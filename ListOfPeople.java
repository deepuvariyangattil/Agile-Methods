import java.text.ParseException;
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
    public boolean UpcomingBday_US38(HashMap<String,String[]> individualMap)
    {
       String individualValues[]=new String[100];
       FormatGEDCOM formatGEDCOM=new FormatGEDCOM();
       ErrorMessages errorMessages=new ErrorMessages();
       Date birthDay=new Date();
       Date currentDay=new Date();
       Vector<String>bdayPeople=new Vector<>(100);

       boolean result=false;
       for(String s: individualMap.keySet())
       {
           individualValues=individualMap.get(s);
           if(!(individualValues[2].trim().equalsIgnoreCase("NA"))&&individualValues[5].trim().equalsIgnoreCase("NA"))
           {

               try {
                   birthDay=formatGEDCOM.StringtoDate(individualValues[2]);

                   Calendar calendar=Calendar.getInstance();
                   calendar.setTime(birthDay);

                   int bdayMonth=calendar.get(Calendar.MONTH)+1;//Month function returns 0 for January and 1 for Feb and so on. so adding one to get correct month
                   int bdayDate=calendar.get(Calendar.DATE);
                   calendar.setTime(currentDay);
                   int currentMonth=calendar.get(Calendar.MONTH)+1;
                   int currentDate=calendar.get(Calendar.DATE);

                   if(((bdayMonth-currentMonth==1)&&(bdayDate<=currentDate))||(((bdayMonth-currentMonth==0)&&(bdayDate>currentDate))))
                   {
                       bdayPeople.add(individualValues[0]);
                       result=true;
                   }


               } catch (ParseException e) {
                   continue;
               }
           }
       }

       errorMessages.ListPrint("Upcoming birthday people",bdayPeople,"UserStory38");
       return result;
    }
    public boolean listDeceased_US29(HashMap<String, String[]> individual){

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
