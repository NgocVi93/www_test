package ExportProductsToExcel;

/**
 * Created by sysadmin on 9/14/17.
 */


public class Employee {
    private String  content;
    private String product_currency;

    private String product_price;
    private String exp_type;
    private int  download;
    private String title ;
    private String manufacturer;
    private String origin;
    private String begin_day;
    private String end_day;
    private String duration;


    private int quanlity;

    private int grade;
    private Double bonus;

    public Employee(  String title , String content,String product_price,String product_currency,int quantity,String manufacturer,

                    String exp_type, String begin_day, String end_day, String duration,String origin,int  download) {

        this.title = title;
        this.content=content;
        this.product_currency = product_currency;
        this.quanlity=quantity;

        this.product_price = product_price;

        this.exp_type = exp_type;


        this.manufacturer = manufacturer;
        this.duration= duration;
        this.origin = origin;
        this.begin_day = begin_day;
        this.end_day = end_day;

        this.download =download;
    }
    //Title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    //Content
    public String getContent() {

        return content;
    }

    public void setcontent(String content) {
        this.content = content;
    }


    //Price
    public String getPrice() {
        return product_price;
    }
    public void setPrice(String product_price) {
        this.product_price = product_price;
    }
    //Curency
    public String getproduct_currency() {

        return product_currency;
    }

    public void setproduct_currency(String product_currency) {
        this.product_currency = product_currency;
    }



//Quantity

    public int  getquanlity() {
        return quanlity;
    }

    public void setquanlity(int  quanlity) {
        this.quanlity= quanlity;
    }


    //Manuafacter



    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    //Exp day

    public String getExp_type() {
        return exp_type;
    }

    public void setExp_type(String Exp_type) {
        this.exp_type = exp_type;
    }



    //begin day
    public String getBegin_day() {
        return begin_day;
    }
    public void setBegin_day(String  quantity) {
        this.begin_day = begin_day;
    }

    //End day
    public String getend_day() {
        return end_day;
    }
    public void setnd_day(String  discount) {
        this.end_day = end_day;
    }

//origin

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }


    //Duration
    public String getduration() {
        return duration;
    }
    public void setdDuration(String duration) {
        this.duration = duration;
    }


    //Download
    public int  getDownload() {
        return download;
    }
    public void setDownload(int  download) {
        this.download = download;
    }





}
