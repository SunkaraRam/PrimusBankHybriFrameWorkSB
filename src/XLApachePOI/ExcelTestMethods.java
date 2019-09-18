package XLApachePOI;

import java.io.IOException;

import XLApachePOI.XLUnits;;

public class ExcelTestMethods
{

	public static void main(String[] args) throws IOException {
		
		System.out.println(XLUnits.getCellData("D:\\PrimusBankHybridFrameWork\\src\\com\\primusbank\\testHybridData\\TestDataHybrid.xlsx", "TestCases",1,5));
		}
}
