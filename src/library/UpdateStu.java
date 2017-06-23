package library;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateStu extends JFrame {
	private JTextField txtUser;
	
	public UpdateStu() {
		setResizable(false);
		setTitle("\u66F4\u65B0\u5B66\u751F\u4FE1\u606F");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		setBounds(500,300,432,339);
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon.jpg"));
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u8D26\u53F7");
		label.setBounds(59, 89, 54, 15);
		getContentPane().add(label);
		
		txtUser = new JTextField();
		txtUser.setBounds(123, 86, 216, 21);
		getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		JButton btnAdd = new JButton("\u6DFB\u52A0");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doAdd();
				doAddTable();
			}
		});
		btnAdd.setBounds(79, 165, 93, 23);
		getContentPane().add(btnAdd);
		
		JButton btnDelete = new JButton("\u5220\u9664");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doDelete();
				doDeleteTable();
			}
		});
		btnDelete.setBounds(246, 165, 93, 23);
		getContentPane().add(btnDelete);
		
		JButton btnReturn = new JButton("\u8FD4\u56DE");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Admin().setVisible(true);
				dispose();
			}
		});
		btnReturn.setBounds(162, 248, 93, 23);
		getContentPane().add(btnReturn);
	}
	public void doAdd()
	{
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection("jdbc:odbc:MyODBC");
			Statement stmt = con.createStatement();
			String sql = "insert into 用户信息 values('"+txtUser.getText()+"','123456')";
			int rs = stmt.executeUpdate(sql);  
			
			if(rs==1)
				JOptionPane.showMessageDialog(null, "添加成功！ ");
			
			stmt.close();
			con.close();
			}catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
	}
	public void doAddTable()
	{
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection("jdbc:odbc:MyODBC");
			Statement stmt = con.createStatement();
			String sql = "create table "+txtUser.getText()+"(ISBN编号 varchar(20) primary key,书名 varchar(20),借书日期 date)";
			stmt.executeUpdate(sql);  
			
			stmt.close();
			con.close();
			}catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
	}
	public void doDelete()
	{
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		try {
			
			Connection con = DriverManager.getConnection("jdbc:odbc:MyODBC");
			Statement stmt = con.createStatement();
			String sql = "delete from 用户信息  where 账号='"+txtUser.getText()+"'";
			int rs = stmt.executeUpdate(sql);   //宿主语言
			if(rs==1)
				JOptionPane.showMessageDialog(null, "删除成功！ ");
			
			
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void doDeleteTable()
	{
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection("jdbc:odbc:MyODBC");
			Statement stmt = con.createStatement();
			String sql = "drop table "+txtUser.getText()+"";
			stmt.executeUpdate(sql);  
			
			stmt.close();
			con.close();
			}catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
	}
}
