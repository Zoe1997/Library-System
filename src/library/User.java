package library;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.event.AncestorListener;

public class User extends JFrame
{
	static String username;
	
	public User() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		setBounds(500,300,410,360);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon.jpg"));
		getContentPane().setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setTitle("\u534E\u5357\u519C\u4E1A\u5927\u5B66\u73E0\u6C5F\u5B66\u9662\u56FE\u4E66\u9986");
		getContentPane().setForeground(Color.WHITE);//±êÇ©Ïß³ÌÊµÏÖÒÆ¶¯
		getContentPane().setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		getContentPane().setLayout(null);
		
		JButton btnSearch = new JButton("\u56FE\u4E66\u68C0\u7D22");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Search().setVisible(true);
				dispose();
			}
		});
		btnSearch.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 20));
		btnSearch.setForeground(new Color(240, 128, 128));
		btnSearch.setBackground(UIManager.getColor("Button.background"));
		btnSearch.setBounds(51, 110, 125, 38);
		getContentPane().add(btnSearch);
		
		JButton btnGuide = new JButton("\u8BFB\u4E66\u6307\u5F15");
		btnGuide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Guide().setVisible(true);
				dispose();
			}
		});
		btnGuide.setBackground(UIManager.getColor("Button.background"));
		btnGuide.setForeground(new Color(138, 43, 226));
		btnGuide.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 20));
		btnGuide.setBounds(51, 172, 125, 38);
		getContentPane().add(btnGuide);
		
		JButton btnRemind = new JButton("\u8FD8\u4E66\u63D0\u9192");
		btnRemind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Remind().setVisible(true);
				
				dispose();
			}
		});
		btnRemind.setBackground(UIManager.getColor("Button.background"));
		btnRemind.setForeground(Color.ORANGE);
		btnRemind.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 20));
		btnRemind.setBounds(226, 110, 125, 38);
		getContentPane().add(btnRemind);
		
		JButton btnMine = new JButton("\u4FEE\u6539\u5BC6\u7801");
		btnMine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Mine().setVisible(true);
				dispose();
			}
		});
		btnMine.setBackground(UIManager.getColor("Button.background"));
		btnMine.setForeground(new Color(0, 191, 255));
		btnMine.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 20));
		btnMine.setBounds(226, 172, 125, 38);
		getContentPane().add(btnMine);
		
		JLabel labhnzj = new JLabel("");
		labhnzj.setIcon(new ImageIcon("hnzj.png"));
		labhnzj.setBounds(0, 0, 392, 90);
		getContentPane().add(labhnzj);
		
		JLabel labXia = new JLabel("");
		labXia.setIcon(new ImageIcon("xia.png"));
		labXia.setBounds(0, 222, 392, 90);
		getContentPane().add(labXia);
		

	}
}


