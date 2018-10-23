package com.formatgedcom;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class PersonBeforeDeathScenarioTest {

	@Test
	public void testBirthBeforeDeath() {
		PersonBeforeDeathScenario obj = new PersonBeforeDeathScenario();
		HashMap<String, String[]> Family = new HashMap<>(100);

		HashMap<String, String[]> Individual = new HashMap<>(100);
		String[] familyValue = { "08-07-2018", "NA", "I1", "Sarah/Joe/", "I2", "Antony/Thomas/", "I14" };

		String[] indivalue = { "I20", "Antony/Thomas/", "M", "02-05-2021", "33", "True", "02-05-2020", "F2", "F1" };
		Family.put("F6", familyValue);

		Individual.put("I1", indivalue);
		try {
			Assert.assertTrue(obj.checkBirthBeforeDeath(Individual, Family));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testMarriageBeforeDivorse() {
		PersonBeforeDeathScenario obj = new PersonBeforeDeathScenario();
		HashMap<String, String[]> Family = new HashMap<>(100);

		HashMap<String, String[]> Individual = new HashMap<>(100);
		String[] familyValue = { "08-07-2018", "02-05-2017", "I1", "Sarah/Joe/", "I2", "Antony/Thomas/", "I14" };
		String[] indivalue = { "I20", "Antony/Thomas/", "M", "02-05-2021", "33", "True", "02-05-2020", "F2", "F1" };
		Family.put("F6", familyValue);

		Individual.put("I1", indivalue);

		try {
			Assert.assertTrue(obj.checkMarriageBeforeDivorse(Individual, Family));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
