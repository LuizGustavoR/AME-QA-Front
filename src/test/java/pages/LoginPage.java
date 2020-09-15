package pages;

import factory.SeleniumFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitComponentVisibility;

import java.util.List;

public class LoginPage {

    @FindBy(id = "email")
    public WebElement txtEmail;

    @FindBy(id = "passwd")
    public WebElement txtPassword;

    @FindBy(id = "SubmitLogin")
    public WebElement btnLogin;

    @FindBy(className = "alert")
    public WebElement spanAlert;

    public LoginPage(){
        PageFactory.initElements(SeleniumFactory.getInstance(), this);
    }

    public void setTxtEmail(String txtEmail) {
        WaitComponentVisibility.waitVisibilityOf(this.txtEmail);
        this.txtEmail.sendKeys(txtEmail);
    }

    public void setTxtPassword(String txtPassword) {
        WaitComponentVisibility.waitVisibilityOf(this.txtPassword);
        this.txtPassword.sendKeys(txtPassword);
    }

    public void btnLoginClick() {
        WaitComponentVisibility.waitVisibilityOf(btnLogin);
        btnLogin.click();
    }

    public String getSpanAlert() {
        WaitComponentVisibility.waitVisibilityOf(spanAlert);
        return spanAlert.getText();
    }

    // return only the first error message
    public String getSpanAlertMessage() {
        WaitComponentVisibility.waitVisibilityOf(spanAlert);

        WebElement span = spanAlert.findElement(By.cssSelector("ol"));
        List<WebElement> alerts = span.findElements(By.tagName("li"));
        for (WebElement li : alerts) {
            return li.getText();
        }
        return null;
    }

}
