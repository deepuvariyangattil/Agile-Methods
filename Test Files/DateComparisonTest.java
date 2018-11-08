import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class DateComparisonTest {

	@Test
	public void testFailBirthOfParentsWithChildBirthScenario() {
		DateComparison obj = new DateComparison();
		HashMap<String, String[]> Family = new HashMap<>(100);

		HashMap<String, String[]> Individual = new HashMap<>(100);
		String[] familyValue = { "08-07-2018", "NA", "I1", "Sarah/Joe/", "I2", "Antony/Thomas/", "I20" };

		String[] indivalue = { "I20", "Antony/Thomas/", "M", "02-05-2017", "33", "True", "02-05-2020", "F2", "F1" };
		Family.put("F6", familyValue);

		Individual.put("I1", indivalue);
		try {
			Assert.assertFalse(obj.BirthOfParentsWithChildBirthScenario_US08(Individual, Family));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	@Test
	public void testPassBirthOfParentsWithChildBirthScenario() {
		DateComparison obj = new DateComparison();
		HashMap<String, String[]> Family = new HashMap<>(100);

		HashMap<String, String[]> Individual = new HashMap<>(100);
		String[] familyValue = { "08-07-2018", "NA", "I1", "Sarah/Joe/", "I2", "Antony/Thomas/", "I20" };

		String[] indivalue = { "I20", "Antony/Thomas/", "M", "02-05-2019", "33", "True", "02-05-2020", "F2", "F1" };
		Family.put("F6", familyValue);

		Individual.put("I1", indivalue);
		try {
			Assert.assertFalse(obj.BirthOfParentsWithChildBirthScenario_US08(Individual, Family));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	

	@Test
	public void testFailDeathOfParentsWithChildBirthScenario() {
		DateComparison obj = new DateComparison();
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
			Assert.assertFalse(obj.DeathOfParentsWithChildBirthScenario_US09(Individual, Family));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	@Test
	public void testPassDeathOfParentsWithChildBirthScenario() {
		DateComparison obj = new DateComparison();
		HashMap<String, String[]> Family = new HashMap<>(100);

		HashMap<String, String[]> Individual = new HashMap<>(100);
		Family.clear();
		Individual.clear();
		String[] familyValue = { "08-07-2018", "NA", "I1", "Antony/Thomas/", "I2", "Geena/Thomas/", "I3" };
		// NAME,GENDER,BIRTHDAY,AGE,ALIVE,DEATH,CHILD,SPOUSE
		String[] indivalue = { "Geena/Thomas/", "F", "02-05-2000", "33", "false", "02-05-2018", "", "F6" };
		String[] indivalue2 = { "Antony/Thomas/", "M", "02-05-2000", "33", "false", "02-05-2018", "", "F6" };
		String[] indivalue3 = { "Sameer/Thomas/", "M", "02-05-2021", "33", "false", "02-05-2020", "F6", "" };
		Family.put("F6", familyValue);

		Individual.put("I2", indivalue);
		Individual.put("I1", indivalue2);
		Individual.put("I3", indivalue3);

		try {
		    boolean out=obj.DeathOfParentsWithChildBirthScenario_US09(Individual, Family);
			Assert.assertTrue(out);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Family.clear();
		Individual.clear();
		 indivalue = new String[]{"Geena/Thomas/", "F", "02-05-2000", "33", "false", "02-05-2018", "F2", "F1"};
		 indivalue2 =new String[] { "Antony/Thomas/", "M", "02-05-2000", "33", "false", "02-05-2017", "F7", "F1" };
		 indivalue3 =new String[] { "Sameer/Thomas/", "M", "02-05-2002", "33", "false", "02-05-2020", "F7", "F1" };
		familyValue =new String[] { "08-07-2018", "NA", "I5", "Sarah/Joe/", "I6", "Antony/Thomas/", "I7" };

		Family.put("F2", familyValue);

		Individual.put("I5", indivalue);
		Individual.put("I6", indivalue2);
		Individual.put("I7", indivalue3);
		try {
			Assert.assertFalse(obj.DeathOfParentsWithChildBirthScenario_US09(Individual, Family));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Family.clear();
		Individual.clear();
		indivalue = new String[]{"Geena/Thomas/", "F", "02-05-2000", "33", "false", "02-05-2018", "F2", "F1"};
		indivalue2 =new String[] { "Antony/Thomas/", "M", "02-05-2000", "33", "false", "02-09-2002", "F7", "F1" };
		indivalue3 =new String[] { "Sameer/Thomas/", "M", "02-05-2003", "33", "false", "02-05-2020", "F7", "F1" };
		familyValue =new String[] { "08-07-2018", "NA", "I5", "Sarah/Joe/", "I6", "Antony/Thomas/", "I7" };

		Family.put("F2", familyValue);

		Individual.put("I6", indivalue);
		Individual.put("I5", indivalue2);
		Individual.put("I7", indivalue3);
		try {
			Assert.assertFalse(obj.DeathOfParentsWithChildBirthScenario_US09(Individual, Family));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	

}
