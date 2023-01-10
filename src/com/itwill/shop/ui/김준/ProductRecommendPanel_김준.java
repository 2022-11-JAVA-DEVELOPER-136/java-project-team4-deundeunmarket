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
		productListScrollPane.setBounds(12, 133, 307, 347);
		add(productListScrollPane);
		
		productListPanel = new JPanel();
		productListPanel.setPreferredSize(new Dimension(10, 570));
		FlowLayout fl_productListPanel = (FlowLayout) productListPanel.getLayout();
		fl_productListPanel.setHgap(10);
		fl_productListPanel.setAlignment(FlowLayout.LEFT);
		productListScrollPane.setViewportView(productListPanel);
		/********제품패널생성***********/
		JPanel tteokbokkiPanel = new JPanel();
		tteokbokkiPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tteokbokkiPanel.setPreferredSize(new Dimension(125, 280));
		
		tteokbokkiPanel.setLayout(null);
		
		JLabel productImageLB = new JLabel("");
		productImageLB.setVerticalTextPosition(SwingConstants.BOTTOM);
		productImageLB.setPreferredSize(new Dimension(100, 140));
		productImageLB.setIcon(new ImageIcon(ProductListPanel_김준.class.getResource("/images/떡볶이_작은.jpg")));
		productImageLB.setBounds(0, 0, 100, 148);
		tteokbokkiPanel.add(productImageLB);
		
		JLabel productNameLB = new JLabel("<html>떡볶이<html>\r\n");
		productNameLB.setMinimumSize(new Dimension(24, 15));
		productNameLB.setMaximumSize(new Dimension(24, 15));
		productNameLB.setPreferredSize(new Dimension(24, 15));
		productNameLB.setBounds(0, 158, 125, 41);
		tteokbokkiPanel.add(productNameLB);
		productListPanel.add(tteokbokkiPanel);
		
		JLabel productPriceLB = new JLabel("<html> 가격 : 10,000 </html>");
		productPriceLB.setPreferredSize(new Dimension(96, 30));
		productPriceLB.setBounds(0, 209, 115, 22);
		tteokbokkiPanel.add(productPriceLB);
		
		JLabel productDescLB = new JLabel("<html>자꾸 생각나는 매콤 달콤함<html>\r\n");
		productDescLB.setBounds(0, 230, 115, 40);
		tteokbokkiPanel.add(productDescLB);
		
		productListPanel.add(tteokbokkiPanel);
		
		JPanel creampastaPanel_2 = new JPanel();
		creampastaPanel_2.setLayout(null);
		creampastaPanel_2.setPreferredSize(new Dimension(125, 280));
		productListPanel.add(creampastaPanel_2);
		
		JLabel productImageLB_2 = new JLabel("");
		productImageLB_2.setIcon(new ImageIcon(ProductRecommendPanel_김준.class.getResource("/images/크림파스타_작은.jpg")));
		productImageLB_2.setVerticalTextPosition(SwingConstants.BOTTOM);
		productImageLB_2.setPreferredSize(new Dimension(100, 140));
		productImageLB_2.setBounds(0, 0, 100, 148);
		creampastaPanel_2.add(productImageLB_2);
		
		JLabel productNameLB_2 = new JLabel("<html>크림파스타<html>\r\n");
		productNameLB_2.setPreferredSize(new Dimension(24, 15));
		productNameLB_2.setMinimumSize(new Dimension(24, 15));
		productNameLB_2.setMaximumSize(new Dimension(24, 15));
		productNameLB_2.setBounds(0, 158, 125, 41);
		creampastaPanel_2.add(productNameLB_2);
		
		JLabel productPriceLB_2 = new JLabel("<html> 가격 : 10,000 </html>");
		productPriceLB_2.setPreferredSize(new Dimension(96, 30));
		productPriceLB_2.setBounds(0, 209, 115, 22);
		creampastaPanel_2.add(productPriceLB_2);
		
		JLabel productDescLB_2 = new JLabel("<html>매콤한 매력의 크림 파스타<html>\r\n");
		productDescLB_2.setBounds(0, 230, 115, 40);
		creampastaPanel_2.add(productDescLB_2);
		
		JPanel steakPanel_3 = new JPanel();
		steakPanel_3.setLayout(null);
		steakPanel_3.setPreferredSize(new Dimension(125, 280));
		productListPanel.add(steakPanel_3);
		
		JLabel productImageLB_3 = new JLabel("");
		productImageLB_3.setIcon(new ImageIcon(ProductRecommendPanel_김준.class.getResource("/images/스테이크_작은.jpg")));
		productImageLB_3.setVerticalTextPosition(SwingConstants.BOTTOM);
		productImageLB_3.setPreferredSize(new Dimension(100, 140));
		productImageLB_3.setBounds(0, 0, 100, 148);
		steakPanel_3.add(productImageLB_3);
		
		JLabel productNameLB_3 = new JLabel("<html>스테이크<html>\r\n");
		productNameLB_3.setPreferredSize(new Dimension(24, 15));
		productNameLB_3.setMinimumSize(new Dimension(24, 15));
		productNameLB_3.setMaximumSize(new Dimension(24, 15));
		productNameLB_3.setBounds(0, 158, 125, 41);
		steakPanel_3.add(productNameLB_3);
		
		JLabel productPriceLB_3 = new JLabel("<html> 가격 : 10,000 </html>");
		productPriceLB_3.setPreferredSize(new Dimension(96, 30));
		productPriceLB_3.setBounds(0, 209, 115, 22);
		steakPanel_3.add(productPriceLB_3);
		
		JLabel productDescLB_3 = new JLabel("<html>쫄깃한 식감, 풍부한 육즙<html>\r\n");
		productDescLB_3.setBounds(0, 230, 115, 40);
		steakPanel_3.add(productDescLB_3);
		
		JPanel shabuPanel_4 = new JPanel();
		shabuPanel_4.setLayout(null);
		shabuPanel_4.setPreferredSize(new Dimension(125, 280));
		productListPanel.add(shabuPanel_4);
		
		JLabel productImageLB_4 = new JLabel("");
		productImageLB_4.setIcon(new ImageIcon(ProductRecommendPanel_김준.class.getResource("/images/샤브샤브_작은.jpg")));
		productImageLB_4.setVerticalTextPosition(SwingConstants.BOTTOM);
		productImageLB_4.setPreferredSize(new Dimension(100, 140));
		productImageLB_4.setBounds(0, 0, 100, 148);
		shabuPanel_4.add(productImageLB_4);
		
		JLabel productNameLB_4 = new JLabel("<html>샤브샤브<html>\r\n");
		productNameLB_4.setPreferredSize(new Dimension(24, 15));
		productNameLB_4.setMinimumSize(new Dimension(24, 15));
		productNameLB_4.setMaximumSize(new Dimension(24, 15));
		productNameLB_4.setBounds(0, 158, 125, 41);
		shabuPanel_4.add(productNameLB_4);
		
		JLabel productPriceLB_4 = new JLabel("<html> 가격 : 10,000 </html>");
		productPriceLB_4.setPreferredSize(new Dimension(96, 30));
		productPriceLB_4.setBounds(0, 209, 115, 22);
		shabuPanel_4.add(productPriceLB_4);
		
		JLabel productDescLB_4 = new JLabel("<html>매장의 노하우로 완성<html>\r\n");
		productDescLB_4.setBounds(0, 230, 115, 40);
		shabuPanel_4.add(productDescLB_4);
		/********************************/	

		//객체 생성
		productService = new ProductService();
		
		member = new Member("sy1", null, null, null, null, null, null);
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