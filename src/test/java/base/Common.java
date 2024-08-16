package base;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.mail.MessagingException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import utils.ConfigLoader;
import utils.MailUtils;

public class Common {

	public WebDriver driver;
	protected WebDriverWait wait;

// Base Url
	protected void load(String endPoint) {

		driver.get(ConfigLoader.getConfigProperty("baseUrl") + endPoint);
	}

	@BeforeMethod
	public void startDriver() {

		this.driver = intializeDriver();

	}

	@AfterMethod
	public void quitDriver(ITestResult result) throws IOException, MessagingException {
		if (result.getStatus() == ITestResult.FAILURE) {
			File desFile = new File(
					"screenshots" + File.separator + result.getTestClass().getRealClass().getSimpleName() + "_"
							+ result.getMethod().getMethodName() + ".png");
			takeScreenshotUsingAShot(desFile);
			String Filepath = desFile.getPath();
			MailUtils.sendMail(result, Filepath);
		}

		driver.close();

	}

	public WebDriver intializeDriver() {

		// Firefox driver
		// WebDriverManager.firefoxdriver().setup();
		// WebDriver driver = new FirefoxDriver();

		// for Chrome driver
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		// chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("--window-size=1366,768");
		WebDriver driver = new ChromeDriver(chromeOptions);
		return driver;

	}

	@SuppressWarnings("unused")
	private void takeScreenshot(File destFile) throws IOException {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, destFile);
	}

	// @SuppressWarnings("unused")
	private void takeScreenshotUsingAShot(File destFile) {
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100))
				.takeScreenshot(driver);
		try {
			ImageIO.write(screenshot.getImage(), "PNG", destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Scroll
	protected void scroll(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);

	}

}
