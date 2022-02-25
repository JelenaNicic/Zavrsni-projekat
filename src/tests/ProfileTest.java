package tests;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import tests.BasicTest;

public class ProfileTest extends BasicTest {
	@Test(priority = 1)
	public void profileTest() throws InterruptedException {
		driver.navigate().to(baseUrl + "guest-user/login-form");
		popupPage.getCloseButton().click();
		loginPage.login(email, password);

		Assert.assertTrue(notificationPage.getNotificationMessage().contains("Login Successfull"), "Error");

		driver.navigate().to(baseUrl + "member/profile");
		profilePage.personalInformationInput("Jelena", "Nicic", "Bk123", "074947399", "01357", "United Kingdom",
				"London", "London");

		Assert.assertTrue(notificationPage.getNotificationMessage().contains("Setup Successful"), "Error");

		authPage.logOut();
		Assert.assertTrue(notificationPage.getNotificationMessage().contains("Logout Successful"), "Error");
	}

	@Test(priority = 2)
	public void changeProfileImageTest() throws IOException, InterruptedException {
		driver.navigate().to(baseUrl + "guest-user/login-form");
		popupPage.getCloseButton().click();
		loginPage.login(email, password);
		Assert.assertTrue(notificationPage.getNotificationMessage().contains("Login Successfull"), "Error");

		driver.navigate().to(baseUrl + "member/profile");
		Thread.sleep(1000);
		profilePage.uploadPhoto("img/download.jpg");
		Thread.sleep(500);
		Assert.assertTrue(notificationPage.getNotificationMessage().contains("Profile Image Uploaded Successfully"),
				"Error");

		profilePage.removePhoto();

		Assert.assertTrue(notificationPage.getNotificationMessage().contains("Profile Image Deleted Successfully"),
				"Error");
		notificationPage.waitForMessageToDisappear();

		authPage.logOut();
	}

}
