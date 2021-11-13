package com.example.messagingstompwebsocket.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.messagingstompwebsocket.dtos.CrypticDTO;
import com.example.messagingstompwebsocket.dtos.CrypticUser;
import com.example.messagingstompwebsocket.dtos.LoggedInUserRequest;
import com.example.messagingstompwebsocket.dtos.ReceivedMessage;
import com.example.messagingstompwebsocket.model.PushNotificationRequest;
import com.example.messagingstompwebsocket.model.PushNotificationResponse;
import com.example.messagingstompwebsocket.repositories.MessageRepository;
import com.example.messagingstompwebsocket.service.PushNotificationService;
import com.example.messagingstompwebsocket.utils.LoggedInUsersMap;
import com.google.gson.Gson;

@RestController
public class PushNotificationController {
	private Logger logger = LoggerFactory.getLogger(PushNotificationController.class);
    private PushNotificationService pushNotificationService;
    @Autowired 
    private MessageRepository messageRepository;
    @Autowired
    private LoggedInUsersMap userMap;
    private Gson gson = new Gson();;
    private int keyCounter = 1;
//    String token = "eqvUCUsHQhmunV9y1vRMy2:APA91bFTdgnRWohTTaHFQHBXKb_Rkum64Zbk5wrnsUhOysnBbOfE28U--nYtpmkqFjt1QIIPYFur-uoaSuIejjoJDuPL_duW6szQCXsq9kRg29ps6AQLxoUVOKxwRx7KjIePNQhYPzw3";
    String token = "dvW1-dp7SzmxaeKZ_bUYjc:APA91bHQDFp54bMGgOJx-dwdlmB1avO7KtGY1FMJtXiQl7PvJvuUNk0hvejAej48cG3aqbjixsrYlWlH2ka4A9U9y6mLzeJ3fhR7vgftid3nqo3kpYnJqISZ1Hw2c86TYVmCpAQbOhxi";
    public PushNotificationController(PushNotificationService pushNotificationService) {
        this.pushNotificationService = pushNotificationService;
    }
    @PostMapping("/notification/topic")
    public ResponseEntity sendNotification(@RequestBody PushNotificationRequest request) {
        pushNotificationService.sendPushNotificationWithoutData(request);
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }
    @PostMapping("/notification/token")
    public ResponseEntity sendTokenNotification(@RequestBody PushNotificationRequest request) {
    	try {
    		pushNotificationService.sendPushNotificationToToken(request);
    	}
        catch(Exception e) {
        	e.printStackTrace();
        }
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }
    @PostMapping("/notification/data")
    public ResponseEntity sendDataNotification(@RequestBody PushNotificationRequest request) {
        pushNotificationService.sendPushNotification(request);
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }   
//    http://localhost:8080/api/v1/sendTestNotification
    @PostMapping("/api/v1/sendTestNotification")
    public ResponseEntity sendTestNotification(@RequestBody ReceivedMessage request) {
    	
    	// Fetch the recievin user's token from the map
    	String receivingDeviceToken = searchForRecipientToken(request);
    	//updateId(request);
    	request.setReceivingDevice(receivingDeviceToken);
    	messageRepository.save(request.convertToMessage());
		logger.info(request.getMessage().toString());
        pushNotificationService.sendPushNotificationToToken(request.convertToPushNotificationRequest());
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }  
    
    @PostMapping("/api/v1/findUser")
    public String findCrypticUserByToken(@RequestBody LoggedInUserRequest token) {
    	System.out.println("Token received in findCrypticUserByToken "+ token.getToken());
    	CrypticUser user = null; 
    	for(String t : userMap.getUsers().keySet()) {
    		System.out.println("Checking against " + t);
    		if(t.contentEquals(token.getToken())) {	
    			user = userMap.getUsers().get(t);
    			break;
    		}
    	}
    	String jsonString = gson.toJson(user);
    	System.out.println("User beeing returned " + jsonString);
    	return jsonString;
    }
    
    private void updateId(ReceivedMessage request) {
    	
			CrypticUser cu = userMap.getUsers().get(request.getSendingDevice());
			if(cu != null) {
				System.out.println("user found... updating id");
				cu.setId(request.getMessage().getSentFrom());
				userMap.getUsers().put(request.getSendingDevice(), cu);
			}
		
			System.out.println("Updated user " + userMap.getUsers().get(request.getSendingDevice()));
    }
    
    private String searchForRecipientToken(ReceivedMessage request) {
		String found = "";
		for(Map.Entry<String, CrypticUser> entry : userMap.getUsers().entrySet()) {
			if(request.getMessage().getSentTo().contentEquals(entry.getValue().getId())) {
				System.out.println("Found receiver details");
				found = entry.getKey();
				
				break;
			}
		}
		
		return found;
	}
	@PostMapping("/api/v1/registerDevice")
    public ResponseEntity registerDevice(@RequestBody CrypticDTO device) {
    	// put into a Map
		device.getUser().setKey("" + keyCounter++);
    	System.out.println("Received registtration from " + device);
    	System.out.println("User: " + device.getUser());
    	userMap.getUsers().put(device.getToken(), device.getUser());
    	 return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Device has been registered."), HttpStatus.OK);
    }
    
    @PostMapping("/api/v1/loadLoggedInUsers")
    public String loadUsers(@RequestBody LoggedInUserRequest token) {
    	System.out.println("Token received in LogggedInsuers "+ token.getToken());
    	List<CrypticUser> users = new ArrayList<>(); 
    	for(String t : userMap.getUsers().keySet()) {
    		System.out.println("Checking against " + t);
    		if(!t.contentEquals(token.getToken())) {
    			
    			users.add(userMap.getUsers().get(t));
    		}
    	}
    	String jsonString = gson.toJson(users);
    	System.out.println(jsonString);
    	return jsonString;

    }
    
    @PostMapping("/api/v1/logoutUser")
    public ResponseEntity logoutUser(@RequestBody LoggedInUserRequest token) {
    	System.out.println("Token received in logoutUser "+ token.getToken());
    	
    	userMap.getUsers().remove(token.getToken());
    	return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), 
    			"Device has been removed."), HttpStatus.OK);
    	  
    }
}