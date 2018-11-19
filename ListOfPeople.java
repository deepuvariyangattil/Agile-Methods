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
        String[] indiValues1 = new String[100];
        Vector<String> recent_Births = new Vector<String>(100);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        Date checkDate = cal.getTime();
        boolean output = true;

        for (String s : Individual.keySet()) {
            indiValues = Individual.get(s);

            for (String s1 : Individual.keySet()) {
                indiValues1 = Individual.get(s1);

                if (indiValues[4] == "True" && indiValues1[4] == "True") {

                    Date date = new Date();
                    date = new SimpleDateFormat("dd-MM-yyyy").parse(indiValues[2]);

                    try {
                        if (date.after(checkDate)) {

                            if (indiValues[2].equals(indiValues1[2])) {
                                recent_Births.add(indiValues[0]);
                                output = false;

                            }
                        }

                    } catch (Exception e) {
                        continue;
                    }
                }
            }
        }em.ListPrint("All Recent Births", recent_Births, "UserStory35" );
        return output;
    }
    
    public boolean recentDeaths_US36(HashMap<String, String[]> Individual) throws ParseException {

        formatGEDCOM.GedcomTable();
        ErrorMessages em = new ErrorMessages();
        String[] indiValues = new String[100];
        String[] indiValues1 = new String[100];
        Vector<String> recent_Deaths = new Vector<String>(100);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        Date checkDate = cal.getTime();
        boolean output = true;

        for (String s : Individual.keySet()) {
            indiValues = Individual.get(s);

            for (String s1 : Individual.keySet()) {
                indiValues1 = Individual.get(s1);

                if (indiValues[4] == "False" && indiValues1[4] == "False") {

                    Date date = new Date();
                    date = new SimpleDateFormat("dd-MM-yyyy").parse(indiValues[5]);

                    try {
                        if (date.after(checkDate)) {

                            if (indiValues[5].equals(indiValues1[5])) {
                                recent_Deaths.add(indiValues[0]);
                                output = false;

                            }
                        }

                    } catch (Exception e) {
                        continue;
                    }
                }
            }
        }em.ListPrint("All Recent Deaths", recent_Deaths, "UserStory36"  );
        return output;
    }
}

