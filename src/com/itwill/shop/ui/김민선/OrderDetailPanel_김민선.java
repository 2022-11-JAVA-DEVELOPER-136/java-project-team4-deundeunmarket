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
import javax.swing.SwingConstants;

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
	
	private JPanel orderDetailPanel;
	private JPanel orderPanel;
	private JLabel orderNoInfoLB2;
	private JLabel orderPriceInfoLB2;
	private JLabel orderPaymentInfoLB2;
	private JLabel orderNameInfoLB2;
	private JLabel orderAddressInfoLB2;

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
		
		JLabel OrderNoInfoLB = new JLabel("주문번호");
		OrderNoInfoLB.setBounds(12, 50, 56, 15);
		add(OrderNoInfoLB);
		
		JScrollPane orderScrollPanel = new JScrollPane();
		orderScrollPanel.setBounds(12, 71, 336, 282);
		add(orderScrollPanel);
		
		orderDetailPanel = new JPanel();
		orderDetailPanel.setPreferredSize(new Dimension(250, 700));
		orderScrollPanel.setViewportView(orderDetailPanel);
		/************제품패널 생성**************/
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
		orderPriceLB.setHorizontalAlignment(SwingConstants.TRAILING);
		orderPriceLB.setBounds(224, 75, 64, 15);
		orderPanel.add(orderPriceLB);
		
		JLabel orderDescLB = new JLabel("집에서 맛보는 인기 메뉴");
		orderDescLB.setBounds(98, 36, 186, 29);
		orderPanel.add(orderDescLB);
		/****************************************/
		
		JLabel orderInfoLB = new JLabel("주문정보");
		orderInfoLB.setBounds(12, 377, 56, 15);
		add(orderInfoLB);
		
		JLabel orderPriceInfoLB = new JLabel("주문금액");
		orderPriceInfoLB.setBounds(12, 408, 56, 15);
		add(orderPriceInfoLB);
		
		JLabel orderPaymentInfoLB = new JLabel("결제방법");
		orderPaymentInfoLB.setBounds(182, 408, 59, 15);
		add(orderPaymentInfoLB);
		
		JLabel orderNameInfoLB = new JLabel("받는 분");
		orderNameInfoLB.setBounds(12, 435, 50, 15);
		add(orderNameInfoLB);
		
		JLabel orderAddressInfoLB = new JLabel("주소");
		orderAddressInfoLB.setBounds(12, 460, 50, 15);
		add(orderAddressInfoLB);
		
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
		/************주문정보**************/
		orderNoInfoLB2 = new JLabel("");
		orderNoInfoLB2.setBounds(75, 50, 95, 15);
		add(orderNoInfoLB2);
		
		orderPriceInfoLB2 = new JLabel("");
		orderPriceInfoLB2.setBounds(75, 408, 95, 15);
		add(orderPriceInfoLB2);
		
		orderPaymentInfoLB2 = new JLabel("");
		orderPaymentInfoLB2.setBounds(243, 408, 85, 15);
		add(orderPaymentInfoLB2);
		
		orderNameInfoLB2 = new JLabel("");
		orderNameInfoLB2.setBounds(74, 435, 96, 15);
		add(orderNameInfoLB2);
		
		orderAddressInfoLB2 = new JLabel("");
		orderAddressInfoLB2.setBounds(75, 460, 253, 15);
		add(orderAddressInfoLB2);
		
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
		// 메소드 호출
		displayOrderDetail(6);
	}
	
	public void displayOrderDetail(int o_no) throws Exception {
		List<Order> orderList = orderService.orderList(loginMember.getM_id());
		/*
		for (Order order : orderList) {
			// orderDetailPanel.removeAll();
			orderPanel = new JPanel();
			orderPanel.setPreferredSize(new Dimension(300, 100));

			orderPanel.setLayout(null);

			JLabel orderImageLB = new JLabel("");
			orderImageLB.setIcon(new ImageIcon(OrderDetailPanel_김민선.class.getResource("/images/김치우동_작은.jpg")));
			orderImageLB.setBounds(0, 0, 86, 100);
			orderPanel.add(orderImageLB);

			JLabel orderTitleLB = new JLabel(order.getOrderItemList().get(0).getProduct().getP_name());
			orderTitleLB.setBounds(97, 10, 203, 15);
			orderPanel.add(orderTitleLB);

			JLabel orderPriceLB = new JLabel(""+order.getO_price());
			orderPriceLB.setHorizontalAlignment(SwingConstants.TRAILING);
			orderPriceLB.setBounds(224, 75, 64, 15);
			orderPanel.add(orderPriceLB);

			JLabel orderDescLB = new JLabel(order.getO_desc());
			orderDescLB.setBounds(98, 36, 186, 29);
			orderPanel.add(orderDescLB);
		}
		 */
		
		
		
	}
	/*
	 * 주문 정보 
	 */
	private void orderDetailInfo(Order order){
	
		
	}
}
