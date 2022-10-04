package helpers;

import helpers.Path;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelFileManager {
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static File file;


    public static String setDataFromExcelFile(int columnNo, int rowNo) throws IOException {
        file = new File(Path.FilePath);
        FileInputStream inputStream = new FileInputStream(file);
        workbook = new XSSFWorkbook(inputStream);
        sheet = workbook.getSheet("Sheet1");
        row = sheet.getRow(rowNo);
        cell = row.getCell(columnNo);
        String Data = cell.getStringCellValue();
        return Data;
    }
}
