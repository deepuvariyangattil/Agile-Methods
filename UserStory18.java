import java.util.HashMap;

public class UserStory18 {
    private FormatGEDCOM formatGEDCOM = new FormatGEDCOM();
    IssueLine issueLine=new IssueLine();
    ErrorMessages errorMessages=new ErrorMessages();


    public boolean FindSiblingSpouse_US18(HashMap<String, String[]>familyMap,HashMap<String, String[]>indiMap)
    {
        boolean result=false;
        String[] familyvalues,childarray,spusearray,indivalues,familycomp=new String[100];
        HashMap<String,String> spouseName=new HashMap<>(100);
        for(String s:familyMap.keySet())
        {
            familyvalues=familyMap.get(s);
            childarray=familyvalues[6].trim().split(" ");
            if(childarray.length>1)
            {
                for(int i=0;i<childarray.length;i++)
                {

                    indivalues=indiMap.get(childarray[i].trim());

                    spusearray=indivalues[7].split(" ");

                    for(int j=0;j<spusearray.length;j++)
                    {


                        try {
                            familycomp = familyMap.get(spusearray[j]);

                            if (indivalues[1].trim().equalsIgnoreCase("M")) {
                                spouseName.put(childarray[i],familycomp[4]);
                            } else if (indivalues[1].trim().equalsIgnoreCase("F")) {
                                spouseName.put(childarray[i],familycomp[2]);
                            }
                        }
                        catch (Exception e){
                            continue;
                        }
                    }
                }
                String temp="";
                for(String z: spouseName.keySet())
                {
                    for(int y=0;y<childarray.length;y++)
                    {
                        if((spouseName.get(z).equalsIgnoreCase(childarray[y]))&&!(s.equalsIgnoreCase(temp)))
                        {
                            String message="Siblings married";
                            String familyID=s;
                            int linenumber=issueLine.GetLineNumber_Family(familyID,familyID);
                            errorMessages.FamilyTableErrorMessages(message,familyID,"UserStory18",linenumber);
                            temp=s;
                            result=true;
                            //System.out.println("Error in GEDCOM File_User Story18 :"+z+" "+spouseName.get(z)+" are couples and siblings\n");
                        }

                    }
                }
            }
        }
        return  result;
    }

}
