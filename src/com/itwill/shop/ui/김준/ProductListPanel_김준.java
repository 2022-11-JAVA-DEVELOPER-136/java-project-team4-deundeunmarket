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

import com.itwill.shop.cart.Cart;
import com.itwill.shop.cart.CartService;
import com.itwill.shop.member.Member;
import com.itwill.shop.order.OrderService;
import com.itwill.shop.product.Product;
import com.itwill.shop.product.ProductService;
import com.itwill.shop.ui.ShopMainFrame;

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
import java.awt.Color;

public class ProductListPanel_김준 extends JPanel {
	ShopMainFrame_김준 frame;
	/*****************************************/
	// Service 객체 선언
	ProductService productService;
	CartService cartService;
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
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JScrollPane productListScrollPane = new JScrollPane();
		productListScrollPane.setBounds(12, 63, 307, 405);
		add(productListScrollPane);
		
		productListPanel = new JPanel();
		productListPanel.setBackground(new Color(255, 255, 255));
		productListPanel.setPreferredSize(new Dimension(10, 1600));
		FlowLayout fl_productListPanel = (FlowLayout) productListPanel.getLayout();
		fl_productListPanel.setHgap(10);
		fl_productListPanel.setAlignment(FlowLayout.LEFT);
		productListScrollPane.setViewportView(productListPanel);
		/********제품패널생성***********/
		JPanel productPanel = new JPanel();
		productPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		productPanel.setPreferredSize(new Dimension(125, 310));
		
		productPanel.setLayout(null);
		
		JLabel productImageLB = new JLabel("");
		productImageLB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
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
		
		
		JButton cartBtn = new JButton("담기");
		cartBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		cartBtn.setBounds(3, 241, 97, 23);
		productPanel.add(cartBtn);
		
		JButton buyBtn = new JButton("구매하기");
		buyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//order화면으로 전환
			}
		});
		buyBtn.setBounds(3, 274, 97, 23);
		productPanel.add(buyBtn);
		
		productListPanel.add(productPanel);
		/********************************/	

		//객체 생성
		productService = new ProductService();
		cartService = new CartService();
		
		member = new Member("sy1", null, null, null, null, null, null);
		productList();
	}
	
	public void setFrame(ShopMainFrame_김준 frame) throws Exception {
		this.frame = frame;
		productList();
	}
	
	private void productList() throws Exception {
		List<Product> productList = productService.productList();
		productListPanel.removeAll();
		
		for (Product product : productList) {
			
			JPanel productPanel = new JPanel();
			productPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			productPanel.setPreferredSize(new Dimension(125, 310));
			
			JLabel productImageLB = new JLabel("");
			productImageLB.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					frame.changePanel(frame.PRODUCT_DETAIL_PANEL, product);
				}
			});
			productPanel.setLayout(null);
			productImageLB.setVerticalTextPosition(SwingConstants.BOTTOM);
			productImageLB.setPreferredSize(new Dimension(100, 140));
			productImageLB.setIcon(new ImageIcon(ProductListPanel_김준.class.getResource(product.getP_image())));
			productImageLB.setBounds(0, 0, 100, 148);
			productPanel.add(productImageLB);
			
			JLabel productNameLB = new JLabel(product.getP_name());
			productNameLB.setMinimumSize(new Dimension(24, 15));
			productNameLB.setMaximumSize(new Dimension(24, 15));
			productNameLB.setPreferredSize(new Dimension(24, 15));
			productNameLB.setBounds(0, 158, 125, 41);
			productPanel.add(productNameLB);
			productListPanel.add(productPanel);
			
			JLabel productPriceLB = new JLabel("<html>"+ product.getP_price()+"</html>");
			productPriceLB.setPreferredSize(new Dimension(96, 30));
			productPriceLB.setBounds(0, 209, 115, 22);
			productPanel.add(productPriceLB);
			
			JButton cartBtn = new JButton("담기");
			cartBtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						cartService.addCart(new Cart(0, 1, member.getM_id(), 
								new Product(product.getP_no(), product.getP_name(), 
											product.getP_price(), product.getP_image(), 
											product.getP_desc())));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			cartBtn.setBounds(3, 241, 97, 23);
			productPanel.add(cartBtn);
			
			JButton buyBtn = new JButton("구매하기");
			buyBtn.setBounds(3, 274, 97, 23);
			productPanel.add(buyBtn);
			
			
			
			productListPanel.add(productPanel);
		}
		
		
	}
}