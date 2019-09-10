package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class BasePage {
    protected WebDriverWait wait;
    private FileInputStream fis;
    protected WebDriver driver;
    private Properties config;



    public BasePage(WebDriver driver) {
        wait = new WebDriverWait(driver, 20);
        this.driver = driver;

        try

        {
            fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/ObjectRepo.properties");
        }

        catch(
                FileNotFoundException e
        )

        {
            e.printStackTrace();
        }

        try

        {
            config = new Properties();
            config.load(fis);
        }

        catch(
                IOException e
        )

        {
            e.printStackTrace();
        }
    }



    public HomePage loadApplication() {
        driver.navigate().to(config.getProperty("baseUrl"));
        return PageFactory.initElements(driver, HomePage.class);

    }

}

