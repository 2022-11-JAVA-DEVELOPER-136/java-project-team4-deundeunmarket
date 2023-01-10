package com.itwill.shop.ui.김강산;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.itwill.shop.cart.Cart;
import com.itwill.shop.cart.CartService;
import com.itwill.shop.member.Member;
import com.itwill.shop.order.OrderService;
import com.itwill.shop.product.ProductService;

import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;



public class CartListPanel_김강산 extends JPanel {
	private JCheckBox cartAllCB;
	private JLabel cartTextLB;
	private JButton selectDeleteBtn;
	private JPanel finalPrice;
	private JButton order;
	private JLabel lblNewLabel_2_1;
	private JLabel baesong;
	private JLabel lblNewLabel;
	
	/*
	 * Service 멤버변수 선언
	 */
	
	 private CartService cartService;
	 private ProductService productService;
	 private OrderService orderService;
	 private Member loginMember;
	 private JPanel cartListPanel;
	 private JScrollPane cartListScrollPane;
	 private JPanel cartPanel;
	 private JButton productImgBtn;
	 private JButton exitBtn;
	 private JCheckBox cartCB;
	 private JPanel cartProductDesc2;
	 private JLabel cartProductDesc;
	 private JComboBox cartProductQty;
	 private JLabel cartProductAddPrice;
	
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	
	
	
	public CartListPanel_김강산() throws Exception {
		
	
		
		
		setLayout(null);
		
		JPanel cartscrollMain = new JPanel();
		cartscrollMain.setBounds(0, 0, 360, 540);
		add(cartscrollMain);
		cartscrollMain.setLayout(null);
		
		order = new JButton("구매하기");
		order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		order.setFont(new Font("D2Coding", Font.PLAIN, 20));
		order.setBounds(12, 478, 336, 52);
		cartscrollMain.add(order);
		
		finalPrice = new JPanel();
		finalPrice.setBounds(12, 405, 336, 75);
		cartscrollMain.add(finalPrice);
		finalPrice.setLayout(null);
		
		JLabel productTotalPriceTF = new JLabel("상품금액");
		productTotalPriceTF.setBounds(12, 10, 48, 15);
		finalPrice.add(productTotalPriceTF);
		
		JLabel baesongbiTF = new JLabel("배송비");
		baesongbiTF.setBounds(12, 27, 48, 15);
		finalPrice.add(baesongbiTF);
		
		JLabel FinalPriceTF = new JLabel("총결제금액");
		FinalPriceTF.setFont(new Font("D2Coding", Font.BOLD, 14));
		FinalPriceTF.setBounds(12, 44, 81, 23);
		finalPrice.add(FinalPriceTF);
		
		lblNewLabel = new JLabel("원");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(276, 10, 48, 15);
		finalPrice.add(lblNewLabel);
		
		baesong = new JLabel("3000원");
		baesong.setHorizontalAlignment(SwingConstants.RIGHT);
		baesong.setBounds(276, 27, 48, 15);
		finalPrice.add(baesong);
		
		lblNewLabel_2_1 = new JLabel("원");
		lblNewLabel_2_1.setFont(new Font("D2Coding", Font.PLAIN, 14));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setBounds(243, 44, 81, 19);
		finalPrice.add(lblNewLabel_2_1);
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(null);
		northPanel.setBounds(0, 0, 360, 75);
		cartscrollMain.add(northPanel);
		
		cartAllCB = new JCheckBox("전체선택");
		cartAllCB.setBounds(8, 46, 115, 23);
		northPanel.add(cartAllCB);
		
		cartTextLB = new JLabel("장바구니");
		cartTextLB.setHorizontalAlignment(SwingConstants.CENTER);
		cartTextLB.setFont(new Font("D2Coding", Font.PLAIN, 25));
		cartTextLB.setBounds(104, 10, 134, 48);
		northPanel.add(cartTextLB);
		
		selectDeleteBtn = new JButton("선택삭제");
		selectDeleteBtn.setBounds(251, 42, 97, 23);
		northPanel.add(selectDeleteBtn);
		
		cartListScrollPane = new JScrollPane();
		cartListScrollPane.setBounds(0, 85, 354, 310);
		cartscrollMain.add(cartListScrollPane);
		
		cartListPanel = new JPanel();
		cartListPanel.setPreferredSize(new Dimension(10, 500));
		cartListScrollPane.setViewportView(cartListPanel);
		/****************cart panel******************/
		cartPanel = new JPanel();
		cartPanel.setPreferredSize(new Dimension(320, 130));
		cartPanel.setLayout(null);
		
		productImgBtn = new JButton("");
		productImgBtn.setIcon(new ImageIcon(CartListPanel_김강산.class.getResource("/images/떡볶이_작은.jpg")));
		productImgBtn.setBackground(Color.WHITE);
		productImgBtn.setBounds(19, 10, 97, 65);
		cartPanel.add(productImgBtn);
		
		exitBtn = new JButton("X");
		exitBtn.setFont(new Font("D2Coding", Font.BOLD, 10));
		exitBtn.setBounds(280, 0, 40, 40);
		cartPanel.add(exitBtn);
		
		cartCB = new JCheckBox("");
		cartCB.setBounds(-4, 30, 21, 23);
		cartPanel.add(cartCB);
		
		cartProductDesc = new JLabel();
		cartProductDesc.setBounds(128, 4, 143, 89);
		cartPanel.add(cartProductDesc);
		
		cartProductQty = new JComboBox();
		cartProductQty.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		cartProductQty.setBounds(52, 96, 32, 23);
		cartPanel.add(cartProductQty);
		
		cartProductAddPrice = new JLabel("상품금액");
		cartProductAddPrice.setFont(new Font("D2Coding", Font.PLAIN, 14));
		cartProductAddPrice.setBounds(225, 101, 68, 15);
		cartPanel.add(cartProductAddPrice);
		
		
		
		/**********************************************/
		cartListPanel.add(cartPanel);
		
		
		
		//서비스 생성자 생성
		cartService = new CartService();
		orderService = new OrderService();
		productService = new ProductService();
		
		
		//loginMember객체생성
		
		loginMember = new Member("sy1", null, null, null, null, null, null);
		//메소드 호출
		displayCartList();
	}
	
