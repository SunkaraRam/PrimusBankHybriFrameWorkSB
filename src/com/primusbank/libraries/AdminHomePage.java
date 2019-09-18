package com.primusbank.libraries;

import org.openqa.selenium.By;

import com.primusbank.contatns.PrimusbankConstants;

public class AdminHomePage extends PrimusbankConstants{
	

	public boolean adminLogout()  {
		
			driver.findElement(By.xpath("//img[@src='images/admin_but_03.jpg']")).click();
			
			if (driver.findElement(By.id("login")).isDisplayed()) {
				
				return true;
				
			} else {
				
				return false;

			}
			
	}

}
