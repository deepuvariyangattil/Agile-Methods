import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class DateComparison
{

	ErrorMessages error = new ErrorMessages();
	IssueLine issueLine=new IssueLine();
	// child born before death of mother && father death before 9 months.
	public boolean DeathOfParentsWithChildBirthScenario_US09(HashMap<String, String[]> individualMap, HashMap<String, String[]> FamilyMap) throws ParseException{
        boolean result = false;
        FormatGEDCOM obj = new FormatGEDCOM();
        String keyf[] = new String[100];
        String valuef[] = new String[100];
        String keyi[] = new String[100];
        String valuei[] = new String[100];
        String valuec[] = new String[100];

        keyf = FamilyMap.keySet().toArray(new String[0]);
        keyi = individualMap.keySet().toArray(new String[0]);

        for (String fam : keyf) {
            valuef = FamilyMap.get(fam);
            String wifeId = valuef[4];
            String childID[] = valuef[6].trim().split(" ");
            valuei = individualMap.get(wifeId);

            if (valuei[5] != null) {
                if (!valuei[5].equals("NA")) {
                    Date deathDate = obj.StringtoDate(valuei[5]);
                    // System.out.println(deathDate);
                    int l = childID.length - 1; // no. of children

                    while (l >=0) {

                        valuec = individualMap.get(childID[l]);

                            Date birthdate = obj.StringtoDate(valuec[2]);
                            if (birthdate.after(deathDate)) {
                                int errorline=issueLine.GetLineNumber_Individual(childID[l],valuec[2]);
                                error.FamilyAndIndividualTableErrorMessages(" Child born after parents died", childID[l], fam, "UserStory09",errorline);
                                result = true;
                            }


                        l--;
                    }

                }
            }

        }
        for (String fam : keyf) {
            valuef = FamilyMap.get(fam);
            String husbandId = valuef[2];
            String childID[] = valuef[6].trim().split(" ");
            valuei = individualMap.get(husbandId);

            if (valuei[5] != null) {
                if (!valuei[5].equals("NA")) {
                    Date deathDate = obj.StringtoDate(valuei[5]);
                    // System.out.println(deathDate);
                    int l = childID.length - 1; // no. of children
                    while (l >=0) {

                        valuec = individualMap.get(childID[l]);
                        Date birthdate = obj.StringtoDate(valuec[2]);
                        if (birthdate.after(deathDate) && DateComparison .getDifferenceOfDates(deathDate,birthdate)!=0) {
                            int errorline=issueLine.GetLineNumber_Individual(childID[l],valuec[2]);
                            error.FamilyAndIndividualTableErrorMessages(" Child born after parents died", childID[l], fam, "US09",errorline);
                            result = true;
                        }

                        l--;
                    }

                }
            }

        }


        return result;
	}

	public boolean BirthOfParentsWithChildBirthScenario_US08(HashMap<String, String[]> individualMap,
			HashMap<String, String[]> FamilyMap) throws ParseException {
		boolean result = false;
        FormatGEDCOM obj = new FormatGEDCOM();

		/*
		 * obj.printTable(); HashMap<String, String[]> individualMap =
		 * obj.getIndividualMap(); HashMap<String, String[]> FamilyMap =
		 * obj.getFamilyMap();
		 */
		String key[] = new String[100];
		String value[] = new String[100];
		String keyi[] = new String[100];
		String valuei[] = new String[100];

		key = FamilyMap.keySet().toArray(new String[0]);
		keyi = individualMap.keySet().toArray(new String[0]);

		// NAME,GENDER,BIRTHDAY,AGE,ALIVE,DEATH,CHILD,SPOUSE
		// familyValues = new String[]{marriageDate, divorseDate, husbandID,
		// husbandName, wifeID, wifeName, childID}
		for (String famvalues : key) {
			value = FamilyMap.get(famvalues);
			if (!value[1].equals("NA")) {

				Date marriageDate = obj.StringtoDate(value[0]); // changed to
																// divorse date

				String childID[] = value[6].split(" ");
				int l = childID.length - 1; // no. of children
				while (l > 0) {
					if (l % 2 != 0) {

						valuei = individualMap.get(childID[l]);
						Date birthdate = obj.StringtoDate(valuei[2]);
						if (marriageDate.before(birthdate)) {
						    int errorline=issueLine.GetLineNumber_Individual(childID[l],valuei[2]);

							error.FamilyAndIndividualTableErrorMessages(" Child born after divorce", childID[l], famvalues, "UserStory08",errorline);
							result = true;
						}
					}
					l--;
				}
			}

		}
		return result;

	}
    public static int getDifferenceOfDates(Date from, Date to){

        Calendar c1 = Calendar.getInstance();
        c1.setTime(from);

        Calendar c2 = Calendar.getInstance();
        c1.setTime(to);

        int y1= c1.get(Calendar.YEAR);
        int m1 = c1.get(Calendar.MONTH);
        int y2= c2.get(Calendar.YEAR);
        int m2 = c2.get(Calendar.MONTH);

        if(y2>y1){
            return 0;
        }
        else if(y1==y2 && m2-m1>9){
            return 0;
        }
        else
            return 1;


    }

}
