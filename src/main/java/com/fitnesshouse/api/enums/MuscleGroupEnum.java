package com.fitnesshouse.api.enums;

public enum MuscleGroupEnum {
	ABS("Abdominais"),
    AEROBIC("Aeróbico"),
    ARMS("Braços"),
    BACKS("Costas"),
    CHEST("Peito"),
    LEGS("Pernas"),
    SHOULDERS("Ombros"),
    STRETCHING("Alongamento");
	
    private String name;
 
    MuscleGroupEnum(String name) {
        this.name = name;
    }
 
    public String getName() {
        return name;
    }	
}