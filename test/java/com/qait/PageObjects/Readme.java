package com.qait.PageObjects;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.qait.initialize.Initialiser;

public class Readme extends Initialiser{
	
	WebDriver driver;
	public static String everything ;
	JavascriptExecutor js;
	String editText="updated";
	public Readme(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		this.js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy (how= How.LINK_TEXT, using= "README.md")
	private WebElement readme;
	
	@FindBy (css ="button[aria-label='Edit this file']")
	private WebElement buttons;
	
	@FindBy (css=".ace_text-input")
	private WebElement txt;
	
	@FindBy (css="#submit-file")
	private WebElement sbmt;
	
	public void clickReadme(){
		if(readme.isDisplayed())
			readme.click();
	}
	
	public void clickEdit() throws InterruptedException{
		Thread.sleep(1000);
		if(buttons.isDisplayed())
			buttons.click();
	}
	
	public void edit() throws InterruptedException{
		clickReadme();
		clickEdit();
		Thread.sleep(5000);
		
			System.out.println("onsode if");
			System.out.println(txt);
			js.executeScript("document.querySelector('.ace_text-input').click();");
			Thread.sleep(1000);
			txt.clear();
			Thread.sleep(1000);
			txt.sendKeys(editText);
			Thread.sleep(1000);
			sbmt.click();
		
		System.out.println("updated");
	}
	
	public String readmeText() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("/home/prakharkumartiwari/workspace/AutomateGit/NewRepo/README.md"));
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    everything = sb.toString();
		} finally {
		    br.close();
		}
		
		return everything;
		
	}
	
	public boolean verifyReadme() throws IOException {
		return readmeText().contains(editText);
	}
	
	

	
	


}
