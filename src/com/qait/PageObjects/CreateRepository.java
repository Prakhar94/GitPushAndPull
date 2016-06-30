package com.qait.PageObjects;

import java.util.UUID;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mysql.jdbc.RandomBalanceStrategy;

public class CreateRepository {
	
	WebDriver driver;
	String uuidname= null;

	public CreateRepository(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy (id="repository_name")
	private WebElement newRepo;
	
	@FindBy (id="repository_auto_init")
	private WebElement readmecheckbox;
	
	@FindBy (css=".btn.btn-primary.first-in-line")
	private WebElement Create;
	
	public String getRepoPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	
	public boolean verifyRepoPageTitle() {
		String expectedTitle = "Create a New Repository";
		return getRepoPageTitle().contains(expectedTitle);
	}
	
	public void CreateAnewRepo() throws InterruptedException {
		
		Thread.sleep(2000);
		enterRepoName("NewRepo");
		Thread.sleep(2000);
		readmeSelect();
		Thread.sleep(2000);
		clickCreate();
//		clickOnSignIn();
		
	}
	
	public void enterRepoName(String name) {
//		UUID uuid = UUID.randomUUID();
//        String randomUUIDString = uuid.toString();
//        uuidname=randomUUIDString.substring(0, 7);
//        System.out.println(name.concat(uuidname));
		
		if(newRepo.isDisplayed())
			newRepo.sendKeys(name);
	}
	
	public void readmeSelect(){
		if(readmecheckbox.isDisplayed())
			readmecheckbox.click();
	}
	
	public void clickCreate(){
		if(Create.isDisplayed())
			Create.click();
		
	}
}
