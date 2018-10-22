import org.junit.Assert;
import org.junit.Test;

public class UserStory22_TEST {

    UniqueIDCheck_US22 obj = new UniqueIDCheck_US22();


    @Test
    public void UniqueIDCheck_US22() {



            Boolean b = obj.uniqueIDCheck("C:\\Users\\Vedant Soni\\Desktop\\Gedcom Files\\Vedant.ged");
            Assert.assertTrue(b);


            Boolean c = obj.uniqueIDCheck("C:\\Users\\Vedant Soni\\Desktop\\Gedcom Files\\Vedant(with error).ged");
            Assert.assertTrue(c);



    }
}





