package com.itwill.shop.ui.김민선;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.itwill.shop.cart.Cart;
import com.itwill.shop.cart.CartService;
import com.itwill.shop.member.Member;
import com.itwill.shop.order.Order;
import com.itwill.shop.order.OrderItem;
import com.itwill.shop.order.OrderService;
import com.itwill.shop.product.Product;
import com.itwill.shop.product.ProductService;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

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
	 * order 객체 선언
	 */
	private Order order = null;

	
	private JTextField orderNameTF;
	private JTextField orderAddressTF;
	private JComboBox paymentCB;
	private JComboBox orderLocCB;

	public OrderCreatePanel_김민선() throws Exception{
		
		
		setLayout(null);
		
		JPanel orderCreatePanel = new JPanel();
		orderCreatePanel.setBounds(0, 0, 360, 540);
		add(orderCreatePanel);
		orderCreatePanel.setLayout(null);
		
		JLabel OrderNameLB = new JLabel("받으실 분");
		OrderNameLB.setBounds(50, 94, 57, 15);
		orderCreatePanel.add(OrderNameLB);
		
		orderNameTF = new JTextField();
		orderNameTF.setColumns(10);
		orderNameTF.setBounds(166, 91, 136, 21);
		orderCreatePanel.add(orderNameTF);
		
		JLabel OrderAddressLB = new JLabel("배송지");
		OrderAddressLB.setBounds(50, 152, 57, 15);
		orderCreatePanel.add(OrderAddressLB);
		
		orderAddressTF = new JTextField();
		orderAddressTF.setColumns(10);
		orderAddressTF.setBounds(50, 174, 257, 21);
		orderCreatePanel.add(orderAddressTF);
		
		JLabel OrderLocLB = new JLabel("수령장소");
		OrderLocLB.setBounds(45, 255, 57, 15);
		orderCreatePanel.add(OrderLocLB);
		
		JLabel OrderPaymentLB = new JLabel("결제수단");
		OrderPaymentLB.setBounds(45, 322, 57, 15);
		orderCreatePanel.add(OrderPaymentLB);
		
		paymentCB = new JComboBox();
		paymentCB.setModel(new DefaultComboBoxModel(new String[] {"카드", "계좌이체"}));
		paymentCB.setEditable(true);
		paymentCB.setBounds(171, 318, 136, 23);
		orderCreatePanel.add(paymentCB);
		
		orderLocCB = new JComboBox();
		orderLocCB.setModel(new DefaultComboBoxModel(new String[] {"문 앞", "경비실", "택배함"}));
		orderLocCB.setEditable(true);
		orderLocCB.setBounds(171, 251, 136, 23);
		orderCreatePanel.add(orderLocCB);
		
		JLabel OrderPriceLB = new JLabel("총 결제금액");
		OrderPriceLB.setBounds(45, 385, 87, 15);
		orderCreatePanel.add(OrderPriceLB);
		
		JButton orderCreateBtn = new JButton("주문하기");
		orderCreateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * 주문 생성 메소드 사용
				 */
				orderCreate();
			}
		});
		orderCreateBtn.setBounds(87, 455, 176, 40);
		orderCreatePanel.add(orderCreateBtn);
		
		JLabel orderTotPriceLB = new JLabel(""+orderTotPrice(loginMember.getM_id()));
		orderTotPriceLB.setHorizontalAlignment(SwingConstants.TRAILING);
		orderTotPriceLB.setBounds(171, 385, 136, 15);
		orderCreatePanel.add(orderTotPriceLB);
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
		loginMember = new Member("sy0",null,null,null,null,null,null);
		/*
		 * order 객체 생성
		 */
		//order = orderService.orderDetail(loginMember.getM_id(), 3);

		/*****************************************/
		
	}
	/*
	 * 주문 총 금액 메소드
	 */
	public int orderTotPrice(String m_id) throws Exception{
		List<Cart> cartList = cartService.getCartItemByMemberId(m_id);
		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		int o_tot_price = 0;
		
		for (Cart cart : cartList) {
			OrderItem orderItem = new OrderItem(0, cart.getCart_qty(), cart.getProduct(), 0);
			orderItemList.add(orderItem);
			o_tot_price += orderItem.getOi_qty()*orderItem.getProduct().getP_price();
		}
		return o_tot_price;
	}
	/*
	 public int orderCreate(Order order) throws Exception {
		
		List<Cart> cartList = cartDao.findByMemberId(order.getM_id());
		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		int o_tot_price = 0;
		int oi_tot_count = 0;
		String o_desc = "";
		int rowCount = 0;
		
		for (Cart cart : cartList) {
			OrderItem orderItem = new OrderItem(0, cart.getCart_qty(), cart.getProduct(), 0);
			orderItemList.add(orderItem);
			o_tot_price += orderItem.getOi_qty()*orderItem.getProduct().getP_price();
			oi_tot_count += orderItem.getOi_qty();
		}
		o_desc = orderItemList.get(0).getProduct().getP_name() + " 외" + (oi_tot_count - 1) + "개";
		
		Order newOrder = new Order(0, order.getO_name(),o_desc, null, o_tot_price, order.getO_address(), order.getO_loc(), order.getO_payment(), order.getM_id());
		newOrder.setOrderItemList(orderItemList);
		rowCount = orderDao.insert(newOrder);
		cartDao.deleteByMemberId(order.getM_id());
		return rowCount;
	}
	 */
	
	
	/*
	 * 주문하기 메소드
	 */
	
	public void orderCreate() {
		try {
			String o_name = orderNameTF.getText();
			String o_address = orderAddressTF.getText();
			String o_payment = (String) paymentCB.getSelectedItem();
			String o_loc = (String) orderLocCB.getSelectedItem();

			Order newOrder = new Order(0, o_name, null, null, 0, o_address, o_loc, o_payment, loginMember.getM_id());
			List<Cart> findCart = cartService.getCartItemByMemberId(loginMember.getM_id());
			int isCreated;
			isCreated = orderService.orderCreate(newOrder);
			if (findCart.size() > 0 && isCreated >= 1) {
				JOptionPane.showMessageDialog(null, "주문이 완료되었습니다.");
				// 주문 성공 시 주문 상세보기 화면으로 전환
				// 주문 상세보기 화면 활성화
			}
		} catch (Exception e1) {
			e1.getMessage();
			JOptionPane.showMessageDialog(null, "장바구니가 비어있습니다.");
		}
	}
	
	
	
}
