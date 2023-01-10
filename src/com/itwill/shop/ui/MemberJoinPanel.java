package com.itwill.shop.ui;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberJoinPanel extends JPanel {
	/*
	 * 프레임 참조
	 */
	ShopMainFrame frame;
	/**
	 * Create the panel.
	 */
	public MemberJoinPanel() {
		setBackground(Color.MAGENTA);
		setLayout(null);
		
		JButton btnNewButton = new JButton("인기상품");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * 버튼 누르면 화면 전환
				 */
				frame.changePanel(frame.PRODUCT_POPULAR_PANEL,null);
			}
		});
		btnNewButton.setBounds(54, 342, 97, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("제품리스트");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * 버튼 누르면 화면 전환
				 */
				frame.changePanel(frame.PRODUCT_LIST_PANEL,null);
			}
		});
		btnNewButton_1.setBounds(186, 342, 97, 23);
		add(btnNewButton_1);

	}
	public void setFrame(ShopMainFrame frame) {
		this.frame = frame;
	}
	
}
