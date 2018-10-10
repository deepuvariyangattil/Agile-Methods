import java.util.HashMap;

public class UserStory18 {
    private FormatGEDCOM formatGEDCOM = new FormatGEDCOM();

    public UserStory18() {
        formatGEDCOM.GedcomTable();

    }
    public void FindSiblingSpouse_US18()
    {
        HashMap<String, String[]>familyMap=formatGEDCOM.getFamilyMap();
        HashMap<String, String[]>indiMap=formatGEDCOM.getIndividualMap();
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
                    //System.out.println("Children are "+childarray[i]);
                    indivalues=indiMap.get(childarray[i].trim());
                    //System.out.println(indivalues[7]);
                    spusearray=indivalues[7].split(" ");
                    //System.out.println(spusearray.length);
                    //System.out.println(spusearray[0]);
                    for(int j=0;j<spusearray.length;j++)
                    {

                        //System.out.println("Hello"+spusearray[j]);
                        try {
                            familycomp = familyMap.get(spusearray[j]);
                            // System.out.println(familycomp[0]+familycomp[4]);
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
                        if(spouseName.get(z).equalsIgnoreCase(childarray[y]))
                        {
                            System.out.println("Error in GEDCOM File:"+z+" "+spouseName.get(z)+" are couples and siblings\n");
                        }

                    }
                }
            }
        }
    }

}
