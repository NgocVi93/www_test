/*
 * Created by sysadmin on 7/17/17.
 */

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class SignUp {
    private WebDriver driver;
    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {System.setProperty("webdriver.chrome.driver", "/home/sysadmin/ChromeDriver/chromedriver");

    //    System.setProperty("webdriver.gecko.driver", "/home/sysadmin/FifoxDriver/geckodriver");



      //  driver = new ChromeDriver();
        driver=new ChromeDriver();

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }


    public void  sleep ( int time) throws Exception
    {
        Thread.sleep(time);
    }
    static SecureRandom rnd = new SecureRandom();
    // Random numbers
    String price="123456799125412368740";
    String randomPrice(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++)
            sb.append(price.charAt(rnd.nextInt(price.length())));
        return sb.toString();
    }

    static final String AB = "abcdeghiklmnopqrstuvsy";

    String randomString( int len ){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();


    }


    @Test(priority =1)
    public void SignUpWithOnlyFillFirstname() throws Exception {


        driver.navigate().to("https://beta.ezqua.com/");
        String currentScreen = driver.getCurrentUrl();
        Thread.sleep(5000);
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys("Vi");
        sleep(2000);
        driver.findElement(By.id("ossn-submit-button")).click();
        String actualScreen =driver.getCurrentUrl();
        if (currentScreen.equals(actualScreen))
        {
            System.out.print("Pass case : SignUp With Only Fill Firstname" +"\n");
        }
        else
        {
            System.out.print("Failed case : SignUp With Only Fill Firstname" +"\n");
        }

        sleep(2000);
    }
    @Test(priority =2)
    public void SignUpWithOnlyFillLasttname() throws Exception {
        driver.navigate().refresh();
        String currentScreen = driver.getCurrentUrl();
        Thread.sleep(5000);
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys("Pham");
        sleep(2000);
        driver.findElement(By.id("ossn-submit-button")).click();
        String actualScreen =driver.getCurrentUrl();
        if (currentScreen.equals(actualScreen))
        {
            System.out.print("Pass case : SignUp With Only Fill Lastname" +"\n");
        }
        else
        {
            System.out.print("Failed case : SignUp With Only Fill Lastname" +"\n");
        }

        sleep(2000);
    }

    @Test(priority =3)
    public void SignUpWithOnlyFillEmail() throws Exception {
        driver.navigate().refresh();
        String currentScreen = driver.getCurrentUrl();
        Thread.sleep(5000);
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("erd@gmail.com");
        sleep(2000);
        driver.findElement(By.id("ossn-submit-button")).click();
        String actualScreen =driver.getCurrentUrl();
        if (currentScreen.equals(actualScreen))
        {
            System.out.print("Pass case : SignUp With Only Fill Email " +"\n");
        }
        else
        {
            System.out.print("Failed case : SignUp With Only Fill Email" +"\n");
        }

        sleep(2000);
    }
    @Test(priority =4)
    public void SignUpWithOnlyFillConfirmEmail() throws Exception {
        driver.navigate().refresh();
        String currentScreen = driver.getCurrentUrl();
        Thread.sleep(5000);
        driver.findElement(By.name("email_re")).clear();
        driver.findElement(By.name("email_re")).sendKeys("erd@gmail.com");
        sleep(2000);
        driver.findElement(By.id("ossn-submit-button")).click();
        String actualScreen =driver.getCurrentUrl();
        if (currentScreen.equals(actualScreen))
        {
            System.out.print("Pass case : SignUp With Only Fill Confirm Email  " +"\n");
        }
        else
        {
            System.out.print("Failed case : SignUp With Only Fill Confirm Email" +"\n");
        }

        sleep(2000);
    }


    @Test(priority =5)
    public void CheckMailIncorrectFormat() throws Exception {


        driver.navigate().refresh();
        Thread.sleep(5000);

        //Fill firstname
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys("Test");
        sleep(2000);


        //Fill lastname
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys("234");
        sleep(2000);

        //Fill email
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("cdre");
        sleep(2000);

        //Fill email_re
        driver.findElement(By.name("email_re")).clear();
        driver.findElement(By.name("email_re")).sendKeys("cdre");
        sleep(2000);

        //Fill username
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("TestMail");
        sleep(2000);

        //Fill password
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("111111");
        sleep(2000);

        //Fill birthdate
        driver.findElement(By.name("birthdate")).click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[6]/a")).click();
        sleep(2000);

        //Fill mobilelogin
        driver.findElement(By.name("mobilelogin")).click();
        driver.findElement(By.name("mobilelogin")).sendKeys("+84987"+randomPrice(6));


        driver.findElement(By.name("gender")).click();
        sleep(2000);

        driver.findElement(By.id("ossn-submit-button")).click();
        sleep(2000);
        String Actual = driver.findElement(By.id("ossn-signup-errors")).getText();
        sleep(2000);
        String epected = "Email không hợp lệ";


        if(epected.equals(Actual))
        {
            System.out.print("Passed case :  Email khong hơp le" +"\n");
        }
        else
        {
            System.out.print("Failed case :  Email không hơp le"+"\n");
            System.out.print("Kết quả failed: " +Actual);
        }


        sleep(2000);
    }


    @Test(priority =6)
    public void CheckConfirmEmailIncorrect() throws Exception {


        driver.navigate().refresh();


        Thread.sleep(5000);
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys("Test");
        sleep(2000);

        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys("234");
        sleep(2000);

        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("nabc@gmail.com");
        sleep(2000);

        driver.findElement(By.name("email_re")).clear();
        driver.findElement(By.name("email_re")).sendKeys("cde@gmail.com");
        sleep(2000);

        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("Test267");
        sleep(2000);

        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("111111");
        sleep(2000);

        driver.findElement(By.name("birthdate")).click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[6]/a")).click();
        sleep(2000);

        //Fill mobilelogin
        driver.findElement(By.name("mobilelogin")).click();
        driver.findElement(By.name("mobilelogin")).sendKeys("+84987"+randomPrice(6));

        driver.findElement(By.name("gender")).click();
        sleep(2000);

        driver.findElement(By.id("ossn-submit-button")).click();
        sleep(2000);
        String Actual = driver.findElement(By.id("ossn-signup-errors")).getText();
        sleep(2000);
        String expected = "Email không khớp";


        if(expected.equals(Actual))
        {
            System.out.print("Passed case : Email không khớp" +"\n");

        }
        else
        {
            System.out.print("Passed caseailed :  Email không khớp" +"\n");
            System.out.print("Kết quả failed: " +Actual);


        }


        sleep(2000);
    }


    @Test(priority =7)
    public void CheckMailWasUse() throws Exception {


        driver.navigate().refresh();


        Thread.sleep(5000);
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys("Test");
        sleep(2000);

        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys("234");
        sleep(2000);

        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("chiphandsome0104@gmail.com");
        sleep(2000);

        driver.findElement(By.name("email_re")).clear();
        driver.findElement(By.name("email_re")).sendKeys("chiphandsome0104@gmail.com");
        sleep(2000);

        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys(randomString(10));
        sleep(2000);

        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("111111");
        sleep(2000);

        driver.findElement(By.name("birthdate")).click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[6]/a")).click();
        sleep(2000);

        //Fill mobilelogin
        driver.findElement(By.name("mobilelogin")).click();
        driver.findElement(By.name("mobilelogin")).sendKeys("+84987"+randomPrice(6));

        driver.findElement(By.name("gender")).click();
        sleep(2000);

        driver.findElement(By.id("ossn-submit-button")).click();
        sleep(2000);
        String Actual = driver.findElement(By.id("ossn-signup-errors")).getText();
        sleep(2000);
        String epected = "Địa chỉ mail đã được sử dụng";


        if(epected.equals(Actual))
        {
            System.out.print("Passed case:  Địa chỉ mail đã được sử dụng" +"\n");
        }
        else
        {
            System.out.print("Failed case :  Địa chỉ mail đã được sử dụng" +"\n");
            System.out.print("Kết quả failed: " +Actual);
        }


        sleep(2000);
    }


    @Test(priority =8)
    public void SignUpWithOnlyFillUsername() throws Exception {

        driver.navigate().refresh();


        String currentScreen = driver.getCurrentUrl();
        Thread.sleep(5000);
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("testDemo");
        sleep(2000);
        driver.findElement(By.id("ossn-submit-button")).click();
        String actualScreen =driver.getCurrentUrl();
        if (currentScreen.equals(actualScreen))
        {
            System.out.print("Pass case : SignUp With Only Fill Username  " +"\n");
        }
        else
        {
            System.out.print("Failed case : SignUp With Only Fill Username" +"\n");
        }

        sleep(2000);
    }

    @Test(priority =9)
    public void SignUpWithOnlyFillPassword() throws Exception {

        driver.navigate().refresh();

        String currentScreen = driver.getCurrentUrl();
        Thread.sleep(5000);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("testDemo");
        sleep(2000);
        driver.findElement(By.id("ossn-submit-button")).click();
        String actualScreen =driver.getCurrentUrl();
        if (currentScreen.equals(actualScreen))
        {
            System.out.print("Pass case : SignUp With Only Fill Password" +"\n");
        }
        else
        {
            System.out.print("Failed case : SignUp With Only Fill Password" +"\n");
        }

        sleep(2000);
    }

    @Test(priority =10)
    public void SignUpWithOnlyFillDate() throws Exception {
        driver.navigate().refresh();

        String currentScreen = driver.getCurrentUrl();
        Thread.sleep(5000);

        driver.findElement(By.name("birthdate")).click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[6]/a")).click();

        sleep(2000);
        driver.findElement(By.id("ossn-submit-button")).click();
        String actualScreen =driver.getCurrentUrl();
        if (currentScreen.equals(actualScreen))
        {
            System.out.print("Pass case : SignUp With Only Fill Date" +"\n");
        }
        else
        {
            System.out.print("Failed case : SignUp With Only Fill Date " +"\n");
        }

        sleep(2000);

    }
    @Test(priority =11)
    public void CheckUsenameWasUse() throws Exception {


        driver.navigate().refresh();



        Thread.sleep(5000);
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys("Test");
        sleep(2000);

        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys("234");
        sleep(2000);

        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("test123@gmail.com");
        sleep(2000);

        driver.findElement(By.name("email_re")).clear();
        driver.findElement(By.name("email_re")).sendKeys("test123@gmail.com");
        sleep(2000);

        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("vipn123");
        sleep(2000);

        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("111111");
        sleep(2000);

        driver.findElement(By.name("birthdate")).click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[6]/a")).click();
        sleep(2000);

        //Fill mobilelogin
        driver.findElement(By.name("mobilelogin")).click();
        driver.findElement(By.name("mobilelogin")).sendKeys("+84987"+randomPrice(6));


        driver.findElement(By.name("gender")).click();
        sleep(2000);

        driver.findElement(By.id("ossn-submit-button")).click();
        sleep(2000);
        String Actual = driver.findElement(By.id("ossn-signup-errors")).getText();
        sleep(2000);
        String epected = "Tên đăng nhập đã được sử dụng.";


        if (epected.equals(Actual)) {
            System.out.print("Passed case:  Tên đăng nhập đã được sử dụng." + "\n");
        } else {
            System.out.print("Failed Case : Tên đăng nhập đã được sử dụng." + "\n");
            System.out.print("Kết quả failed: " + Actual);
        }
    }


    @Test(priority =12)
    public void SignUpWithOnlyFillMobileNumber() throws Exception {
        driver.navigate().refresh();


        String currentScreen = driver.getCurrentUrl();
        Thread.sleep(5000);


        //Fill mobilelogin
        driver.findElement(By.name("mobilelogin")).click();
        driver.findElement(By.name("mobilelogin")).sendKeys("+84987"+randomPrice(6));


        sleep(2000);
        driver.findElement(By.id("ossn-submit-button")).click();
        sleep(5000);
        String actualScreen =driver.getCurrentUrl();

        if (currentScreen.equals(actualScreen))
        {
            System.out.print("Pass case : SignUp With Only Fill Mobile Number" +"\n");
        }
        else
        {
            System.out.print("Failed case : SignUp With Only Fill Mobile Number " +"\n");
        }
        sleep(2000);
    }

    @Test(priority =13)
    public void CheckMobileNumberWasUse() throws Exception {

        driver.navigate().refresh();


        Thread.sleep(5000);
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys("Test");
        sleep(2000);

        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys("234");
        sleep(2000);

        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("test123@gmail.com");
        sleep(2000);

        driver.findElement(By.name("email_re")).clear();
        driver.findElement(By.name("email_re")).sendKeys("test123@gmail.com");
        sleep(2000);

        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys(randomString(11));
        sleep(2000);

        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("111111");
        sleep(2000);

        driver.findElement(By.name("birthdate")).click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[6]/a")).click();
        sleep(2000);

        //Fill mobilelogin
        driver.findElement(By.name("mobilelogin")).click();
        driver.findElement(By.name("mobilelogin")).sendKeys("+84987112233");


        driver.findElement(By.name("gender")).click();
        sleep(2000);

        driver.findElement(By.id("ossn-submit-button")).click();
        sleep(2000);
        String Actual = driver.findElement(By.id("ossn-signup-errors")).getText();
        sleep(2000);
        String epected = "Số điện thoại đã được sử dụng";


        if (epected.equals(Actual)) {
            System.out.print("Passed case:  TSố điện thoại đã được sử dụng" + "\n");
        } else {
            System.out.print("Failed Case : Số điện thoại đã được sử dụng " + "\n");
            System.out.print("Kết quả failed: " + Actual);
        }
    }


    @Test(priority =14)
    public void CheckIncorrectMobilenumber() throws Exception {

        driver.navigate().refresh();


        Thread.sleep(5000);
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys("Test");
        sleep(2000);

        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys("234");
        sleep(2000);

        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("test123@gmail.com");

        sleep(2000);

        driver.findElement(By.name("email_re")).clear();
        driver.findElement(By.name("email_re")).sendKeys("test123@gmail.com");
        sleep(2000);

        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys(randomString(11));
        sleep(2000);

        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("111111");
        sleep(2000);

        driver.findElement(By.name("birthdate")).click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[6]/a")).click();
        sleep(2000);

        //Fill mobilelogin
        driver.findElement(By.name("mobilelogin")).click();
        driver.findElement(By.name("mobilelogin")).sendKeys(randomString(11));


        driver.findElement(By.name("gender")).click();
        sleep(2000);

        driver.findElement(By.id("ossn-submit-button")).click();
        sleep(2000);
        String Actual = driver.findElement(By.id("ossn-signup-errors")).getText();
        sleep(2000);
        String epected = "Số điện thoại không đúng";


        if (epected.equals(Actual)) {
            System.out.print("Passed case:  Số điện thoại không hợp lệ" + "\n");
        } else {
            System.out.print("Failed Case : Số điện thoại không hợp lệ " + "\n");
            System.out.print("Kết quả failed: " + Actual);
        }
    }


    @Test(priority =15)
    public void SignUpWithOnlyFilLGender() throws Exception {
        driver.navigate().refresh();

        String currentScreen = driver.getCurrentUrl();
        Thread.sleep(5000);

        driver.findElement(By.name("gender")).click();


        sleep(2000);
        driver.findElement(By.id("ossn-submit-button")).click();
        String actualScreen = driver.getCurrentUrl();
        if (currentScreen.equals(actualScreen))
        {
            System.out.print("Pass case : SignUp With Only Fill Gender" +"\n");
        }
        else
        {
            System.out.print("Failed case : SignUp With Only Fill Gender" +"\n");
        }

        sleep(2000);
    }

    @Test(priority =16)
    // Character>=5
    public void SignUpWithLimitChracterAccount() throws Exception {
        driver.navigate().refresh();


        String currentScreen = driver.getCurrentUrl();
        Thread.sleep(5000);

        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys("Tet");
        sleep(3000);

        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys("234");
        sleep(3000);

        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("test123@gmail.com");

        sleep(2000);

        driver.findElement(By.name("email_re")).clear();
        driver.findElement(By.name("email_re")).sendKeys("test123@gmail.com");
        sleep(3000);

        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys(randomString(4));
        sleep(3000);

        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("111111");
        sleep(3000);

        driver.findElement(By.name("birthdate")).click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[6]/a")).click();
        sleep(3000);

        //Fill mobilelogin
        driver.findElement(By.name("mobilelogin")).click();
        driver.findElement(By.name("mobilelogin")).sendKeys("+84987"+randomPrice(6));

        driver.findElement(By.name("gender")).click();
        sleep(3000);

        driver.findElement(By.id("ossn-submit-button")).click();
        sleep(4000);
        String Actual = driver.findElement(By.id("ossn-signup-errors")).getText();
        sleep(2000);
        String expected = "Tên đăng nhập không hợp lệ";


        if (expected.equals(Actual)) {
            System.out.print("Passed case:  Tên đăng nhập không hợp lệ" + "\n");
        } else {
            System.out.print("Failed Case : Tên đăng nhập không hợp lệ" + "\n");
            System.out.print("Kết quả failed: " + Actual);
        }



        sleep(2000);
    }
    @Test(priority =17)
    public void SignUpWithAllinfo() throws Exception {
        driver.navigate().refresh();


            String currentScreen = driver.getCurrentUrl();
            Thread.sleep(5000);

            driver.findElement(By.name("firstname")).clear();
            driver.findElement(By.name("firstname")).sendKeys("Test");
            sleep(2000);

            driver.findElement(By.name("lastname")).clear();
            driver.findElement(By.name("lastname")).sendKeys("234");
            sleep(2000);

            driver.findElement(By.name("email")).clear();
            driver.findElement(By.name("email")).sendKeys("abngtrd@gmail.com");
            String mail_r = driver.findElement(By.name("email")).getText();
            sleep(2000);

            driver.findElement(By.name("email_re")).clear();
            driver.findElement(By.name("email_re")).sendKeys("abngtrd@gmail.com");
            sleep(2000);

            driver.findElement(By.name("username")).clear();
            driver.findElement(By.name("username")).sendKeys(randomString(6));
            sleep(2000);

            driver.findElement(By.name("password")).clear();
            driver.findElement(By.name("password")).sendKeys("111111");
            sleep(2000);

            driver.findElement(By.name("birthdate")).click();
            driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[6]/a")).click();
            sleep(2000);

        //Fill mobilelogin
        driver.findElement(By.name("mobilelogin")).click();
        driver.findElement(By.name("mobilelogin")).sendKeys("+84987"+randomPrice(6));


            driver.findElement(By.name("gender")).click();
            sleep(2000);

            driver.findElement(By.id("ossn-submit-button")).click();


            sleep(5000);

    String Expecte=driver.findElement(By.className("ossn-message-done")).getText();
    String Actual="Tài khoản của bạn đã được đăng ký! Chúng tôi đã gửi cho bạn một email kích hoạt tài khoản. Nếu bạn không nhận được email, vui lòng kiểm tra thư / thư mục rác của bạn";
       // assertNotEquals();
        if(Expecte.equals(Actual))
        {
            System.out.print("Passed case SignUpWithAllinfo");
        }
        else
        {
            System.out.print("Failed case SignUpWithAllinfo");
        }
    }


   //Auto Sign Up 10 account
   @Test(priority =18)
  public void AutoSignUp() throws Exception {
        for(int i=1;i<=10;i++) {
            driver.navigate().to("https://beta.ezqua.com/");


            String currentScreen = driver.getCurrentUrl();
            Thread.sleep(5000);

            driver.findElement(By.name("firstname")).clear();
            driver.findElement(By.name("firstname")).sendKeys("demo");
            sleep(2000);

            driver.findElement(By.name("lastname")).clear();
            driver.findElement(By.name("lastname")).sendKeys(randomPrice(3));
            sleep(2000);

            driver.findElement(By.name("email")).clear();
            driver.findElement(By.name("email")).sendKeys(randomString(7) + "@gmail.com");
            // String mail_r = driver.findElement(By.name("email")).getText();
            WebElement elem = driver.findElement(By.name("email"));

            elem.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            elem.sendKeys(Keys.chord(Keys.CONTROL, "c"));

            sleep(2000);

            driver.findElement(By.name("email_re")).click();


            sleep(2000);
            driver.findElement(By.name("email_re")).sendKeys(Keys.chord(Keys.CONTROL, "v"));


            driver.findElement(By.name("username")).clear();
            driver.findElement(By.name("username")).sendKeys(randomString(6));
            sleep(2000);

            driver.findElement(By.name("password")).clear();
            driver.findElement(By.name("password")).sendKeys("vipn123");
            sleep(2000);

            driver.findElement(By.name("birthdate")).click();
            driver.findElement(By.xpath("/[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[6]/a")).click();
            sleep(2000);

            //Fill mobilelogin
            driver.findElement(By.name("mobilelogin")).click();
            driver.findElement(By.name("mobilelogin")).sendKeys("+84987" + randomPrice(6));


            driver.findElement(By.name("gender")).click();
            sleep(2000);

            driver.findElement(By.id("ossn-submit-button")).click();


            sleep(5000);

            String Expecte = driver.findElement(By.className("ossn-message-done")).getText();
            String Actual = "Tài khoản của bạn đã được đăng ký! Chúng tôi đã gửi cho bạn một email kích hoạt tài khoản. Nếu bạn không nhận được email, vui lòng kiểm tra thư / thư mục rác của bạn";
            // assertNotEquals();
            if (Expecte.equals(Actual)) {
                System.out.print("Passed case SignUpWithAllinfo");
            } else {
                System.out.print("Failed case SignUpWithAllinfo");
            }
        }
    }


    @AfterTest
    public void afterTest()
    {

        driver.close();

    }


}


