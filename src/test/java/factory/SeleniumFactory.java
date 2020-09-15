package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import utils.Util;

import static utils.Constants.CHROMEDRIVER_PATH;

public class SeleniumFactory {

    private static WebDriver webDriver;

    public static WebDriver getInstance() {
        if(webDriver == null){
            if (Util.getOS().equals(Util.OS.WINDOWS)){
                System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH + "chromedriver.exe");
            }else if (Util.getOS().equals(Util.OS.MAC)){
                System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH + "chromedriver");
            }
            webDriver = new ChromeDriver();
        }
        SessionId sessionid = ((RemoteWebDriver) webDriver).getSessionId();
        if(sessionid == null){
            webDriver = new ChromeDriver();
        }
        return webDriver;
    }

}
