package Pratice_one;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class ReadDataSecond {
	
	public class Data_Write {
		@Test(dataProvider="getData")
		public  void testt(HashMap<String, String> data)throws EncryptedDocumentException, IOException
		{
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("www.biba.in");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.className("loginlnk")).click();
				
		
		
		}
		void excelData() throws EncryptedDocumentException, IOException, InvalidFormatException
		{
			File f1 = new File ("E:\\userdata\\Pratice_Logins");
			FileInputStream fis = new FileInputStream(f1);
				Workbook w1=WorkbookFactory.create(fis);
				Sheet s1=w1.getSheet("Pratice_Logins");
			Row r1=s1.getRow(1);
			Cell c1=r1.getCell(1);
		}

}}
