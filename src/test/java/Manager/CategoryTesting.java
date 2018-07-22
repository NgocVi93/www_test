package Manager;

/**
 * Created by sysadmin on 10/24/17.
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
public class CategoryTesting {
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
           objLogin.sleep(2000);

            driver.findElement(By.cssSelector("a.btn.btn-primary")).click();
            objLogin.Login("vipn201", "123456");
            objLogin.sleep(3000);


    }
    @Test(priority = 2)
        public void AddCateGory()throws Exception
    {
            objManager =new ManagerPage(driver);
        driver.get("https://dev.ezqua.com/s/manager");
            String Name= "category"+ objManager.randomNumber(8);
            objManager.Click_MenuCateGory();
            int beforeAdd=objManager.Count();
            objManager.Click_ButtonAdd();
            objManager.AddNewCateFory(Name, objManager.randomString(10),"true");
        driver.navigate().refresh();
        int afterAdd=objManager.Count();
        Thread.sleep(3000);
        System.out.print("beforeAdd "+beforeAdd + "\n");
        System.out.print("afterAdd "+afterAdd+ "\n");
        Assert.assertEquals(beforeAdd+1,afterAdd);




    }
    @Test(priority = 3)
    public void EditCateGory()throws Exception
    {
        objManager =new ManagerPage(driver);
        Thread.sleep(3000);
        String updateName= "Update category"+ objManager.randomNumber(8);
        int beforeEdit=objManager.Count();
        driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div[1]/form/div[3]/table/tbody/tr[2]/td[5]/ul/li[1]/a")).click();
        Thread.sleep(3000);
        objManager.EditCategory(updateName,"Update Content "+ objManager.randomString(10),"false");
        driver.navigate().refresh();
        int afterEdit=objManager.Count();
        Thread.sleep(3000);
        System.out.print("beforeEdit "+beforeEdit + "\n");
        System.out.print("afterAdd "+afterEdit+ "\n");
        Assert.assertEquals(beforeEdit,afterEdit);
    }


   @Test(priority = 4)
    public void DeleteCateGory()throws Exception
    {
        objManager =new ManagerPage(driver);
        //so luong truoc khi delete
        Thread.sleep(3000);
        int beforeDelete=objManager.Count();
        objManager.DeleteCategory();
        //so luong sau khi delete
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(5000);
        int afterDelete=objManager.Count();

        System.out.print("beforeEdit "+beforeDelete + "\n");
        System.out.print("afterAdd "+afterDelete+ "\n");
        Assert.assertEquals(beforeDelete-1,afterDelete);
    }



    @AfterTest
    public void afterTest()
    {

        driver.close();

    }
}
