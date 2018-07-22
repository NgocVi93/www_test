/**
 * Created by sysadmin on 7/11/17.
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


public class ProfilePage
{

    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception
    {
        System.setProperty("webdriver.chrome.driver", "/home/sysadmin/ChromeDriver/chromedriver");
        // System.setProperty("webdriver.gecko.driver", "/home/sysadmin/FifoxDriver/geckodriver");
        driver = new ChromeDriver();
      //  driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }


    // Chức năng Login
    @Test(priority = 1)
    public void driver1Login() throws Exception {


        driver.navigate().to("https://beta.ezqua.com/");
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("a.btn.btn-primary")).click();

    try {


        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("vipn123");


        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("vipn123");

        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
        Thread.sleep(5000);
        System.out.print(" Passed Case driver Login Success" + "\n");
    }
    catch (Exception e)
    {
        System.out.print(" Failed Case driver Login Success" + "\n");
    }

    }




@Test(priority=2)
    public void EditFirsttName() throws Exception
    {
try {
   // driver.findElement(By.cssSelector("a.edit-profile")).click();
    driver.findElement(By.cssSelector("li.ossn-topbar-dropdown-menu")).click();

    driver.findElement(By.cssSelector("a.menu-topbar-dropdown-account_settings")).click();
    driver.findElement(By.name("firstname")).clear();
    sleep(2000);
    driver.findElement(By.name("firstname")).sendKeys("Vipn");
    sleep(2000);
    Robot robot = new Robot();
    robot.keyPress(KeyEvent.VK_PAGE_DOWN);
    robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
    sleep(2000);
    driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
    sleep(2000);

    WebElement abc = driver.findElement(By.name("firstname"));
    System.out.println(abc.getText());
    sleep(2000);
    System.out.print("Passed Case Edit FirstName" + "\n");
}
catch (Exception e)
{
    System.out.print("Failed Case Edit FirstName" + "\n");
}

    }
    @Test(priority=3)
    public void EditlastName() throws Exception
    {
        try {


            driver.findElement(By.name("lastname")).clear();
            sleep(2000);
            driver.findElement(By.name("lastname")).sendKeys("Pham");
            sleep(2000);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_PAGE_DOWN);
            robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
            sleep(2000);
            driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
            sleep(2000);
            System.out.print("Passed Case Edit LastName" + "\n");
        }
        catch (Exception e)
        {
            System.out.print("Failed Case Edit LastName" + "\n");
        }

    }
    @Test(priority=4)
    public void EditEmail() throws Exception
    {
        try {
        driver.findElement(By.name("email")).clear();
        sleep(2000);
        driver.findElement(By.name("email")).sendKeys("chiphandsome0104@gmail.com");
        sleep(2000);
        Robot robot =new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        sleep(2000);
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
            sleep(2000);
            System.out.print("Passed Case Edit Email" + "\n");
        }
        catch (Exception e)
        {
            System.out.println("Failed Case Edit Email" + "\n");
        }

    }
    @Test(priority=5)
    public void ChangePasword() throws Exception
    {
        try {


            driver.findElement(By.name("password")).clear();
            sleep(2000);
            driver.findElement(By.name("password")).sendKeys("111111");
            sleep(2000);
            Robot robot =new Robot();
            robot.keyPress(KeyEvent.VK_PAGE_DOWN);
            robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
            sleep(2000);
            driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
            sleep(2000);
            System.out.print("Passed Case Change Password" + "\n");
        }
        catch (Exception e)
        {
            System.out.print("Failed Case Change Password" + "\n");
        }

    }

    public void CheckformatEmail() throws Exception
    {

        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("abc");
        Robot robot =new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        sleep(2000);
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
        sleep(500);
        String abc= driver.findElement(By.cssSelector("div.col-md-11.ossn-system-messages-inner")).getText();
        sleep(500);
        String expected="Email không hợp lệ";

        if(abc.equals(expected))
        {
            System.out.print("Pased Case check Format Email");
        }
        else
        {
            System.out.print("Failed Case check Format Email");

        }


    }


    @Test(priority=6)
    public void EditGender() throws Exception
    {

        Robot robot =new Robot();


        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        sleep(2000);
        try
        {

            driver.findElement(By.name("gender")).click();

            driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
            sleep(2000);
            System.out.println("Passed Case Edit Gender");

        }
        catch (Exception e)
        {
            System.out.println("Failed Case Edit Gender");

        }

    }

    @Test(priority=7)
    public void EditLanguage() throws Exception
    {

        Robot robot =new Robot();
       // driver.findElement(By.cssSelector("a.edit-profile")).click();


        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        sleep(2000);

        try
        {
            // choose in drop down list
            Select DrpLanguage=new Select(driver.findElement(By.name("language")));
            DrpLanguage.selectByVisibleText("Vietnamese");


            driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
            sleep(2000);
            System.out.println("Passed Case Change Language");
            sleep(7000);


        }
        catch (Exception e)
        {
            String ActualLanguage=driver.findElement(By.cssSelector("input.btn.btn-primary")).getText();
            System.out.println("Failed Case Change Language");
            System.out.print("Language : "+ActualLanguage);
        }
    }

    @Test(priority=8)
    public void EditAllInfor() throws Exception
    {
        try
        {
            //Edit firstname
            driver.findElement(By.name("firstname")).clear();
            driver.findElement(By.name("firstname")).sendKeys("Vipn");
            sleep(2000);

            // Edit lastname
            driver.findElement(By.name("lastname")).clear();
            driver.findElement(By.name("lastname")).sendKeys("All");
            sleep(2000);

            //Edit Email
           // driver.findElement(By.name("email")).clear();
          //  driver.findElement(By.name("email")).sendKeys("abc@gmail.com");
           // sleep(2000);

            // edit Password

            driver.findElement(By.name("password")).clear();
            driver.findElement(By.name("password")).sendKeys("222222");
            sleep(2000);


            // Edit Gender
            driver.findElement(By.cssSelector("input.ossn-radio-input[value='female']")).click();
            sleep(2000);


            //scroll to the end's page
            Robot robot =new Robot();
            robot.keyPress(KeyEvent.VK_PAGE_DOWN);
            robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
            sleep(2000);

            // Edit Language
            Select DrpLanguage=new Select(driver.findElement(By.name("language")));
            DrpLanguage.selectByVisibleText("English");


            driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
            sleep(2000);

            System.out.println("Update All of Infor thành công");


        }
        catch (Exception e)
        {
            System.out.println("Update All of Infor failed");
        }
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
    public void TakesScreenShotExample() throws Exception
    {
        {

            //    driver.get("http://www.google.com/");
            File scrFile = ((TakesScreenshot)driver).
                    getScreenshotAs(OutputType.FILE);
            System.out.println(scrFile.getAbsolutePath());

        }
    }

    @AfterTest
    public void afterTest()
    {

        driver.close();

    }

}


