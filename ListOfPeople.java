import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

public class ListOfPeople {

    private FormatGEDCOM formatGEDCOM = new FormatGEDCOM();

    public ListOfPeople(){}
    
    public boolean recentBirths_US35(HashMap<String, String[]> Individual) throws ParseException {

        formatGEDCOM.GedcomTable();
        ErrorMessages em = new ErrorMessages();
        String[] indiValues = new String[100];
        String[] indiValues1 = new String[100];
        Vector<String> recent_Births = new Vector<String>(100);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        Date checkDate = cal.getTime();
        boolean output = false;

        for (String s : Individual.keySet()) {
            indiValues = Individual.get(s);
            if (indiValues[4] == "True") {

                java.util.Date date = new Date(0);
                String fDate;
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                fDate = dateFormat.format(date);
                date = new SimpleDateFormat("dd-MM-yyyy").parse(indiValues[2]);

                try {

                    if (date.after(checkDate)) {
                        for (String s1 : Individual.keySet()) {
                            indiValues1 = Individual.get(s1);
                            {

                                if (indiValues[2].equals(indiValues1[2])) {
                                    recent_Births.add(indiValues[0]);
                                    output = true;
                                }
                            }
                        }
                    }

                } catch (Exception e) {
                    continue;
                }
            }
        }
        em.ListPrint("All Recent Births", recent_Births, "UserStory35" );
        output = true;
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
        boolean output = false;

        for (String s : Individual.keySet()) {
            indiValues = Individual.get(s);
            if (indiValues[4] == "False") {

                java.util.Date date = new Date(0);
                String fDate;
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                fDate = dateFormat.format(date);
                date = new SimpleDateFormat("dd-MM-yyyy").parse(indiValues[5]);

                try {

                    if (date.after(checkDate)) {
                        for (String s1 : Individual.keySet()) {
                            indiValues1 = Individual.get(s1);
                            {

                                if (indiValues[5].equals(indiValues1[5])) {
                                    recent_Deaths.add(indiValues[0]);
                                    output = true;
                                }
                            }
                        }
                    }

                } catch (Exception e) {
                    continue;
                }
            }
        }
        em.ListPrint("All Recent Deaths", recent_Deaths, "UserStory36" );
        output = true;
        return output;
    }
}

