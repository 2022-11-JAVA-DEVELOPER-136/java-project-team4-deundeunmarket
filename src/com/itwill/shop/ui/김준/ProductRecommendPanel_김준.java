package com.itwill.shop.ui.김준;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JSplitPane;
import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import com.itwill.shop.member.Member;
import com.itwill.shop.product.Product;
import com.itwill.shop.product.ProductService;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;
import java.awt.Rectangle;
import java.awt.Dimension;

public class ProductRecommendPanel_김준 extends JPanel {
	/*****************************************/
	// Service 객체 선언
	ProductService productService;

	// loginMember 객체선언
	Member member;
	/*****************************************/

	private JLabel ProductListLB;
	private JPanel productListPanel;

	/**
	 * Create the panel.
	 * 
	 * @throws Exception
	 */

	public ProductRecommendPanel_김준() throws Exception {
		setLayout(null);
		
		JScrollPane productListScrollPane = new JScrollPane();
		productListScrollPane.setBounds(12, 121, 336, 347);
		add(productListScrollPane);
		
		productListPanel = new JPanel();
		FlowLayout fl_productListPanel = (FlowLayout) productListPanel.getLayout();
		fl_productListPanel.setHgap(10);
		fl_productListPanel.setAlignment(FlowLayout.LEFT);
		productListPanel.setPreferredSize(new Dimension(10, 500));
		productListScrollPane.setViewportView(productListPanel);
		/********제품패널생성***********/
		JPanel productPanel = new JPanel();
		productPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		productPanel.setPreferredSize(new Dimension(270, 150));
		
		productPanel.setLayout(null);
		
		JLabel productImageLB = new JLabel("");
		productImageLB.setVerticalTextPosition(SwingConstants.BOTTOM);
		productImageLB.setPreferredSize(new Dimension(100, 140));
		productImageLB.setIcon(new ImageIcon(ProductRecommendPanel_김준.class.getResource("/images/떡볶이_작은.jpg")));
		productImageLB.setBounds(0, 0, 100, 148);
		productPanel.add(productImageLB);
		
		JLabel ProductNameLB = new JLabel("<html>[석관동 떡볶이] 오리지널 떡볶이<html>\r\n");
		ProductNameLB.setMinimumSize(new Dimension(24, 15));
		ProductNameLB.setMaximumSize(new Dimension(24, 15));
		ProductNameLB.setPreferredSize(new Dimension(24, 15));
		ProductNameLB.setBounds(102, 10, 145, 41);
		productPanel.add(ProductNameLB);
		productListPanel.add(productPanel);
		
		JLabel ProductDescLB = new JLabel("<html> 가격 : 12,000 </html>");
		ProductDescLB.setPreferredSize(new Dimension(96, 30));
		ProductDescLB.setBounds(102, 52, 140, 41);
		productPanel.add(ProductDescLB);
		
		productListPanel.add(productPanel);
		/********************************/	

		//객체 생성
		productService = new ProductService();
		
		member = new Member("sy1", null, null, null, null, null, null);
		productList();
	}
	
	private void productList() throws Exception {
		List<Product> productList = productService.productList();
		for (Product product : productList) {
			JPanel productPanel = new JPanel();
			productPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			productPanel.setPreferredSize(new Dimension(270, 150));
			
			productPanel.setLayout(null);
			
			JLabel productImageLB = new JLabel("");
			productImageLB.setVerticalTextPosition(SwingConstants.BOTTOM);
			productImageLB.setPreferredSize(new Dimension(100, 140));
			productImageLB.setIcon(new ImageIcon(ProductRecommendPanel_김준.class.getResource(product.getP_image())));
			productImageLB.setBounds(0, 0, 100, 148);
			productPanel.add(productImageLB);
			
			JLabel ProductNameLB = new JLabel(product.getP_name());
			ProductNameLB.setMinimumSize(new Dimension(24, 15));
			ProductNameLB.setMaximumSize(new Dimension(24, 15));
			ProductNameLB.setPreferredSize(new Dimension(24, 15));
			ProductNameLB.setBounds(102, 10, 140, 41);
			productPanel.add(ProductNameLB);
			productListPanel.add(productPanel);
			
			JLabel ProductDescLB = new JLabel("<html>"+ product.getP_price()+"</html>");
			ProductDescLB.setPreferredSize(new Dimension(96, 30));
			ProductDescLB.setBounds(102, 52, 140, 41);
			productPanel.add(ProductDescLB);
			
			productListPanel.add(productPanel);
		}
		
		
	}
}