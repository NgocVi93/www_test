package Manager;

/**
 * Created by sysadmin on 10/26/17.
 */
import Login.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertNotEquals;

public class ProductTesting {
    WebDriver driver;
    ManagerPage objManager;
    LoginPage objLogin;


    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception
    {System.setProperty("webdriver.chrome.driver", "/home/sysadmin/ChromeDriver/chromedriver");
        driver=new ChromeDriver();

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://dev.ezqua.com/");

    }
    @Test(priority =1)
    public void Login() throws Exception {
        objLogin =new LoginPage(driver);
       Thread.sleep(2000);

        driver.findElement(By.cssSelector("a.btn.btn-primary")).click();
        objLogin.Login("vipn500", "123456");

        Thread.sleep(3000);
    }
    @Test(priority = 2)
    public void AddProduct()throws Exception {
        objManager = new ManagerPage(driver);
        driver.get("https://dev.ezqua.com/s/manager");
        objManager.Click_MenuProduct();
        Thread.sleep(2000);

        for(int i=1;i<=20;i++) {

            objManager.Click_btnAddProduct();

            String currenURL = driver.getCurrentUrl();
            String randomProductName = "voucher's vipn500" + i;
            String randomPrice = objManager.randomNumber(6);
            String randomContent = "Day la sản phẩm " + i;
            String randomSku = "sku" + objManager.randomString(10);
            String randomManufacture = "Manufacture" + objManager.randomString(5);
            String randomOrigin = "Origin" + objManager.randomString(5);
            String randomWeight = objManager.randomNumber(1);


            objManager.AddProductWithOnLyFillProductName(randomProductName, randomPrice,randomContent,
                    randomSku, randomManufacture, randomOrigin, "10", "50", "5");
            Thread.sleep(2000);
            objManager.Click_ProductSumit();
        }
    }

   /* @Test(priority = 3)
    public void AddProductWithNotFillName()throws Exception {
        objManager = new ManagerPage(driver);


        Thread.sleep(2000);

        objManager.Click_btnAddProduct();


        String randomProductName = "san pham " + objManager.randomNumber(10);
        String randomPrice = objManager.randomNumber(6);
        String randomContent = objManager.randomString(20);
        String randomSku = "sku" + objManager.randomString(10);
        String randomManufacture = "Manufacture" + objManager.randomString(5);
        String randomOrigin = "Origin" + objManager.randomString(5);
        String randomWeight = objManager.randomNumber(1);


        objManager.AddProductWithOnLyFillProductName("", randomPrice, randomContent, "4017",
                randomSku, randomManufacture, randomOrigin, randomWeight, "10", "50", "5");
        Thread.sleep(2000);

        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, "https://dev.ezqua.com/s/manager/product/add");
        Thread.sleep(5000);
    }
    @Test(priority = 4)
    public void AddProductWithNotFillPrice()throws Exception {
        objManager = new ManagerPage(driver);



        String currenURL = driver.getCurrentUrl();
        String randomProductName = "san pham " + objManager.randomNumber(10);
        String randomPrice = objManager.randomNumber(6);
        String randomContent = objManager.randomString(20);
        String randomSku = "sku" + objManager.randomString(10);
        String randomManufacture = "Manufacture" + objManager.randomString(5);
        String randomOrigin = "Origin" + objManager.randomString(5);
        String randomWeight = objManager.randomNumber(1);



        objManager.AddProductWithOnLyFillProductName(randomProductName, "", randomContent, "4017",
                randomSku, randomManufacture, randomOrigin, randomWeight, "10", "50", "5");
        Thread.sleep(5000);
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,"https://dev.ezqua.com/s/manager/product");
    }
*/
    @AfterTest
    public void afterTest()
    {

        driver.close();

    }
}
