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

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

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
	
	
	/*
	 * Product product
	 */
	Product product;

	/**
	 * Create the panel.
	 */
	public ProductDetailPanel_김준() throws Exception{
		setLayout(new BorderLayout(0, 0));
		/*
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
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
		PriceTextField.setBounds(134, 318, 155, 21);
		panel_1.add(PriceTextField);
		PriceTextField.setColumns(10);
		
		JLabel DeatilLB = new JLabel("설명");
		DeatilLB.setBounds(38, 368, 57, 15);
		panel_1.add(DeatilLB);
		
		DetailTextField = new JTextField();
		DetailTextField.setEditable(false);
		DetailTextField.setBounds(134, 365, 155, 58);
		panel_1.add(DetailTextField);
		DetailTextField.setColumns(10);
		
		JButton CartAddBtn = new JButton("담기");
		CartAddBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		CartAddBtn.setBounds(38, 491, 97, 23);
		CartAddBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//클릭시 주문으로 이동 or 장바구니에 담겨짐
			}
		});
		panel_1.add(CartAddBtn);
		
		JLabel ImageLabel = new JLabel("New label");
		ImageLabel.setIcon(new ImageIcon(ProductDetailPanel_김준.class.getResource("/images/떡복이_큰.jpg")));
		ImageLabel.setBounds(77, 10, 183, 234);
		panel_1.add(ImageLabel);
		
		JButton buyBtn = new JButton("구매하기");
		buyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buyBtn.setBounds(192, 491, 97, 23);
		panel_1.add(buyBtn);
		
		JComboBox producrQtyCB = new JComboBox();
		producrQtyCB.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		producrQtyCB.setBounds(134, 433, 32, 23);
		panel_1.add(producrQtyCB);
		
		JLabel lblNewLabel_1 = new JLabel("수량");
		lblNewLabel_1.setBounds(38, 437, 57, 15);
		panel_1.add(lblNewLabel_1);
		*/
		
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
		
		this.product=productService.productDetail(1);
		setProduct(product);
	}

	public void setProduct(Product product) {
		this.product = product;
		productDetail(product);
	}



	public void productDetail( Product product) {
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
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
		cartAddBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cartAddBtn.setBounds(38, 491, 97, 23);
		cartAddBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//클릭시 주문으로 이동 or 장바구니에 담겨짐
			}
		});
		panel_1.add(cartAddBtn);
		
		JLabel imageLB = new JLabel("");
		imageLB.setIcon(new ImageIcon(ProductDetailPanel_김준.class.getResource(product.getP_image())));
		imageLB.setBounds(124, 35, 107, 184);
		panel_1.add(imageLB);
		
		JButton buyBtn = new JButton("구매하기");
		buyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buyBtn.setBounds(192, 491, 97, 23);
		panel_1.add(buyBtn);
		
		JComboBox producrQtyCB = new JComboBox();
		producrQtyCB.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		producrQtyCB.setBounds(134, 433, 32, 23);
		panel_1.add(producrQtyCB);
		
		JLabel productQtyLB = new JLabel("수량");
		productQtyLB.setBounds(38, 437, 57, 15);
		panel_1.add(productQtyLB);
		
		JLabel detailContentLB = new JLabel("<html>"+ product.getP_desc() + "<html>");
		detailContentLB.setBounds(134, 368, 155, 55);
		panel_1.add(detailContentLB);
		
		JLabel priceContentLB = new JLabel("<html>"+ product.getP_price() + "<html>");
		priceContentLB.setBounds(134, 321, 116, 15);
		panel_1.add(priceContentLB);
		
		JLabel nameContentLB = new JLabel("<html>"+ product.getP_name() + "<html>");
		nameContentLB.setBounds(134, 265, 97, 15);
		panel_1.add(nameContentLB);
	}
}
