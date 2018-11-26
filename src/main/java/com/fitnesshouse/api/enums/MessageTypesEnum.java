package com.fitnesshouse.api.enums;

public enum MessageTypesEnum {
	
	MESSAGE(" mandou uma mensagem"), 
	SYSTEM(" teve uma atualização"), 
	RETURN(" respondeu seu feedback"),
	REQUEST(" solicitacao professor");
	
	private String suffix;

	MessageTypesEnum(String suffix) {
		this.suffix = suffix;
	}

	public String getSuffix() {
		return suffix;
	}
}
