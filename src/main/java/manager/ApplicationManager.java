package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;




public class ApplicationManager {
    Logger logger= LoggerFactory.getLogger(ApplicationManager.class);
    WebDriver wd;
    HelperUser helperUser;

    HelperAddContact helperAddContact;



    public void init(){
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        wd= new ChromeDriver(options);
        logger.info("All tests run in Chrome driver");
        WebDriverListener listener= new ListenerWD();
        wd=new EventFiringDecorator<>(listener).decorate(wd);


        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        wd.navigate().to("https://telranedu.web.app/login");
        logger.info("The link ---> " +wd.getCurrentUrl());
        helperUser= new HelperUser(wd);
        helperAddContact= new HelperAddContact(wd);




    }

    public HelperUser getHelperUser() {
        return helperUser;
    }

    public HelperAddContact getHelperAddContact(){ return helperAddContact;}




    public void stop(){
    wd.quit();
    }


}
