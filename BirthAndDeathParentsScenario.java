package com.formatgedcom;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

public class BirthAndDeathParentsScenario {

	ErrorMessages error = new ErrorMessages();
	// child born before death of mother && father death before 9 months.
	public boolean DeathOfParentsWithChildBirthScenario(HashMap<String, String[]> individualMap, HashMap<String, String[]> FamilyMap) throws ParseException{
		boolean result = false;
		FormatGEDCOM obj = new FormatGEDCOM();
		obj.GedcomTable();
		

		String keyi[] = new String[100];
		String valuei[] = new String[100];

		keyi = individualMap.keySet().toArray(new String[0]);

		// NAME,GENDER,BIRTHDAY,AGE,ALIVE,DEATH,CHILD,SPOUSE
		// familyValues = new String[]{marriageDate, divorseDate, husbandID,
		// husbandName, wifeID, wifeName, childID}
		for (String indi : keyi) {
			valuei = individualMap.get(indi);
			if(!valuei[5].equals("NA") && valuei[1].equals("F")){ //death of mother scenario
				
			
			Date deathDate = obj.StringtoDate(valuei[5]); //changed to death date
			
			String childID[] = valuei[6].split(" ");
			int l = childID.length - 1; // no. of children
			while (l > 0) {
				if (l % 2 != 0) {

					valuei = individualMap.get(childID[l]);
					Date birthdate = obj.StringtoDate(valuei[2]);
					if (deathDate.before(birthdate) ) { //check divorse date too
						//System.out.println(childID[l] + " Illegal birthdate");
						error.IndividualTableErrorMessages(" Illegal birthdate", childID[l], "US09");
						result = true; 
					}
				}
				l--;
			}
			}
			else if(valuei[1].equals("M")){
				
			}

		}
		
		return result;	
	}

	public boolean BirthOfParentsWithChildBirthScenario(HashMap<String, String[]> individualMap,
			HashMap<String, String[]> FamilyMap) throws ParseException {
		boolean result = false;
		FormatGEDCOM obj = new FormatGEDCOM();
		obj.GedcomTable();
		/*
		 * obj.printTable(); HashMap<String, String[]> individualMap =
		 * obj.getIndividualMap(); HashMap<String, String[]> FamilyMap =
		 * obj.getFamilyMap();
		 */
		String key[] = new String[100];
		String value[] = new String[100];
		String keyi[] = new String[100];
		String valuei[] = new String[100];

		key = FamilyMap.keySet().toArray(new String[0]);
		keyi = individualMap.keySet().toArray(new String[0]);

		// NAME,GENDER,BIRTHDAY,AGE,ALIVE,DEATH,CHILD,SPOUSE
		// familyValues = new String[]{marriageDate, divorseDate, husbandID,
		// husbandName, wifeID, wifeName, childID}
		for (String famvalues : key) {
			value = FamilyMap.get(famvalues);
			if (!value[1].equals("NA")) {

				Date marriageDate = obj.StringtoDate(value[0]); // changed to
																// divorse date

				String childID[] = value[6].split(" ");
				int l = childID.length - 1; // no. of children
				while (l > 0) {
					if (l % 2 != 0) {

						valuei = individualMap.get(childID[l]);
						Date birthdate = obj.StringtoDate(valuei[2]);
						if (marriageDate.before(birthdate)) { // check divorse
																// date too
							//System.out.println(childID[l] + " Illegal birthdate");
							error.FamilyAndIndividualTableErrorMessages(" Illegal birthdate", childID[l], famvalues, "US08");
							result = true;
						}
					}
					l--;
				}
			}

		}
		return result;

	}

	public static void main(String args[]) throws ParseException {
		BirthAndDeathParentsScenario obj = new BirthAndDeathParentsScenario();
		FormatGEDCOM ob = new FormatGEDCOM();
		obj.DeathOfParentsWithChildBirthScenario(ob.getIndividualMap(), ob.getFamilyMap());
		// obj.BirthOfParentsWithChildBirthScenario(ob.getIndividualMap(),ob.getFamilyMap());

	}

}
