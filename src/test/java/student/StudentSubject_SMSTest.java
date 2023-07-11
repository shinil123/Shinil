package student;
//System test case
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import sms.genericutility.BaseClass;
import sms.genericutility.FileUtility;
import sms.genericutility.WebDriverUtility;
import sms.pomrepository.HomePage;
import sms.pomrepository.LoginPage;
@Listeners(sms.genericutility.ListenerImplementation.class)
public class StudentSubject_SMSTest extends BaseClass
{//(groups={"System"})
	@Test(retryAnalyzer=sms.genericutility.RetryImplementation.class,alwaysRun = true)
	public void Subject() throws Throwable  
	{
	
		HomePage home=new HomePage(driver);
		home.Subjects();
		home.StudentSubject();
		WebElement element = home.getSignOutImg();
		wlib.waitForElement(driver, element);
	}
}
