package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    @FindBy(css = "button > span:nth-child(2)")
    private WebElement acceptCookie = null;



    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage closeYourPrivacy(){
        wait.until(ExpectedConditions.elementToBeClickable(acceptCookie));
        acceptCookie.click();
        return PageFactory.initElements(driver, HomePage.class);

    }

    public boolean confirmIfNewsArticleIsValid(){
        wait.until(ExpectedConditions
                .urlContains("https://www.theguardian.com/tone/news"));
        return driver.getPageSource().toLowerCase().contains("Support The Guardian".toLowerCase());

    }
}
