package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MealItemTest extends BasicTest {

	@Test(priority = 1)
	public void addMealToCartTest() throws InterruptedException {
		driver.navigate().to(baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");
		popupPage.getCloseButton().click();
		Thread.sleep(500);

		mealPage.addProductToTheCart("2");
		Thread.sleep(1500);
		Assert.assertTrue(notificationPage.getNotificationMessage().contains("The Following Errors Occurred:"),
				"Error");
		Assert.assertTrue(notificationPage.getNotificationMessage().contains("Please Select Location"), "Error");

		notificationPage.waitForMessageToDisappear();

		popupPage.getLocationButton().click();
		popupPage.chooseLocation("City Center - Albany");

		Thread.sleep(2000);
		mealPage.addProductToTheCart("2");

		Assert.assertTrue(notificationPage.getNotificationMessage().contains("Meal Added To Cart"), "Error");
	}

	@Test(priority = 2)
	public void addMealToFavourite() throws InterruptedException {
		driver.navigate().to(baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");
		popupPage.getCloseButton().click();
		mealPage.addToFavourite();
		Thread.sleep(1000);
		Assert.assertTrue(notificationPage.getNotificationMessage().contains("Please login first!"), "Error");
		driver.navigate().to(baseUrl + "guest-user/login-form");
		loginPage.getUsernameInput().clear();
		loginPage.getPasswordInput().clear();
		loginPage.login(email, password);
		driver.navigate().to(baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");
		mealPage.addToFavourite();
		Thread.sleep(1000);
		Assert.assertTrue(
				notificationPage.getNotificationMessage().contains("Product has been added to your favorites."),
				"Error");
	}

	@Test(priority = 3)
	public void clearCartTest() throws InterruptedException, IOException {
		driver.navigate().to(baseUrl + "meals");
		popupPage.chooseLocation("Butte Street Junction - Los Angeles");
		File file = new File("data/Data.xlsx");
		System.out.println(file.getAbsolutePath());
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Meals");
		for (int i = 1; i < 6; i++) {
			driver.navigate().to(sheet.getRow(i).getCell(0).getStringCellValue());
			mealPage.addProductToTheCart("2");
			sa.assertTrue(notificationPage.getNotificationMessage().contains("Meal Added To Cart"), "Error");
		}
		sa.assertAll();
		Thread.sleep(500);
		cartSummaryPage.clearAll();
		Assert.assertTrue(
				notificationPage.getNotificationMessage().contains("All meals removed from Cart successfully"),
				"Error");
	}

}
