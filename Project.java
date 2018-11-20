import java.text.ParseException;

public class Project {
    public static void main(String[] args) throws ParseException {
        ListOfPeople listOfPeople=new ListOfPeople();
        FormatGEDCOM formatGEDCOM = new FormatGEDCOM();
        formatGEDCOM.GedcomTable();
        formatGEDCOM.printTable();
        //Error printing
        System.out.println("\n\033[0;1m\033[0;4mERRORS IN GEDCOM FILE\033[0;0m");
        Sprint3 sprint3=new Sprint3();
        sprint3.Sprint3();
        US11_US14 us11_us14=new US11_US14();
        ParentsAgeAndSiblings parentsAgeAndSiblings=new ParentsAgeAndSiblings();
        us11_us14.multipleBirths(formatGEDCOM.getIndividualMap());
        us11_us14.noBigamy(formatGEDCOM.getFamilyMap());
        parentsAgeAndSiblings.checkParentsAgeDifference(formatGEDCOM.getIndividualMap(),formatGEDCOM.getFamilyMap());
        parentsAgeAndSiblings.LessSiblings(formatGEDCOM.getFamilyMap());


        //List Printing
        System.out.println("\n\033[0;1m\033[0;4mDIFFERENT LISTS FROM GEDCOM FILE\033[0;0m\n");
        listOfPeople.UpcomingBday_US38(formatGEDCOM.getIndividualMap());
        listOfPeople.recentBirths_US35(formatGEDCOM.getIndividualMap());
        listOfPeople.recentDeaths_US36(formatGEDCOM.getIndividualMap());
        listOfPeople.ListLiving_US30(formatGEDCOM.getFamilyMap(), formatGEDCOM.getIndividualMap());
        listOfPeople.listDeceased_US29(formatGEDCOM.getIndividualMap());
        listOfPeople.recentSurvivors_US37(formatGEDCOM.getIndividualMap());
        listOfPeople.UpAnniv_39(formatGEDCOM.getFamilyMap());
        listOfPeople.StillSingle_US31(formatGEDCOM.getIndividualMap());
        listOfPeople.MultipleBirths_US32(formatGEDCOM.getIndividualMap());
    }
}
