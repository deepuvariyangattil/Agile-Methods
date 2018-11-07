import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class US37_US39Test {

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
        US37_US39 us=new US37_US39();
        boolean result=us.recentSurvivors(individual);
        assertTrue(result);
		
		
	}
	
	
	@Test
	public void US39test() throws ParseException{
		HashMap<String,String[]>family=new HashMap<>(100);
		String[] fami1=new String[100];
		fami1=new String[]{"11-11-2018", "NA", "I1", "George/Joe/", "I2", "Sarah/Thomas/", "I3"};
		family.put("F1",fami1);
		US37_US39 us=new US37_US39();
		boolean result=us.UpAnniv(family);
		assertTrue(result);
	}

}
