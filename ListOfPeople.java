import java.util.HashMap;
import java.util.Vector;

public class ListOfPeople {

    public boolean ListLiving_US30(HashMap<String, String[]> family, HashMap<String, String[]> individual) {
        ErrorMessages errorMessages = new ErrorMessages();
        String[] familyValues, individualValues = new String[100];
        boolean result = false;
        Vector<String> living_Married = new Vector<String>(100);
        for (String s : family.keySet()) {
            familyValues = family.get(s);
            try {
                individualValues = individual.get(familyValues[2].trim());
                if (individualValues[4].trim().equalsIgnoreCase("TRUE") && individualValues[5].trim().equalsIgnoreCase("NA")) {

                    living_Married.add(individualValues[0]);
                    result = true;
                }

            } catch (Exception e) {

                errorMessages.IndividualTableErrorMessages("Individual not present ", familyValues[2], "UserStory30");
                continue;
            }
            try {
                individualValues = individual.get(familyValues[4].trim());
                if (individualValues[4].trim().equalsIgnoreCase("TRUE") && individualValues[5].trim().equalsIgnoreCase("NA")) {
                    living_Married.add(individualValues[0]);
                    result = true;
                }

            } catch (Exception e) {

                errorMessages.IndividualTableErrorMessages("Individual not present ", familyValues[4], "UserStory30");
                continue;
            }


        }
        errorMessages.ListPrint("Living Married people", living_Married, "UserStory30");
        return result;
    }

}