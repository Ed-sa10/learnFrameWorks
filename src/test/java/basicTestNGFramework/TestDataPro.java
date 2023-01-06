package basicTestNGFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataPro {
	@Test(dataProvider="getExcelData")
	public void dataDriven(String originCity, String rdestinationCity, int numOfPax) {
		System.out.println(originCity + " "+ rdestinationCity+ " "+ numOfPax );
	}
	
	@DataProvider(name="getExcelData")
	public Object[][] readExcelData() throws IOException{
		
		Object[][] result = new Object[3][3];
		
		File file = new File(".\\src\\test\\resources\\sample.xlsx");
		FileInputStream fis = new FileInputStream(file);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		for(int i=1; i<=sheet.getLastRowNum(); i++) {
			XSSFRow row = sheet.getRow(i); 			
			for(int j=0; j<row.getLastCellNum(); j++) {
				XSSFCell cell = row.getCell(j);				
				if(j==2) {
					int value = (int)cell.getNumericCellValue();
					result [i-1][j] = value;
				}
				else {
					String value = cell.getStringCellValue();
					result [i-1][j] = value;
				}				
			}
		}
		return result;
	}
}
