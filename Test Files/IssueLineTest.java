import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class IssueLineTest {
    IssueLine issueLine=new IssueLine();
    @Test
    public void getLineNumber_Individual() {

        int result;
        result=issueLine.GetLineNumber_Individual("I1","M");
        Assert.assertEquals(7,result);
        result=issueLine.GetLineNumber_Individual("I30","Amir/Khan/");
        Assert.assertEquals(284,result);
    }

    @Test
    public void getLineNumber_Family() {
        int result;
        result=issueLine.GetLineNumber_Family("F0","I22");
        Assert.assertEquals(677,result);
        result=issueLine.GetLineNumber_Family("F1","11-03-2000");
        Assert.assertEquals(0,result);


    }
}