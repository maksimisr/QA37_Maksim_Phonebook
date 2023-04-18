package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {
    @BeforeClass
    public void preCondition() {

        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().setEmail("maks-skam@mail.ru").setPassword("Maksim1996$"));

            app.getHelperAddContact().provideContatcs();
        }

    }
    @Test
public void RemoveContactFromList(){

        Assert.assertEquals(app.getHelperAddContact().removeOneContact(),1);


}
//public void removeAllConatcs(){
   //Assert.assertEquals(app.getHelperAddContact().removeAllContact(),1);
//}
}
