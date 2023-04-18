package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class HelperAddContact extends HelperBase {

    public HelperAddContact(WebDriver wd) {
        super(wd);
    }

    public void openContactForm(){
        click(By.xpath("//a[@href='/add']"));
    }

    public void fillAdditionFrom(Contact contact){
        type(By.xpath("//input[@placeholder='Name']"),contact.getName());
        type(By.xpath("//input[@placeholder='Last Name']"),contact.getLastName());
        type(By.xpath("//input[@placeholder='Phone']"),contact.getPhone());
        type(By.xpath("//input[@placeholder='email']"),contact.getEmail());
        type(By.xpath("//input[@placeholder='Address']"),contact.getAddress());
        type(By.xpath("//input[@placeholder='description']"),contact.getDescription());

    }

    public void submitNewContact(){
       // getScreenElement("src/test/screenshots/screen-btn.png", By.xpath("//b[.='Save']");
        click(By.xpath("//b[.='Save']"));
    }


    public boolean isContactAddedByName(String name) {
        List<WebElement> list = wd.findElements(By.cssSelector("h2"));
        for (WebElement el:list) {
            if(el.getText().equals(name)){
                return true;
            }
        }
        return false;
    }

    public boolean isContactAddedByPhone(String phone) {
        List<WebElement> list= wd.findElements(By.cssSelector("h3"));

        for (WebElement el:list) {
           if(el.getText().equals(phone)) {
               return true;
           }
        }
        return false;
    }


    public boolean isAddPageStillDisplayed() {
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));
        boolean res = wait.until(ExpectedConditions.textToBePresentInElement(wd.findElement(By.xpath("//a[@style='border: 1px solid black; background-color: black; color: white;']")),"ADD"));
        return res;

    }

    public void chooseContactToRemoveByName(){
        click(By.xpath("//div/h2[text()='Bart']"));
    }

    public void removeContact(){
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[.='Remove']"));
        pause(500);
    }

    public int removeOneContact() {
        int before = countOfContacts();
        logger.info("Number of contact lists before remove is--> "+before );
        removeContact();
        int after = countOfContacts();
        logger.info("Number of contact lists after remove  is--> " +after );


        return before-after;
    }

    private int countOfContacts() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
    }
    public void removeAllContact(){
        while (wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size()!=0)
        {
            removeContact();
        }
    }
    public void provideContatcs(){
        if(countOfContacts()<3){
            for (int i = 0; i < 3; i++) {
                addOneContact();
            }
        }
    }

    private void addOneContact() {
        int i = new  Random().nextInt(1000)+1000;
        Contact contact= Contact.builder()
                .name("Harry"+i)
                .lastName("Potter")
                .address("Hogwards")
                .email("harry@"+i+"gmail.com")
                .phone("5444784643843")
                .description("Strudent")
                .build();
openContactForm();
fillAdditionFrom(contact);
submitNewContact();
pause(500);

    }
}

