import org.junit.Assert;
import org.junit.Test;

import java.util.Vector;

public class ErrorMessagesTest {

    @Test
    public void familyTableErrorMessages() {
        boolean b=new ErrorMessages().FamilyTableErrorMessages("Data is not correct","F6","User Story15",100);
        Assert.assertTrue(b);
    }

    @Test
    public void individualTableErrorMessages() {
        boolean b=new ErrorMessages().IndividualTableErrorMessages("Data is wrong","I1","User Story 20",150);
        Assert.assertTrue(b);
    }

    @Test
    public void familyAndIndividualTableErrorMessages() {
        boolean b=new ErrorMessages().FamilyAndIndividualTableErrorMessages("Data to be corrected","I5","F7","UserStory24",200);
        Assert.assertTrue(b);
    }

    @Test
    public void listPrint() {
        Vector<String>list=new Vector<>(100);
        list.add("Hello");
        list.add("World");

        boolean b=new ErrorMessages().ListPrint("Data to be printed",list,"UserStoryXX");
        Assert.assertTrue(b);
    }
}