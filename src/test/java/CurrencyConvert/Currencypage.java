package CurrencyConvert;

/**
 * Created by sysadmin on 10/19/17.
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class Currencypage {
    private WebDriver driver;

    By txtWalletAmount=By.cssSelector("span.lead");
    By chooseProduct=By.xpath(".//*[@id='show_product']/div/div[2]/div/div[1]");
    By PriceProductWasChosse=By.xpath(".//*[@id='show_product']/div/div[2]/div/div[1]/a/strong");
    By btnBuy=By.id("btn_buy_product");

    By priceProductInShop =By.xpath("html/body/div[4]/div/div[2]/div/div/div/div[2]/div/div[2]/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[2]");
    By priceproductInCart=By.id("sub-total");
    By totalPrice=By.id("total");
    By btnIconMarketCart=By.id("ossn-notif-market-cart");
    By btnViewShopingCart=By.xpath("html/body/div[4]/div/div[1]/div/div/div[4]/div/div/div/div[3]/div/a[1]");


    //button Tiếp thep
    By btnSusscess=By.cssSelector("a.btn.btn-success"); public void clickbtnSusscess(){driver.findElement(btnSusscess).click();}

    // Lây thông tin button Kho của tôi
    By btnDelevery=By.cssSelector("div.col-sm-12.paymentmethod.btn_storage");


    //Chon thanh toán bằng Ví của tôi
    By btnByWallet=By.cssSelector("div.col-sm-12.paymentmethod.btn_wallet");

    // Số tiền còn lại
    By RemainingMount =By.xpath(".//*[@id='payment_form']/fieldset/div[1]/div[2]/fieldset/div/div[2]/p[4]/span");

    //Xác nhận
    By btnpayment_submit =By.id("payment_submit_btn");

    public  Currencypage(WebDriver driver)
    {
        this.driver=driver;
    }



    public void getWallet()
    {

        driver.findElement(txtWalletAmount).getText();
    }
 public String getPriceProductWasChosse()
    {

        return driver.findElement(PriceProductWasChosse).getText();
    }

    public void getpriceProductInShop()
    {
        driver.findElement(priceProductInShop).getText();
    }
     public String  getpriceproductInCart()
    {
        return driver.findElement(priceproductInCart).getText();
    }

public String  getTotalpriceInCart()
    {
       return  driver.findElement(totalPrice).getText();
    }


 public void clickbtnBuy()
    {

        driver.findElement(btnBuy).click();
    }
public void clickchooseProduct()
    {

        driver.findElement(chooseProduct).click();
    }

public void clickbtnIconMarketCart()
    {

        driver.findElement(btnIconMarketCart).click();
    }

public void clickbtnViewShopingCart()
    {

        driver.findElement(btnViewShopingCart).click();
    }
//Click Kho của tôi
    public void clickbtnDelevery()
    {
        driver.findElement(btnDelevery).click();
    }

    //Chọn thanh toán bằng ví của tôi
    public void clickbtnByWallet()
    {
        driver.findElement(btnByWallet).click();
    }

    public String getRemainingMount()
    {
      return   driver.findElement(RemainingMount).getText();
    }
    public void clickbtnpayment_submit()
    {
        driver.findElement(btnpayment_submit).click();
    }




    public float getWalletAmount()
    {
        String balance = driver.findElement(txtWalletAmount).getText();
        String replace = balance.replace("$", "");

        System.out.print(replace);
        return  Float.parseFloat(replace);


    }

}
