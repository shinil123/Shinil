package student;
//System Test case
import java.io.FileInputStream;


import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import sms.genericutility.BaseClass;
import sms.genericutility.ExcelUtility;
import sms.genericutility.FileUtility;
import sms.genericutility.WebDriverUtility;
import sms.pomrepository.HomePage;
import sms.pomrepository.LoginPage;
@Listeners(sms.genericutility.ListenerImplementation.class)
public class SearchTeacher_SMSTest extends BaseClass
{//(groups={"System"})
	@Test(retryAnalyzer=sms.genericutility.RetryImplementation.class)
	public void searchTeacher() throws Throwable 
	{
		EXCEL_PATH=flib.getDataFromProperties("excel");
		String value=elib.getDataFromExcelBasedTestId(EXCEL_PATH,"Sheet1", "TC_04", "Teacher_Name");
//		String actualtitle="Student Management System";
//		String exptitle="student management system";
		HomePage home=new HomePage(driver);
//		Assert.assertTrue(actualtitle.contains(exptitle));
		home.Teacher();
		home.AllTeacher();
		driver.findElement(By.xpath("//div[@id='example1_filter']/label/input")).sendKeys(value,Keys.ENTER);
		WebElement element = home.getSignOutImg();
		wlib.waitForElement(driver, element);
	    
	}
}
