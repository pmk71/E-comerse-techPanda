package org.techpanda.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {


	public String getPropertyData(String property) throws IOException
	{

		FileInputStream fis= new FileInputStream("./src/main/resources/test.property");
		Properties p= new Properties();
		p.load(fis);
		String data = p.getProperty(property);
		return data;

	}

	public String getExcelData(String sheet,int row,int cell) throws EncryptedDocumentException, IOException
	{

		FileInputStream fis= new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return data;

	}



	public Object[][] toReadMultipleData(String sheetname) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int rowcount=sh.getLastRowNum()+1;
		int cellcount=sh.getRow(0).getLastCellNum();
		Object[][] Obj = new Object[rowcount][cellcount];
		for (int i = 0; i <rowcount; i++) {
			for (int j = 0; j<cellcount; j++) {

				Obj [i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return Obj;
	}


	public int getRandomNumber()
	{
		int num = (int) (Math.random()*100);
		return num;

	}

}