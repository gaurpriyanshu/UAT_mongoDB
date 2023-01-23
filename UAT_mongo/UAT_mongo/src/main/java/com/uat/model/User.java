package com.uat.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

import org.bson.types.ObjectId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection = "subscription")
public class User {
	@Id
	private ObjectId _id; //
	private String shopId;
	private double amount;
	private double gst;
	private Date startDate;
	private Date endDate;
	private String userId;
	private String phone;
	private String userType;
	private String segmentId;
	private String flyUserId;
	private String orderId;
	private String paymentId;
	private boolean paid;
	private String gstin;
	private String _class;//
	
}
