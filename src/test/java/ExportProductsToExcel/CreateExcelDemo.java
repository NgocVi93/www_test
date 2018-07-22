package ExportProductsToExcel; /**
 * Created by sysadmin on 9/14/17.
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

public class CreateExcelDemo {
    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }


    public static void main(String[] args) throws IOException {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Employees sheet");

        List<Employee> list = EmployeeDAO.listEmployees();

        int rownum = 0;
        Cell cell;
        Row row;
        //
        HSSFCellStyle style = createStyleForTitle(workbook);

        row = sheet.createRow(rownum);


        // EmpNo
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("title");
        cell.setCellStyle(style);

        // Title
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("description");
        cell.setCellStyle(style);
       String a = cell.getStringCellValue();

        // Price
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("price");
        cell.setCellStyle(style);

        // Content
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("currency");
        cell.setCellStyle(style);

        // shop_category
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("quantity");
        cell.setCellStyle(style);

//market_category
        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("manufacturer");
        cell.setCellStyle(style);
        // manufacturer
        cell = row.createCell(6, CellType.STRING);
        cell.setCellValue("expiry_type");
        cell.setCellStyle(style);
        // Ogigin
        cell = row.createCell(7, CellType.STRING);
        cell.setCellValue("begin_day");
        cell.setCellStyle(style);
        // Grade
        cell = row.createCell(8, CellType.STRING);
        cell.setCellValue("end_day");
        cell.setCellStyle(style);
        // Bonus
        cell = row.createCell(9, CellType.STRING);
        cell.setCellValue("duration");
        cell.setCellStyle(style);

        // Bonus
        cell = row.createCell(10, CellType.STRING);
        cell.setCellValue("origin");
        cell.setCellStyle(style);
        // Bonus
        cell = row.createCell(11, CellType.STRING);
        cell.setCellValue("download");
        cell.setCellStyle(style);



        // Data
        for (Employee emp : list) {
            rownum++;
            row = sheet.createRow(rownum);


            // EmpName (A)
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue(emp.getTitle());
            // EmpNo (B)
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(emp.getContent());


            // Salary (C)
            cell = row.createCell(2, CellType.NUMERIC);
            cell.setCellValue(emp.getPrice());


            // Quantity (D)
            cell = row.createCell(3, CellType.NUMERIC);
            cell.setCellValue(emp.getproduct_currency());
            // Grade (E)
            cell = row.createCell(4, CellType.NUMERIC);
            cell.setCellValue(emp.getquanlity());

            // Salary (F)
            cell = row.createCell(5, CellType.NUMERIC);
            cell.setCellValue(emp.getManufacturer());






            // EmpNo (G)
            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue(emp.getExp_type());
            // EmpName (H)
            cell = row.createCell(7 , CellType.STRING);
            cell.setCellValue(emp.getBegin_day());




            // EmpNo (H)
            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue(emp.getend_day());
            // EmpName (I)
            String formula = "I" + (rownum + 1) + "-H" + (rownum + 1);
            cell = row.createCell(9, CellType.STRING);
            cell.setCellFormula(formula);


            // EmpName (J)
            cell = row.createCell(10, CellType.STRING);
            cell.setCellValue(emp.getOrigin());



            // Salary (k)
            cell = row.createCell(11, CellType.NUMERIC);
            cell.setCellValue(emp.getDownload());



        }

        File file = new File("/home/sysadmin/Excel/default.xlsx");

            file.getParentFile().mkdirs();

            FileOutputStream outFile = new FileOutputStream(file);
            workbook.write(outFile);
            System.out.println("Created file: " + file.getAbsolutePath());



    }






}