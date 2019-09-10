package stepsdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import support.WorldHelper;

public class NewsSteps {


    private final WorldHelper helper;
    private HomePage homePage;

    public NewsSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable {
      homePage = helper.getHomePage().loadApplication();

    }

    @When("^I check a news article$")
    public void iCheckANewsArticle() throws Throwable {
        homePage=  homePage.closeYourPrivacy();
        

    }

    @Then("^I should a valid news article$")
    public void iShouldAValidNewsArticle() throws Throwable {
        Assert.assertTrue(homePage.confirmIfNewsArticleIsValid());



    }

}
