package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider 1
	
	@DataProvider(name="loginData")
	public String [][]getData() throws IOException
	{
		String path=".\\testData\\opencart_loginData.xlsx";
		ExcelUtility xlutil=new ExcelUtility(path);
		
		int total_rows=xlutil.getRowCount("Sheet1");
		int total_cols=xlutil.getCellCount("Sheet1",1);
		
		String logindata[][]=new String [total_rows][total_cols];
		
		//read data from excel storing into two dimensional array
		for(int i=1;i<=total_rows;i++)
		{
			for(int j=0;j<total_cols;j++)
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
		}
		return logindata;	//returning two dimensional array
	}

}

//DataProvider 2

//DataProvider 3

//DataProvider 4
