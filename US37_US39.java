import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class US37_US39 {
	FormatGEDCOM formatGEDCOM = new FormatGEDCOM();
	
	public static boolean recentSurvivors(HashMap<String,String[]> Indi) throws ParseException
	{
		boolean t=false;
		String[] indiValues=new String[100];
		String[] indiValues2=new String[100];
		String[] famValues=new String[100];
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date date1 = sdf.parse("01-10-2018");
        
		System.out.println("User Story 37: Recent Survivors");
		for(String s:Indi.keySet())
		{
			indiValues =Indi.get(s);
			if(indiValues[4]=="False")
			{
				 java.util.Date date = new Date(0);
			        String formattedDate;
			        try {
						date = new SimpleDateFormat("dd-MM-yyyy").parse(indiValues[5]);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			        formattedDate = dateFormat.format(date);
			        
			        if(date.after(date1))
			        {
			        		for(String s1:Indi.keySet())
			        	{
			        		indiValues2=Indi.get(s1);
			        		if((indiValues[7].equals(indiValues2[7])|| indiValues[7].equals(indiValues2[6])) &&indiValues2[4]=="True"&&!(indiValues[0].equals(indiValues2[0])))
			        		{
			        			System.out.println(indiValues2[0]);
			        			t=true;
			        		}
			        		
			        	}
			        }
			      }
			
		}
		
return t;
	}

	public static boolean UpAnniv(HashMap<String,String[]> Fam) throws ParseException
	{
	boolean t=false;
	String[] famValues=new String[100];
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    java.util.Date date1 = sdf.parse("01-11-2018");
    java.util.Date date2 = sdf.parse("01-12-2018");
    System.out.println("User Story 39: Upcoming anniversaries:");
    for(String s:Fam.keySet())
    {
    	famValues=Fam.get(s);
    	 java.util.Date date = new Date(0);
	        String formattedDate;
	        try {
				date = new SimpleDateFormat("dd-MM-yyyy").parse(famValues[0]);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	        formattedDate = dateFormat.format(date);
	        if(date.after(date1)&&date.before(date2))
	        {
	        	System.out.println(famValues[3]+" and "+famValues[5]+" have an upcoming anniversary!");t=true;
	        }
    	
    	
    	
    	
    	
    }
	
	
	
	return t;
	
		
		
	}
	
	
	
}
