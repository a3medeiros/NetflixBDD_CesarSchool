package netflixTests;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import netflixTests.pages.*;
import netflixTests.support.Constants;
import netflixTests.support.Web;
import org.junit.Assert;

public class StepDefinition{

    //initialize the driver(FF or Chrome)
    @Before
    public void setUp() {
        Web.driver = Web.createFirefox();
    }

    //close window
    @After
    public void tearDown() {
       Web.driver.quit();
    }

    @Given("a web browser is at the Netflix home page")
    public void a_web_browser_is_at_the_Netflix_home_page(){
        Web.driver.get(Constants.NETFLIX_URL);
    }

    @When("the user wants to change the language from PT to EN")
    public void the_user_wants_to_change_the_language_from_PT_to_EN() {
        new NetflixHomePage(Web.driver).changeLanguage("English");
    }

    @Then("Netflix page gets translated to english")
    public void netflix_page_gets_translated_to_english() {
        Assert.assertEquals("https://www.netflix.com/br-en/",Web.driver.getCurrentUrl());
    }

    @When("the user wants to log in with an inexistent {string}")
    public void the_user_wants_to_log_in_with_an_inexistent(String string) {
        new NetflixHomePage(Web.driver).clickToSignIn().writeEmailField(string).writePswdField("Testezera123").loginSubmitError();
    }

    @Then("Netflix page returns an error message")
    public void netflix_page_returns_an_error_message() {
        String errorMsg = new NetflixSignUpPage(Web.driver).getErrorMsg();
       Assert.assertEquals(Constants.LOGIN_ERROR,errorMsg);
    }

    @When("the user selects Watch Free for Thirty days")
    public void the_user_selects_Watch_Free_for_Thirty_days() {
        new NetflixHomePage(Web.driver).click30DaysSign();
    }

    @When("Wants to see the plans to sign")
    public void wants_to_see_the_plans_to_sign() {
        new NetflixPlansNotifyPage(Web.driver).clickShowPlans();
    }

    @Then("the following related plans are shown")
    public void the_following_related_plans_are_shown() {
        String plan03 = new NetflixPlansPage(Web.driver).getBoxPlanName03();
        String plan01 = new NetflixPlansPage(Web.driver).getBoxPlanName01();
        String plan02 = new NetflixPlansPage(Web.driver).getBoxPlanName02();
        Assert.assertEquals("Básico",plan01);
        Assert.assertEquals("Padrão",plan02);
        Assert.assertEquals("Premium",plan03);
    }

    @When("the user clicks on Contact Us")
    public void the_user_clicks_on_Contact_Us() {
        new NetflixHomePage(Web.driver).clickToContactUs();
    }

    @When("Clicks on Call us")
    public void clicks_on_Call_us() {
            new NetflixContactPage(Web.driver).closeModal().clickCallForUs();
    }

    @Then("Netflix contact number for Brazil is shown")
    public void netflix_contact_number_for_Brazil_is_shown() {
            String netflixBRNumber = new NetflixContactPage(Web.driver).getNetflixBRnumber();
            Assert.assertEquals("0800-887-0201",netflixBRNumber);
    }

    @When("the user wants to see the the ways to watch Netflix")
    public void the_user_wants_to_see_the_the_ways_to_watch_Netflix() {
      new NetflixHomePage(Web.driver).clickToWaysToWatch();
    }

    @Then("Netflix display the {string} of devices is available")
    public void netflix_display_the_of_devices_is_available(String string) {
        String result = new NetflixWaysToWatchPage(Web.driver).getWay2Watch(string);
        Assert.assertEquals(string,result);
    }
}
