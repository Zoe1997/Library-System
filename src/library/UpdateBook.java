package library;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateBook extends JFrame {
	private JTextField txtISBN;
	private JTextField txtBook;
	private JTextField txtWriter;
	private JTextField txtPublish;
	private JTextField txtPlace;
	private JTextField textField;
	public UpdateBook() {
		setResizable(false);
		setTitle("\u66F4\u65B0\u56FE\u4E66\u4FE1\u606F");
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon.jpg"));
		getContentPane().setLayout(null);
		setBounds(500,300,450,370);
		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);
		
		getContentPane().add(tab);
		tab.setBounds(0, 0, 453, 344);
		
		JPanel panelAdd = new JPanel();
		tab.addTab("添加图书信息",panelAdd);
		panelAdd.setLayout(null);
		
		JLabel lblISBN = new JLabel("ISBN\u7F16\u53F7");
		lblISBN.setBounds(35, 31, 54, 15);
		panelAdd.add(lblISBN);
		
		txtISBN = new JTextField();
		txtISBN.setBounds(129, 28, 207, 21);
		panelAdd.add(txtISBN);
		txtISBN.setColumns(10);
		
		JButton btnAdd = new JButton("\u6DFB\u52A0");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doAdd();
				
			}
			
		});
		btnAdd.setBounds(82, 282, 93, 23);
		panelAdd.add(btnAdd);
		
		JButton btnReturn1 = new JButton("\u8FD4\u56DE");
		btnReturn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Admin().setVisible(true);
				dispose();
			}
		});
	
		btnReturn1.setBounds(263, 282, 93, 23);
		panelAdd.add(btnReturn1);
		
		JLabel lblBook = new JLabel("\u4E66\u540D");
		lblBook.setBounds(35, 70, 54, 15);
		panelAdd.add(lblBook);
		
		txtBook = new JTextField();
		txtBook.setBounds(129, 67, 207, 21);
		panelAdd.add(txtBook);
		txtBook.setColumns(10);
		
		JLabel lblWriter = new JLabel("\u4F5C\u8005");
		lblWriter.setBounds(35, 109, 54, 15);
		panelAdd.add(lblWriter);
		
		txtWriter = new JTextField();
		txtWriter.setBounds(129, 103, 207, 21);
		panelAdd.add(txtWriter);
		txtWriter.setColumns(10);
		
		JLabel lblPublish = new JLabel("\u51FA\u7248\u793E");
		lblPublish.setBounds(35, 147, 54, 15);
		panelAdd.add(lblPublish);
		
		txtPublish = new JTextField();
		txtPublish.setBounds(129, 144, 207, 21);
		panelAdd.add(txtPublish);
		txtPublish.setColumns(10);
		
		JLabel lblPlace = new JLabel("\u85CF\u4E66\u4F4D\u7F6E");
		lblPlace.setBounds(35, 187, 54, 15);
		panelAdd.add(lblPlace);
		
		txtPlace = new JTextField();
		txtPlace.setBounds(129, 184, 207, 21);
		panelAdd.add(txtPlace);
		txtPlace.setColumns(10);
		JPanel panelDelete = new JPanel();
		tab.addTab("删除图书信息",panelDelete);
		panelDelete.setLayout(null);
		
		JLabel lblIsbn = new JLabel("ISBN\u7F16\u53F7");
		lblIsbn.setBounds(70, 83, 54, 15);
		panelDelete.add(lblIsbn);
		
		textField = new JTextField();
		textField.setBounds(168, 80, 179, 21);
		panelDelete.add(textField);
		textField.setColumns(10);
		
		JButton btnDelete = new JButton("\u5220\u9664");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doDelete();
			}
		});
		btnDelete.setBounds(102, 266, 93, 23);
		panelDelete.add(btnDelete);
		
		JButton btnReturn2 = new JButton("\u8FD4\u56DE");
		btnReturn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Admin().setVisible(true);
				dispose();
			}
			
		});
		btnReturn2.setBounds(248, 266, 93, 23);
		panelDelete.add(btnReturn2);
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
			String sql = "insert into 图书信息 values('"+txtISBN.getText()+"','"+txtBook.getText()+"','"+txtWriter.getText()+"','"
					+txtPublish.getText()+"','0','"+txtPlace.getText()+"',date())";
			
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
			String sql = "delete from 图书信息 where ISBN编号='"+textField.getText()+"'";
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
}