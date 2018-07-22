package Functions;

import java.security.SecureRandom;

/**
 * Created by sysadmin on 8/30/17.
 */
 public class Functions {

    static void Sleep(int time) throws InterruptedException
    {

        Thread.sleep(time);

    }
    public void  sleep ( int time) throws Exception
    {
        Thread.sleep(time);
    }



    // Random String
    static final String AB = "aáâăạãảeéèếêẹẻẽẾẾÈẼẺÊẾỆiíìỉĩịIÍÌỈĨỊòóoọỏõôốồộổỗ u ú ù ụ ủ ũ U Ú Ù Ụ Ũ Ủ ư ứ ừ ự ữ Ư Ứ Ừ Ự Ử Ữ  y ý ỳ ỵ ỷ ỹ Y Ý Ỳ Ỵ Ỷ Ỹ ";

    static SecureRandom rnd = new SecureRandom();
   static String randomString( int len ){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();


    }

    // Random numbers
    static String price="12345679912541236874";
    static  String randomPrice(int len)
    {
        StringBuilder sb = new StringBuilder(  );
        for( int i = 0; i < len; i++ )
            sb.append( price.charAt( rnd.nextInt(price.length()) ) );
        return sb.toString();
    }



}
