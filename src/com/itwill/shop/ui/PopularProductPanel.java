package com.itwill.shop.ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itwill.shop.product.Product;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class PopularProductPanel extends JPanel {
	/*
	 * 프레임 참조
	 */
	ShopMainFrame frame;
	private JLabel productImageLB;
	private JLabel productNameLB;
	/**
	 * Create the panel.
	 */
	public PopularProductPanel() {
		setBackground(Color.ORANGE);
		setLayout(null);
		
		JButton btnNewButton = new JButton("제품리스트");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * 화면전환
				frame.changePanel(frame.PRODUCT_LIST_PANEL,null);
				 */
			}
		});
		btnNewButton.setBounds(121, 323, 97, 23);
		add(btnNewButton);
		
		productNameLB = new JLabel("상품이름");
		productNameLB.setBounds(143, 265, 57, 15);
		add(productNameLB);
		
		productImageLB = new JLabel("이미지");
		productImageLB.setIcon(new ImageIcon(PopularProductPanel.class.getResource("/images/김치우동_작은.jpg")));
		productImageLB.setBounds(72, 62, 174, 148);
		add(productImageLB);
		 
	}
	
	public void setFrame(ShopMainFrame frame) {
		this.frame = frame;
	}

	public void displayPopularProduct(Product product) {
		System.out.println("popular product"+product);
		productNameLB.setText(product.getP_name());
		productImageLB.setIcon(new ImageIcon(PopularProductPanel.class.getResource("/images/"+product.getP_image())));
	
	}
	
	
}
