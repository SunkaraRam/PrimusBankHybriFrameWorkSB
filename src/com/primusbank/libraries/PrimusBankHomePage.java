package com.primusbank.libraries;





import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.primusbank.contatns.PrimusbankConstants;


public class PrimusBankHomePage extends PrimusbankConstants {

	public String adminuid, adminpwd;
	
	public String bankerbrch,bankeruid,bankerpwd;
	
	public  boolean adminLogin(String uid,String pwd) {
		
		String expurl,acturl;
	
		expurl = "adminflow" ;
		
		driver.findElement(By.id("txtuId")).sendKeys(uid);
		
		driver.findElement(By.id("txtPword")).sendKeys(pwd);
		
		driver.findElement(By.id("login")).click();
		
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, 5);
			
			wait.until(ExpectedConditions.alertIsPresent());
			
			driver.switchTo().alert().accept();
			
			driver.findElement(By.id("txtuId")).clear();
			
		} catch (Exception e) {
			
			
			
		}
		 
		acturl = driver.getCurrentUrl();
		
		
		if (acturl.toLowerCase().contains(expurl.toLowerCase())) {
			
			return true;
			
		
			
		} else {

			return false;
			
		}
		
	}
	
	public boolean bankerLogin(String brch, String uid, String pwd) 
	
		{
			
			String expval,actval;
			
			expval = "Bankers_flow";
			
			Select dlist = new Select(driver.findElement(By.id("drlist")));
			
			dlist.selectByVisibleText(brch);
			
			driver.findElement(By.id("txtuId")).sendKeys(uid);;
			
			driver.findElement(By.id("txtPword")).sendKeys(pwd);
			
			driver.findElement(By.id("login")).click();
			
			try 
				{

					WebDriverWait wt =  new WebDriverWait(driver, 5);
					wt.until(ExpectedConditions.alertIsPresent());
					driver.switchTo().alert().accept();
					driver.findElement(By.id("txtuId")).clear();
				} 
			catch (Exception e) 
				{
				
				}
			
			actval = driver.getCurrentUrl();
			
			if (actval.toLowerCase().contains(expval.toLowerCase())) 
				{
	
					return true;
				
				} 
			else 
				{
				
					return false;
	
				}
			
				
		}
	
	public boolean PersonalLink() {
		
		driver.findElement(By.xpath("//*[@src='images/mainlinks_03.jpg']")).click();;
		
		String exp,act;
		
		exp = "personal_banking";
		
		act = driver.getCurrentUrl();
		
		if (act.toLowerCase().contains(exp.toLowerCase())) {
			
			return true;
			
		}
		else {
			return false;
		}
		
		
	}
	
	public boolean internationaL() {
		
		String act,exp;
		
		exp="International";
		
		driver.findElement(By.xpath("//*[@src='images/mainlinks_05.jpg']")).click();
		
		act = driver.getCurrentUrl();
		
		if (act.toLowerCase().contains(exp.toLowerCase())) {
			
			return true;
			
		} else {
			
			return false;

		}
		
		
	}
	
	
}


