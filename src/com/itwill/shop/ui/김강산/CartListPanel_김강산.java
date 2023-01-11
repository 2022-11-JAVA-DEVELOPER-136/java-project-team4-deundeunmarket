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
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ChangeEvent;

public class CartListPanel_김강산 extends JPanel {
	private JLabel cartTextLB;
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
	private JLabel cartProductDesc;
	private JLabel cartProductAddPrice;
	/*
	 * Service 멤버변수 선언
	 */

	private CartService cartService;
	private ProductService productService;
	private OrderService orderService;
	private Member loginMember;
	private JPanel jp;

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
		productTotalPriceTF.setFont(new Font("굴림", Font.PLAIN, 12));
		productTotalPriceTF.setBounds(12, 2, 48, 25);
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
		cartListTotalLB.setText(addCartListTotal() + "원");
		finalPrice.add(cartListTotalLB);

		baesongLB = new JLabel("3000원");
		baesongLB.setHorizontalAlignment(SwingConstants.RIGHT);
		baesongLB.setBounds(276, 27, 48, 15);
		finalPrice.add(baesongLB);

		finalCartListTotalLB = new JLabel("103000원");
		finalCartListTotalLB.setFont(new Font("D2Coding", Font.PLAIN, 14));
		finalCartListTotalLB.setHorizontalAlignment(SwingConstants.RIGHT);
		finalCartListTotalLB.setBounds(243, 44, 81, 19);
		finalCartListTotalLB.setText(finalCartListTotal() + "원");
		finalPrice.add(finalCartListTotalLB);

		JPanel northPanel = new JPanel();
		northPanel.setLayout(null);
		northPanel.setBounds(0, 0, 360, 75);
		cartscrollMain.add(northPanel);

		cartTextLB = new JLabel("장바구니");
		cartTextLB.setHorizontalAlignment(SwingConstants.CENTER);
		cartTextLB.setFont(new Font("D2Coding", Font.PLAIN, 25));
		cartTextLB.setBounds(104, 10, 134, 48);
		northPanel.add(cartTextLB);
		
		allCartDelete = new JButton("전체삭제");
		allCartDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cartService.deleteCartItemByMemberId(loginMember.getM_id());
					refresh();
				} catch (Exception e1) {
					e1.getMessage();
				}
			}
		});
		allCartDelete.setBounds(257, 51, 89, 23);
		northPanel.add(allCartDelete);
		

		cartListScrollPane = new JScrollPane();
		cartListScrollPane.setBounds(0, 85, 354, 310);
		cartscrollMain.add(cartListScrollPane);

		cartListPanel = new JPanel();
		cartListPanel.setPreferredSize(new Dimension(10, 700));
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

		cartProductDesc = new JLabel();
		cartProductDesc.setFont(new Font("굴림", Font.PLAIN, 10));
		cartProductDesc.setBounds(128, 10, 192, 79);
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
		
		cartProductName = new JLabel();
		cartProductName.setBounds(128, 10, 152, 43);
		cartPanel.add(cartProductName);

		// 서비스 생성자 생성
		
		cartService = new CartService();
		orderService = new OrderService();
		productService = new ProductService();

		// loginMember객체생성

		loginMember = new Member("sy0", null, null, null, null, null, null);
		
		// 메인 메소드 호출
		displayCartList();

	}

	List<Cart> selectedCartList = null;
	JCheckBox[] cartCBArray = null;
	private JLabel cartProductName;
	private JButton F5Btn;
	private JButton allCartDelete;

		// 메인 메소드

	public void displayCartList() throws Exception {
		List<Cart> cartList = cartService.getCartItemByMemberId(loginMember.getM_id());
		cartListPanel.removeAll();
		cartCBArray = new JCheckBox[cartList.size()];

		for (int i = 0; i < cartList.size(); i++) {
			Cart cart = cartList.get(i);
			
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

			// 장바구니 1개 삭제 X버튼
			exitBtn = new JButton("");
			exitBtn.setIcon(new ImageIcon(CartListPanel_김강산.class.getResource("/images/close10.png")));
			exitBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						cartService.deleteCartItemByCartNo(cart.getCart_no());
						refresh();
//						cartPanel.remove(cartPanel);
						System.out.println("카트1개가 삭제되었습니다");
					} catch (Exception e1) {
						e1.getMessage();
					}
				}
			});
			exitBtn.setFont(new Font("D2Coding", Font.BOLD, 10));
			exitBtn.setBounds(292, 10, 16, 15);
			cartPanel.add(exitBtn);
			
			cartProductName = new JLabel();
			cartProductName.setBounds(128, 10, 152, 43);
			cartProductName.setText(cart.getProduct().getP_name());
			cartPanel.add(cartProductName);

			cartProductDesc = new JLabel();
			cartProductDesc.setFont(new Font("굴림", Font.PLAIN, 11));
			cartProductDesc.setBounds(128, 10, 192, 79);
			cartProductDesc.setText(cart.getProduct().getP_desc());
			cartPanel.add(cartProductDesc);

			cartProductAddPrice = new JLabel("상품금액");
			cartProductAddPrice.setFont(new Font("D2Coding", Font.PLAIN, 14));
			cartProductAddPrice.setBounds(225, 101, 68, 15);
			cartProductAddPrice.setText(Integer.toString(cart.getProduct().getP_price()) + "원");
			cartPanel.add(cartProductAddPrice);

			JComboBox productQty = new JComboBox();
			productQty.setBounds(52, 97, 32, 23);
			productQty.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9",
					"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
			productQty.setSelectedItem(Integer.toString(cart.getCart_qty()));
			cartPanel.add(productQty);
			productQty.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						try {
							String qty = (String) productQty.getSelectedItem();
							int iqty = Integer.parseInt(qty);
							cart.setCart_qty(iqty);
							cartService.updateCart(cart);

							cartListTotalLB.setText(addCartListTotal() + "원");
							finalCartListTotalLB.setText(finalCartListTotal() + "원");
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}
				}
			});

			cartListPanel.add(cartPanel);

			/*******************/

		}

	}

	// 메소드 내 메소드

	// 배송비 제외 카트리스트 합계

	public String addCartListTotal() throws Exception {
		loginMember = new Member("sy0", null, null, null, null, null, null);
		cartService = new CartService();
		return Integer.toString(cartService.addCartListTotal(loginMember.getM_id()));

	}

	// 배송비 제외 카트리스트 합계

	public String finalCartListTotal() throws Exception {
		int total = 0;
		total = Integer.parseInt(this.addCartListTotal()) + 3000;
		return Integer.toString(total);

	}
	
	// 삭제시 새로고침 기능 추가
	public void refresh() throws Exception {
		cartListTotalLB.setText(addCartListTotal() + "원");
		finalCartListTotalLB.setText(finalCartListTotal() + "원");
		displayCartList();
	}
}