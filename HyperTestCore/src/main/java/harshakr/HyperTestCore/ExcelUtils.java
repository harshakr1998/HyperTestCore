package harshakr.HyperTestCore;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ExcelUtils(String excelPath, String sheetName) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(excelPath);
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet(sheetName);
    }

    public String getCellData(int rowNum, int colNum) {
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
    }

    public int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    public int getColCount() {
        return sheet.getRow(0).getPhysicalNumberOfCells();
    }
}

