package sms.genericutility;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class WebDriverUtility 
{
	public void implicitlyWait(WebDriver driver)  
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void waitForElement(WebDriver driver , WebElement element) throws Throwable 
	{	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void getSelectByIndex(WebElement ele,int n)
	{
		Select s=new Select(ele);
		s.selectByIndex(n);
	}
	
	public void getSelectByVisibleText(WebElement ele,String value)
	{
		Select s=new Select(ele);
		s.selectByVisibleText(value);
	}
	
	public void getSelectByValue(WebElement ele, String value)
	{
		Select s=new Select(ele);
		s.selectByValue(value);
	}
	
	public void swithToWindow(WebDriver driver , String partialWindowTitle) 
	{
	       Set<String> set = driver.getWindowHandles();
	       Iterator<String> it = set.iterator();
	       while (it.hasNext()) 
	       {
			      String wID = it.next();
			      driver.switchTo().window(wID);
			      String currentWindowTitle = driver.getTitle();
			      if(currentWindowTitle.contains(partialWindowTitle)) 
			      {
			        	  System.out.println(partialWindowTitle + "Switch to Window is passed--!");
			        	  break;
			      }
		    }
	}
}