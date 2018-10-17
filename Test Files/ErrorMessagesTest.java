import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ErrorMessagesTest {

    @Test
    public void familyTableErrorMessages() {
        boolean b=new ErrorMessages().FamilyTableErrorMessages("Data is not correct","F6","User Story15");
        Assert.assertTrue(b);
    }

    @Test
    public void individualTableErrorMessages() {
        boolean b=new ErrorMessages().IndividualTableErrorMessages("Data is wrong","I1","User Story 20");
        Assert.assertTrue(b);
    }

    @Test
    public void familyAndIndividualTableErrorMessages() {
        boolean b=new ErrorMessages().FamilyAndIndividualTableErrorMessages("Data to be corrected","I5","F7","UserStory24");
        Assert.assertTrue(b);
    }
}