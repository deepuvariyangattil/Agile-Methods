import java.util.TreeMap;

public class IssueLine {
    FormatGEDCOM formatGEDCOM=new FormatGEDCOM();

    public int GetLineNumber_Individual(String individualID,String individualMap_Value)
    {

        String[] indiValue=new String [20];
        String errorValue="";
        String indiID_Line="";
        int lineNumber_Error=0;
        formatGEDCOM.GedcomTable();
        TreeMap<String,String[]> indiLineMap=formatGEDCOM.getIndividual_ErrorLine();
        //System.out.println(individualID);
        indiValue=indiLineMap.get(individualID.trim());
        //System.out.println(indiValue[0]);
        for(int i=0;i<indiValue.length;i++)
        {
            if(indiValue[i].trim().equalsIgnoreCase(individualMap_Value.trim()))
            {
                errorValue=indiValue[i+1];

            }

        }
       lineNumber_Error=ExtractLineNumber(errorValue.trim());
       return lineNumber_Error;
    }

    private int ExtractLineNumber(String errorValue) {
        int linenumber;
        String temp;
        int index;
       //System.out.println(errorValue);
        if(errorValue.equals(""))
        {
            return 0;
        }
        index=errorValue.trim().indexOf("_");
        temp=errorValue.substring(index+1);
        linenumber=Integer.parseInt(temp);
        return linenumber;

    }

    public int GetLineNumber_Family(String familyID,String familyMap_Value)
    {
        String[] famValue=new String [20];
        String errorValue="";

        int lineNumber_Error=0;
        formatGEDCOM.GedcomTable();
        TreeMap<String,String[]> famLineMap=formatGEDCOM.getFamily_ErrorLine();
        famValue=famLineMap.get(familyID.trim());
        //System.out.println(familyID);
        //System.out.println(familyMap_Value);
        //System.out.println(famValue[famValue.length-1]);
        //System.out.println(famValue[famValue.length-2]);
        for(int i=0;i<famValue.length;i++)
        {
            if(famValue[i].trim().equalsIgnoreCase(familyMap_Value.trim()))
            {
                errorValue=famValue[i+1];

            }

        }
        //System.out.println("Error value :"+errorValue);
        lineNumber_Error=ExtractLineNumber(errorValue.trim());
        return lineNumber_Error;

    }

}
