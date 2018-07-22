package ExportProductsToExcel;

/**
 * Created by sysadmin on 9/14/17.
 */
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import ExportProductsToExcel.CreateExcelDemo;
public class EmployeeDAO {

    //Random string
    static final String AB = "abcdeghiklmnopqrstuvsy";

    static SecureRandom rnd = new SecureRandom();

    static String randomString( int len ){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }

    // Random numbers
  static   String price="123456799125412368740";
    static String randomPrice(int len)
    {
        StringBuilder sb = new StringBuilder(  );
        for( int i = 0; i < len; i++ )
            sb.append( price.charAt( rnd.nextInt(price.length()) ) );
        return sb.toString();
    }

    public static List<Employee> listEmployees() {
        List<Employee> list = new ArrayList<Employee>();

    for(int i=0;i<=5;i++)
    {

    Employee e = new Employee("product"+i,"description"+i,randomPrice(4),"VND",i,"manufacturer"+i,randomPrice(3),randomPrice(1),randomPrice(2),"","Origin"+i,i );
    list.add(e);


      // String a= cell.getStringCellValue();
        }



        return list;
    }
}
