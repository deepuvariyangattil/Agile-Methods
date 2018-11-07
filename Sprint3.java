import java.text.ParseException;

public class Sprint3 {
    public static void main(String[] args) throws ParseException {
        Sprint2 sprint2=new Sprint2();
        sprint2.Sprint2();
        GenderCorrectness_US21 deepu_us21=new GenderCorrectness_US21();
        ListOfPeople listOfPeople=new ListOfPeople();
        uniqueChildInFamily vedant=new uniqueChildInFamily();
        DateComparison susheel=new DateComparison();
        FormatGEDCOM formatGEDCOM=new FormatGEDCOM();
        formatGEDCOM.GedcomTable();
        System.out.println("\033[0;1mSprint 3 User stories");
        System.out.println("\nDeepu's sprint 3 user stories\n");
        deepu_us21.CorrectGender_US21(formatGEDCOM.getFamilyMap(),formatGEDCOM.getIndividualMap());
        listOfPeople.ListLiving_US30(formatGEDCOM.getFamilyMap(),formatGEDCOM.getIndividualMap());
        System.out.println("\nVedant's sprint 3 user stories\n");
        listOfPeople.listDeceased_US29(formatGEDCOM.getIndividualMap());
        vedant.uniqueChild_US25(formatGEDCOM.getFamilyMap(),formatGEDCOM.getIndividualMap());
        System.out.println("\nNisheet's sprint 3 user stories\n");
        listOfPeople.recentSurvivors_US37(formatGEDCOM.getIndividualMap());
        listOfPeople.UpAnniv_39(formatGEDCOM.getFamilyMap());
        System.out.println("\nSusheel's sprint 3 user stories\n");
        susheel.BirthOfParentsWithChildBirthScenario_US08(formatGEDCOM.getIndividualMap(),formatGEDCOM.getFamilyMap());
        susheel.DeathOfParentsWithChildBirthScenario_US09(formatGEDCOM.getIndividualMap(),formatGEDCOM.getFamilyMap());



    }
}
