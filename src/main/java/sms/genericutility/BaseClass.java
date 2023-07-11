package sms.genericutility;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import sms.pomrepository.HomePage;
import sms.pomrepository.LoginPage;

public class BaseClass 
{
	public static WebDriver sdriver;
	public WebDriver driver;
	public FileUtility flib=new FileUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	public ExcelUtility elib=new ExcelUtility();
	public DatabaseUtility dlib=new DatabaseUtility();
	public String PROJECT_PATH,EXCEL_PATH,BROWSER,URL;

	@BeforeSuite
	public void connectDB() throws SQLException
	{
		dlib.connectDB();
		System.out.println("dataBase is connected");
	}
	
	@BeforeClass(alwaysRun=true)
	public void launchBrowser() throws Throwable
	{
		PROJECT_PATH=flib.getDataFromProperties("project");
		 BROWSER=flib.getDataFromProperties(PROJECT_PATH,"browser");
		 URL=flib.getDataFromProperties(PROJECT_PATH,"url");
		//String BROWSER=System.getProperty("browser");
		//String URL=System.getProperty("url");
		if(BROWSER.equalsIgnoreCase("chrome")) {		
			  driver = new ChromeDriver();
					}else if(BROWSER.equalsIgnoreCase("firefox")) {
						driver = new FirefoxDriver();
					}else if(BROWSER.equalsIgnoreCase("edge")) {
						driver = new EdgeDriver();
					}else {
					    driver = new ChromeDriver();
					}	
		sdriver=driver;
		wlib.implicitlyWait(driver);
		wlib.maximize(driver);
		driver.get(URL);
		System.out.println("Browser is launched");
	}
	
	@BeforeMethod(alwaysRun=true)
	public void login() throws Throwable
	{
		EXCEL_PATH=flib.getDataFromProperties("excel");
	//	wlib.waitForElement(driver, usernameTxt);
		String USERNAME=flib.getDataFromProperties(PROJECT_PATH,"user3");
		String PASSWORD=flib.getDataFromProperties(PROJECT_PATH,"pass");
		LoginPage Login=new LoginPage(driver);
		Login.loginToApp(USERNAME, PASSWORD);
		wlib.implicitlyWait(driver);
		System.out.println("successfully logged into application");
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void logout()
	{
		HomePage home=new HomePage(driver);
		home.getSignOutImg();
		home.logoutToApp();
	}
	
	@AfterClass(alwaysRun=true)
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("Browser is closed");
	}
	
	@AfterSuite
	public void closeDB() throws SQLException
	{
		dlib.closeDB();
		System.out.println("dataBase is closed");
	}
}
