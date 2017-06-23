package library;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;


import java.sql.*;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Guide extends JFrame {
    private JTable tableBorrow;
    private JTable tableNew;
    private JTable tableRecommend;
	public Guide() {
		setResizable(false);
        
		// 定义表头
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		
		setTitle("\u8BFB\u4E66\u6307\u5F15");
		setBounds(300,200,724,575);
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon.jpg"));
		getContentPane().setLayout(null);
		JPanel panelBorrow=new JPanel();
		JPanel panelRecommend=new JPanel();
		JPanel panelNew=new JPanel();
		panelBorrow.setLayout(null);
		panelRecommend.setLayout(null);
		panelNew.setLayout(null);
		
		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);
		tab.add("热门借阅",panelBorrow);
		
		JButton btnReturn1 = new JButton("\u8FD4\u56DE");
		btnReturn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new User().setVisible(true);
				dispose();
			}
		});
		btnReturn1.setBounds(318, 483, 93, 23);
		panelBorrow.add(btnReturn1);
		tab.add("馆长推荐",panelRecommend);
		
		JButton btnReturn2 = new JButton("\u8FD4\u56DE");
		btnReturn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new User().setVisible(true);
				dispose();
			}
		});
		btnReturn2.setBounds(318, 483, 93, 23);
		panelRecommend.add(btnReturn2);
		tab.add("新书通告",panelNew);
		panelNew.setLayout(null);
		
		JButton btnReturn3 = new JButton("\u8FD4\u56DE");
		btnReturn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new User().setVisible(true);
				dispose();
			}
		});
		btnReturn3.setBounds(318, 483, 93, 23);
		panelNew.add(btnReturn3);
		
		JScrollPane scroBorrow = new JScrollPane();
		scroBorrow.setBounds(10, 10, 693, 463);
		panelBorrow.add(scroBorrow);
		
		
		DefaultTableModel ModelBorrow = new DefaultTableModel();
		
		ModelBorrow.addColumn("ISBN编号");
		ModelBorrow.addColumn("书名");
		ModelBorrow.addColumn("作者");
		ModelBorrow.addColumn("出版社");
		ModelBorrow.addColumn("借阅数");
		ModelBorrow.addColumn("藏书位置");
		
		try {
			      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("驱动程序加载失败！");
			}
		try { 
				Connection con = DriverManager.getConnection("jdbc:odbc:MyODBC");
			    Statement st = con.createStatement();
			    ResultSet rsb = st.executeQuery("select * from 图书信息 order by 借阅数 desc");
			    while (rsb.next())
			         {
			              Vector<String> RowB = new Vector<String>();
			              RowB.addElement(rsb.getString(1));
			              RowB.addElement(rsb.getString(2));
			              RowB.addElement(rsb.getString(3));
			              RowB.addElement(rsb.getString(4));
			              RowB.addElement(rsb.getString(5));
			              RowB.addElement(rsb.getString(6));
			                       
			              ModelBorrow.addRow(RowB); 
			          }
			        tableBorrow = new JTable();
			    	tableBorrow = new JTable(ModelBorrow);
			    	scroBorrow.setViewportView(tableBorrow);
			    	scroBorrow = new JScrollPane(); 
			        rsb.close();
			        st.close();
			        con.close();
			
			   } catch (Exception ex) {
			           ex.printStackTrace();
			           System.out.println("数据库连接失败！");
			   }
			
		JScrollPane scroRecommend = new JScrollPane();
		scroRecommend.setBounds(10, 10, 693, 463);
		panelRecommend.add(scroRecommend);
		
		DefaultTableModel ModelRecommend = new DefaultTableModel();
		
		ModelRecommend.addColumn("ISBN编号");
		ModelRecommend.addColumn("书名");
		ModelRecommend.addColumn("作者");
		ModelRecommend.addColumn("出版社");
		ModelRecommend.addColumn("藏书位置");
		try {
			      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("驱动程序加载失败！");
			}
		try { 
				Connection con = DriverManager.getConnection("jdbc:odbc:MyODBC");
			    Statement st = con.createStatement();
			    ResultSet rsr = st.executeQuery("select * from 馆长推荐");
			    while (rsr.next())
			         {
			              Vector<String> RowR = new Vector<String>();
			              RowR.addElement(rsr.getString(1));
			              RowR.addElement(rsr.getString(2));
			              RowR.addElement(rsr.getString(3));
			              RowR.addElement(rsr.getString(4));
			              RowR.addElement(rsr.getString(5));
			  
			              
			              ModelRecommend.addRow(RowR); 
			          }
			        tableRecommend = new JTable();
			    	tableRecommend = new JTable(ModelRecommend);
			    	scroRecommend.setViewportView(tableRecommend);
			    	scroRecommend = new JScrollPane(); 
			        rsr.close();
			        st.close();
			        con.close();
			
			   } catch (Exception ex) {
			           ex.printStackTrace();
			           System.out.println("数据库连接失败！");
			   } 
		 
		JScrollPane scroNew = new JScrollPane();
		scroNew.setBounds(10, 10, 693, 463);
		panelNew.add(scroNew);
		
		DefaultTableModel ModelNew = new DefaultTableModel();
		
		ModelNew.addColumn("ISBN编号");
		ModelNew.addColumn("书名");
		ModelNew.addColumn("作者");
		ModelNew.addColumn("出版社");
		ModelNew.addColumn("藏书位置");
		ModelNew.addColumn("到馆日期");
		
		try {
			      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("驱动程序加载失败！");
			}
		try { 
				Connection con = DriverManager.getConnection("jdbc:odbc:MyODBC");
			    Statement st = con.createStatement();
			    ResultSet rsn = st.executeQuery("select * from 新书通告");
			    while (rsn.next())
			         {
			              Vector<String> RowN= new Vector<String>();
			              RowN.addElement(rsn.getString(1));
			              RowN.addElement(rsn.getString(2));
			              RowN.addElement(rsn.getString(3));
			              RowN.addElement(rsn.getString(4));
			              RowN.addElement(rsn.getString(5));
			              RowN.addElement(rsn.getString(6));
			                  
			              ModelNew.addRow(RowN); 
			          }
			        tableNew = new JTable();
			    	tableNew = new JTable(ModelNew);
			    	scroNew.setViewportView(tableNew);
			    	scroNew = new JScrollPane(); 
			        rsn.close();
			        st.close();
			        con.close();
			
			   } catch (Exception ex) {
			           ex.printStackTrace();
			           System.out.println("数据库连接失败！");
			   } 	
		tab.setBounds(0, 0, 718, 546);
		getContentPane().add(tab);
		
	}
}