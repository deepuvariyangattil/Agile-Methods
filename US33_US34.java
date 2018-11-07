import java.text.ParseException;
import java.util.HashMap;

public class US33_US34 {
	FormatGEDCOM formatGEDCOM = new FormatGEDCOM();
	
	public static boolean orphans(HashMap<String,String[]> Indi,HashMap<String,String[]> Fam)
	{
		boolean t=false;
		int c=0;
		String[] indiValues=new String[100];
		String[] famValues=new String[100];
		System.out.println("Orphans:");
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
			}
			if(c==2)
			{
				
				System.out.println("Individual(s) "+famValues[6]+" is an orphan");
				t=true;
			}
			c=0;
			
		}
		return t;
}
	
	
public static boolean largeAgeD(HashMap<String,String[]> Indi)
{
	boolean t=false;
	String[] indiValues=new String[100];
	String[] i2=new String[100];
	System.out.println("Large age differences:");
	for(String s:Indi.keySet())
	{
	indiValues=Indi.get(s);
	int age1 = Integer.parseInt(indiValues[3]);
	
	for(String s1:Indi.keySet())
	{
	i2=Indi.get(s1);
	int age2 = Integer.parseInt(i2[3]);
	if(i2[7].equals(indiValues[7])&& age1-age2 > age2 && indiValues[7]!="")
	{
		System.out.println(indiValues[0]+" is more than twice as old as "+i2[0]);
		t=true;
	}
		
	}
		
		
	}
	
	
	return t;
	
}
	
	
	
}
