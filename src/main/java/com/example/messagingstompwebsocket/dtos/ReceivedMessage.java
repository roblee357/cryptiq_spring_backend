package com.example.messagingstompwebsocket.dtos;

import com.example.messagingstompwebsocket.model.Message;
import com.example.messagingstompwebsocket.model.PushNotificationRequest;

public class ReceivedMessage {
	
	String sendingDevice;
	String receivingDevice;
	ReceivedMessageObject message;
	
	public String getSendingDevice() {
		return sendingDevice;
	}
	public void setSendingDevice(String sendingDevice) {
		this.sendingDevice = sendingDevice;
	}
	public ReceivedMessageObject getMessage() {
		return message;
	}
	public void setMessage(ReceivedMessageObject message) {
		this.message = message;
	}
	
	
	public String getReceivingDevice() {
		return receivingDevice;
	}
	public void setReceivingDevice(String receivingDevice) {
		this.receivingDevice = receivingDevice;
	}
	public Message convertToMessage() {
		Message message= new Message();
		message.setMessage(this.message.getEncryptedContent());
		message.setToken(this.receivingDevice);
		message.setTopic(this.message.sentFrom);
		message.setUID(this.message.sentTo);
		
		return message;
	}
	public PushNotificationRequest convertToPushNotificationRequest() {
		PushNotificationRequest req = new PushNotificationRequest();
		req.setTitle(this.sendingDevice);
		req.setMessage(message.getEncryptedContent());
		req.setToken(getReceivingDevice());
		req.setTopic("");
		req.setUID(this.message.sentTo);
		return req;
	}

}
