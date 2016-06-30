package com.qait.PageObjects;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteRepo {
	WebDriver driver;
	String repo_name="NewRepo";
	public DeleteRepo(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css = "a[data-selected-links*='repo_branch_settings hooks']")
	WebElement setting_button;
	
	@FindBy(css = "button[data-facebox*='delete_repo_confirm']")
	WebElement delete_button;
	
	@FindBy(xpath = "(//input[@name='verify'])[3]")
	WebElement confirm_name;
	
	@FindBy(xpath = "(//button[@data-disable-invalid=\"\"])[4]")
	WebElement click_to_confirm;
	
	public void deleteRepo() throws InterruptedException, IOException {
		Thread.sleep(2000);
		setting_button.click();
		Thread.sleep(2000);
		delete_button.click();
		Thread.sleep(4000);
		String todel = repo_name;
		System.out.println(todel);
		confirm_name.sendKeys(todel);
		Thread.sleep(4000);
		click_to_confirm.click();
//		File f=new File("/home/prakharkumartiwari/workspace/GitAutomation/NewRepo");
//		String[]entries = f.list();
//		for(String s: entries){
//		    File currentFile = new File(f.getPath(),s);
//		    currentFile.delete();
//		}
//		f.delete();
		FileUtils.deleteDirectory(new File("/home/prakharkumartiwari/workspace/GitAutomation/NewRepo"));
		System.out.println("bye");
	}





}
