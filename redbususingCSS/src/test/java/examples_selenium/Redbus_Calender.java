package examples_selenium;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Redbus_Calender {
	
	static WebDriver driver;
	
	public static void main (String[] args)
	{
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = WebDriverManager.chromedriver().create();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
	//	options.addArguments("start-maximized");
		driver.manage().window().maximize();
		driver.get("https://redbus.in");
		
		System.out.println(driver.getTitle());
		
		WebElement month_by_default = driver.findElement(By.cssSelector(".dateText"));
		System.out.println("Displaying month by default :" + month_by_default.getText());
		
		
		WebElement calender = driver.findElement(By.cssSelector("#onwardCal"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("Is Calendar displayed : " + calender.isDisplayed());
		calender.click();
		WebElement cal_month = driver.findElement(By.cssSelector("div[class='DayNavigator__CalendarHeader-qj8jdz-1 fxvMrr'] div:nth-child(2)"));
		System.out.println("Month displaying in the calendar :" + cal_month.getText() );
		WebElement cal_navigate_next = driver.findElement(By.cssSelector("div[class='DayNavigator__CalendarHeader-qj8jdz-1 fxvMrr'] div:nth-child(3)"));
		cal_navigate_next.click();
		System.out.println("Month displaying after navigating in the calendar :" + cal_month.getText() );
		WebElement holidaycount = driver.findElement(By.cssSelector(".holiday_count"));
	//	System.out.println("Holidays -  total count : " + holidaycount.getText());
		
		List <WebElement> weekend = driver.findElements(By.cssSelector("span[class='DayTiles__CalendarDaysSpan-sc-1xum02u-1 bwoYtA']"));
		System.out.print("Weekend days are");
		for (WebElement weekend_days : weekend)
		{
			String weekends = weekend_days.getText();
			
			System.out.print(" " + weekends + "," );
		}
				
	}

}
