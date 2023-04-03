package manager;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm(){
      //  WebElement loginTab= wd.findElement(By.xpath("//a[text()='LOGIN']"));
        //css a[text()='LOGIN']

       // loginTab.click();
        click(By.xpath("//a[text()='LOGIN']"));
    }

    public void fillLoginRegistrationForm(String email, String password){
     //  WebElement emailInput= wd.findElement(By.name("email"));
       // emailInput.click();
      //  emailInput.clear();
      //  emailInput.sendKeys(email);
        type(By.name("email"),email);
      //  WebElement passwordInput= wd.findElement(By.xpath("//input[last()]"));
       // passwordInput.click();
       // passwordInput.clear();
       // emailInput.sendKeys(password);
        type(By.xpath("//input[last()]"),password);
    }

    public void fillLoginRegistrationForm(User user){

        type(By.xpath("//input[@name='email']"), user.getEmail());

        type(By.xpath("//input[last()]"), user.getPassword());
    }
    public void submitLogin(){
        click(By.xpath("//button[text()='Login']"));
    }

    public void submitRegistrationFrom()
    {
        click(By.cssSelector("button[name='registration']"));
    }
    public boolean isLogged(){
        pause(2000);
        return isElementPresent(By.xpath("//button[text()='Sign Out']"));
    }

    public void logout() {
        click(By.xpath("//button[text()='Sign Out']"));
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

    public boolean isNoContactHereDisplayed(){
        WebDriverWait wait = new WebDriverWait(wd,Duration.ofSeconds(5));
      boolean res = wait.until(ExpectedConditions.textToBePresentInElement(wd.findElement(By.cssSelector(".contact-page_message"))," No contacts here"));
        return res;
    }

    public void login(User user) {
        openLoginRegistrationForm();
        fillLoginRegistrationForm(user);
        submitLogin();
    }
}
