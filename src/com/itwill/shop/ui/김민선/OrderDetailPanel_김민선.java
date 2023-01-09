package com.itwill.shop.ui.김민선;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Dimension;

public class OrderDetailPanel_김민선 extends JPanel {
	private JTextField orderNoTF;

	/**
	 * Create the panel.
	 */
	public OrderDetailPanel_김민선() {

		initGUI();
	}
	private void initGUI() {
		setLayout(null);
		
		JLabel OrderDetailTitleLB = new JLabel("주문내역 상세");
		OrderDetailTitleLB.setFont(new Font("굴림", Font.BOLD, 18));
		OrderDetailTitleLB.setBounds(30, 10, 181, 35);
		add(OrderDetailTitleLB);
		
		JLabel OrderNoLB = new JLabel("주문번호");
		OrderNoLB.setBounds(12, 50, 50, 15);
		add(OrderNoLB);
		
		orderNoTF = new JTextField();
		orderNoTF.setEditable(false);
		orderNoTF.setEnabled(false);
		orderNoTF.setBounds(64, 47, 96, 21);
		add(orderNoTF);
		orderNoTF.setColumns(10);
		
		JScrollPane orderScrollPanel = new JScrollPane();
		orderScrollPanel.setBounds(12, 75, 336, 282);
		add(orderScrollPanel);
		
		JPanel orderDetailPanel = new JPanel();
		orderDetailPanel.setPreferredSize(new Dimension(250, 700));
		orderScrollPanel.setViewportView(orderDetailPanel);
		
		JPanel orderPanel = new JPanel();
		orderPanel.setPreferredSize(new Dimension(300, 100));
		orderDetailPanel.add(orderPanel);
		orderPanel.setLayout(null);
	}
}
