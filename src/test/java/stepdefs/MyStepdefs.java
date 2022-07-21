package stepdefs;

import implementation.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MyStepdefs {
    @Steps
    HomePage homePage;
    @Given("I open google home Page and accept cookies")
    public void iOpenGoogleHomePage() {
        homePage = new HomePage();
        homePage.openPage();
    }

    @When("I search for {string}")
    public void iSearchFor(String text) {
        homePage.searchForText(text);
    }

    @Then("I see {string} among the result")
    public void iSeeHadrianCorporateSiteAmongTheResult(String text) {
       homePage.textIsAmongResult(text);
       homePage.quitDriver();
    }

    @And("I see {string} among first 10 pages")
    public void theSiteIsAmongTheFirstPages(String text) {
        homePage.siteAmongTenPages(text);
        homePage.quitDriver();
    }
}
