package com.itwill.shop.ui.김세영;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.itwill.shop.member.Member;
import com.itwill.shop.order.Order;
import com.itwill.shop.order.OrderItem;
import com.itwill.shop.order.OrderService;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		orderService = new OrderService();
		loginMember = new Member("sy0", null, "김세영", null, null, null, null);
		Order order = orderService.orderDetail(loginMember.getM_id(), 6);
		
		setLayout(null);
		
		JScrollPane orderDetailScrollPane = new JScrollPane();
<<<<<<< HEAD
		orderDetailScrollPane.setBounds(12, 38, 312, 132);
=======
		orderDetailScrollPane.setBounds(25, -24, 336, 520);
>>>>>>> branch 'master' of https://github.com/2022-11-JAVA-DEVELOPER/java-project-team4-deundeunmarket.git
		add(orderDetailScrollPane);
		
		orderDetailPanel = new JPanel();
		orderDetailPanel.setPreferredSize(new Dimension(10, 700));
		orderDetailScrollPane.setViewportView(orderDetailPanel);
		orderDetailPanel.setLayout(null);
		
		/**************주문아이템패널생성****************/
		/*
		JPanel orderItemPanel = new JPanel();
		orderItemPanel.setPreferredSize(new Dimension(290, 110));
		orderItemPanel.setBounds(10, 10, 275, 95);
		orderDetailPanel.add(orderItemPanel);
		orderItemPanel.setLayout(null);
		
		JLabel p_imageLabel = new JLabel("");
		p_imageLabel.setIcon(new ImageIcon(OrderDetailPanel_김세영2.class.getResource("/images/닭도리탕_작은.jpg")));
		p_imageLabel.setBounds(12, 10, 87, 73);
		orderItemPanel.add(p_imageLabel);
		
		JLabel p_descLabel = new JLabel("p_desc");
		p_descLabel.setVerticalAlignment(SwingConstants.TOP);
		p_descLabel.setBounds(111, 10, 152, 48);
		orderItemPanel.add(p_descLabel);
		
		JLabel p_priceLabel = new JLabel("p_price");
		p_priceLabel.setBounds(111, 68, 74, 15);
		orderItemPanel.add(p_priceLabel);
		
		JLabel oi_qtyLabel = new JLabel("oi_qty");
		oi_qtyLabel.setBounds(187, 68, 63, 15);
		orderItemPanel.add(oi_qtyLabel);
		
		/************************************************/
		
		JLabel o_locLabel = new JLabel("받는장소");
		o_locLabel.setBounds(12, 435, 57, 15);
		add(o_locLabel);
		
		JLabel o_locDisplayLabel = new JLabel(order.getO_loc());
		o_locDisplayLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		o_locDisplayLabel.setBounds(95, 435, 224, 15);
		add(o_locDisplayLabel);
		
		JLabel o_addressLabel = new JLabel("주소");
		o_addressLabel.setBounds(12, 410, 57, 15);
		add(o_addressLabel);
		
		JLabel o_addressDisplayLabel = new JLabel(order.getO_address());
		o_addressDisplayLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		o_addressDisplayLabel.setBounds(95, 410, 224, 15);
		add(o_addressDisplayLabel);
		
		JLabel o_nameLabel = new JLabel("받는분");
		o_nameLabel.setBounds(12, 385, 57, 15);
		add(o_nameLabel);
		
		JLabel o_nameDisplayLabel = new JLabel(order.getO_name());
		o_nameDisplayLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		o_nameDisplayLabel.setBounds(95, 385, 224, 15);
		add(o_nameDisplayLabel);
		
		JLabel deliveryInfoLabel = new JLabel("배송정보");
		deliveryInfoLabel.setBounds(12, 360, 57, 15);
		add(deliveryInfoLabel);
		
		JLabel m_nameLabel = new JLabel("보내는분");
		m_nameLabel.setBounds(12, 320, 57, 15);
		add(m_nameLabel);
		
		JLabel m_nameDisplayLabel = new JLabel(loginMember.getM_name());
		m_nameDisplayLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		m_nameDisplayLabel.setBounds(95, 320, 224, 15);
		add(m_nameDisplayLabel);
		
		JLabel o_no_2Label = new JLabel("주문번호");
		o_no_2Label.setBounds(12, 295, 57, 15);
		add(o_no_2Label);
		
		JLabel o_noDisplay2Label = new JLabel(""+order.getO_no());
		o_noDisplay2Label.setHorizontalAlignment(SwingConstants.TRAILING);
		o_noDisplay2Label.setBounds(95, 295, 224, 15);
		add(o_noDisplay2Label);
		
		JLabel orderInfoLabel = new JLabel("주문정보");
		orderInfoLabel.setBounds(12, 270, 57, 15);
		add(orderInfoLabel);
		
		JLabel o_paymentLabel = new JLabel("결제방법");
		o_paymentLabel.setBounds(12, 230, 57, 15);
		add(o_paymentLabel);
		
		JLabel o_paymentDisplayLabel = new JLabel(order.getO_payment());
		o_paymentDisplayLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		o_paymentDisplayLabel.setBounds(95, 230, 224, 15);
		add(o_paymentDisplayLabel);
		
		JLabel o_priceLabel = new JLabel("주문금액");
		o_priceLabel.setBounds(12, 205, 57, 15);
		add(o_priceLabel);
		
		JLabel o_priceDisplayLabel = new JLabel(order.getO_price()+" 원");
		o_priceDisplayLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		o_priceDisplayLabel.setBounds(95, 205, 224, 15);
		add(o_priceDisplayLabel);
		
		JLabel paymentInfoLabel = new JLabel("결제정보");
		paymentInfoLabel.setBounds(12, 180, 57, 15);
		add(paymentInfoLabel);
		
		JButton orderCancleButton = new JButton("주문취소");
		orderCancleButton.addActionListener(new ActionListener() {
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
		orderCancleButton.setBounds(120, 500, 97, 23);
		add(orderCancleButton);
		
		JLabel o_noLabel = new JLabel("주문번호");
		o_noLabel.setBounds(12, 13, 57, 15);
		add(o_noLabel);
		
		JLabel o_noDisplayLabel = new JLabel(""+order.getO_no());
		o_noDisplayLabel.setBounds(95, 13, 224, 15);
		add(o_noDisplayLabel);
		
		/******************************/
		/*
		 * Service객체 생성
		 */
		//orderService = new OrderService();
		
		/*
		 * loginMember객체 생성
		 */
		//loginMember = new Member("sy0", null, null, null, null, null, null);
		/******************************/
		/*
		 * 메소드 사용
		 */
		orderDetail(6);
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
			orderItemPanel.setBounds(10, 10, 275, 95);
			orderItemPanel.setLayout(null);
			
			JLabel p_imageLabel = new JLabel("");
			p_imageLabel.setIcon(new ImageIcon(OrderDetailPanel_김세영.class.getResource(orderItem.getProduct().getP_image())));
			p_imageLabel.setBounds(12, 10, 87, 73);
			orderItemPanel.add(p_imageLabel);
			
			JLabel p_descLabel = new JLabel(orderItem.getProduct().getP_desc());
			p_descLabel.setVerticalAlignment(SwingConstants.TOP);
			p_descLabel.setBounds(111, 10, 152, 48);
			orderItemPanel.add(p_descLabel);
			
			JLabel p_priceLabel = new JLabel(orderItem.getProduct().getP_price()+"원");
			p_priceLabel.setBounds(111, 68, 74, 15);
			orderItemPanel.add(p_priceLabel);
			
			JLabel oi_qtyLabel = new JLabel(orderItem.getOi_qty()+" 개");
			oi_qtyLabel.setBounds(187, 68, 63, 15);
			orderItemPanel.add(oi_qtyLabel);
			
			orderDetailPanel.add(orderItemPanel);
		}
	}
}
