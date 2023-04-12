package manager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void type(By locator, String text){
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        if(text!=null){

            element.sendKeys(text);
        }
    }

    public void click(By locator){
        WebElement element= wd.findElement(locator);
        element.click();
    }
    public boolean isElementPresent(By locator){
        List<WebElement> list = wd.findElements(locator);
        return list.size()>0;
    }

    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isNoContactHereDisplayed(){
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));
        boolean res = wait.until(ExpectedConditions.textToBePresentInElement(wd.findElement(By.cssSelector(".contact-page_message"))," No contacts here"));
        return res;
    }

    public boolean isAlertPresent(String message) {
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));
        Alert alert= wait.until(ExpectedConditions.alertIsPresent());

        if(alert !=null && alert.getText().contains(message)){
            System.out.println(alert.getText());

            alert.accept();

            // alert.dismiss();
            //if it "cancel" button

            //alert.sendKeys("hello");
            // if needed to write something
            return true;

        }
        return false;
    }


}
