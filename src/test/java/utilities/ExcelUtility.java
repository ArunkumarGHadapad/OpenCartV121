package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtility {

    private String excelFilePath;

    // Constructor to initialize the file path
    public ExcelUtility(String excelFilePath) {
        this.excelFilePath = excelFilePath;
    }

    // Method to get data from Excel sheet
    public String getCellData(int rowNum, int colNum) throws IOException {
        FileInputStream file = new FileInputStream(new File(excelFilePath));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0); // Assuming we are working with the first sheet
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(colNum);
        
        String cellData = cell.getStringCellValue();
        workbook.close();
        file.close();
        
        return cellData;
    }

    // Method to get the row count in the Excel sheet
    public int getRowCount(String Sheetname ) throws IOException {
        FileInputStream file = new FileInputStream(new File(excelFilePath));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheet(Sheetname);
        int rowCount = sheet.getLastRowNum();
        workbook.close();
        file.close();
        return rowCount;
    }
    
    public int getCellCount(String Sheetname ,int rownum ) throws IOException {
        FileInputStream file = new FileInputStream(new File(excelFilePath));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheet(Sheetname);
        Row rowCount = sheet.getRow(rownum);
        int cellCount= rowCount.getLastCellNum();
        workbook.close();
        file.close();
        return cellCount;
    }

    	// Method to write data to Excel sheet
    	public void writeToExcel(int rowNum, int colNum, String data) throws IOException {
        FileInputStream file = new FileInputStream(new File(excelFilePath));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        
        Row row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);
        }

        Cell cell = row.createCell(colNum);
        cell.setCellValue(data);

        file.close();
        
        // Write the updated data to the Excel file
        FileOutputStream outFile = new FileOutputStream(new File(excelFilePath));
        workbook.write(outFile);
        outFile.close();
        workbook.close();
    }
}
