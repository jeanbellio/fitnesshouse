package com.fitnesshouse.api.enums;

public enum UserTypeEnum {
	ALUNO("Aluno"),
    ESTAGIARIO("Estagiário"),
    PROFESSOR("Professor");

	private String name;

    UserTypeEnum(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
		return getName();
	}
}
