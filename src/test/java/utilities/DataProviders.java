package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path="./testData/Testdata.xlsx";
		ExcelUtility xu=new ExcelUtility(path);
		int totalRows= xu.getRowCount("LoginData");
		int totalColumns= xu.getCellCount("LoginData", 1);
		
		String loginData[][]=new String[totalRows][totalRows];
		for(int i=1;i<totalRows;i++) {
			for(int j=0;j<totalColumns;j++) {
				loginData[i-1][j]=xu.getCellData(i, j);
			}
		}
		return loginData;
	}
	
}
