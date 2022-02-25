package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Auth extends BasicPage {

	public Auth(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
	}

	public WebElement getAuthButton() {
		return driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div[2]/div[2]/ul/li/a"));
	}

	public WebElement getMyAccountButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'my-account-dropdown')]//li[1]/a"));
	}

	public WebElement getLogOutButton() {
		return driver.findElement(By.xpath("//*[@class='my-account-dropdown']//li[2]/a"));
	}

	public void logOut() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", getAuthButton());
		js.executeScript("arguments[0].click();", getLogOutButton());

	}
}
