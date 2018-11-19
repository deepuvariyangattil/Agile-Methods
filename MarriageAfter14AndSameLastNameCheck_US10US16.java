import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class MarriageAfter14AndSameLastNameCheck_US10US16 {
    private FormatGEDCOM formatGEDCOM = new FormatGEDCOM();
    IssueLine issueLine=new IssueLine();

    public MarriageAfter14AndSameLastNameCheck_US10US16() {


    }

    public boolean MarriageAfterFourteen_US10(HashMap<String,String[]>Family,HashMap<String,String[]> Individual)
{   String fValues[]=new String[100];
    String iValues[]=new String[100];
    ErrorMessages errorMessages=new ErrorMessages();
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
                        int errorline=issueLine.GetLineNumber_Individual(t,iValues[2]);
                        errorMessages.FamilyAndIndividualTableErrorMessages("Husband married before 14 years old",t,s,"UserStory10",errorline);

                    }
                    else if(iValues[1].trim().equalsIgnoreCase("F"))
                    {
                        int errorline=issueLine.GetLineNumber_Individual(t,iValues[2]);
                        errorMessages.FamilyAndIndividualTableErrorMessages("Wife married before 14 years old",t,s,"UserStory10",errorline);
                    }
                    else
                    {
                        int erroline=issueLine.GetLineNumber_Family(s,s);
                        errorMessages.FamilyAndIndividualTableErrorMessages("Husband/Wife(Gender not mentioned) married before 14 years old",t,s,"UserStory10",erroline);
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
ErrorMessages errorMessages=new ErrorMessages();
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
                           int errorline=issueLine.GetLineNumber_Individual(t,iValues[0]);
                            errorMessages.FamilyTableErrorMessages("Child and Father has different last names ",s,"UserStory16",errorline);
                            result=true;
                        }

                    }
                }
                catch(Exception e)
                {
                    System.out.println("Error in GEDCOM File_UserStory16: Child record is missing in Individual table\n");
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
