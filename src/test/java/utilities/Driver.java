package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){

    }


    private static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver == null){
            String browser = Config.getProperty("browser");
            if ("chrome".equals(browser)) {
                WebDriverManager.chromedriver().setup();
 //               System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
                ChromeOptions options = new ChromeOptions();
                //options.setHeadless(true);
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("ignore-certificate-errors");
                options.addArguments("start-maximized");
                options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                options.setExperimentalOption("useAutomationExtension", false);
                driver = new ChromeDriver(options);
               // driver = new ChromeDriver();
            } else if ("firefox".equals(browser)) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else {
                WebDriverManager.chromedriver().setup();
//                System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
                ChromeOptions options = new ChromeOptions();
//                //options.setHeadless(true);
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("ignore-certificate-errors");
                options.addArguments("start-maximized");
                options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                options.setExperimentalOption("useAutomationExtension", false);
                driver = new ChromeDriver(options);
 //               driver = new ChromeDriver();
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();

        }
        return driver;
    }



    public static void quitDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }


}
