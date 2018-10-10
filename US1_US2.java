import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class US1_US2 {

	@SuppressWarnings("deprecation")
	public void checkDatesWithToday(){
		FormatGEDCOM formatGEDCOM = new FormatGEDCOM();

		formatGEDCOM.GedcomTable();
		HashMap<String, String[]> Indi = formatGEDCOM.getIndividualMap();
		Set<String> IndiIDs = Indi.keySet();
		String IndiData[] = new String[100];
		Date marriedDate, divorceDate, birthDate,deathDate;

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date today = new Date();
		// todays date
		// System.out.println(formatter.format(date));

		Iterator I1 = IndiIDs.iterator();
		while (I1.hasNext()) {
			// System.out.println(Indi.get(I1.next()));
			IndiData = Indi.get(I1.next());
			// System.out.println(IndiData[2]);
			birthDate = formatter.parse(IndiData[2]);
			if(!IndiData[5].equalsIgnoreCase("NA")){
				deathDate = formatter.parse(IndiData[5]); //checks for available death day or not. 
				if(deathDate.compareTo(today) > 0){
					System.out.println(IndiData[5] + " Date cannot be in the future!!");
				}
			}
			
			
			if (birthDate.compareTo(today) > 0) { // compare dates here!
				System.out.println("Date cannot be in the future!!");
			} 
		}
	}
	
	public void checkMarriageWithToday(){
	
	FormatGEDCOM fg = new FormatGEDCOM();
	HashMap<String, String[]> family = fg.getFamilyMap();

	Set<String> famIDs = family.keySet();
	String famData[] = new String[100];
	Date MarriageDate;
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	Date today = new Date();
	
	//System.out.println(famIDs);
	Iterator I2 = famIDs.iterator();
	while(I2.hasNext()){

		famData = family.get(I2.next());

		MarriageDate = formatter.parse(famData[0]); //retrieve the marriage date. 
		
		if(MarriageDate.compareTo(today) > 0){
			System.out.println("Marriage date cannot be in the future");
		}
		
		 
		 
	}

	
}

		

	
}
