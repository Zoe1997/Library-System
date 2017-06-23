package library;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class UpdateNew extends JFrame {
	private JTable table;
	private JTextField txtISBN;
	private JTextField txtBook;
	private JTextField txtWriter;
	private JTextField txtPublish;
	private JTextField txtPlace;
	public UpdateNew() {
		setTitle("\u66F4\u65B0\u65B0\u4E66\u901A\u544A");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon.jpg"));
		setBounds(500,300,748,571);
		getContentPane().setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.3);
		splitPane.setBounds(0, 0, 732, 533);
		getContentPane().add(splitPane);
		
		final JPanel panelShow = new JPanel();
		
		splitPane.setRightComponent(panelShow);
		panelShow.setLayout(null);
		
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 488, 464);
		panelShow.add(scrollPane);
		
		
		DefaultTableModel Model = new DefaultTableModel();
		
		Model.addColumn("ISBN编号");
		Model.addColumn("书名");
		Model.addColumn("作者");
		Model.addColumn("出版社");
		Model.addColumn("藏书位置");
		Model.addColumn("到馆日期");

		try {
			      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("驱动程序加载失败！");
			}
		try { 
				Connection con = DriverManager.getConnection("jdbc:odbc:MyODBC");
			    Statement st = con.createStatement();
			    ResultSet rs = st.executeQuery("select *from 新书通告");  
			    while (rs.next())
			         {
			              Vector<String> Row = new Vector<String>();
			              Row.addElement(rs.getString(1));
			              Row.addElement(rs.getString(2));
			              Row.addElement(rs.getString(3));
			              Row.addElement(rs.getString(4));
			              Row.addElement(rs.getString(5));
			              Row.addElement(String.valueOf(rs.getDate(6)));
			              Model.addRow(Row); 
			          }
		
			        rs.close();
			        st.close();
			        con.close();
			
			   } catch (Exception ex) {
			           ex.printStackTrace();
			           System.out.println("数据库连接失败！");
			   }
		
		table = new JTable(Model);
		scrollPane.setViewportView(table);
	
		
		JButton btnReturn = new JButton("\u8FD4\u56DE");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Admin().setVisible(true);
				dispose();
			}
		});
		btnReturn.setBounds(209, 498, 93, 23);
		panelShow.add(btnReturn);
		
		JPanel panelPrint = new JPanel();
		
		splitPane.setLeftComponent(panelPrint);
		panelPrint.setLayout(null);
		
		JLabel lblISBN = new JLabel("ISBN\u7F16\u53F7");
		lblISBN.setBounds(10, 48, 62, 15);
		panelPrint.add(lblISBN);
		
		txtISBN = new JTextField();
		txtISBN.setBounds(77, 45, 130, 21);
		panelPrint.add(txtISBN);
		txtISBN.setColumns(10);
		
		JButton btnAdd = new JButton("\u6DFB\u52A0");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doAdd();
			}
		});
		btnAdd.setBounds(10, 498, 62, 23);
		panelPrint.add(btnAdd);
		
		JButton button = new JButton("\u5220\u9664");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doDelete();
			}
		});
		button.setBounds(145, 498, 62, 23);
		panelPrint.add(button);
		
		JLabel lblBook = new JLabel("\u4E66\u540D");
		lblBook.setBounds(10, 100, 54, 15);
		panelPrint.add(lblBook);
		
		JLabel lblWriter = new JLabel("\u4F5C\u8005");
		lblWriter.setBounds(10, 150, 54, 15);
		panelPrint.add(lblWriter);
		
		JLabel lblPublish = new JLabel("\u51FA\u7248\u793E");
		lblPublish.setBounds(10, 197, 54, 15);
		panelPrint.add(lblPublish);
		
		JLabel lblPlace = new JLabel("\u85CF\u4E66\u4F4D\u7F6E");
		lblPlace.setBounds(10, 244, 54, 15);
		panelPrint.add(lblPlace);
		
		txtBook = new JTextField();
		txtBook.setBounds(77, 97, 130, 21);
		panelPrint.add(txtBook);
		txtBook.setColumns(10);
		
		txtWriter = new JTextField();
		txtWriter.setBounds(77, 147, 130, 21);
		panelPrint.add(txtWriter);
		txtWriter.setColumns(10);
		
		txtPublish = new JTextField();
		txtPublish.setBounds(77, 194, 130, 21);
		panelPrint.add(txtPublish);
		txtPublish.setColumns(10);
		
		txtPlace = new JTextField();
		txtPlace.setBounds(77, 241, 130, 21);
		panelPrint.add(txtPlace);
		txtPlace.setColumns(10);
		
		JLabel lblisbn = new JLabel("\u5220\u9664\u65F6\uFF0C\u53EA\u9700\u8F93\u5165ISBN\u7F16\u53F7\u5373\u53EF");
		lblisbn.setBounds(10, 282, 197, 21);
		panelPrint.add(lblisbn);
		
		JButton btnUpdate = new JButton("\u5237\u65B0");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelShow.removeAll();
				DefaultTableModel ModelUpdate = new DefaultTableModel();
				ModelUpdate.addColumn("ISBN编号");
				ModelUpdate.addColumn("书名");
				ModelUpdate.addColumn("作者");
				ModelUpdate.addColumn("出版社");
				ModelUpdate.addColumn("藏书位置");
				ModelUpdate.addColumn("到馆日期");
				try {
					      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					} catch (Exception ex) {
						ex.printStackTrace();
						System.out.println("驱动程序加载失败！");
					}
				try { 
						Connection con = DriverManager.getConnection("jdbc:odbc:MyODBC");
					    Statement st = con.createStatement();
					    ResultSet rs = st.executeQuery("select *from 新书通告");  
					    while (rs.next())
					         {
					              Vector<String> Row = new Vector<String>();
					              Row.addElement(rs.getString(1));
					              Row.addElement(rs.getString(2));
					              Row.addElement(rs.getString(3));
					              Row.addElement(rs.getString(4));
					              Row.addElement(rs.getString(5));
					              Row.addElement(String.valueOf(rs.getDate(6)));
					              ModelUpdate.addRow(Row); 
					          }
				
					        rs.close();
					        st.close();
					        con.close();
					
					   } catch (Exception ex) {
					           ex.printStackTrace();
					           System.out.println("数据库连接失败！");
					   }
				table = new JTable(ModelUpdate);
				scrollPane.setViewportView(table);
				scrollPane.setBounds(10, 20, 488, 464);
				panelShow.add(scrollPane);
			}
		});
		btnUpdate.setBounds(77, 498, 62, 23);
		panelPrint.add(btnUpdate);
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
			String sql = "insert into 新书通告  values('"+txtISBN.getText()+"','"+txtBook.getText()+"','"+txtWriter.getText()+"','"
					+txtPublish.getText()+"','"+txtPlace.getText()+"',date())";
			
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
			String sql = "delete from 新书通告  where ISBN编号='"+txtISBN.getText()+"'";
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
