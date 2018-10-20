package com.VedantSoni;

import java.text.ParseException;
import java.util.HashMap;

public class UserStrory23 {

    private FormatGEDCOM formatGEDCOM = new FormatGEDCOM();

    public void uniqueNameandBirthday_US23() throws ParseException {
        formatGEDCOM.GedcomTable();
        HashMap<String, String[]> Individual = formatGEDCOM.getIndividualMap();
        String[] indiValues = new String[100];
        String[] indiValues1 = new String[100];


        for (String s : Individual.keySet()) {
            indiValues = Individual.get(s);

            for (String s1 : Individual.keySet()) {
                indiValues1 = Individual.get(s1);

                for (int i = 0; i < indiValues.length; i++) {

                    for (int j = i+1; j < indiValues1.length; j++) {

                        if (indiValues[0].equals(indiValues1[0])&& indiValues[i].equals(indiValues1[j])){

                            System.out.println("ERROR in Gedcom File " + indiValues[0] + " and " + indiValues1[0] + " have duplicate names");
                        }


                    }


                }
                for (int i = 0; i < indiValues.length; i++) {

                    for (int j = i+1; j < indiValues1.length; j++) {

                        if (indiValues[2].equals(indiValues1[2])&& indiValues[i].equals(indiValues1[j])){

                            System.out.println("ERROR in Gedcom File: Individual " + indiValues[0] + " has Duplicate Birthdate " + indiValues[2] + " and " + indiValues1[2] );
                        }


                    }


                }

            }
        }
    }
}