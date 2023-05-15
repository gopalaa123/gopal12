package com.gopal12;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedExcelFile {

	 public static void main(String[] args) throws IOException, InterruptedException  {
	        // TODO Auto-generated method stub
		 
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\rayasam.krishna\\Documents\\gopal12\\Resourses\\chromedriver.exe");
			
		 ChromeOptions chromeOptions = new ChromeOptions();

		 chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
		 ChromeDriver driver = new ChromeDriver(chromeOptions);
		 
		 driver.get("https://form.j"+ "otform.com/222641277139457");
					  
			
			FileInputStream file = new FileInputStream("C:\\Users\\rayasam.krishna\\Desktop\\New folder\\ExcelWrite.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("Sheet2");
			
			int rowcount = sheet.getLastRowNum();
			
			
			for(int i=1; i<=rowcount; i++) {
				XSSFRow row = sheet.getRow(i);
				
				String FirstName   = row.getCell(0).getStringCellValue();
				
				String LastName  = row.getCell(1).getStringCellValue();
				String Gender = row.getCell(2).getStringCellValue();
				int Age = (int) row.getCell(3).getNumericCellValue();
				String Address = row.getCell(4).getStringCellValue();
				String  Street = row.getCell(5).getStringCellValue();
				String city = row.getCell(6).getStringCellValue();
				String state = row.getCell(7).getStringCellValue();
				int postal = (int) row.getCell(8).getNumericCellValue();
				String Country = row.getCell(9).getStringCellValue();
				String email = row.getCell(10).getStringCellValue();
				int Areacode = (int) row.getCell(11).getNumericCellValue();
				int phonenumber = (int) row.getCell(12).getNumericCellValue();
				int Eveningcode = (int) row.getCell(13).getNumericCellValue();
				int Eveningphonenumber = (int) row.getCell(14).getNumericCellValue();
				String church = row.getCell(15).getStringCellValue();
				String received = row.getCell(16).getStringCellValue();
				String ministry = row.getCell(17).getStringCellValue();
				String Approximate  = row.getCell(18).getStringCellValue();
				
				
				driver.findElement(By.xpath("//input[@name='q2_name2[first]']")).sendKeys(FirstName);
			Thread.sleep(5000);
				driver.findElement(By.xpath("//input[@name='q2_name2[last]']")).sendKeys(LastName );
				Thread.sleep(5000);
				
				
				List<WebElement> radiobutton = driver.findElements(By.name("q17_gender"));
				int radiosize = radiobutton.size();
				
				for(int j=0; j<radiosize; j++ ) {
					String val = radiobutton.get(j).getAttribute("value");
					
					if(val.equalsIgnoreCase(Gender)) {
						radiobutton.get(j).click();
						
					}
				}
				
				driver.findElement(By.xpath("//input[@name='q18_age']")).sendKeys(String.valueOf(Age));
				driver.findElement(By.xpath("//input[@id='input_19_addr_line1']")).sendKeys(Address);
				driver.findElement(By.xpath("//input[@id='input_19_addr_line2']")).sendKeys(Street);
				driver.findElement(By.xpath("//input[@id='input_19_city']")).sendKeys(city);
				driver.findElement(By.xpath("//input[@id='input_19_state']")).sendKeys(state);
				driver.findElement(By.xpath("//input[@id='input_19_postal']")).sendKeys(String.valueOf(postal));
				
				
				WebElement countryElement = driver.findElement(By.xpath("//select[@id='input_19_country']"));
				Select countryNameDropdown = new Select(countryElement);
				List<WebElement> countryNameDropdownOptions = countryNameDropdown.getOptions();
				for (WebElement option:countryNameDropdownOptions) {
					System.out.println(option.getText());
				}
				
				countryNameDropdown.selectByIndex(1);
				Thread.sleep(3000);
				countryNameDropdown.selectByValue("India");
				Thread.sleep(3000);
				countryNameDropdown.selectByVisibleText(" Russia ");
				Thread.sleep(3000);
				String selectedText = countryNameDropdown.getFirstSelectedOption().getText();
				System.out.println("selected visible text -" +selectedText);
				
			
				
				
				
				driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
				driver.findElement(By.xpath("//input[@id='input_3_area']")).sendKeys(String.valueOf(Areacode));
				driver.findElement(By.xpath("//input[@id='input_3_phone']")).sendKeys(String.valueOf(phonenumber));
				driver.findElement(By.xpath("//input[@id='input_20_area']")).sendKeys(String.valueOf(Eveningcode));
				driver.findElement(By.xpath("//input[@id='input_20_phone']")).sendKeys(String.valueOf(Eveningphonenumber));
				driver.findElement(By.xpath("//input[@name='q21_whatChurch']")).sendKeys(church);
				Thread.sleep(5000);
				
				List<WebElement> radiobutton1 = driver.findElements(By.name("q23_haveYou"));
				int radiosize1 = radiobutton1.size();
				
				for(int a=0; a<radiosize1; a++ ) {
					String val = radiobutton1.get(a).getAttribute("value");
					
					if(val.equalsIgnoreCase(received)) {
					    radiobutton1.get(a).click();
						
						
					}
				}
				
				List<WebElement> radiobutton11  = driver.findElements(By.name("q24_whatType"));
				int radiosize11 = radiobutton11.size();
				
				for(int b=0; b<radiosize11; b++ ) {
					String val = radiobutton11.get(b).getAttribute("value");
					
					if(val.equalsIgnoreCase(ministry)) {
					    radiobutton11.get(b).click();
						
					driver.findElement(By.xpath("//textarea [@id='input_25']")).sendKeys(Approximate);
						
					Thread.sleep(3000);
						
						
						
						
					}
				}
					    
					driver.get("https://form.jotform.com/222641277139457");
					
				}
				
			 workbook.close();
			

	}

}
