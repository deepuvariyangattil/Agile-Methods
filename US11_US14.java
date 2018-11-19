import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class US11_US14 {
    FormatGEDCOM formatGEDCOM = new FormatGEDCOM();

    public boolean noBigamy(HashMap<String,String[]> Fam) throws ParseException
    {
        boolean t=false;
        ErrorMessages em = new ErrorMessages();
        String[] famValues=new String[100];
        String[] famcheck=new String[100];
        Date marrieddate = new Date();
        Date divorcedate = new Date();
        Date marrieddatecheck = new Date();


        for(String s:Fam.keySet())
        {

            famValues=Fam.get(s);

            marrieddate = new SimpleDateFormat("dd-MM-yyyy").parse(famValues[0]);
            if(!famValues[1].equals("NA"))
            {
                divorcedate = new SimpleDateFormat("dd-MM-yyyy").parse(famValues[1]);

                for(String s1:Fam.keySet())
                {
                    famcheck=Fam.get(s1);
                    marrieddatecheck = new SimpleDateFormat("dd-MM-yyyy").parse(famcheck[0]);
                    if((famcheck[2].equals(famValues[2])||famcheck[4].equals(famValues[4]))&&(marrieddatecheck.after(marrieddate)&&marrieddatecheck.before(divorcedate))&&!s1.equals(s))
                    {
                        int lineNumber=new IssueLine().GetLineNumber_Family(s1,famcheck[0]);
                        em.FamilyTableErrorMessages("Bigamy occurrence in families: ",s+" and "+s1,"UserStory11",lineNumber);
                        t=true;

                    }


                }

            }
            if(famValues[1].equals("NA"))
            {

                for(String s1:Fam.keySet())
                {
                    famcheck=Fam.get(s1);
                    marrieddatecheck = new SimpleDateFormat("dd-MM-yyyy").parse(famcheck[0]);
                    if((famcheck[2].equals(famValues[2])||famcheck[4].equals(famValues[4]))&&marrieddatecheck.after(marrieddate)&&!s1.equals(s))
                    {
                        int lineNumber=new IssueLine().GetLineNumber_Family(s1,famcheck[0]);
                        em.FamilyTableErrorMessages("Bigamy occurrence in families: ",s+" and "+s1,"UserStory11",lineNumber);

                        t=true;

                    }


                }






            }





        }

        return t;

    }


    public boolean multipleBirths(HashMap<String,String[]> Indi) throws ParseException
    {
        boolean t=false;
        ErrorMessages em = new ErrorMessages();
        int count=0;
        String[] indiValues=new String[100];
        String[] indicheck=new String[100];
        ArrayList<String>siblingSet=new ArrayList<>();

        //System.out.println("User Story 14: Multiple Births<=5");
        for(String s:Indi.keySet())
        {
            indiValues=Indi.get(s);
            Date birthday = new Date();
            birthday = new SimpleDateFormat("dd-MM-yyyy").parse(indiValues[2]);
            if(!siblingSet.contains(s))
            {
                siblingSet.add(s);
            }

            if(indiValues[6]!="")
            {
                for(String s1:Indi.keySet())
                {
                    indicheck=Indi.get(s1);

                    Date sibbirthday = new Date();
                    sibbirthday = new SimpleDateFormat("dd-MM-yyyy").parse(indicheck[2]);

                    if(indiValues[6].equals(indicheck[6])&& birthday.equals(sibbirthday) &&(!s.equals(s1))&&(!siblingSet.contains(s1)))
                    {
                        count++;
                        siblingSet.add(s1);
                    }
                    //System.out.println(count);
                    if(count>4)
                    {
                        int linenumber=new IssueLine().GetLineNumber_Family(indiValues[6],indiValues[6]);
                        em.FamilyTableErrorMessages("More than five siblings born at same time",indiValues[6],"UserStory14",linenumber);
                        t=true;
                        count=0;
                        break;

                    }

                }

                count=0;
            }

        }







        return t;

    }







}