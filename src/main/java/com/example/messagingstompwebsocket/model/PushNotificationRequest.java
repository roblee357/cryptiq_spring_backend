package com.example.messagingstompwebsocket.model;

public class PushNotificationRequest {
    private String title;
    private String message;
    private String topic;
    private String token;
    private String UID;
    private String signature;
    
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}  
    
	public String getUID() {
		return UID;
	}
	public void setUID(String uID) {
		UID = uID;
	}
	
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	public Message convertToMessage() {
		Message message= new Message();
		message.setMessage(this.message);
		message.setToken(this.token);
		message.setTopic(this.topic);
		message.setUID(this.UID);
		
		return message;
	}
}