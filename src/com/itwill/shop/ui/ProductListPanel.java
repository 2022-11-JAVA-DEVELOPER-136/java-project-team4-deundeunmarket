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
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.Cursor;

public class ProductListPanel extends JPanel {
	/*
	 * 프레임 참조
	 */
	ShopMainFrame frame;
	private JPanel productItemListPanel;
	private JPanel orderPanel;
	/**
	 * Create the panel.
	 */
	public ProductListPanel() throws Exception{
		setBackground(Color.RED);
		setLayout(null);
		
		JButton btnNewButton = new JButton("인기상품");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * 화면전환
				 */
				frame.changePanel(frame.PRODUCT_POPULAR_PANEL,null);
			}
		});
		btnNewButton.setBounds(113, 418, 97, 23);
		add(btnNewButton);
		
		JScrollPane productListScrollPane = new JScrollPane();
		productListScrollPane.setBounds(12, 10, 311, 388);
		add(productListScrollPane);
		
		productItemListPanel = new JPanel();
		productItemListPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		productItemListPanel.setPreferredSize(new Dimension(280, 700));
		productListScrollPane.setViewportView(productItemListPanel);
		
		/***************product item start*******************/
		orderPanel = new JPanel();
		orderPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		orderPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		orderPanel.setBackground(Color.WHITE);
		orderPanel.setLayout(null);
		orderPanel.setPreferredSize(new Dimension(250, 100));
		productItemListPanel.add(orderPanel);
		
		JLabel orderImageLB = new JLabel("");
		orderImageLB.setIcon(new ImageIcon(ProductListPanel.class.getResource("/images/김치우동_작은.jpg")));
		orderImageLB.setBounds(12, 19, 64, 71);
		orderPanel.add(orderImageLB);
		
		JLabel orderPriceLB = new JLabel("11900원");
		orderPriceLB.setHorizontalAlignment(SwingConstants.TRAILING);
		orderPriceLB.setBounds(142, 44, 64, 15);
		orderPanel.add(orderPriceLB);
		/***************product item end*******************/
	}
	
	public void setFrame(ShopMainFrame frame) {
		this.frame = frame;
	}
	
	public void productList() throws Exception{
		List<Product> productList = frame.productService.productList();
		
		productItemListPanel.removeAll();
		for(Product product : productList) {
		orderPanel = new JPanel();
		orderPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		orderPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(product);
				frame.selectProduct = product;
				frame.changePanel(frame.PRODUCT_POPULAR_PANEL,product);
			}
		});
		orderPanel.setBackground(Color.WHITE);
		orderPanel.setLayout(null);
		orderPanel.setPreferredSize(new Dimension(250, 100));
		productItemListPanel.add(orderPanel);
		
		JLabel orderImageLB = new JLabel("");
		orderImageLB.setIcon(new ImageIcon(ProductListPanel.class.getResource(product.getP_image())));
		orderImageLB.setBounds(12, 19, 64, 71);
		orderPanel.add(orderImageLB);
		
		JLabel orderPriceLB = new JLabel("11900원");
		orderPriceLB.setHorizontalAlignment(SwingConstants.TRAILING);
		orderPriceLB.setBounds(142, 44, 64, 15);
		orderPanel.add(orderPriceLB);
		
		productItemListPanel.add(orderPanel);
		}
	}
	
	
	
	
}
