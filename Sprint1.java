import java.text.ParseException;

public class Sprint1 {
    public  void sprint1() throws ParseException {
        UserStory4UserStory5 deepu = new UserStory4UserStory5();
        US31_US32 nisheet = new US31_US32();
        UserStory18 deepu_Extra = new UserStory18();
        UserStory07 vedant = new UserStory07();
        US1_US2 susheel = new US1_US2();
        //MarriageAfter14AndSameLastNameCheck_US10US16 deepu_sprint2=new MarriageAfter14AndSameLastNameCheck_US10US16();
        //FormatGEDCOM formatGEDCOM=new FormatGEDCOM();
        //formatGEDCOM.GedcomTable();
        System.out.println("\nSprint 1 User stories output\n");
        deepu.MarriageBeforeDivorce_US4();
        deepu.MarriageBeforeDeath_US5();
        System.out.println("\n");
        nisheet.StillSingle_US31();
        nisheet.MultipleBirths_US32();
        System.out.println("\n");
        deepu_Extra.FindSiblingSpouse_US18();

        vedant.ageLessThan150_US07();
        System.out.println("\n");
        susheel.checkDatesWithToday();
        susheel.checkMarriageWithBirth();
        //System.out.println("Sprint 2\n");
        //deepu_sprint2.MarriageAfterFourteen_US10(formatGEDCOM.getFamilyMap(),formatGEDCOM.getIndividualMap());
        //deepu_sprint2.MaleLastNamesSameInFamily_US16(formatGEDCOM.getFamilyMap(),formatGEDCOM.getIndividualMap());
    }
}
