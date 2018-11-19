import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.HashMap;

public class US11_US14Test {

    @Test
    public void noBigamy() throws ParseException {
        HashMap<String,String[]> family=new HashMap<>(100);
        String[] fami1=new String[100];
        String[] fami12=new String[100];
        fami1=new String[]{"11-11-2018", "NA", "I1", "George/Joe/", "I2", "Sarah/Thomas/", "I3"};
        fami12=new String[]{"20-11-2018", "NA", "I1", "George/Joe/", "I200", "Hannah/Thomas/", "I3"};
        family.put("F1",fami1);
        family.put("F2",fami12);

        US11_US14 us=new US11_US14();
        boolean result=us.noBigamy(family);
        Assert.assertTrue(result);
        family.clear();
        fami1=new String[]{"11-11-2017", "11-11-2018", "I1", "George/Joe/", "I2", "Sarah/Thomas/", "I3"};
        fami12=new String[]{"20-11-2018", "NA", "I1", "George/Joe/", "I200", "Hannah/Thomas/", "I3"};
        family.put("F1",fami1);
        family.put("F2",fami12);
        result=us.noBigamy(family);
        Assert.assertFalse(result);
    }

    @Test
    public void multipleBirths() throws ParseException {
        HashMap<String,String[]>individual=new HashMap<>(100);
        String[] indivi1,indivi2,indivi3,indivi4,indivi5,indivi6=new String[100];
        indivi1= new String[]{"George/Joe/", "M", "02-05-1986", "33", "False", "28-10-2018", "F2", "F1"};
        indivi2= new String[]{"Vedant/Soni/", "M", "02-05-1986", "33", "False", "28-10-2018", "F2", "F1"};
        indivi3= new String[]{"Sushil/Saladi/", "M", "02-05-1986", "33", "False", "28-10-2018", "F2", "F1"};
        indivi4= new String[]{"Deepu/V/", "M", "02-05-1986", "33", "False", "28-10-2018", "F2", "F1"};
        indivi5= new String[]{"Nisheet/Thakur/", "M", "02-05-1986", "33", "False", "28-10-2018", "F2", "F1"};
        indivi6= new String[]{"ABC/DEF/", "M", "02-05-1986", "33", "False", "28-10-2018", "F2", "F1"};

        individual.put("I1",indivi1);
        individual.put("I2",indivi2);
        individual.put("I3",indivi3);
        individual.put("I4",indivi4);
        individual.put("I5",indivi5);
        individual.put("I6",indivi6);

        US11_US14 us=new US11_US14();
        boolean result=us.multipleBirths(individual);
        Assert.assertTrue(result);
        individual.clear();
        indivi1= new String[]{"George/Joe/", "M", "02-05-1986", "33", "False", "28-10-2018", "F2", "F1"};
        indivi2= new String[]{"Vedant/Soni/", "M", "02-05-1986", "33", "False", "28-10-2018", "F2", "F1"};
        indivi3= new String[]{"Sushil/Saladi/", "M", "02-05-1986", "33", "False", "28-10-2018", "F2", "F1"};
        indivi4= new String[]{"Deepu/V/", "M", "02-05-1986", "33", "False", "28-10-2018", "F2", "F1"};
        indivi5= new String[]{"Nisheet/Thakur/", "M", "02-05-1987", "33", "False", "28-10-2018", "F2", "F1"};
        indivi6= new String[]{"ABC/DEF/", "M", "02-05-1986", "33", "False", "28-10-2018", "F2", "F1"};
        individual.put("I6",indivi6);
        individual.put("I1",indivi1);
        individual.put("I2",indivi2);
        individual.put("I3",indivi3);
        individual.put("I4",indivi4);
        individual.put("I5",indivi5);
        result=us.multipleBirths(individual);
        Assert.assertFalse(result);
    }
}