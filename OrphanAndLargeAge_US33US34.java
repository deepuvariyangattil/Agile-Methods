import java.util.HashMap;

public class OrphanAndLargeAge_US33US34 {
	FormatGEDCOM formatGEDCOM = new FormatGEDCOM();
	ErrorMessages errorMessages=new ErrorMessages();
	IssueLine issueLine=new IssueLine();
	
	public  boolean orphans(HashMap<String,String[]> Indi,HashMap<String,String[]> Fam)
	{
		boolean t=false;
		int c=0;
		int age=100;
		String[] indiValues=new String[100];
		String[] famValues=new String[100];


		for(String s:Fam.keySet())
		{
			
			famValues =Fam.get(s);
			for(String s1:Indi.keySet())
			{
				indiValues=Indi.get(s1);
				if(famValues[2].equals(s1)&&indiValues[4].equals("False"))
				{
					c++;
				}
				if(famValues[4].equals(s1)&&indiValues[4].equals("False"))
				{
					c++;
				}
				if(famValues[6].trim().equalsIgnoreCase(s1))
				{
					age=Integer.parseInt(indiValues[3]);

				}
			}
			if(c==2 && age<18)
			{
				
				//System.out.println("Individual(s) "+famValues[6]+" is an orphan");
				int erroline=issueLine.GetLineNumber_Family(s,famValues[6]);
				errorMessages.IndividualTableErrorMessages("Individual is an orphan",famValues[6].trim(),"UserStory33",erroline);
				t=true;
			}
			c=0;
			age=100;
			
		}
		return t;
}
	
	
public boolean largeAgeD(HashMap<String,String[]> Indi)
{
	boolean t=false;
	String[] indiValues=new String[100];
	String[] indiValues_Duplicate=new String[100];
	for(String s:Indi.keySet())
	{
	indiValues=Indi.get(s);
	int age1 = Integer.parseInt(indiValues[3]);
	
	for(String s1:Indi.keySet())
	{
	indiValues_Duplicate=Indi.get(s1);
	int age2 = Integer.parseInt(indiValues_Duplicate[3]);
	if((!(s.equals(s1)))&&indiValues_Duplicate[7].equals(indiValues[7])&& age1-age2 > age2 && indiValues[7]!="")
	{
		String message=indiValues[0]+" is more than twice as old as "+indiValues_Duplicate[0];
		String individualID=s+","+s1;
		int errorline=issueLine.GetLineNumber_Individual(s,indiValues[0]);
		errorMessages.IndividualTableErrorMessages(message,individualID,"UserStory34",errorline);
		//System.out.println(indiValues[0]+" is more than twice as old as "+indiValues_Duplicate[0]);
		t=true;
	}
		
	}
		
		
	}
	
	
	return t;
	
}
	
	
	
}
