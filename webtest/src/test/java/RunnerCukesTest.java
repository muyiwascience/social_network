import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        dryRun = false
        , monochrome = true
        , plugin = {
        "pretty",
        "html:target/cucumber/report",
        //"json:target/cukes-test-report/report-json.json",
        "json:target/cucumber.json",
        "junit:target/cukes-test-report/report-xml.xml"}
        , strict = false
        , features = {"src/test/resources"}
        , snippets = SnippetType.CAMELCASE
        , tags = {"@wip"}

)

public class RunnerCukesTest {


}
