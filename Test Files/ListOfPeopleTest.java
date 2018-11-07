import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;

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
	@Test
    public void listDeceased__US29(){

        ListOfPeople obj = new ListOfPeople();

        HashMap<String,String[]> individual=new HashMap<>(100);

        String[] indiValue1 = {"Christian/Philip/", "M", "16-11-1986", "25", "False", "08-02-2011", "F8"} ;
        individual.put("I1", indiValue1);

        try {
            //Invalid scenario
            Assert.assertTrue(obj.listDeceased_US29(individual));
        } catch (Exception e) {
            e.printStackTrace();
        }
        individual.clear();
        indiValue1 = new String[]{"John/Philip/", "M", "16-11-1986", "25", "True", "NA", "F8","F1"} ;
        individual.put("I2", indiValue1);

        try {
            //Valid Scenario
            Assert.assertFalse(obj.listDeceased_US29(individual));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    public void US37test() throws ParseException {
        HashMap<String,String[]>individual=new HashMap<>(100);
        String[] indivi1,indivi2,indivi3=new String[100];
        indivi1= new String[]{"George/Joe/", "M", "02-05-1986", "33", "False", "28-10-2018", "F2", "F1"};
        indivi2=new String[]{"Sarah/Thomas/","F","02-05-1986","33","True","NA","F2","F1"};
        indivi3=new String[]{"Kiran/Nimish/","M","02-05-1988","30","True","NA","F2","F1"};
        individual.put("I1",indivi1);
        individual.put("I2",indivi2);
        individual.put("I3",indivi3);
        ListOfPeople us=new ListOfPeople();
        boolean result=us.recentSurvivors_US37(individual);
        assertTrue(result);


    }


    @Test
    public void US39test() throws ParseException {
        HashMap<String,String[]>family=new HashMap<>(100);
        String[] fami1=new String[100];
        fami1=new String[]{"11-11-2018", "NA", "I1", "George/Joe/", "I2", "Sarah/Thomas/", "I3"};
        family.put("F1",fami1);
        ListOfPeople us=new ListOfPeople();
        boolean result=us.UpAnniv_39(family);
        assertTrue(result);
    }
}