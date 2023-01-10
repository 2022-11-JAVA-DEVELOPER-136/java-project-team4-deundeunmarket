package com.itwill.shop.ui.김세영;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.itwill.shop.member.Member;
import com.itwill.shop.order.Order;
import com.itwill.shop.order.OrderItem;
import com.itwill.shop.order.OrderService;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class OrderDetailPanel_김세영 extends JPanel {
	
	/******************************/
	/*
	 * Service객체 선언
	 */
	OrderService orderService;
	
	/*
	 * loginMember객체 선언
	 */
	Member loginMember;
	/******************************/
	private JPanel orderDetailPanel;

	/**
	 * Create the panel.
	 */
	public OrderDetailPanel_김세영() throws Exception {
		
		Order order = orderService.orderDetail(loginMember.getM_id(), 1);
		
		setLayout(null);
		
		JScrollPane orderDetailScrollPane = new JScrollPane();
		orderDetailScrollPane.setBounds(12, 10, 336, 520);
		add(orderDetailScrollPane);
		
		orderDetailPanel = new JPanel();
		orderDetailPanel.setPreferredSize(new Dimension(10, 700));
		orderDetailScrollPane.setViewportView(orderDetailPanel);
		orderDetailPanel.setLayout(null);
		
		/**************주문아이템패널생성****************/
		
		JPanel orderItemPanel = new JPanel();
		orderItemPanel.setPreferredSize(new Dimension(290, 110));
		orderItemPanel.setBounds(12, 35, 293, 95);
		orderDetailPanel.add(orderItemPanel);
		orderItemPanel.setLayout(null);
		/*
		JLabel p_imageLabel = new JLabel("");
		p_imageLabel.setIcon(new ImageIcon(OrderDetailPanel_김세영.class.getResource("/images/닭도리탕_작은.jpg")));
		p_imageLabel.setBounds(12, 10, 87, 73);
		orderItemPanel.add(p_imageLabel);
		*/
		JLabel p_descLabel = new JLabel("p_desc");
		p_descLabel.setBounds(111, 18, 170, 40);
		orderItemPanel.add(p_descLabel);
		
		JLabel p_priceLabel = new JLabel("p_price");
		p_priceLabel.setBounds(111, 68, 70, 15);
		orderItemPanel.add(p_priceLabel);
		
		JLabel oi_qtyLabel = new JLabel("oi_qty");
		oi_qtyLabel.setBounds(193, 68, 57, 15);
		orderItemPanel.add(oi_qtyLabel);
		
		/******************************/
		
		JLabel o_noLabel = new JLabel("주문번호");
		o_noLabel.setBounds(12, 10, 57, 15);
		orderDetailPanel.add(o_noLabel);
		
		JLabel o_noDisplayLabel = new JLabel(""+order.getO_no());
		o_noDisplayLabel.setBounds(81, 10, 224, 15);
		orderDetailPanel.add(o_noDisplayLabel);
		
		JLabel paymentInfoLabel = new JLabel("결제정보");
		paymentInfoLabel.setBounds(12, 140, 57, 15);
		orderDetailPanel.add(paymentInfoLabel);
		
		JLabel o_priceLabel = new JLabel("주문금액");
		o_priceLabel.setBounds(12, 165, 57, 15);
		orderDetailPanel.add(o_priceLabel);
		
		JLabel o_priceDisplayLabel = new JLabel("o_price");
		o_priceDisplayLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		o_priceDisplayLabel.setBounds(81, 165, 224, 15);
		orderDetailPanel.add(o_priceDisplayLabel);
		
		JLabel o_paymentLabel = new JLabel("결제방법");
		o_paymentLabel.setBounds(12, 190, 57, 15);
		orderDetailPanel.add(o_paymentLabel);
		
		JLabel o_paymentDisplayLabel = new JLabel("o_payment");
		o_paymentDisplayLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		o_paymentDisplayLabel.setBounds(81, 190, 224, 15);
		orderDetailPanel.add(o_paymentDisplayLabel);
		
		JLabel orderInfoLabel = new JLabel("주문정보");
		orderInfoLabel.setBounds(12, 230, 57, 15);
		orderDetailPanel.add(orderInfoLabel);
		
		JLabel o_no_2Label = new JLabel("주문번호");
		o_no_2Label.setBounds(12, 255, 57, 15);
		orderDetailPanel.add(o_no_2Label);
		
		JLabel o_noDisplay2Label = new JLabel("o_no");
		o_noDisplay2Label.setHorizontalAlignment(SwingConstants.TRAILING);
		o_noDisplay2Label.setBounds(81, 255, 224, 15);
		orderDetailPanel.add(o_noDisplay2Label);
		
		JLabel m_nameLabel = new JLabel("보내는분");
		m_nameLabel.setBounds(12, 280, 57, 15);
		orderDetailPanel.add(m_nameLabel);
		
		JLabel m_nameDisplayLabel = new JLabel("m_name");
		m_nameDisplayLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		m_nameDisplayLabel.setBounds(81, 280, 224, 15);
		orderDetailPanel.add(m_nameDisplayLabel);
		
		JLabel deliveryInfoLabel = new JLabel("배송정보");
		deliveryInfoLabel.setBounds(12, 320, 57, 15);
		orderDetailPanel.add(deliveryInfoLabel);
		
		JLabel o_nameLabel = new JLabel("받는분");
		o_nameLabel.setBounds(12, 345, 57, 15);
		orderDetailPanel.add(o_nameLabel);
		
		JLabel o_nameDisplayLabel = new JLabel("o_name");
		o_nameDisplayLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		o_nameDisplayLabel.setBounds(81, 345, 224, 15);
		orderDetailPanel.add(o_nameDisplayLabel);
		
		JLabel o_addressLabel = new JLabel("주소");
		o_addressLabel.setBounds(12, 370, 57, 15);
		orderDetailPanel.add(o_addressLabel);
		
		JLabel o_addressDisplayLabel = new JLabel("o_address");
		o_addressDisplayLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		o_addressDisplayLabel.setBounds(81, 370, 224, 15);
		orderDetailPanel.add(o_addressDisplayLabel);
		
		JLabel o_locLabel = new JLabel("받는장소");
		o_locLabel.setBounds(12, 395, 57, 15);
		orderDetailPanel.add(o_locLabel);
		
		JLabel o_locDisplayLabel = new JLabel("o_loc");
		o_locDisplayLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		o_locDisplayLabel.setBounds(81, 395, 224, 15);
		orderDetailPanel.add(o_locDisplayLabel);
		
		/******************************/
		/*
		 * Service객체 생성
		 */
		orderService = new OrderService();
		
		/*
		 * loginMember객체 생성
		 */
		loginMember = new Member("sy0", null, null, null, null, null, null);
		/******************************/
		/*
		 * 메소드 사용
		 */
		
		/******************************/
	}//생성자 종료
	
	/******************************/
	/*
	 * 메소드 선언
	 */
	public void orderDetail(int o_no) throws Exception {
		Order order = orderService.orderDetail(loginMember.getM_id(), o_no);
		for (OrderItem orderItem : order.getOrderItemList()) {
			JPanel orderItemPanel = new JPanel();
			orderItemPanel.setPreferredSize(new Dimension(290, 110));
			orderItemPanel.setBounds(12, 35, 293, 95);
			orderItemPanel.setLayout(null);
			
			JLabel p_imageLabel = new JLabel("New label");
			p_imageLabel.setBounds(12, 18, 57, 57);
			orderItemPanel.add(p_imageLabel);
			
			JLabel p_descLabel = new JLabel("New label");
			p_descLabel.setBounds(81, 18, 200, 40);
			orderItemPanel.add(p_descLabel);
			
			JLabel p_priceLabel = new JLabel("New label");
			p_priceLabel.setBounds(81, 68, 100, 15);
			orderItemPanel.add(p_priceLabel);
			
			JLabel oi_qtyLabel = new JLabel("New label");
			oi_qtyLabel.setBounds(193, 68, 57, 15);
			orderItemPanel.add(oi_qtyLabel);
			
			orderDetailPanel.add(orderItemPanel);
		}
	}
}
