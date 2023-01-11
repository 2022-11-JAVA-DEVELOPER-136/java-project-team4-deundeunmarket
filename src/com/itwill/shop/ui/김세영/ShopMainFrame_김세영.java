package com.itwill.shop.ui.김세영;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

public class ShopMainFrame_김세영 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopMainFrame_김세영 frame = new ShopMainFrame_김세영();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ShopMainFrame_김세영() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane orderTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(orderTabbedPane, BorderLayout.CENTER);
		
		OrderListPanel_김세영 orderListPanel_김세영 = new OrderListPanel_김세영();
		orderTabbedPane.addTab("New tab", null, orderListPanel_김세영, null);
	}
}
