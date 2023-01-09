package com.itwill.shop.ui.김민선;

import javax.swing.JPanel;

import com.itwill.shop.cart.CartService;
import com.itwill.shop.member.Member;
import com.itwill.shop.member.MemberService;
import com.itwill.shop.order.OrderService;
import com.itwill.shop.product.ProductService;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

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
	/**
	 * Create the panel.
	 */
	public CartListPanel_김민선() {
		setLayout(null);
		
		JScrollPane cartScrollPanel = new JScrollPane();
		cartScrollPanel.setBounds(12, 85, 336, 376);
		add(cartScrollPanel);
		
		JPanel cartListPanel = new JPanel();
		cartListPanel.setPreferredSize(new Dimension(250, 700));
		cartScrollPanel.setViewportView(cartListPanel);
		
		JPanel cartPanel = new JPanel();
		cartPanel.setPreferredSize(new Dimension(300, 100));
		cartListPanel.add(cartPanel);
		cartPanel.setLayout(null);
		
		JLabel productImageLB = new JLabel("");
		productImageLB.setHorizontalAlignment(SwingConstants.CENTER);
		productImageLB.setIcon(new ImageIcon(CartListPanel_김민선.class.getResource("/images/크림파스타.jpg")));
		productImageLB.setBounds(0, 0, 88, 100);
		cartPanel.add(productImageLB);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(100, 10, 57, 15);
		cartPanel.add(lblNewLabel);
		
		JLabel CartLB = new JLabel("장바구니");
		CartLB.setFont(new Font("굴림", Font.BOLD, 25));
		CartLB.setBounds(25, 45, 122, 30);
		add(CartLB);

	}

}
