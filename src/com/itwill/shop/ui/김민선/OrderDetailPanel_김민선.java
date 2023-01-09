package com.itwill.shop.ui.김민선;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;

import javax.swing.JTextField;

import com.itwill.shop.cart.CartService;
import com.itwill.shop.member.Member;
import com.itwill.shop.member.MemberService;
import com.itwill.shop.order.Order;
import com.itwill.shop.order.OrderService;
import com.itwill.shop.product.ProductService;

import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderDetailPanel_김민선 extends JPanel {
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
	
	
	private JTextField orderNoTF;
	private JTextField orderPaymentInfoTF;
	private JTextField orderPriceInfoTF;
	private JTextField orderNameInfoTF;
	private JTextField orderAddressInfoTF;
	private JPanel orderDetailPanel;
	private JPanel orderPanel;

	/**
	 * Create the panel.
	 */
	public OrderDetailPanel_김민선() throws Exception{

		initGUI();
	}
	private void initGUI() throws Exception{
		setLayout(null);
		
		JLabel OrderDetailTitleLB = new JLabel("주문내역 상세");
		OrderDetailTitleLB.setFont(new Font("굴림", Font.BOLD, 18));
		OrderDetailTitleLB.setBounds(30, 10, 181, 35);
		add(OrderDetailTitleLB);
		
		JLabel OrderNoLB = new JLabel("주문번호");
		OrderNoLB.setBounds(12, 50, 56, 15);
		add(OrderNoLB);
		
		orderNoTF = new JTextField();
		orderNoTF.setEditable(false);
		orderNoTF.setBounds(74, 47, 96, 21);
		add(orderNoTF);
		orderNoTF.setColumns(10);
		
		JScrollPane orderScrollPanel = new JScrollPane();
		orderScrollPanel.setBounds(12, 75, 336, 282);
		add(orderScrollPanel);
		
		orderDetailPanel = new JPanel();
		orderDetailPanel.setPreferredSize(new Dimension(250, 700));
		orderScrollPanel.setViewportView(orderDetailPanel);
		
		orderPanel = new JPanel();
		orderPanel.setPreferredSize(new Dimension(300, 100));
		
		orderPanel.setLayout(null);
		
		JLabel orderImageLB = new JLabel("");
		orderImageLB.setIcon(new ImageIcon(OrderDetailPanel_김민선.class.getResource("/images/김치우동_작은.jpg")));
		orderImageLB.setBounds(0, 0, 86, 100);
		orderPanel.add(orderImageLB);
		
		JLabel orderTitleLB = new JLabel("[투다리] 시그니처 김치우동(2인분)");
		orderTitleLB.setBounds(97, 10, 203, 15);
		orderPanel.add(orderTitleLB);
		
		JLabel orderPriceLB = new JLabel("11900원");
		orderPriceLB.setBounds(238, 75, 50, 15);
		orderPanel.add(orderPriceLB);
		
		JLabel orderDescLB = new JLabel("집에서 맛보는 인기 메뉴");
		orderDescLB.setBounds(108, 36, 176, 15);
		orderPanel.add(orderDescLB);
		
		JLabel orderInfoLB = new JLabel("주문정보");
		orderInfoLB.setBounds(12, 377, 56, 15);
		add(orderInfoLB);
		
		orderPaymentInfoTF = new JTextField();
		orderPaymentInfoTF.setEditable(false);
		orderPaymentInfoTF.setBounds(244, 405, 84, 21);
		add(orderPaymentInfoTF);
		orderPaymentInfoTF.setColumns(10);
		
		JLabel orderPriceInfoLB = new JLabel("주문금액");
		orderPriceInfoLB.setBounds(12, 408, 56, 15);
		add(orderPriceInfoLB);
		
		orderPriceInfoTF = new JTextField();
		orderPriceInfoTF.setEditable(false);
		orderPriceInfoTF.setBounds(74, 405, 96, 21);
		add(orderPriceInfoTF);
		orderPriceInfoTF.setColumns(10);
		
		JLabel orderPaymentInfoLB = new JLabel("결제방법");
		orderPaymentInfoLB.setBounds(182, 408, 59, 15);
		add(orderPaymentInfoLB);
		
		JLabel orderNameInfoLB = new JLabel("받는 분");
		orderNameInfoLB.setBounds(12, 435, 50, 15);
		add(orderNameInfoLB);
		
		orderNameInfoTF = new JTextField();
		orderNameInfoTF.setEditable(false);
		orderNameInfoTF.setBounds(75, 432, 96, 21);
		add(orderNameInfoTF);
		orderNameInfoTF.setColumns(10);
		
		JLabel orderAddressInfoLB = new JLabel("주소");
		orderAddressInfoLB.setBounds(12, 460, 50, 15);
		add(orderAddressInfoLB);
		
		orderAddressInfoTF = new JTextField();
		orderAddressInfoTF.setEditable(false);
		orderAddressInfoTF.setBounds(75, 457, 253, 21);
		add(orderAddressInfoTF);
		orderAddressInfoTF.setColumns(10);
		
		JButton orderCancalBtn = new JButton("주문취소");
		orderCancalBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					orderService.delete(loginMember.getM_id());
					JOptionPane.showMessageDialog(null, "주문이 취소되었습니다.");
					// 메인화면으로 화면 전환
				} catch (Exception e1) {
					e1.getMessage();
				}
				
				
			}
		});
		orderCancalBtn.setBounds(108, 501, 124, 29);
		add(orderCancalBtn);
		
		orderDetailPanel.add(orderPanel);
		
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
		
		displayOrderDetail();
	}
	
	public void displayOrderDetail() throws Exception{
		List<Order> orderList = orderService.orderList(loginMember.getM_id());
		//orderDetailPanel.removeAll();
		
		for (Order order : orderList) {
			orderPanel = new JPanel();
			orderPanel.setPreferredSize(new Dimension(300, 100));
			
			orderPanel.setLayout(null);
			
			JLabel orderImageLB = new JLabel("");
			orderImageLB.setIcon(new ImageIcon(OrderDetailPanel_김민선.class.getResource("/images/김치우동_작은.jpg")));
			orderImageLB.setBounds(0, 0, 86, 100);
			orderPanel.add(orderImageLB);
			
			JLabel orderTitleLB = new JLabel("[투다리] 시그니처 김치우동(2인분)");
			orderTitleLB.setBounds(97, 10, 203, 15);
			orderPanel.add(orderTitleLB);
			
			JLabel orderPriceLB = new JLabel("11900원");
			orderPriceLB.setBounds(238, 75, 50, 15);
			orderPanel.add(orderPriceLB);
			
			JLabel orderDescLB = new JLabel("집에서 맛보는 인기 메뉴");
			orderDescLB.setBounds(108, 36, 176, 15);
			orderPanel.add(orderDescLB);
		}
	}
	/*
	 * 주문 정보 
	 */
	private void orderDetailInfo(Order order){
		//orderNoTF.setText(order.getO_no());
		orderNameInfoTF.setText(order.getO_name());
		orderAddressInfoTF.setText(order.getO_address());
		//orderPriceInfoTF.setText(order.getO_price());
		orderPaymentInfoTF.setText(order.getO_payment());
		
	}
	
	
	
}
