package student;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import sms.genericutility.BaseClass;
import sms.pomrepository.HomePage;
@Listeners(sms.genericutility.ListenerImplementation.class)
public class StudentExamMarks_SMSTest extends BaseClass//Marks Graphical Representation
{//(groups={"Integration"})
	@Test
	public void ExamMarksGraph() throws Throwable 
	{
		EXCEL_PATH=flib.getDataFromProperties("excel");
		HomePage home=new HomePage(driver);
		home.Exam();
		home.ExamMarks();
		WebElement exam=driver.findElement(By.id("exam"));
	//	Thread.sleep(2000);
//		ExcelUtility elib=new ExcelUtility();
		wlib.getSelectByVisibleText(exam,elib.getDataFromExcelBasedTestId(EXCEL_PATH,"Sheet3", "TC_12", "Exam_Names"));
		driver.findElement(By.id("btnSubmit")).click();
		driver.findElement(By.xpath("//input[@value='Pie Chart']")).click();
		WebElement element = home.getSignOutImg();
		wlib.waitForElement(driver, element);
	}
}
