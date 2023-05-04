package tests;

import manager.DataProviderContact;
import manager.DataProviderUser;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginTests extends TestBase{

    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        //if sign out present -> logout
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
            logger.info("before method finish logout");
        }
    }
    @Test(dataProvider = "loginData",dataProviderClass = DataProviderUser.class)
    public void loginSuccess(User user) {
        logger.info("Start test with name 'loginSuccess' ");
        logger.info("TEst data---> " +user.toString());
       // User user = new User().setEmail("maks-skam@mail.ru").setPassword("Maksim1996$");
       app.getHelperUser().openLoginRegistrationForm();
       app.getHelperUser().fillLoginRegistrationForm(user);
       app.getHelperUser().submitLogin();

       Assert.assertTrue(app.getHelperUser().isLogged());
       logger.info("Assert check is element button 'Sign out' present");

    }


    @Test(dataProvider = "loginFile",dataProviderClass = DataProviderContact.class)
    public void loginSuccessModel(User user){
        logger.info("Start test with name 'loginSuccessModel' ");
        logger.info("TEst data--->  email: 'maks-skam@mail.ru' & password: 'Maksim1996$' ");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
    }

    @Test(groups = {"smoke"})
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
