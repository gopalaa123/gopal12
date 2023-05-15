package WriteExcel;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gopal12.XCELUtilityFile;

public class webTableToExcel {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\rayasam.krishna\\eclipse-workspace\\gopal12\\Resourses\\chromedriver.exe");
				

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("https://en.wikipedia.org/wiki/List_of_countries_and_dependencies_by_population");

		String path = "C:\\Users\\rayasam.krishna\\Desktop\\New folder\\Tabledatak.xlsx";
		

		// string path is inputing XcelUtility File which in com.gopal12 package
		XCELUtilityFile xlutil = new XCELUtilityFile(path);
		
		
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;
		int e = 5;
		int f = 6;
		
		String abc = "Tjgfljhawgfajhext";
		System.out.println(abc);

		// this is header this Excel this is print in excel

		WebElement r = driver.findElement(By.xpath("//a[text()='Country']"));
		String text = r.getText();
		xlutil.setCellData("Sheet3", 0, 0, text);
		System.out.println(text);
		
		WebElement s = 	driver.findElement(By.xpath("//table//tr//th[text()='Population']"));
		String text1 = s.getText();
		xlutil.setCellData("Sheet3", 0, 1, text1);
		System.out.println(text1);
		
		WebElement k = driver.findElement(By.xpath("//th[contains(text(),'the world')]"));
		String percentage = k.getText();
		xlutil.setCellData("Sheet3", 0, 2, percentage);
		System.out.println(percentage);
		
		WebElement m = 	driver.findElement(By.xpath("//table//tr//th[text()='Date']"));
		String text2 = m.getText();
		xlutil.setCellData("Sheet3", 0, 3, text2);
		System.out.println(text2);
		
		WebElement n = driver.findElement(By.xpath("//table//tr//span[text()='Source (official or from']"));;
		String text3 = n.getText();
		xlutil.setCellData("Sheet3", 0, 4, text3);
		System.out.println(text3);

		WebElement T = driver.findElement(By.xpath("//table//tr//th[@class='unsortable']"));		
		String text11 = T.getText();
		xlutil.setCellData("Sheet3", 0, 5, text11);
		System.out.println(text11);
		


		
		// it was table of the rows it is print the excel
		
		
		 //WebElement table= driver.findElement(By.xpath("//table[@class='wikitablesortable jquery-tablesorter']/tbody"));
		
		 for(a=2; a<=10; a++) {
			 for(b=1;b<=6;b++) {
				String tablevalue= driver.findElement(By.xpath("//table//tr["+a+"]//td["+b+"]")).getText();
				xlutil.setCellData("Sheet3", a, b-1, tablevalue);
			
		
				System.out.println(tablevalue + " in excel the table value is "+a);
			
				
				
			
			
		 
		
		 // driver.findElement(By.xpath("//table//tr[3]//td[5]"));
//		 int rows= table.findElements(By.xpath("tr")).size(); //row present in web //
//		// * table
//		 
//		for(int r1=1;r1<rows;r1++) { // the read data from the Website of table
//		 String country=table.findElement(By.xpath("tr["+r+"]/td[1]")).getText();
//		  
//		  String population=table.findElement(By.xpath("tr["+r+"]/td[2]")).getText();
//		  
//		  // String
//	    	String  percentage1=table.findElement(By.xpath("tr["+r+"]/td[3]")).getText();
//		  String Date=table.findElement(By.xpath("tr["+r+"]/td[4]")).getText(); 
//		  String source=table.findElement(By.xpath("tr["+r+"]/td[5]")).getText();
//		  String Note=table.findElement(By.xpath("tr["+r+"]/td[6]")).getText();
//		  
//		  System.out.println(country);
//				  
//		  xlutil.setCellData("Sheet3", r1, 0, country); 
//		  xlutil.setCellData("Sheet3", r1, 1, population);
//		  xlutil.setCellData("Sheet3", r1, 2, percentage1);
//		  xlutil.setCellData("Sheet3", r1, 3, Date); 
//		  xlutil.setCellData("Sheet3", r1, 4, source);
//	      xlutil.setCellData("Sheet3", r1, 5, Note);
//		  
//		 }
	
	
}
		 }
	
		System.out.println("web scapping is done succesfully..............");

		driver.close();

	

	}
}