package com.itwill.shop.ui.김민선;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductListPanel_김민선 extends JPanel {
	
	/*
	 * Service 객체 선언
	 */
	/*
	 * logInMember 객체 선언
	 */

	/**
	 * Create the panel.
	 */
	public ProductListPanel_김민선() {
		setBackground(new Color(154, 205, 50));
		setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*******처리*********/
			}
		});
		btnNewButton.setBounds(120, 181, 97, 23);
		add(btnNewButton);

	}

}
