package Graphic_user_interface;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Connect_database.ConnectDB;

import java.awt.event.*;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.Categories;
import data.Customers;
import data.OrderDetails;
import data.Orders;
import data.Products;
import data.Suppliers;

import java.lang.NumberFormatException;
//import java.awt.Insets;
//import java.awt.GridBagLayout;
//import java.awt.BorderLayout;
//import java.awt.MenuBar;
//import java.awt.Menu;



public class GUIclass extends JFrame implements ActionListener,ItemListener{
	
	
	//......................................
	private GridBagLayout gb;
	private GridBagConstraints gbc;
	//................................................ panelMain
	
	private JPanel panelMain;
	private MenuBar menubar;
	private Menu menufile,menuedit;
	
	//................................................ panelTagba
	private JPanel panelTagba;  
	private JButton buttonHome,buttonAdd,buttonProduct,buttonSupplier,buttonCategory,buttonSale,buttonCustomer; 
	
	
	//................................................ panelHomeMain
	private JPanel panelHomeMain;
	
	//................................................ panelTrangChu
	
	private JPanel panelTrangChu;
	
	
	//................................................ panelAddMain
	
	private JPanel panelAddMain;
	private JPanel panelAdd1,panelAdd2,panelAdd3;
	private JLabel labelAdd1, labelAdd2, labelAdd3, labelAdd4, labelAdd5, labelAdd6, labelAdd7, labelAdd8, labelAdd9, labelAdd10, labelAdd11, labelAdd12, labelAdd13;
	private JLabel ErrorMessage;
	private JButton buttonAddsave;
	private JTextField textfieldAdd1, textfieldAdd2, textfieldAdd3, textfieldAdd4, textfieldAdd5;
	private JPanel panelAdd6;
	private Choice choiceAdd62, choiceAdd63;
	private static String stringAddNam;
	private static String stringAddThang;
	private Choice choiceAdd7; 
	private JTextField textfieldAdd8, textfieldAdd9, textfieldAdd12;
	private Choice choiceAdd11;
	private TextArea textareaAdd10,textareaAdd13;
	
	private static final String sqlSupplierAdd = "SELECT s.supplierName FROM suppliers as s;";
	private static final String sqlCategoryAdd = "SELECT c.categoryName FROM categories as c";
	
	
	//............................................... panelProductMain
	
	private JPanel panelProductMain;
	private JPanel panelProduct1,panelProduct2,panelProduct3;
	private JPanel panelProduct31,panelProduct32, panelProduct33, panelProduct34;
	
	private JTextField textfieldProduct1, textfieldProduct2, textfieldProduct3, textfieldProduct4,
	textfieldProduct5, textfieldProduct6, textfieldProduct7, textfieldProduct8;   // thanh tim kiem 
	
	private JTable tableProduct;
	private String [] columnNameProduct = {"ID","ProductName","Category","Supplier","Storage","Amount","Price","Hsd"};
	private JScrollPane jscrollpaneProduct;
	private DefaultTableModel tableModelProduct;  
	private static final String sqlProducts = "SELECT p.productID, p.productName, c.categoryName, s.supplierName, p.storage, p.amount, p.price, p.hsd"
			+ " FROM products as p, categories as c, suppliers as s "
			+ "WHERE p.categoryID = c.categoryID and p.supplierID = s.supplierID;";
	
	private JTextField textfieldProduct9, textfieldProduct10, textfieldProduct11, textfieldProduct12, textfieldProduct13;
	private TextArea textareaProduct14;
	private JTextField textfieldProduct15;
	private TextArea textareaProduct16;
	
	private JLabel labelProduct9, labelProduct10, labelProduct11,labelProduct12, labelProduct13, labelProduct14, labelProduct15, labelProduct16;
	private JLabel labelProduct31;
	
	//............................................................panelSupplier
	private JPanel panelSupplierMain;
	private JPanel panelSupplier1,panelSupplier2;
	private JPanel panelSupplier11,panelSupplier12;
	private JLabel labelSupplierCaption;
	private JLabel labelSupplier1, labelSupplier2, labelSupplier3, labelSupplier4; 
	private JTextField textfieldSupplier1, textfieldSupplier2, textfieldSupplier3;
	private TextArea textareaSupplier;
	private JButton buttonSupplierSave;
	private JTable tableSupplier;
	private JScrollPane jscrollpaneSupplier;
	private DefaultTableModel tableModelSupplier;
	private static final String [] columnNameSupplier = {"SupplierID","SupplierName","SupplierAddress","Phone"};
	private static final String sqlSupplier = "SELECT * FROM suppliers";
	
	
	//............................................................... panelCategory
	private JPanel panelCategoryMain;
	private JPanel panelCategory1, panelCategory2;
	private JPanel panelCategory11, panelCategory12;
	private JPanel panelCategory21, panelCategory22;
	private JPanel panelCategory221, panelCategory222;
	
	private JLabel labelCategoryCaption1, labelCategoryCaption2;
	private JLabel labelCategory1, labelCategory2, labelCategory3;
	private JLabel labelCategory222;
	private TextArea textareaCategory222;
	
	private JTextField textfieldCategory1, textfieldCategory2;
	private TextArea textareaCategory;
	
	private JButton buttonCategorySave; 
	
	private JTable tableCategory;
	private JScrollPane jscrollpaneCategory;
	private DefaultTableModel tableModelCategory;
	
	private static final String [] columnNameCategory = {"CategoryID","CategoryName","Description"};
	private static final String sqlCategory = "SELECT * FROM categories";
	
	
	//................................................ panelSaleMain
	
	private JPanel panelSaleMain; 
	private JPanel panelSale1,panelSale2;
	private JPanel panelSale21,panelSale22; 
	
	private JLabel labelSale1, labelSale2, labelSale3, labelSale4, labelSale5, labelSale6, labelSale7;
	private JTextField textfieldSale1, textfieldSale2, textfieldSale3, textfieldSale4, textfieldSale5;
	private TextArea  textareaSale6;
	private JTextField  textfieldSale7;
	private JButton buttonSale1, buttonSale2;
	
	private String [] columnNameSale = {"ProductID","ProductName","Categoryname","Đơn giá","Amount"};

	
	private JTable tableSale;
	private JScrollPane jscrollpaneSale;
	private DefaultTableModel tableModelSale;
	private static final String sqlSale = "SELECT p.productID, p.productName,c.categoryName,p.price FROM PRODUCTS AS P,CATEGORIES AS C WHERE P.categoryID = C.categoryID;";
	
	
	//................................................ panelCustomerMain
	
	private JPanel panelCustomerMain;
	private JPanel panelCustomer1,panelCustomer2,panelCustomer3;
	private JPanel panelCustomer31,panelCustomer32,panelCustomer33;
	private JPanel panelCustomer331, panelCustomer332;
	
	private JTextField textfieldCustomer1, textfieldCustomer2, textfieldCustomer3;
	
	private JTextField textfieldCustomer4, textfieldCustomer5;
	private TextArea textareaCustomer6;
	private JTextField textfieldCustomer7;
	
	private String [] columnNameCustomer1 = {"CustomerID","CustomerName","Phone"};
	private Object [][] dataCustomer1 = {};
	
	private String[] columnNameCustomer2 = {"OrderDate","ProductID","ProductName","Amount"};
	private Object [][] dataCustomer2 = {};
	
	private JTable tableCustomer1;
	private JScrollPane jscrollpaneCustomer1;
	
