package com.example.messagingstompwebsocket.dtos;

public class CrypticUser {

	private String email;
	private String firstName;
	private String id;
	private String key;
	private String lastName;
	private int messageCount;
	private String middleName;
	private String mostRecentInteraction;
	private String phone;
	private String publicKey;
	private String unreadMessageCount;
	private String username;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getMessageCount() {
		return messageCount;
	}
	public void setMessageCount(int messageCount) {
		this.messageCount = messageCount;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getMostRecentInteraction() {
		return mostRecentInteraction;
	}
	public void setMostRecentInteraction(String mostRecentInteraction) {
		this.mostRecentInteraction = mostRecentInteraction;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPublicKey() {
		return publicKey;
	}
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}
	public String getUnreadMessageCount() {
		return unreadMessageCount;
	}
	public void setUnreadMessageCount(String unreadMessageCount) {
		this.unreadMessageCount = unreadMessageCount;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "CrypticUser [email=" + email + ", firstName=" + firstName + ", id=" + id + ", lastName=" + lastName
				+ ", middleName=" + middleName + ", phone=" + phone + ", username=" + username + "]";
	}
	
	
	
}
