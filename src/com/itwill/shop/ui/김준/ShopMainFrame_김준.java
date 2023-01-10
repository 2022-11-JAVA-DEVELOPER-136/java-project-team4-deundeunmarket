package com.itwill.shop.ui.김준;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Rectangle;
import java.awt.Dimension;

public class ShopMainFrame_김준 extends JFrame {

	private JPanel contentPane;
	private ProductListPanel_김준 productListPanel_김준;
	private ProductRecommendPanel_김준 productRecommendPanel_김준;
	private ProductDetailPanel_김준 productDetailPanel_김준;
	private JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopMainFrame_김준 frame = new ShopMainFrame_김준();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public ShopMainFrame_김준() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		productListPanel_김준 = new ProductListPanel_김준();
		tabbedPane.addTab("New tab", null, productListPanel_김준, null);
		
		productRecommendPanel_김준 = new ProductRecommendPanel_김준();
		tabbedPane.addTab("New tab", null, productRecommendPanel_김준, null);
		
		productDetailPanel_김준 = new ProductDetailPanel_김준();
		tabbedPane.addTab("New tab", null, productDetailPanel_김준, null);
		

	}
}