	private JTable tableCustomer2;
	private JScrollPane jscrollpaneCustomer2;
	
	private JLabel labelCustomer4, labelCustomer5, labelCustomer6,labelCustomer7;
	private JLabel labelCustomer8;
	
	//.........................connect database....................................................
	
	private ConnectDB connection;
	
	//..................................... data ...........................................
	Categories category = new Categories();
	Customers customer = new Customers(); 
	OrderDetails orderDetail = new OrderDetails();
	Orders order = new Orders();
	
	private ArrayList <Categories> categories       = new ArrayList();
	private ArrayList <Customers> customers         = new ArrayList();
	private ArrayList <OrderDetails> orderDetails   = new ArrayList();
	private ArrayList <Orders> orders               = new ArrayList();
//	private ArrayList <Products> products           = new ArrayList();
	private ArrayList <Suppliers> suppliers         = new ArrayList();
	
	
	//.......................................................................................
	
	public GUIclass()
	{
		super("Quan ly ban hang");
		
		//................................connection database ...............................
		
		connection = new ConnectDB();
		connection.Connecting();
		
		
		//...............................
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		gb = new GridBagLayout();
		gbc = new GridBagConstraints();
		
		
		//...........
		panelMain = new JPanel();
		menubar = new MenuBar();
		menufile = new Menu("FILE");
		menuedit = new Menu("EDIT");
		
		
		//..........................
		
		panelTagba = new JPanel();  //-------------------> panelTagba
		buttonHome = new JButton("HOME");
		buttonAdd = new JButton("ADD"); 
		buttonProduct = new JButton("Product");
		buttonSupplier = new JButton("Supplier");
		buttonCategory = new JButton("Category");
		buttonSale = new JButton("Sale");
		buttonCustomer = new JButton("Customer");
		
		//........................---------------------->panelHomeMain;
		
		panelHomeMain = new JPanel();
		
		//.................................--------------->panelTrangChu
		panelTrangChu = new JPanel();
	
		//......................................
		panelAddMain = new JPanel();    //--------------------------panelAddMain
		
		panelAdd1 = new JPanel();
		panelAdd2 = new JPanel();
		panelAdd3 = new JPanel();
		
		labelAdd1 = new JLabel("ProductID");
		labelAdd2 = new JLabel("ProductName");
		labelAdd3 = new JLabel("Storage");
		labelAdd4 = new JLabel("Amount");
		labelAdd5 = new JLabel("Price");
		labelAdd6 = new JLabel("Hsd");
		
		labelAdd7 = new JLabel("SupplierName");
		labelAdd8 = new JLabel("SupplierID");
		labelAdd9 = new JLabel("Phone");
		labelAdd10 = new JLabel("SupplierAddress");
		
		labelAdd11 = new JLabel("CategoryName");
		labelAdd12 = new JLabel("CategoryID");
		labelAdd13 = new JLabel("Description");
		
		ErrorMessage = new JLabel("");
		buttonAddsave = new JButton("Save");
		
		textfieldAdd1 = new JTextField(); // productID
		textfieldAdd2 = new JTextField(); // productName
		textfieldAdd3 = new JTextField(); // Storage
		textfieldAdd4 = new JTextField(); // Amount
		textfieldAdd5 = new JTextField(); // price
		
		panelAdd6 = new JPanel();
		choiceAdd62 = new Choice();     // thang
		choiceAdd63 = new Choice();     //nam
		
		choiceAdd7 = new Choice();
		textfieldAdd8 = new JTextField();
		textfieldAdd9 = new JTextField();
		textareaAdd10 = new TextArea();
		
		choiceAdd11 = new Choice();
		textfieldAdd12 = new JTextField();
		textareaAdd13 = new TextArea();
		
		
		//................................................
		panelProductMain = new JPanel();         //------------------->panelProductMain
		
		panelProduct1 = new JPanel();
		panelProduct2 = new JPanel();
		panelProduct3 = new JPanel();
		
		panelProduct31 = new JPanel();
		panelProduct32 = new JPanel();
		panelProduct33 = new JPanel();
		panelProduct34 = new JPanel();
		
		
		textfieldProduct1 = new JTextField();
		textfieldProduct2 = new JTextField();
		textfieldProduct3 = new JTextField();
		textfieldProduct4 = new JTextField();
		textfieldProduct5 = new JTextField();
		textfieldProduct6 = new JTextField();		
		textfieldProduct7 = new JTextField();
		textfieldProduct8 = new JTextField();
		
		
		tableProduct = new JTable(); 
		jscrollpaneProduct = new JScrollPane(tableProduct);
		tableModelProduct = new DefaultTableModel();
		
		textfieldProduct9 = new JTextField();
		textfieldProduct10 = new JTextField();
		textfieldProduct11 = new JTextField();
		textfieldProduct12 = new JTextField();
		
		textfieldProduct13 = new JTextField();
		textareaProduct14 = new TextArea();
		
		textfieldProduct15 = new JTextField();
		textareaProduct16  = new TextArea();
		
		
		labelProduct9 = new JLabel("ID");
		labelProduct10 = new JLabel("ProductName");
		labelProduct11= new JLabel("CategoryID");
		labelProduct12 = new JLabel("SupplierID");
		
		labelProduct13 = new JLabel("CategoryName");
		labelProduct14 = new JLabel("Description");
		
		labelProduct15 = new JLabel("SupplierName");
		labelProduct16 = new JLabel("SupplierAddress");
		
		labelProduct31 = new JLabel("Thông tin chi tiêt về sản phẩm");
		
		//............................................................. panelSupplierMain
		panelSupplierMain = new JPanel();
		panelSupplier1 = new JPanel();
		panelSupplier2 = new JPanel();
		panelSupplier11 = new JPanel();
		panelSupplier12 = new JPanel();
		
		labelSupplierCaption = new JLabel("Lưu trữ thông tin về nha cung cấp");
		labelSupplier1 = new JLabel("SupplierID");
		labelSupplier2 = new JLabel("SupplierName");
		labelSupplier3 = new JLabel("Phone");
		labelSupplier4 = new JLabel("SupplierAddress");
		
		textfieldSupplier1 = new JTextField();
		textfieldSupplier2 = new JTextField();
		textfieldSupplier3 = new JTextField();
		textareaSupplier = new TextArea();
		
		buttonSupplierSave = new JButton("Save");
		
		tableSupplier = new JTable();
		jscrollpaneSupplier = new JScrollPane(tableSupplier);
		tableModelSupplier = new DefaultTableModel();
		
		
		//.............................................................  panelCategoryMain
		panelCategoryMain = new JPanel();
		
		panelCategory1 = new JPanel();
		panelCategory2 = new JPanel();
		panelCategory11 = new JPanel();
		panelCategory12 = new JPanel();
		panelCategory21 = new JPanel();
		panelCategory22 = new JPanel();
		panelCategory221 = new JPanel();
		panelCategory222 = new JPanel();
		
		
		labelCategoryCaption1 = new JLabel("Lưu trữ thông tin về loại sản phẩm");
		labelCategoryCaption2 = new JLabel("Miêu tả chi tiết về sản phẩm");
		labelCategory1 = new JLabel("CategoryID");
		labelCategory2 = new JLabel("CategoryName");
		labelCategory3 = new JLabel("Description");
		labelCategory222 = new JLabel("Description");
		
		textfieldCategory1 = new JTextField();
		textfieldCategory2 = new JTextField();
		textareaCategory = new TextArea();
		textareaCategory222 = new TextArea();
		
		buttonCategorySave = new JButton("Save");
		
		tableCategory = new JTable();
		jscrollpaneCategory = new JScrollPane(tableCategory);
		tableModelCategory = new DefaultTableModel();
		
		
		//......................................................... ...> panelSaleMain
		panelSaleMain = new JPanel();
		panelSale1 = new JPanel();
		panelSale2 = new JPanel(); 
		panelSale21 = new JPanel();
		panelSale22 = new JPanel();
		
		labelSale1 = new JLabel("OrderID");
		labelSale2 = new JLabel("OrderDate");
		labelSale3 = new JLabel("CustomerID");
		labelSale4 = new JLabel("CustomerName");
		labelSale5 = new JLabel("Phone");
		labelSale6 = new JLabel("Address customer");
		labelSale7 = new JLabel("Total Money");
		
		textfieldSale1 = new JTextField();
		textfieldSale2 = new JTextField();
		textfieldSale3 = new JTextField();
		textfieldSale4 = new JTextField();
		textfieldSale5 = new JTextField();
		textareaSale6 = new TextArea();
		textfieldSale7 = new JTextField();
		
		buttonSale1 = new JButton("Tính Tiền");
		buttonSale2 = new JButton("Buy");
		
		tableSale = new JTable();
		jscrollpaneSale = new JScrollPane(tableSale);
		tableModelSale = new DefaultTableModel();
		
		
		//.................................................
		panelCustomerMain = new JPanel();     //------------------------panelCustomerMain
		panelCustomer1 = new JPanel();
		panelCustomer2 = new JPanel();
		panelCustomer3 = new JPanel();
		panelCustomer31 = new JPanel();
		panelCustomer32 = new JPanel();
		panelCustomer33 = new JPanel();
		panelCustomer331 = new JPanel();
		panelCustomer332 = new JPanel();
		
		textfieldCustomer1 = new JTextField();
		textfieldCustomer2 = new JTextField();
		textfieldCustomer3 = new JTextField();
		
		
		textfieldCustomer4 = new JTextField();
		textfieldCustomer5 = new JTextField();
		textareaCustomer6 = new TextArea();
		textfieldCustomer7 = new JTextField();
		
		labelCustomer4 = new JLabel("CustomerID");
		labelCustomer5 = new JLabel("CustomerName");
		labelCustomer6 = new JLabel("Address");
		labelCustomer7 = new JLabel("Total money");
		labelCustomer8 = new JLabel("Thông tin chi tiết khách hàng");
		
		tableCustomer1 = new JTable(dataCustomer1,columnNameCustomer1);
		jscrollpaneCustomer1 = new JScrollPane(tableCustomer1);
		
		tableCustomer2 = new JTable(dataCustomer2,columnNameCustomer2);
		jscrollpaneCustomer2 = new JScrollPane(tableCustomer2);
		
		
		
	}
	
	
	
	
//........................................set up component..............................................................	
	
	
	public void setUpComponent()   
	{
		
		//....................................      panelMain
		this.add(panelMain);
		panelMain.setLayout(new BorderLayout());
		panelMain.add(panelTagba,BorderLayout.NORTH);
		panelMain.add(panelHomeMain,BorderLayout.CENTER);
		
		
		this.setMenuBar(menubar);
		
		menubar.add(menufile);
		menubar.add(menuedit);
		
		//.......................................  paneTagba
		panelTagba.setLayout(new FlowLayout());
		
		buttonHome.addActionListener(this);
		buttonHome.setBackground(new Color(204,204,255));
		buttonHome.setPreferredSize(new Dimension(100,30));
		
		buttonAdd.addActionListener(this);
		buttonAdd.setBackground(new Color(204,255,204));
		buttonAdd.setPreferredSize(new Dimension(100,30));
		
		
		buttonProduct.addActionListener(this);
		buttonProduct.setBackground(new Color(204,255,204));
		buttonProduct.setPreferredSize(new Dimension(100,30));
		
		buttonSupplier.addActionListener(this);
		buttonSupplier.setBackground(new Color(204,255,204));
		buttonSupplier.setPreferredSize(new Dimension(100,30));
		
		buttonCategory.addActionListener(this);
		buttonCategory.setBackground(new Color(204,255,204));
		buttonCategory.setPreferredSize(new Dimension(100,30));
		
		buttonSale.addActionListener(this);
		buttonSale.setBackground(new Color(204,255,204));
		buttonSale.setPreferredSize(new Dimension(100,30));
		
		buttonCustomer.addActionListener(this);
		buttonCustomer.setBackground(new Color(204,255,204));
		buttonCustomer.setPreferredSize(new Dimension(100,30));
		
		
		panelTagba.add(buttonHome);
		panelTagba.add(buttonAdd);
		panelTagba.add(buttonProduct);
		panelTagba.add(buttonSupplier);
		panelTagba.add(buttonCategory);
		panelTagba.add(buttonSale);
		panelTagba.add(buttonCustomer);
		
		panelTagba.setPreferredSize(new Dimension(0,30));
		panelTagba.setBackground(new Color(166,163,177));       
		
		//............................................  panelHomeMain
		
		panelHomeMain.setLayout(new CardLayout());
		panelHomeMain.setBackground(new Color(123,124,109));   
		
		panelHomeMain.add(panelTrangChu);
		
		//.......................................................  panelTrangChu
		panelTrangChu.setBackground(new Color(255,204,204));
		
		
		//..............................................    panelAddMain
		panelAddMain.setBackground(new Color(170,109,89));
		
		panelAddMain.setLayout(new BorderLayout());
		
		panelAddMain.add(panelAdd1,BorderLayout.WEST);
		panelAdd1.setBackground(new Color(204,204,204));
		panelAdd1.setPreferredSize(new Dimension(430,0));
		
		panelAddMain.add(panelAdd2,BorderLayout.CENTER);
		panelAdd2.setBackground(new Color(204,204,204));
		
		panelAddMain.add(panelAdd3,BorderLayout.EAST);
		panelAdd3.setBackground(new Color(204,204,204));
		panelAdd3.setPreferredSize(new Dimension(350,0));
		
	    
		labelAdd1.setLabelFor(textfieldAdd1);
		labelAdd2.setLabelFor(textfieldAdd2);
		labelAdd3.setLabelFor(textfieldAdd3);
		labelAdd4.setLabelFor(textfieldAdd4);
		labelAdd5.setLabelFor(textfieldAdd5);
		
		labelAdd7.setLabelFor(choiceAdd7);  
		labelAdd8.setLabelFor(textfieldAdd8);
		labelAdd9.setLabelFor(textfieldAdd9);
		labelAdd10.setLabelFor(textareaAdd10);  
		
		labelAdd11.setLabelFor(choiceAdd11);
		labelAdd12.setLabelFor(textfieldAdd12);
		labelAdd13.setLabelFor(textareaAdd13);
		
		
		//
	    panelAdd1.setLayout(gb);
		textfieldAdd1.setPreferredSize(new Dimension(250,30));
		textfieldAdd1.addActionListener(this);
		
		textfieldAdd2.setPreferredSize(new Dimension(250,30));
		textfieldAdd2.addActionListener(this);
		
		textfieldAdd3.setPreferredSize(new Dimension(250,30));
		textfieldAdd3.addActionListener(this);
		
		textfieldAdd4.setPreferredSize(new Dimension(250,30));
		textfieldAdd4.addActionListener(this);
		
		textfieldAdd5.setPreferredSize(new Dimension(250,30));
		textfieldAdd5.addActionListener(this);
		
		choiceAdd62.add("THANG");
		for(int i = 1; i<=12 ;i++)
		{
			choiceAdd62.add(String.valueOf(i));
		}
		choiceAdd62.addItemListener(this);
		
		choiceAdd63.add("NAM");
		for(int i = 2000;i <= 3000; i++)
		{
			choiceAdd63.add(String.valueOf(i));
		}
		choiceAdd63.addItemListener(this);
		
		gbc.insets = new Insets(0,0,60,0);
		
		
		this.addComponentForContainer(panelAdd1,labelAdd1,0,0);
		this.addComponentForContainer(panelAdd1,textfieldAdd1,1,0);
		
		this.addComponentForContainer(panelAdd1,labelAdd2,0,1);
		this.addComponentForContainer(panelAdd1,textfieldAdd2,1,1);
		
		this.addComponentForContainer(panelAdd1,labelAdd3,0,2);
		this.addComponentForContainer(panelAdd1,textfieldAdd3,1,2);
		
		this.addComponentForContainer(panelAdd1,labelAdd4,0,3);
		this.addComponentForContainer(panelAdd1,textfieldAdd4,1,3);
		
		this.addComponentForContainer(panelAdd1,labelAdd5,0,4);
		this.addComponentForContainer(panelAdd1,textfieldAdd5,1,4);
		
		this.addComponentForContainer(panelAdd1,labelAdd6,0,5);
		this.addComponentForContainer(panelAdd1,panelAdd6,1,5);
		panelAdd6.setPreferredSize(new Dimension(250,30));
		panelAdd6.setLayout(new GridLayout(1,2));
		panelAdd6.add(choiceAdd63);
		panelAdd6.add(choiceAdd62);
		
		
		
	
		panelAdd2.setLayout(gb);
		
		choiceAdd7.setPreferredSize(new Dimension(250,30));
		choiceAdd7.addItemListener(this);
		textfieldAdd8.setPreferredSize(new Dimension(250,30));
		textfieldAdd8.setEditable(false);  // khong chinh sua truc tiep
		
		textfieldAdd9.setPreferredSize(new Dimension(250,30));
		textfieldAdd9.setEditable(false);
		
		textareaAdd10.setPreferredSize(new Dimension(250,110));
		textareaAdd10.setEditable(false);
		
		this.addComponentForContainer(panelAdd2,labelAdd7,0,0);
		this.addComponentForContainer(panelAdd2,choiceAdd7,1,0);
		
		this.addComponentForContainer(panelAdd2,labelAdd8,0,1);
		this.addComponentForContainer(panelAdd2,textfieldAdd8,1,1);
		
		this.addComponentForContainer(panelAdd2,labelAdd9,0,2);
		this.addComponentForContainer(panelAdd2,textfieldAdd9,1,2);
		
		this.addComponentForContainer(panelAdd2,labelAdd10,0,3);
		this.addComponentForContainer(panelAdd2,textareaAdd10,1,3);
		
		//
		
		
		panelAdd3.setLayout(gb);
		choiceAdd11.setPreferredSize(new Dimension(250,30));
		choiceAdd11.addItemListener(this);
		textfieldAdd12.setPreferredSize(new Dimension(250,30));
		textfieldAdd12.setEditable(false);
		
		textareaAdd13.setPreferredSize(new Dimension(250,110));
		textareaAdd13.setEditable(false);
		
		ErrorMessage.setForeground(Color.red);
		buttonAddsave.setPreferredSize(new Dimension(150,30));
		buttonAddsave.setBackground(new Color(51,255,255));
		buttonAddsave.addActionListener(this);
		
		
		this.addComponentForContainer(panelAdd3,labelAdd11,0,0);
		this.addComponentForContainer(panelAdd3,choiceAdd11,1,0);
		
		this.addComponentForContainer(panelAdd3,labelAdd12,0,1);
		this.addComponentForContainer(panelAdd3,textfieldAdd12,1,1);
		
		this.addComponentForContainer(panelAdd3,labelAdd13,0,2);
		this.addComponentForContainer(panelAdd3,textareaAdd13,1,2);
		
		
		
		this.addComponentForContainer(panelAdd3,buttonAddsave,1 ,3 );
		this.addComponentForContainer(panelAdd3,ErrorMessage,1,4);
		
		
		//................................................... panelPruductMain
		panelProductMain.setBackground(new Color(120,190,87));
		
		panelProductMain.setLayout(new BorderLayout());
		
		panelProductMain.add(panelProduct1,BorderLayout.NORTH);
		panelProduct1.setBackground(new Color(223,98,200));
		panelProduct1.setPreferredSize(new Dimension(0,30));
		
		panelProductMain.add(panelProduct2,BorderLayout.CENTER);
		panelProduct2.setBackground(new Color(100,100,188));
		
		panelProductMain.add(panelProduct3,BorderLayout.SOUTH);
		panelProduct3.setPreferredSize(new Dimension(0,330));
		
		
		panelProduct3.setLayout(new BorderLayout());
		
		panelProduct3.add(panelProduct31,BorderLayout.NORTH);
	      panelProduct31.setBackground(Color.pink);	
		  panelProduct31.setPreferredSize(new Dimension(0,30));
		
		panelProduct3.add(panelProduct32,BorderLayout.WEST);
		  panelProduct32.setBackground(new Color(204,204,204));
		  panelProduct32.setPreferredSize(new Dimension(370,0));
		  
		panelProduct3.add(panelProduct33,BorderLayout.CENTER);
		  panelProduct33.setBackground(new Color(204,204,204)); 
		
		panelProduct3.add(panelProduct34,BorderLayout.EAST);
		  panelProduct34.setBackground(new Color(204,204,204));
		  panelProduct34.setPreferredSize(new Dimension(370,300));
		  
		  
		panelProduct1.setLayout(new GridLayout(1,8));
		panelProduct1.add(textfieldProduct1);
		textfieldProduct1.addActionListener(this);
		
		panelProduct1.add(textfieldProduct2);
		textfieldProduct2.addActionListener(this);
		
		panelProduct1.add(textfieldProduct3);
		textfieldProduct3.addActionListener(this);
		
		panelProduct1.add(textfieldProduct4);
		textfieldProduct4.addActionListener(this);
		
		panelProduct1.add(textfieldProduct5);
		textfieldProduct5.addActionListener(this);
		
		panelProduct1.add(textfieldProduct6);
		panelProduct1.add(textfieldProduct7);
		panelProduct1.add(textfieldProduct8);
				
		                                           
		panelProduct2.setLayout(new BorderLayout());
		panelProduct2.add(jscrollpaneProduct,BorderLayout.CENTER);
		
		
		
		
		labelProduct9.setLabelFor(textfieldProduct9);
		labelProduct10.setLabelFor(textfieldProduct10);
		labelProduct11.setLabelFor(textfieldProduct11);
		labelProduct12.setLabelFor(textfieldProduct12);
		
		labelProduct13.setLabelFor(textfieldProduct13);
		labelProduct14.setLabelFor(textareaProduct14);
		
		labelProduct15.setLabelFor(textfieldProduct15);
		labelProduct16.setLabelFor(textareaProduct16);
		
		//
		panelProduct31.add(labelProduct31);
		
		
		//
		panelProduct32.setLayout(gb);
		
		
		gbc.insets =new Insets(0,0,20,0);
		
		textfieldProduct9.setPreferredSize(new Dimension(150,30));
		textfieldProduct10.setPreferredSize(new Dimension(150,30));
		textfieldProduct11.setPreferredSize(new Dimension(150,30));
		textfieldProduct12.setPreferredSize(new Dimension(150,30));
		
		
		
		addComponentForContainer(panelProduct32,labelProduct9,0,0);
		addComponentForContainer(panelProduct32,textfieldProduct9,1,0);
		
	    addComponentForContainer(panelProduct32,labelProduct10,0,1);
		addComponentForContainer(panelProduct32,textfieldProduct10,1,1);
		
		addComponentForContainer(panelProduct32,labelProduct11,0,2);
		addComponentForContainer(panelProduct32,textfieldProduct11,1,2);
		
		addComponentForContainer(panelProduct32,labelProduct12,0,3);
		addComponentForContainer(panelProduct32,textfieldProduct12,1,3);
		
		//
		panelProduct33.setLayout(gb);
		
		textfieldProduct13.setPreferredSize(new Dimension(150,30));
		textareaProduct14.setPreferredSize(new Dimension(150,100));
		
		addComponentForContainer(panelProduct33,labelProduct13,0,0);
		addComponentForContainer(panelProduct33,textfieldProduct13,1,0);
		
		addComponentForContainer(panelProduct33,labelProduct14,0,1);
		addComponentForContainer(panelProduct33,textareaProduct14,1,1);
		
		
		panelProduct34.setLayout(gb);
		
		textfieldProduct15.setPreferredSize(new Dimension(150,30));
		textareaProduct16.setPreferredSize(new Dimension(150,100));
		
		addComponentForContainer(panelProduct34,labelProduct15,0,0);
		addComponentForContainer(panelProduct34,textfieldProduct15,1,0);
		
		addComponentForContainer(panelProduct34,labelProduct16,0,1);
		addComponentForContainer(panelProduct34,textareaProduct16,1,1);
		
		//.............................................................panelSupplierMain
		panelSupplierMain.setLayout(new BorderLayout());
		
		panelSupplierMain.add(panelSupplier1,BorderLayout.WEST);
		
		panelSupplier1.setPreferredSize(new Dimension(370,0));
		panelSupplier1.setLayout(new BorderLayout());
		
		panelSupplier1.add(panelSupplier11,BorderLayout.NORTH);
		panelSupplier11.setPreferredSize(new Dimension(0,30));
		panelSupplier11.setBackground(Color.pink);
		panelSupplier11.add(labelSupplierCaption);
		
		panelSupplier1.add(panelSupplier12,BorderLayout.SOUTH);
		panelSupplier12.setLayout(gb);
		textfieldSupplier1.setPreferredSize(new Dimension(150,30));
		textfieldSupplier2.setPreferredSize(new Dimension(150,30));
		textfieldSupplier3.setPreferredSize(new Dimension(150,30));
		textareaSupplier.setPreferredSize(new Dimension(150,100));
		
		buttonSupplierSave.addActionListener(this);
		buttonSupplierSave.setPreferredSize(new Dimension(150,30));
		buttonSupplierSave.setBackground(new Color(51,255,255));
		
		labelSupplier1.setLabelFor(textfieldSupplier1);
		labelSupplier2.setLabelFor(textfieldSupplier2);
		labelSupplier3.setLabelFor(textfieldSupplier3);
		labelSupplier4.setLabelFor(textareaSupplier);
		
		gbc.insets = new Insets(0,0,70,0);
		
		addComponentForContainer(panelSupplier12,labelSupplier1,0,0);
		addComponentForContainer(panelSupplier12,textfieldSupplier1,1,0);
		
		addComponentForContainer(panelSupplier12,labelSupplier2,0,1);
		addComponentForContainer(panelSupplier12,textfieldSupplier2,1,1);
		
		addComponentForContainer(panelSupplier12,labelSupplier3,0,2);
		addComponentForContainer(panelSupplier12,textfieldSupplier3,1,2);
		
		addComponentForContainer(panelSupplier12,labelSupplier4,0,3);
		addComponentForContainer(panelSupplier12,textareaSupplier,1,3);
		
		addComponentForContainer(panelSupplier12,buttonSupplierSave,0,4);
		
		
		panelSupplierMain.add(panelSupplier2,BorderLayout.CENTER);
		
		panelSupplier2.setLayout(new BorderLayout());
		panelSupplier2.add(jscrollpaneSupplier,BorderLayout.CENTER);
		
		
		
		
		
		//............................................................. panelCategoryMain
		
		panelCategoryMain.setLayout(new BorderLayout());
		
		panelCategoryMain.add(panelCategory1,BorderLayout.WEST);
		
		panelCategory1.setPreferredSize(new Dimension(370,0));
		panelCategory1.setLayout(new BorderLayout());
		panelCategory1.add(panelCategory11,BorderLayout.NORTH);
		panelCategory11.setPreferredSize(new Dimension(0,30));
		panelCategory11.setBackground(Color.pink);
		panelCategory11.add(labelCategoryCaption1);
		
		panelCategory1.add(panelCategory12,BorderLayout.CENTER);
		
		panelCategory12.setLayout(gb);
		labelCategory1.setLabelFor(textfieldCategory1);
		labelCategory2.setLabelFor(textfieldCategory2);
		labelCategory3.setLabelFor(textareaCategory);
		textfieldCategory1.setPreferredSize(new Dimension(150,30));
		textfieldCategory2.setPreferredSize(new Dimension(150,30));
		textareaCategory.setPreferredSize(new Dimension(150,100));
		buttonCategorySave.setPreferredSize(new Dimension(100,30));
		buttonCategorySave.setBackground(new Color(51,255,255));
		buttonCategorySave.addActionListener(this);
		
		gbc.insets = new Insets(0,0,70,0);
		
		addComponentForContainer(panelCategory12,labelCategory1,0,0);
		addComponentForContainer(panelCategory12,textfieldCategory1,1,0);
		
		addComponentForContainer(panelCategory12,labelCategory2,0,1);
		addComponentForContainer(panelCategory12,textfieldCategory2,1,1);
		
		addComponentForContainer(panelCategory12,labelCategory3,0,2);
		addComponentForContainer(panelCategory12,textareaCategory,1,2);
		
		addComponentForContainer(panelCategory12,buttonCategorySave,0,3);
		
		panelCategoryMain.add(panelCategory2,BorderLayout.CENTER);
		panelCategory2.setLayout(new BorderLayout());
		panelCategory2.add(panelCategory21,BorderLayout.NORTH);
		panelCategory2.add(panelCategory22,BorderLayout.CENTER);
		
		panelCategory21.setPreferredSize(new Dimension(0,280));
		panelCategory21.setLayout(new BorderLayout());
		panelCategory21.add(jscrollpaneCategory);
		
		panelCategory22.setLayout(new BorderLayout());
		panelCategory22.add(panelCategory221,BorderLayout.NORTH);
		panelCategory221.add(labelCategoryCaption2);
		panelCategory221.setPreferredSize(new Dimension(0,30));
		panelCategory221.setBackground(Color.pink);
		
		panelCategory22.add(panelCategory222,BorderLayout.CENTER);
		
		panelCategory222.setLayout(gb);
		labelCategory222.setLabelFor(textareaCategory222);
		textareaCategory222.setPreferredSize(new Dimension(350,150));
		
		addComponentForContainer(panelCategory222,labelCategory222,0,0);
		addComponentForContainer(panelCategory222,textareaCategory222,1,0);
		
		
		//.............................................................panelSaleMain
		panelSaleMain.setBackground(new Color(4,189,129));
		panelSaleMain.setLayout(new BorderLayout());
		
		panelSaleMain.add(panelSale1,BorderLayout.WEST);
		panelSale1.setPreferredSize(new Dimension(370,0));
		
		panelSaleMain.add(panelSale2,BorderLayout.CENTER);
		panelSale2.setLayout(new BorderLayout());
		panelSale2.add(panelSale21,BorderLayout.NORTH);
		panelSale21.setBackground(new Color(100,100,120));
		panelSale21.setPreferredSize(new Dimension(0,450));
		
		panelSale2.add(panelSale22,BorderLayout.CENTER);
		
		
		labelSale1.setLabelFor(textfieldSale1);
		labelSale2.setLabelFor(textfieldSale2);
		labelSale3.setLabelFor(textfieldSale3);
		labelSale4.setLabelFor(textfieldSale4);
		labelSale5.setLabelFor(textfieldSale5);
		labelSale6.setLabelFor(textareaSale6);
		labelSale7.setLabelFor(textfieldSale7);
		
		
		panelSale1.setLayout(gb);
		gbc.insets = new Insets(0,0,40,0); 
		
		textfieldSale1.setPreferredSize(new Dimension(150,30));
		textfieldSale2.setPreferredSize(new Dimension(150,30));
		textfieldSale3.setPreferredSize(new Dimension(150,30));
		textfieldSale4.setPreferredSize(new Dimension(150,30));
		textfieldSale5.setPreferredSize(new Dimension(150,30));
		textareaSale6.setPreferredSize(new Dimension(150,100));
		
		this.addComponentForContainer(panelSale1, labelSale1, 0, 0);
		this.addComponentForContainer(panelSale1, textfieldSale1, 1, 0);
		
		this.addComponentForContainer(panelSale1, labelSale2, 0, 1);
		this.addComponentForContainer(panelSale1, textfieldSale2, 1, 1);
		
		this.addComponentForContainer(panelSale1, labelSale3, 0, 2);
		this.addComponentForContainer(panelSale1, textfieldSale3, 1,2 );
		
		this.addComponentForContainer(panelSale1, labelSale4, 0, 3);
		this.addComponentForContainer(panelSale1, textfieldSale4, 1, 3);
		
		this.addComponentForContainer(panelSale1, labelSale5, 0, 4);
		this.addComponentForContainer(panelSale1, textfieldSale5, 1, 4);
		
		this.addComponentForContainer(panelSale1, labelSale6, 0, 5);
		this.addComponentForContainer(panelSale1, textareaSale6, 1, 5);
		
		
		panelSale21.setLayout(new BorderLayout());
		panelSale21.add(jscrollpaneSale,BorderLayout.CENTER);
		
		
		panelSale22.setLayout(gb);
		textfieldSale7.setPreferredSize(new Dimension(200,30));
		
		buttonSale2.setPreferredSize(new Dimension(150,30));
		buttonSale2.setBackground(new Color(255,51,255));
		
	    this.addComponentForContainer(panelSale22, buttonSale1, 0, 0);
	    
		this.addComponentForContainer(panelSale22, labelSale7, 0, 1);
		this.addComponentForContainer(panelSale22, textfieldSale7, 1, 1);
		
		this.addComponentForContainer(panelSale22, buttonSale2, 0, 2);
		
		
		
		
		//.............................................................panelCustomerMain
		panelCustomerMain.setBackground(new Color(123,30,89));
		
		panelCustomerMain.setLayout(new BorderLayout());
		
		panelCustomerMain.add(panelCustomer1,BorderLayout.NORTH);
		panelCustomer1.setBackground(new Color(150,50,50));
		panelCustomer1.setPreferredSize(new Dimension(0,30));
		
		panelCustomerMain.add(panelCustomer2,BorderLayout.CENTER);
		panelCustomer2.setBackground(new Color(100,200,50));
		
		panelCustomerMain.add(panelCustomer3,BorderLayout.SOUTH);
		panelCustomer3.setPreferredSize(new Dimension(0,350));
		panelCustomer3.setLayout(new BorderLayout());
		panelCustomer3.add(panelCustomer31,BorderLayout.NORTH);
		panelCustomer31.setBackground(new Color(255,153,153));   
		panelCustomer31.setPreferredSize(new Dimension(0,30));
		
		panelCustomer3.add(panelCustomer32,BorderLayout.WEST); 
		panelCustomer32.setPreferredSize(new Dimension(350,0));
		
		panelCustomer3.add(panelCustomer33,BorderLayout.CENTER);
		panelCustomer33.setLayout(new BorderLayout());
		
		panelCustomer33.add(panelCustomer331,BorderLayout.NORTH);
		panelCustomer331.setBackground(new Color(150,130,120));
		panelCustomer331.setPreferredSize(new Dimension(0,220));
		
		panelCustomer33.add(panelCustomer332,BorderLayout.CENTER);
		
		
		labelCustomer4.setLabelFor(textfieldCustomer4);
		labelCustomer5.setLabelFor(textfieldCustomer5);
		labelCustomer6.setLabelFor(textareaCustomer6);
		labelCustomer7.setLabelFor(textfieldCustomer7);
		
		
		
		panelCustomer1.setLayout(new GridLayout(1,3));
		panelCustomer1.add(textfieldCustomer1);
		panelCustomer1.add(textfieldCustomer2);
		panelCustomer1.add(textfieldCustomer3);
		
		panelCustomer2.setLayout(new BorderLayout());
		panelCustomer2.add(jscrollpaneCustomer1,BorderLayout.CENTER);
		
		panelCustomer31.add(labelCustomer8);
		
		
		panelCustomer32.setLayout(gb);
		textfieldCustomer4.setPreferredSize(new Dimension(150,30));
		textfieldCustomer5.setPreferredSize(new Dimension(150,30));
		textareaCustomer6.setPreferredSize(new Dimension(150,100));
		
		this.addComponentForContainer(panelCustomer32,labelCustomer4 , 0, 0);
		this.addComponentForContainer(panelCustomer32, textfieldCustomer4,1 , 0);
		
		this.addComponentForContainer(panelCustomer32,labelCustomer5 , 0, 1);
		this.addComponentForContainer(panelCustomer32, textfieldCustomer5,1 , 1);
		
		this.addComponentForContainer(panelCustomer32,labelCustomer6 , 0, 2);
		this.addComponentForContainer(panelCustomer32, textareaCustomer6,1 , 2);
		
		panelCustomer331.setLayout(new BorderLayout());
		panelCustomer331.add(jscrollpaneCustomer2);
		
		
		panelCustomer332.setLayout(gb);
		textfieldCustomer7.setPreferredSize(new Dimension(250,30));
		 this.addComponentForContainer(panelCustomer332, labelCustomer7, 0,0);
		 this.addComponentForContainer(panelCustomer332, textfieldCustomer7, 1, 0);
		 
		 
		 //......................................................load database up object...................
		 
		 ResultSet resultSuppliers = connection.getResultset(sqlSupplier);
		 try {
			while( resultSuppliers.next() )
			 {
				 Suppliers temp = new Suppliers();
				 temp.setSupplierID(resultSuppliers.getInt(1));
				 temp.setSupplierName(resultSuppliers.getString(2));
				 temp.setSupplierAddress(resultSuppliers.getString(3));
				 temp.setPhone(resultSuppliers.getInt(4));
				 suppliers.add(temp);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 ResultSet resultCategories = connection.getResultset(sqlCategory);
		 
		 try {
			while(resultCategories.next())
			 {
				 Categories temp = new Categories();
				 temp.setCategoryID(resultCategories.getInt(1));
				 temp.setCategoryName(resultCategories.getString(2));
				 temp.setDescription(resultCategories.getString(3));
				 categories.add(temp);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == buttonHome)     //......................buttonHome
		{
			panelHomeMain.removeAll();
			panelHomeMain.repaint();
			panelHomeMain.add(panelTrangChu);
			panelHomeMain.revalidate();
		}
		
		
		if(ae.getSource() == buttonAdd)   //.........................buttonAdd
		{
			panelHomeMain.removeAll();
			panelHomeMain.repaint();
			panelHomeMain.add(panelAddMain);
			panelHomeMain.revalidate();
			
			connection.loadData(choiceAdd7, sqlSupplierAdd);
			connection.loadData(choiceAdd11, sqlCategoryAdd);
		}
		if(ae.getSource() == buttonAddsave)
		{
			Products product = new Products();
			int productId = 0;
			String productName;
			int categoryID=0;
			int supplierID =0;
			int storage =0;
			int amount =0;
			int price = 0;
			String hsd;			
			int count =0;
			
			ErrorMessage.setText("");
			
			
			if(textfieldAdd12.getText().equals(""))
			{
				ErrorMessage.setText("Category chua duoc chon");				
			}
			else
			{
				categoryID = Integer.parseInt(textfieldAdd12.getText());				
				count++;
			}
			
			
			if(textfieldAdd8.getText().equals(""))
			{
				ErrorMessage.setText("Supplier chua duoc chon");
			}
			else
			{
				supplierID = Integer.parseInt(textfieldAdd8.getText());
				count++;
			}
						
									
            try{
            	price = Integer.parseInt(textfieldAdd5.getText());       
            	count++;
			}catch(NumberFormatException e){
				ErrorMessage.setText("Hay nhap so vao price");				
			}
			
            try{
            	amount = Integer.parseInt(textfieldAdd4.getText());            	
            	count++;
			}catch(NumberFormatException e){
				ErrorMessage.setText("Hay nhap so vao amount");				
			}
            
            try{
				storage = Integer.parseInt(textfieldAdd3.getText());				
				count++;
			}catch(NumberFormatException e){
				ErrorMessage.setText("Hay nhap so vao storage");				
			}
            
           
            productName = textfieldAdd2.getText();
			if(productName.equals("") )
			{
				ErrorMessage.setText("Trường productName chưa được nhập");				
			}
			else
			{
			    count++;
			}
             
            try{
				productId = Integer.parseInt(textfieldAdd1.getText());
				count++;
			}catch(NumberFormatException e)
			{
				if(textfieldAdd1.getText().equals(""))
					ErrorMessage.setText("Trường productID chưa được nhập");
				else
				    ErrorMessage.setText("hãy nhập số vao productId");				
			}
            
			hsd = stringAddNam+"-"+stringAddThang+"-31";			
			
	//		sqlcommand = "Insert into products"
	//				+ "Values(" + productId + "," + "\"" +productName + "\"" + "," + categoryID + "," + supplierID + "," +storage + "," + amount + "," + price + "," + hsd + ");";
			
			if(count == 7)
			{
				product.setProductID(productId);
				product.setProductName(productName);
				product.setCategoryID(categoryID);
				product.setSupplierID(supplierID);
				product.setStorage(storage);
				product.setAmount(amount);
				product.setPrice(price);
				product.setHsd(hsd);
				
				
				connection.insertProduct(product);
			}
		}
		
		
		
		if(ae.getSource()== buttonProduct)  //....................................... buttonProduct
		{
			panelHomeMain.removeAll();
			panelHomeMain.repaint();
			panelHomeMain.add(panelProductMain);
			panelHomeMain.revalidate();
			
			connection.loadData(tableProduct, tableModelProduct,columnNameProduct,sqlProducts);  // load database up jtable
		}
		
		if(ae.getSource() == textfieldProduct1) // chua debug loi khi ma nhap vao khong co trong ban 
		{
			String str;
			String sqlcommand;
			boolean isSql = false;
			str = textfieldProduct1.getText();
			ArrayList <String> temp = connection.loadData(1, sqlProducts);
			
			for(int i= 0;i < temp.size(); i++ )
			{
				if(str.equals(temp.get(i) ) )
					isSql = true;
			}
			
			if(isSql)
			{
				sqlcommand = "SELECT p.productID, p.productName, c.categoryName, s.supplierName, p.storage, p.amount, p.price, p.hsd"
						+ " FROM products as p, categories as c, suppliers as s "
						+ "WHERE p.productID = "+str
						+ "and p.categoryID = c.categoryID and p.supplierID = s.supplierID;";
				
				connection.loadData(tableProduct, tableModelProduct,columnNameProduct,sqlcommand);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Khong tim thay");
				connection.loadData(tableProduct, tableModelProduct,columnNameProduct,sqlProducts);
			}
			
			temp.clear();
		}
		
		if(ae.getSource() == textfieldProduct2)
		{
			String str = textfieldProduct2.getText();
			String sqlcommand;
			boolean isSql = false;
			
			ArrayList <String> productName = connection.loadData(2,sqlProducts);
			for(int i= 0; i < productName.size(); i++)
			{
				if(str.equals( productName.get(i) ) )
				{
					isSql = true;
				}
			}
			if(isSql)
			{
				sqlcommand = "SELECT p.productID, p.productName, c.categoryName, s.supplierName, p.storage, p.amount, p.price, p.hsd"
						+ " FROM products as p, categories as c, suppliers as s "
						+ "WHERE p.productName = "+"\""+str+"\""
						+ " and p.categoryID = c.categoryID and p.supplierID = s.supplierID;";
				
				connection.loadData(tableProduct, tableModelProduct,columnNameProduct,sqlcommand);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Khong tim thay");
				connection.loadData(tableProduct, tableModelProduct,columnNameProduct,sqlProducts);
			}
			productName.clear();
		}
		
		if(ae.getSource() == textfieldProduct3)
		{
			String str = textfieldProduct3.getText();
			String sqlcommand;
			boolean isSql = false;
			
			ArrayList <String> categoryName = connection.loadData(3,sqlProducts);
			for(int i= 0; i < categoryName.size(); i++)
			{
				if(str.equals( categoryName.get(i) ) )
				{
					isSql = true;
				}
			}
			if(isSql)
			{
				sqlcommand = "SELECT p.productID, p.productName, c.categoryName, s.supplierName, p.storage, p.amount, p.price, p.hsd"
						+ " FROM products as p, categories as c, suppliers as s "
						+ "WHERE c.categoryName = "+"\""+str+"\""
						+ " and p.categoryID = c.categoryID and p.supplierID = s.supplierID;";
				
				connection.loadData(tableProduct, tableModelProduct,columnNameProduct,sqlcommand);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Khong tim thay");
				connection.loadData(tableProduct, tableModelProduct,columnNameProduct,sqlProducts);
			}
			categoryName.clear();
		}
			
		if(ae.getSource() == textfieldProduct4)
		{
			String str = textfieldProduct4.getText();
			String sqlcommand;
			boolean isSql = false;
			
			ArrayList <String> supplierName = connection.loadData(4,sqlProducts);
			for(int i= 0; i < supplierName.size(); i++)
			{
				if(str.equals( supplierName.get(i) ) )
				{
					isSql = true;
				}
			}
			if(isSql)
			{
				sqlcommand = "SELECT p.productID, p.productName, c.categoryName, s.supplierName, p.storage, p.amount, p.price, p.hsd"
						+ " FROM products as p, categories as c, suppliers as s "
						+ "WHERE s.supplierName = "+"\""+str+"\""
						+ " and p.categoryID = c.categoryID and p.supplierID = s.supplierID;";
				
				connection.loadData(tableProduct, tableModelProduct,columnNameProduct,sqlcommand);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Khong tim thay");
				connection.loadData(tableProduct, tableModelProduct,columnNameProduct,sqlProducts);
			}
			supplierName.clear();
		}
		
		if(ae.getSource() == textfieldProduct5)
		{
			String str = textfieldProduct5.getText();
			String sqlcommand;
			boolean isSql = false;
			
			ArrayList <String> storage = connection.loadData(5,sqlProducts);
			for(int i= 0; i < storage.size(); i++)
			{
				if(str.equals( storage.get(i) ) )
				{
					isSql = true;
				}
			}
			if(isSql)
			{
				sqlcommand = "SELECT p.productID, p.productName, c.categoryName, s.supplierName, p.storage, p.amount, p.price, p.hsd"
						+ " FROM products as p, categories as c, suppliers as s "
						+ "WHERE p.storage = "+"\""+str+"\""
						+ " and p.categoryID = c.categoryID and p.supplierID = s.supplierID;";
				
				connection.loadData(tableProduct, tableModelProduct,columnNameProduct,sqlcommand);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Khong tim thay");
				connection.loadData(tableProduct, tableModelProduct,columnNameProduct,sqlProducts);
			}
			storage.clear();
		}
		
		
		
		
		if(ae.getSource() == buttonSupplier)  //.....................................buttonSupplier
		{
			panelHomeMain.removeAll();
			panelHomeMain.repaint();
			panelHomeMain.add(panelSupplierMain);
			panelHomeMain.revalidate();			
			
			connection.loadData(tableSupplier,tableModelSupplier,columnNameSupplier,sqlSupplier);
		}
		
		if(ae.getSource() == buttonSupplierSave)
		{
			Suppliers supplier = new Suppliers();
			int supplierID = 0;
			String supplierName;
			String supplierAddress;
			int phone = 0;
			
			int count = 0;
			
															
			try{
				phone = Integer.parseInt(textfieldSupplier3.getText());
				count++;
			}catch(NumberFormatException e)
			{							
					JOptionPane.showMessageDialog(null, "Nhap so cho truong Phone");		
			}
			
			supplierAddress = textareaSupplier.getText();
			if(!supplierAddress.equals(""))
			{
				count++;
			}
			
			supplierName = textfieldSupplier2.getText();
			if(!supplierName.equals(""))
			{
				count++;
			}
			
			try{
				supplierID = Integer.parseInt(textfieldSupplier1.getText());
				count++;
			}catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "Nhap so vao truong SupplierID");
			}
			
			if(count == 4)
			{
				supplier.setSupplierID(supplierID);
				supplier.setSupplierName(supplierName);
				supplier.setSupplierAddress(supplierAddress);
				supplier.setPhone(phone);
				
				connection.insertSupplier(supplier);
				
			}else
			{
				JOptionPane.showMessageDialog(null, "Chua nhap du thong tin");
			}
			
		}
		
		
		
		
		
		
		
		if(ae.getSource() == buttonCategory)  //.............................. buttonCategory
		{
			panelHomeMain.removeAll();
			panelHomeMain.repaint();
			panelHomeMain.add(panelCategoryMain);
			panelHomeMain.revalidate();
			
			connection.loadData(tableCategory, tableModelCategory, columnNameCategory, sqlCategory);
		}
		
		if(ae.getSource() == buttonCategorySave)
		{
			Categories category = new Categories();
			int categoryID = 0;
	        String categoryName;
	        String description;
			int count =0;
	        
			try{
				categoryID = Integer.parseInt(textfieldCategory1.getText());
				count++;
			}catch(NumberFormatException e)
			{
				//JOptionPane.showMessageDialog(null, "Nhap so vao categoryID");
			}
			
			
			categoryName = textfieldCategory2.getText();
			if(!categoryName.equals(""))
			{
				count++;
			}
			
	        description = textareaCategory.getText();
	        if(!description.equals(""))
	        {
	        	count++;
	        }
	        	
	        if(count == 3)
	        {
	        	category.setCategoryID(categoryID);
	        	category.setCategoryName(categoryName);
	        	category.setDescription(description);
	        	
	        	connection.insertCategories(category);
	        }
	        else
	        {
	        	JOptionPane.showMessageDialog(null, "Chua nhap du thong tin");
	        }
	        
	        
		}
		
		
		
		
		
		
		if(ae.getSource() == buttonSale)    //................................. buttonSale
		{
			panelHomeMain.removeAll();
			panelHomeMain.repaint();
			panelHomeMain.add(panelSaleMain);
			panelHomeMain.revalidate();
			
			connection.loadData(tableSale, tableModelSale,columnNameSale, sqlSale);
		}
		
		
		if(ae.getSource() == buttonCustomer)  //............................... buttonCustomer
		{
			panelHomeMain.removeAll();
			panelHomeMain.repaint();
			panelHomeMain.add(panelCustomerMain);
		}
		
	}
	//............................................................. 
	
	public void itemStateChanged(ItemEvent ie)
	{
		if(ie.getStateChange() == ItemEvent.SELECTED || ie.getStateChange() == ItemEvent.DESELECTED)
		{
			String temp = (String)ie.getItem();
			if(ie.getSource() == choiceAdd7)
			{
				for(int i = 0;i < suppliers.size(); i++)
				{
					if(temp.equals(suppliers.get(i).getSupplierName()))
					{
						textfieldAdd8.setText( String.valueOf(suppliers.get(i).getSupplierID() ) );
						textfieldAdd9.setText(String.valueOf(suppliers.get(i).getPhone() ) );
						textareaAdd10.setText(suppliers.get(i).getSupplierAddress());
					}
				}
			}
			
			if(ie.getSource() == choiceAdd11)
			{
				for(int i = 0;i < categories.size(); i++)
				{
					if(temp.equals(categories.get(i).getCategoryName() ) )
					{
						textfieldAdd12.setText(String.valueOf(categories.get(i).getCategoryID()) );
						textareaAdd13.setText(categories.get(i).getDescription());
					}
				}
			}
			
			if(ie.getSource() == choiceAdd63)
			{
				stringAddNam = (String)choiceAdd63.getSelectedItem();
				
			}
			if(ie.getSource() == choiceAdd62)
			{
				stringAddThang = (String)choiceAdd62.getSelectedItem();
			}
		}
	}
	
	
	//........................................................................ addComponent
	
	public void addComponentForContainer(Container p, Component c,int x,int y)
	{
		gbc.gridx = x;
		gbc.gridy = y;
		
		gb.setConstraints(c,gbc);
		p.add(c);
	}
	
	
	
	
	
	
}
