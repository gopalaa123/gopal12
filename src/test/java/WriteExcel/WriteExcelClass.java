package WriteExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelClass {
	
	public void writeExcel(String sheetName,String cellvalue,int row,int col) throws Exception  {
		
		String excelPath="C:\\Users\\rayasam.krishna\\eclipse-workspace\\gopal12\\src\\test\\java\\com\\gopal12\\New Microsoft Excel Worksheet.xlsx";
		
		File file = new File(excelPath);
		
		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet= wb.getSheet(sheetName);
		
		sheet.getRow(row).createCell(col).setCellValue(cellvalue);
		
		FileOutputStream fos = new FileOutputStream(new File(excelPath));
		
		wb.write(fos);
		
		wb.close();
		
		fos.close();
		
		
		
	}

}
