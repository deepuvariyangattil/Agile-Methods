import java.text.ParseException;
import java.util.HashMap;

public class uniqueNameAndBirthdayCheck {

    private FormatGEDCOM formatGEDCOM = new FormatGEDCOM();

    public uniqueNameAndBirthdayCheck() {
    }

    public boolean uniqueNameandBirthday_US23(HashMap<String, String[]> Individual) throws ParseException {

        ErrorMessages em = new ErrorMessages();

        String[] indiValues = new String[100];
        String[] indiValues1 = new String[100];
        Boolean output = false;
        String temp="";

        for (String s : Individual.keySet()) {
            indiValues = Individual.get(s);

            for (String s1 : Individual.keySet()) {
                indiValues1 = Individual.get(s1);
                if(!(temp.equalsIgnoreCase(s))) {

                    if ((!(s.equals(s1))) && indiValues[0].equals(indiValues1[0]) && indiValues[2].equals(indiValues1[2])) {
                        temp = s1;
                        String individualID = s + "," + s1;
                        em.IndividualTableErrorMessages("Name and Birth date is same for two individuals", individualID, "UserStory23");
                        output = true;
                    }
                }
            }
        }
        return output;
    }
}