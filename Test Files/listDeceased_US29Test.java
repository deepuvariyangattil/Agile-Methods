import org.junit.Test;
import org.junit.Assert;

import java.util.HashMap;

public class listDeceased_US29Test {


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
}
