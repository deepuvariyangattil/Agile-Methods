import java.text.ParseException;

public class Sprint1 {
    public static void main(String[] args) throws ParseException {
        UserStory4UserStory5 deepu = new UserStory4UserStory5();
        US31_US32 nisheet = new US31_US32();
        UserStory18 deepu_Extra = new UserStory18();
        UserStory07 vedant = new UserStory07();
        US1_US2 susheel = new US1_US2();
        System.out.println("Deepu's User story Error messages printing");
        deepu.MarriageBeforeDivorce_US4();
        deepu.MarriageBeforeDeath_US5();
        System.out.println("\n\nNisheet's user story Error messages printing\n");
        nisheet.StillSingle_US31();
        nisheet.MultipleBirths_US32();
        System.out.println("\n\nDeepu's extra user story Error messages printing\n");
        deepu_Extra.FindSiblingSpouse_US18();
        System.out.println("Vedant's user story Error messages printing");
        vedant.ageLessThan150_US07();
        System.out.println("\nSusheel's user story(Rewritten by Deepu) Error messages printing\n");
        susheel.checkDatesWithToday();
        susheel.checkMarriageWithBirth();
    }
}
