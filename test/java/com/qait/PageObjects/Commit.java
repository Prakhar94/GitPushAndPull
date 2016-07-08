package com.qait.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Commit {
	

	@FindBy(xpath = "(//a[@class='message'])[3]")
	private static WebElement msg;
	private WebDriver driver;
	
	public Commit(WebDriver driver)
	{
		this.driver=driver;
		driver.navigate().refresh();
		PageFactory.initElements(driver, this);
		
	}
	public String commitUI() throws InterruptedException
	{
		Thread.sleep(2000);
		String s=msg.getText();
		System.out.println(s);
		return s;
	}
	public boolean verifyCommit() throws InterruptedException {
		String expectedTitle = "adding a text file";
		return commitUI().contains(expectedTitle);
	}
	


}
