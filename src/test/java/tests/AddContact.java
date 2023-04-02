package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;

import static tests.TestBase.app;

public class AddContact {
    @BeforeTest
    private void preCondition(){

            User user = new User().setEmail("maks-skam@mail.ru").setPassword("Maksim1996$");
            app.getHelperUser().openLoginRegistrationForm();
            app.getHelperUser().fillLoginRegistrationForm(user);
            app.getHelperUser().submitLogin();

            Assert.assertTrue(app.getHelperUser().isLogged());


    }

    @Test
    public void additionSuccess(){
        Random random = new Random();
        int i= random.nextInt(1000);
        //String s= random.toString();
        Contact contact = new Contact();
        contact.setName("Maksim");
        contact.setLastName("Galileo");
        contact.setPhone("123884"+"i"+"128835");
        contact.setEmail("galileo199"+"i"+"@gmail.com");
        contact.setAddress("NY");
        contact.setDescription("Friend");

    }
@Test
    public void additionWrongEmail(){
        Contact contact = new Contact();
        Random random = new Random();
        int i= random.nextInt(1000);
    //String s= random.toString();

        contact.setName("Galiley");
        contact.setLastName("Galileo");
        contact.setPhone("123884"+"i"+"128835");
        contact.setEmail("galileo199"+i+"gmail.com");
        contact.setAddress("Haifa");
        contact.setDescription("Friend");
    }
    @Test
    public void additionWrongPhone(){
        Random random = new Random();
        int i= random.nextInt(1000);
        Contact contact = new Contact();
        contact.setName("Galiley");
        contact.setLastName("Galileo");
        contact.setPhone("1234968");
        contact.setEmail("galileo199"+"i"+"@gmail.com");
        contact.setAddress("Rehovot");
        contact.setDescription("Friend");
    }
    @Test
    public void contactIsAlreadyExisted(){
        Contact contact = new Contact();
        contact.setName("Lisa");
        contact.setLastName("Simpson");
        contact.setPhone("1111111111111");
        contact.setEmail("bart@gmail.com");
        contact.setAddress("NY");
        contact.setDescription("Friend");
    }
}
