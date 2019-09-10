package hooks;


import config.BrowserFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class GeneralHooks {



    private BrowserFactory browserFactory;


    @Before(order = 2)
    public void testSetUp() {
        browserFactory = new BrowserFactory();
        browserFactory.initialiseBrowsers().cleanUpBrowsers();

    }

    @After(order = 2)
    public void testCleanUp(Scenario scenario){
        browserFactory.screenCapture(scenario);
        browserFactory.tearDownBrowsers();
    }

}
