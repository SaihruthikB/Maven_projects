package Pratice_one;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data_Write {
	@Test(dataProvider="getData")
	public  void testt(HashMap<String, String> data)throws EncryptedDocumentException, IOException
	{
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("www.biba.in");
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.findElement(By.className("loginlnk")).click();
		
		System.err.println(data.get("Username"));
	
	
	}
	void excelData() throws EncryptedDocumentException, IOException
	{
//		File f1 = new File ("E:\\userdata\\Pratice_Logins");
//		FileInputStream fis = new FileInputStream(f1);
//			Workbook w1=WorkbookFactory.create(fis);
//			Sheet s1=w1.getSheet("Pratice_Logins");
//			Row r1=s1.getRow(1);
//			Cell c1=r1.getCell(1);
	}
	
	@DataProvider
	public static Object[][] getData() throws IOException {

		File f = new File("E:\\userdata\\Pratice_Logins.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook w = null;
		try {
			w = WorkbookFactory.create(fis);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}
		Sheet s = w.getSheet("Logins");
		int rowCount = s.getLastRowNum();
		int colCount = s.getRow(0).getLastCellNum();
		System.out.println("rows>>>>>>>" + rowCount);
		System.out.println("coloumns>>>>" + colCount);
		Object[][] obj = new Object[rowCount][1];

		for (int i = 1; i <= rowCount; i++) {
			Map<String, String> data = new HashMap<String, String>();
			for (int j = 0; j < colCount; j++) {


				DataFormatter df = new DataFormatter();
				String key = df.formatCellValue(s.getRow(0).getCell(j));
				String value = df.formatCellValue(s.getRow(i).getCell(j));
				data.put(key, value);

			}
			obj[i - 1][0] = data;
		}
		return obj;

	}


}
