package sms.genericutility;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class FileUtility 
{
	public String getDataFromProperties(String key) throws IOException 
	{
		FileInputStream fis=new FileInputStream("./config/file_path.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(key);
		return value;
	}
	public String getDataFromProperties(String filePath, String key) throws Throwable 
	{
		FileInputStream fis = new FileInputStream(filePath);
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
	}
}
