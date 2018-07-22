/**
 * Created by sysadmin on 7/19/17.
 */
import javafx.scene.layout.Priority;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.support.ui.Select;
import java.awt.datatransfer.StringSelection;
public class Groups {
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
    public void sleep(int time) throws Exception {
        Thread.sleep(time);
    }

    //Random string
    static final String AB = "aáâăạãảeéèếêẹẻẽẾẾÈẼẺÊẾỆiíìỉĩịIÍÌỈĨỊòóoọỏõôốồộổỗ u ú ù ụ ủ ũ U Ú Ù Ụ Ũ Ủ ư ứ ừ ự ữ Ư Ứ Ừ Ự Ử Ữ  y ý ỳ ỵ ỷ ỹ Y Ý Ỳ Ỵ Ỷ Ỹ ";

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
        StringBuilder sb = new StringBuilder(  );for( int i = 0; i < len; i++ )
        sb.append( price.charAt( rnd.nextInt(price.length()) ) );
        return sb.toString();
    }
    @Test(priority =1)
    public void Login() throws Exception {
        driver.navigate().to("https://beta.ezqua.com/");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("a.btn.btn-primary")).click();


        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("vipn123");


        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("vipn123");

        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
        Thread.sleep(5000);
        System.out.print("driver Login Success"+"\n");


