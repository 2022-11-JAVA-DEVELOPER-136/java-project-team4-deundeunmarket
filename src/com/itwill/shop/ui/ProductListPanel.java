package com.itwill.shop.ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.ImageIcon;

public class ProductListPanel extends JPanel {
	/*
	 * 프레임 참조
	 */
	ShopMainFrame frame;
	/**
	 * Create the panel.
	 */
	public ProductListPanel() {
		setBackground(Color.RED);
		setLayout(null);
		
		JButton btnNewButton = new JButton("인기상품");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * 화면전환
				 */
				frame.changePanel(frame.PRODUCT_POPULAR_PANEL);
			}
		});
		btnNewButton.setBounds(113, 418, 97, 23);
		add(btnNewButton);
		
		JScrollPane productListScrollPane = new JScrollPane();
		productListScrollPane.setBounds(12, 10, 311, 388);
		add(productListScrollPane);
		
		JPanel productItemListPanel = new JPanel();
		productItemListPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		productItemListPanel.setPreferredSize(new Dimension(280, 700));
		productListScrollPane.setViewportView(productItemListPanel);
		
		JPanel orderPanel = new JPanel();
		orderPanel.setLayout(null);
		orderPanel.setPreferredSize(new Dimension(250, 100));
		productItemListPanel.add(orderPanel);
		
		JLabel orderImageLB = new JLabel("");
		orderImageLB.setIcon(new ImageIcon(ProductListPanel.class.getResource("/images/김치우동_작은.jpg")));
		orderImageLB.setBounds(0, 29, 64, 71);
		orderPanel.add(orderImageLB);
		
		JLabel orderTitleLB = new JLabel("[투다리] 시그니처 김치우동(2인분)");
		orderTitleLB.setBounds(55, 10, 203, 15);
		orderPanel.add(orderTitleLB);
		
		JLabel orderPriceLB = new JLabel("11900원");
		orderPriceLB.setHorizontalAlignment(SwingConstants.TRAILING);
		orderPriceLB.setBounds(182, 75, 64, 15);
		orderPanel.add(orderPriceLB);
		
		JLabel orderDescLB = new JLabel("집에서 맛보는 인기 메뉴");
		orderDescLB.setBounds(96, 36, 186, 29);
		orderPanel.add(orderDescLB);

	}
	
	public void setFrame(ShopMainFrame frame) {
		this.frame = frame;
	}
}
