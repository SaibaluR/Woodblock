package utils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ImageUtils {

	public static int invalidImageCount;

	public static void image(WebDriver driver) {

		List<WebElement> images = driver.findElements(By.xpath("//img"));

		System.out.println("total images in page = " + images.size());
		for (WebElement image : images) {

			String imageSrc = image.getAttribute("src");

			try {
				URL url = new URL(imageSrc);
				URLConnection urlConnection = url.openConnection();
				HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
				httpURLConnection.setConnectTimeout(5000);
				httpURLConnection.connect();

				if (httpURLConnection.getResponseCode() == 200) {

					// System.out.println("Image is present");
					// System.out.println(imageSrc + ">>" + httpURLConnection.getResponseCode() +
					// ">>"
					// + httpURLConnection.getResponseMessage());
					// Send_mail();
				}

				else if (httpURLConnection.getResponseCode() != 403) {

					// String text="image_verify";

					System.err.println(imageSrc + ">>" + httpURLConnection.getResponseCode() + ">>"
							+ httpURLConnection.getResponseMessage());
					invalidImageCount++;
					System.out.println(invalidImageCount + " images are broken");
				}

				httpURLConnection.disconnect();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}

		int invalidcount = 0;
		Assert.assertEquals(invalidImageCount, invalidcount);
		System.out.println(invalidImageCount + " images are broken");

	}
}
