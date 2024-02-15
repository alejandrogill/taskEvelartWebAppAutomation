package stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import task.CompleteCycles;
import task.Login;
import utils.MyWebDriver;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static utils.Constant.URL;

public class TestAutomationStepDefinitions {

    @Before
    public void before(){
        WebDriverManager.chromedriver().setup();
        OnStage.setTheStage(Cast.ofStandardActors());
    }

    @Given("^(.*) is in the test page$")
    public void theUserIsInTheTestPage(String name) {
        OnStage.theActorCalled(name).whoCan(BrowseTheWeb.with(MyWebDriver.inUrl(URL)));
    }


    @When("^he complete all ciclos$")
    public void heCompleteAllCiclos() {
        theActorInTheSpotlight().attemptsTo(Login.whitUser("785837").andPass("10df2f32286b7120Mi00LTczODU4Nw==30e0c83e6c29f1c3"));
        theActorInTheSpotlight().attemptsTo(CompleteCycles.inThePage());


    }

    @Then("he shoulds see that the result")
    public void he_shoulds_see_that_the_result() throws InterruptedException {
        Thread.sleep(50000);
    }


}
