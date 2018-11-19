import java.text.ParseException;

public class Sprint3 {
    public void Sprint3() throws ParseException {
        Sprint2 sprint2 = new Sprint2();
        sprint2.Sprint2();
        GenderCorrectness_US21 deepu_us21 = new GenderCorrectness_US21();
        ListOfPeople listOfPeople = new ListOfPeople();
        uniqueChildInFamily vedant = new uniqueChildInFamily();
        DateComparison susheel = new DateComparison();
        FormatGEDCOM formatGEDCOM = new FormatGEDCOM();
        formatGEDCOM.GedcomTable();
        deepu_us21.CorrectGender_US21(formatGEDCOM.getFamilyMap(), formatGEDCOM.getIndividualMap());

        vedant.uniqueChild_US25(formatGEDCOM.getFamilyMap(), formatGEDCOM.getIndividualMap());

        susheel.BirthOfParentsWithChildBirthScenario_US08(formatGEDCOM.getIndividualMap(), formatGEDCOM.getFamilyMap());
        susheel.DeathOfParentsWithChildBirthScenario_US09(formatGEDCOM.getIndividualMap(), formatGEDCOM.getFamilyMap());

    }


}
