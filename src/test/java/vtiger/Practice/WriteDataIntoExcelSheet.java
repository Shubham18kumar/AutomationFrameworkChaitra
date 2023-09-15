package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelSheet {
		public static void main(String[] args) throws EncryptedDocumentException, IOException {
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.createSheet("NewSheet");
			Row rw = sh.createRow(2);
			org.apache.poi.ss.usermodel.Cell cl = rw.createCell(3);
			cl.setCellValue("SELENIUM");
			FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
			wb.write(fos);
			System.out.println("data added succesfully");
			wb.close();
		}
	}
}
