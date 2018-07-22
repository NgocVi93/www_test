package Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

/**
 * Created by sysadmin on 10/5/17.
 */
public class LoginPage  {

private WebDriver driver;

//Button Login
By button_login=By.cssSelector("a.btn.btn-primary");
By Username =By.name("username");
By Password =By.name("password");
By Submit =By.cssSelector("input.btn.btn-primary");
//By Alert=By.cssSelector("div.alert.alert-success");


    public  LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void ClickButtonLogin()
    {
    driver.findElement(button_login).click();

    }

    public  void setClearUsername()
    {
        driver.findElement(Username).clear();
    }


    public  void setClearPassword()
    {
        driver.findElement(Password).clear();
    }


    public void setUsername(String username)
    {
        driver.findElement(Username).sendKeys(username);
    }


    public void setPassword(String password)
    {
        driver.findElement(Password).sendKeys(password);
    }


  /*  public String setAlert()
    {
        return  driver.findElement(Alert).getText();

    }*/

    public void setSubmit()
        {
            driver.findElement(Submit).click();
        }

    public void  sleep ( int time) throws InterruptedException
    {
        Thread.sleep(time);
    }

        public void Login(String strUsername, String strPassword) throws Exception
        {



            String LoginURL= driver.getCurrentUrl();
            System.out.print("LoginURL "+ LoginURL+"\n");
            //Click Login button

        sleep(5000);



               //Clear UserName
               this.setClearUsername();
               this.setUsername(strUsername);
               //Clear Password
               this.setClearPassword();
               this.setPassword(strPassword);

               //Click submit
               this.setSubmit();



           }

}
