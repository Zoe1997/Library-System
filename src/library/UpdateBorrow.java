package library;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class UpdateBorrow extends JFrame {
	private JTextField txtUser;
	private JTextField txtISBN;
	private JTextField txtBook;
	public UpdateBorrow() {
		setResizable(false);
		
		setTitle("\u6DFB\u52A0\u501F\u4E66\u8BB0\u5F55");
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon.jpg"));
		getContentPane().setLayout(null);
		setBounds(500,300,410,300);
		JLabel label = new JLabel("\u8D26\u53F7");
		label.setBounds(54, 51, 54, 15);
		getContentPane().add(label);
		
		JLabel lblIsbn = new JLabel("ISBN\u7F16\u53F7");
		lblIsbn.setBounds(54, 92, 54, 15);
		getContentPane().add(lblIsbn);
		
		JLabel label_1 = new JLabel("\u4E66\u540D");
		label_1.setBounds(54, 138, 54, 15);
		getContentPane().add(label_1);
		
		JButton btnAdd = new JButton("\u6DFB\u52A0");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doAdd();
				doAddNum();
			}
		});
		btnAdd.setBounds(84, 229, 93, 23);
		getContentPane().add(btnAdd);
		
		JButton btnReturn = new JButton("\u8FD4\u56DE");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Admin().setVisible(true);
				dispose();
			}
		});
		btnReturn.setBounds(221, 229, 93, 23);
		getContentPane().add(btnReturn);
		
		txtUser = new JTextField();
		txtUser.setBounds(155, 48, 172, 21);
		getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		txtISBN = new JTextField();
		txtISBN.setBounds(155, 92, 172, 21);
		getContentPane().add(txtISBN);
		txtISBN.setColumns(10);
		
		txtBook = new JTextField();
		txtBook.setBounds(155, 135, 172, 21);
		getContentPane().add(txtBook);
		txtBook.setColumns(10);
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
			String sql = "insert into "+txtUser.getText()+"  values('"+txtISBN.getText()+"','"+txtBook.getText()+"',date())";
			
			int rs = stmt.executeUpdate(sql);   //宿主语言
			if(rs==1)
				JOptionPane.showMessageDialog(null, "添加成功！ ");
		
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			}
	}
	public void doAddNum()
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
			String sql = "update 图书信息 set 借阅数=(借阅数)+1 where ISBN编号='"+txtISBN.getText()+"'";
			stmt.executeUpdate(sql);  
			
			stmt.close();
			con.close();
			}catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
	}
}
