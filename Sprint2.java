import java.text.ParseException;

public class Sprint2 {
    public static void main(String[] args) throws ParseException {
        Sprint1 sprint1=new Sprint1();
        MarriageAfter14AndSameLastNameCheck_US10US16 deepu_sprint2=new MarriageAfter14AndSameLastNameCheck_US10US16();
        FormatGEDCOM formatGEDCOM=new FormatGEDCOM();
        formatGEDCOM.GedcomTable();

        sprint1.sprint1();
        System.out.println("\033[0;1mSprint 2 User stories ouput\n");
        System.out.println("Deepu's User stories\n");
        deepu_sprint2.MarriageAfterFourteen_US10(formatGEDCOM.getFamilyMap(),formatGEDCOM.getIndividualMap());
        deepu_sprint2.MaleLastNamesSameInFamily_US16(formatGEDCOM.getFamilyMap(),formatGEDCOM.getIndividualMap());
        System.out.println("\nVedant's User stories\n");
        uniqueIndividualAndFamilyIDCheck vedant_sprint2_US22=new uniqueIndividualAndFamilyIDCheck();
        vedant_sprint2_US22.uniqueIDCheck("C:\\Users\\DEEPUAISHU\\IdeaProjects\\Sprint2\\src\\Deepu_Variyangattil.ged");
        uniqueNameAndBirthdayCheck vedant_sprint2_US23=new uniqueNameAndBirthdayCheck();
        vedant_sprint2_US23.uniqueNameandBirthday_US23(formatGEDCOM.getIndividualMap());
        System.out.println("\nSusheel's User stories\n");
        PersonBeforeDeathScenario susheel_sprint2=new PersonBeforeDeathScenario();
        susheel_sprint2.checkBirthBeforeDeath(formatGEDCOM.getIndividualMap());
        susheel_sprint2.checkMarriageBeforeDivorse(formatGEDCOM.getIndividualMap(),formatGEDCOM.getFamilyMap());
        System.out.println("\nNisheet's User stories\n");
        OrphanAndLargeAge_US33US34 nisheet_Sprint2=new OrphanAndLargeAge_US33US34();
        nisheet_Sprint2.orphans(formatGEDCOM.getIndividualMap(),formatGEDCOM.getFamilyMap());
        nisheet_Sprint2.largeAgeD(formatGEDCOM.getIndividualMap());

    }
}
