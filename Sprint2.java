
import java.text.ParseException;


public class Sprint2 {

    public void Sprint2() throws ParseException {
        Sprint1 sprint1=new Sprint1();
        MarriageAfter14AndSameLastNameCheck_US10US16 deepu_sprint2=new MarriageAfter14AndSameLastNameCheck_US10US16();
       FormatGEDCOM formatGEDCOM=new FormatGEDCOM();
       formatGEDCOM.GedcomTable();

       sprint1.sprint1();

        deepu_sprint2.MarriageAfterFourteen_US10(formatGEDCOM.getFamilyMap(),formatGEDCOM.getIndividualMap());
       deepu_sprint2.MaleLastNamesSameInFamily_US16(formatGEDCOM.getFamilyMap(),formatGEDCOM.getIndividualMap());

       uniqueIndividualAndFamilyIDCheck vedant_sprint2_US22=new uniqueIndividualAndFamilyIDCheck();
        vedant_sprint2_US22.uniqueIDCheck("C:\\Users\\DEEPUAISHU\\IdeaProjects\\Sprint2\\src\\Deepu_Variyangattil.ged");
       uniqueNameAndBirthdayCheck vedant_sprint2_US23=new uniqueNameAndBirthdayCheck();
        vedant_sprint2_US23.uniqueNameandBirthday_US23(formatGEDCOM.getIndividualMap());

        PersonBeforeDeathScenario susheel_sprint2=new PersonBeforeDeathScenario();
        susheel_sprint2.checkBirthBeforeDeath(formatGEDCOM.getIndividualMap());
        susheel_sprint2.checkMarriageBeforeDivorse(formatGEDCOM.getIndividualMap(),formatGEDCOM.getFamilyMap());

        OrphanAndLargeAge_US33US34 nisheet_Sprint2=new OrphanAndLargeAge_US33US34();
       nisheet_Sprint2.orphans(formatGEDCOM.getIndividualMap(),formatGEDCOM.getFamilyMap());
        nisheet_Sprint2.largeAgeD(formatGEDCOM.getIndividualMap());

    }
}
