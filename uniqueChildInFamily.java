import java.util.HashMap;
import java.util.Vector;

public class uniqueChildInFamily {

    private FormatGEDCOM formatGEDCOM = new FormatGEDCOM();

    public uniqueChildInFamily() {
    }

    public boolean uniqueChild_US25(HashMap<String, String[]> Family, HashMap<String, String[]> Individual) {

        formatGEDCOM.GedcomTable();
        String[] famValues, childarray = new String[100];
        IssueLine issueLine=new IssueLine();
        String[] indiValues, indiValues1 = new String[100];
        String[] childInfo = new String[100];
        Vector<String> comparisonList = new Vector<>(100);
        ErrorMessages em = new ErrorMessages();
        boolean output = false;

        for (String s : Family.keySet()) {
            famValues = Family.get(s);


            childarray = famValues[6].trim().split(" ");
            if (childarray.length > 1) {

                for (int i = 0; i < childarray.length; i++) {
                    for (String indikey : Individual.keySet()) {
                        if (indikey.equalsIgnoreCase(childarray[i])) {
                            childInfo = Individual.get(indikey);
                            comparisonList.add(indikey);
                            comparisonList.add(childInfo[0]);
                            comparisonList.add(childInfo[2]);

                        }
                    }
                }

                for (int i = 1; i < comparisonList.size(); i = i + 2) {
                    for (int j = i + 3; j < comparisonList.size(); j += 3) {
                        
                        if ((comparisonList.elementAt(i).equalsIgnoreCase(comparisonList.elementAt(j))) && (comparisonList.elementAt(i + 1).equalsIgnoreCase(comparisonList.elementAt(j + 1)))) {

                            String IDs = comparisonList.elementAt(i - 1) + "," + comparisonList.elementAt(j - 1);
                            int errorLine=issueLine.GetLineNumber_Individual(comparisonList.elementAt(j-1),comparisonList.elementAt(j));
                            em.IndividualTableErrorMessages("Name and Birthdate same for children", IDs, "UserStory25",errorLine);
                            output = true;
                        }

                    }

                }
            }
            comparisonList.clear();
        }


        return output;

    }
}