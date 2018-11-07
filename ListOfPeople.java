import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

    public boolean UpcomingBday_US38(HashMap<String, String[]> individualMap) {
        String individualValues[] = new String[100];
        FormatGEDCOM formatGEDCOM = new FormatGEDCOM();
        ErrorMessages errorMessages = new ErrorMessages();
        Date birthDay = new Date();
        Date currentDay = new Date();
        Vector<String> bdayPeople = new Vector<>(100);

        boolean result = false;
        for (String s : individualMap.keySet()) {
            individualValues = individualMap.get(s);
            if (!(individualValues[2].trim().equalsIgnoreCase("NA")) && individualValues[5].trim().equalsIgnoreCase("NA")) {

                try {
                    birthDay = formatGEDCOM.StringtoDate(individualValues[2]);

                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(birthDay);

                    int bdayMonth = calendar.get(Calendar.MONTH) + 1;//Month function returns 0 for January and 1 for Feb and so on. so adding one to get correct month
                    int bdayDate = calendar.get(Calendar.DATE);
                    calendar.setTime(currentDay);
                    int currentMonth = calendar.get(Calendar.MONTH) + 1;
                    int currentDate = calendar.get(Calendar.DATE);

                    if (((bdayMonth - currentMonth == 1) && (bdayDate <= currentDate)) || (((bdayMonth - currentMonth == 0) && (bdayDate > currentDate)))) {
                        bdayPeople.add(individualValues[0]);
                        result = true;
                    }


                } catch (ParseException e) {
                    continue;
                }
            }
        }

        errorMessages.ListPrint("Upcoming birthday people", bdayPeople, "UserStory38");
        return result;
    }

    public boolean listDeceased_US29(HashMap<String, String[]> individual) {

        Vector<String> all_deceased = new Vector<String>(100);
        String[] indiValues = new String[100];
        ErrorMessages em = new ErrorMessages();
        boolean output = false;

        for (String s : individual.keySet()) {
            indiValues = individual.get(s);

            try {

                if (indiValues[4] != "True" && indiValues[5] != "NA") {
                    all_deceased.add(indiValues[0]);
                    output = true;
                }
            } catch (Exception e) {
                continue;
            }

        }
        em.ListPrint("All Deceased People", all_deceased, "UserStory29");
        return output;
    }

    public boolean recentSurvivors_US37(HashMap<String, String[]> Indi) throws ParseException {
        boolean t = false;
        String[] indiValues = new String[100];
        String[] indiValues2 = new String[100];
        String[] famValues = new String[100];
        ErrorMessages errorMessages = new ErrorMessages();
        Vector<String> survivors = new Vector<>(100);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date date1 = sdf.parse("01-10-2018");


        for (String s : Indi.keySet()) {
            indiValues = Indi.get(s);
            if (indiValues[4] == "False") {
                java.util.Date date = new Date(0);
                String formattedDate;
                try {
                    date = new SimpleDateFormat("dd-MM-yyyy").parse(indiValues[5]);
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                formattedDate = dateFormat.format(date);

                if (date.after(date1)) {
                    for (String s1 : Indi.keySet()) {
                        indiValues2 = Indi.get(s1);
                        if ((indiValues[7].equals(indiValues2[7]) || indiValues[7].equals(indiValues2[6])) && indiValues2[4] == "True" && !(indiValues[0].equals(indiValues2[0]))) {

                            survivors.add(indiValues2[0]);
                            t = true;
                        }

                    }
                }
            }

        }
        errorMessages.ListPrint("Recent survivors", survivors, "UserStory_37");

        return t;
    }

    public boolean UpAnniv_39(HashMap<String, String[]> Fam) throws ParseException {
        boolean t=false;
        String[] famValues=new String[100];
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM");
        int datestart=07;
        int dateend=07;
        int monthstart=11;
        int monthend=12;
        Vector<String> anniversary = new Vector<>(100);
        ErrorMessages errorMessages = new ErrorMessages();

        //System.out.println("User Story 39: Upcoming anniversaries:");
        for(String s:Fam.keySet()) {
            famValues = Fam.get(s);
            java.util.Date date = new Date(0);
            String marriedmonth, marrieddate;
            try {
                date = new SimpleDateFormat("dd-MM-yyyy").parse(famValues[0]);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            DateFormat mo = new SimpleDateFormat("MM");
            marriedmonth = mo.format(date);
            int m = Integer.parseInt(marriedmonth);
            DateFormat dt = new SimpleDateFormat("dd");
            marrieddate = dt.format(date);
            int d = Integer.parseInt(marrieddate);

            if (monthstart == m || monthend == m) {
                if ((d > datestart && d < 31) || (d < dateend && d > 0)) {
                    String couple=famValues[3]+" & "+famValues[5];
                    anniversary.add(couple);
                    t = true;
                }

            }
        }

        errorMessages.ListPrint("couple celebrating upcoming anniversaries", anniversary, "UserStory39");

        return t;


    }

}
