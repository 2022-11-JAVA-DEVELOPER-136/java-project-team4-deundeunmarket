package com.itwill.shop.ui.김민선;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import com.itwill.shop.cart.CartService;
import com.itwill.shop.member.Member;
import com.itwill.shop.order.OrderService;
import com.itwill.shop.product.Product;
import com.itwill.shop.product.ProductService;

import java.awt.Font;

public class ProductListPanel_김민선 extends JPanel {
	
	/*
	 * Service 객체 선언
	 */
	private OrderService orderService;
	private ProductService productService;
	private CartService cartService;
	/*
	 * logInMember 객체 선언
	 */
	private Member loginMember = null;
	private JPanel productListPanel;

	/**
	 * Create the panel.
	 */
	public ProductListPanel_김민선() throws Exception{
		setBackground(new Color(154, 205, 50));
		setLayout(null);
		
		JScrollPane productListScrollPanel = new JScrollPane();
		productListScrollPanel.setBounds(12, 86, 333, 373);
		add(productListScrollPanel);
		
		JPanel productListPanel = new JPanel();
		productListPanel.setPreferredSize(new Dimension(10, 700));
		productListScrollPanel.setViewportView(productListPanel);
		/************제품패널 생성**************/
		JPanel productPanel = new JPanel();
		productPanel.setPreferredSize(new Dimension(300, 100));
		
		productPanel.setLayout(null);
		
		JLabel productImageLB = new JLabel("홈");
		productImageLB.setHorizontalTextPosition(SwingConstants.CENTER);
		productImageLB.setVerticalTextPosition(SwingConstants.BOTTOM);
		productImageLB.setIcon(new ImageIcon(ProductListPanel_김민선.class.getResource("/images/home 50.png")));
		productImageLB.setBounds(12, 10, 50, 80);
		productPanel.add(productImageLB);
		
		JLabel productTitleLB = new JLabel("제품이름");
		productTitleLB.setHorizontalAlignment(SwingConstants.CENTER);
		productTitleLB.setFont(new Font("굴림", Font.BOLD, 12));
		productTitleLB.setBounds(79, 10, 104, 15);
		productPanel.add(productTitleLB);
		
		JLabel productDescLB = new JLabel("<html>제품설명<br> 가격:20000원</html>");
		productDescLB.setHorizontalAlignment(SwingConstants.CENTER);
		productDescLB.setBounds(74, 35, 109, 55);
		productPanel.add(productDescLB);
		
		productListPanel.add(productPanel);
		/****************************************/
		/*
		 * Service 객체 생성
		 */
		orderService = new OrderService();
		productService = new ProductService();
		cartService = new CartService();
		/*
		 * loginMember 객체 생성
		 */
		loginMember = new Member("sy0",null,null,null,null,null,null);
		productList();
	}
		/*****************************************/
		/*************************************/
		private void productList()throws Exception {
			List<Product> productList=productService.productList();
			for(Product product:productList) {
				/************제품패널 생성**************/
				JPanel productPanel = new JPanel();
				productPanel.setPreferredSize(new Dimension(300, 100));
				
				productPanel.setLayout(null);
				
				JLabel productImageLB = new JLabel("홈");
				productImageLB.setHorizontalTextPosition(SwingConstants.CENTER);
				productImageLB.setVerticalTextPosition(SwingConstants.BOTTOM);
				productImageLB.setIcon(new ImageIcon(ProductListPanel_김민선.class.getResource("/images/home 50.png")));
				productImageLB.setBounds(12, 10, 50, 80);
				productPanel.add(productImageLB);
				
				JLabel productTitleLB = new JLabel("제품이름");
				productTitleLB.setHorizontalAlignment(SwingConstants.CENTER);
				productTitleLB.setFont(new Font("굴림", Font.BOLD, 12));
				productTitleLB.setBounds(79, 10, 104, 15);
				productPanel.add(productTitleLB);
				
				JLabel productDescLB = new JLabel("<html>제품설명<br> 가격:20000원</html>");
				productDescLB.setHorizontalAlignment(SwingConstants.CENTER);
				productDescLB.setBounds(74, 35, 109, 55);
				productPanel.add(productDescLB);
				
				productListPanel.add(productPanel);
			}
		
		
		
	}
}
