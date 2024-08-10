package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.BaseTest;

public class ExtentReporter {

	public static ExtentReports generate_extent_rpt() 
	{
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter sparkrpt = new ExtentSparkReporter(System.getProperty("user.dir") + "\\Extent reports\\Orange_extentrpt.html");
		sparkrpt.config().setTheme(Theme.DARK);
		sparkrpt.config().setReportName("Orange HRM - Automation using Hybrid POM");
		sparkrpt.config().setDocumentTitle("Orange hrm test by Venkat");
		sparkrpt.config().setTimeStampFormat("dd/MM/yyyy HH:mm:ss");
		
		extent.attachReporter(sparkrpt);
		
		Properties prop1 = new Properties(); 
		File file = new File("D:\\ECLIPSE - Automation\\Automation-Selenium\\FreeCrm\\Config_file\\config");
		
		try {
		FileInputStream fis = new FileInputStream(file);
		prop1.load(fis);
	    } catch (Throwable e) {
			
			e.printStackTrace();
		}
		
		
		extent.setSystemInfo("Test URL : ", prop1.getProperty("url"));
		extent.setSystemInfo("Browser name", prop1.getProperty("browsername"));
		extent.setSystemInfo("Tested User name : ", prop1.getProperty("username"));
		extent.setSystemInfo("OS name : ", System.getProperty("os.name"));
		extent.setSystemInfo("User Name : ", System.getProperty("user.name"));
		extent.setSystemInfo("Java Version : ", System.getProperty("java.version"));
		
		return extent;
	}
}