	public void displayCartList() throws Exception {
		List<Cart> cartList= cartService.getCartItemByMemberId(loginMember.getM_id());
		cartListPanel.removeAll();
		
		for(Cart cart:cartList) {
			cartPanel = new JPanel();
			cartPanel.setPreferredSize(new Dimension(320, 130));
			cartPanel.setLayout(null);
			
			productImgBtn = new JButton("");
			productImgBtn.setIcon(new ImageIcon(CartListPanel_김강산.class.getResource(cart.getProduct().getP_image())));
			productImgBtn.setBackground(Color.WHITE);
			productImgBtn.setBounds(19, 10, 97, 65);
			cartPanel.add(productImgBtn);
			
			exitBtn = new JButton("X");
			exitBtn.setFont(new Font("D2Coding", Font.BOLD, 10));
			exitBtn.setBounds(280, 0, 40, 40);
			cartPanel.add(exitBtn);
			
			cartCB = new JCheckBox("");
			cartCB.setBounds(-4, 30, 21, 23);
			cartPanel.add(cartCB);
			
			cartProductDesc = new JLabel();
			cartProductDesc.setBounds(128, 4, 143, 89);
			cartPanel.add(cartProductDesc);
			
			cartProductQty = new JComboBox();
			cartProductQty.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
			cartProductQty.setBounds(52, 96, 32, 23);
			cartPanel.add(cartProductQty);
			
			cartProductAddPrice = new JLabel("상품금액");
			cartProductAddPrice.setFont(new Font("D2Coding", Font.PLAIN, 14));
			cartProductAddPrice.setBounds(225, 101, 68, 15);
			cartPanel.add(cartProductAddPrice);
			
			cartListPanel.add(cartPanel);
			
			/*******************/
			cartProductDesc.setText(cart.getProduct().getP_name()+"\n"+cart.getProduct().getP_desc());
			
		}
	}
	
	
}
