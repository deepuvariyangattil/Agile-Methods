package com.formatgedcom;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;



public class PersonBeforeDeathScenario {

	public static FormatGEDCOM formatGEDCOM = new FormatGEDCOM();
	ErrorMessages error = new ErrorMessages();

	PersonBeforeDeathScenario() {
		formatGEDCOM.GedcomTable();

	}
	
	//ID,NAME,GENDER,BIRTHDAY,AGE,ALIVE,DEATH,CHILD,SPOUSE
	public boolean checkBirthBeforeDeath(HashMap<String, String[]> Indi , HashMap<String, String[]> familyMap) throws ParseException{
		boolean result = false;
		String [] indiValues = new String[100];
		Date birthDate,deathDate;
		for (String s : Indi.keySet()) {
			indiValues = Indi.get(s);
			try {
				if (!(indiValues[3].equalsIgnoreCase("NA"))) {
					birthDate = formatGEDCOM.StringtoDate(indiValues[3]); //check if birthdate is coming.
					deathDate = formatGEDCOM.StringtoDate(indiValues[6]); // check if death date is coming

					if (birthDate.after(deathDate)) {
						return error.IndividualTableErrorMessages("birthdate is after death Date",indiValues[0] , "US03" );
					}
				}

			}
			catch(Exception e){
				e.printStackTrace();
			}
		
	}
		return result;
	}
	/*
	familyValues = new String[]{marriageDate, divorseDate, husbandID, husbandName, wifeID, wifeName, childID};*/
	
	public boolean checkMarriageBeforeDivorse(HashMap<String, String[]> Indi , HashMap<String, String[]> familyMap){
		boolean result = false;
		Date marriageDate , divorseDate;
		String [] familyValues = new String[100]; 
		for(String s : familyMap.keySet()){
			familyValues = familyMap.get(s);
			try {
				if (!(familyValues[0].equalsIgnoreCase("NA"))&&!(familyValues[1].equalsIgnoreCase("NA"))) {
					marriageDate = formatGEDCOM.StringtoDate(familyValues[0]);
					divorseDate = formatGEDCOM.StringtoDate(familyValues[1]);

					if (marriageDate.after(divorseDate)) {
						return error.IndividualTableErrorMessages("marriage date is after Death Date",s, "US04" );
					}
				}

			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			
		}
		
	return result;	
	}
	
	
	
	
	

}
