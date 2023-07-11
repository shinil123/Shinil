package sms.genericutility;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class ExcelUtility 
{
	// read data from excelsheet using row no. and column no.
	public String getDataFromExcelSheet(String file_path,String sheetname, int rownum, int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(file_path);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheetname);
		DataFormatter format=new DataFormatter();
		String value=format.formatCellValue(sh.getRow(rownum).getCell(cellnum));
		return value;
	}
	// write the data into excelsheet using row no. and column no.
	public void setDataIntoExcelSheet(String file_path,String sheetname, int rownum, int cellnum,String data) throws IOException
	{
		FileInputStream fis=new FileInputStream(file_path);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheetname);
		FileOutputStream fos=new FileOutputStream(file_path);
		sh.createRow(rownum).createCell(cellnum).setCellValue(data);
		book.write(fos);
		fos.flush();
	}
	// get last row number
	public int getLastRowCount(String file_path,String sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(file_path);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheetname);
		int lastrow=sh.getLastRowNum();
		return lastrow;
	}	
	public String getDataFromExcelBasedTestId(String file_path,String sheetName , String testId, String columnHeader ) throws Throwable, IOException
    {
		FileInputStream fis1 = new FileInputStream(file_path);
		Workbook wb =  WorkbookFactory.create(fis1);
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		int testRowNum = 0;
		String actTestID="";
		String actColHeaderName="";
		String data="";
		
		for(int i=0; i<=rowCount; i++) {
			try { actTestID = sheet.getRow(i).getCell(0).toString();} catch (Exception e) {}

			if(actTestID.equalsIgnoreCase(testId)) {
				break;				
			}
			testRowNum++;
		}
		int testColNum =0;
		int celCountforTest = sheet.getRow(testRowNum-1).getLastCellNum();
		for(int j=0; j<celCountforTest; j++) {
			try {actColHeaderName =  sheet.getRow(testRowNum-1).getCell(j).toString(); } catch (Exception e) {}
			if(actColHeaderName.equalsIgnoreCase(columnHeader)) {
				break;
			}
			testColNum++;
		}
		try {data =  sheet.getRow(testRowNum).getCell(testColNum).toString();}catch (Exception e) {}
		return data;
	}
}
