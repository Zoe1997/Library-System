package library;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Admin extends JFrame {
	public Admin() {
		setTitle("\u7BA1\u7406\u5458");
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon.jpg"));
		setBounds(500,300,340,204);
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		JButton btnStudent = new JButton("\u66F4\u65B0\u5B66\u751F\u4FE1\u606F");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateStu().setVisible(true);
				dispose();
			}
		});
		btnStudent.setBounds(23, 31, 118, 23);
		getContentPane().add(btnStudent);
		
		JButton btnBook = new JButton("\u66F4\u65B0\u56FE\u4E66\u4FE1\u606F");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateBook().setVisible(true);
				dispose();
			}
		});
		btnBook.setBounds(23, 74, 118, 23);
		getContentPane().add(btnBook);
		
		JButton btnUpateRecommend = new JButton("\u66F4\u65B0\u9986\u957F\u63A8\u8350");
		btnUpateRecommend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateRecommend().setVisible(true);
				dispose();
			}
		});
		btnUpateRecommend.setBounds(180, 31, 118, 23);
		getContentPane().add(btnUpateRecommend);
		
		JButton btnUpateNew = new JButton("\u66F4\u65B0\u65B0\u4E66\u901A\u544A");
		btnUpateNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateNew().setVisible(true);
				dispose();
			}
		});
		btnUpateNew.setBounds(180, 74, 118, 23);
		getContentPane().add(btnUpateNew);
		
		JButton btnBorrow = new JButton("\u6DFB\u52A0\u501F\u4E66\u8BB0\u5F55");
		btnBorrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateBorrow().setVisible(true);
				dispose();
			}
		});
		btnBorrow.setBounds(23, 115, 118, 23);
		getContentPane().add(btnBorrow);
		
		JButton btnReceive = new JButton("\u5220\u9664\u501F\u4E66\u8BB0\u5F55");
		btnReceive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateReceive().setVisible(true);
				dispose();
			}
		});
		btnReceive.setBounds(180, 115, 118, 23);
		getContentPane().add(btnReceive);
	}
}
