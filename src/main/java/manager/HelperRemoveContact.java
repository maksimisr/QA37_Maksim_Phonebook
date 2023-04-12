package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperRemoveContact extends HelperBase{

    public HelperRemoveContact(WebDriver wd) {
        super(wd);
    }
    public void chooseContactToRemoveByName(){
        click(By.xpath("//div/h2[text()='Bart']"));
    }

public void removeContact(){
        click(By.xpath("//button[.='Remove']"));
}
}
