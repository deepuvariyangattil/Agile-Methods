import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class ListOfPeopleTest {

    @Test
    public void listLiving_US30() {
        HashMap<String,String[]>family=new HashMap<>(100);
        HashMap<String,String[]>individual=new HashMap<>(100);
        String[] indivi1,indivi2,indivi3,fami1=new String[100];
        indivi1= new String[]{"George/Joe/", "M", "02-05-1986", "33", "True", "NA", "F2", "F1"};
        indivi2=new String[]{"Sarah/Thomas/","F","02-05-1986","33","True","NA","F2","F1"};
        indivi3=new String[]{"Kiran/Nimish/","M","02-05-1988","30","True","NA","F2","F1"};
        fami1=new String[]{"08-07-2018", "NA", "I1", "George/Joe/", "I2", "Sarah/Thomas/", "I3"};
        family.put("F1",fami1);
        individual.put("I1",indivi1);
        individual.put("I2",indivi2);
        individual.put("I3",indivi3);
        boolean output=new ListOfPeople().ListLiving_US30(family,individual);
        Assert.assertTrue(output);
        family.clear();
        individual.clear();
        indivi1= new String[]{"George/Joe/", "M", "02-05-1986", "33", "False", "02-05-2000", "F2", "F1"};
        indivi2=new String[]{"Sarah/Thomas/","F","02-05-1986","33","False","02-05-2000","F2","F1"};
        indivi3=new String[]{"Kiran/Nimish/","M","02-05-1988","30","True","NA","F2","F1"};
        fami1=new String[]{"08-07-2018", "NA", "I1", "George/Joe/", "I2", "Sarah/Thomas/", "I3"};
        family.put("F1",fami1);
        individual.put("I1",indivi1);
        individual.put("I2",indivi2);
        individual.put("I3",indivi3);
        output=new ListOfPeople().ListLiving_US30(family,individual);
        Assert.assertFalse(output);


    }
}