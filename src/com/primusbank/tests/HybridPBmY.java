package com.primusbank.tests;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.primusbank.contatns.PrimusbankConstants;
import com.primusbank.libraries.AdminHomePage;
import com.primusbank.libraries.BankerHomePage;
import com.primusbank.libraries.PrimusBankHomePage;
import XLApachePOI.XLUnits;

public class HybridPBmY extends PrimusbankConstants{

	int tcnum,tsnum,ttnum;

	String keywordfile= "D:\\PrimusBankHybridFrameWork\\src\\com\\primusbank\\testHybridData\\TestDataHybrid1.xlsx";
			
	String tCsheet="TestCases";
	
	String tSsheet = "TestScenario";
		
	PrimusBankHomePage phome = new PrimusBankHomePage();
	
	BankerHomePage bhome = new BankerHomePage();
	
	AdminHomePage ahome= new AdminHomePage();
	
	@Test
	public void primusbatchTest() throws IOException {
		
		tsnum = XLUnits.getRowCount(keywordfile, tSsheet);
		
		for (int i = 1; i <= tsnum; i++) {
		
			String tsyn = XLUnits.getCellData(keywordfile, tSsheet, i, 2);
			
			if (tSsheet.equalsIgnoreCase("y")) {
				
				String tcid = XLUnits.getCellData(keywordfile, tSsheet, i, 0);
				
				tcnum = XLUnits.getRowCount(keywordfile, tCsheet);
				
				boolean res=false;
				
				for (int j = 1; j <= tcnum; j++) {
					
					String tsid = XLUnits.getCellData(keywordfile, tCsheet, j, 0);
					
					if (tsid.equalsIgnoreCase(tcid)) {
						
						String keyword = XLUnits.getCellData(keywordfile, tCsheet, j, 4);
						
						switch (keyword.toLowerCase()) {
						
						case "adminlogin":
							
							phome.adminuid=XLUnits.getCellData(keywordfile, tCsheet, j, 5);
							
							phome.adminpwd=XLUnits.getCellData(keywordfile, tCsheet, j, 6);
							
							res = phome.adminLogin(phome.adminuid,phome.adminuid);
							
							if (res) {

								Assert.assertTrue(res);
								
							}
							break;
							
						case "adminlogout":
							res = bhome.bankerLogout();
							Assert.assertTrue(res);
							break;

						case "bankerlogin":
							phome.bankerbrch=XLUnits.getCellData(keywordfile, tCsheet, j, 5);

							phome.bankeruid=XLUnits.getCellData(keywordfile, tCsheet, j, 6);

							phome.bankerpwd=XLUnits.getCellData(keywordfile, tCsheet, j, 7);
							
							res = phome.bankerLogin(phome.bankerbrch, phome.bankeruid,phome.bankerpwd);
							
							Assert.assertTrue(res);
							break;

						case "bankerlogout":
							
							res = bhome.bankerLogout();
							
							Assert.assertTrue(res);
							break;

						case "personallink":
							
							res = phome.PersonalLink();
							
							Assert.assertTrue(res);
							break;
							
						case "international":
							
							res =phome.internationaL();
							
							Assert.assertTrue(res);
							break;
						
						}//
						
						
						if (res) {
							
							String tsres = "Pass";
							
							XLUnits.setCellData(keywordfile, tCsheet, j,3,tsres);
							
							XLUnits.fillGreenColor(keywordfile, tCsheet, j, 3);
							
						}else {
							
							String tsres = "Fail";
							
							XLUnits.setCellData(keywordfile, tCsheet, j, 3, tsres);
						}
						
						
						String tsres = XLUnits.getCellData(keywordfile, tCsheet, j, 3);
						
						if (!tsres.equalsIgnoreCase("fail")) {
							
							XLUnits.setCellData(keywordfile, tSsheet, i, 3, tsres);
							
						}
						
						if (tsres.equalsIgnoreCase("pass")) {
							
							XLUnits.fillGreenColor(keywordfile, tCsheet, j, 3);
							
						}
						
						else {
							XLUnits.fillRedColor(keywordfile, tCsheet, j, 3);
						}
						
						
					}
					
					
				}
				
				
				
			} else {
				
				String data="blocked";
				
				XLUnits.setCellData(tSsheet, tSsheet, i,3, data);
				
				XLUnits.fillRedColor(keywordfile, tSsheet, i, 3);

			}
		}
		
		
		
	}

}
