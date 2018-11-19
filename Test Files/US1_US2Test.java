import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.HashMap;

public class US1_US2Test {

    @Test
    public void checkDatesWithToday() throws ParseException {
        HashMap<String,String[]> indi=new HashMap<>();
        HashMap<String,String[]>fam=new HashMap<>();
        String[] individual1,individual2,fami1,famil2;
        individual1=new String[]{"George/Joe/", "M", "10-12-2030", "33", "False", "10-12-2090", "F2", "F1"};
        individual2=new String[]{"Sarah/Thomas/","F","02-05-1986","33","True","NA","F2","F1"};
        famil2=new String[]{"11-11-2022", "11-11-2023", "I3", "George/Joe/", "I4", "Sarah/Thomas/", "I5"};
        indi.put("I3",individual1);
        indi.put("I4",individual2);
        fam.put("F1",famil2);
        Assert.assertTrue(new US1_US2().checkDatesWithToday(fam,indi));
        indi.clear();
        fam.clear();
        individual1=new String[]{"George/Joe/", "M", "10-12-2000", "33", "False", "10-12-2001", "F2", "F1"};
        individual2=new String[]{"Sarah/Thomas/","F","02-05-1986","33","True","NA","F2","F1"};
        famil2=new String[]{"11-11-2009", "11-11-2012", "I1", "George/Joe/", "I2", "Sarah/Thomas/", "I5"};
        indi.put("I1",individual1);
        indi.put("I2",individual2);
        fam.put("F2",famil2);
        Assert.assertFalse(new US1_US2().checkDatesWithToday(fam,indi));

    }

    @Test
    public void checkMarriageWithBirth() throws ParseException {
        HashMap<String,String[]> indi=new HashMap<>();
        HashMap<String,String[]>fam=new HashMap<>();
        String[] individual1,individual2,fami1,famil2;
        individual1=new String[]{"George/Joe/", "M", "10-12-2014", "33", "False", "10-12-2090", "F2", "F1"};
        individual2=new String[]{"Sarah/Thomas/","F","02-05-1986","33","True","NA","F2","F1"};
        famil2=new String[]{"11-11-2012", "11-11-2012", "I3", "George/Joe/", "I4", "Sarah/Thomas/", "I5"};
        indi.put("I3",individual1);
        indi.put("I4",individual2);
        fam.put("F1",famil2);
        Assert.assertTrue(new US1_US2().checkMarriageWithBirth(fam,indi));
        indi.clear();
        fam.clear();
        individual1=new String[]{"George/Joe/", "M", "10-12-2014", "33", "False", "10-12-2090", "F2", "F1"};
        individual2=new String[]{"Sarah/Thomas/","F","02-05-1986","33","True","NA","F2","F1"};
        famil2=new String[]{"11-11-2022", "11-11-2012", "I3", "George/Joe/", "I4", "Sarah/Thomas/", "I5"};
        indi.put("I3",individual1);
        indi.put("I4",individual2);
        fam.put("F1",famil2);
        Assert.assertFalse(new US1_US2().checkMarriageWithBirth(fam,indi));

    }
}