package com.etl.loader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import POJO.AccountDetails;
import POJO.BranchInfoUIData;
import POJO.CustomerDetails;
import POJO.CustomerDetailsUIData;
import POJO.TransactionDetails;

@Controller
public class controller {
	
	@RequestMapping("/welcome")
	public String createFactTable(Model model) {
		
		System.out.println("Hellooooo");
		return "welcome.jsp";
	}
	
	public int createCustomerDimensionTable() throws SQLException, ClassNotFoundException {
		
	
		//merging branch 1 and branch 2 tables to create dimension tables
		
		connection c4 = new connection();
		Connection c4connection = c4.sourcedb1();
		
		c4connection.createStatement();
		Statement stmt4=c4connection.createStatement();  
		ResultSet rs4=stmt4.executeQuery("select * from customerdetails");  
		ArrayList<CustomerDetails> customerDimensionTableData = new ArrayList<>();
		
		while(rs4.next())
		{
			CustomerDetails cd = new CustomerDetails();
			cd.setCustomerId(rs4.getInt(1));
			cd.setCustomerName(rs4.getString(2));
			cd.setAddress(rs4.getString(3));
			//cd.setBranchId(1);
			customerDimensionTableData.add(cd);
			
		}
		
		connection c5 = new connection();
		Connection c5connection = c5.sourcedb2();
		
		c5connection.createStatement();
		Statement stmt5=c5connection.createStatement();  
		ResultSet rs5=stmt5.executeQuery("select * from customerdetails");  
		
		while(rs5.next())
		{
			CustomerDetails cd = new CustomerDetails();
			cd.setCustomerId(rs5.getInt(1));
			cd.setCustomerName(rs5.getString(2));
			cd.setAddress(rs5.getString(3));
			//cd.setBranchId(2);
			customerDimensionTableData.add(cd);
			
		}

		String query = "INSERT INTO customerdetails ( CustomerID, CustomerName, Address) VALUES (?, ?, ?)";
		PreparedStatement ps1;
		
		connection c3 = new connection();
		Connection source3connection;
		source3connection = c3.sourcedb3();
		
		ps1 = source3connection.prepareStatement(query);
		
		for(int k=0; k<customerDimensionTableData.size(); k++){
			
		ps1.setInt(1, customerDimensionTableData.get(k).getCustomerId());
		ps1.setString(2, customerDimensionTableData.get(k).getCustomerName());
		ps1.setString(3, customerDimensionTableData.get(k).getAddress());
				
	int i = ps1.executeUpdate();
		
		}
		
		return 1 ;
	}
		
	public int createTransactionDimensionTable() throws ClassNotFoundException, SQLException {
		

		
		//merging branch 1 and branch 2 tables to create transaction dimension tables
		
				connection c6 = new connection();
				Connection c6connection = c6.sourcedb1();
				
				Statement stmt6=c6connection.createStatement();  
				ResultSet rs6=stmt6.executeQuery("select * from transactiondetails");  
				ArrayList<TransactionDetails> transactionDimensionTableData = new ArrayList<>();
				
				while(rs6.next())
				{
					TransactionDetails td = new TransactionDetails();
					td.setTransactionId(rs6.getInt(1));
					td.setTransactionType(rs6.getString(2));
					td.setTransactionAmount(rs6.getInt(3));
					td.setTransactionMonth(rs6.getString(5));
					//td.setBranchId(1);
					transactionDimensionTableData.add(td);
					
				}
				
				connection c7 = new connection();
				Connection c7connection = c7.sourcedb2();
				
				Statement stmt7=c7connection.createStatement();  
				ResultSet rs7=stmt7.executeQuery("select * from transactiondetails");  
				
				while(rs7.next())
				{
					TransactionDetails td = new TransactionDetails();
					td.setTransactionId(rs7.getInt(1));
					td.setTransactionType(rs7.getString(2));
					td.setTransactionAmount(rs7.getInt(3));
					td.setTransactionMonth(rs7.getString(5));
					//td.setBranchId(2);
					transactionDimensionTableData.add(td);
					
				}

				String query2 = "INSERT INTO transactiondetails ( TransactionId, TransactionType, Amount, TransMonth) VALUES (?, ?, ?, ?)";
				PreparedStatement ps2;
				connection c3 = new connection();
				Connection source3connection;
				source3connection = c3.sourcedb3();
				ps2 = source3connection.prepareStatement(query2);
				
				for(int k=0; k<transactionDimensionTableData.size(); k++){
					
				ps2.setInt(1, transactionDimensionTableData.get(k).getTransactionId());
				ps2.setString(2, transactionDimensionTableData.get(k).getTransactionType());
				ps2.setInt(3, transactionDimensionTableData.get(k).getTransactionAmount());
				ps2.setString(4, transactionDimensionTableData.get(k).getTransactionMonth());
				//ps2.setInt(5, transactionDimensionTableData.get(k).getBranchId());
			
				int i = ps2.executeUpdate();
				
				}
		

		
		return 1;
	}
	
