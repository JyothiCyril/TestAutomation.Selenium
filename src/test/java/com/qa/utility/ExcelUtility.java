package com.qa.utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public static FileInputStream fileLoc;
	public static XSSFWorkbook wBook;
	public static XSSFSheet xSheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	
	// 1. method the can get the row count
	public static int getRowCount(String xFile, String xSheetName) throws IOException {
		fileLoc = new FileInputStream(xFile); // open the file in a read mode.
		wBook = new XSSFWorkbook(fileLoc); // open the file as excel file
		xSheet = wBook.getSheet(xSheetName); // open the sheet in the excel file based on sheetname
		int rowCount = xSheet.getLastRowNum(); // count of the rows 
		return rowCount;	
		
	}
	
	// 2. method to get the cell count of each row / row number
	public static int getCellCount(String xFile, String xSheetName, int rowNum) throws IOException {
		fileLoc = new FileInputStream(xFile); 
		wBook = new XSSFWorkbook(fileLoc);
		xSheet = wBook.getSheet(xSheetName);
		row = xSheet.getRow(rowNum);
		int cellCount = row.getLastCellNum(); // return the total of cells in a row
		return cellCount;
		
	}
	//3. method to get the cell data in String format.
	
	public static String getCellData(String xFile, String xSheetName, int rowNum, int cellNum) throws IOException {
		fileLoc = new FileInputStream(xFile); 
		wBook = new XSSFWorkbook(fileLoc);
		xSheet = wBook.getSheet(xSheetName);
		row = xSheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		
		DataFormatter format = new DataFormatter();
		String cellData = format.formatCellValue(cell);
		
		fileLoc.close();
		wBook.close();
		
		return cellData;
		
		
	}
	
	
}
