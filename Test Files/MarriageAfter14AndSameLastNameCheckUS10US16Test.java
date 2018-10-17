import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class Marriageafter14andSamelastnamecheckUS10US14Test {
    Marriageafter14andSamelastnamecheck_US10US14 obj=new Marriageafter14andSamelastnamecheck_US10US14();

    @Test
    public void lastNameExtractor() {
        Marriageafter14andSamelastnamecheck_US10US14 us=new Marriageafter14andSamelastnamecheck_US10US14();
        String name="Shinto/Francis/";
        String lN="Francis";
        assertEquals(lN,us.LastNameExtractor(name));
    }

    @Test
    public void marriageAfterFourteen_US10() {
        HashMap<String,String[]> Family=new HashMap<>(100);
        HashMap<String,String[]> Individual=new HashMap<>(100);
        //Initializing family and individual map with age less than 14
        String[] familyValue={"08-07-2018","NA","I1","Sarah/Joe/","I2","Antony/Thomas/","I14"};
        String[] indivalue={" George/Thomas/","M","02-05-2018","33","True","NA","F2","F1"};
        String[] indivalue2={"Sarah/Joe/","F","02-05-2018","33","True","NA","F2","F1"};

        Family.put("F6",familyValue);
        Individual.put("I1",indivalue);
        Individual.put("I2",indivalue2);

        Boolean b=obj.MarriageAfterFourteen_US10(Family,Individual);
        Assert.assertTrue(b);//checking whether return value of function is true. True means age is less than 14

        Individual.clear();//clearing individual data for negative flow
        //Adding new set of values to Individual map
        indivalue= new String[]{" George/Thomas/", "M", "02-05-2000", "33", "True", "NA", "F2", "F1"};
        indivalue2= new String[]{"Sarah/Joe/", "F", "02-05-2000", "33", "True", "NA", "F2", "F1"};
        Individual.put("I3",indivalue);
        Individual.put("I4",indivalue2);
        b=obj.MarriageAfterFourteen_US10(Family,Individual);
        Assert.assertFalse(b);//checking whether return value of function is false. False means age is more than 14
    }

    @Test
    public void MaleLastNamesSameInFamily_US16(){
        HashMap<String,String[]> Family=new HashMap<>(100);
        HashMap<String,String[]> Individual=new HashMap<>(100);
        String[] familyValue={"08-07-2018","NA","I1","Sarah/Joe/","I2","Antony/Thomas/","I14"};
        String[] indivalue={" George/Joe/","M","02-05-2018","33","True","NA","F2","F1"};
        String[] indivalue2={"Sarah/Thomas/","F","02-05-2018","33","True","NA","F2","F1"};
        //Creating a positive scenario where last names are same. Hence shouldn't print any error message.
        Family.put("F6",familyValue);
        Individual.put("I14",indivalue);
        boolean output=obj.MaleLastNamesSameInFamily_US16(Family,Individual);
        Assert.assertFalse(output);
        //Creating a negative scenario where last names are different. Hence should print error message.
        familyValue= new String[]{"08-07-2018", "NA", "I1", "Sarah/Joe/", "I2", "Antony/Thomas/", "I2"};
        Family.clear();
        Individual.clear();
        Family.put("F6",familyValue);
        Individual.put("I2",indivalue2);
        output=obj.MaleLastNamesSameInFamily_US16(Family,Individual);
        Assert.assertTrue(output);

    }

}
