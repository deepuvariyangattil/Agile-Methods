import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class US11_US14 {
	FormatGEDCOM formatGEDCOM = new FormatGEDCOM();
	
	public static boolean noBigamy(HashMap<String,String[]> Fam) throws ParseException
	{
		boolean t=false;
		ErrorMessages em = new ErrorMessages(); 
		String[] famValues=new String[100];
		String[] famcheck=new String[100];
		
		System.out.println("User Story 11: No Bigamy");
		for(String s:Fam.keySet())
		{
			famValues=Fam.get(s);
			for(String s1:Fam.keySet())
			{
				famcheck=Fam.get(s1);
				
				if((famcheck[2].equals(famValues[2])||famcheck[4].equals(famValues[4]))&&famcheck[0].equals(famValues[0])&&!s1.equals(s))
				{
					em.ListPrint("Bigamy in family: ",s,"UserStory11");
					t=true;
				
				}
				
				
			}
			
		}	
		
		return t;
		
	}
	
	
	public static boolean multipleBirths(HashMap<String,String[]> Indi) throws ParseException
	{
		boolean t=false;
		ErrorMessages em = new ErrorMessages();
		int count=0;
		String[] indiValues=new String[100];
		String[] indicheck=new String[100];
		
		System.out.println("User Story 14: Multiple Births<=5");
		for(String s:Indi.keySet())
		{
			indiValues=Indi.get(s);
			Date birthday = new Date();
	        birthday = new SimpleDateFormat("dd-MM-yyyy").parse(indiValues[2]);
	        
			
			if(indiValues[6]!="")
			{
			for(String s1:Indi.keySet())
			{
				indicheck=Indi.get(s1); 
				
				Date sibbirthday = new Date();
		        sibbirthday = new SimpleDateFormat("dd-MM-yyyy").parse(indicheck[2]);
		        
				if(indiValues[6].equals(indicheck[6])&& birthday.equals(sibbirthday) &&!s.equals(s1))
				{
					count++;
				}
				
				if(count==4)
				{
					System.out.println("Multiple births found in family "+indiValues[6]);
					em.ListPrint("Multiple births in family: ",indiValues[6],"UserStory14");
					t=true;
					count=0;
					break;
					
				}
				
			}
			
			count=0;
			}
			
		}
		
		
		
		
		
		
		
		return t;
		
	}
	
	
	
	
	
	
	
}
