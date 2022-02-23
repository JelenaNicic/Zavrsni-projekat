package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicPage {
	
	protected WebDriver driver;
    protected JavascriptExecutor js;
	protected WebDriverWait wait;

	public BasicPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js){
		this.driver = driver;
		this.wait = wait;
		this.js = (JavascriptExecutor) driver;
	}

}

