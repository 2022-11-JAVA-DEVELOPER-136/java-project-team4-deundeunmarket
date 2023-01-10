package com.itwill.shop.ui.김준;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import com.itwill.shop.cart.Cart;
import com.itwill.shop.cart.CartService;
import com.itwill.shop.member.Member;
import com.itwill.shop.member.MemberService;
import com.itwill.shop.order.OrderService;
import com.itwill.shop.product.ProductService;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductDetailPanel_김준 extends JPanel {
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
	private JTextField NameTextField;
	private JTextField PriceTextField;
	private JTextField DetailTextField;

	/**
	 * Create the panel.
	 */
	public ProductDetailPanel_김준() throws Exception{
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel ProductDetailImageLB = new JLabel("");
		ProductDetailImageLB.setHorizontalAlignment(SwingConstants.CENTER);
		ProductDetailImageLB.setIcon(new ImageIcon(ProductDetailPanel_김준.class.getResource("/images/product01.jpg")));
		panel.add(ProductDetailImageLB, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel NameLB = new JLabel("이름");
		NameLB.setBounds(38, 265, 57, 15);
		panel_1.add(NameLB);
		
		NameTextField = new JTextField();
		NameTextField.setEditable(false);
		NameTextField.setBounds(134, 262, 116, 21);
		panel_1.add(NameTextField);
		NameTextField.setColumns(10);
		
		JLabel PriceLB = new JLabel("가격");
		PriceLB.setBounds(38, 321, 57, 15);
		panel_1.add(PriceLB);
		
		PriceTextField = new JTextField();
		PriceTextField.setEditable(false);
		PriceTextField.setBounds(134, 318, 116, 21);
		panel_1.add(PriceTextField);
		PriceTextField.setColumns(10);
		
		JLabel DeatilLB = new JLabel("설명");
		DeatilLB.setBounds(38, 390, 57, 15);
		panel_1.add(DeatilLB);
		
		DetailTextField = new JTextField();
		DetailTextField.setEditable(false);
		DetailTextField.setBounds(134, 387, 116, 21);
		panel_1.add(DetailTextField);
		DetailTextField.setColumns(10);
		
		JButton CartAddBtn = new JButton("담기");
		CartAddBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		CartAddBtn.setBounds(117, 491, 97, 23);
		CartAddBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//클릭시 주문으로 이동 or 장바구니에 담겨짐
			}
		});
		panel_1.add(CartAddBtn);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ProductDetailPanel_김준.class.getResource("/images/떡복이_큰.jpg")));
		lblNewLabel.setBounds(77, 10, 183, 234);
		panel_1.add(lblNewLabel);

		
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
	}
}
