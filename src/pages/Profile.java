package pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Profile extends BasicPage {

	public Profile(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
	}

	public WebElement getUploadPhotoButton() {
		return driver.findElement(By.xpath("//*[@id='profileInfo']/div/div[1]/div/a[1]/i"));
	}
	public WebElement getRemovePhotoButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'remove')]"));
	}
	public WebElement getAuthButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'after-arrow user-trigger-js user-trigger-active')]"));
	}
	public WebElement getMyAccountButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'my-account-dropdown')]//li[1]/a"));
	}
	public WebElement getProfileButton() {
		return driver.findElement(By.xpath("//*[@id = 'fixed__panel']//li[2]/a"));
	}
	public WebElement getFirstNameInput() {
		return driver.findElement(By.name("user_first_name"));
	}
	public void scrollIntoViewFirstName() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView;", getFirstNameInput());
	}
	public WebElement getLastNameInput() {
		return driver.findElement(By.name("user_last_name"));
	}
	public WebElement getAdressInput() {
		return driver.findElement(By.name("user_address"));
	}
	public WebElement getPhoneNumberInput() {
		return driver.findElement(By.name("user_phone"));
	}
	public WebElement getZipCodeInput() {
		return driver.findElement(By.name("user_zip"));
	}
	public void selectCountry(String country) {
		Select dropdownCountry = new Select(driver.findElement(By.id("user_country_id")));
		dropdownCountry.selectByVisibleText(country);
	}
	public void selectState(String state) {
		Select dropdownState = new Select(driver.findElement(By.id("user_state_id")));
		dropdownState.selectByVisibleText(state);
	}
	public void selectCity(String city) {
		Select dropdownCity = new Select(driver.findElement(By.id("user_city")));
		dropdownCity.selectByVisibleText(city);
	}
	public WebElement getPersonalInformationSaveButton() {
		return driver.findElement(
				By.xpath("//*[contains(@class, 'col-lg-12 col-md-12 col-sm-12 col-lg-12 align--right')]//input"));
	}

	public void goToProfilePage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", getMyAccountButton());
		getProfileButton().click();
	}

	public void uploadPhoto(String pathToThePicture) throws InterruptedException, IOException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", getUploadPhotoButton());
		WebElement profilePhotoUpload = driver.findElement(By.xpath("//input[@type='file']"));

		File profilePhoto = new File(pathToThePicture);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(profilePhoto.getCanonicalPath());
		Thread.sleep(3000);
	}

	public void removePhoto() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", getRemovePhotoButton());
	}

	public void personalInformationInput(String firstName, String lastName, String adress, String phoneNumber,
			String zipCode, String country, String state, String city) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		scrollIntoViewFirstName();
		getFirstNameInput().clear();
		getLastNameInput().clear();
		getAdressInput().clear();
		getPhoneNumberInput().clear();
		getZipCodeInput().clear();
		getFirstNameInput().sendKeys(firstName);
		getLastNameInput().sendKeys(lastName);
		getAdressInput().sendKeys(adress);
		getPhoneNumberInput().sendKeys(phoneNumber);
		getZipCodeInput().sendKeys(zipCode);
		Thread.sleep(800);
		selectCountry(country);
		Thread.sleep(800);

		selectState(state);
		Thread.sleep(800);

		selectCity(city);
		js.executeScript("arguments[0].click();", getPersonalInformationSaveButton());
	
	
	}	
	
}
