package com.itwill.shop.ui;

import javax.swing.JPanel;
import javax.swing.JButton;

public class MemberJoinPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public MemberJoinPanel() {
		setLayout(null);
		
		JButton btnNewButton = new JButton("가입");
		btnNewButton.setBounds(54, 342, 97, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("취소");
		btnNewButton_1.setBounds(186, 342, 97, 23);
		add(btnNewButton_1);

	}
}
