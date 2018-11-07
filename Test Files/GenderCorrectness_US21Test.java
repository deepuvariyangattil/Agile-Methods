import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class GenderCorrectness_US21Test {

    @Test
    public void correctGender_US21() {
        HashMap<String,String[]> family=new HashMap<>(100);
        HashMap<String,String[]>individual=new HashMap<>(100);
        String[] indivi1,indivi2,indivi3,fami1=new String[100];
        indivi1= new String[]{"George/Joe/", "F", "02-05-1986", "33", "True", "NA", "F2", "F1"};
        indivi2=new String[]{"Sarah/Thomas/","M","02-05-1986","33","True","NA","F2","F1"};
        indivi3=new String[]{"Kiran/Nimish/","M","02-05-1988","30","True","NA","F2","F1"};
        fami1=new String[]{"08-07-2018", "NA", "I1", "George/Joe/", "I2", "Sarah/Thomas/", "I3"};
        family.put("F1",fami1);
        individual.put("I1",indivi1);
        individual.put("I2",indivi2);
        individual.put("I3",indivi3);
        boolean output=new GenderCorrectness_US21().CorrectGender_US21(family,individual);
        //Testing invalid scenario
        Assert.assertTrue(output);
        family.clear();
        individual.clear();
        indivi1= new String[]{"George/Joe/", "M", "02-05-1986", "33", "True", "NA", "F2", "F1"};
        indivi2=new String[]{"Sarah/Thomas/","F","02-05-1986","33","True","NA","F2","F1"};
        indivi3=new String[]{"Kiran/Nimish/","M","02-05-1988","30","True","NA","F2","F1"};
        fami1=new String[]{"08-07-2018", "NA", "I9", "George/Joe/", "I8", "Sarah/Thomas/", "I7"};
        family.put("F9",fami1);
        individual.put("I9",indivi1);
        individual.put("I8",indivi2);
        individual.put("I7",indivi3);
        output=new GenderCorrectness_US21().CorrectGender_US21(family,individual);
        //Testing valid scenario
        Assert.assertFalse(output);
    }
}