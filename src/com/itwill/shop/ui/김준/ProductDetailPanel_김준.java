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
import com.itwill.shop.product.Product;
import com.itwill.shop.product.ProductService;
import com.itwill.shop.ui.ShopMainFrame;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProductDetailPanel_김준 extends JPanel {
	ShopMainFrame_김준 frame;
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
	Member loginMember;
	
	
	/*
	 * Product product
	 */
	Product product;
	private JLabel imageLB;
	private JLabel nameContentLB;
	private JLabel priceContentLB;
	private JLabel detailContentLB;

	/**
	 * Create the panel.
	 */
	public ProductDetailPanel_김준() throws Exception{
		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel nameLB = new JLabel("이름");
		nameLB.setBounds(38, 265, 57, 15);
		panel_1.add(nameLB);
		
		JLabel priceLB = new JLabel("가격");
		priceLB.setBounds(38, 321, 57, 15);
		panel_1.add(priceLB);
		
		
		JLabel detailLB = new JLabel("설명");
		detailLB.setBounds(38, 368, 57, 15);
		panel_1.add(detailLB);
		
		
		JButton cartAddBtn = new JButton("담기");
		cartAddBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
						try {
							cartService.addCart(new Cart(0, 1, loginMember.getM_id(), 
									new Product(product.getP_no(), product.getP_name(), 
												product.getP_price(), product.getP_image(), 
												product.getP_desc())));
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
			});
		cartAddBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cartAddBtn.setBounds(38, 491, 97, 23);
		
		
		panel_1.add(cartAddBtn);
		
		imageLB = new JLabel("");
		imageLB.setIcon(new ImageIcon(ProductDetailPanel_김준.class.getResource("/images/떡볶이_작은.jpg")));
		imageLB.setBounds(124, 35, 107, 184);
		panel_1.add(imageLB);
		
		JButton buyBtn = new JButton("구매하기");
		buyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//order구매 화면으로 전환
			}	
		});		
		buyBtn.setBounds(192, 491, 97, 23);
		panel_1.add(buyBtn);
		
		detailContentLB = new JLabel("<html>자꾸 생각나는 매콤 달콤함<html>");
		detailContentLB.setBounds(134, 354, 155, 55);
		panel_1.add(detailContentLB);
		
		priceContentLB = new JLabel("10,000");
		priceContentLB.setBounds(134, 321, 116, 15);
		panel_1.add(priceContentLB);
		
		nameContentLB = new JLabel("<html>떡볶이<html>");
		nameContentLB.setBounds(134, 265, 97, 15);
		panel_1.add(nameContentLB);		
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

	public void setFrame(ShopMainFrame_김준 frame) {
		this.frame = frame;
	}
	
	public void displayProductDetail(Product product) {
		imageLB.setIcon(new ImageIcon(ProductDetailPanel_김준.class.getResource(product.getP_image())));
		nameContentLB.setText("<html>" + product.getP_name() + "<html>");
		detailContentLB.setText("<html>" + product.getP_desc() + "<html>");
		
		
	}
	
	
	
	
	
	
	
}	