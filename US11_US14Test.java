import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

class US11_US14Test {

	@Test
	public void US11test() throws ParseException
	{
		HashMap<String,String[]>family=new HashMap<>(100);
		String[] fami1=new String[100];
		String[] fami12=new String[100];
		fami1=new String[]{"11-11-2018", "NA", "I1", "George/Joe/", "I2", "Sarah/Thomas/", "I3"};
		fami12=new String[]{"11-11-2018", "NA", "I1", "George/Joe/", "I200", "Hannah/Thomas/", "I3"};
		family.put("F1",fami1);
		family.put("F2",fami12);
		
		US11_US14 us=new US11_US14();
		boolean result=us.noBigamy(family);
		assertTrue(result);
			
	}
	
	
	@Test
	public void US14Test() throws ParseException
	{
		HashMap<String,String[]>individual=new HashMap<>(100); 
		String[] indivi1,indivi2,indivi3,indivi4,indivi5=new String[100];
		indivi1= new String[]{"George/Joe/", "M", "02-05-1986", "33", "False", "28-10-2018", "F2", "F1"};
		indivi2= new String[]{"Vedant/Soni/", "M", "02-05-1986", "33", "False", "28-10-2018", "F2", "F1"};
		indivi3= new String[]{"Sushil/Saladi/", "M", "02-05-1986", "33", "False", "28-10-2018", "F2", "F1"};
		indivi4= new String[]{"Deepu/V/", "M", "02-05-1986", "33", "False", "28-10-2018", "F2", "F1"};
		indivi5= new String[]{"Nisheet/Thakur/", "M", "02-05-1986", "33", "False", "28-10-2018", "F2", "F1"};
		
		individual.put("I1",indivi1);
		individual.put("I2",indivi2);
		individual.put("I3",indivi3);
		individual.put("I4",indivi4);
		individual.put("I5",indivi5);
		
		US11_US14 us=new US11_US14();
		boolean result=us.multipleBirths(individual);
		assertTrue(result);
		
	
		
		
		
		
	}

	
	
	

}
