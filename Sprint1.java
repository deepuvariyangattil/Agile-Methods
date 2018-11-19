import java.text.ParseException;

public class Sprint1 {
    public  void sprint1() throws ParseException {
        FormatGEDCOM formatGEDCOM=new FormatGEDCOM();
        formatGEDCOM.GedcomTable();

        UserStory4UserStory5 deepu = new UserStory4UserStory5();

        UserStory18 deepu_Extra = new UserStory18();
        UserStory07 vedant = new UserStory07();
        US1_US2 susheel = new US1_US2();

        //System.out.println("\nSprint 1 & 2 User stories output\n");
        deepu.MarriageBeforeDivorce_US4(formatGEDCOM.getFamilyMap());
        deepu.MarriageBeforeDeath_US5(formatGEDCOM.getFamilyMap(),formatGEDCOM.getIndividualMap());
        //System.out.println("\n");

        //System.out.println("\n");
        deepu_Extra.FindSiblingSpouse_US18(formatGEDCOM.getFamilyMap(),formatGEDCOM.getIndividualMap());

        vedant.ageLessThan150_US07(formatGEDCOM.getIndividualMap());
        //System.out.println("\n");
        susheel.checkDatesWithToday(formatGEDCOM.getFamilyMap(),formatGEDCOM.getIndividualMap());
        susheel.checkMarriageWithBirth(formatGEDCOM.getFamilyMap(),formatGEDCOM.getIndividualMap());
        //System.out.println("Sprint 2\n");

    }
}
