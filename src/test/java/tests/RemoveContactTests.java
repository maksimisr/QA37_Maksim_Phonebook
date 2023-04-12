package tests;

import models.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {
    @BeforeClass
    public void preCondition() {

        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().setEmail("maks-skam@mail.ru").setPassword("Maksim1996$"));
        }

    }
    @Test
public void RemoveContactFromList(){
        app.getHelperRemoveContact().chooseContactToRemoveByName();
        app.getHelperRemoveContact().removeContact();
}

}