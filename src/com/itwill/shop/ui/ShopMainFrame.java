package com.itwill.shop.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.shop.cart.CartService;
import com.itwill.shop.member.Member;
import com.itwill.shop.member.MemberService;
import com.itwill.shop.order.OrderService;
import com.itwill.shop.product.Product;
import com.itwill.shop.product.ProductService;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.Cursor;
import javax.swing.JTabbedPane;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ShopMainFrame extends JFrame {
	
	/*
	 * Panel상수 선언
	 */
	
	/*
	 * 1. Service객체 선언
	 */
	
	/*
	 * 2. login User 선언
	 */
	
	/*********************************************************/
	/*
	 * Panel상수
	 */
	public static final int PRODUCT_LIST_PANEL = 1;
	public static final int PRODUCT_POPULAR_PANEL = 2;
	public static final int MEMBER_JOIN_PANEL = 3;
	public static final int MEMBER_INFO_PANEL = 4;
	
	private JPanel contentPane;
	/*
	 * 1. Service 객체 선언
	 */
	MemberService memberService;
	OrderService orderService;
	CartService cartService;
	ProductService productService;
	/*
	 * 2. login Member 객체 선언(선택한 product 객체 선언)
	 */
	Member loginMember = null;
	Product selectProduct;
	
	private JTabbedPane shopTabbedPane;
	private PopularProductPanel popularProductPanel;
	private ProductListPanel productListPanel;
	private MemberJoinPanel memberJoinPanel;
	private MemberInfoPanel memberInfoPanel;
	private JTabbedPane productTabbedPane;
	private JTabbedPane memberTabbedPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopMainFrame frame = new ShopMainFrame();
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
	public ShopMainFrame() throws Exception{
		initGUI();
	}
	private void initGUI() throws Exception{
		setPreferredSize(new Dimension(360, 640));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
				setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel globalNorthMenuPanel = new JPanel();
		globalNorthMenuPanel.setBackground(new Color(46, 139, 87));
		contentPane.add(globalNorthMenuPanel, BorderLayout.NORTH);
		globalNorthMenuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel globalLogoLB = new JLabel("");
		globalLogoLB.setBorder(null);
		globalLogoLB.setHorizontalAlignment(SwingConstants.LEFT);
		globalLogoLB.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/든든마켓화이트 상단.png")));
		globalNorthMenuPanel.add(globalLogoLB);
		
		JPanel globalSouthMenuPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) globalSouthMenuPanel.getLayout();
		flowLayout.setHgap(50);
		globalSouthMenuPanel.setBackground(new Color(46, 139, 87));
		contentPane.add(globalSouthMenuPanel, BorderLayout.SOUTH);
		
		JButton globalSearchMenuButton = new JButton("");
		globalSearchMenuButton.setOpaque(false);
		globalSearchMenuButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		globalSearchMenuButton.setBorder(null);
		globalSearchMenuButton.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/search 50.png")));
		globalSouthMenuPanel.add(globalSearchMenuButton);
		
		JButton globalHomeMenuButton = new JButton("");
		globalHomeMenuButton.setOpaque(false);
		globalHomeMenuButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		globalHomeMenuButton.setBorder(null);
		globalHomeMenuButton.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/home 50.png")));
		globalSouthMenuPanel.add(globalHomeMenuButton);
		
		JButton globalMemberMenuButton = new JButton("");
		globalMemberMenuButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		globalMemberMenuButton.setBorder(null);
		globalMemberMenuButton.setOpaque(false);
		globalMemberMenuButton.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/cart50.png")));
		globalSouthMenuPanel.add(globalMemberMenuButton);
		
		shopTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(shopTabbedPane, BorderLayout.CENTER);
		
		productTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		shopTabbedPane.addTab("제품", null, productTabbedPane, null);
		
		popularProductPanel = new PopularProductPanel();
		productTabbedPane.addTab("인기상품", null, popularProductPanel, null);
		
		productListPanel = new ProductListPanel();
		productTabbedPane.addTab("제품리스트", null, productListPanel, null);
		
		memberTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		shopTabbedPane.addTab("회원", null, memberTabbedPane, null);
		
		memberJoinPanel = new MemberJoinPanel();
		memberTabbedPane.addTab("회원가입", null, memberJoinPanel, null);
		
		memberInfoPanel = new MemberInfoPanel();
		memberTabbedPane.addTab("회원정보", null, memberInfoPanel, null);
		
		/*****************************/
		/*
		 * 3. Service 객체 생성
		 */
		memberService = new MemberService();
		orderService = new OrderService();
		cartService = new CartService();
		productService = new ProductService();
		
		/****** ShopMainFrame 참조를 Panel에게 넘겨줌 ******/
		productListPanel.setFrame(this); 
		popularProductPanel.setFrame(this); 
		memberInfoPanel.setFrame(this); 
		memberJoinPanel.setFrame(this);  
		
		
		
		/*
		 * 4. login Member 객체 생성
		 */
		
		/******************************/
		
		
		
	}// 생성자 끝
	/***************패널 변경 메소드******************/
	
	public void changePanel(int panel_no, Object data) {
		if (panel_no == PRODUCT_POPULAR_PANEL) {
			Product product = (Product)data;
			System.out.println("receive product" + product);
			shopTabbedPane.setSelectedIndex(0);
			productTabbedPane.setSelectedIndex(0);
			popularProductPanel.displayPopularProduct(product);
		} else if (panel_no == PRODUCT_LIST_PANEL) {
			shopTabbedPane.setSelectedIndex(0);
			productTabbedPane.setSelectedIndex(1);
		} else if (panel_no == MEMBER_JOIN_PANEL) {
			shopTabbedPane.setSelectedIndex(1);
			productTabbedPane.setSelectedIndex(1);
		} else if (panel_no == MEMBER_INFO_PANEL) {
			shopTabbedPane.setSelectedIndex(1);
			productTabbedPane.setSelectedIndex(2);
		}
		
	}
	

	
	
	
	
	
	
	
	
	
}
