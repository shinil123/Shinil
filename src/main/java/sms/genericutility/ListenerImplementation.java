package sms.genericutility;

import java.io.File;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener
{
	public void onTestSuccess(ITestResult result)
	{
		String methodName=result.getMethod().getMethodName();
		TakesScreenshot takesScreenshot=(TakesScreenshot)BaseClass.sdriver;
		File src=takesScreenshot.getScreenshotAs(OutputType.FILE);
		LocalDateTime dt=LocalDateTime.now();
		String dateTime=dt.toString().replace(" ","_").replace(":", "_");
		File dst=new File("./screenshot/"+methodName+"_"+dateTime+".png");
		try
		{
			FileUtils.copyFile(src, dst);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
