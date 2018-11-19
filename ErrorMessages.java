import java.util.Vector;

public class ErrorMessages {
    public boolean FamilyTableErrorMessages(String message,String familyID,String userStory,int linenumber)
    {
        boolean result=true;
        System.out.println("Error in GEDCOM File_"+userStory+"_"+linenumber+" :"+message+" in the family table with family ID "+familyID+"\n");
        return result;
    }
    public boolean IndividualTableErrorMessages(String message,String individualID,String userStory,int linenumber)
    {
        boolean result=true;
        System.out.println("Error in GEDCOM File_"+userStory+"_"+linenumber+" :"+message+" in the individual table with individual ID "+individualID+"\n");
        return result;
    }
    public boolean FamilyAndIndividualTableErrorMessages(String message,String individualID,String familyID,String userStory,int linenumber)
    {
        boolean result=true;
        System.out.println("Error in GEDCOM File_"+userStory+"_"+linenumber+" :"+message+" in the family and individual tables with family ID and individual ID as "
        +familyID+","+individualID+" respectively\n");
        return result;
    }
    public boolean ListPrint(String message, Vector<String> list,String UserStory)
    {
        boolean result=true;
        System.out.println("List of "+message+"_"+UserStory+" :"+"\n"+list);
        return result;
    }
}
