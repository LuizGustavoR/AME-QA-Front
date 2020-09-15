package utils;

import factory.SeleniumFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitComponentVisibility {

    private static WebDriverWait wait;

    private static WebDriverWait getInstance(){
        if (wait == null){
            wait = new WebDriverWait(SeleniumFactory.getInstance(), 16);
        }
        return wait;
    }

    public static void waitVisibilityOf(WebElement webElement){
        getInstance().until(ExpectedConditions.visibilityOf(webElement));
    }

}
