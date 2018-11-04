import java.text.ParseException;
import java.util.HashMap;

public class listDeceased {

    private FormatGEDCOM formatGEDCOM = new FormatGEDCOM();

    public listDeceased(){}

    public boolean listDeceased_US29( HashMap<String, String[]> individual) throws ParseException {

        formatGEDCOM.GedcomTable();
        HashMap<String, String[]> Individual = formatGEDCOM.getIndividualMap();
        String[] indiValues = new String[100];
        ErrorMessages em = new ErrorMessages();
        boolean output = false;

        for (String s : Individual.keySet()) {
            indiValues = Individual.get(s);

            if (indiValues[4] != "True" && indiValues[5] != "NA") {

                em.IndividualTableErrorMessages("The individual is listed as deceased",s, "US29");

            }output =true;

        }return output;
    }
}
