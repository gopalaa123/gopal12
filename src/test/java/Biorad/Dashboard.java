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

public class Dashboard {



		
		
		

			public static void main(String[] args) throws Exception {
				// TODO Auto-generated method stub
				
				System.setProperty("webdriver.chrome.driver","C:\\Users\\rayasam.krishna\\Documents\\gopal12\\Resourses\\chromedriver.exe");
				
				 ChromeOptions chromeOptions = new ChromeOptions();

				 chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
				 ChromeDriver driver = new ChromeDriver(chromeOptions);
				
				driver.get("https://d1iggqkp62cbjh.cloudfront.net/login");
				
				driver.findElement(By.xpath("//input[contains(@placeholder, 'Enter email')]")).sendKeys("vijayakumar.l02@mphasis.com");
				driver.findElement(By.xpath("//input[contains(@placeholder, 'Enter password')]")).sendKeys("Admin@321");
				driver.findElement(By.xpath("//input[@value='Sign In']")).click();
				
				FileInputStream file = new FileInputStream("C:\\Users\\rayasam.krishna\\Desktop\\New folder\\Bio-Radproject.xlsx");
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				XSSFSheet sheet = workbook.getSheet("Sheet3");
				
				int rowcount = sheet.getLastRowNum();
				
				
				for(int i=1; i<=rowcount; i++) {
					XSSFRow row = sheet.getRow(i);
					
					String ExperimentName   = row.getCell(0).getStringCellValue();
					//String Species = row.getCell(1).getStringCellValue();
					//String sampleName  = row.getCell(2).getStringCellValue();
					
					driver.findElement(By.xpath("//input[@placeholder='Description']")).sendKeys(ExperimentName);
					//driver.findElement(By.xpath("//input[@placeholder='Sample Name']")).sendKeys(sampleName);
					
					Thread.sleep(2000);
					driver.findElement(By.xpath("//p[contains(@class, 'text-short')]")).click();
					Thread.sleep(2000);
	}

}
}
