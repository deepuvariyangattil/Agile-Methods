package com.formatgedcom;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class BirthAndDeathParentsScenarioTest {

	@Test
	public void testFailBirthOfParentsWithChildBirthScenario() {
		BirthAndDeathParentsScenario obj = new BirthAndDeathParentsScenario();
		HashMap<String, String[]> Family = new HashMap<>(100);

		HashMap<String, String[]> Individual = new HashMap<>(100);
		String[] familyValue = { "08-07-2018", "NA", "I1", "Sarah/Joe/", "I2", "Antony/Thomas/", "I20" };

		String[] indivalue = { "I20", "Antony/Thomas/", "M", "02-05-2017", "33", "True", "02-05-2020", "F2", "F1" };
		Family.put("F6", familyValue);

		Individual.put("I1", indivalue);
		try {
			Assert.assertFalse(obj.BirthOfParentsWithChildBirthScenario(Individual, Family));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	@Test
	public void testPassBirthOfParentsWithChildBirthScenario() {
		BirthAndDeathParentsScenario obj = new BirthAndDeathParentsScenario();
		HashMap<String, String[]> Family = new HashMap<>(100);

		HashMap<String, String[]> Individual = new HashMap<>(100);
		String[] familyValue = { "08-07-2018", "NA", "I1", "Sarah/Joe/", "I2", "Antony/Thomas/", "I20" };

		String[] indivalue = { "I20", "Antony/Thomas/", "M", "02-05-2019", "33", "True", "02-05-2020", "F2", "F1" };
		Family.put("F6", familyValue);

		Individual.put("I1", indivalue);
		try {
			Assert.assertFalse(obj.BirthOfParentsWithChildBirthScenario(Individual, Family));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	

	@Test
	public void testFailDeathOfParentsWithChildBirthScenario() {
		BirthAndDeathParentsScenario obj = new BirthAndDeathParentsScenario();
		HashMap<String, String[]> Family = new HashMap<>(100);

		HashMap<String, String[]> Individual = new HashMap<>(100);
		String[] familyValue = { "08-07-2018", "NA", "I1", "Sarah/Joe/", "I2", "Antony/Thomas/", "I20" };
		// NAME,GENDER,BIRTHDAY,AGE,ALIVE,DEATH,CHILD,SPOUSE
		String[] indivalue = { "Antony/Thomas/", "F", "02-05-2017", "33", "false", "02-05-2020", "F2", "I1" };
		String[] indivalue2 = { "Antony/Thomas/", "M", "02-05-2018", "33", "false", "02-05-2020", "F7", "F1" };
		Family.put("F6", familyValue);

		Individual.put("I1", indivalue);
		Individual.put("F2", indivalue2);
		try {
			Assert.assertFalse(obj.DeathOfParentsWithChildBirthScenario(Individual, Family));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	@Test
	public void testPassDeathOfParentsWithChildBirthScenario() {
		BirthAndDeathParentsScenario obj = new BirthAndDeathParentsScenario();
		HashMap<String, String[]> Family = new HashMap<>(100);

		HashMap<String, String[]> Individual = new HashMap<>(100);
		String[] familyValue = { "08-07-2018", "NA", "I1", "Sarah/Joe/", "I2", "Antony/Thomas/", "I20" };
		// NAME,GENDER,BIRTHDAY,AGE,ALIVE,DEATH,CHILD,SPOUSE
		String[] indivalue = { "Antony/Thomas/", "F", "02-05-2017", "33", "false", "02-05-2020", "F2", "I1" };
		String[] indivalue2 = { "Antony/Thomas/", "M", "02-05-2021", "33", "false", "02-05-2020", "F7", "F1" };
		Family.put("F6", familyValue);

		Individual.put("I1", indivalue);
		Individual.put("F2", indivalue2);
		try {
			Assert.assertTrue(obj.DeathOfParentsWithChildBirthScenario(Individual, Family));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
	

}
