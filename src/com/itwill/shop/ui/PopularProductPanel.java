package com.itwill.shop.ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PopularProductPanel extends JPanel {
	/*
	 * 프레임 참조
	 */
	ShopMainFrame frame;
	/**
	 * Create the panel.
	 */
	public PopularProductPanel() {
		setBackground(Color.BLUE);
		setLayout(null);
		
		JButton btnNewButton = new JButton("제품리스트");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * 화면전환
				 */
				frame.changePanel(frame.PRODUCT_LIST_PANEL);
			}
		});
		btnNewButton.setBounds(121, 323, 97, 23);
		add(btnNewButton);

	}
	
	public void setFrame(ShopMainFrame frame) {
		this.frame = frame;
	}
	
}
