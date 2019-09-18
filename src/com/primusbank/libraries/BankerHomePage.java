package com.primusbank.libraries;

import org.openqa.selenium.By;

import com.primusbank.contatns.PrimusbankConstants;

public class BankerHomePage extends PrimusbankConstants {

	public boolean bankerLogout() {
	
		driver.findElement(By.xpath("//*[@src='images/admin_but_03.jpg']")).click();
		
		if (driver.findElement(By.id("login")).isDisplayed()) {
			
			return true;
			
		} 
		else {
			
			return false;

		}
		
	}

}
