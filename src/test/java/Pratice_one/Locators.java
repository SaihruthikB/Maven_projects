package Pratice_one;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {
	static Cell user;

	@org.testng.annotations.Test
	public static void Test()
			throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.biba.in");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[@class='main_navbtn_l']/following-sibling::span[text()='Mix & Match']"))
				.click();

		Select a = new Select(driver.findElement(By.id("drpSort")));
		a.selectByVisibleText("Price high to low");
		Thread.sleep(5000);
		driver.findElement(By.id("Rs_CU00310982-006-10")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("Rs_CU00310982-CU0031098-3")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='bucket_left']/a/img[1]")).click();
		driver.findElement(By.id("236990")).click();
		driver.findElement(By.id("lnkAddToWhishLstPrdDetails")).click();
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_ctl00_ctl01_Login1_UserName")).sendKeys("hruthik.bolly@capillarytech.com");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_ctl00_ctl01_Login1_Password")).sendKeys("1234567");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_ctl00_ctl01_Login1_LoginImageButton")).click();
		driver.findElement(By.id("236990")).click();
		driver.findElement(By.xpath("//input[@value='Add to Cart']")).click();
		driver.findElement(By.xpath("//a[contains(@class,'btn_checkout')]")).click();
		// driver.findElement(By.xpath("//a[contains(@class,
		// 'btn_qtyincrease')]")).click();
		driver.findElement(By.id("btnSinglePagecheckout")).click();

		driver.findElement(By.id("Step2continue")).click();
		driver.switchTo().frame("CCiframe");
		driver.findElement(By.xpath("//input[@id='txt_ccnum']")).sendKeys(Test2(1,"Hrithik"));
		driver.findElement(By.xpath("//input[@id='txt_expdate']")).sendKeys(Test2(2,""));
		driver.findElement(By.xpath("//input[@id='cvv']")).sendKeys(Test2(3,""));
		driver.findElement(By.xpath("//input[@id='txt_ccname']")).sendKeys(Test2(4,""));
		driver.switchTo().defaultContent();
		String n=driver.findElement(By.xpath("(//div[@id='1555573'])[2]")).getText();
		System.out.println(n);
		driver.findElement(By.xpath("//img[@class='logo']")).click();
		WebElement s1=driver.findElement(By.xpath("//label[@id='lblusrn']"));
		Actions a3 = new Actions(driver);
		a3.moveToElement(s1).build().perform();
		driver.findElement(By.xpath("(//a[text()='My Account'])[1]")).click();
		driver.quit();
		Reporter.log("****driver closed****", true);
		
		//driver.findElement(By.id("btnpay")).click();
		
		}

	public static String Test2(int i,String sheetName) throws EncryptedDocumentException, InvalidFormatException, IOException {
		DataFormatter d1 = new DataFormatter();
		
		File f1 = new File("E:\\userdata\\Biba.xlsx");
		FileInputStream fis = new FileInputStream(f1);
		Workbook w1 = WorkbookFactory.create(fis);
		Cell s=w1.getSheet(sheetName).getRow(1).getCell(i);
		return d1.formatCellValue(s);
			

	}
}
