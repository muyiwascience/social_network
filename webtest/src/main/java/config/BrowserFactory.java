package config;

import cucumber.api.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import utilities.Screenshots;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BrowserFactory {

    protected static WebDriver driver;
    private static FileInputStream fis;
    private Properties config;


    public BrowserFactory initialiseBrowsers() {


        try {
            fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/ObjectRepo.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            config = new Properties();
            config.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(config.getProperty("browser").equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers-package/mac/chromedriver/chromedriver");
            driver = new ChromeDriver();
        }

        return PageFactory.initElements(driver, BrowserFactory.class);
    }


    public BasePage cleanUpBrowsers() {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return new BasePage(driver);
    }

    public void tearDownBrowsers() {
        if (driver != null);
        driver.quit();


    }


    public void screenCapture(Scenario scenario) {
        scenario.write("The Scenario name is "+scenario.getName()+" and the status is "+scenario.getStatus());
        if (scenario.isFailed()){
            Screenshots sc = new Screenshots(driver);
            sc.takeShot(scenario.getName());
            scenario.write("Current Page URL is: " + driver.getCurrentUrl());
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            }
        }else if(!scenario.isFailed()){
        }
    }
}
