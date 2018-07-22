/**
 * Created by sysadmin on 8/1/17.
 */
import javafx.scene.layout.Priority;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.awt.datatransfer.StringSelection;

public class TestWithFifoxBrowser {
    private WebDriver driver;
    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {

        System.setProperty("webdriver.gecko.driver", "/home/sysadmin/FifoxDriver/geckodriver");

        DesiredCapabilities capability = DesiredCapabilities.firefox();
       // WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
         driver = new FirefoxDriver();
        capability.setBrowserName("firefox");

        driver.manage().deleteAllCookies();
        driver.get("https://dev.ezqua.com");

    }

    public void  sleep ( int time) throws Exception
    {
        Thread.sleep(time);
    }

    static final String AB = "aáâăạãảeéèếêẹẻẽẾẾÈẼẺÊẾỆiíìỉĩịIÍÌỈĨỊòóoọỏõôốồộổỗ u ú ù ụ ủ ũ U Ú Ù Ụ Ũ Ủ ư ứ ừ ự ữ Ư Ứ Ừ Ự Ử Ữ  y ý ỳ ỵ ỷ ỹ Y Ý Ỳ Ỵ Ỷ Ỹ ";

    static SecureRandom rnd = new SecureRandom();
    String randomString( int len ){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();


    }

    @Test(priority = 1)
    public void Login() throws Exception
    {

        Thread.sleep(5000);

        driver.findElement(By.cssSelector("a.btn.btn-primary")).click();

        Thread.sleep(5000);


        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("phamvv");


        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("123456");

        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
        Thread.sleep(5000);
        System.out.print("driver Login Success"+"\n");



    }


    @AfterTest
    public void afterTest()
    {
        if(driver!=null) {
            driver.close();
        }

    }
}