/*
      Robot robot=new Robot();
        driver.findElement(By.name("comment")).sendKeys("Test hoy mà");
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);*/


    }

 /*@Test(priority =2)
    public void AddNewGroupWithNullName() throws Exception

    {
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        sleep(2000);
        robot.keyRelease(KeyEvent.VK_DOWN);
        sleep(2000);
        driver.findElement(By.cssSelector("li.menu-section-item-addgroup")).click();
        sleep(2000);

        driver.findElement(By.name("groupname")).sendKeys("");

        //driver.findElement(By.name("groupname")).sendKeys("Test123");
        sleep(2000);
        driver.findElement(By.cssSelector("a.btn.btn-primary")).click();
        sleep(5000);

        String err=driver.findElement(By.cssSelector("div.alert.alert-danger")).getText();
        sleep(2000);
        System.out.print(err);

        sleep(2000);
        String expected="Cannot create group! Please try again later.";
        if(err.equals(expected))
        {
            System.out.print("Passed case Add New Group With Null Group Name");
        }
        else {
            System.out.print("Failed case Add New Group With Null Group Name");
        }
    }
*/
    @Test(priority =2)
    public void AddNewGroup() throws Exception {
        sleep(5000);
        for(int i=1;i<2;i++)
        {
            Robot robot=new Robot();
            robot.keyPress(KeyEvent.VK_DOWN);
            sleep(3000);
            robot.keyRelease(KeyEvent.VK_DOWN);
            sleep(2000);
            driver.findElement(By.cssSelector("li.menu-section-item-addgroup")).click();
            sleep(2000);

           driver.findElement(By.name("groupname")).sendKeys("Group"+randomPrice(3));

            //driver.findElement(By.name("groupname")).sendKeys("Test123");
            sleep(2000);
            driver.findElement(By.cssSelector("a.btn.btn-primary")).click();
            sleep(5000);

           // driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/div/div/div[2]/span/a")).click();
           // sleep(2000);
        }
    }
 /*@Test(priority =4)
    public void AddMood() throws Exception {

*//*  Select DrpLanguage=new Select(driver.findElement(By.name("mood")));
        DrpLanguage.selectByVisibleText("đang cảm thấy đói");
        sleep(2000);*//*


      driver.findElement(By.cssSelector("i.fa.fa-map-pin")).click();
     driver.findElement(By.cssSelector("a.chosen-single.chosen-default")).click();

        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

sleep(2000);
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
        sleep(2000);


    }*/
    @Test(priority = 3)
    public void SendMessageAndLocation() throws Exception
    {
        try {


            Robot robot = new Robot();
            driver.findElement(By.name("post")).sendKeys("Send message + Location  !" + "\n");
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("i.fa.fa-map-marker")).click();

            Thread.sleep(2000);
            driver.findElement(By.id("ossn-wall-location-input")).sendKeys("Saigon");

            Thread.sleep(5000);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            driver.findElement(By.cssSelector("input.btn.btn-primary.ossn-wall-post")).click();
            Thread.sleep(5000);
            System.out.print("Passed Case SendMessageAndLocation ");
        }
        catch (Exception e)
        {
            System.out.print("Failed Case SendMessageAndLocation ");
        }

    }
    @Test(priority = 4)
    public void SendTextAndImage ()throws Exception {

        {
            try {


                driver.findElement(By.name("post")).sendKeys(Keys.chord(Keys.SHIFT, "send message and Images "));
                sleep(2000);
                driver.findElement(By.cssSelector("i.fa.fa-picture-o")).click();

                Robot robot = new Robot();
                StringSelection ss = new StringSelection("~/Pictures/1.jpg");
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);


                Thread.sleep(3000);
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                sleep(2000);
                robot.keyPress(KeyEvent.VK_ENTER);
                sleep(1000);
                robot.keyRelease(KeyEvent.VK_ENTER);

                sleep(5000);
                driver.findElement(By.cssSelector("input.btn.btn-primary.ossn-wall-post")).click();
                sleep(5000);
                System.out.print("Passed Case SendTextAndImage ");
            }
            catch (Exception e)
            {
                System.out.print("Failed Case SendTextAndImage ");
            }

        }
    }
    @Test(priority = 5)
    public void SendMessageAndEmoji() throws Exception
    {
        sleep(2000);

        try {
            driver.findElement(By.name("post")).sendKeys(Keys.chord(Keys.SHIFT, "send message and emoji") + "\n");

            driver.findElement(By.cssSelector("i.fa.fa-smile-o")).click();


            driver.findElement(By.xpath("//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[4]/div/div[1]/li[10]")).click();
            driver.findElement(By.xpath("//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[4]/div/div[1]/li[11]")).click();
            driver.findElement(By.xpath("//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[4]/div/div[1]/li[12]")).click();
            driver.findElement(By.xpath("//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[4]/div/div[1]/li[13]")).click();
            driver.findElement(By.xpath("//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[4]/div/div[1]/li[14]")).click();
            driver.findElement(By.xpath("//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[4]/div/div[1]/li[15]")).click();
            driver.findElement(By.xpath("//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[4]/div/div[1]/li[16]")).click();
            driver.findElement(By.xpath("//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[4]/div/div[1]/li[17]")).click();
            driver.findElement(By.xpath("//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[4]/div/div[1]/li[18]")).click();
            driver.findElement(By.xpath("//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[4]/div/div[1]/li[19]")).click();


            Thread.sleep(2000);
            driver.findElement(By.cssSelector("input.btn.btn-primary.ossn-wall-post")).click();
            Thread.sleep(5000);
            System.out.print("Passed Case SendMessageAndEmoji ");
        }
        catch (Exception e )
        {
            System.out.print("Failed Case SendMessageAndEmoji ");
        }

    }

  /*  @Test(priority = 6)
    public void TestStatusWithPrivacyFriend() throws Exception {
        try {


            Robot robot = new Robot();
            driver.findElement(By.name("post")).sendKeys("Send message + Location  !" + "\n");
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("i.fa.fa-map-marker")).click();

            Thread.sleep(2000);
            driver.findElement(By.id("ossn-wall-location-input")).sendKeys("Saigon");

            Thread.sleep(5000);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            driver.findElement(By.name("post")).sendKeys(Keys.chord(Keys.SHIFT, "send message and Images "));
            sleep(2000);
            driver.findElement(By.cssSelector("i.fa.fa-picture-o")).click();

            StringSelection ss = new StringSelection("~/Pictures/1.jpg");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);


            Thread.sleep(3000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            sleep(2000);
            robot.keyPress(KeyEvent.VK_ENTER);
            sleep(1000);
            robot.keyRelease(KeyEvent.VK_ENTER);

            sleep(5000);

            driver.findElement(By.cssSelector("i.fa.fa-lock")).click();
            driver.findElement(By.xpath("/*//*[@id=\"ossn-wall-privacy-container\"]/fieldset/div[2]/table/tbody/tr/td[2]/input[2]")).click();
            sleep(2000);
            driver.findElement(By.cssSelector("a.btn.btn-primary")).click();
            sleep(2000);
           driver.findElement(By.cssSelector("input.btn.btn-primary.ossn-wall-post")).click();
            sleep(5000);
            System.out.print("Passed Case SendTextAndImage ");

        }
        catch (Exception e)
        {
            System.out.print("Failed ");

        }
    }

*/



    @Test(priority =6)
    public void LikePost() throws Exception {
        try {


            sleep(3000);
            driver.findElement(By.cssSelector("a.post-control-like")).click();
            sleep(5000);
            System.out.print("Passed Case LikePost ");
        }
        catch (Exception e)
        {
            System.out.print("Failed Case LikePost ");
        }

    }
