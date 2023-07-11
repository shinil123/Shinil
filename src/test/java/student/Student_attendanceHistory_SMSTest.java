package student;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import sms.genericutility.BaseClass;
import sms.pomrepository.HomePage;
@Listeners(sms.genericutility.ListenerImplementation.class)
public class Student_attendanceHistory_SMSTest extends BaseClass
{//(groups={"System"})
		@Test(retryAnalyzer=sms.genericutility.RetryImplementation.class)
		public void AttHistoryTest() throws Throwable 
		{
			EXCEL_PATH=flib.getDataFromProperties("excel");
			HomePage home=new HomePage(driver);
			home.Attendance();
			home.AttHistory();
			WebElement year=driver.findElement(By.id("year"));
			wlib.getSelectByIndex(year, 0);
			WebElement month=driver.findElement(By.id("month"));
			wlib.getSelectByVisibleText(month, elib.getDataFromExcelBasedTestId(EXCEL_PATH, "Sheet2","TC_07","Exam_Month"));
			driver.findElement(By.xpath("//button[text()='Submit']")).click();
			WebElement element = home.getSignOutImg();
			wlib.waitForElement(driver, element);
		}
}
