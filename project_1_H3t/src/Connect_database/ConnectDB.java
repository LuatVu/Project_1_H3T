package Connect_database;

import java.awt.Choice;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import data.Categories;
import data.Products;
import data.Suppliers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;


public class ConnectDB {
	private static final String classJDBC = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/project_1";
	private static final String username = "root";
	private static final String password = "1234";
	private Connection connection;
	
	
	public void Connecting()
	{
		try {
			Class.forName(classJDBC);
			System.out.println("found class jdbc successful !");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			connection = DriverManager.getConnection(url,username,password);
			System.out.println("connect is Successful !");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public ResultSet getResultset(String sqlcommand)
	{
		ResultSet result = null;
		
		try {
			Statement statement = connection.createStatement();
			result = statement.executeQuery(sqlcommand);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	public void loadData(JTable jtable,DefaultTableModel tablemodel,String [] columnName,String sqlcommand)
	{
		ResultSet result = getResultset(sqlcommand);
		int columnNumber;
		tablemodel.setRowCount(0);
		try {
			ResultSetMetaData rsmd = result.getMetaData();
			columnNumber = rsmd.getColumnCount();
			String [] columnData = new  String[columnNumber];
			
			for(int i = 0; i< columnNumber ; i++)
			{
				columnData[i] = rsmd.getColumnName(i+1);
			}
			tablemodel.setColumnIdentifiers(columnName);
			
			while(result.next())
			{
				for(int i= 0;i < columnNumber; i++)
				{
					columnData[i] = result.getString(i+1);
				}
				tablemodel.addRow(columnData);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jtable.setModel(tablemodel);
	}
	
	// phuong thuc nay chi su dung trong 1 pham vi nho. khong mang tinh tong quat
	public void loadData(Choice choice, String sqlcommand)
	{
		choice.removeAll();
		ResultSet rs = getResultset(sqlcommand);
		try {
			choice.addItem("");
			while(rs.next())
			{
				choice.addItem(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<String> loadData(int column,String sqlcommand) //
	{
		ArrayList <String> str = new <String>ArrayList(); 
		ResultSet rs = getResultset(sqlcommand);
		try {
			while( rs.next() )
			{
				str.add(rs.getString(column) );
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	
	public void insertProduct(Products product)
	{
		String sqlCommand = "INSERT INTO products(productID,productName,categoryID,supplierID,storage,amount,price,hsd)"
				+ "Values(?,?,?,?,?,?,?,?);";
		try{
			PreparedStatement ps = connection.prepareStatement(sqlCommand);
			ps.setInt(1, product.getProductID());
			ps.setString(2, product.getProductName());
			ps.setInt(3, product.getCategoryID());
			ps.setInt(4, product.getSupplierID());
			ps.setInt(5, product.getStorage());
			ps.setInt(6, product.getAmount());
			ps.setInt(7, product.getPrice());
			ps.setString(8, product.getHsd());
			
			if(ps.executeUpdate() > 0 )
			{
				JOptionPane.showMessageDialog(null, "Them san pham thanh cong");
			}			
			
		}catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null, "Ma san pham da ton tai");
			
		}
	}
	
	public void insertSupplier(Suppliers supplier)
	{
		String sqlCommand = "INSERT INTO suppliers(supplierID,supplierName,supplierAddress,phone)"
				+ "Values(?,?,?,?);";
		try{
			PreparedStatement ps = connection.prepareStatement(sqlCommand);
			ps.setInt(1, supplier.getSupplierID());
			ps.setString(2, supplier.getSupplierName());
			ps.setString(3,  supplier.getSupplierAddress());
			ps.setInt(4,  supplier.getPhone());
			if(ps.executeUpdate() >0)
			{
				JOptionPane.showMessageDialog(null, "Them nha cung cap thanh cong");
			}
			
		}catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null, "Ma nha cung cap da ton tai");
		}
	}
	
	public void insertCategories(Categories category)
	{
		String sqlCommand = "Insert Into categories(categoryID,categoryName,description)"
				+ "Value(?,?,?)";
		try{
			PreparedStatement ps = connection.prepareStatement(sqlCommand);
			ps.setInt(1, category.getCategoryID());
			ps.setString(2, category.getCategoryName());
			ps.setString(3, category.getDescription());
			if(ps.executeUpdate() >0)
			{
				JOptionPane.showMessageDialog(null, "Them loai san pham thanh cong");
			}
		}catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null, "Ma loai san pham da ton tai");
		}
	}
}
