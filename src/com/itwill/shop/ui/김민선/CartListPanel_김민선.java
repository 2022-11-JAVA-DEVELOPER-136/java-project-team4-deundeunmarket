package com.itwill.shop.ui.김민선;

import javax.swing.JPanel;

import com.itwill.shop.cart.Cart;
import com.itwill.shop.cart.CartService;
import com.itwill.shop.member.Member;
import com.itwill.shop.member.MemberService;
import com.itwill.shop.order.OrderService;
import com.itwill.shop.product.Product;
import com.itwill.shop.product.ProductService;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class CartListPanel_김민선 extends JPanel {
	/*
	 * Service 객체 선언
	 */
	private OrderService orderService;
	private ProductService productService;
	private CartService cartService;
	private MemberService memberService;
	/*
	 * logInMember 객체 선언
	 */
	private Member loginMember = null;
	private JPanel cartListPanel;
	/**
	 * Create the panel.
	 */
	public CartListPanel_김민선() throws Exception{
		setLayout(null);
		
		JScrollPane cartScrollPanel = new JScrollPane();
		cartScrollPanel.setBounds(12, 104, 336, 357);
		add(cartScrollPanel);
		
		JPanel cartListPanel = new JPanel();
		cartListPanel.setPreferredSize(new Dimension(250, 700));
		cartScrollPanel.setViewportView(cartListPanel);
		/************제품패널 생성**************/
		JPanel cartPanel = new JPanel();
		cartPanel.setPreferredSize(new Dimension(300, 100));
		
		cartPanel.setLayout(null);
		
		JLabel productImageLB = new JLabel("");
		productImageLB.setHorizontalAlignment(SwingConstants.CENTER);
		productImageLB.setIcon(new ImageIcon(CartListPanel_김민선.class.getResource("/images/삼선짬뽕_작은.jpg")));
		productImageLB.setBounds(0, 0, 88, 100);
		cartPanel.add(productImageLB);
		
		JLabel productTitleLB = new JLabel("[백리향] 삼선짬뽕 밀키트(2인분)");
		productTitleLB.setFont(new Font("굴림", Font.PLAIN, 12));
		productTitleLB.setBounds(100, 10, 188, 15);
		cartPanel.add(productTitleLB);
		
		JLabel productPriceLB = new JLabel("11900원");
		productPriceLB.setBounds(231, 75, 57, 15);
		cartPanel.add(productPriceLB);
		
		JLabel productDescLB = new JLabel("<html>해산물이 푸짐한<br> 백리향의 삼선짬뽕!</html>");
		productDescLB.setHorizontalAlignment(SwingConstants.LEFT);
		productDescLB.setBounds(110, 35, 187, 30);
		cartPanel.add(productDescLB);
		
		JLabel CartLB = new JLabel("장바구니");
		CartLB.setFont(new Font("굴림", Font.BOLD, 25));
		CartLB.setBounds(23, 72, 122, 30);
		add(CartLB);
		
		JButton cartOrderCreateBtn = new JButton("주문하기");
		cartOrderCreateBtn.setBounds(90, 470, 178, 40);
		add(cartOrderCreateBtn);
		
		cartListPanel.add(cartPanel);
		
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
		cartList();

	}

	private void cartList() throws Exception {
		List<Cart> cartList=cartService.getCartItemByMemberId(loginMember.getM_id());
		for(Cart cart:cartList) {
			/************제품패널 생성**************/
			JPanel cartPanel = new JPanel();
			cartPanel.setPreferredSize(new Dimension(300, 100));
			
			cartPanel.setLayout(null);
			
			JLabel productImageLB = new JLabel("");
			productImageLB.setHorizontalAlignment(SwingConstants.CENTER);
			productImageLB.setIcon(new ImageIcon(CartListPanel_김민선.class.getResource(cart.getProduct().getP_image())));
			productImageLB.setBounds(0, 0, 88, 100);
			cartPanel.add(productImageLB);
			
			JLabel lblNewLabel = new JLabel("[백리향] 삼선짬뽕 밀키트(2인분)");
			lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 12));
			lblNewLabel.setBounds(100, 10, 188, 15);
			cartPanel.add(lblNewLabel);
			
			JLabel productPriceLB = new JLabel("11900원");
			productPriceLB.setBounds(231, 75, 57, 15);
			cartPanel.add(productPriceLB);
			
			JLabel productDescLB = new JLabel("<html>해산물이 푸짐한<br> 백리향의 삼선짬뽕!</html>");
			productDescLB.setHorizontalAlignment(SwingConstants.LEFT);
			productDescLB.setBounds(110, 35, 187, 30);
			cartPanel.add(productDescLB);
			
			JLabel CartLB = new JLabel("장바구니");
			CartLB.setFont(new Font("굴림", Font.BOLD, 25));
			CartLB.setBounds(23, 72, 122, 30);
			add(CartLB);
			
			JButton cartOrderCreateBtn = new JButton("주문하기");
			cartOrderCreateBtn.setBounds(90, 470, 178, 40);
			add(cartOrderCreateBtn);
			
			
			cartListPanel.add(cartPanel);
		}
	}
}
