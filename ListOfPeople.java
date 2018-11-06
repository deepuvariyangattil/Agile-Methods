import java.util.HashMap;
import java.util.Vector;

public class ListOfPeople {

    private FormatGEDCOM formatGEDCOM = new FormatGEDCOM();

    public ListOfPeople(){}

    public boolean listDeceased_US29(HashMap<String, String[]> individual){

        formatGEDCOM.GedcomTable();
        //HashMap<String, String[]> individual = formatGEDCOM.getIndividualMap();
        Vector<String> all_deceased = new Vector<String>(100);
        String[] indiValues = new String[100];
        ErrorMessages em = new ErrorMessages();
        boolean output = false;

        for (String s : individual.keySet()) {
            indiValues = individual.get(s);

            try{

                if (indiValues[4] != "True" && indiValues[5] != "NA") {
                    all_deceased.add(indiValues[0]);
                    output = true;
                }
            }
            catch(Exception e){
                continue;
            }

        }
        em.ListPrint("All Deceased People", all_deceased, "UserStory29");
        return output;
    }
}
