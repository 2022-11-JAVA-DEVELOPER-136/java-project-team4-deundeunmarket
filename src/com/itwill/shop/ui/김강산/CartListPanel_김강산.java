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

import javafx.scene.control.ComboBox;

import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
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
	private JButton orderBtn;
	private JLabel finalCartListTotalLB;
	private JLabel baesongLB;
	private JLabel cartListTotalLB;
	private JPanel cartListPanel;
	private JScrollPane cartListScrollPane;
	private JPanel cartPanel;
	private JButton productImgBtn;
	private JButton exitBtn;
	private JCheckBox cartCB;
	private JLabel cartProductDesc;
	private JLabel cartProductAddPrice;
	/*
	 * Service 멤버변수 선언
	 */


	private CartService cartService;
	private ProductService productService;
	private OrderService orderService;
	private Member loginMember;

	/**
	 * Create the panel.
	 * 
	 * @throws Exception
	 */

	// ****************카트리스트패널만들기******************

	public CartListPanel_김강산() throws Exception {

		setLayout(null);

		JPanel cartscrollMain = new JPanel();
		cartscrollMain.setBounds(0, 0, 360, 540);
		add(cartscrollMain);
		cartscrollMain.setLayout(null);

		orderBtn = new JButton("구매하기");
		orderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 오더창으로 넘어가기
			}
		});
		orderBtn.setFont(new Font("D2Coding", Font.PLAIN, 20));
		orderBtn.setBounds(12, 478, 336, 52);
		cartscrollMain.add(orderBtn);

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

		cartListTotalLB = new JLabel("100000원");
		cartListTotalLB.setHorizontalAlignment(SwingConstants.RIGHT);
		cartListTotalLB.setBounds(264, 10, 60, 15);
		cartListTotalLB.setText(addCartListTotal()+"원"); 
		finalPrice.add(cartListTotalLB);

		baesongLB = new JLabel("3000원");
		baesongLB.setHorizontalAlignment(SwingConstants.RIGHT);
		baesongLB.setBounds(276, 27, 48, 15);
		finalPrice.add(baesongLB);

		finalCartListTotalLB = new JLabel("103000원");
		finalCartListTotalLB.setFont(new Font("D2Coding", Font.PLAIN, 14));
		finalCartListTotalLB.setHorizontalAlignment(SwingConstants.RIGHT);
		finalCartListTotalLB.setBounds(243, 44, 81, 19);
		finalCartListTotalLB.setText(finalCartListTotal()+"원");
		finalPrice.add(finalCartListTotalLB);

		JPanel northPanel = new JPanel();
		northPanel.setLayout(null);
		northPanel.setBounds(0, 0, 360, 75);
		cartscrollMain.add(northPanel);

		cartAllCB = new JCheckBox("전체선택");
		cartAllCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartCB.doClick();
			}
		});
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
		
		/**************** cart panel ******************/
		
		cartPanel = new JPanel();
		cartPanel.setPreferredSize(new Dimension(320, 130));
		cartPanel.setLayout(null);

		productImgBtn = new JButton("");
		productImgBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 상세보기 추가
			}
		});
		productImgBtn.setIcon(new ImageIcon(CartListPanel_김강산.class.getResource("/images/떡볶이_작은.jpg")));
		productImgBtn.setBackground(Color.WHITE);
		productImgBtn.setBounds(19, 10, 97, 65);
		cartPanel.add(productImgBtn);

		exitBtn = new JButton("");
		exitBtn.setIcon(new ImageIcon(CartListPanel_김강산.class.getResource("/images/close10.png")));
		exitBtn.setFont(new Font("D2Coding", Font.BOLD, 10));
		exitBtn.setBounds(292, 10, 16, 15);
		cartPanel.add(exitBtn);

		cartCB = new JCheckBox("");
		cartCB.setBounds(-4, 30, 21, 23);
		cartPanel.add(cartCB);

		cartProductDesc = new JLabel();
		cartProductDesc.setBounds(128, 4, 143, 89);
		cartPanel.add(cartProductDesc);

		cartProductAddPrice = new JLabel("상품금액");
		cartProductAddPrice.setFont(new Font("D2Coding", Font.PLAIN, 14));
		cartProductAddPrice.setBounds(225, 101, 68, 15);
		cartPanel.add(cartProductAddPrice);

		JComboBox productQty = new JComboBox();
		productQty.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
		productQty.setBounds(52, 97, 32, 23);
		cartPanel.add(productQty);

		/**********************************************/
		cartListPanel.add(cartPanel);

		// 서비스 생성자 생성
		cartService = new CartService();
		orderService = new OrderService();
		productService = new ProductService();

		// loginMember객체생성

		loginMember = new Member("sy1", null, null, null, null, null, null);
		// 메소드 호출
		displayCartList();
		
	}
	JCheckBox[] cartCBArray=null;
	public void displayCartList() throws Exception {
		List<Cart> cartList = cartService.getCartItemByMemberId(loginMember.getM_id());
		cartListPanel.removeAll();
		cartCBArray = new JCheckBox[cartList.size()];
		for (int i=0;i< cartList.size();i++) {
			Cart cart=cartList.get(i);
			cartPanel = new JPanel();
			cartPanel.setPreferredSize(new Dimension(320, 130));
			cartPanel.setLayout(null);

			productImgBtn = new JButton("");
			productImgBtn.setIcon(new ImageIcon(CartListPanel_김강산.class.getResource(cart.getProduct().getP_image())));
			productImgBtn.setBackground(Color.WHITE);
			productImgBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 상품 상세보기 추가
				}
			});
			productImgBtn.setBounds(19, 10, 97, 65);
			cartPanel.add(productImgBtn);

			exitBtn = new JButton("");
			exitBtn.setIcon(new ImageIcon(CartListPanel_김강산.class.getResource("/images/close10.png")));
			exitBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						cartService.deleteCartItemByCartNo(cart.getCart_no());
						cartListPanel.remove(cart.getCart_no());
					} catch (Exception e1) {
						e1.getMessage();
					}
				}
			});
			exitBtn.setFont(new Font("D2Coding", Font.BOLD, 10));
			exitBtn.setBounds(292, 10, 16, 15);
			cartPanel.add(exitBtn);

			cartCB = new JCheckBox("");
			cartCB.setBounds(-4, 30, 21, 23);
			cartCB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			cartPanel.add(cartCB);
			
			cartCBArray[i]=cartCB;
			
			cartProductDesc = new JLabel();
			cartProductDesc.setBounds(128, 4, 143, 89);
			cartPanel.add(cartProductDesc);

			cartProductAddPrice = new JLabel("상품금액");
			cartProductAddPrice.setFont(new Font("D2Coding", Font.PLAIN, 14));
			cartProductAddPrice.setBounds(225, 101, 68, 15);
			cartPanel.add(cartProductAddPrice);

			JComboBox productQty = new JComboBox();
			productQty.setBounds(52, 97, 32, 23);
			productQty.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9",
					"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
			cartPanel.add(productQty);
			productQty.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange()==ItemEvent.SELECTED) {
						try {
							String qty = (String) productQty.getSelectedItem();
							int iqty = Integer.parseInt(qty);
							cart.setCart_qty(iqty);
							cartService.updateCart(cart);
							cartListTotalLB.setText(addCartListTotal()+"원");
							finalCartListTotalLB.setText(finalCartListTotal()+"원");
							cartProductAddPrice.setText(new DecimalFormat("0,000").format(cartService.addCartTotal(cart.getCart_no())));
							//productQty.setSelectedItem(String.valueOf(iqty));
						} catch (Exception e2) {
							// TODO: handle exception
							e2.printStackTrace();
						}
					}
				}
			});
			// 라벨에 추가데이터 삽입
			cartProductDesc.setText(cart.getProduct().getP_name() + "\n" + cart.getProduct().getP_desc());
			cartProductAddPrice.setText(new DecimalFormat("0,000").format(cartService.addCartTotal(cart.getCart_no())));
			

			/*******************/

			

			cartListPanel.add(cartPanel);
			
		}
		
		
	}
	//최종카트 합 메소드
	
	public String addCartListTotal() throws Exception{
		cartService = new CartService();
		return Integer.toString(cartService.addCartListTotal("sy1"));
		
	}
	
	public String finalCartListTotal() throws Exception{
		int total = 0;
		total = Integer.parseInt(this.addCartListTotal())+3000;
		return Integer.toString(total);
		
		
	}
	
}
