package com.fitnesshouse.api.enums;

public enum WorkoutIdentifierEnum {
	ABS("Abdominais"),
    AEROBIC("Aeróbico"),
    ARMS("Braços"),
    BACKS("Costas"),
    CHEST("Peito"),
    LEGS("Pernas"),
    SHOULDERS("Ombros"),
    STRETCHING("Alongamento");
	
    private String name;
 
    WorkoutIdentifierEnum(String name) {
        this.name = name;
    }
 
    public String getName() {
        return name;
    }	
}