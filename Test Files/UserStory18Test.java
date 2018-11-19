import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class UserStory18Test {

    @Test
    public void findSiblingSpouse_US18() {
        HashMap<String,String[]>indi=new HashMap<>();
        HashMap<String,String[]>fam=new HashMap<>();
        String[] individual1,individual2,fami1,famil2;
        individual1=new String[]{"George/Joe/", "M", "10-12-1986", "33", "True", "NA", "F2", "F1"};
        individual2=new String[]{"Sarah/Thomas/","F","02-05-1986","33","True","NA","F2","F1"};
        fami1=new String[]{"11-11-2018", "NA", "I1", "Peter/Joe/", "I2", "Anna/Thomas/", "I3 I4"};
        famil2=new String[]{"11-11-2018", "NA", "I3", "George/Joe/", "I4", "Sarah/Thomas/", "I5"};
        indi.put("I3",individual1);
        indi.put("I4",individual2);
        fam.put("F2",fami1);
        fam.put("F1",famil2);
        Assert.assertTrue( new UserStory18().FindSiblingSpouse_US18(fam,indi));
        indi.clear();
        fam.clear();
        individual1=new String[]{"George/Joe/", "M", "10-12-1986", "33", "True", "NA", "F2", "F1"};
        individual2=new String[]{"Sarah/Thomas/","F","02-05-1986","33","True","NA","F2","F1"};
        fami1=new String[]{"11-11-2018", "NA", "I1", "Peter/Joe/", "I2", "Anna/Thomas/", "I3 I4"};
        famil2=new String[]{"11-11-2018", "NA", "I7", "George/Joe/", "I8", "Sarah/Thomas/", "I5"};
        indi.put("I3",individual1);
        indi.put("I4",individual2);
        fam.put("F2",fami1);
        fam.put("F1",famil2);
        Assert.assertFalse(new UserStory18().FindSiblingSpouse_US18(fam,indi));

    }
}