package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static final Logger log = LogManager.getLogger(BaseTest.class);
	public static Properties prop;
	


	public void base_init() throws IOException
	{
		ChromeOptions options = new ChromeOptions();
		driver = WebDriverManager.chromedriver().create();
		prop = new Properties(); 
		//File file = new File(System.getProperty("user.dir" + "\\FreeCrm\\Config_file\\config"));
		File file = new File("D:\\ECLIPSE - Automation\\Automation-Selenium\\FreeCrm\\Config_file\\config");
		
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);
		String browser = prop.getProperty("browsername");
		String url = prop.getProperty("url");
		
		switch (browser.toLowerCase())
		{
		case "chrome": driver = new ChromeDriver(options); break;
		case "firefox": driver = new FirefoxDriver(); break;
		case "edge": driver = new EdgeDriver(); break;
		default: System.out.println("Invalid browser"); return;
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		
		
	}

}
