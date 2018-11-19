

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;



public class PersonBeforeDeathScenario {

	public static FormatGEDCOM formatGEDCOM = new FormatGEDCOM();
	ErrorMessages error = new ErrorMessages();
	IssueLine issueLine=new IssueLine();

	PersonBeforeDeathScenario() {
		formatGEDCOM.GedcomTable();

	}
	
	//ID,NAME,GENDER,BIRTHDAY,AGE,ALIVE,DEATH,CHILD,SPOUSE
	public boolean checkBirthBeforeDeath(HashMap<String, String[]> Indi ) throws ParseException{
		boolean result = false;
		String [] indiValues = new String[100];
		Date birthDate,deathDate;
		for (String s : Indi.keySet()) {
			indiValues = Indi.get(s);
			try {
				if (!(indiValues[2].equalsIgnoreCase("NA"))&&!(indiValues[5].equalsIgnoreCase("NA"))) {
					birthDate = formatGEDCOM.StringtoDate(indiValues[2]);
					deathDate = formatGEDCOM.StringtoDate(indiValues[5]); // check if death date is coming
					if (birthDate.after(deathDate)) {
						int errorline=issueLine.GetLineNumber_Individual(s,indiValues[2]);
						return error.IndividualTableErrorMessages("birthdate is after death Date", s, "UserStory03",errorline);
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
						int errorline=issueLine.GetLineNumber_Family(s,familyValues[0]);
						return error.FamilyTableErrorMessages("marriage date is after Divorce Date",s, "UserStory04",errorline );
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
