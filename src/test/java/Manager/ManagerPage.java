package Manager;

/**
 * Created by sysadmin on 10/24/17.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.security.SecureRandom;
import java.util.*;
import java.util.List;

public class ManagerPage {


    private WebDriver driver;
    public  ManagerPage(WebDriver driver)
    {
        this.driver=driver;
    }

    // Menu manager
    By menu_category=By.xpath(".//*[@id='mainmenu']/ul/li[3]/a");
    By menu_product =By.xpath(".//*[@id='mainmenu']/ul/li[4]/a");
    By menu_promotion =By.xpath(".//*[@id='mainmenu']/ul/li[5]/a");

    public void Click_MenuCateGory(){driver.findElement(menu_category).click();}
    public void Click_MenuProduct(){driver.findElement(menu_product).click();}
    public void Click_MenuPromotion(){driver.findElement(menu_promotion).click();}
    //End Menu

    //Category

    By category_add =By.cssSelector("div.btn-toolbar.btn-toolbar-media-manager.pull-right");
    By category_multi_delete=By.cssSelector("div.btn-group.pull-left");
    By category_name=By.name("title");
    By category_add_content=By.cssSelector("div.note-editable");
    By category_parent=By.id("parent");
    By category_order_plus=By.cssSelector("a.btn.btn-default.btn-order");
    By category_order=By.name("sort_order");
    By category_starus=By.name("enabled");
    By category_submit=By.name("submit");

    public void Click_ButtonAdd(){driver.findElement(category_add).click();}
    public void Click_MultiDelete(){driver.findElement(category_multi_delete).click();}

    public void Send_CategoryName(String CategoryName){driver.findElement(category_name).sendKeys(CategoryName);}
    public void Clear_Categoryname(){driver.findElement(category_name).clear();}
    public void Send_AddContent(String AddContent){driver.findElement(category_add_content).sendKeys(AddContent);}
    public void Clear_AddContent(){driver.findElement(category_add_content).clear();}
    public void Click_OrderPlus(){driver.findElement(category_order_plus).click();}
    public void Click_SelectParent(){driver.findElement(category_parent).click();}
    public void Send_Order(String number){driver.findElement(category_order).sendKeys(number);}
    public void Click_Submit(){driver.findElement(category_submit).click();}

    public void Choose_ParentCategory() throws Exception
    {
        Click_SelectParent();
        Robot robot =new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
           robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);


    }
 public void Choose_CategoryStatus(String value)
    {
        if(value=="true") {
            Select DrpLanguage = new Select(driver.findElement(By.name("enabled")));
            DrpLanguage.selectByValue(value);
        }
        else if(value=="false")
        {
            Select DrpLanguage = new Select(driver.findElement(By.name("enabled")));
            DrpLanguage.selectByValue(value);
        }
        else
        {
            System.out.print("Failed Choose Category status");
        }
    }


    public void AddNewCateFory(String name,String content,String status) throws Exception
    {

        this.Send_CategoryName(name);
        this.Send_AddContent(content);

       this.Choose_ParentCategory();
       this.Choose_CategoryStatus(status);

      //  this.Click_OrderPlus();
      // this.Choose_StatusVisible();
        this.Click_Submit();
    }

    public void EditCategory(String name, String content,String status)throws Exception
    {
        try
        {
        this.Clear_Categoryname();
        Thread.sleep(2000);
        this.Send_CategoryName(name);
        Thread.sleep(2000);
        this.Clear_AddContent();
        this.Send_AddContent(content);
        Thread.sleep(2000);
        this.Choose_ParentCategory();
            this.Choose_CategoryStatus(status);
        // this.Choose_StatusVisible();
            Thread.sleep(5000);
        this.Click_Submit();

        }
        catch (Exception e)
        {
            System.out.print("Failed Edit Category!");
        }
    }

    public void DeleteCategory()throws InterruptedException
    {
        try
        {

            driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div[1]/form/div[3]/table/tbody/tr[9]/td[5]/ul/li[2]/a")).click();
            Robot robot = new Robot();
            Thread.sleep(5000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        }
        catch (Exception a)
        {
            System.out.print("Failed DeleteCategory!");
        }


    }

    public int Count() throws Exception
    {

        List<WebElement> ListRowprice = driver.findElements(By.className("object_action"));
        Thread.sleep(2000);
        return  ListRowprice.size();

    }
    // End category




    // Product
    By btnAddProduct =By.xpath("html/body/section/div[2]/div/div/div[1]/div[1]/div/div[2]/a/button");
    By product_voucher =By.xpath("//*[@id=\"general\"]/div[2]/div[1]/div[2]/div/div/button[2]");
    By product_name =By.name("product_name");
    By product_shopcategory =By.id("token-input-shop_category");
    By product_marketcategory =By.id("token-input-market_category");
    By product_imageupload=By.name("product_name");
    By product_price=By.id("product_price");
    By product_content=By.cssSelector("div.note-editable");
    By product_sku=By.name("product_sku");
    By product_group=By.name("product_group");
    By product_manufacture=By.name("product_manufacture");
    By product_origin=By.name("product_origin");
     By product_weight=By.name("product_weight");
    By product_tax=By.name("product_tax");
    By product_quantity=By.name("product_quantity");
    By product_expiryday=By.name("select2-expiry_type-container");
    By storage_duration=By.name("storage_duration");

    By product_status=By.xpath("//*[@id=\"select2-enabled-3o-container\"]");
    By product_order=By.name("product_order");
    By product_sumit=By.xpath("//*[@id=\"product-add\"]/fieldset/div[1]/input");
    public void Click_ProductShopCategory() throws Exception{//driver.findElement(product_shopcategory).click();

        driver.findElement(product_shopcategory).sendKeys("May");
        Thread.sleep(3000);
        Robot robot =new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }
    public void Click_ProductMarketCategory() throws Exception{//driver.findElement(product_marketcategory).click();
        driver.findElement(product_marketcategory).sendKeys("Du");
        Thread.sleep(3000);
        Robot robot =new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
    public void Click_ProductImageUpload(){driver.findElement(product_imageupload).click();}
    public void Click_ProductSumit(){driver.findElement(product_sumit).click();}
    public void Click_btnAddProduct(){driver.findElement(btnAddProduct).click();}
    public void Fill_ProductName(String name){driver.findElement(product_name).sendKeys(name);}
    public void Fill_ProductPrice(String price){driver.findElement(product_price).sendKeys(price);}
    public void Fill_ProductContent(String content){driver.findElement(product_content).sendKeys(content);}
    public void Fill_ProductSku(String sku){driver.findElement(product_sku).sendKeys(sku);}
    public void Fill_ProductManufacture(String manufacture){driver.findElement(product_manufacture).sendKeys(manufacture);}
    public void Fill_ProductOrigin(String origin){driver.findElement(product_origin).sendKeys(origin);}
    public void Fill_ProductWeight(String weight){driver.findElement(product_weight).sendKeys(weight);}
   public void Fill_ProductTax(String tax){driver.findElement(product_tax).clear();
        driver.findElement(product_tax).sendKeys(tax);}
    public void Fill_ProductQuantity(String quantity){driver.findElement(product_quantity).sendKeys(quantity);}
    public void Fill_ProductOrder(String order){driver.findElement(product_order).sendKeys(order);}
    public void Click_ProductStatus(){driver.findElement(product_status).click();}
    public void Click_ProductVoucher(){driver.findElement(product_voucher).click();}

    public void AddProductWithOnLyFillProductName(String name, String price,String sku,String content,
                                                   String manufacture,String origin,
                                                  String tax,String quantity,String order)throws Exception
    {
        this.Fill_ProductName(name);
        this.Fill_ProductPrice(price);
        this.Fill_Storage_Duration();
        this.Fill_ProductSku(sku);

     //   this.Click_ProductShopCategory();
        this.Choose_ProductImage();
        this.Fill_ProductContent(content);
        this.Click_ProductVoucher();
        Thread.sleep(2000);
  //  this.Click_ProductMarketCategory();
        this.Fill_ProductManufacture(manufacture);
        this.Fill_ProductOrigin(origin);
        this.Fill_ProductQuantity(quantity);

        this.Fill_ProductTax(tax);
        driver.findElement(By.xpath("//*[@id=\"custom_attributes_table\"]/thead/tr/th[2]")).click();
        Robot robot =new Robot();
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        Thread.sleep(2000);
        this.Fill_ProductOrder(order);





        driver.findElement(By.xpath("//*[@id=\"custom_attributes_table\"]/thead/tr/th[2]")).click();
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_PAGE_UP);
        robot.keyRelease(KeyEvent.VK_PAGE_UP);
        Thread.sleep(2000);
        // true On, faile Off



    }
    public void Fill_Storage_Duration()throws Exception
    {
        driver.findElement(storage_duration).clear();
        driver.findElement(storage_duration).sendKeys("50");

    }

    public void Choose_ProductImage()throws Exception
    {

        StringSelection ss = new StringSelection("~/Pictures/1.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        driver.findElement(By.id("fileupload")).click();

        Thread.sleep(3000);
        Robot robot =new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        robot.keyPress(KeyEvent.VK_PAGE_DOWN);


    } /*public void Choose_ProductGroup(String group)
    {

        Float.parseFloat(group);
        switch (Integer.parseInt(group))
        {
            // Group Dien thoai
            case 4017:
            {
                Select DrpLanguage = new Select(driver.findElement(By.name("product_group")));
                DrpLanguage.selectByValue(group); //4018
            }

            default:

        }

    }*/
  public void Choose_ProductStatus() throws Exception
    {
        this.Click_ProductStatus();
          Robot robot =new Robot();
        robot.keyPress(KeyEvent.VK_UP);
        robot.keyRelease(KeyEvent.VK_UP);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);


       /* if(value=="true") {
            Select DrpLanguage = new Select(driver.findElement(By.name("product_status")));
            DrpLanguage.selectByValue(value);
~/Pictures/3.png

        }
        else if(value=="false")
        {
            Select DrpLanguage = new Select(driver.findElement(By.name("product_status")));
            DrpLanguage.selectByValue(value);
        }
        else
        {
            System.out.print("Failed Choose product status");
        }
*/

    }



    // End product












    //Random string
    final String AB = "abcdeghiklmnopqrstuvsy";

    SecureRandom rnd = new SecureRandom();

    public String randomString( int len ){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }

    // Random numbers
    String number="123456799125412368740";
    public   String randomNumber(int len)
    {
        StringBuilder sb = new StringBuilder(  );for( int i = 0; i < len; i++ )
        sb.append( number.charAt( rnd.nextInt(number.length()) ) );
        return sb.toString();

    }

}
