package library;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Color;

import javax.swing.JTabbedPane;



public class Login extends JFrame {
	private JTextField txtStuID;
	private JTextField txtAdmID;
	private JTextField txtStupwd;
	private JTextField txtAdmpwd;

	public Login() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		setBounds(500,300,300,280);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon.jpg"));
		setTitle("\u767B\u9646");
		JPanel panelStu=new JPanel();
		JPanel panelAdm=new JPanel();
		panelStu.setLayout(null);
		panelAdm.setLayout(null);
		
		txtStuID = new JTextField();
		txtStuID.setBounds(90, 37, 149, 21);
		panelStu.add(txtStuID);
		txtStuID.setColumns(10);
		
		txtStupwd = new JTextField();
		txtStupwd.setBounds(90, 98, 149, 21);
		panelStu.add(txtStupwd);
		txtStupwd.setColumns(10);
		
		JLabel labStuID = new JLabel("\u8D26\u53F7");
		labStuID.setBounds(43, 40, 37, 18);
		panelStu.add(labStuID);
		
		JLabel labStupwd = new JLabel("\u5BC6\u7801");
		labStupwd.setBounds(43, 101, 54, 15);
		panelStu.add(labStupwd);
		
		JButton btnStulogin = new JButton("\u767B\u9646");
		btnStulogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				doStuLogin();
			}
		});
		btnStulogin.setBounds(119, 167, 93, 23);
		panelStu.add(btnStulogin);
		
		txtAdmID = new JTextField();
		txtAdmID.setBounds(90, 37, 149, 21);
		panelAdm.add(txtAdmID);
		txtAdmID.setColumns(10);
		
		txtAdmpwd = new JTextField();
		txtAdmpwd.setBounds(90, 98, 149, 21);
		panelAdm.add(txtAdmpwd);
		txtAdmpwd.setColumns(10);
		
		JLabel labAdmID = new JLabel("\u8D26\u53F7");
		labAdmID.setBounds(43, 40, 37, 18);
		panelAdm.add(labAdmID);
		
		JLabel labAdmpwd = new JLabel("\u5BC6\u7801");
		labAdmpwd.setBounds(43, 101, 54, 15);
		panelAdm.add(labAdmpwd);
		
		JButton btnAdmlogin = new JButton("\u767B\u9646");
		btnAdmlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				doAdmLogin();
			}
		});
		btnAdmlogin.setBounds(119, 167, 93, 23);
		panelAdm.add(btnAdmlogin);
		
		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);
		tab.add("学生登录",panelStu);
		tab.add("管理员登陆",panelAdm);
		
		
		tab.setToolTipText("");
		tab.setBounds(10, 10, 164, 23);
		getContentPane().add(tab);
	}
	
	public static void main(String[] ar)
	{
		new Login().setVisible(true);
	}
	public void doStuLogin()
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
			String sql = "select * from 用户信息 where 账号='" + txtStuID.getText() + " 'and 密码 = '" +txtStupwd.getText()+"'";
			ResultSet rs = stmt.executeQuery(sql);   //宿主语言
			if (rs.next())
			{
				new User().setVisible(true);
				User.username=txtStuID.getText();
				dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "您输入的账号或密码不正确，请重新输入！ ", "提示 ", JOptionPane.ERROR_MESSAGE);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public void doAdmLogin()
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
			String sql = "select * from 管理员信息 where 账号='" + txtAdmID.getText() + " 'and 密码 = '" +txtAdmpwd.getText()+"'";
			ResultSet rs = stmt.executeQuery(sql);   //宿主语言
			if (rs.next())
			{
				new Admin().setVisible(true);
				dispose();
			}
			else{
				JOptionPane.showMessageDialog(null, "您输入的账号或密码不正确，请重新输入！ ", "提示 ", JOptionPane.ERROR_MESSAGE);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
