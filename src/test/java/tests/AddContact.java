package tests;


import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class AddContact extends TestBase {


    @BeforeClass
    public void preCondition(){

if(!app.getHelperUser().isLogged()){
    app.getHelperUser().login(new User().setEmail("maks-skam@mail.ru").setPassword("Maksim1996$"));
}
    }

    @Test
    public void additionSuccessAllFields(){
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
    public void successRequiredFields(){
        Random random = new Random();
        int i= random.nextInt(1000);
        Contact contact = Contact.builder().
                name("Galiley").lastName("Galileo").
                phone("123884"+i+"128835").
                email("galileo199"+i+"@gmail.com").
                address("NY").
                description("")
                .build();
        app.getHelperAddContact().openContactForm();
        app.getHelperAddContact().fillAdditionFrom(contact);
        app.getHelperAddContact().submitNewContact();
        Assert.assertTrue(app.getHelperAddContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperAddContact().isContactAddedByPhone(contact.getPhone()));
    }

    @Test
    public void  addNewContactWrongAddress(){
        Random random = new Random();
        int i= random.nextInt(1000);
        Contact contact = Contact.builder().
                name("Maksim").lastName("Galileo").
                phone("123884"+i+"128835").
                email("galileo199"+i+"@gmail.com").
                address("").
                description("Friend")
                .build();
        app.getHelperAddContact().openContactForm();
        app.getHelperAddContact().fillAdditionFrom(contact);
        app.getHelperAddContact().submitNewContact();
        Assert.assertTrue(app.getHelperAddContact().isAddPageStillDisplayed());
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
    Assert.assertTrue(app.getHelperAddContact().isAddPageStillDisplayed());
    Assert.assertTrue(app.getHelperUser().isAlertPresent("Email not valid: must be a well-formed email address"));
    }

    @Test
    public void addNewContactWrongLastName(){
        Random random = new Random();
        int i= random.nextInt(1000);
        Contact contact = Contact.builder().
                name("Maksim").lastName("").
                phone("123884"+i+"128835").
                email("galileo199"+i+"@gmail.com").
                address("NY").
                description("Friend")
                .build();
        app.getHelperAddContact().openContactForm();
        app.getHelperAddContact().fillAdditionFrom(contact);
        app.getHelperAddContact().submitNewContact();
        // Assert.assertTrue(app.getHelperAddContact().isElementPresent());
    }

    @Test
    public void addNewContactWrongName(){
        Random random = new Random();
        int i= random.nextInt(1000);
        Contact contact = Contact.builder().
                name("").lastName("Galileo").
                phone("123884"+i+"1288535").
                email("galileo"+i+"@gmail.com").
                address("NY").
                description("Friend")
                .build();
        app.getHelperAddContact().openContactForm();
        app.getHelperAddContact().fillAdditionFrom(contact);
        app.getHelperAddContact().submitNewContact();
        Assert.assertTrue(app.getHelperAddContact().isAddPageStillDisplayed());
    }

    @Test
    public void additionWrongPhone(){
        Random random = new Random();
        int i= random.nextInt(1000);
        Contact contact = Contact.builder().
                name("Maksim").lastName("Galileo").
                phone("123884").
                email("galileo199"+i+"@gmail.com").
                address("NY").
                description("Friend")
                .build();
        app.getHelperAddContact().openContactForm();
        app.getHelperAddContact().fillAdditionFrom(contact);
        app.getHelperAddContact().submitNewContact();
        Assert.assertTrue(app.getHelperAddContact().isAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperUser().isAlertPresent(" Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));
      //  Assert.assertTrue(app.getHelperAddContact().isNoContactHereDisplayed());
     ///   Assert.assertTrue(app.getHelperAddContact().isAlertPresent("ZAPOLNI !!!!!"));
    }














}
