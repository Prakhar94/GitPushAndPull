package com.qait.PageObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CommandCheckin {
	
	public WebDriver driver;
	
	public CommandCheckin(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	
	
	
	public void runCommand() throws IOException{
		 ProcessBuilder pb = new ProcessBuilder("/home/prakharkumartiwari/workspace/AutomateGit/push.sh");
		 Process p = pb.start();
		 BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		 String line = null;
		 while ((line = reader.readLine()) != null)
		 {
		    System.out.println(line);
		}
		System.out.println("hello");
		
	}
	

}
