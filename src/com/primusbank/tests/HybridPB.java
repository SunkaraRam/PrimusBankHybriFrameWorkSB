package com.primusbank.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.primusbank.contatns.PrimusbankConstants;
import com.primusbank.libraries.AdminHomePage;
import com.primusbank.libraries.BankerHomePage;
import com.primusbank.libraries.PrimusBankHomePage;

import XLApachePOI.XLUnits;;


public class HybridPB extends PrimusbankConstants
{
	
	
	
	int ttcount,tscount,tccount;
	
	String keywordFile = "D:\\PrimusBankHybridFrameWork\\TestIO\\SureshBabu.xlsx";
	
	String tSsheet= "TestScenario";
	
	String tCsheet = "TestCases";
	
	String tcexeflag ,tcid,tsid,keyword, tcres,tsres;
		
	PrimusBankHomePage phome = new PrimusBankHomePage();
	
	BankerHomePage bhome = new BankerHomePage();
	
	AdminHomePage ahome = new AdminHomePage();
	
	@Test
	public void primusbankBatchTest() throws IOException
	{
			
		tscount= XLUnits.getRowCount(keywordFile, tSsheet);//TestScenario Sheet
		
		for (int i = 1; i <=tscount; i++) 
		{
			
			tcexeflag = XLUnits.getCellData(keywordFile, tSsheet, i , 2);
			
			if (tcexeflag.equalsIgnoreCase("y")) 
			{
				
				tsid = XLUnits.getCellData(keywordFile, tSsheet, i, 0);
				
				tccount = XLUnits.getRowCount(keywordFile, tCsheet);
				
				boolean res = false;
				
				for (int j = 1; j <=tccount; j++) 
				{ 
					
					tcid = XLUnits.getCellData(keywordFile, tCsheet,j, 0);
					
					if (tcid.equalsIgnoreCase(tsid)) 
					{
						
						keyword = XLUnits.getCellData(keywordFile, tCsheet, j , 4);
						
						switch (keyword.toLowerCase()) 
							{
								case "adminlogin":
									phome.adminuid=XLUnits.getCellData(keywordFile, tCsheet, j, 5);
									phome.adminpwd = XLUnits.getCellData(keywordFile, tCsheet, j, 6);
	 								res = phome.adminLogin(phome.adminuid,phome.adminpwd);
									if(res){
										
										Assert.assertTrue(res);
										
									}
									
									break;
									
								case "adminlogout":
									 //res = ahome.adminLogout();
									if (res) {
										
										ahome.adminLogout();
											}
									 
									break;
								
								case "bankerlogin":
									phome.bankerbrch=XLUnits.getCellData(keywordFile, tCsheet, j, 5);
									phome.bankeruid=XLUnits.getCellData(keywordFile, tCsheet, j, 6);
									phome.bankerpwd=XLUnits.getCellData(keywordFile, tCsheet, j, 7);					
									res = phome.bankerLogin(phome.bankerbrch,phome.bankeruid,phome.bankerpwd);
									if (res) {
										
										Assert.assertTrue(res);
										
									}
									break;
									
								case "bankerlogout":
									
									//res = bhome.bankerLogout();
									if (res) {
										
										 bhome.bankerLogout();
									}
									
									break;
									
									
								case "personallink":
									
									res=phome.PersonalLink();
									
									Assert.assertTrue(res);
									
									break;
									
								case "international":
									
									res=phome.internationaL();
									
									Assert.assertTrue(res);
									
									/*
									 								
									try{
										
										Assert.assertTrue(res);
										
									} catch (Exception e) {
										
										 
									}
									
									*/
									
	
							}
						
							
							//Switch case End
							
							if (res) 
								{
								
									tsres ="Pass";
									XLUnits.setCellData(keywordFile, tCsheet , j, 3, tsres);
									XLUnits.fillGreenColor(keywordFile, tCsheet, j,3);									
								}
							
							else {
								
									tsres = "Fail";
									XLUnits.setCellData(keywordFile, tCsheet , j, 3, tsres);
									XLUnits.fillRedColor(keywordFile, tCsheet, j, 3);
								
								}
					
							
							//Code for Update TestCase Result
								
								tcres =XLUnits.getCellData(keywordFile, tCsheet, i, 3);//pass
								
									if(!tcres.equalsIgnoreCase("fail")) 
										{
										
											XLUnits.setCellData(keywordFile, tSsheet, i, 3,tsres);
											
										}
								
								tcres = XLUnits.getCellData(keywordFile, tSsheet, i, 3);
								
									if (tcres.equalsIgnoreCase("pass")) 
										{
										
											XLUnits.fillGreenColor(keywordFile, tSsheet, i, 3);
									  	
										}
									else 
										{
											XLUnits.fillRedColor(keywordFile, tSsheet, i, 3);
										}
					}
						
					}
					
					 
				
			}
			
			else {
				XLUnits.setCellData(keywordFile, tSsheet,  i, 3,"Blocked");
				XLUnits.fillRedColor(keywordFile, tSsheet, i, 3);
			}
		
	}
		
  }
	
}


