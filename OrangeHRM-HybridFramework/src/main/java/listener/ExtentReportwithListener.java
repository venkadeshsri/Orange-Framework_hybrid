package listener;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseTest;
import util.ExtentReporter;

public class ExtentReportwithListener extends BaseTest implements ITestListener {

	ExtentReports extentrpt;
	ExtentTest extest;

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println(context.getName() + "Execution Started...");

		extentrpt = ExtentReporter.generate_extent_rpt();

	}

	@Override
	public void onTestStart(ITestResult result) {

		String testname = result.getName();
		//System.out.println(testname + "Started executing ...");
		extest = extentrpt.createTest(testname);
		extest.log(Status.INFO, testname + " Test Started for executing ...");

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		String testname = result.getName();
		extest = extentrpt.createTest(testname);
		extest.log(Status.PASS, testname + " Test is  Passed...	");
		//System.out.println(testname + "Test is  Passed...");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testname = result.getName();
		//System.out.println(testname + " Test is  Failed...");
		System.out.println(result.getThrowable());

		File src_screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String scr_target = (System.getProperty("user.dir") + "\\Screenshots\\" + testname + System.currentTimeMillis()
				+ ".png");
		
		try {
			FileHandler.copy(src_screen, new File(scr_target)); 
		} catch (IOException e) {

			e.printStackTrace();
		} 
		extest.addScreenCaptureFromPath(scr_target);
		extest.log(Status.INFO, result.getThrowable() );
		extest.log(Status.FAIL, testname + " Test is  Failed...");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testname = result.getName();
		/*
		 * System.out.println(testname + "Test is  Skipped, Try again...");
		 * System.out.println(result.getThrowable());
		 */
		extest.log(Status.INFO, result.getThrowable() );
		extest.log(Status.SKIP, testname + " Test is  Skipped...");
	}

	@Override
	public void onFinish(ITestContext context) {

		System.out.println("Test Execution is completed");
		extentrpt.flush();

	}

}
