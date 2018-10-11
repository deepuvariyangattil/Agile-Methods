import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

public class UserStoryTest {
    FormatGEDCOM formatGEDCOM=new FormatGEDCOM();


    @Before
    public void init()
    {

        formatGEDCOM.GedcomTable();

    }
    @Test
    public void HashmapValidation() throws ParseException {

       UserStory4UserStory5 us=new UserStory4UserStory5();
       Date married,divorce;

        String[] a;
        for(String s:formatGEDCOM.getFamilyMap().keySet())
        {
            a=formatGEDCOM.getFamilyMap().get(s);
            Assert.assertNotNull(a[2]);
            Assert.assertNotNull(a[3]);
            Assert.assertNotNull(a[4]);
            Assert.assertNotNull(a[5]);
            Assert.assertNotEquals(a[3],0,a[3].length());
            Assert.assertNotEquals(a[5],0,a[3].length());
            Assert.assertEquals(a[0],10,a[0].length());
            if(a[1].length()==2)
            {
                Assert.assertEquals(a[1],2,a[1].length());
            }
            else
            {
                Assert.assertEquals(a[1],10,a[1].length());
            }
        }
        for(String s:formatGEDCOM.getIndividualMap().keySet())
        {
            a=formatGEDCOM.getIndividualMap().get(s);
            Assert.assertEquals(a[2],10,a[2].length());
            Assert.assertNotNull(a[0]);
            Assert.assertNotNull(a[1]);
            Assert.assertNotEquals(a[0],0,a[0].length());

            if(a[5].length()==2)
            {
                Assert.assertEquals(a[5],2,a[5].length());
            }
            else
            {
                Assert.assertEquals(a[5],10,a[5].length());
            }
        }
        Assert.assertNotNull(formatGEDCOM.getFamilyMap());
        Assert.assertNotNull(formatGEDCOM.getIndividualMap());


    }


}