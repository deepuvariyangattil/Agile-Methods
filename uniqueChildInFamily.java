import java.util.HashMap;

public class uniqueChildInFamily {

    private FormatGEDCOM formatGEDCOM = new FormatGEDCOM();

    public uniqueChildInFamily(){}

    public boolean uniqueChild_US25(HashMap<String, String[]> Family, HashMap<String, String[]> Individual) {

        formatGEDCOM.GedcomTable();
        String[] famValues,childarray = new String[100];
        String[] indiValues, indiValues1 = new String[100];
        ErrorMessages em = new ErrorMessages();
        boolean output = false;

        for (String s : Family.keySet()) {
            famValues = Family.get(s);

            for (String s1 : Individual.keySet()) {
                indiValues = Individual.get(s1);

                        for(String s2 : Individual.keySet()){
                            indiValues1 = Individual.get(s2);

                            childarray=famValues[6].trim().split(" ");
                            if(childarray.length > 1){

                            for(int i=0; i<childarray.length; i++){

                                if(s1.matches(childarray[i])){

                                    if(indiValues[0] == indiValues1[0] && indiValues[2] == indiValues1[2]){

                                    em.FamilyAndIndividualTableErrorMessages("Name and Birthdate same for children", s,s1,"US25");

                                }output = true;
                            }
                        }
                    }
                }

            }
        }return output;

    }
}