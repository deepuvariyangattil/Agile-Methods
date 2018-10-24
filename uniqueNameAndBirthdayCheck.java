package com.VedantSoni;
import java.text.ParseException;
import java.util.HashMap;

public class uniqueNameAndBirthdayCheck {

    private FormatGEDCOM formatGEDCOM = new FormatGEDCOM();

    public uniqueNameAndBirthdayCheck(){}

    public boolean uniqueNameandBirthday_US23(HashMap<String, String[]>individual, HashMap<String, String[]>individual1) throws ParseException {
        formatGEDCOM.GedcomTable();
        HashMap<String, String[]> Individual = formatGEDCOM.getIndividualMap();
        ErrorMessages em = new ErrorMessages();

        String[] indiValues = new String[100];
        String[] indiValues1 = new String[100];
        Boolean output=false;

        for (String s : Individual.keySet()) {
            indiValues = Individual.get(s);

            for (String s1 : Individual.keySet()) {
                indiValues1 = Individual.get(s1);

                for (int i = 0; i < indiValues.length; i++) {

                    for (int j = i + 1; j < indiValues1.length; j++) {

                           for (int k = 0; k < indiValues.length; k++) {

                                for (int l = k + 1; l < indiValues1.length; l++) {

                                    if (indiValues[0].equals(indiValues1[0]) && indiValues[i].equals(indiValues1[j])){

                                    if (indiValues[2].equals(indiValues1[2]) && indiValues[k].equals(indiValues1[l])) {

                                        em.IndividualTableErrorMessages("Name and birthdate are the same",s,"US23");

                                    }output = true;


                                }


                            }
                        }

                    }


                }

            }
        }return output;
    }
}