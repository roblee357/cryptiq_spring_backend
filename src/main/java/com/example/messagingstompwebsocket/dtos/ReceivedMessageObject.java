package com.example.messagingstompwebsocket.dtos;

public class ReceivedMessageObject {
	String encryptedContent;
	String id;
	String sentFrom;
	String sentTo;
	String signature;
	public String getEncryptedContent() {
		return encryptedContent;
	}
	public void setEncryptedContent(String encryptedContent) {
		this.encryptedContent = encryptedContent;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSentFrom() {
		return sentFrom;
	}
	public void setSentFrom(String sentFrom) {
		this.sentFrom = sentFrom;
	}
	public String getSentTo() {
		return sentTo;
	}
	public void setSentTo(String sentTo) {
		this.sentTo = sentTo;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	@Override
	public String toString() {
		return "ReceivedMessageObject [encryptedContent=" + encryptedContent + ", id=" + id + ", sentFrom=" + sentFrom
				+ ", sentTo=" + sentTo + ", signature=" + signature + "]";
	}
	
	
	
}
/*
{"encryptedContent": "LawMDGRjCo/c6SQdpTIbetn3PVMp4jrviT4wuXwgFwM7LLAp6wxP6awd7Ss78yNWjPeRYkEvikLE
soEnNvFrAjoGdH1CAcL1yGU7fvTXApy2LJ7zkig+nBkt20GXy7cRVFZr20zhGH/zbbYp+oRbWFc9
qWZvIYm2xmVEixW4JgDIgHN8eV1xNhNMKpulzV5WgDoK1OIPTSQyj10uESkaCZh2HmYL3s5MxZ+D
Oyj2EeZCV+D/WmuuDUPmSmm5NQLVQne7G4ge1tPEXG4J7mfqFYNs8Qc4xgkFPjbRfwMlPpsByrsl
36DsNktVQ0d2IcZl5gp31Ui2ez0Lh04nPKY2Mg==
", "id": "4c4c95de-ad67-497f-8a93-8614772a7d19", "sentFrom": "555a14c0-4320-45b7-842c-e5ba26f5dbff","
		+ " "sentTo": undefined, "signature": "fi3o+nbAxvlmkf9o5wb5CY88kAgbwiFXFM9UbTFWA+J0n7kYuAEkFie9TjREm4Gfg/FG6l9HkPX8
pY/+Ayt1LAaaeCMvL4imu4Gmr4vh+BBG8qWXFmWhQlxhdL+65sDTScPcEM6jJ7dEiym82CTrlv6P
j05O/uOaEfBBvRwXh2hQC2Fdk6c4MIBEIYeBqSQEGjhdV+vEzvXpWFF7H02/OHUL9LyvHmaeseTc
QZ3YlAReZUrkVYOyHcFPgviz/HlTune2HdnSL7ZM8xvmnHcpQ0GYo1d+DcOdq3tXjTF6wa42RzQB
a61B8jtUZyEXWAfyhTa6eRNY1tyuQQhT++KnFA==
"}
*/