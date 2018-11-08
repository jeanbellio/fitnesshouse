package com.fitnesshouse.api.enums;

public enum MuscleGroupEnum {
	
	FULLBODY("Corpo todo"),
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
    
    public static MuscleGroupEnum findMuscleGroupByEnum(String enumName) {
    	for (MuscleGroupEnum muscleGroup : values()) {
			if(muscleGroup.name().equals(enumName)) {
				return muscleGroup;
			}
		}
    	return MuscleGroupEnum.FULLBODY;
    }
    
    public static boolean isValid(String enumName) {
    	for (MuscleGroupEnum muscleGroup : values()) {
			if(muscleGroup.name().equals(enumName)) {
				return true;
			}
		}
    	return false;
    }
}