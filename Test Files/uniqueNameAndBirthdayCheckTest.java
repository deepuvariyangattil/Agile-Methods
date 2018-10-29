import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.HashMap;

public class uniqueNameAndBirthdayCheckTest {

    @Test
    public void uniqueNameandBirthday_US23() {
        uniqueNameAndBirthdayCheck obj=new uniqueNameAndBirthdayCheck();


        HashMap<String, String[]> Individual = new HashMap<>(100);
        String[] indiValue2 = { "Sara/Tom/", "F", "02-05-2021", "33", "False", "02-05-2061", "F2", "F1" };

        String[] indivalue = { "Sara/Tom/", "F", "02-05-2021", "33", "False", "02-05-2020", "F2", "F1" };
        Individual.put("I6", indiValue2);

        Individual.put("I1", indivalue);
        try {
            Assert.assertTrue(obj.uniqueNameandBirthday_US23(Individual));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Individual.clear();
        indiValue2 = new String[]{ "Sara/Tom/", "F", "02-05-2020", "33", "False", "02-05-2061", "F2", "F1" };
        indivalue = new String[]{"Sara/Tom/", "M", "02-05-2021", "33", "False", "02-05-2020", "F2", "F1"};
        Individual.put("I6", indiValue2);

        Individual.put("I1", indivalue);
        try {
            Assert.assertFalse(obj.uniqueNameandBirthday_US23(Individual));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}