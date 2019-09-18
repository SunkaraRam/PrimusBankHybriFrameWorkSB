package com.primusbank.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.primusbank.contatns.PrimusbankConstants;
import com.primusbank.libraries.AdminHomePage;
import com.primusbank.libraries.PrimusBankHomePage;

public class classd extends PrimusbankConstants
{
	@Test
	
	
public static void main(String[] args) 
	
	{	
		
		List<WebElement> lnum =  driver.findElements(By.tagName("a"));
		
		System.out.println(lnum.size());
		
	}
	/*
	public static void mahesh() {
		PrimusBankHomePage a=new PrimusBankHomePage();
		a.adminLogin("Admin", "Admin");
		AdminHomePage p=new AdminHomePage();
		p.adminLogout();
	}
	
	*/
	
	/*
	public static void tcrestest(){
		
		
		String tcres = "fail";
		
		if (!tcres.equalsIgnoreCase("fail")) {
			
			System.out.println("TestPass");
			
		}
	
		
	}
	
	*/
	
	
	

	
	
}
