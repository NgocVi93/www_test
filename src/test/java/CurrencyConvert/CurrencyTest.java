package CurrencyConvert;

/**
 * Created by sysadmin on 10/20/17.
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
public class CurrencyTest {
    WebDriver driver;
    //22737.608
    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {System.setProperty("webdriver.chrome.driver", "/home/sysadmin/ChromeDriver/chromedriver");
        driver=new ChromeDriver();

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://dev.ezqua.com/");

    }

    @Test(priority = 1)
    public void Login() throws Exception {
        LoginPage objLogin = new LoginPage(driver);
        Currencypage objCurrency=new Currencypage(driver);
        objLogin.sleep(2000);
        driver.findElement(By.cssSelector("a.btn.btn-primary")).click();


        //Call Login function
        objLogin.sleep(2000);
        objLogin.Login("vipn203", "123456");
        objLogin.sleep(3000);

        objLogin.sleep(3000);
        driver.findElement(By.cssSelector("li.ossn-topbar-dropdown-menu")).click();
        driver.findElement(By.cssSelector("a.menu-topbar-dropdown-my_wallet")).click();
        objLogin.sleep(2000);

       System.out.print("Tiền ban đầu "+ driver.findElement(By.xpath("html/body/div[4]/div/div[2]/div/div/div[2]/div[2]/div/div[1]/div[2]/div/div[2]/p[1]/span")).getText()+"\n");
        objLogin.sleep(3000);

        driver.get("https://dev.ezqua.com/s/vivnd");
        objLogin.sleep(2000);
       String PriceProductWasChosse= objCurrency.getPriceProductWasChosse();
        System.out.print("Giá tiền sản phẩm chưa thuế" + PriceProductWasChosse+"\n");

        objLogin.sleep(2000);
        objCurrency.clickchooseProduct();
        objLogin.sleep(2000);
        objCurrency.clickbtnBuy();
        objLogin.sleep(2000);
        objCurrency.clickbtnIconMarketCart();
        objLogin.sleep(2000);
        objCurrency.clickbtnViewShopingCart();

        String getpriceproductInCart =objCurrency.getpriceproductInCart();
       String TotoalAmount=objCurrency.getTotalpriceInCart();
        System.out.print("Giá tiền sản phẩm có thuế" + TotoalAmount+"\n");
Assert.assertEquals(PriceProductWasChosse,getpriceproductInCart);
        objLogin.sleep(2000);
objCurrency.clickbtnSusscess();
        objLogin.sleep(2000);
driver.findElement(By.xpath("html/body/div[4]/div[1]/div[2]/div/div[2]/div/div[3]/div[2]/form/fieldset/div[1]/div[2]/div/div[2]/div")).click();
        objLogin.sleep(2000);
        driver.findElement(By.cssSelector("input.btn.btn-success")).click();
        objLogin.sleep(2000);
objCurrency.clickbtnByWallet();
        driver.findElement(By.cssSelector("input.btn.btn-success")).click();
        objLogin.sleep(2000);
        String sodu=objCurrency.getRemainingMount();
        System.out.print("Số dư" + sodu+"\n");
        objLogin.sleep(2000);
        objCurrency.clickbtnpayment_submit();
        objLogin.sleep(10000);

        driver.findElement(By.cssSelector("li.ossn-topbar-dropdown-menu")).click();
        driver.findElement(By.cssSelector("a.menu-topbar-dropdown-my_wallet")).click();

        String PriceWalletAfterBuy= driver.findElement(By.xpath("html/body/div[4]/div/div[2]/div/div/div[2]/div[2]/div/div[1]/div[2]/div/div[2]/p[1]/span")).getText();
        System.out.print("Tài khoản sau khi mua" + sodu+"\n");
        Assert.assertEquals(sodu,PriceWalletAfterBuy);
    }
    @AfterTest
    public void afterTest()
    {

        driver.close();

    }
}
