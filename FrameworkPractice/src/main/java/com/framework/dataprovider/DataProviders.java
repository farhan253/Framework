/**
 * 
 */
package com.framework.dataprovider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.beust.jcommander.internal.Lists;
import com.framework.utilities.NewExcelLibrary;


public class DataProviders {

	NewExcelLibrary obj = new NewExcelLibrary();

//Class --> LoginPageTest,HomePageTest Test Case--> loginTest, wishListTest, orderHistoryandDetailsTest

	@DataProvider(name = "credentials")
	public Object[][] getCredentials() {
		// Totals rows count
		int rows = obj.getRowCount("credentials");
		// Total Columns
		int column = obj.getColumnCount("credentials");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("credentials", j, i + 2);
			}
		}
		return data;
	}

	@DataProvider(name = "shipping address")
	public Object[][] shippingAddress() {
		// Totals rows count
		int rows = obj.getRowCount("shipping address");
		// Total Columns
		int column = obj.getColumnCount("shipping address");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("shipping address", j, i + 2);
			}
		}
		return data;
	}
	@DataProvider(name = "myProject")
	public Object[][] myProject() {
		// Totals rows count
		int rows = obj.getRowCount("myProject");
		// Total Columns
		int column = obj.getColumnCount("myProject");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("myProject", j, i + 2);
			}
		}
		return data;
	}
	

}
