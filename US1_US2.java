
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

public class US1_US2 {
    IssueLine issueLine=new IssueLine();
    ErrorMessages errorMessages=new ErrorMessages();
    FormatGEDCOM formatGEDCOM = new FormatGEDCOM();

    public boolean checkDatesWithToday(HashMap<String, String[]> familyMap,HashMap<String, String[]> Indi) throws ParseException {
        boolean result=false;
        Date tDate = new Date();
        Date marriedDate, birthDate, divorceDate, deathDate;
        String[] familyValues, indiValues = new String[100];
        for (String s : Indi.keySet()) {
            indiValues = Indi.get(s);
            try {
                if (!(indiValues[2].equalsIgnoreCase("NA"))) {
                    birthDate = formatGEDCOM.StringtoDate(indiValues[2]);

                    if (birthDate.after(tDate)) {
                        String message="Individual is having birth date after today's date";
                        int errorline=issueLine.GetLineNumber_Individual(s,indiValues[2]);
                        errorMessages.IndividualTableErrorMessages(message,s,"UserStory01",errorline);
                        result=true;

                    }
                }if (!(indiValues[5].equalsIgnoreCase("NA"))) {
                    deathDate = formatGEDCOM.StringtoDate(indiValues[5]);
                    if (deathDate.after(tDate)) {
                        String message="Individual is having death date after today's date";
                        int errorline=issueLine.GetLineNumber_Individual(s,indiValues[4]);
                        errorMessages.IndividualTableErrorMessages(message,s,"UserStory01",errorline);
                        result=true;

                    }
                }


            } catch (Exception e) {
                continue;
            }
        }
        for (String t : familyMap.keySet()) {
            familyValues = familyMap.get(t);
            try {
                if (!(familyValues[0].trim().equalsIgnoreCase("NA"))) {
                    marriedDate = formatGEDCOM.StringtoDate(familyValues[0]);
                    if (marriedDate.after(tDate)) {
                        String message="Marriage date is after today's date";
                        int errorline=issueLine.GetLineNumber_Family(t,familyValues[0]);
                        errorMessages.FamilyTableErrorMessages(message,t,"UserStory01",errorline);
                        result=true;

                    }
                }  if (!(familyValues[1].trim().equalsIgnoreCase("NA"))) {
                    divorceDate = formatGEDCOM.StringtoDate(familyValues[1]);
                    if (divorceDate.after(tDate)) {
                        String message="Divorce date is after today's date";
                        int errorline=issueLine.GetLineNumber_Family(t,familyValues[1]);
                        errorMessages.FamilyTableErrorMessages(message,t,"UserStory01",errorline);
                        result=true;

                    }
                }
            } catch (Exception e) {
                continue;
            }
        }
        return result;
    }

    public boolean checkMarriageWithBirth(HashMap<String,String[]>familyMap,HashMap<String,String[]>indiMap) throws ParseException {

        String[] familyValues,indiValuesHus,indiValuesWife=new String[100];
        Date birthDateHus,marriedDate,birthDateWife;
        boolean result=false;
        for(String s: familyMap.keySet())
        {
            familyValues=familyMap.get(s);
            try
            {
                marriedDate=formatGEDCOM.StringtoDate(familyValues[0]);
                indiValuesHus=indiMap.get(familyValues[2]);
                indiValuesWife=indiMap.get(familyValues[4]);
                birthDateHus=formatGEDCOM.StringtoDate(indiValuesHus[2]);
                birthDateWife=formatGEDCOM.StringtoDate(indiValuesWife[2]);
                if(birthDateHus.after(marriedDate))
                {
                    String message="Husband's birth date is after married date";
                    int errorline=issueLine.GetLineNumber_Individual(familyValues[2],indiValuesHus[2]);
                    errorMessages.FamilyAndIndividualTableErrorMessages(message,familyValues[2],s,"UserStory02",errorline);
                    result=true;

                }
                if(birthDateWife.after(marriedDate))
                {
                    String message="Wife's birth date is after married date";
                    int errorline=issueLine.GetLineNumber_Individual(familyValues[4],indiValuesWife[2]);
                    errorMessages.FamilyAndIndividualTableErrorMessages(message,familyValues[4],s,"UserStory02",errorline);
                    result=true;
                }

            }
            catch(Exception e)
            {
                continue;
            }
        }
        return result;

    }
}


		

	

