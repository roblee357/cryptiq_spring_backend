package com.example.messagingstompwebsocket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.messagingstompwebsocket.model.PushNotificationRequest;
import com.example.messagingstompwebsocket.model.PushNotificationResponse;
import com.example.messagingstompwebsocket.repositories.MessageRepository;
import com.example.messagingstompwebsocket.service.PushNotificationService;

@RestController
public class PushNotificationController {
	private Logger logger = LoggerFactory.getLogger(PushNotificationController.class);
    private PushNotificationService pushNotificationService;
    @Autowired 
    private MessageRepository messageRepository;
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
        pushNotificationService.sendPushNotificationToToken(request);
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }
    @PostMapping("/notification/data")
    public ResponseEntity sendDataNotification(@RequestBody PushNotificationRequest request) {
        pushNotificationService.sendPushNotification(request);
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }   
//    http://localhost:8080/api/v1/sendTestNotification
    @PostMapping("/api/v1/sendTestNotification")
    public ResponseEntity sendTestNotification(@RequestBody PushNotificationRequest request) {
    	request.setToken(token);
    	messageRepository.save(request.convertToMessage());
		logger.info(request.getMessage());
        pushNotificationService.sendPushNotificationToToken(request);
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }       
}