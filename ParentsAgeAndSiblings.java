package com.formatgedcom;

import java.util.HashMap;

public class ParentsAgeAndSiblings {

	public boolean checkParentsAgeDifference(HashMap<String, String[]> individual,HashMap<String, String[]> family) {
		boolean result = false;
		FormatGEDCOM obj = new FormatGEDCOM();
		obj.GedcomTable();
		obj.printTable();
		/* = obj.getFamilyMap();
		HashMap<String, String[]> individual = obj.getIndividualMap();
		*/
		String familyDetails[] = new String[100];
		String[] husband;
		String[] wife;
		String[] child;
		String AchildID[] = new String[3];
		String childID = null;
		ErrorMessages em = new ErrorMessages();
		
		for (String s : family.keySet()) {
			boolean moreThan1Child = false;
			familyDetails = family.get(s);
			String husID = familyDetails[2];
			String wifeID = familyDetails[4];
			if (familyDetails[6].split(" ").length > 3) {
				AchildID = familyDetails[6].split(" ");
				moreThan1Child = true;
			} else {
				childID = familyDetails[6].trim();
			}

			if (moreThan1Child) {
				for(int i=1;i<AchildID.length;i++){
					//System.out.println(husID + " " + wifeID + "child" + i + " " + AchildID[i]);	
					husband = individual.get(husID);
					wife = individual.get(wifeID);
					child = individual.get(AchildID[i]); 
					
					if(Integer.parseInt(husband[3])- Integer.parseInt(child[3])>24 && Integer.parseInt(wife[3])- Integer.parseInt(child[3])>14){
						em.IndividualTableErrorMessages("Age difference more than 24", husID , "US12");
						em.IndividualTableErrorMessages("Age difference more than 14", wifeID, "US12");
						result = true;
					}
					//System.out.println(husband[3] + " " + wife[3] + " " + child[3]);
					
				}
				
			} else {
				husband = individual.get(husID);
				wife = individual.get(wifeID);
				child = individual.get(childID);
				if(Integer.parseInt(husband[3])- Integer.parseInt(child[3])>20 && Integer.parseInt(wife[3])- Integer.parseInt(child[3])>20){
					em.IndividualTableErrorMessages("Age difference more than 24", husID , "US12");
					em.IndividualTableErrorMessages("Age difference more than 14", wifeID, "US12");
					result = true;
				}
				//System.out.println(husband[3] + " " + wife[3] + " " + child[3]);
			}

		}
		return result;
	}
	public boolean LessSiblings(HashMap<String, String[]> individual, HashMap<String, String[]> family){
		boolean result = false;
		ErrorMessages em = new ErrorMessages();
		for(String s: family.keySet()){
			String []famvalues = family.get(s);
			if(famvalues[6].split(" ").length>2){
				//System.out.println(famvalues[6]);
				result = true;
				em.FamilyTableErrorMessages("More than 2 siblings", s, "US15");
			}
		}
		
		
		
		return result; 
		
	}

}
