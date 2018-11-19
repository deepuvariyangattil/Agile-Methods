import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class UserStory07 {

    private FormatGEDCOM formatGEDCOM = new FormatGEDCOM();
    IssueLine issueLine=new IssueLine();
    ErrorMessages errorMessages=new ErrorMessages();

    public boolean ageLessThan150_US07(HashMap<String, String[]> Individual) throws ParseException {
        String[] indiValues = new String[100];
        long differenceInDays, differenceInYears;
        Date birthdate, deathdate, tdate;
        tdate = new Date();
        boolean result=false;


        for (String s : Individual.keySet()) {
            indiValues = Individual.get(s);


            if (!indiValues[2].equalsIgnoreCase("NA")) {
                birthdate = formatGEDCOM.StringtoDate(indiValues[2]);

                if (!indiValues[5].equalsIgnoreCase("NA")) {
                    deathdate = formatGEDCOM.StringtoDate(indiValues[5]);

                    long duration = deathdate.getTime() - birthdate.getTime();
                    differenceInDays = TimeUnit.MILLISECONDS.toDays(duration);
                    differenceInYears = differenceInDays / 365;

                    if (differenceInYears > 150) {
                        String message="age is more than 150";
                        int linenumber=issueLine.GetLineNumber_Individual(s,indiValues[2]);
                        errorMessages.IndividualTableErrorMessages(message,s,"UserStory07",linenumber);
                        result=true;

                       // System.out.println("\n ERROR in the Input GEDCOM File_User Story 7: The age is more than 150 for the Individual ID " + s);
                    }
                }
                else if(indiValues[5].equalsIgnoreCase("NA")){

                    long duration1= tdate.getTime() - birthdate.getTime();
                    differenceInDays = TimeUnit.MILLISECONDS.toDays(duration1);
                    differenceInYears = differenceInDays/365;

                    if(differenceInYears > 150){
                        String message="age is more than 150";
                        int linenumber=issueLine.GetLineNumber_Individual(s,indiValues[2]);
                        errorMessages.IndividualTableErrorMessages(message,s,"UserStory07",linenumber);
                        result=true;
                        //System.out.println("\n ERROR in the Input GEDCOM File_User Story 7: The age is more than 150 for the Individual ID " + s);
                    }
                }

            }

        }
        return result;
    }
}
