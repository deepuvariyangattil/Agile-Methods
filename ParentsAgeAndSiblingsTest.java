package com.formatgedcom;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class ParentsAgeAndSiblingsTest {
	ParentsAgeAndSiblings obj = new ParentsAgeAndSiblings();
	
	@Test
	public void testPassCheckParentsAgeDifference() throws ParseException {
		HashMap<String, String[]> Family = new HashMap<String, String[]>(100);

		HashMap<String, String[]> Individual = new HashMap<String, String[]>(100);

		// Initializing family and individual map with age less than 14

		String[] familyValue = { "08-07-2018", "NA", "I1", "Antony/Thomas/", "I2", "Sarah/Joe/", "I14" };

		String[] indivalue = { "Antony/Thomas/", "M", "02-05-1973", "55", "True", "NA", "F2", "F1"}; //ID I1

		String[] indivalue2 = { "Sarah/Joe/", "F", "02-05-1975", "53", "True", "NA", "F2", "F1"}; //ID I2
		
		String[] indivalue3 = {"Maissie/Joe/", "F", "02-05-1975", "10", "True", "NA", "F2", "F1"}; //ID I14
		
		Family.put("F1", familyValue);
		Individual.put("I1", indivalue);
		Individual.put("I2", indivalue2);
		Individual.put("I14", indivalue3);
		
		Assert.assertTrue(obj.checkParentsAgeDifference(Individual, Family));
	}
	@Test
	public void testFailCheckParentsAgeDifference() throws ParseException {
		HashMap<String, String[]> Family = new HashMap<String, String[]>(100);

		HashMap<String, String[]> Individual = new HashMap<String, String[]>(100);

		// Initializing family and individual map with age less than 14

		String[] familyValue = { "08-07-2018", "NA", "I1", "Antony/Thomas/", "I2", "Sarah/Joe/", "I14" };

		String[] indivalue = { "Antony/Thomas/", "M", "02-05-1973", "55", "True", "NA", "F2", "F1"}; //ID I1

		String[] indivalue2 = { "Sarah/Joe/", "F", "02-05-1975", "53", "True", "NA", "F2", "F1"}; //ID I2
		
		String[] indivalue3 = {"Maissie/Joe/", "F", "02-05-1975", "40", "True", "NA", "F2", "F1"}; //ID I14
		
		Family.put("F1", familyValue);
		Individual.put("I1", indivalue);
		Individual.put("I2", indivalue2);
		Individual.put("I14", indivalue3);
		
		Assert.assertFalse(obj.checkParentsAgeDifference(Individual, Family));
	}

	@Test
	public void testPassLessSiblings() {
		
		HashMap<String, String[]> Family = new HashMap<String, String[]>(100);

		HashMap<String, String[]> Individual = new HashMap<String, String[]>(100);

		// Initializing family and individual map with age less than 14

		String[] familyValue = { "08-07-2018", "NA", "I1", "Antony/Thomas/", "I2", "Sarah/Joe/", "I14 I15 I16" };

		String[] indivalue = { "Antony/Thomas/", "M", "02-05-1973", "55", "True", "NA", "F2", "F1"}; //ID I1

		String[] indivalue2 = { "Sarah/Joe/", "F", "02-05-1975", "53", "True", "NA", "F2", "F1"}; //ID I2
		
		String[] indivalue3 = {"Maissie/Joe/", "F", "02-05-1975", "40", "True", "NA", "F2", "F1"}; //ID I14
		
		String[] indivalue4 = {"Maissie/Joe/", "F", "02-05-1975", "40", "True", "NA", "F2", "F1"}; //ID I15
		
		String[] indivalue5 = {"Maissie/Joe/", "F", "02-05-1975", "40", "True", "NA", "F2", "F1"}; //ID I16
		
		Family.put("F1", familyValue);
		Individual.put("I1", indivalue);
		Individual.put("I2", indivalue2);
		Individual.put("I14", indivalue3);
		Individual.put("I15", indivalue4);
		Individual.put("I16", indivalue5);
		
		Assert.assertTrue(obj.LessSiblings(Individual, Family));
		
		
	}
	@Test
	public void testFailLessSiblings() {
		
		HashMap<String, String[]> Family = new HashMap<String, String[]>(100);

		HashMap<String, String[]> Individual = new HashMap<String, String[]>(100);

		// Initializing family and individual map with age less than 14

		String[] familyValue = { "08-07-2018", "NA", "I1", "Antony/Thomas/", "I2", "Sarah/Joe/", "I14" };

		String[] indivalue = { "Antony/Thomas/", "M", "02-05-1973", "55", "True", "NA", "F2", "F1"}; //ID I1

		String[] indivalue2 = { "Sarah/Joe/", "F", "02-05-1975", "53", "True", "NA", "F2", "F1"}; //ID I2
		
		String[] indivalue3 = {"Maissie/Joe/", "F", "02-05-1975", "40", "True", "NA", "F2", "F1"}; //ID I14
		
		
		Family.put("F1", familyValue);
		Individual.put("I1", indivalue);
		Individual.put("I2", indivalue2);
		Individual.put("I14", indivalue3);
	
		
		Assert.assertFalse(obj.LessSiblings(Individual, Family));
		
		
	}
	

}
