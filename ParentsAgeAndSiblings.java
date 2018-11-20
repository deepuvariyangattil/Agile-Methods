import java.util.HashMap;

public class ParentsAgeAndSiblings {
    public boolean checkParentsAgeDifference(HashMap<String, String[]> individual, HashMap<String, String[]> family) {
        boolean result = false;
        FormatGEDCOM obj = new FormatGEDCOM();
        String familyDetails[] = new String[100];
        String[] husband;
        String[] wife;
        String[] child;
        String AchildID[] = new String[3];
        String childID = null;
        ErrorMessages em = new ErrorMessages();

        for (String s : family.keySet()) {
            boolean moreThan1Child = false;
            familyDetails = family.get(s);
            String husID = familyDetails[2];
            String wifeID = familyDetails[4];
            if (familyDetails[6].split(" ").length > 2) {
                AchildID = familyDetails[6].split(" ");
                moreThan1Child = true;
            } else {
                childID = familyDetails[6].trim();
            }

            if (moreThan1Child) {
                for (int i = 1; i < AchildID.length; i++) {

                    husband = individual.get(husID);
                    wife = individual.get(wifeID);
                    child = individual.get(AchildID[i]);
                    if (Integer.parseInt(husband[3]) - Integer.parseInt(child[3]) > 80)  {

                        String message="Age difference between father and child is greater than 80";
                        int errorLine=new IssueLine().GetLineNumber_Family(s,s);
                        em.FamilyTableErrorMessages(message,s,"UserStory12",errorLine);

                        result = true;
                    }
                    if (Integer.parseInt(wife[3]) - Integer.parseInt(child[3]) > 60) {
                        String message = "Age difference between mother and child is greater than 60";
                        int errorLine = new IssueLine().GetLineNumber_Family(s, s);
                        em.FamilyTableErrorMessages(message, s, "UserStory12", errorLine);
                        result = true;
                    }



                }

            } else {
                husband = individual.get(husID);
                wife = individual.get(wifeID);
                if(!childID.equals(""))
                {
                    child = individual.get(childID);

                    if (Integer.parseInt(husband[3]) - Integer.parseInt(child[3]) > 80) {
                        String message="Age difference between father and child is greater than 80";
                        int errorLine=new IssueLine().GetLineNumber_Family(s,s);
                        em.FamilyTableErrorMessages(message,s,"UserStory12",errorLine);
                        result=true;

                    }
                    if (Integer.parseInt(wife[3]) - Integer.parseInt(child[3]) > 60) {
                        String message = "Age difference between mother and child is greater than 60";
                        int errorLine = new IssueLine().GetLineNumber_Family(s, s);
                        em.FamilyTableErrorMessages(message, s, "UserStory12", errorLine);
                        result = true;
                    }
                }


            }

        }
        return result;
    }
    public boolean LessSiblings(HashMap<String, String[]> family){
        boolean result = false;
        ErrorMessages em = new ErrorMessages();
        for(String s: family.keySet()){
            String []famvalues = family.get(s);
            if(famvalues[6].split(" ").length>15){
                result = true;
                int lineNumber=new IssueLine().GetLineNumber_Family(s,s);
                em.FamilyTableErrorMessages("More than 15 siblings", s, "UserStory15",lineNumber);
            }
        }



        return result;

    }

}
