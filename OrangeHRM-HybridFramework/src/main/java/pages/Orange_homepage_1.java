package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class Orange_homepage_1 extends BaseTest {
	
	@FindBy(xpath = "//img[@alt='company-branding']") WebElement logo;
	@FindBy(xpath="//button[@type='submit']") WebElement loginbtn;
	@FindBys({@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")}) List<WebElement> errmsg; 
    @FindBy(xpath="//input[contains(@placeholder,'Username')]") WebElement usrname;
    @FindBy(xpath="//input[@placeholder='Password']") WebElement pwd;
    @FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']") WebElement pwd_err_msg;
    @FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']") WebElement usrname_err_msg;
    
    
    
	public Orange_homepage_1()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean logo_test()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(logo));
		Boolean logodisp = logo.isDisplayed();
		System.out.println("Is logo displaying : " + logodisp);
		return logodisp;
	}
	
	public String login_errcheck1()
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(loginbtn));
		 
		System.out.println("Is Button Displaying : " + loginbtn.isDisplayed());
	    System.out.println("Is Button Enabled : " + loginbtn.isEnabled());
		//System.out.println(loginbtn.isSelected());
		loginbtn.click();
		boolean errmsg_usrname = errmsg.get(0).isDisplayed();
		boolean errmsg_pwd = errmsg.get(1).isDisplayed();
		
		String result = "true";
		String result1 = "false";
					
		if (errmsg_usrname==errmsg_pwd)
		{
			return result;
		}else
		{
			return result1;
		}
		
	}
	
	public boolean login_errcheck2() 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(usrname));
		
		//String username = prop.getProperty("username");
		usrname.click();
		System.out.println("Username textbox is enabled : " + usrname.isEnabled());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
		
	 //   usrname.sendKeys(username);	
		usrname.sendKeys("Admin");
	    System.out.println(usrname.getText());
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    loginbtn.click();
	    boolean result = pwd_err_msg.isDisplayed();
	    if (result = true)
	    {
	    	return result;
	    }
	    else {
	    	boolean result1 = false;
	    	return result1;
	    }
		
	}
	
	public boolean login_errcheck3() 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(pwd));
		
		String pwd1 = prop.getProperty("password");
	//	pwd.click();
		System.out.println("Password textbox is enabled : " + pwd.isEnabled());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
		
	    pwd.sendKeys("password");	
	//	pwd.sendKeys("Admin");
		log.info("Entered Password is : " + pwd.getText());
	    System.out.println(pwd.getText());
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    loginbtn.click();
	    boolean result = usrname_err_msg.isDisplayed();
	    if (result = true)
	    {
	    	return result;
	    }
	    else {
	    	boolean result1 = false;
	    	return result1;
	    }
		
	}
}
