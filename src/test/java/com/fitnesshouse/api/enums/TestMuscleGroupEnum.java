package com.fitnesshouse.api.enums;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMuscleGroupEnum {

	@Test
	public void testFindMuscleGroupByEnumWithCorrectName() {
		assertEquals(MuscleGroupEnum.ABS, MuscleGroupEnum.findMuscleGroupByEnum("ABS"));
	}

	@Test
	public void testFindMuscleGroupByEnumWithIncorrectName() {
		assertEquals(MuscleGroupEnum.FULLBODY, MuscleGroupEnum.findMuscleGroupByEnum("ZXY"));
	}
	
	@Test
	public void testFindMuscleGroupByEnumWithNullName() {
		assertEquals(MuscleGroupEnum.FULLBODY, MuscleGroupEnum.findMuscleGroupByEnum(null));
	}
	
	@Test
	public void testIsValidWithCorrectName() {
		assertTrue(MuscleGroupEnum.isValid("ABS"));
	}

	@Test
	public void testIsValidWithIncorrectName() {
		assertFalse(MuscleGroupEnum.isValid("ZXY"));
	}
	
	@Test
	public void testIsValidWithNullName() {
		assertFalse(MuscleGroupEnum.isValid(null));
	}
}
