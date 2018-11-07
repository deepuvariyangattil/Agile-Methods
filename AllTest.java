import static org.junit.jupiter.api.Assertions.*;
import java.text.ParseException;
import java.util.HashMap;


import org.junit.jupiter.api.Test;

class US31_US32Test {
	
	@Test
	public void test() throws ParseException{
		FormatGEDCOM formatGEDCOM = new FormatGEDCOM();
		formatGEDCOM.GedcomTable();
		
        HashMap<String, String[]> Indi = formatGEDCOM.getIndividualMap();
        
		boolean result=US31_US32.StillSingle_US31(Indi);
		assertEquals(result,true);
	}
	
	@Test
	public void test1() throws ParseException{
		FormatGEDCOM formatGEDCOM = new FormatGEDCOM();
		formatGEDCOM.GedcomTable();
		
        HashMap<String, String[]> Indi = formatGEDCOM.getIndividualMap();
       	boolean result=US31_US32.MultipleBirths_US32(Indi);
		//assertEquals(result,true);
	}
	
	@Test
	public void test2()
	{
		FormatGEDCOM formatGEDCOM = new FormatGEDCOM();
		formatGEDCOM.GedcomTable();
		HashMap<String,String[]> Fam=formatGEDCOM.getFamilyMap();
        HashMap<String, String[]> Indi = formatGEDCOM.getIndividualMap();
        boolean result=US33_US34.orphans(Indi,Fam);
        assertEquals(result,true);
				
	}
	
	@Test
	public void test3()
	{
		FormatGEDCOM formatGEDCOM = new FormatGEDCOM();
		formatGEDCOM.GedcomTable();
		HashMap<String, String[]> Indi = formatGEDCOM.getIndividualMap();
		boolean result=US33_US34.largeAgeD(Indi);
		assertEquals(result,true);
	}

}
