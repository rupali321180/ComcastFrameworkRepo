package com.concast.com.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	
	public String getdatafromExcel(String sheetname , int rownum , int celnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./Testdata/testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetname).getRow(rownum).getCell(celnum).toString();
		return data;
		
	}
	public int getrowcount(String sheetname) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./Testdata/testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount=wb.getSheet(sheetname).getLastRowNum();
		return rowcount;
		
	}
	public int getrowcount(String sheetname , int rownum ,int celnum , String data) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./Testdata/testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetname).getRow(rownum).createCell(celnum);
		
		FileOutputStream fos=new FileOutputStream("./Testdata/testscriptdata.xlsx");
		wb.write(fos);
		wb.close();
		return celnum;
	
}
}

