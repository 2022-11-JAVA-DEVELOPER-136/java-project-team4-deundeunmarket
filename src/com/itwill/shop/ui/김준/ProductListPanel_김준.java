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

import com.itwill.shop.cart.CartService;
import com.itwill.shop.member.Member;
import com.itwill.shop.order.OrderService;
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

public class ProductListPanel_김준 extends JPanel {
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

	public ProductListPanel_김준() throws Exception {
		setLayout(null);
		
		JScrollPane productListScrollPane = new JScrollPane();
		productListScrollPane.setBounds(12, 121, 307, 347);
		add(productListScrollPane);
		
		productListPanel = new JPanel();
		productListPanel.setPreferredSize(new Dimension(10, 1450));
		FlowLayout fl_productListPanel = (FlowLayout) productListPanel.getLayout();
		fl_productListPanel.setHgap(10);
		fl_productListPanel.setAlignment(FlowLayout.LEFT);
		productListScrollPane.setViewportView(productListPanel);
		/********제품패널생성***********/
		JPanel productPanel = new JPanel();
		productPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		productPanel.setPreferredSize(new Dimension(125, 280));
		
		productPanel.setLayout(null);
		
		JLabel productImageLB = new JLabel("");
		productImageLB.setVerticalTextPosition(SwingConstants.BOTTOM);
		productImageLB.setPreferredSize(new Dimension(100, 140));
		productImageLB.setIcon(new ImageIcon(ProductListPanel_김준.class.getResource("/images/떡볶이_작은.jpg")));
		productImageLB.setBounds(0, 0, 100, 148);
		productPanel.add(productImageLB);
		
		JLabel productNameLB = new JLabel("<html>[석관동 떡볶이] 오리지널 떡볶이<html>\r\n");
		productNameLB.setMinimumSize(new Dimension(24, 15));
		productNameLB.setMaximumSize(new Dimension(24, 15));
		productNameLB.setPreferredSize(new Dimension(24, 15));
		productNameLB.setBounds(0, 158, 125, 41);
		productPanel.add(productNameLB);
		productListPanel.add(productPanel);
		
		JLabel productPriceLB = new JLabel("<html> 가격 : 10,000 </html>");
		productPriceLB.setPreferredSize(new Dimension(96, 30));
		productPriceLB.setBounds(0, 209, 115, 22);
		productPanel.add(productPriceLB);
		
		JLabel productDescLB = new JLabel("<html>자꾸 생각나는 매콤 달콤함<html>\r\n");
		productDescLB.setBounds(0, 230, 115, 40);
		productPanel.add(productDescLB);
		
		productListPanel.add(productPanel);
		/********************************/	

		//객체 생성
		productService = new ProductService();
		
		member = new Member("sy1", null, null, null, null, null, null);
		productList();
	}
	
	private void productList() throws Exception {
		List<Product> productList = productService.productList();
		productListPanel.removeAll();
		
		for (Product product : productList) {
			JPanel productPanel = new JPanel();
			productPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			productPanel.setPreferredSize(new Dimension(125, 280));
			
			productPanel.setLayout(null);
			
			JLabel productImageLB = new JLabel("");
			productImageLB.setVerticalTextPosition(SwingConstants.BOTTOM);
			productImageLB.setPreferredSize(new Dimension(100, 140));
			productImageLB.setIcon(new ImageIcon(ProductListPanel_김준.class.getResource(product.getP_image())));
			productImageLB.setBounds(0, 0, 100, 148);
			productPanel.add(productImageLB);
			
			JLabel productNameLB = new JLabel(product.getP_name());
			productNameLB.setMinimumSize(new Dimension(24, 15));
			productNameLB.setMaximumSize(new Dimension(24, 15));
			productNameLB.setPreferredSize(new Dimension(24, 15));
			productNameLB.setBounds(0, 158, 115, 41);
			productPanel.add(productNameLB);
			productListPanel.add(productPanel);
			
			JLabel productPriceLB = new JLabel("<html>"+ product.getP_price()+"</html>");
			productPriceLB.setPreferredSize(new Dimension(96, 30));
			productPriceLB.setBounds(0, 209, 115, 22);
			productPanel.add(productPriceLB);
			
			JLabel productDescLB = new JLabel("<html>"+ product.getP_desc() +"</html>");
			productDescLB.setBounds(0, 230, 115, 40);
			productPanel.add(productDescLB);
			
			productListPanel.add(productPanel);
		}
		
		
	}
}