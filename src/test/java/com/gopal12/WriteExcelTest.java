package com.gopal12;

import org.testng.annotations.Test;

import WriteExcel.WriteExcelClass;

public class WriteExcelTest {
	
	WriteExcelClass obj = new WriteExcelClass();
	
	@Test
	public void WriteExcelTest() throws Exception {
		
		obj.writeExcel("Sheet3", "Male", 0, 4);		
		
	}
	
	@Test
	
	public void WriteExcelTest1() throws Exception {
		
		
		obj.writeExcel("Sheet3", "Female", 1, 4);	
		
		
	
	}
	
	@Test
	
public void WriteExcelTest2() throws Exception {
		
		obj.writeExcel("Sheet3", "Male", 2, 4);	
	
}
	@Test
public void WriteExcelTest3() throws Exception {
		
		obj.writeExcel("Sheet3", "Female", 3, 4);	

}
	@Test
public void WriteExcelTest4() throws Exception {
		
		obj.writeExcel("Sheet3", "Male", 4, 4);	
	
	
}	
	@Test
public void WriteExcelTest5() throws Exception {
		
		obj.writeExcel("Sheet3", "Female", 5, 4);	

}
	
	
	
	
	
}
