package library;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class UpdateReceive extends JFrame {
	private JTextField txtISBN;
	private JTextField txtUser;
	public UpdateReceive() {
		setResizable(false);
		setTitle("\u5220\u9664\u501F\u4E66\u8BB0\u5F55");
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon.jpg"));
		getContentPane().setLayout(null);
		setBounds(500,300,410,300);
		JLabel lblIsbn = new JLabel("ISBN\u7F16\u53F7");
		lblIsbn.setBounds(68, 125, 54, 15);
		getContentPane().add(lblIsbn);
		
		txtISBN = new JTextField();
		txtISBN.setBounds(175, 122, 153, 21);
		getContentPane().add(txtISBN);
		txtISBN.setColumns(10);
		
		JButton btnDelete = new JButton("\u5220\u9664");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doDelete();
			}
		});
		btnDelete.setBounds(84, 229, 93, 23);
		getContentPane().add(btnDelete);
		
		JLabel label = new JLabel("\u8D26\u53F7");
		label.setBounds(68, 64, 54, 15);
		getContentPane().add(label);
		
		txtUser = new JTextField();
		txtUser.setBounds(175, 61, 153, 21);
		getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		JButton btnReturn = new JButton("\u8FD4\u56DE");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Admin().setVisible(true);
				dispose();
			}
		});
		btnReturn.setBounds(221, 229, 93, 23);
		getContentPane().add(btnReturn);
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
			String sql = "delete from "+txtUser.getText()+"  where ISBN编号='"+txtISBN.getText()+"'";
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
