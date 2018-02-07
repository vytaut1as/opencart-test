package itakademija.lt.Vertutas;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class Task1Test {
	WebDriver driver = new FirefoxDriver();
	PageForTask1 testAcc = new PageForTask1("Vardas", "Adamkus", "@gmail.com", "867598665");
	List<String> details = new ArrayList<String>();

	@Before
	public void openBrowser() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://88.119.151.54/opencartone/");
		// driver.get("https://demo.opencart.com");

	}

	@After
	public void closeBrowser() {
//		driver.close();
	}

	@Test
	public void createNewAccTest() {
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.partialLinkText("Register")).click();
		fillTheForm();
		driver.findElement(By.cssSelector("input.btn")).click();

		assertTrue("create account false", driver
				.findElement(By.cssSelector("html body.account-success div.container div.row div#content.col-sm-9 h1"))
				.getText().contains("Account Has Been Created!"));

		System.out.println("Create acc for: " + testAcc.toString());

		driver.findElement(By.xpath("//a[contains(text(), 'Continue')]")).click();
		driver.findElement(By.xpath("//a[contains(text(), 'Edit')]")).click();

		collectDetails();

		assertEquals(details.get(0), testAcc.getFirstName());
		assertEquals(details.get(1), testAcc.getLastName());
		assertEquals(details.get(2), testAcc.getEmailAdress());
		assertEquals(details.get(3), testAcc.getPhoneNumber());
	}

	private void fillTheForm() {
		driver.findElement(By.id("input-firstname")).sendKeys(testAcc.getFirstName());
		driver.findElement(By.cssSelector("#input-lastname")).sendKeys(testAcc.getLastName());
		driver.findElement(By.name("email")).sendKeys(testAcc.getEmailAdress());
		driver.findElement(By.id("input-telephone")).sendKeys(testAcc.getPhoneNumber());
		driver.findElement(By.id("input-address-1")).sendKeys(testAcc.createRandomString() + " gatve 10");
		driver.findElement(By.id("input-city")).sendKeys("Vilnius");
		driver.findElement(By.id("input-postcode")).sendKeys("LT-31234");

		Select countryField = new Select(driver.findElement(By.id("input-country")));
		countryField.selectByVisibleText("Seychelles");
		countryField.selectByIndex(4);
		countryField.selectByValue("4");
		Select zoneField = new Select(driver.findElement(By.id("input-zone")));
		zoneField.selectByValue("119");
		driver.findElement(By.id("input-password")).sendKeys("1234qwer");
		driver.findElement(By.id("input-confirm")).sendKeys("1234qwer");
		driver.findElement(By.name("agree")).click();
	}

	private void collectDetails() {
		details.add(driver.findElement(By.id("input-firstname")).getAttribute("Value"));
		details.add(driver.findElement(By.id("input-lastname")).getAttribute("Value"));
		details.add(driver.findElement(By.id("input-email")).getAttribute("Value"));
		details.add(driver.findElement(By.id("input-telephone")).getAttribute("Value"));
	}

}
