package com.qa.utility;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtility {
	public static FileInputStream Fileloc;
	public static XSSFWorkbook Wbook;
	public static XSSFSheet Wsheet;
	public static XSSFRow Row;
	public static XSSFCell cell;
	public static int  GetRowCount(String xfile,String xsheet) throws Exception 
	{
		Fileloc =new FileInputStream(xfile);
		Wbook=new XSSFWorkbook(Fileloc);
		Wsheet=Wbook.getSheet(xsheet);
		int RowCount =Wsheet.getLastRowNum();
		Wbook.close();
		Fileloc.close();
	return RowCount;
		
		
	}
	
	public static int  GetCellCount(String xfile,String xsheet,int rownum) throws Exception 
	{
		Fileloc =new FileInputStream(xfile);
		Wbook=new XSSFWorkbook(Fileloc);
		Wsheet=Wbook.getSheet(xsheet);
		Row =Wsheet.getRow(rownum);
		int CellCount=Row.getLastCellNum();
		Wbook.close();
		Fileloc.close();
		return CellCount;
		
		
	}
	public static String  GetCallData(String xfile,String xsheet,int rownum,int column) throws Exception 
	{
		Fileloc =new FileInputStream(xfile);
		Wbook=new XSSFWorkbook(Fileloc);
		Wsheet=Wbook.getSheet(xsheet);
		Row =Wsheet.getRow(rownum);
		cell=Row.getCell(column);
		DataFormatter formater=new DataFormatter();
		String celldata =formater.formatCellValue(cell);
		Wbook.close();
		Fileloc.close();
	return celldata;
		
	}
	}



