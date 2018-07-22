package MyShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
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
public class CategoryInMyShop {
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


    public void sleep(int time) throws InterruptedException {
        Thread.sleep(time);
        //  return time;
    }


    //Random string
    //static final String AB = "aáâăạãảeéèếêẹẻẽẾẾÈẼẺÊẾỆiíìỉĩịIÍÌỈĨỊòóoọỏõôốồộổỗ u ú ù ụ ủ ũ U Ú Ù Ụ Ũ Ủ ư ứ ừ ự ữ Ư Ứ Ừ Ự Ử Ữ  y ý ỳ ỵ ỷ ỹ Y Ý Ỳ Ỵ Ỷ Ỹ ";
    static final String AB = "abcdeghiklmnopqrstuvsy";
    static SecureRandom rnd = new SecureRandom();

    String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    // Random numbers
    String price = "123456799125412368740";

    String randomPrice(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++)
            sb.append(price.charAt(rnd.nextInt(price.length())));
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
        } catch (Exception e) {
            System.out.print(" Failed Case driver Login Success" + "\n");
        }
    }

    @Test(priority = 2)
    public void AddCategory() throws InterruptedException {

        try {
            driver.navigate().to("https://beta.ezqua.com/s/my-shop/admin/category");
            sleep(2000);


            driver.findElement(By.cssSelector("a.btn.btn-default.pull-right")).click();
            sleep(2000);
            driver.findElement(By.id("category_title")).sendKeys("CategoryMyShop"+randomPrice(3));

            driver.findElement(By.cssSelector("div.note-editable.panel-body")).sendKeys(randomString(30));
            sleep(2000);


            Select DrpLanguage = new Select(driver.findElement(By.name("parent_guid")));
            DrpLanguage.selectByVisibleText("Samsung");


            driver.findElement(By.cssSelector("input.btn.btn-success.right")).click();
            System.out.print("Passed  Add Category!");
        } catch (Exception E) {

            System.out.print("Failed Add Category!");
        }

    }


    @Test(priority = 3)
    public void EditCategory() throws InterruptedException {
    try{
        //click icon edit
        sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"category_table\"]/table/tbody/tr[8]/td[4]/div/a[1]")).click();


        driver.findElement(By.id("category_title")).clear();
        driver.findElement(By.id("category_title")).sendKeys("UpdateCategory"+randomPrice(3));
        driver.findElement(By.cssSelector("input.btn.btn-success.right")).click();
        System.out.print("Passed  Edit Category!");
    } catch (Exception E) {

        System.out.print("Failed Edit Category!");
    }



    }
    @Test(priority = 4)
    public void DeleteCategory() throws InterruptedException {
        sleep(5000);
        try {
            //click icon delete
            driver.findElement(By.xpath("//*[@id=\"category_table\"]/table/tbody/tr[8]/td[4]/div/a[2]")).click();

            System.out.print("Passed Case Delete Category!");
            sleep(5000);

        }catch (Exception e)
        {
            System.out.print("Failed Case Delete Category!");
        }

    }



    @AfterTest
    public void afterTest()
    {

        driver.close();

    }



    }
