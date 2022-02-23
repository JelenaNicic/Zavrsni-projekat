package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocationPopup extends BasicPage{

		public LocationPopup(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
			super(driver,wait,js);
		}

		public WebElement getLocationButton() {
			return driver.findElement(By.xpath("//*[contains(@class, 'location-selector')]/a"));
		}
		
		public WebElement getKeyword() {
			return driver.findElement(By.id("locality_keyword"));
		}
		
		public WebElement getLocationItem(String locationName) {
			return driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));
		}
		
		public WebElement getLocationInput() {
			return driver.findElement(By.id("location_id"));
		}
		
		public WebElement getSubmit() {
			return driver.findElement(By.name("btn_submit"));
		}
		
		public WebElement getCloseButton() {
			return driver.findElement(By.xpath("//*[contains(@class, 'close-btn close-btn-white')]"));
		}
		
		public void clickLocationPopUp() {
			getLocationButton().click();
		}

		public void chooseLocation(String locationName) throws InterruptedException {
			getKeyword().click();
			String value = getLocationItem(locationName).getAttribute("data-value");
			js.executeScript("arguments[0].value=arguments[1];", getLocationInput(), value);
			js.executeScript("arguments[0].click();", getSubmit());

}}