	public int createAccountDimensionTable() throws ClassNotFoundException, SQLException {
		

		//merging branch 1 and branch 2 tables to create account dimension tables
		
		connection c8 = new connection();
		Connection c8connection = c8.sourcedb1();
		
		Statement stmt8=c8connection.createStatement();  
		ResultSet rs8=stmt8.executeQuery("select * from accountdetails");  
		ArrayList<AccountDetails> accountDimensionTableData = new ArrayList<>();
		
		while(rs8.next())
		{
			AccountDetails ad = new AccountDetails();
			ad.setAccountNumber(rs8.getInt(1));
			ad.setAccountType(rs8.getString(2));
			ad.setBalance(rs8.getInt(3));
			//ad.setBranchId(1);
			accountDimensionTableData.add(ad);
			
		}
		
		connection c9 = new connection();
		Connection c9connection = c9.sourcedb2();
		
		Statement stmt9=c9connection.createStatement();  
		ResultSet rs9=stmt9.executeQuery("select * from accountdetails");  
		
		while(rs9.next())
		{
			AccountDetails ad = new AccountDetails();
			ad.setAccountNumber(rs9.getInt(1));
			ad.setAccountType(rs9.getString(2));
			ad.setBalance(rs9.getInt(3));
			//ad.setBranchId(2);
			accountDimensionTableData.add(ad);
			
		}

		String query3 = "INSERT INTO accountdetails ( AccountNo, Balance) VALUES (?, ?)";
		PreparedStatement ps3;
		connection c3 = new connection();
		Connection source3connection;
		source3connection = c3.sourcedb3();
		ps3 = source3connection.prepareStatement(query3);
		
		for(int k=0; k<accountDimensionTableData.size(); k++){
			
		ps3.setInt(1, accountDimensionTableData.get(k).getAccountNumber());
		//ps3.setString(2, accountDimensionTableData.get(k).getAccountType());
		ps3.setInt(2, accountDimensionTableData.get(k).getBalance());
		//ps3.setInt(4, accountDimensionTableData.get(k).getBranchId());
	
		int i = ps3.executeUpdate();
		
		}





		return 1;
	}

