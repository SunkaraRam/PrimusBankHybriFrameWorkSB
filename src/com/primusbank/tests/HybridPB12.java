package com.primusbank.tests;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.primusbank.contatns.PrimusbankConstants;
import com.primusbank.libraries.AdminHomePage;
import com.primusbank.libraries.BankerHomePage;
import com.primusbank.libraries.PrimusBankHomePage;

import XLApachePOI.XLUnits;;




public class HybridPB12 extends PrimusbankConstants
{
	String keywordfile="D:\\PrimusBankHybridFrameWork\\src\\com\\primusbank\\testHybridData\\TestDataHybrid1.xlsx";
    String tcsheet="TestScenario";
    String tssheet="TestCases";
	
    @Test 
	public void primusbankBatchTest() throws IOException
	{
		int tccount,tscount;
		String tcexeflag,tcid,tstcid,keyword,tsres,tcres;
		boolean res=false;
		
	PrimusBankHomePage phome = new PrimusBankHomePage();
		
		BankerHomePage bhome = new BankerHomePage();
		
		AdminHomePage ahome = new AdminHomePage();
		
	 tccount=XLUnits.getRowCount(keywordfile, tcsheet);
	 tscount=XLUnits.getRowCount(keywordfile, tssheet);
	 for (int i = 1; i <=tccount; i++) 
	 {
		tcexeflag=XLUnits.getCellData(keywordfile, tcsheet, i,2);
	 if (tcexeflag.equalsIgnoreCase("y")) 
	    {
		   tcid=XLUnits.getCellData(keywordfile, tcsheet, i, 0);
		   for (int j = 1; j <=tscount; j++) 
		   {
			   tstcid=XLUnits.getCellData(keywordfile, tssheet, j, 0);
			   if (tcid.equalsIgnoreCase(tstcid)) 
			   {
				   keyword=XLUnits.getCellData(keywordfile, tssheet, j, 4);
				   
				   switch (keyword.toLowerCase()) 
				   {
				   		case "adminlogin":
				   			
				   			phome.adminuid=XLUnits.getCellData(keywordfile, tssheet, j, 5);
				   			phome.adminpwd=XLUnits.getCellData(keywordfile, tssheet, j, 6);
				   			res=phome.adminLogin(phome.adminuid, phome.adminpwd);		
				   			if (res) {
								
				   				Assert.assertTrue(res);
							}
				   			break;
				   		case "adminlogout":
				   			//res=ahome.adminLogout();
				   			if (res) {
								
				   					ahome.adminLogout();
				   					Assert.assertTrue(res);
							}
				   			break;
				   		case "bankerlogin":
				   			phome.bankerbrch=XLUnits.getCellData(keywordfile, tssheet, j, 5);
				   			phome.bankeruid=XLUnits.getCellData(keywordfile, tssheet, j, 6);
				   			phome.bankerpwd=XLUnits.getCellData(keywordfile, tssheet, j, 7);
				   			res=phome.bankerLogin(phome.bankerbrch, phome.bankeruid, phome.bankerpwd);
				   			if (res) {
								
				   				Assert.assertTrue(res);
							}
				   			break;
				   		case "bankerlogout":
				   			if (res) {
							
				   				bhome.bankerLogout();
				   				Assert.assertTrue(res);
							}
				   			
				   			
				   			break;
				   }
				   if (res) 
				   {
					   tsres="Pass";
					   XLUnits.setCellData(keywordfile, tssheet, j, 3, tsres);
					   XLUnits.fillGreenColor(keywordfile, tssheet, j, 3);
				  } 
				   else 
				   {
					   tsres="Fail";
					   XLUnits.setCellData(keywordfile, tssheet, j, 3, tsres);
					   XLUnits.fillRedColor(keywordfile, tssheet, j, 3);
				   }	
				   				   
				   //Code to update TestCase Res
				   
				   tcres=XLUnits.getCellData(keywordfile, tcsheet, i, 3);
				   System.err.println(tcres);
				   if (!tcres.equalsIgnoreCase("Fail")) 
				   {
					   XLUnits.setCellData(keywordfile, tcsheet, i, 3, tsres);
				   }
				   tcres=XLUnits.getCellData(keywordfile, tcsheet, i, 3);
				   if (tcres.equalsIgnoreCase("Pass")) 
				   {
					   XLUnits.fillGreenColor(keywordfile, tcsheet, i, 3);
				   } else 
				   {
					   XLUnits.fillRedColor(keywordfile, tcsheet, i, 3);
				   }   
				   
				   
			   } 
			}
		 
	     }
	 else 
	    {
	      XLUnits.setCellData(keywordfile, tcsheet, i, 3,"Blocked");
	      XLUnits.fillRedColor(keywordfile, tcsheet, i, 3);
	    
	    }
	 	 
	 }
	 


	}

	
}
