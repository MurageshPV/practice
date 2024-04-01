package pageEvents;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import pageObject.HomePageElement;
import utils.ElementFetch;

public class HomePageEvents {

	ElementFetch ele = new ElementFetch();

	public void clickOnFreeTrailBtn() {
		ele.getWebElement("xpath", HomePageElement.freeTrailBtn).click();
	}

	public void FreeTrailIsDisplay() {
		String actualText = ele.getWebElement("xpath", HomePageElement.freeTrailBtn).getText();

		// Define the expected text
		String expectedText = "Start Free Trial";

		// Verify that the actual text matches the expected text
		if (actualText.equals(expectedText)) {
			System.out.println("Text is as expected: " + actualText);
		} else {
			System.out.println("Text is not as expected. Actual: " + actualText + ", Expected: " + expectedText);
		}
	}

	public void verifysignUpPageTitle() {
		String aclText = ele.getWebElement("CSS", HomePageElement.singUpPageTitle).getText();
		String expectedText = "Let's get started";

		// Verify that the actual text matches the expected text
		if (aclText.equals(expectedText)) {
			System.out.println("Text is as expected: " + aclText);
		} else {
			System.out.println("Text is not as expected. Actual: " + aclText + ", Expected: " + expectedText);
		}
	}

	public void contactSalesIsdisplay() {
		String actualText = ele.getWebElement("CSS", HomePageElement.contactSaleBtn).getText();

		// Define the expected text
		String expectedText = "Contact sales";

		// Verify that the actual text matches the expected text
		if (actualText.equals(expectedText)) {
			System.out.println("Text is as expected: " + actualText);
		} else {
			System.out.println("Text is not as expected. Actual: " + actualText + ", Expected: " + expectedText);
		}
	}

	public void verifyMenuOption() {
		List<WebElement> menuOption = ele.getWebElements("xpath", HomePageElement.menuOptions);
		// Store text content in a String array
		String[] texts = new String[menuOption.size()];
		for (int i = 0; i < menuOption.size(); i++) {
			texts[i] = menuOption.get(i).getText();
		}
		Assert.assertTrue(Arrays.asList(texts).contains("Solutions"));
		Assert.assertTrue(Arrays.asList(texts).contains("Products"));
		Assert.assertTrue(Arrays.asList(texts).contains("Industries"));
		Assert.assertTrue(Arrays.asList(texts).contains("Resources"));
	}
	
	@SuppressWarnings("deprecation")
	public void verifyLinks() {
		List<WebElement> links = ele.getWebElements("tagName", HomePageElement.links);
		System.out.println("Total number of Links:" + links.size());
		for (WebElement link : links) {
			// Get the href attribute of the link
			String url = link.getAttribute("href");
			// Verify the link URL
			if (url != null && !url.isEmpty()) {
				try {
					HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
					httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
					httpURLConnection.connect();
					if (httpURLConnection.getResponseCode() == 200) {
						System.out.println(url + " - " + httpURLConnection.getResponseMessage());
					} else {
						System.out.println(
								url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link");
					}
				} catch (Exception e) {
					// Handle exceptions
					e.printStackTrace();
				}
			}
		}

	}
}