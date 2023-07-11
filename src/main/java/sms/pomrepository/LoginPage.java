package sms.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	//Declaration
	@FindBy(id = "email")
	private WebElement usernameTxt;
	
	@FindBy(id = "password")
	private WebElement passwordTxt;
	
	@FindBy(id = "btnSubmit")
	private WebElement LoginBtnClk;
	
//	@FindBy(xpath="//span[contains(text(),'Dad')]")
//	private WebElement signOutImg;
//	
//	@FindBy(xpath="//a[text()='Sign out']")
//	private WebElement LogoutBtnClk;
	
	//Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	public WebElement getUsername()
	{
		return usernameTxt;
	}

	public WebElement getPassword() 
	{
		return passwordTxt;
	}

	public WebElement getLoginBtnClk() 
	{
		return LoginBtnClk;
	}
	
//	public WebElement getSignOutImg()
//	{
//		return signOutImg;
//	}
//	
//	public WebElement getLogoutBtnClk()
//	{
//		return LogoutBtnClk;
//	}
	
	
	//Business libraries
	public void loginToApp(String username,String password)
	{
		usernameTxt.sendKeys(username);
		passwordTxt.sendKeys(password);
		LoginBtnClk.click();
	}
}
