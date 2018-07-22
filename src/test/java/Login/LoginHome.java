package Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
/**
 * Created by sysadmin on 10/6/17.
 */
public class LoginHome {

    WebDriver driver;
    By Alert=By.cssSelector("div.alert.alert-success");


    public LoginHome(WebDriver driver)
    {
        this.driver=driver;
    }


//Get alert from Login Page
    public String getAlert()
    {
        return driver.findElement(Alert).getText();
    }
    public String getURL()
    {
     return driver.getCurrentUrl();
    }
}
