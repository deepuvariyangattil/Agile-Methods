
import org.junit.Assert;
import org.junit.Test;

public class UserStory22_TEST {

    uniqueIndividualAndFamilyIDCheck obj = new uniqueIndividualAndFamilyIDCheck();


    @Test
    public void UniqueIDCheck_US22() {



            Boolean b = obj.uniqueIDCheck("C:\\Users\\DEEPUAISHU\\IdeaProjects\\Sprint2\\Test\\Vedant.ged");
            Assert.assertFalse(b);


            Boolean c = obj.uniqueIDCheck("C:\\Users\\DEEPUAISHU\\IdeaProjects\\Sprint2\\Test\\Vedant(with error).ged");
            Assert.assertTrue(c);



    }
}


