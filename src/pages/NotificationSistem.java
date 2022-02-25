package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NotificationSistem extends BasicPage {

	private WebDriverWait wait;

	public NotificationSistem(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
		// TODO Auto-generated constructor stub
	}

	public WebElement getLoginButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'alert--success')]"));
	}

	public String getNotificationMessage() {
		return driver.findElement(By.xpath(
				"//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')][contains(@style,'display: block')]"))
				.getText();
	}

	public void waitForMessageToDisappear() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.attributeToBe(By.xpath(" //*[contains(@class, 'system_message')]"), "style",
				"display: none;"));
	}
}
