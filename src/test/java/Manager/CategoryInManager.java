package Manager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by sysadmin on 8/30/17.
 */
public class CategoryInManager {
    private WebDriver driver;
    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/home/sysadmin/ChromeDriver/chromedriver");
        // System.setProperty("webdriver.gecko.driver", "/home/sysadmin/FifoxDriver/geckodriver");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }


    public void sleep ( int time) throws InterruptedException
    {
        Thread.sleep(time);
      //  return time;
    }


    //Random string
    static final String AB = "abcdeghiklmnopqrstuvsy";

    static SecureRandom rnd = new SecureRandom();

    String randomString( int len ){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }

    // Random numbers
    String price="123456799125412368740";
    String randomPrice(int len)
    {
        StringBuilder sb = new StringBuilder(  );
        for( int i = 0; i < len; i++ )
            sb.append( price.charAt( rnd.nextInt(price.length()) ) );
        return sb.toString();
    }
    // Chức năng Login
    @Test(priority = 1)
    public void driverLogin() throws InterruptedException {


        driver.get("https://beta.ezqua.com/");
        sleep(5000);
        driver.findElement(By.cssSelector("a.btn.btn-primary")).click();
        sleep(5000);

        try {


            driver.findElement(By.name("username")).clear();
            driver.findElement(By.name("username")).sendKeys("admin");


            driver.findElement(By.name("password")).clear();
            driver.findElement(By.name("password")).sendKeys("ezqua123");
            sleep(3000);

            driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
            sleep(5000);
            System.out.print(" Passed Case driver Login Success" + "\n");
        }
        catch (Exception e)
        {
            System.out.print(" Failed Case driver Login Success" + "\n");
        }

    }
    @Test(priority = 2)
    public void AddCategory() throws InterruptedException {
        driver.navigate().to("https://beta.ezqua.com/s/manager");
        sleep(2000);

        try {
            driver.findElement(By.xpath("//*[@id=\"mainmenu\"]/ul/li[3]/a/i")).click();

        sleep(2000);
        driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div[1]/div[1]/div/div/a/button")).click();



            // Fill Category Name
            driver.findElement(By.name("title")).sendKeys("CategoryAdmin"+randomPrice(3));

        sleep(2000);
            driver.findElement(By.cssSelector("div.note-editable")).sendKeys("CategoryAdmin"+randomString(50));

            //Choose PARENT CATEGORY

            Select DrpLanguage = new Select(driver.findElement(By.id("parent")));
            DrpLanguage.selectByVisibleText("Iphone");

        sleep(2000);
            //Choose Sumnit
            driver.findElement(By.name("submit")).click();

        sleep(2000);

           System.out.print("Passed  Add Category!");
        } catch (Exception E) {

            System.out.print("Failed Add Category!");
        }
    }

    @Test(priority = 3)
    public void EditCategory()throws InterruptedException {
       try {
            driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div[1]/div[3]/table/tbody/tr[8]/td[5]/ul/li[1]/a")).click();

            // Fill Category Name
           driver.findElement(By.name("title")).clear();
            driver.findElement(By.name("title")).sendKeys("UpdateCategoryMyShop"+randomPrice(3));

            //Choose PARENT CATEGORY
            Select DrpLanguage = new Select(driver.findElement(By.id("parent")));
            DrpLanguage.selectByVisibleText("Asus");


            //Sunmit
            driver.findElement(By.name("submit")).click();
            sleep(2000);

            System.out.print("Passed Update Category");
        }
        catch ( Exception E)
        {
            System.out.print("Failed Update  Category!");
        }
    }

    @Test(priority = 4)
    public void DeleteCategory()throws InterruptedException {
        try {
        driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div[1]/div[3]/table/tbody/tr[8]/td[5]/ul/li[2]/a")).click();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        System.out.print("Passed Category!");

    }
        catch (Exception a)
    {
        System.out.print("Failed Category!");
    }


    }

    @AfterTest
    public void afterTest()
    {

        driver.close();

    }
}
