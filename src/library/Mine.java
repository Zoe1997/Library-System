package library;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

import javax.swing.JLabel;

public class Mine extends JFrame {
	private JTextField txtUser;
	private JTextField txtpwd;
	private JTextField txtRpwd;
	public Mine() {
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setBounds(500,300,358,298);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon.jpg"));
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		txtUser = new JTextField();
		txtUser.setBounds(126, 31, 153, 21);
		getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		JButton btnReturn = new JButton("\u8FD4\u56DE");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new User().setVisible(true);
			}
		});
		btnReturn.setBounds(199, 217, 93, 23);
		getContentPane().add(btnReturn);
		
		JLabel labUser = new JLabel("\u8D26\u53F7");
		labUser.setBounds(35, 34, 54, 15);
		getContentPane().add(labUser);
		
		JLabel labpwd = new JLabel("\u521D\u59CB\u5BC6\u7801");
		labpwd.setBounds(35, 81, 54, 15);
		getContentPane().add(labpwd);
		
		JLabel labRpwd = new JLabel("\u4FEE\u6539\u5BC6\u7801");
		labRpwd.setBounds(35, 138, 54, 15);
		getContentPane().add(labRpwd);
		
		JButton btnRight = new JButton("\u786E\u8BA4");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doAlter();
			}
		});
		btnRight.setBounds(59, 217, 93, 23);
		getContentPane().add(btnRight);
		
		txtpwd = new JTextField();
		txtpwd.setBounds(126, 78, 153, 21);
		getContentPane().add(txtpwd);
		txtpwd.setColumns(10);
		
		txtRpwd = new JTextField();
		txtRpwd.setBounds(126, 135, 153, 21);
		getContentPane().add(txtRpwd);
		txtRpwd.setColumns(10);
		
		
		
	}
	public void doAlter()
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
			String sql = "select * from 用户信息 where 账号='" + txtUser.getText() + " 'and 密码 = '" +txtpwd.getText()+"'";
			ResultSet rs = stmt.executeQuery(sql);   //宿主语言
			if (rs.next())
			{
				
				String s="update 用户信息 set 密码='"+txtRpwd.getText()+"' where 账号='"+txtUser.getText()+"'";
				int  rsp = stmt.executeUpdate(s);  
				if(rsp==1)
					JOptionPane.showMessageDialog(null, "修改成功！ ");
			
			}
			else
			{
				JOptionPane.showMessageDialog(null, "您输入的账号或密码不正确，请重新输入！ ", "提示 ", JOptionPane.ERROR_MESSAGE);
			}
			
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
