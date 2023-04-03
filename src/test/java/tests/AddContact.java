package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;

import static tests.TestBase.app;

public class AddContact {
    @BeforeClass
    public void preCondition(){

if(!app.getHelperUser().isLogged()){
    app.getHelperUser().login(new User().setEmail("maks-skam@mail.ru").setPassword("Maksim1996$"));
}
    }

    @Test
    public void additionSuccess(){
        Random random = new Random();
        int i= random.nextInt(1000);
        //String s= random.toString();
        Contact contact = Contact.builder().
                name("Maksim").lastName("Galileo").
                phone("123884"+i+"128835").
                email("galileo199"+i+"@gmail.com").
                address("NY").
                description("Friend")
                .build();
        app.getHelperAddContact().openContactForm();
        app.getHelperAddContact().fillAdditionFrom(contact);
        app.getHelperAddContact().submitNewContact();

       Assert.assertTrue(app.getHelperAddContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperAddContact().isContactAddedByPhone(contact.getPhone()));

    }
@Test
    public void additionWrongEmail(){

        Random random = new Random();
        int i= random.nextInt(1000);
    //String s= random.toString();

    Contact contact = Contact.builder().
            name("Maksim").lastName("Galileo").
            phone("123884"+i+"128835").
            email("galileo199"+i+"gmail.com").
            address("NY").
            description("Friend")
            .build();
    app.getHelperAddContact().openContactForm();
    app.getHelperAddContact().fillAdditionFrom(contact);
    app.getHelperAddContact().submitNewContact();
    }
    @Test
    public void additionWrongPhone(){
        Random random = new Random();
        int i= random.nextInt(1000);
        Contact contact = Contact.builder().
                name("Maksim").lastName("Galileo").
                phone("123884").
                email("galileo199"+i+"gmail.com").
                address("NY").
                description("Friend")
                .build();
        app.getHelperAddContact().openContactForm();
        app.getHelperAddContact().fillAdditionFrom(contact);
        app.getHelperAddContact().submitNewContact();
    }
    @Test
    public void contactIsAlreadyExisted(){

        Contact contact = Contact.builder().
                name("Lisa").lastName("Simpson").
                phone("1111111111111").
                email("bart@gmail.com").
                address("NY").
                description("Friend")
                .build();
        app.getHelperAddContact().openContactForm();
        app.getHelperAddContact().fillAdditionFrom(contact);
        app.getHelperAddContact().submitNewContact();
    }

}
