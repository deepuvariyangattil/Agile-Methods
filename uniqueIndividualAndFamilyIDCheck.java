import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class uniqueIndividualAndFamilyIDCheck {
    IssueLine issueLine=new IssueLine();

    public boolean uniqueIDCheck(String filePath) {
        FileReader fileReader = null;
        String fileData;
        ErrorMessages errorMessages=new ErrorMessages();
        boolean output = false;
        CharSequence charSequence_ID = "0 @I";
        CharSequence charSequence_FAM = "0 @F";
        Vector<String> indiID = new Vector<>(100);
        Vector<String> famID = new Vector<>(100);
        try {
            fileReader = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        try {
            while ((fileData = bufferedReader.readLine()) != null) {
                if (fileData.contains(charSequence_ID)) {
                    int firstIndex = (fileData.indexOf('@'));
                    int lastIndex = (fileData.lastIndexOf('@'));
                    String id = fileData.substring(firstIndex + 1, lastIndex);
                    indiID.add(id);
                }
            }
            for (int i = 0; i < indiID.size(); i++) {
                for (int j = i + 1; j < indiID.size(); j++) {
                    if (indiID.elementAt(i).equalsIgnoreCase(indiID.elementAt(j))) {

                        String message="Duplicate individual ID found in GEDCOM file";
                        String individualID=indiID.elementAt(i);
                        int errorline=issueLine.GetLineNumber_Individual(individualID,individualID);
                        errorMessages.IndividualTableErrorMessages(message,individualID,"UserStory22",errorline);
                        //System.out.println("ERROR in the GEDCOM FILE: Inidividual ID " + indiID.elementAt(i) + " has a duplicate in GEDCOM file ");
                        output = true;
                    }
                }
            }
        }

        catch (Exception e) {
            e.fillInStackTrace();
        }
        try {
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileReader = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        BufferedReader bufferedReader1 = new BufferedReader(fileReader);
        try{
            while ((fileData = bufferedReader1.readLine()) != null) {
                if (fileData.contains(charSequence_FAM)) {
                    int firstIndex = (fileData.indexOf('@'));
                    int lastIndex = (fileData.lastIndexOf('@'));
                    String id = fileData.substring(firstIndex + 1, lastIndex);
                    famID.add(id);
                }
            }
            for (int i = 0; i < famID.size(); i++) {
                for (int j = i + 1; j < famID.size(); j++) {
                    if (famID.elementAt(i).equalsIgnoreCase(famID.elementAt(j))) {
                        String message="Duplicate family ID found in GEDCOM file";
                        String familyID=famID.elementAt(i);
                        int errorline=issueLine.GetLineNumber_Family(familyID,familyID);
                        errorMessages.FamilyTableErrorMessages(message,familyID,"UserStory22",errorline);
                        //System.out.println("ERROR in the GEDCOM FILE: FAMILY ID " + famID.elementAt(i) + " has a duplicate in GEDCOM file ");
                        output = true;
                    }
                }
            }

        }
        catch (Exception e) {
            e.fillInStackTrace();
        }
        try {
            bufferedReader1.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output;
    }
}
