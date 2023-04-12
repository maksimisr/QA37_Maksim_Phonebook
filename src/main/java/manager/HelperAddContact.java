package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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
}

