import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.HashMap;

import static org.junit.Assert.*;

public class UserStory4UserStory5Test {

    @Test
    public void marriageBeforeDivorce_US4() throws ParseException {
        HashMap<String,String[]>fam=new HashMap<>();
        String[] fami1;
        fami1=new String[]{"11-11-2018", "19-10-2017", "I1", "Peter/Joe/", "I2", "Anna/Thomas/", "I3 I4"};
        fam.put("F1",fami1);
        boolean output=new UserStory4UserStory5().MarriageBeforeDivorce_US4(fam);

        Assert.assertTrue(output);
        fam.clear();
        fami1=new String[]{"11-11-2017", "19-10-2018", "I1", "Peter/Joe/", "I2", "Anna/Thomas/", "I3 I4"};
        fam.put("F2",fami1);
        Assert.assertFalse(new UserStory4UserStory5().MarriageBeforeDivorce_US4(fam));


    }

    @Test
    public void marriageBeforeDeath_US5() throws ParseException {
        HashMap<String,String[]>indi=new HashMap<>();
        HashMap<String,String[]>fam=new HashMap<>();
        String[] individual1,individual2,fami1,famil2;
        individual1=new String[]{"George/Joe/", "M", "10-12-1986", "33", "False", "10-12-1999", "F2", "F1"};
        individual2=new String[]{"Sarah/Thomas/","F","02-05-1986","33","True","NA","F2","F1"};
        famil2=new String[]{"11-11-2018", "NA", "I3", "George/Joe/", "I4", "Sarah/Thomas/", "I5"};
        indi.put("I3",individual1);
        indi.put("I4",individual2);
        fam.put("F3",famil2);
        Assert.assertTrue(new UserStory4UserStory5().MarriageBeforeDeath_US5(fam,indi));
        indi.clear();
        fam.clear();
        individual1=new String[]{"George/Joe/", "M", "10-12-1986", "33", "False", "10-12-2090", "F2", "F1"};
        individual2=new String[]{"Sarah/Thomas/","F","02-05-1986","33","True","NA","F2","F1"};
        famil2=new String[]{"11-11-2018", "NA", "I3", "George/Joe/", "I4", "Sarah/Thomas/", "I5"};
        indi.put("I3",individual1);
        indi.put("I4",individual2);
        fam.put("F1",famil2);
        Assert.assertFalse(new UserStory4UserStory5().MarriageBeforeDeath_US5(fam,indi));


    }
}