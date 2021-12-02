package com.Freecrm.utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtils {
	

	public static String TestData_Sheet_Path = "C://Users//senth//eclipse-workspace//FrameworkSample//src//main//java//com//Freecrm//TestData//TestData.xlsx";
	
	public static Workbook wb;
	
	public static Sheet sh;
	
	public Object[][] getTestData(String sheetName) throws IOException, InvalidFormatException{

		FileInputStream fis = null;
		
		try {

		fis = new FileInputStream(TestData_Sheet_Path);		
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			
			wb = WorkbookFactory.create(fis); 
		
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}

		 sh= wb.getSheet(sheetName);
		
		int totalNoOfRows = sh.getPhysicalNumberOfRows();
		
		int totalNoOfCols = sh.getRow(0).getPhysicalNumberOfCells();

		Object[][] data = new String[totalNoOfRows - 1][totalNoOfCols];

		for (int i = 1; i < totalNoOfRows; i++) {

			for (int j = 0; j < totalNoOfCols; j++) {
				data[i - 1][j] = sh.getRow(i).getCell(j).getStringCellValue();
			}

		}
		return data; 
		
	}
}
