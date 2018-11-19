import java.util.HashMap;

public class GenderCorrectness_US21 {

IssueLine issueLine=new IssueLine();
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
                            int errorline=issueLine.GetLineNumber_Individual(t,individualValues[1]);
                            errorMessages.FamilyAndIndividualTableErrorMessages(message, familyValues[2], s, "UserStory21",errorline);
                            result = true;
                        }
                    }
                }

            } catch (Exception e) {
                int errorline=issueLine.GetLineNumber_Family(s,familyValues[2]);
                errorMessages.IndividualTableErrorMessages("Individual not present ", familyValues[2], "UserStory21",errorline);
                continue;
            }
            try {
                for (String t : Individual.keySet()) {
                    if (t.equalsIgnoreCase(familyValues[4].trim())) {
                        individualValues = Individual.get(t);
                        if (!(individualValues[1].trim().equalsIgnoreCase("F"))) {
                            String message = "Wife's gender is not Male";
                            int errorline=issueLine.GetLineNumber_Individual(t,individualValues[1]);
                            errorMessages.FamilyAndIndividualTableErrorMessages(message, familyValues[4], s, "UserStory21",errorline);
                            result = true;
                        }
                    }
                }
            } catch (Exception e) {
                int errorline=issueLine.GetLineNumber_Family(s,familyValues[4]);
                errorMessages.IndividualTableErrorMessages("Individual not present ", familyValues[4], "UserStory21",errorline);
                continue;
            }
        }
        return result;
    }


}