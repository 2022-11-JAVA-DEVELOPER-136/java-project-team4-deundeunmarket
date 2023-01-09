package com.itwill.shop.ui.김민선;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.itwill.shop.cart.Cart;
import com.itwill.shop.cart.CartService;
import com.itwill.shop.member.Member;
import com.itwill.shop.order.Order;
import com.itwill.shop.order.OrderService;
import com.itwill.shop.product.Product;
import com.itwill.shop.product.ProductService;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class OrderCreatePanel_김민선 extends JPanel {
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
	/*
	 * Create the panel.
	 */
	private JTextField addressTF;
	private JTextField orderPriceTF;
	private JTextField nameTF;
	private JComboBox orderLocCB;
	private JComboBox paymentCB;

	public OrderCreatePanel_김민선() throws Exception{
		setLayout(null);
		
		JLabel OrderNameLB = new JLabel("받으실 분");
		OrderNameLB.setBounds(49, 96, 57, 15);
		add(OrderNameLB);
		
		nameTF = new JTextField();
		nameTF.setBounds(49, 121, 136, 21);
		add(nameTF);
		nameTF.setColumns(10);
		
		JLabel OrderAddressLB = new JLabel("배송지");
		OrderAddressLB.setBounds(49, 170, 57, 15);
		add(OrderAddressLB);
		
		addressTF = new JTextField();
		addressTF.setBounds(49, 195, 257, 21);
		add(addressTF);
		addressTF.setColumns(10);
		
		JLabel OrderLocLB = new JLabel("수령장소");
		OrderLocLB.setBounds(49, 257, 57, 15);
		add(OrderLocLB);
		
		JLabel OrderPaymentLB = new JLabel("결제수단");
		OrderPaymentLB.setBounds(49, 322, 57, 15);
		add(OrderPaymentLB);
		
		paymentCB = new JComboBox();
		paymentCB.setModel(new DefaultComboBoxModel(new String[] {"카드", "계좌이체", "휴대폰"}));
		paymentCB.setBounds(170, 318, 136, 23);
		add(paymentCB);
		
		orderLocCB = new JComboBox();
		orderLocCB.setModel(new DefaultComboBoxModel(new String[] {"문 앞", "경비실", "택배함"}));
		orderLocCB.setBounds(170, 253, 136, 23);
		add(orderLocCB);
		
		JLabel OrderPriceLB = new JLabel("총 결제금액");
		OrderPriceLB.setBounds(49, 387, 87, 15);
		add(OrderPriceLB);
		
		orderPriceTF = new JTextField();
		orderPriceTF.setEnabled(false);
		orderPriceTF.setEditable(false);
		orderPriceTF.setBounds(170, 384, 136, 21);
		add(orderPriceTF);
		orderPriceTF.setColumns(10);
		
		JButton orderCreateBtn = new JButton("주문하기");
		orderCreateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					String o_name = nameTF.getText();
					String o_address = addressTF.getText();
					String o_payment = (String) paymentCB.getSelectedItem();
					String o_loc = (String) orderLocCB.getSelectedItem();
					
					Order newOrder = new Order(0, o_name, null, null, 0, o_address, o_loc, o_payment, loginMember.getM_id());
					int isCreated;
					List<Cart> findCart = cartService.getCartItemByMemberId(loginMember.getM_id());
					isCreated = orderService.orderCreate(newOrder);
					if (findCart.size() > 0 && isCreated >= 1) {
						JOptionPane.showMessageDialog(null, "주문이 완료되었습니다.");
						// 주문 성공 시 주문 상세보기 화면으로 전환
						// 주문 상세보기 화면 활성화
					} else {
						JOptionPane.showMessageDialog(null, "주문 실패");
					}
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			 
			}
		});
		orderCreateBtn.setBounds(87, 451, 176, 40);
		add(orderCreateBtn);
		/*****************************************/
		/*
		 * Service 객체 생성
		 */
		orderService = new OrderService();
		productService = new ProductService();
		cartService = new CartService();
		/*
		 * loginMember 객체 생성
		 */
		loginMember = new Member("sy1",null,null,null,null,null,null);
		/*****************************************/
	}
	
	
	
	
	
	
}
