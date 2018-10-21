import org.junit.Test;
import org.junit.Assert;

import java.util.HashMap;

public class US23_TestCase {

    UserStrory23 obj = new UserStrory23();

    @Test
    public void UserStrory23() {


        HashMap<String, String[]> Individual = new HashMap<>(100);
        String[] indiValues = {" Dan/George/", "M", "02-11-2010", "8", "True", "NA", "F1"};
        String[] indiValues1 = {"Dan/George/", "M", "16-11-1986", "32", "True", "NA", "F8"};

        Individual.put("I11", indiValues);
        Individual.put("I13", indiValues1);

        try {
            Boolean b = obj.uniqueNameandBirthday_US23(Individual);
            Assert.assertTrue(b);
        } catch (Exception e) {
        }
    }
}