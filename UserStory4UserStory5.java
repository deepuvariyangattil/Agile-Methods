import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

public class UserStory4UserStory5 {
    private FormatGEDCOM formatGEDCOM = new FormatGEDCOM();
    IssueLine issueLine=new IssueLine();
    ErrorMessages errorMessages=new ErrorMessages();



    public boolean MarriageBeforeDivorce_US4(HashMap<String, String[]> Family) throws ParseException {

        boolean result=false;
        String[] familyValues = new String[100];
        Date marriedDate, divorceDate, tdate;
        tdate = new Date();//Setting date to today's date.
        for (String s : Family.keySet()) {
            familyValues = Family.get(s);//Getting values of family map for each key value
            try {
                if ((!familyValues[0].equalsIgnoreCase("NA")) && (!familyValues[1].equalsIgnoreCase("NA"))) {

                    if ((!familyValues[0].equalsIgnoreCase("")) || (!familyValues[1].equalsIgnoreCase(""))) {
                        marriedDate = formatGEDCOM.StringtoDate(familyValues[0]);
                        divorceDate = formatGEDCOM.StringtoDate(familyValues[1]);
                        if (marriedDate.after(divorceDate) || marriedDate.equals(divorceDate)) {
                            String message="Marriage Date is after Divorce date";

                            int errorline=issueLine.GetLineNumber_Family(s,familyValues[0]);
                            errorMessages.FamilyTableErrorMessages(message,s,"UserStory04",errorline);

                            result=true;


                        }
                        else if(marriedDate.equals(divorceDate))
                        {
                            String message="Marriage Date and Divorce date are same";
                            int errorline=issueLine.GetLineNumber_Family(s,familyValues[0]);
                            errorMessages.FamilyTableErrorMessages(message,s,"UserStory04",errorline);
                            result=true;


                        }
                    } else {
                        String message="Marriage date and Divorce date is not mentioned";
                        int errorline=issueLine.GetLineNumber_Family(s,familyValues[0]);
                        errorMessages.FamilyTableErrorMessages(message,s,"UserStory04",errorline);
                        result=true;


                    }


                } else if ((!familyValues[0].equalsIgnoreCase("NA")) && (familyValues[1].equalsIgnoreCase("NA")))

                {
                    marriedDate = formatGEDCOM.StringtoDate(familyValues[0]);
                    if (marriedDate.after(tdate)) {
                        String message="Marriage date is mentioned is a future date";
                        int errorline=issueLine.GetLineNumber_Family(s,familyValues[0]);
                        errorMessages.FamilyTableErrorMessages(message,s,"UserStory04",errorline);
                        result=true;


                    }
                } else if ((familyValues[0].equalsIgnoreCase("NA")) && (!familyValues[1].equalsIgnoreCase("NA"))) {
                    String message="Divorce date is mentioned but Marriage Date not mentioned";
                    int errorline=issueLine.GetLineNumber_Family(s,familyValues[0]);
                    errorMessages.FamilyTableErrorMessages(message,s,"UserStory04",errorline);
                    result=true;



                }
            }
            catch (Exception e)
            {
                e.fillInStackTrace();
            }
        }

        return result;
    }
    public boolean MarriageBeforeDeath_US5(HashMap<String, String[]> Family,HashMap<String, String[]> Individual) throws ParseException {
        boolean result=false;
        String familyValues[]=new String[100];
        String individualValues[]=new String[100];
        Date marriedDate,deathDate;
        for(String key: Family.keySet())
        {
            familyValues=Family.get(key);
            try {
                marriedDate=formatGEDCOM.StringtoDate(familyValues[0]);
            }
            catch(Exception e)
            {
                continue;
            }
            for(String iKey:Individual.keySet())
            {
                if(familyValues[2].trim().equalsIgnoreCase(iKey)||familyValues[4].trim().equalsIgnoreCase(iKey))
                {
                    individualValues=Individual.get(iKey);
                    try {
                        deathDate = formatGEDCOM.StringtoDate(individualValues[5]);
                        if(deathDate.before(marriedDate))
                        {
                            if(individualValues[1].trim().equalsIgnoreCase("M"))
                            {
                                String message="Husband's death date is before marriage date";
                                int linenumber=issueLine.GetLineNumber_Individual(iKey,individualValues[5]);
                                errorMessages.FamilyAndIndividualTableErrorMessages(message,iKey,key,"UserStory05",linenumber);
                                result=true;

                            }
                            else if(individualValues[1].trim().equalsIgnoreCase("F"))
                            {
                                String message="Wife's death date is before marriage date";
                                int linenumber=issueLine.GetLineNumber_Individual(iKey,individualValues[5]);
                                errorMessages.FamilyAndIndividualTableErrorMessages(message,iKey,key,"UserStory05",linenumber);
                                result=true;

                            }
                            else
                            {
                                String message="Wife/Husband's(Gender not mentioned) death date is before marriage date";
                                int linenumber=issueLine.GetLineNumber_Individual(iKey,individualValues[5]);
                                errorMessages.FamilyAndIndividualTableErrorMessages(message,iKey,key,"UserStory05",linenumber);
                                result=true;

                            }
                        }
                    }
                    catch (Exception e)
                    {
                        continue;
                    }
                }


            }

        }
        return result;
    }



}
