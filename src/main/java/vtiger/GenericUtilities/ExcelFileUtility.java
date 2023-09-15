package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {

	
		/**
		 * This method will read data into ExcelSheet
		 * @param SheetName
		 * @param rowNum
		 * @param celNo
		 * @return
		 * @throws Throwable
		 */
		
		public String readDataFromExcel(String SheetName, int rowNum, int celNo) throws Throwable
		{
			FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
			Workbook wb= WorkbookFactory.create(fis);
			String data=wb.getSheet(SheetName).getRow(rowNum).getCell(celNo).getStringCellValue();
//			wb.close();
			return data;		
		}
			/**
			 * This method will write data into ExcelSheet
			 * @param Sheet
			 * @param rowNum
			 * @param i 
			 * @param value
			 * @throws Throwable
			 */
		public void WriteDataIntoExcel(String Sheet, int rowNum, int i, String value) throws Throwable 
		{
			FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
			Workbook wb= WorkbookFactory.create(fis);
			wb.createSheet().createRow(rowNum).createCell(rowNum).getStringCellValue();
			
			FileOutputStream fos= new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
			wb.write(fos);
			wb.close();
		}

	}



