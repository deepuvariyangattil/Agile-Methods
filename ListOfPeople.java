import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

public class ListOfPeople {

    private FormatGEDCOM formatGEDCOM = new FormatGEDCOM();

    public ListOfPeople() {
    }

    public boolean recentBirths_US35(HashMap<String, String[]> Individual) throws ParseException {

        formatGEDCOM.GedcomTable();
        ErrorMessages em = new ErrorMessages();
        String[] indiValues = new String[100];
        Vector<String> recent_Births = new Vector<String>(100);
        boolean output = false;

        for (String s : Individual.keySet()) {
            indiValues = Individual.get(s);


            if (indiValues[4] == "True") {

                Date date = new Date();
                Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(indiValues[2]);

                long duration = date.getTime() - date1.getTime();
                long inDays = TimeUnit.MILLISECONDS.toDays(duration);

                try {
                    if (inDays < 30) {

                        recent_Births.add(indiValues[0]);
                        output = true;

                    }

                } catch (Exception e) {
                    continue;
                }
            }
        }em.ListPrint("All Recent Births", recent_Births, "UserStory35" );
        return output;
    }
    
    public boolean recentDeaths_US36(HashMap<String, String[]> Individual) throws ParseException {

        formatGEDCOM.GedcomTable();
        ErrorMessages em = new ErrorMessages();
        String[] indiValues = new String[100];
        Vector<String> recent_Deaths = new Vector<String>(100);
        boolean output = false;

        for (String s : Individual.keySet()) {
            indiValues = Individual.get(s);


            if (indiValues[4] == "False") {

                Date date = new Date();
                Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(indiValues[5]);

                long duration = date.getTime() - date1.getTime();
                long inDays = TimeUnit.MILLISECONDS.toDays(duration);

                try {
                    if (inDays < 30) {

                        recent_Deaths.add(indiValues[0]);
                        output = true;

                    }

                } catch (Exception e) {
                    continue;
                }
            }
        }em.ListPrint("All Recent Death", recent_Deaths, "UserStory36" );
        return output;
    }
}

