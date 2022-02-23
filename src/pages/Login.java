package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends BasicPage{

	public Login(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
	}

	public WebElement getLoginButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'filled')]/a"));
	}
	public WebElement getUsernameInput() {
		return driver.findElement(By.name("username"));
	}
	public WebElement getPasswordInput() {
		return driver.findElement(By.name("password"));
	}
	public WebElement getRememberMeCheckbox() {
		return driver.findElement(By.name("remember_me"));
	}
	public WebElement getSubmitButton() {
		return driver.findElement(By.name("btn_submit"));
	}
	public void login(String username, String password) throws InterruptedException {
		Thread.sleep(1500);
		getLoginButton().click();
		getUsernameInput().clear();
		getPasswordInput().clear();
		getUsernameInput().sendKeys(username);
		getPasswordInput().sendKeys(password);
		getSubmitButton().click();
	
	
	
	
	
	}	
}
