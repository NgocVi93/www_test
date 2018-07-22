package Login;

import Amely.amely;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by sysadmin on 10/5/17.
 */


public class LoginTest extends amely{

     WebDriver driver;
     LoginPage objLogin ;
     LoginHome objHome;

    @BeforeClass(alwaysRun = true)
    public void setupwebbrowser() throws Exception {
        LoginTest setup=new LoginTest();
        setup.setUp();


    }
    // Get Thông báo lỗi
    private String AlertInvalidUserOrPassword ="×\n" +
        "Invalid username or passsword!";
    private String LoginHomeURL="https://amely.com";
    @Test(priority = 1)
        public void CheckCaseNullUserNameAndPassword() throws Exception
    {
        objLogin =new LoginPage(driver);
        objHome= new LoginHome(driver);
        driver.findElement(By.cssSelector("a.btn.btn-primary")).click();
         try
         {
            //Call Login function
            objLogin.sleep(2000);
            objLogin.Login("","");
            objLogin.sleep(3000);

         //Compare Alert
            Assert.assertEquals(objHome.getAlert(), AlertInvalidUserOrPassword,"Passed Alert Invalid username or Password");
            Assert.assertEquals(objHome.getURL(),LoginHomeURL,"Passed URL login Home");
        //Compare URL
            objLogin.sleep(3000);
          }
        catch (Exception E)
             {
            System.out.print("Failed CheckCaseNullUserNameAndPassword ");
             }
    }


    @Test(priority = 2)
    public void CheckCaseOnlyFillUsername () throws Exception
    {
        objLogin =new LoginPage(driver);
        objHome= new LoginHome(driver);

        try
        {


            //Call Login function
            objLogin.sleep(2000);
            objLogin.Login("vipn123","");
            objLogin.sleep(3000);

            //Compare Alert
            Assert.assertEquals(objHome.getAlert(), AlertInvalidUserOrPassword,"Passed Alert Invalid username or Password");
            Assert.assertEquals(objHome.getURL(),LoginHomeURL,"Passed URL login Home");
            //Compare URL
            objLogin.sleep(3000);
        }
        catch (Exception E)
        {
            System.out.print("Failed CheckCaseOnlyFillUsername ");
        }
    }

    @Test(priority = 3)
    public void CheckCaseOnlyFillPassword () throws Exception
    {
        objLogin =new LoginPage(driver);
        objHome= new LoginHome(driver);

        try
        {


            //Call Login function
            objLogin.sleep(2000);
            objLogin.Login("","vipn123");
            objLogin.sleep(3000);

            //Compare Alert
            Assert.assertEquals(objHome.getAlert(), AlertInvalidUserOrPassword,"Passed Alert Invalid username or Password");
            Assert.assertEquals(objHome.getURL(),LoginHomeURL,"Passed URL login Home");
            //Compare URL
            objLogin.sleep(3000);
        }
        catch (Exception E)
        {
            System.out.print("Failed CheckCaseOnlyFillPassword ");
        }
    }

    @Test(priority = 4)
    public void CheckCaseInccrectPassword() throws InterruptedException
    {
        objLogin =new LoginPage(driver);
        objHome= new LoginHome(driver);
        try
        {


            //Call Login function
            objLogin.sleep(2000);
            objLogin.Login("vipn123","vipn123890");
            objLogin.sleep(3000);

            //Compare Alert
            Assert.assertEquals(objHome.getAlert(), AlertInvalidUserOrPassword,"Passed Alert Invalid username or Password");
            Assert.assertEquals(objHome.getURL(),LoginHomeURL,"Passed URL login Home");
            //Compare URL
            objLogin.sleep(3000);
        }
        catch (Exception E)
        {
            System.out.print("Failed CheckCaseOnlyFillPassword ");
        }

    }

    /*@Test(priority = 5)
    public void CheckCaseLoginSuccesWithUserName() throws Exception
    {
        objLogin =new LoginPage(driver);
        objLogin.sleep(2000);
        try {
        driver.findElement(By.cssSelector("a.btn.btn-primary")).click();
        String urrentURL=driver.getCurrentUrl();
            objLogin.Login("vipn123","vipn123");
            objLogin.sleep(3000);
            String ExpectedURL=driver.getCurrentUrl();
        Assert.assertEquals("https://amely.comhome",ExpectedURL);
            //Compare URL
            objLogin.sleep(3000);
            driver.findElement(By.cssSelector("li.ossn-topbar-dropdown-menu")).click();
            driver.findElement(By.cssSelector("a.menu-topbar-dropdown-logout")).click();
            objLogin.sleep(3000);
    }
        catch (InterruptedException E)
    {

    }


    }
   @Test(priority = 6)
    public void CheckCaseLoginSuccesWithEmail() throws Exception
    {
        objLogin =new LoginPage(driver);
        objLogin.sleep(2000);
        try {
            driver.findElement(By.cssSelector("a.btn.btn-primary")).click();

            String urrentURL = driver.getCurrentUrl();


            objLogin.Login("chiphandsome0104@gmail.com", "vipn123");
            objLogin.sleep(3000);


            String ExpectedURL = driver.getCurrentUrl();


            Assert.assertEquals("https://amely.comhome", ExpectedURL);
            //Compare URL
            objLogin.sleep(3000);
            driver.findElement(By.cssSelector("li.ossn-topbar-dropdown-menu")).click();
            driver.findElement(By.cssSelector("a.menu-topbar-dropdown-logout")).click();
            objLogin.sleep(3000);
        }
        catch (InterruptedException E)
        {

        }


    }
   @Test(priority = 7)
    public void CheckCaseLoginSuccesWithPhoneNumber() throws Exception
    {
        objLogin =new LoginPage(driver);
        objLogin.sleep(2000);
        try {
        driver.findElement(By.cssSelector("a.btn.btn-primary")).click();

        String urrentURL=driver.getCurrentUrl();


        objLogin.Login("0987456123","vipn123");
        objLogin.sleep(3000);



        String ExpectedURL=driver.getCurrentUrl();


        Assert.assertEquals("https://amely.comhome",ExpectedURL);
        //Compare URL
        objLogin.sleep(3000);
        driver.findElement(By.cssSelector("li.ossn-topbar-dropdown-menu")).click();
        driver.findElement(By.cssSelector("a.menu-topbar-dropdown-logout")).click();
        objLogin.sleep(3000);

    }
        catch (InterruptedException E)
    {

    }
    }
*/
    @AfterTest
    public void afterTest()
    {

        driver.close();

    }





}
