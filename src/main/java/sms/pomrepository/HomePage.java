package sms.pomrepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePage 
{
		//Declaration
		@FindBy(xpath="//span[text()='Dashboard']")
		private WebElement dashboardpage;
		
		@FindBy(xpath="//span[text()='Profile']")
		private WebElement profiledropdown;
		
		@FindBy(xpath="//ul[@class='treeview-menu menu-open']/li[1]")
		private WebElement My_Profile;
		
		@FindBy(xpath="//ul[@class='treeview-menu menu-open']/li[2]")
		private WebElement My_Son_Profiler;
		
		@FindBy(xpath="//span[text()='Teacher']")
		private WebElement Teacherdropdown;
		
		@FindBy(xpath="//span[text()='Teacher']/../following-sibling::ul/li[1]")
		private WebElement My_Son_Teacher;
		
		@FindBy(xpath="//span[text()='Teacher']/../following-sibling::ul/li[2]")
		private WebElement All_Teacher;
		
		@FindBy(xpath="//span[text()='Subject']")
		private WebElement Subjectdropdown;
		
		@FindBy(xpath="//span[text()='Subject']/../../ul/li[1]")
		private WebElement My_Son_Subject;
		
		@FindBy(xpath="//span[text()='Subject']/../../ul/li[2]")
		private WebElement All_Subject;
		
		@FindBy(xpath="//span[text()='Timetable']")
		private WebElement Timetabledropdown;
		
		@FindBy(xpath="//span[text()='Timetable']/../../ul/li[1]")
		private WebElement My_Son_Timetable;
		
		@FindBy(xpath="//span[text()='Timetable']/../../ul/li[2]")
		private WebElement All_Timetable;
		
		@FindBy(xpath="//span[text()='Attendance']")
		private WebElement Attendancedropdown;
		
		@FindBy(xpath="//span[text()='Attendance']/../../ul/li[1]")
		private WebElement  My_Son_Attendance;
		
		@FindBy(xpath="//span[text()='Attendance']/../../ul/li[2]")
		private WebElement My_Son_Attendance_History;
		
		@FindBy(xpath="//a[@href='my_sons_payments.php']/span")
		private WebElement My_Son_Payments;
		
		@FindBy(xpath="//span[text()='Exam']")
		private WebElement Exam;
		
		@FindBy(xpath="//span[text()='Exam']/../../ul/li[1]")
		private WebElement Son_ExamMarks;
		
		@FindBy(xpath="//span[text()='Exam']/../../ul/li[2]")
		private WebElement Son_ExamMarks_History;
		
		@FindBy(xpath="//span[text()='Exam']/../../ul/li[3]")
		private WebElement Son_ExamTimetable;
		
		@FindBy(xpath="//span[contains(text(),'Dad')]")
		private WebElement signOutImg;
		
		@FindBy(xpath="//a[text()='Sign out']")
		private WebElement LogoutBtnClk;
		
		//Initialization
		public HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		//Utilization
		public WebElement getDashboardpage()
		{
			return dashboardpage;
		}
		public WebElement getProfiledropdown()
		{
			return profiledropdown;
		}
		
		public WebElement getMyProfile()
		{
			return My_Profile;
		}
		
		public WebElement getSonProfile()
		{
			return My_Son_Profiler;
		}
		
		public WebElement getTeacherdropdown()
		{
			return Teacherdropdown;
		}
		
		public WebElement getMySonTeacher()
		{
			return My_Son_Teacher;
		}
		
		public WebElement getAllTeacher()
		{
			return All_Teacher;
		}
		
		public WebElement getSubjectdropdown()
		{
			return Subjectdropdown;
		}
		
		public WebElement getMySonSubject()
		{
			return My_Son_Subject;
		}
		
		public WebElement getAllSubject()
		{
			return All_Subject;
		}
		
		public WebElement getTimetabledropdown()
		{
			return Timetabledropdown;
		}
		
		public WebElement getMySonTimetable()
		{
			return My_Son_Timetable;
		}
		
		public WebElement getAllTimetable()
		{
			return All_Timetable;
		}
		public WebElement getAttendancedropdown()
		{
			return Attendancedropdown;
		}
		
		public WebElement getMySonAttendance()
		{
			return My_Son_Attendance;
		}
		
		public WebElement getMySonAttendanceHistory()
		{
			return My_Son_Attendance_History;
		}
		
		public WebElement getMySonPayments()
		{
			return My_Son_Payments;
		}
		
		public WebElement getExam()
		{
			return Exam;
		}
		
		public WebElement getExamMarks()
		{
			return Son_ExamMarks;
		}
		
		public WebElement getSignOutImg()
		{
			return signOutImg;
		}
	
		public WebElement getLogoutBtnClk()
		{
			return LogoutBtnClk;
		}		
		
		//Business libraries
		public void logoutToApp()
		{
			signOutImg.click();
			LogoutBtnClk.click();
		}
		public void Teacher()
		{
			Teacherdropdown.click();
		}
		public void AllTeacher()
		{
			All_Teacher.click();
		}
		public void Subjects()
		{
			Subjectdropdown.click();
		}
		public void StudentSubject()
		{
			My_Son_Subject.click();
		}
		public void Exam()
		{
			 Exam.click();
		}
		
		public void ExamMarks()
		{
			Son_ExamMarks.click();
		}
		
		public void Attendance()
		{
			Attendancedropdown.click();
		}
		
		public void AttHistory()//Attendance History
		{
			My_Son_Attendance_History.click();
		}
}
