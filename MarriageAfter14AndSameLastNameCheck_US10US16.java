import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Marriageafter14andSamelastnamecheck_US10US14 {
    private FormatGEDCOM formatGEDCOM = new FormatGEDCOM();

    public Marriageafter14andSamelastnamecheck_US10US14() {
       // formatGEDCOM.GedcomTable();

    }

    public boolean MarriageAfterFourteen_US10(HashMap<String,String[]>Family,HashMap<String,String[]> Individual)
{   //HashMap<String,String[]> Family=formatGEDCOM.getFamilyMap();
    //HashMap<String,String[]> Individual=formatGEDCOM.getIndividualMap();
    String fValues[]=new String[100];
    String iValues[]=new String[100];
    Date marriedDate,birthDate;
    long differenceInDays,duration,differenceInYears;
    Boolean output=false;

    for(String s: Family.keySet())
    {
        fValues=Family.get(s);
        try {
            marriedDate=formatGEDCOM.StringtoDate(fValues[0]);
        } catch (ParseException e) {
            continue;
        }
        for(String t:Individual.keySet())
        {
            if(fValues[2].trim().equalsIgnoreCase(t)||fValues[4].trim().equalsIgnoreCase(t))
            {
                iValues=Individual.get(t);
                try {
                    birthDate=formatGEDCOM.StringtoDate(iValues[2]);
                } catch (ParseException e) {
                    continue;
                }
                duration=marriedDate.getTime()-birthDate.getTime();
                differenceInDays=TimeUnit.MILLISECONDS.toDays(duration);
                differenceInYears=differenceInDays/365;
                if(differenceInYears<=14)
                {
                    if(iValues[1].trim().equalsIgnoreCase("M"))
                    {
                        System.out.println("\nError in GEDCOM File: Husband with individual ID "+t+" married at the age "+differenceInYears+" in the family with family ID " +
                               s );
                    }
                    else if(iValues[1].trim().equalsIgnoreCase("F"))
                    {
                        System.out.println("\nError in GEDCOM File: Wife with individual ID "+t+" married at the age "+differenceInYears+" in the family with family ID " +
                                s);
                    }
                    else
                    {
                        System.out.println("\nError in GEDCOM File: Husband/Wife(Gender not mentioned) with individual ID "+t+" married at the age "+differenceInYears+" in the family with family ID " +
                                s);
                    }
                   output=true;
                }


            }
        }


    }
return output;
}
public boolean MaleLastNamesSameInFamily_US16(HashMap<String,String[]> Family,HashMap<String,String[]> Individual)
{
    //HashMap<String,String[]> Family=formatGEDCOM.getFamilyMap();
    //HashMap<String,String[]> Individual=formatGEDCOM.getIndividualMap();
    String fValues[]=new String[100];
    String iValues[]=new String[100];
    String child[]=new String[100];
    String fatherLastName,childLastName;
    boolean result=false;
    for(String s: Family.keySet())
    {
        fValues=Family.get(s);
        fatherLastName=LastNameExtractor(fValues[3]);
        if(!(fValues[6].trim().equalsIgnoreCase(" ")))
        {
            child=fValues[6].split(" ");
            for(String t:child)
            {
                try
                {
                    if(Individual.keySet().contains(t))
                    {
                        iValues=Individual.get(t);
                        childLastName=LastNameExtractor(iValues[0]);
                        if(!(childLastName.trim().equalsIgnoreCase(fatherLastName)))
                        {
                            System.out.println("\nError in GEDCOM File: Child with Individual ID "+t+" Has a different last name compared to Father with individual ID "+fValues[2]
                            +" in the family with family ID "+s);
                            result=true;
                        }

                    }
                }
                catch(Exception e)
                {
                    System.out.println("Error in GEDCOM File: Child record is missing in Individual table\n");
                    continue;
                }
            }
        }

    }
    return result;
}
public String LastNameExtractor(String fullName)
{
    int fIndex = fullName.trim().indexOf("/");
    int lastIndex=fullName.trim().lastIndexOf("/");
    String lastName=fullName.trim().substring(fIndex+1,lastIndex);
    return lastName;
}
}
