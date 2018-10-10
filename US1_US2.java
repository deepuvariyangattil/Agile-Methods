import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

public class US1_US2 {
    FormatGEDCOM formatGEDCOM = new FormatGEDCOM();

    public US1_US2() {
        formatGEDCOM.GedcomTable();

    }

    public void checkDatesWithToday() throws ParseException {


        HashMap<String, String[]> Indi = formatGEDCOM.getIndividualMap();
        HashMap<String, String[]> familyMap = formatGEDCOM.getFamilyMap();
        Date tDate = new Date();
        Date marriedDate, birthDate, divorceDate, deathDate;
        String[] familyValues, indiValues = new String[100];
        for (String s : Indi.keySet()) {
            indiValues = Indi.get(s);
            try {
                if (!(indiValues[2].equalsIgnoreCase("NA"))) {
                    birthDate = formatGEDCOM.StringtoDate(indiValues[2]);

                    if (birthDate.after(tDate)) {
                        System.out.println("Error in GEDCOM File: Individual with individual ID " + s + " is having birth date after " +
                                "today's date\n");
                    }
                } else if (!(indiValues[2].equalsIgnoreCase("NA"))) {
                    deathDate = formatGEDCOM.StringtoDate(indiValues[4]);
                    if (deathDate.after(tDate)) {
                        System.out.println("Error in GEDCOM File: Individual with individual ID " + s + " is having death date after " +
                                "today's date\n");
                    }
                }


            } catch (Exception e) {
                continue;
            }
        }
        for (String t : familyMap.keySet()) {
            familyValues = familyMap.get(t);
            try {
                if (!(familyValues[0].trim().equalsIgnoreCase("NA"))) {
                    marriedDate = formatGEDCOM.StringtoDate(familyValues[0]);
                    if (marriedDate.after(tDate)) {
                        System.out.println("Error in GEDCOM File: Family with Family ID " + t + " is having marriage date after " +
                                "today's date\n");
                    }
                } else if (!(familyValues[1].trim().equalsIgnoreCase("NA"))) {
                    divorceDate = formatGEDCOM.StringtoDate(familyValues[1]);
                    if (divorceDate.after(tDate)) {
                        System.out.println("Error in GEDCOM File: Family with Family ID " + t + " is having divorce date after " +
                                "today's date\n");
                    }
                }
            } catch (Exception e) {
                continue;
            }
        }
    }

    public void checkMarriageWithBirth() throws ParseException {

        HashMap<String,String[]>familyMap=formatGEDCOM.getFamilyMap();
        HashMap<String,String[]>indiMap=formatGEDCOM.getIndividualMap();
        String[] familyValues,indiValuesHus,indiValuesWife=new String[100];
        Date birthDateHus,marriedDate,birthDateWife;

        for(String s: familyMap.keySet())
        {
            familyValues=familyMap.get(s);
            try
            {
                marriedDate=formatGEDCOM.StringtoDate(familyValues[0]);
                indiValuesHus=indiMap.get(familyValues[2]);
                indiValuesWife=indiMap.get(familyValues[4]);
                birthDateHus=formatGEDCOM.StringtoDate(indiValuesHus[2]);
                birthDateWife=formatGEDCOM.StringtoDate(indiValuesWife[2]);
                if(birthDateHus.after(marriedDate))
                {
                    System.out.println("Error in GEDCOM File: Husband's birth date is after married date for the family " +
                            "with family ID "+s+"\n");
                }
                if(birthDateWife.after(marriedDate))
                {
                    System.out.println("Error in GEDCOM File: Wife's birth date is after married date for the family " +
                            "with family ID "+s+"\n");
                }

            }
            catch(Exception e)
            {
                continue;
            }
        }

    }
}


		

	

