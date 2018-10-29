import java.util.HashMap;

public class GenderCorrectness_US21 {


    public boolean CorrectGender_US21(HashMap<String, String[]> Family, HashMap<String, String[]> Individual) {
        String[] familyValues, individualValues = new String[100];
        boolean result = false;
        ErrorMessages errorMessages = new ErrorMessages();
        for (String s : Family.keySet()) {
            familyValues = Family.get(s);
            try {
                for (String t : Individual.keySet()) {
                    if (t.equalsIgnoreCase(familyValues[2].trim())) {
                        individualValues = Individual.get(t);

                        if (!(individualValues[1].trim().equalsIgnoreCase("M"))) {
                            String message = "Husband's gender is not Male";
                            errorMessages.FamilyAndIndividualTableErrorMessages(message, familyValues[2], s, "UserStory21");
                            result = true;
                        }
                    }
                }

            } catch (Exception e) {
                errorMessages.IndividualTableErrorMessages("Individual not present ", familyValues[2], "UserStory21");
                continue;
            }
            try {
                for (String t : Individual.keySet()) {
                    if (t.equalsIgnoreCase(familyValues[4].trim())) {
                        individualValues = Individual.get(t);
                        if (!(individualValues[1].trim().equalsIgnoreCase("F"))) {
                            String message = "Wife's gender is not Male";
                            errorMessages.FamilyAndIndividualTableErrorMessages(message, familyValues[4], s, "UserStory21");
                            result = true;
                        }
                    }
                }
            } catch (Exception e) {
                errorMessages.IndividualTableErrorMessages("Individual not present ", familyValues[4], "UserStory21");
                continue;
            }
        }
        return result;
    }


}