/*    @Test(priority =4)
    public void SharePost() throws Exception {
        try {


            sleep(3000);
            driver.findElement(By.cssSelector("a.post-control-sharepost")).click();
            sleep(5000);
            System.out.print("Passed Case SharePost ");
        }
        catch (Exception e)
        {
            System.out.print("Failed Case SharePost ");
        }

    }*/
    @Test(priority =7)
    public void DeleteSharePost() throws Exception {
        try {


            driver.findElement(By.id("dLabel")).click();
            sleep(3000);
            driver.findElement(By.cssSelector("a.post-control-delete.ossn-wall-post-delete")).click();
            sleep(3000);
            System.out.print("Passed Case DeleteSharePost ");
        }
        catch (Exception e)
        {
            System.out.print("Failed Case DeleteSharePost ");
        }


    }

    @Test(priority =8)
    public void EditThenSavePost() throws Exception {
        try {


            driver.findElement(By.id("dLabel")).click();
            sleep(3000);
            driver.findElement(By.cssSelector("a.post-control-edit.ossn-wall-post-edit")).click();
            sleep(2000);
            driver.findElement((By.id("post-edit"))).clear();
            sleep(2000);
            driver.findElement((By.id("post-edit"))).sendKeys(randomString(10));
            sleep(2000);
            driver.findElement(By.cssSelector("a.btn.btn-primary")).click();
            sleep(2000);
            System.out.print("Passed Case EditThenSavePost ");
        }
        catch (Exception e)
        {
            System.out.print("Failed Case EditThenSavePost ");
        }



    }
    @Test(priority =9)
    public void EditThenCancelPost() throws Exception {
        try {


            driver.findElement(By.id("dLabel")).click();
            sleep(3000);
            driver.findElement(By.cssSelector("a.post-control-edit.ossn-wall-post-edit")).click();
            sleep(2000);
            driver.findElement((By.id("post-edit"))).clear();
            sleep(2000);
            driver.findElement((By.id("post-edit"))).sendKeys(randomString(10));
            sleep(2000);
            driver.findElement(By.cssSelector("a.btn.btn-default")).click();
            sleep(2000);
            System.out.print("Passed Case EditThenCancelPost ");
        }
        catch (Exception e)
        {
            System.out.print("Failed Case EditThenCancelPost ");
        }

    }


    @Test(priority =10)
    public void EditReportAndSave() throws Exception {
        try {


            driver.findElement(By.id("dLabel")).click();

            sleep(3000);
            driver.findElement(By.cssSelector("a.post-control-report.ossn-report-this")).click();
            sleep(2000);
            driver.findElement((By.name("reason"))).clear();
            sleep(2000);
            driver.findElement((By.name("reason"))).sendKeys(randomString(10));
            sleep(2000);
            driver.findElement(By.cssSelector("a.btn.btn-primary")).click();
            sleep(2000);
            System.out.print("Passed Case Edit Report And Save ");
        }
        catch (Exception e)
        {
            System.out.print("Failed  Case Edit Report And Save ");
        }



    }
    @Test(priority =11)
    public void EditReportAndCancel() throws Exception {
        try {


            driver.findElement(By.id("dLabel")).click();
            sleep(3000);
            driver.findElement(By.cssSelector("a.post-control-report.ossn-report-this")).click();
            sleep(2000);
            driver.findElement((By.name("reason"))).clear();
            sleep(2000);
            driver.findElement((By.name("reason"))).sendKeys("Edit report "+randomPrice(8));
            sleep(2000);
            driver.findElement(By.cssSelector("a.btn.btn-default")).click();
            sleep(2000);
            System.out.print("Passed Case Edit Report And Cancel ");
        }
        catch (Exception e)
        {
            System.out.print("Failed  Cshopping/cart/confirmase Edit Report And Cancel ");
        }

    }


   @AfterTest
   public void afterTest()
   {

       driver.close();

   }

}
