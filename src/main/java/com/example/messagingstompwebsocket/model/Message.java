package com.example.messagingstompwebsocket.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity //(name="UserTable") // This tells Hibernate to make a table out of this class
public class Message {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String topic;
	private String message;
	private String token;
	private String UID;
	private String username;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDate message_creation_date;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDate message_sent_at_date;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public LocalDate getMessage_creation_date() {
		return message_creation_date;
	}
	public void setMessage_creation_date(LocalDate message_creation_date) {
		this.message_creation_date = message_creation_date;
	}
	public LocalDate getMessage_sent_at_date() {
		return message_sent_at_date;
	}
	public void setMessage_sent_at_date(LocalDate message_sent_at_date) {
		this.message_sent_at_date = message_sent_at_date;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}

	
	
	
	
}
//Back end Message to device
//Device token
//Sender UID
//Sender Username
//Encrypted Message content
//Meta data: Created date, sent at date