	@RequestMapping("/updateFactTable")
	public String extractAndTransform(Model model) throws ClassNotFoundException, SQLException {
		
		connection c1 = new connection();
		Connection source1connection;
		source1connection = c1.sourcedb1();
		
		connection c2 = new connection();
		Connection source2connection;
		source2connection = c2.sourcedb2();
		
		connection c3 = new connection();
		Connection source3connection;
		source3connection = c3.sourcedb3();
		
		
		//createFactTable();
		
		ArrayList<FactTableData> factDataList = new ArrayList<>();
		
		//creating the data for the fact table from branch 1
		Statement stmt=source1connection.createStatement();  
		ResultSet rs=stmt.executeQuery("select customerdetails.CustomerID,accountdetails.AccountNumber,transactiondetails.TransMonth, transactiondetails.transactionID from ((customerdetails INNER JOIN accountdetails ON  customerdetails.CustomerID= accountdetails.CustomerID) INNER JOIN transactiondetails ON customerdetails.CustomerID= transactiondetails.CustomerID)");  
		while(rs.next()) 
		{
			
			  FactTableData data = new FactTableData();
			  data.setAccountNumber(rs.getInt(2)); 
			  data.setMonth(rs.getString(3));
			  data.setCustomerId(String.valueOf(rs.getInt(1)));
			  data.setAmount(0);
			  data.setTransactionId(rs.getInt(4));
			  data.setBranchId(1);
			  factDataList.add(data);
		}
		
		Statement stmt1=source1connection.createStatement();  
		ResultSet rs1=stmt1.executeQuery("select transactiondetails.customerid, transactiondetails.transmonth, sum(transactiondetails.amount) as AMOUNTSPENT from transactiondetails where transactiondetails.transactiontype ='d' group by transactiondetails.customerid, transactiondetails.transmonth;");  
		while(rs1.next())
		{
			String customer = String.valueOf(rs1.getInt(1));
			String month = rs1.getString(2);
			
			int j=0; 
			for(j=0;j<factDataList.size();j++)
			{
				if(factDataList.get(j).getCustomerId().equalsIgnoreCase(customer) && factDataList.get(j).getMonth().equalsIgnoreCase(month))
				{
					factDataList.get(j).setAmount(rs1.getInt(3));
				}
				
			}
			
		}
		
		//creating the data for the fact table from branch 2
		Statement stmt2=source2connection.createStatement();  
		ResultSet rs2=stmt2.executeQuery("select customerdetails.CustID,accountdetails.AccountNumber,transactiondetails.TransMonth, transactiondetails.transactionID, transactiondetails.Amount from ((customerdetails INNER JOIN accountdetails ON  customerdetails.CustID= accountdetails.CustID) INNER JOIN transactiondetails ON customerdetails.CustID= transactiondetails.CustID)");  
		
		while(rs2.next()) 
		{
			
			  FactTableData data = new FactTableData();
			  data.setAccountNumber(rs2.getInt(2)); 
			  data.setAmount(rs2.getInt(5));
			  data.setMonth(rs2.getString(3));
			  data.setCustomerId(String.valueOf(rs2.getInt(1)));
			  data.setTransactionId(rs2.getInt(4));
			  data.setBranchId(2);
			  factDataList.add(data);
		}
		
		Statement stmt3=source2connection.createStatement();  
		ResultSet rs3=stmt3.executeQuery("select transactiondetails.custid, transactiondetails.transmonth, sum(transactiondetails.amount) as AMOUNTSPENT from transactiondetails where transactiondetails.transactiontype ='d' group by transactiondetails.custid, transactiondetails.transmonth;");  
		while(rs3.next())
		{
			String customer = String.valueOf(rs3.getInt(1));
			String month = rs3.getString(2);
			
			int k; 
			for(k=0;k<factDataList.size();k++)
			{
				if(factDataList.get(k).getCustomerId().equalsIgnoreCase(customer) && factDataList.get(k).getMonth().equalsIgnoreCase(month))
				{
					factDataList.get(k).setAmount(rs3.getInt(3));
				}
				
			}
			
		}
			
		//inserting the fact table data
		String queryCheck = "INSERT INTO facttable ( CustomerID, AccountNumber, TransMonth, TransactionID, Fundspent, BranchId) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps;
		ps = source3connection.prepareStatement(queryCheck);
		
		
		for(int k=0; k<factDataList.size(); k++){
			
		ps.setString(1, factDataList.get(k).getCustomerId());
		ps.setInt(2, factDataList.get(k).getAccountNumber());
		ps.setString(3, factDataList.get(k).getMonth());
		ps.setInt(4, factDataList.get(k).getTransactionId());
		ps.setInt(5,  factDataList.get(k).getAmount());
		ps.setInt(6, factDataList.get(k).getBranchId());
		
	int i = ps.executeUpdate();
		
		}
		
		createCustomerDimensionTable();
		createAccountDimensionTable();
		createTransactionDimensionTable();
			
		model.addAttribute("message","Warehouse Updated");
		return "twitterDashboard.jsp";

	}
	
	@RequestMapping("/gotoDashboard")
	public String redirect1(Model model) {
	
		return "twitterDashboard.jsp";
	}
	@RequestMapping("/gotoTransactionInfo")
	public String redirect2(Model model) {
	
		return "transactionInfo.jsp";
	}
	@RequestMapping("/gotoBranchInfo")
	public String redirect3(Model model) {
	
		return "branchInfo.jsp";
	}
	
