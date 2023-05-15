package WriteExcel;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gopal12.XCELUtilityFile;

public class writetable {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\rayasam.krishna\\eclipse-workspace\\gopal12\\Resourses\\chromedriver.exe");
		

		WebDriver driver = new ChromeDriver();

	

		driver.manage().window().maximize();

		driver.get("https://en.wikipedia.org/wiki/List_of_countries_and_dependencies_by_population");

		String path = "C:\\Users\\rayasam.krishna\\eclipse-workspace\\gopal12\\src\\test\\java\\com\\gopal12\\New Microsoft Excel Worksheet.xlsx";
		

		// string path is inputing XcelUtility File which in com.gopal12 package
		XCELUtilityFile xlutil = new XCELUtilityFile(path);
		
		
		xlutil.setCellData("Sheet1", 0, 0, "Country");
		xlutil.setCellData("Sheet1", 0, 1, "population");
		xlutil.setCellData("Sheet1", 0, 2, "% of world");
		xlutil.setCellData("Sheet1", 0, 0, "source");
		xlutil.setCellData("Sheet1", 0, 0, "Date");
		xlutil.setCellData("Sheet1", 0, 0, "Note");
		
		WebElement table= driver.findElement(By.xpath("//table[@class='wikitablesortable jquery-tablesorter']/tbody"));
		
		int rows= table.findElements(By.xpath("tr")).size(); //row present in web
		
		for(int r=1;r<=rows;r++)
		{
			 
			
			String country=table.findElement(By.xpath("tr["+r+"]/td[1]")).getText();
			  String population=table.findElement(By.xpath("tr["+r+"]/td[2]")).getText();
		      String  percentage=table.findElement(By.xpath("tr["+r+"]/td[3]")).getText();
			  String Date=table.findElement(By.xpath("tr["+r+"]/td[4]")).getText(); 
			  String source=table.findElement(By.xpath("tr["+r+"]/td[5]")).getText();
			  String Note=table.findElement(By.xpath("tr["+r+"]/td[6]")).getText();
			  
			  System.out.println(country+population+percentage+Date+source+Note );
			  
			  xlutil.setCellData("Sheet3", r, 0, country); 
			  xlutil.setCellData("Sheet3", r, 1, population);
			  xlutil.setCellData("Sheet3", r, 2, percentage);
			  xlutil.setCellData("Sheet3", r, 3, Date); 
			  xlutil.setCellData("Sheet3", r, 4, source);
		      xlutil.setCellData("Sheet3", r, 5, Note);
		      
		      System.out.println("web scapping is done succesfully..............");

				driver.close();
			  
			 }
		}
		

	}


