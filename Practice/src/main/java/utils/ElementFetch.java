package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseTest;

public class ElementFetch {

	public WebElement getWebElement(String indentifierType, String indentifierValue) {

		switch (indentifierType) {
		case "id":
			return BaseTest.driver.findElement(By.id(indentifierValue));
		case "name":
			return BaseTest.driver.findElement(By.name(indentifierValue));
		case "className":
			return BaseTest.driver.findElement(By.className(indentifierValue));
		case "tagName":
			return BaseTest.driver.findElement(By.tagName(indentifierValue));
		case "xpath":
			return BaseTest.driver.findElement(By.xpath(indentifierValue));
		case "CSS":
			return BaseTest.driver.findElement(By.cssSelector(indentifierValue));
		case "linkText":
			return BaseTest.driver.findElement(By.linkText(indentifierValue));
		case "partialLinkText":
			return BaseTest.driver.findElement(By.partialLinkText(indentifierValue));
		default:
			return null;

		}

	}

	public List<WebElement> getWebElements(String indentifierType, String indentifierValue) {
		switch (indentifierType) {
		case "id":
			return BaseTest.driver.findElements(By.id(indentifierValue));
		case "name":
			return BaseTest.driver.findElements(By.name(indentifierValue));
		case "className":
			return BaseTest.driver.findElements(By.className(indentifierValue));
		case "tagName":
			return BaseTest.driver.findElements(By.tagName(indentifierValue));
		case "xpath":
			return BaseTest.driver.findElements(By.xpath(indentifierValue));
		case "CSS":
			return BaseTest.driver.findElements(By.cssSelector(indentifierValue));
		default:
			return null;

		}

	}

}
