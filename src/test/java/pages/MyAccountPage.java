package pages;

import factory.SeleniumFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    @FindBy(className = "page-heading")
    public WebElement lblPageName;

    @FindBy(linkText = "Sign out")
    public WebElement btnLogOut;

    public MyAccountPage(){
        PageFactory.initElements(SeleniumFactory.getInstance(), this);
    }

    public String getLblPageName() {
        return lblPageName.getText();
    }

    public void clickBtnLogOut() {
        btnLogOut.click();
    }

}
