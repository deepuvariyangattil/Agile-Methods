import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class uniqueChildInFamily_US25Test {

    uniqueChildInFamily obj = new uniqueChildInFamily();

    @Test
    public void uniqueChildInFamily_US25Test() {

        HashMap<String, String[]> Individual = new HashMap<>(100);
        HashMap<String, String[]> Family = new HashMap<>(100);

        String[] famValue = {"08-07-2006", "NA", "I4", "Antony/Thomas/", "I12", "Sarah/Joe/", "I1 I2"};
        String[] indiValue = {"Christian/Philip/", "M", "16-11-1986", "32", "TRUE", "NA", "F1"};
        String[] indiValue1 = {"Christian/Philip/", "F", "16-11-1986", "32", "TRUE", "NA", "F1"};

        Individual.put("I1", indiValue);
        Individual.put("I2", indiValue1);
        Family.put("F1", famValue);

        Boolean b = obj.uniqueChild_US25(Family, Individual);
        Assert.assertTrue(b);

        Individual.clear();
        Family.clear();
        indiValue = new String[]{"Christian/Philip/", "M", "16-11-1986", "32", "TRUE", "NA", "F1"};
        indiValue1 = new String[]{"Samir/Antony/", "M", "04-03-1998", "57", "TRUE", "NA", "F1"};
        Individual.put("I3", indiValue);
        Individual.put("I4", indiValue1);
        famValue = new String[]{"08-07-2006", "NA", "I4", "Antony/Thomas/", "I12", "Sarah/Joe/", "I3 I4"};
        Family.put("F2", famValue);

        b = obj.uniqueChild_US25(Family, Individual);
        Assert.assertFalse(b);

                }
        }
