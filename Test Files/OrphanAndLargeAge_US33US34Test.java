import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class OrphanAndLargeAge_US33US34Test {
	

	
	@Test
	public void orphans()
	{

		HashMap<String, String[]> Family = new HashMap<>(100);

		HashMap<String, String[]> Individual = new HashMap<>(100);
		String[] indiValue_wife = { "Sara/Tom/", "F", "02-05-1985", "33", "False", "02-05-2017", "F2", "F1" };

		String[] indivalue_father = { "Tom/Nath/", "M", "02-05-1975", "43", "False", "02-05-2017", "F2", "F1" };
		String[] indivalue_kid = { "Sam/Nath/", "M", "02-05-2013", "5", "True", "NA", "F2", "F1" };
		Individual.put("I6", indiValue_wife);

		Individual.put("I1", indivalue_father);
		Individual.put("I2",indivalue_kid);
		String[] famValue = { "08-07-2000","NA","I1","Tom/Nath/","I6","Sara/Tom/","I2"};
		Family.put("F1",famValue);
        OrphanAndLargeAge_US33US34 obj=new OrphanAndLargeAge_US33US34();
        Assert.assertTrue(obj.orphans(Individual,Family));

				
	}
	
	@Test
	public void largeAgeD()
	{
		HashMap<String, String[]> Individual = new HashMap<>(100);
		String[] indiValue_wife = { "Sara/Tom/", "F", "02-05-1985", "33", "False", "02-05-2017", "F2", "F1" };

		String[] indivalue_father = { "Tom/Nath/", "M", "02-05-1945", "73", "False", "02-05-2017", "F2", "F1" };
		Individual.put("I6", indiValue_wife);

		Individual.put("I1", indivalue_father);
		OrphanAndLargeAge_US33US34 obj=new OrphanAndLargeAge_US33US34();
		Assert.assertTrue(obj.largeAgeD(Individual));

	}

}
