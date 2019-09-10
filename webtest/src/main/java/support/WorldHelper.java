package support;


import config.BrowserFactory;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.HomePage;



public class WorldHelper extends BrowserFactory {


    private HomePage homePage;
    private BasePage basePage;

    public BasePage getBasePage(){
        if (basePage == null) {
            basePage = PageFactory.initElements(driver, BasePage.class);
        }
        return basePage;

    }


    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = PageFactory.initElements(driver, HomePage.class);
        }
        return homePage;
    }
}