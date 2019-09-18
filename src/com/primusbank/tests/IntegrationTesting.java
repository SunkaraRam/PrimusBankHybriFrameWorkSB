package com.primusbank.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.primusbank.contatns.PrimusbankConstants;

public class IntegrationTesting extends PrimusbankConstants{


	public static void main(String[] args) {
		
		
System.setProperty("webdriver.chrome.driver", "d://chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();//*[@src='images/mainlinks_03.jpg']

		driver.manage().window().maximize();
		
		driver.get("http://primusbank.qedgetech.com");
	/*	
		driver.findElement(By.xpath("//*[@src='images/mainlinks_03.jpg']")).click();;
		
		String exp,act;
		
		exp = "personal_banking";
		
		act = driver.getCurrentUrl();
		
		if (act.toLowerCase().contains(exp.toLowerCase())) {
			
			System.out.println("pass");
		}
		else {
			
			System.out.println("fail");
		
	}
	
	*/
		
	List<WebElement> links= driver.findElements(By.tagName("a"));	
	
	int lsize = links.size();
	
	System.out.println(lsize);
	
	String exp,act;

	for (int i = 0; i < lsize; i++) {
		
		String name =  links.get(i).getText();
		
		exp = "Privacy";
		
		boolean ram=true;
		
		if (name.toLowerCase().equalsIgnoreCase(exp)) {
			
			System.out.println("Pass");
			ram=false;
			
		}
		
		else {
			System.out.println("Fail");
		}

		
	}
	
	}
	

}
