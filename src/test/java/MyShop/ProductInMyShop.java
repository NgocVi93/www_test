package MyShop;

/**
 * Created by sysadmin on 8/31/17.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public class ProductInMyShop {
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


    public void  sleep ( int time) throws InterruptedException
    {
        Thread.sleep(time);
    }


    //Random string
   // static final String AB = "aáâăạãảeéèếêẹẻẽẾẾÈẼẺÊẾỆiíìỉĩịIÍÌỈĨỊòóoọỏõôốồộổỗ u ú ù ụ ủ ũ U Ú Ù Ụ Ũ Ủ ư ứ ừ ự ữ Ư Ứ Ừ Ự Ử Ữ  y ý ỳ ỵ ỷ ỹ Y Ý Ỳ Ỵ Ỷ Ỹ ";
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
    public void driverLogin() throws Exception {


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

    public void AddProduct() throws InterruptedException {



        driver.navigate().to("https://beta.ezqua.com/s/my-shop/admin/product");
        sleep(2000);
        // for (int i = 0; i <= 10; i++) {
        try {
            driver.findElement(By.cssSelector("a.btn.btn-default.pull-right")).click();

            driver.findElement(By.name("product_name")).sendKeys("Product" + randomPrice(3));
            sleep(2000);

            //Fill Price
            driver.findElement(By.name("product_price")).sendKeys(randomPrice(6));
            sleep(2000);

            driver.findElement(By.cssSelector("div.note-editable.panel-body")).sendKeys(randomString(50));

            sleep(2000);



        /* attribute page*/
            driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div/div/div[2]/div/div[2]/div[2]/div/div[2]/form/fieldset/div/div/div/ul/li[2]/a")).click();
            sleep(2000);
            //Fill Price
      /*  driver.findElement(By.name("product_price")).sendKeys(randomPrice(6));
        sleep(2000);*/

            //Fill Tax
            driver.findElement(By.name("product_tax")).clear();
            driver.findElement(By.name("product_tax")).sendKeys(randomPrice(2));
            sleep(2000);


            //Fill Quantity
            driver.findElement(By.name("product_quantity")).clear();
            driver.findElement(By.name("product_quantity")).sendKeys(randomPrice(2));
            sleep(2000);

            //Choose product_expiry in drop down list

            Select DrpLanguage = new Select(driver.findElement(By.name("product_expiry")));
            DrpLanguage.selectByVisibleText("Hạn sử dụng tính từ ngày mua");



        /* Links*/
            driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div/div/div[2]/div/div[2]/div[2]/div/div[2]/form/fieldset/div/div/div/ul/li[3]/a")).click();
            sleep(2000);
            //Fill product_manufacturer
            driver.findElement(By.name("product_manufacture")).sendKeys("Manufactuner" + randomPrice(3));
            sleep(2000);
  /*  //Choose product_category
    Select Drpcategory = new Select(driver.findElement(By.name("product_category")));
    Drpcategory.selectByVisibleText("Dell");
*/

            driver.findElement(By.name("product_origin")).sendKeys("Made In" + randomPrice(5));
            sleep(2000);
            driver.findElement(By.id("token-input-shop-category")).sendKeys("Test điện thoại");
            Robot robot = new Robot();
            Thread.sleep(3000);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            sleep(2000);
            // Choose product:market_category

            //Fill product_origin
            // driver.findElement(By.name("product_origin")).sendKeys(randomString(20));


        /*discount page*/
            driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div/div/div[2]/div/div[2]/div[2]/div/div[2]/form/fieldset/div/div/div/ul/li[4]/a")).click();
            sleep(2000);
            driver.findElement(By.name("product_discount")).clear();
            driver.findElement(By.name("product_discount")).sendKeys(randomPrice(2));


            driver.findElement(By.cssSelector("input.btn.btn-success.pull-right.form-group")).click();

            System.out.print("Passed case add product");
            sleep(2000);

        }catch(Exception e)
        {
            System.out.print("Failed case add product");
        }
    }





    @Test(priority = 3)
    public void EditProduct() throws InterruptedException {
        sleep(4000);
        try {


            driver.findElement(By.xpath("//*[@id=\"product_table\"]/tbody/tr[10]/td[6]/a[1]")).click();

            driver.findElement(By.name("product_name")).clear();
            driver.findElement(By.name("product_name")).sendKeys("EditProduct"+randomPrice(3));
            sleep(2000);

            driver.findElement(By.cssSelector("input.btn.btn-success.pull-right.form-group")).click();

            System.out.print("Passed Case Edit Product name in MyShop");



            sleep(4000);
        } catch (Exception a) {
            System.out.print("Failed Case Edit Product name in MyShop");
        }
    }



    @Test(priority = 4)
    public void DeleteProduct() throws InterruptedException {
        sleep(4000);
        try {


            driver.findElement(By.xpath("//*[@id=\"product_table\"]/tbody/tr[7]/td[6]/a[2]/i")).click();

    /*        Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);*/

            System.out.print("Passed DeleteProduct");

            sleep(4000);
        } catch (Exception a) {
            System.out.print("Failed DeleteProduct");
        }
    }
    @AfterTest
    public void afterTest()
    {

        driver.close();

    }
}
