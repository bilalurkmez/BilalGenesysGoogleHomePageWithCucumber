package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

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
                ChromeOptions options = new ChromeOptions();
                //options.setHeadless(true);
                options.addArguments("start-maximized");
                options.addArguments("disable-infobars");
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--no-sandbox");
                driver = new ChromeDriver(options);
            } else if ("firefox".equals(browser)) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                //options.setHeadless(true);
                options.addArguments("start-maximized");
                options.addArguments("disable-infobars");
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--no-sandbox");
                driver = new ChromeDriver(options);
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
