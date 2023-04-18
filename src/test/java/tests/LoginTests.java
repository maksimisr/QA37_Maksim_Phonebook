package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        //if sign out present -> logout
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
            logger.info("before method finish logout");
        }
    }
    @Test
    public void loginSuccess(){
        logger.info("Start test with name 'loginSuccess' ");
        logger.info("TEst data--->  email: 'maks-skam@mail.ru' & password: 'Maksim1996$' ");
        User user = new User().setEmail("maks-skam@mail.ru").setPassword("Maksim1996$");
       app.getHelperUser().openLoginRegistrationForm();
       app.getHelperUser().fillLoginRegistrationForm(user);
       app.getHelperUser().submitLogin();

       Assert.assertTrue(app.getHelperUser().isLogged());
       logger.info("Assert check is element button 'Sign out' present");
    }


    @Test
    public void loginSuccessModel(){
        logger.info("Start test with name 'loginSuccessModel' ");
        logger.info("TEst data--->  email: 'maks-skam@mail.ru' & password: 'Maksim1996$' ");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("maks-skam@mail.ru","Maksim1996$");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
    }

    @Test
    public void loginWrongEmail(){
        logger.info("Start test with name 'loginWrongEmail' ");
        logger.info("TEst data--->  email: 'maskam@mail.ru' & password: 'Maksim1996$' ");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("maskam@mail.ru","Maksim1996$");
        app.getHelperUser().submitLogin();
      Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }

    @Test
    public void loginWrongPassword(){
        logger.info("Start test with name 'loginWrongPasswor' ");
        logger.info("TEst data--->  email: 'maks-skam@mail.ru' & password: 'Maafzdm1996$' ");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("maks-skam@mail.ru","Maafzdm1996$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }

    @Test
    public void loginUnregisteredUser(){
        logger.info("Start test with name 'loginUnregisteredUser' ");
        logger.info("TEst data--->  email: 'maksskam@mail.ru' & password: 'Makssm1996$' ");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("maksskam@mail.ru","Makssm1996$");
        app.getHelperUser().submitLogin();
    }
}
