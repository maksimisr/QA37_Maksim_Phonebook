package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase{
    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        //if sign out present -> logout
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }
    @Test
    public void registrationSuccess(){

        Random random= new Random();
        int i =random.nextInt(1000);
      //  System.currentTimeMillis();

        User user = new User().setEmail("maks"+i+"@mail.ru").setPassword("Maksim1996$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistrationFrom();

        Assert.assertTrue(app.getHelperUser().isLogged());
    }

    @Test
    public void registrationWrongEmailFormat(){
        Random random= new Random();
        int i =random.nextInt(1000);
        User user = new User().setEmail("mask"+i+"mail.ru").setPassword("Maksim1996$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistrationFrom();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
    }

    @Test(groups = {"smoke"})
    public void registrationWrongPaswordFormat(){
        Random random= new Random();
        int i =random.nextInt(1000);
        User user = new User().setEmail("maks"+i+"@mail.ru").setPassword("maksim");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistrationFrom();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
    }

    @Test
    public void userIsAlreadyRegistered(){

        User user = new User().setEmail("maks-skam@mail.ru").setPassword("Maksim1996$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistrationFrom();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("User already exist"));
    }

}
