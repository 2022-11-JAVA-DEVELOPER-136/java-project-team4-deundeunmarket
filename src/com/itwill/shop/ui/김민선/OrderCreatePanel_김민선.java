package com.itwill.shop.ui.김민선;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class OrderCreatePanel_김민선 extends JPanel {
	private JTextField nameTF;
	private JTextField addressTF;
	private JTextField orderPriceTF;

	/*
	 * Service 객체 선언
	 */
	/*
	 * logInMember 객체 선언
	 */
	/*
	 * Create the panel.
	 */
	public OrderCreatePanel_김민선() {
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
		
		JComboBox paymentCB = new JComboBox();
		paymentCB.setModel(new DefaultComboBoxModel(new String[] {"카드", "계좌이체", "휴대폰"}));
		paymentCB.setBounds(170, 318, 136, 23);
		add(paymentCB);
		
		JComboBox orderLocCB = new JComboBox();
		orderLocCB.setModel(new DefaultComboBoxModel(new String[] {"문 앞", "경비실", "택배함"}));
		orderLocCB.setBounds(170, 253, 136, 23);
		add(orderLocCB);
		
		JLabel OrderPriceLB = new JLabel("총 결제금액");
		OrderPriceLB.setBounds(49, 387, 87, 15);
		add(OrderPriceLB);
		
		orderPriceTF = new JTextField();
		orderPriceTF.setBounds(170, 384, 136, 21);
		add(orderPriceTF);
		orderPriceTF.setColumns(10);
		
		JButton orderCreateBtn = new JButton("주문하기");
		orderCreateBtn.setBounds(87, 451, 176, 40);
		add(orderCreateBtn);

	}
}
