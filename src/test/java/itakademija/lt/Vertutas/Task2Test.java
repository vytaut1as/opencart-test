package itakademija.lt.Vertutas;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.impl.io.SocketOutputBuffer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//@RunWith(Parameterized.class)
public class Task2Test {
	WebDriver driver;
	int count= 0;
	String item;
	static String testFileName = "src/test/resources/TestData.txt";

//	@Parameters
	public static List<String> testData() throws IOException {
		return new FileDataReader(testFileName).getTestData();
	}

	@Before
	public void openBrowser() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://88.119.151.54/opencartone/");
	}

	@After
	public void closeBrowser() {
		// driver.close();
	}

	@Test
	public void dataFileTest() throws IOException {
		System.out.println("asdf2");
		List<String> testDataList = testData();
		driver.findElement(By.name("search")).sendKeys(testDataList.get(count));
		count++;
	}

}
