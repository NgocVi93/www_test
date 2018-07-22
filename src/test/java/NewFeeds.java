/**
 * Created by sysadmin on 7/17/17.
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
public class NewFeeds {
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
    public void SendMessage() throws Exception
    {
        driver.navigate().to("https://dev.helloqua.com/");
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("a.btn.btn-primary")).click();


        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("vipn123");


        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("vipn123");


        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
        Thread.sleep(5000);
        System.out.print("driver Login Success"+"\n");

     //   driver.findElement(By.cssSelector("a.menu-section-item-a-newsfeed")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("post")).sendKeys(randomString(20));
        //   }
        driver.findElement(By.cssSelector("input.btn.btn-primary.ossn-wall-post")).click();
        Thread.sleep(5000);
            System.out.print("Passed Case Send Text");



    }

   @Test(priority = 2)
    public void SendMessageAndTagFriend() throws Exception
    {

        try {


        Robot robot=new Robot();
        driver.findElement(By.name("post")).sendKeys("Send message +Tag Friend !"+"\n");
        driver.findElement(By.cssSelector("li.ossn-wall-friend.ossn-wall-container-control-menu-tag-friend")).click();

        Thread.sleep(2000);

        driver.findElement(By.id("token-input-ossn-wall-friend-input")).sendKeys("EZQUA");

        Thread.sleep(5000);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        driver.findElement(By.id("token-input-ossn-wall-friend-input")).sendKeys("thinh");

        Thread.sleep(5000);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        driver.findElement(By.cssSelector("input.btn.btn-primary.ossn-wall-post")).click();
        Thread.sleep(5000);
            System.out.print("Passed Case SendMessageAndTagFriend ");
        }
        catch (Exception e)
        {
            System.out.print("Failed Case SendMessageAndTagFriend ");
        }

    }
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

    //Send Text and Image
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

    // Send Text and emoji
    @Test(priority = 5)
    public void SendMessageAndEmoji() throws Exception
    {

        try {
            driver.findElement(By.name("post")).sendKeys(Keys.chord(Keys.SHIFT, "send message and emoji") + "\n");
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("i.fa.fa-smile-o")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[1]")).click();
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[2]")).click();
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[3]")).click();
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[4]")).click();
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[5]")).click();
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[6]")).click();
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[7]")).click();
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[8]")).click();
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[9]")).click();
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[10]")).click();
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[11]")).click();
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[12]")).click();


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


    //Send Tag Friend and Location
    @Test(priority = 6)
    public void SendTagFriendAndLocation() throws Exception {
        try {


            Robot robot = new Robot();
            driver.findElement(By.name("post")).sendKeys("Send Tag Friend + Location!" + "\n");
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("li.ossn-wall-friend.ossn-wall-container-control-menu-tag-friend")).click();

            Thread.sleep(2000);

            driver.findElement(By.id("token-input-ossn-wall-friend-input")).sendKeys("EZQUA");

            Thread.sleep(5000);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            driver.findElement(By.id("token-input-ossn-wall-friend-input")).sendKeys("thinh");

            Thread.sleep(5000);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            sleep(2000);

            driver.findElement(By.cssSelector("li.ossn-wall-location.ossn-wall-container-control-menu-location")).click();


            Thread.sleep(2000);
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-location-input\"]")).sendKeys("Saigon");

            Thread.sleep(5000);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);


            driver.findElement(By.cssSelector("input.btn.btn-primary.ossn-wall-post")).click();
            Thread.sleep(5000);

            System.out.print("Passed Case SendTagFriendAndLocation ");
        }
        catch (Exception e)
        {
            System.out.print("Failed Case SendTagFriendAndLocation ");
        }

    }
    //Send Tag Friend And Images
     @Test(priority = 7)
    public void SendTagFriendAndImages() throws Exception
    {
        try {


            Robot robot = new Robot();
            driver.findElement(By.name("post")).sendKeys("Send Tag Friend + Images !" + "\n");
            driver.findElement(By.cssSelector("li.ossn-wall-friend.ossn-wall-container-control-menu-tag-friend")).click();

            Thread.sleep(2000);

            driver.findElement(By.id("token-input-ossn-wall-friend-input")).sendKeys("EZQUA");

            Thread.sleep(5000);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            driver.findElement(By.id("token-input-ossn-wall-friend-input")).sendKeys("thinh");

            Thread.sleep(5000);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            driver.findElement(By.id("token-input-ossn-wall-friend-input")).sendKeys("Quân");

            Thread.sleep(5000);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            driver.findElement(By.id("token-input-ossn-wall-friend-input")).sendKeys("Phúc");

            Thread.sleep(5000);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);


            // Upload Image

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

            sleep(3000);
            driver.findElement(By.cssSelector("input.btn.btn-primary.ossn-wall-post")).click();
            sleep(3000);


            System.out.print("Passed Case SendTagFriendAndImages ");
        }
        catch ( Exception e)
        {
            System.out.print("Failed Case SendTagFriendAndImages ");
        }

    }

    //Send Tag Friend and Emoji
    @Test(priority =8)
    public void SendTagFriendAndEmoji() throws Exception
    {
        try {


            Robot robot = new Robot();
            driver.findElement(By.name("post")).sendKeys("Send Tag Friend + Emoji !" + "\n");
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("li.ossn-wall-friend.ossn-wall-container-control-menu-tag-friend")).click();

            Thread.sleep(2000);


            Thread.sleep(5000);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            driver.findElement(By.id("token-input-ossn-wall-friend-input")).sendKeys("Quân");

            Thread.sleep(5000);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            driver.findElement(By.id("token-input-ossn-wall-friend-input")).sendKeys("Phúc");

            Thread.sleep(5000);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(2000);

            // Upload Image
            driver.findElement(By.cssSelector("i.fa.fa-smile-o")).click();
            Thread.sleep(4000);
            driver.findElement(By.xpath("/*//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[1]")).click();
            driver.findElement(By.xpath("/*//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[2]")).click();
            driver.findElement(By.xpath("/*//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[3]")).click();
            driver.findElement(By.xpath("/*//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[4]")).click();
            driver.findElement(By.xpath("/*//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[5]")).click();
            driver.findElement(By.xpath("/*//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[6]")).click();
            driver.findElement(By.xpath("/*//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[7]")).click();
            driver.findElement(By.xpath("/*//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[8]")).click();
            driver.findElement(By.xpath("/*//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[9]")).click();
            driver.findElement(By.xpath("/*//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[10]")).click();
            driver.findElement(By.xpath("/*//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[11]")).click();
            driver.findElement(By.xpath("/*//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[12]")).click();
            sleep(3000);
            driver.findElement(By.cssSelector("input.btn.btn-primary.ossn-wall-post")).click();
            sleep(5000);

            System.out.print("Passsed Case SendTagFriendAndEmoji ");
        }
        catch (Exception e)
        {
            System.out.print("Failed Case SendTagFriendAndEmoji ");
        }

    }

    //Send Location And Images
    @Test(priority = 9 )
    public void SendLocationAndImages() throws Exception
    {
        try {

            Robot robot = new Robot();
            driver.findElement(By.name("post")).sendKeys("Send Location And Images  !" + "\n");
            driver.findElement(By.cssSelector("li.ossn-wall-location.ossn-wall-container-control-menu-location")).click();

            Thread.sleep(2000);
            driver.findElement(By.xpath("/*//*[@id=\"ossn-wall-location-input\"]")).sendKeys("Saigon");

            Thread.sleep(5000);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            // Upload Image
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


            sleep(3000);
            driver.findElement(By.cssSelector("input.btn.btn-primary.ossn-wall-post")).click();
            sleep(5000);
            System.out.print("Passed Case SendLocationAndImages ");
        }
        catch (Exception e)
        {
            System.out.print("Failed Case SendLocationAndImages ");
        }

    }

    //Send Location And Emoji
    @Test(priority =10 )
    public void SendLocationAndEmoji() throws Exception
    {
        try {


            Robot robot = new Robot();
            driver.findElement(By.name("post")).sendKeys("Send Location And Emoji  !" + "\n");
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("li.ossn-wall-location.ossn-wall-container-control-menu-location")).click();

            Thread.sleep(2000);
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-location-input\"]")).sendKeys("Saigon");

            Thread.sleep(5000);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            // Upload Image
            driver.findElement(By.cssSelector("i.fa.fa-smile-o")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[1]")).click();
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[2]")).click();
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[3]")).click();
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[4]")).click();
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[5]")).click();
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[6]")).click();
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[7]")).click();
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[8]")).click();
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[9]")).click();
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[10]")).click();
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[11]")).click();
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[12]")).click();
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[13]")).click();
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[14]")).click();
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[15]")).click();
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[16]")).click();
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[17]")).click();
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[18]")).click();
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[19]")).click();
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[20]")).click();
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[21]")).click();
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[22]")).click();
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[23]")).click();
            driver.findElement(By.xpath("*//*//**//*[@id=\"ossn-wall-form\"]/fieldset/div[2]/div[5]/div/div[1]/li[24]")).click();
            sleep(3000);
            driver.findElement(By.cssSelector("input.btn.btn-primary.ossn-wall-post")).click();
            sleep(3000);
            System.out.print("Passed Case SendLocationAndEmoji ");
        }
        catch (Exception e)
        {
            System.out.print("Failed Case SendLocationAndEmoji ");
        }

    }







    @Test(priority =11)
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
    @Test(priority =12)
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

    }
    @Test(priority =13)
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
    @Test(priority =14)
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
    @Test(priority =15)
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

    @AfterTest
    public void afterTest()
    {

        driver.close();

    }


}
