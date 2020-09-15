package steps;

import factory.SeleniumFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

public class LoginSteps{

    private HomePage homePage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;

    @Before
    public void setup(){
        homePage = new HomePage();
        loginPage = new LoginPage();
        myAccountPage = new MyAccountPage();
    }

    @Given("User is in the home page of the site")
    public void userInHomePage(){
        SeleniumFactory.getInstance().get("http://automationpractice.com/index.php");
    }

    @And("go to Sign in page")
    public void goToSignInPage(){
        homePage.btnSignInClick();
    }

    @When("User enter valid {string} and {string}")
    @When("User enter invalid {string} and {string}")
    public void userEnterValidEmailAndPassword(String email, String password) {
        loginPage.setTxtEmail(email);
        loginPage.setTxtPassword(password);
        loginPage.btnLoginClick();
    }

    @Then("User should be taken to the My Account page")
    public void userRedirect(){
        Assert.assertEquals(myAccountPage.getLblPageName(), "MY ACCOUNT");
        myAccountPage.clickBtnLogOut();
    }

    @Then("User should receive the error message {string}")
    public void userShouldReceiveErrorMessage(String message){
        Assert.assertEquals(loginPage.getSpanAlertMessage(), message);
    }

    @After
    public void endTest(){
        SeleniumFactory.getInstance().quit();
    }

}