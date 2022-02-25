package tests;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.naming.directory.SearchResult;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import pages.Auth;
import pages.CartSummary;
import pages.LocationPopup;
import pages.Login;
import pages.Meal;
import pages.NotificationSistem;
import pages.Profile;

public abstract class BasicTest {

	protected WebDriver driver;
	protected String baseUrl = "http://demo.yo-meals.com/";
	protected String email = "customer@dummyid.com";
	protected String password = "12345678a";
	protected SoftAssert sa;
	protected TakesScreenshot ts;
	protected JavascriptExecutor js;
	protected WebDriverWait wait;
	protected WebElement upload;
	protected Login loginPage;
	protected LocationPopup popupPage;
	protected NotificationSistem notificationPage;
	protected Profile profilePage;
	protected Auth authPage;
	protected Meal mealPage;
	protected CartSummary cartSummaryPage;
	
	
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		sa = new SoftAssert();
		ts = (TakesScreenshot) driver;
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		loginPage=new Login(driver, wait, js);
		popupPage=new LocationPopup(driver, wait, js);
		notificationPage=new NotificationSistem(driver, wait, js);
		profilePage=new Profile(driver, wait, js);
		authPage=new Auth(driver, wait, js);
		mealPage=new Meal(driver, wait, js);
		cartSummaryPage=new CartSummary(driver, wait, js);
}
	
	
	
	
	
	
	
	
	
}
