import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.HashMap;

public class UserStory07Test {

    @Test
    public void ageLessThan150_US07() throws ParseException {
        HashMap<String,String[]> indi=new HashMap<>();
        String[] individual1,individual2;
        individual1=new String[]{"George/Joe/", "M", "10-12-1786", "33", "True", "NA", "F2", "F1"};
        individual2=new String[]{"Sarah/Thomas/","F","02-05-1986","33","True","NA","F2","F1"};
        indi.put("I3",individual1);
        indi.put("I4",individual2);
        Assert.assertTrue(new UserStory07().ageLessThan150_US07(indi));
        indi.clear();
        individual1=new String[]{"George/Joe/", "M", "10-12-1986", "33", "True", "NA", "F2", "F1"};
        individual2=new String[]{"Sarah/Thomas/","F","02-05-1986","33","True","NA","F2","F1"};
        indi.put("I3",individual1);
        indi.put("I4",individual2);
        Assert.assertFalse(new UserStory07().ageLessThan150_US07(indi));

    }
}