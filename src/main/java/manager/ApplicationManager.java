package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ApplicationManager {
    WebDriver wd;
    HelperUser helperUser;

    HelperAddContact helperAddContact;

    HelperRemoveContact helperRemoveContact;

    public void init(){
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        wd= new ChromeDriver(options);
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wd.navigate().to("https://telranedu.web.app/login");
        helperUser= new HelperUser(wd);
        helperAddContact= new HelperAddContact(wd);
        helperRemoveContact= new HelperRemoveContact(wd);



    }

    public HelperUser getHelperUser() {
        return helperUser;
    }

    public HelperAddContact getHelperAddContact(){ return helperAddContact;}

    public HelperRemoveContact getHelperRemoveContact(){return helperRemoveContact;}

    public void stop(){
    wd.quit();
    }


}
