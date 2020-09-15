package pages;

import factory.SeleniumFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitComponentVisibility;

public class HomePage {

    @FindBy(className = "login")
    public WebElement btnSignIn;

    public HomePage(){
        PageFactory.initElements(SeleniumFactory.getInstance(), this);
    }

    public void btnSignInClick(){
        WaitComponentVisibility.waitVisibilityOf(btnSignIn);
        btnSignIn.click();
    }

}
