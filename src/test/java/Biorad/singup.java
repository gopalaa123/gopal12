package Biorad;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class singup {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\rayasam.krishna\\Documents\\gopal12\\Resourses\\chromedriver.exe");
		
		 ChromeOptions chromeOptions = new ChromeOptions();

		 chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
		 ChromeDriver driver = new ChromeDriver(chromeOptions);
		
		driver.navigate().to("https://d1iggqkp62cbjh.cloudfront.net/login");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		FileInputStream file = new FileInputStream("C:\\Users\\rayasam.krishna\\Desktop\\New folder\\Bio-Radproject.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet4");
		
		int rowcount = sheet.getLastRowNum();
		
		
		for(int i=1; i<=rowcount; i++) {
			XSSFRow row = sheet.getRow(i);
			
			String Name   = row.getCell(0).getStringCellValue();
			String Company = row.getCell(1).getStringCellValue();
			String Email   = row.getCell(2).getStringCellValue();
			String UserName   = row.getCell(3).getStringCellValue();
			String password   = row.getCell(3).getStringCellValue();
			
			
			
			driver.findElement(By.xpath("//input[@placeholder='Enter name']")).sendKeys(Name);
			driver.findElement(By.xpath("//input[@placeholder='Enter company']")).sendKeys(Company);
			driver.findElement(By.xpath("//input[@placeholder='Enter email']")).sendKeys(Email);
			driver.findElement(By.xpath("//input[@placeholder='Enter username']")).sendKeys(UserName);
			driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys(password);
			driver.findElement(By.xpath("//input[@value='Sign In']")).click();
			
		
	
		
	
		}
		
		

	}

}
