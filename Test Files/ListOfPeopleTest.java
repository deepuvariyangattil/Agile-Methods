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
	@Test
    public void listDeceased__US29(){

        ListofPeople obj = new ListofPeople();

        HashMap<String,String[]> individual=new HashMap<>(100);

        String[] indiValue1 = {"Christian/Philip/", "M", "16-11-1986", "25", "False", "08-02-2011", "F8"} ;
        individual.put("I1", indiValue1);

        try {
            Assert.assertTrue(obj.listDeceased_US29(individual));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
	@Test
    public void recentBirths_US35() {

        ListOfPeople obj = new ListOfPeople();

        HashMap<String, String[]> individual = new HashMap<>(100);

        String[] indiValue1 = {"Christian/Philip/", "M", "15-09-2018", "3", "False", "NA", "F8"};
        individual.put("I1", indiValue1);

        try {
            //Invalid scenario
            Assert.assertTrue(obj.recentBirths_US35(individual));
        } catch (Exception e) {
            e.printStackTrace();
        }
        individual.clear();
        indiValue1 = new String[]{"Fabi/Thomas/", "F", "20-10-2018", "21", "True", "NA", "F9"};
        individual.put("I2", indiValue1);

        try {
            //Valid Scenario
            Assert.assertFalse(obj.recentBirths_US35(individual));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
	@Test
    public void recentDeaths_US36() {

        ListOfPeople obj = new ListOfPeople();

        HashMap<String, String[]> individual = new HashMap<>(100);

        String[] indiValue1 = {"Christian/Philip/", "M", "21-03-1972", "3", "True", "19-10-2018", "F8"};
        individual.put("I1", indiValue1);

        try {
            //Invalid scenario
            Assert.assertTrue(obj.recentDeaths_US36(individual));
        } catch (Exception e) {
            e.printStackTrace();
        }
        individual.clear();
        indiValue1 = new String[]{"John/Thomas/", "F", "08-11-1991", "21", "False", "20-10-2018", "F9"};
        individual.put("I2", indiValue1);

        try {
            //Valid Scenario
            Assert.assertFalse(obj.recentDeaths_US36(individual));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
