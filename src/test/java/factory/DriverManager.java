package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	public WebDriver intializeDriver() {

		// Firefox driver
		// WebDriverManager.firefoxdriver().setup();
		// WebDriver driver = new FirefoxDriver();

		// for Chrome driver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;

	}

}
