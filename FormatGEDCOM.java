/*
Name: Deepu Variyangattil, Nisheet Thakur, Sushil Saladi, Vedant Soni
Group: Group 5
Github Link: https://github.com/deepuvariyangattil/Agile-Methods/blob/master/FormatGEDCOM.java
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeMap;


public class FormatGEDCOM {
    private HashMap<String, String[]> individualMap = new HashMap<>();
    private HashMap<String, String[]> FamilyMap = new HashMap<>();
    private TreeMap<String, String[]> individual_ErrorLine = new TreeMap<>();
    private TreeMap<String, String[]> family_ErrorLine = new TreeMap<>();

    /*
    FindDate function used to convert input date into desired format
    */
    private static String findDate(String dateString) throws ParseException {
        Date date = new Date();
        String formattedDate;
        date = new SimpleDateFormat("ddMMMyyyy").parse(dateString);
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        formattedDate = dateFormat.format(date);
        return formattedDate;

    }

    //Finding correct tag and level match for individual
    private static boolean keywordMatcherFamily(String level, String tag) {
        String[] validKeyWords_2 = new String[100];
        if (level.equalsIgnoreCase("1")) {
            validKeyWords_2 = new String[]{"HUSB", "WIFE", "MARR", "CHIL", "DIV"};
        } else {
            validKeyWords_2 = new String[]{"DATE"};
        }
        boolean result = true;

        for (String iterate : validKeyWords_2) {
            if (iterate.equalsIgnoreCase(tag)) {
                result = true;
                break;
            } else {
                result = false;
            }


        }
        return result;
    }

    //Finding correct tag and level match for family
    private static boolean keywordMatcher(String level, String tag) {

        String[] validKeyWords_2 = new String[100];
        if (level.equalsIgnoreCase("1")) {
            validKeyWords_2 = new String[]{"NAME", "BIRT", "SEX", "DEAT", "FAMS", "FAMC"};
        } else {
            validKeyWords_2 = new String[]{"DATE"};
        }
        boolean result = true;

        for (String iterate : validKeyWords_2) {
            if (iterate.equalsIgnoreCase(tag)) {
                result = true;
                break;
            } else {
                result = false;
            }


        }
        return result;
    }

    public TreeMap<String, String[]> getIndividual_ErrorLine() {
        return individual_ErrorLine;
    }

    public TreeMap<String, String[]> getFamily_ErrorLine() {
        return family_ErrorLine;
    }

    public HashMap<String, String[]> getIndividualMap() {
        return individualMap;
    }

    public HashMap<String, String[]> getFamilyMap() {
        return FamilyMap;
    }

    public Date StringtoDate(String stringDate) throws ParseException {
        Date mDate = new Date();
        mDate = new SimpleDateFormat("dd-MM-yyyy").parse(stringDate);
        return mDate;

    }

    public void GedcomTable() {

        String filedata = "";
        String filePath;
        filePath = "C:\\Users\\DEEPUAISHU\\IdeaProjects\\Sprint3\\src\\Deepu_Variyangattil.ged";
        CharSequence charSequenceIndividual = "INDI";
        CharSequence charSequenceFamily = "FAM";
        //CharSequence charSequenceChild = "FAMC";

        String[] lineArray = new String[1000];
        String[] lineArray2 = new String[1000];
        String[] familyArray1 = new String[100];
        String[] familyArray2 = new String[100];
        String[] values;
        String individualID = null, date, name, sex = null;
        String birthDate = "";
        String deathDate = "";

        String alive = "False";
        String individualID_Old = "";
        String spouse = "";
        String child = "";
        int count = 0;
        int familyCount = 0;
        String familyID = null;
        String husbandName = null;
        String wifeName = null;
        String husbandID = null;
        String wifeID = null;
        String childID = "";
        int dateField = 0;
        int familyDatePick = 0;
        String marriageDate = null;
        String divorseDate = null;
        boolean keywordMatch_2;
        String[] familyValues;
        date = "";
        name = "";
        Date dateBir;
        Date dateDet;
        int age = 0;
        dateBir = new Date();
        dateDet = new Date();

        //Error line map variables declaration starts here
        int lineNumber = 0;
        String[] lineArray_Error = new String[1000];
        String[] lineArray2_Error = new String[1000];
        String[] familyArray1_Error = new String[100];
        String[] familyArray2_Error = new String[100];
        String[] values_Error;
        String individualID_Error = " ", date_Error, name_Error, sex_Error = null;
        String birthDate_Error = "";
        String deathDate_Error = "";
        String alive_Error = "False";
        String individualID_Old_Error = "";
        String spouse_Error = "";
        String child_Error = "";
        int count_Error = 0;
        int familyCount_Error = 0;
        String familyID_Error = null;
        String husbandName_Error = null;
        String wifeName_Error = null;
        String husbandID_Error = null;
        String wifeID_Error = null;
        String childID_Error = "";
        int dateField_Error = 0;
        int familyDatePick_Error = 0;
        String marriageDate_Error = null;
        String divorseDate_Error = null;
        boolean keywordMatch_2_Error;
        String[] familyValues_Error;
        date_Error = "";
        name_Error = "";
        Date dateBir_Error;
        Date dateDet_Error;
        int age_Error = 0;
        dateBir_Error = new Date();
        dateDet_Error = new Date();
        //Error line map variables declaration ends here
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        try {
            while ((filedata = bufferedReader.readLine()) != null) {

                lineNumber++;

                values = new String[]{name, sex, birthDate, Integer.toString(age), alive, deathDate, child, spouse};
                if(individualID!=null){
                    values_Error = new String[]{name,name_Error,sex, sex_Error,birthDate, birthDate_Error, Integer.toString(age), alive, deathDate,deathDate_Error,child, child_Error,spouse, spouse_Error,individualID.replace("@", "").trim(),individualID_Error.replace("@", "").trim()};
                }
                else
                {
                    values_Error = new String[]{name,name_Error,sex, sex_Error,birthDate, birthDate_Error, Integer.toString(age), alive, deathDate,deathDate_Error,child, child_Error,spouse, spouse_Error,individualID,individualID_Error.replace("@", "").trim()};
                }

                //Printing Last individual member in GEDCOM file
                if (filedata.contains(charSequenceFamily) && filedata.startsWith("0")) {
                    count = 0;
                    //Checking individual count is less than 5000
                    if (individualMap.size() < 5000) {
                        individualMap.put(individualID.replace("@", "").trim(), values);
                        individual_ErrorLine.put(individualID.replace("@", "").trim(), values_Error);
                    }

                }

                if (filedata.contains(charSequenceIndividual)) {


                    if (individualID != null) {
                        //Checking individual count is less than 5000
                        if (individualMap.size() < 5000) {
                            individualMap.put(individualID.replace("@", "").trim(), values);
                            individual_ErrorLine.put(individualID.replace("@", "").trim(), values_Error);
                        }

                    }

                    individualID_Old = individualID;
                    individualID = "";
                    name = "";
                    name_Error = "";
                    sex = "";
                    sex_Error = "";
                    birthDate = "";
                    birthDate_Error = "";
                    age = 0;
                    age_Error = 0;
                    alive = "";
                    alive_Error = "";
                    deathDate = "";
                    deathDate_Error = "";

                    count = 0;
                    count_Error = 0;
                    dateField = 0;
                    dateField_Error = 0;
                    dateBir = new Date();
                    dateBir_Error = new Date();
                    date = "";
                    spouse = "";
                    child = "";
                    date_Error = "";
                    spouse_Error = "";
                    child_Error = "";
                    // Identifiying individual ID and keeping it as Hashmap key.

                    dateDet = new Date();
                    lineArray = filedata.split(" ");
                    individualID = lineArray[1];
                    individualID_Error = individualID + "_" + lineNumber;

                    count = 1;
                    count_Error = 1;


                } else if (filedata.contains(charSequenceIndividual) == false && count == 1) {
                    lineArray2 = filedata.split(" ");
                    //Calculating date fields and age.
                    if (lineArray2[0].equalsIgnoreCase("2")) {
                        keywordMatch_2 = keywordMatcher(lineArray2[0], lineArray2[1]);
                        if (keywordMatch_2) {

                            for (int i = 2; i <= lineArray2.length - 1; i++)
                                date += lineArray2[i];

                            if (dateField == 1) {
                                birthDate = date;
                                date = "";
                                dateBir = new SimpleDateFormat("ddMMMyyyy").parse(birthDate);
                                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                                birthDate = dateFormat.format(dateBir);
                                birthDate_Error = birthDate + "_" + lineNumber;

                                int birthYear = dateBir.getYear();

                                int currentYear = dateDet.getYear();
                                age = currentYear - birthYear;
                                alive = "True";
                                deathDate = "NA";


                            } else if (dateField == 2) {
                                deathDate = date;
                                date = "";
                                //Calculating death date.
                                dateDet = new SimpleDateFormat("ddMMMyyyy").parse(deathDate);
                                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                                deathDate = dateFormat.format(dateDet);
                                deathDate_Error = deathDate + "_" + lineNumber;
                                int birthYear = dateBir.getYear();
                                int deathYear = dateDet.getYear();
                                age = deathYear - birthYear;
                                alive = "False";


                            }


                        }
                    } else if (lineArray2[0].equalsIgnoreCase("1")) {
                        //Finding individual attributes such as Name, Sex,Spouse ID, children IDs
                        keywordMatch_2 = keywordMatcher(lineArray2[0], lineArray2[1]);
                        if (keywordMatch_2) {
                            if (lineArray2[1].equalsIgnoreCase("BIRT")) {
                                dateField = 1;
                            } else if (lineArray2[1].equalsIgnoreCase("DEAT")) {
                                dateField = 2;
                            } else if (lineArray2[1].equalsIgnoreCase("NAME")) {
                                for (int i = 2; i < lineArray2.length; i++) {
                                    name = name + lineArray2[i];
                                }
                                name_Error = name + "_" + lineNumber;

                            } else if (lineArray2[1].equalsIgnoreCase("SEX")) {
                                sex = lineArray2[2];
                                sex_Error = sex + "_" + lineNumber;

                            } else if (lineArray2[1].equalsIgnoreCase("FAMS")) {
                                String spouseArray[] = new String[100];
                                String spouseArray_Error[] = new String[100];
                                spouseArray = filedata.split(" ");

                                spouse = spouse + " " + spouseArray[2].replace("@", "").trim();
                                spouse_Error = spouse_Error + " " + spouseArray[2].replace("@", "").trim() + "_" + lineNumber;


                            } else if (lineArray2[1].equalsIgnoreCase("FAMC")) {
                                String childArray[] = new String[100];
                                childArray = filedata.split(" ");
                                child = child + " " + childArray[2].replace("@", "").trim();
                                child_Error = child_Error + " " + childArray[2].replace("@", "").trim() + "_" + lineNumber;
                            }

                        }
                    }
                }
                //Forming Family table
                else if ((filedata.contains(charSequenceFamily) && filedata.startsWith("0")) || filedata.contains("TRLR")) {
                    familyValues = new String[]{marriageDate, divorseDate, husbandID, husbandName, wifeID, wifeName, childID};
                    familyValues_Error = new String[]{marriageDate,marriageDate_Error,divorseDate, divorseDate_Error,husbandID, husbandID_Error,husbandName, husbandName_Error,wifeID, wifeID_Error,wifeName, wifeName_Error,childID, childID_Error,familyID,familyID_Error};
                    familyArray1 = filedata.split(" ");


                    if (familyID != null) {
                        //Checking family count is less than 1000
                        if (FamilyMap.size() < 1000) {
                            FamilyMap.put(familyID, familyValues);
                            family_ErrorLine.put(familyID, familyValues_Error);
                        }

                    }

                    childID = "";
                    husbandName = "";
                    wifeName = "";
                    husbandID = "";
                    wifeID = "";
                    marriageDate = "";
                    divorseDate = "";
                    familyCount = 1;
                    date = "";
                    //Line number hashmap for family variable declaration starts here
                    childID_Error = "";
                    husbandName_Error = "";
                    wifeName_Error = "";
                    husbandID_Error = "";
                    wifeID_Error = "";
                    marriageDate_Error = "";
                    divorseDate_Error = "";
                    familyCount_Error = 1;
                    date_Error = "";
                    //Line number hashmap for family variable declaration ends here
                    //Finding family ID
                    familyID = familyArray1[1].replace("@", "").trim();
                    familyID_Error = familyID + "_" + lineNumber;
                    //Finding family attributes
                } else if (filedata.contains(charSequenceFamily) == false && familyCount == 1) {
                    familyArray2 = filedata.split(" ");
                    if (keywordMatcherFamily(familyArray2[0], familyArray2[1])) {
                        if (familyArray2[1].equalsIgnoreCase("HUSB")) {
                            husbandID = familyArray2[2].replace("@", "").trim();
                            husbandID_Error = husbandID + "_" + lineNumber;
                            if (individualMap.containsKey(husbandID)) {
                                husbandName = individualMap.get(husbandID)[0];
                                husbandName_Error = husbandName + "_" + lineNumber;
                            } else {
                                husbandName = "";
                            }
                        } else if (familyArray2[1].equalsIgnoreCase("WIFE")) {
                            wifeID = familyArray2[2].replace("@", "").trim();
                            wifeID_Error = wifeID + "_" + lineNumber;
                            if (individualMap.containsKey(wifeID)) {
                                wifeName = individualMap.get(wifeID)[0];
                                wifeName_Error = wifeName + "_" + lineNumber;
                            } else {
                                wifeName = "";
                            }
                        } else if (familyArray2[1].equalsIgnoreCase("CHIL")) {
                            childID = childID + " " + familyArray2[2].replace("@", "").trim();
                            childID_Error = childID_Error + " " + familyArray2[2].replace("@", "").trim() + "_" + lineNumber;


                        } else if (familyArray2[1].equalsIgnoreCase("MARR")) {
                            familyDatePick = 1;
                        } else if (familyArray2[1].equalsIgnoreCase("DIV")) {
                            familyDatePick = 2;
                        } else if (familyArray2[1].equalsIgnoreCase("DATE")) {
                            for (int i = 2; i <= familyArray2.length - 1; i++)
                                date += familyArray2[i];
                            //System.out.println(date);
                            if (familyDatePick == 1) {
                                marriageDate = "";
                                marriageDate = findDate(date);
                                marriageDate_Error = marriageDate + "_" + lineNumber;
                                //System.out.println(marriageDate);
                                divorseDate = "NA";
                                date = "";
                            }
                            if (familyDatePick == 2) {
                                divorseDate = "";
                                divorseDate = findDate(date);
                                divorseDate_Error = divorseDate + "_" + lineNumber;

                            }

                        }

                    }

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //Closing file readers.
        try {
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //printTable();

    }

    public void printTable() {
        String[] temp = new String[100];
        String[] set = new String[1000];
        set = individualMap.keySet().toArray(new String[0]);


        //Printing hashmaps data in tabular format.
        System.out.println("\n\033[0;1m\033[0;4m Individual\033[0;0m\n");
        System.out.println("ID           NAME               GENDER     BIRTHDAY       AGE       ALIVE         DEATH      CHILD      SPOUSE");
        System.out.println("==       ============           ======      ========      ===       =====        ========    =====      ======");

        for (String iterator_Key : set) {
            if (iterator_Key != null) {
                temp = individualMap.get(iterator_Key);


                if (iterator_Key.length() == 2) {
                    System.out.println(String.format("%1s%20s%14s%16s%8s%12s%17s%7s%14s", iterator_Key, temp[0], temp[1], temp[2], temp[3],
                            temp[4], temp[5], temp[6], temp[7]));
                } else if (iterator_Key.length() == 3) {
                    System.out.println(String.format("%1s%19s%14s%16s%8s%12s%17s%7s%14s", iterator_Key, temp[0], temp[1], temp[2], temp[3],
                            temp[4], temp[5], temp[6], temp[7]));
                }


            }
        }

//Family Data Printing
        set = FamilyMap.keySet().toArray(new String[0]);

        System.out.println("\n\n\n\033[0;1m\033[0;4mFamily\033[0;0m\n");
        System.out.println("ID    MARRIED         DIVORCED     HUSBANDID            HUSBANDNAME             WIFEID          WIFENAME        CHILDREN");
        System.out.println("==    =======         ========      =========           ===========             ======          ========        ========");

        for (String iterator_Key : set) {
            if (iterator_Key != null) {
                // temp = FamilyMap.get(iterator_Key);
                temp = FamilyMap.get(iterator_Key);
                if (iterator_Key.length() == 2) {
                    System.out.println(String.format("%1s%14s%14s%14s%25s%14s%21s%11s", iterator_Key, temp[0], temp[1], temp[2], temp[3],
                            temp[4], temp[5], temp[6]));
                } else if (iterator_Key.length() == 3) {
                    System.out.println(String.format("%1s%13s%14s%14s%25s%14s%21s%11s", iterator_Key, temp[0], temp[1], temp[2], temp[3],
                            temp[4], temp[5], temp[6]));
                }


            }
        }

    }

    public void printTable_Error() {
        String[] temp = new String[100];
        String[] set = new String[1000];
        //set = individualMap.keySet().toArray(new String[0]);
        set = individual_ErrorLine.keySet().toArray(new String[0]);

        //Printing hashmaps data in tabular format.
        System.out.println("\n\n Individual\n\n");
        System.out.println("ID           NAME               GENDER     BIRTHDAY       AGE       ALIVE         DEATH      CHILD      SPOUSE");
        System.out.println("==       ============           ======      ========      ===       =====        ========    =====      ======");

        for (String iterator_Key : set) {
            if (iterator_Key != null) {
                //temp = individualMap.get(iterator_Key);
                temp = individual_ErrorLine.get(iterator_Key);
                //System.out.println("Iterator key length"+iterator_Key.length());
                if (iterator_Key.length() == 2) {
                    System.out.println(String.format("%1s%20s%14s%16s%8s%12s%17s%7s%14s%8s%12s%17s%7s%14s%14s%14s%14s", iterator_Key, temp[0], temp[1], temp[2], temp[3],
                            temp[4], temp[5], temp[6], temp[7],temp[8], temp[9], temp[10],temp[11], temp[12],temp[13],temp[14],temp[15]));
                } else if (iterator_Key.length() >= 3) {
                    System.out.println(String.format("%1s%19s%14s%16s%8s%12s%17s%7s%14s%8s%12s%17s%7s%14s%14s%14s%14s",iterator_Key, temp[0], temp[1], temp[2], temp[3],
                            temp[4], temp[5], temp[6], temp[7],temp[8], temp[9], temp[10],temp[11], temp[12],temp[13],temp[14],temp[15]));
                }


            }
        }

//Family Data Printing
        //set = FamilyMap.keySet().toArray(new String[0]);
        set = family_ErrorLine.keySet().toArray(new String[0]);
        System.out.println("\n\n\nFamily\n\n\n");
        System.out.println("ID    MARRIED         DIVORCED         HUSBANDID            HUSBANDNAME             WIFEID          WIFENAME        CHILDREN");
        System.out.println("==    =======         ========          =========           ===========             ======          ========        ========");

        for (String iterator_Key : set) {
            if (iterator_Key != null) {
                // temp = FamilyMap.get(iterator_Key);
                temp = family_ErrorLine.get(iterator_Key);
                //System.out.println("Iterator key length"+iterator_Key.length());
                if (iterator_Key.length() == 2) {
                    System.out.println(String.format("%1s%17s%16s%14s%25s%14s%21s%11s%16s%16s%14s%25s%14s%21s%11s", iterator_Key, temp[0], temp[1], temp[2], temp[3],
                            temp[4], temp[5], temp[6],temp[7], temp[8], temp[9],temp[10], temp[11], temp[12],temp[13]));
                } else if (iterator_Key.length() >= 3) {
                    System.out.println(String.format("%1s%16s%16s%14s%25s%14s%21s%11s%16s%16s%14s%25s%14s%21s%11s", iterator_Key, temp[0], temp[1], temp[2], temp[3],
                            temp[4], temp[5], temp[6],temp[7], temp[8], temp[9],temp[10], temp[11], temp[12],temp[13]));
                }


            }
        }

    }
}
