package com.fitnesshouse.api.documents;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fitnesshouse.api.enums.MessageTypesEnum;

@Document
public class News {

	@Id
	private String id;

	private String from;
	private String txtMessage;
	private Date date;
	private MessageTypesEnum messageTypes;

	public News() {
		super();
	}

	public News(String id, String from, String txtMessage, Date date, MessageTypesEnum messageTypes) {
		super();
		this.id = id;
		this.from = from;
		this.txtMessage = txtMessage;
		this.date = date;
		this.messageTypes = messageTypes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTxtMessage() {
		return txtMessage;
	}

	public void setTxtMessage(String txtMessage) {
		this.txtMessage = txtMessage;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public MessageTypesEnum getMessageTypes() {
		return messageTypes;
	}

	public void setMessageTypes(MessageTypesEnum messageTypes) {
		this.messageTypes = messageTypes;
	}

}