	@RequestMapping("/findcustomer")
	public String getCustomerInfo(Model model, String customerId) throws SQLException, ClassNotFoundException
	{
		connection c = new connection();
		Connection facttableconnection = c.sourcedb3();
		
		Statement stmt = facttableconnection.createStatement();
		String query= "select customerid, accountnumber, branchid from facttable where customerid = ?";
		PreparedStatement ps;
		ps = facttableconnection.prepareStatement(query);
		ps.setString(1, customerId);
		ResultSet rs = ps.executeQuery();
		ArrayList<CustomerDetailsUIData> ar = new ArrayList<>();
		while(rs.next())
		{
			CustomerDetailsUIData cdud = new CustomerDetailsUIData();
			cdud.setCustomerId(rs.getString(1));
			cdud.setAccountNumber(rs.getInt(2));
			cdud.setBranchId(rs.getInt(3));
			ar.add(cdud);
		}
		
		Statement stmt1 = facttableconnection.createStatement();
		String query1 = "select customername, address from customerdetails where customerid = ?";
		PreparedStatement ps1;
		ps1 = facttableconnection.prepareStatement(query1);
		ps1.setString(1, customerId);
		ResultSet rs1 = ps1.executeQuery();
		while(rs1.next())
		{
			ar.get(0).setCustomerName(rs1.getString(1));
			ar.get(0).setAddress(rs1.getString(2));
		}
		
		Statement stmt2 = facttableconnection.createStatement();
		String query2 = "select balance from accountdetails where accountno = ?";
		PreparedStatement ps2;
		ps2 = facttableconnection.prepareStatement(query2);
		ps2.setInt(1, ar.get(0).getAccountNumber());
		ResultSet rs2 = ps2.executeQuery();
		while(rs2.next())
		{
			ar.get(0).setBalance(rs2.getInt(1));
		}

		model.addAttribute("customerinfo", ar.get(0));
		return "twitterDashboard.jsp";
	}
	
	@RequestMapping("/findTransactionInfo")
	public String getTransactionInfo(Model model, String month) throws SQLException, ClassNotFoundException
	{
		connection c = new connection();
		Connection facttableconnection = c.sourcedb3();
		
		Statement stmt = facttableconnection.createStatement();
		String query= "select customerid, transmonth, fundspent from facttable where transmonth = ? group by customerid";
		PreparedStatement ps;
		ps = facttableconnection.prepareStatement(query);
		ps.setString(1, month);
		ResultSet rs = ps.executeQuery();
		ArrayList<FactTableData> ar = new ArrayList<>();
		while(rs.next())
		{
			FactTableData ftd = new FactTableData();
			ftd.setCustomerId(rs.getString(1));
			ftd.setMonth(month);
			ftd.setAmount(rs.getInt(3));
			ar.add(ftd);
		}
		model.addAttribute("transactioninfo", ar);
		model.addAttribute("size", "Records Fetched= "+ar.size());
		return "transactionInfo.jsp";
	}
	
	
	@RequestMapping("/findBranchInfo")
	public String getBranchInfo(Model model, String branchId) throws SQLException, ClassNotFoundException
	{
		connection c = new connection();
		Connection facttableconnection = c.sourcedb3();
		String query;
		PreparedStatement ps;
		if(branchId.equalsIgnoreCase("both"))
				{
			query= "select branchid, facttable.customerid, facttable.accountnumber, customername from facttable inner join customerdetails on facttable.customerid = customerdetails.customerid group by customerid";
			ps = facttableconnection.prepareStatement(query);

				}
		else
		{
			query= "select branchid, facttable.customerid, facttable.accountnumber, customername from facttable inner join customerdetails on facttable.customerid = customerdetails.customerid where branchId = ? group by customerid";
			ps = facttableconnection.prepareStatement(query);
			ps.setString(1, branchId);
		
		}
		
		ResultSet rs = ps.executeQuery();
		ArrayList<BranchInfoUIData> ar = new ArrayList<>();
		while(rs.next())
		{
			BranchInfoUIData buid = new BranchInfoUIData();
			buid.setBranchId(rs.getInt(1));
			buid.setCustomerId(rs.getInt(2));
			buid.setAccountNumber(rs.getInt(3));
			buid.setCustomerName(rs.getString(4));
			ar.add(buid);
		}
		
		model.addAttribute("branchinfo", ar);
		model.addAttribute("size", "Records Fetched= "+ar.size());
		return "branchInfo.jsp";
	}
	
	}
