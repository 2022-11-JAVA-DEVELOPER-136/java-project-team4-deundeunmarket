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
import com.itwill.shop.ui.최민영.MemberLoginPanel_최민영;
import com.itwill.shop.ui.최민영.MemberJoinPanel_최민영;
import com.itwill.shop.ui.최민영.MemberDetailPanel_최민영;
import com.itwill.shop.ui.김민선.OrderCreatePanel_김민선;
import com.itwill.shop.ui.김세영.OrderListPanel_김세영;
import com.itwill.shop.ui.김세영.OrderDetailPanel_김세영;

public class ShopMainFrame extends JFrame {
	
	/*********************************************************/
	/*
	 * Panel상수 선언
	 */
	public static final int PANEL_MEMBER_LOGIN = 1;
	public static final int PANEL_MEMBER_JOIN = 2;
	public static final int PANEL_MEMBER_INFO = 3;
	public static final int PANEL_PRODUCT_LIST = 4;
	public static final int PANEL_PRODUCT_RECOMMEND = 5;
	public static final int PANEL_PRODUCT_DETAIL = 6;
	public static final int PANEL_CART = 7;
	public static final int PANEL_ORDER_CREATE = 8;
	public static final int PANEL_ORDER_LIST = 9;
	public static final int PANEL_ORDER_DETAIL = 10;
	
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
	private JTabbedPane memberTabbedPane;
	private JTabbedPane productTabbedPane;
	private JTabbedPane cartTabbedPane;
	private JTabbedPane orderTabbedPane;
	private MemberLoginPanel_최민영 memberLoginPanel;
	private MemberJoinPanel_최민영 memberJoinPanel;
	private MemberDetailPanel_최민영 memberDetailPanel;
	private OrderCreatePanel_김민선 orderCreatePanel;
	private OrderListPanel_김세영 orderListPanel;
	private OrderDetailPanel_김세영 orderDetailPanel;
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
		globalSearchMenuButton.setContentAreaFilled(false);
		globalSearchMenuButton.setBorderPainted(false);
		globalSearchMenuButton.setOpaque(false);
		globalSearchMenuButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		globalSearchMenuButton.setBorder(null);
		globalSearchMenuButton.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/search 50.png")));
		globalSouthMenuPanel.add(globalSearchMenuButton);
		
		JButton globalHomeMenuButton = new JButton("");
		globalHomeMenuButton.setContentAreaFilled(false);
		globalHomeMenuButton.setBorderPainted(false);
		globalHomeMenuButton.setOpaque(false);
		globalHomeMenuButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		globalHomeMenuButton.setBorder(null);
		globalHomeMenuButton.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/home 50.png")));
		globalSouthMenuPanel.add(globalHomeMenuButton);
		
		JButton globalMemberMenuButton = new JButton("");
		globalMemberMenuButton.setContentAreaFilled(false);
		globalMemberMenuButton.setBorderPainted(false);
		globalMemberMenuButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		globalMemberMenuButton.setBorder(null);
		globalMemberMenuButton.setOpaque(false);
		globalMemberMenuButton.setIcon(new ImageIcon(ShopMainFrame.class.getResource("/images/cart50.png")));
		globalSouthMenuPanel.add(globalMemberMenuButton);
		
		shopTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(shopTabbedPane, BorderLayout.CENTER);
		
		memberTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		shopTabbedPane.addTab("회원", null, memberTabbedPane, null);
		
		memberLoginPanel = new MemberLoginPanel_최민영();
		memberTabbedPane.addTab("로그인", null, memberLoginPanel, null);
		
		memberJoinPanel = new MemberJoinPanel_최민영();
		memberTabbedPane.addTab("회원가입", null, memberJoinPanel, null);
		
		memberDetailPanel = new MemberDetailPanel_최민영();
		memberTabbedPane.addTab("회원정보", null, memberDetailPanel, null);
		
		productTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		shopTabbedPane.addTab("상품", null, productTabbedPane, null);
		
		/*****************************/
		/*
		 * 3. Service 객체 생성
		 */
		memberService = new MemberService();
		orderService = new OrderService();
		cartService = new CartService();
		productService = new ProductService();
		
		cartTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		shopTabbedPane.addTab("장바구니", null, cartTabbedPane, null);
		
		orderTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		shopTabbedPane.addTab("주문", null, orderTabbedPane, null);
		
		orderCreatePanel = new OrderCreatePanel_김민선();
		orderTabbedPane.addTab("주문하기", null, orderCreatePanel, null);
		
		orderListPanel = new OrderListPanel_김세영();
		orderTabbedPane.addTab("주문목록", null, orderListPanel, null);
		
		orderDetailPanel = new OrderDetailPanel_김세영();
		orderTabbedPane.addTab("주문상세", null, orderDetailPanel, null);
		
		
		
		/*
		 * 4. login Member 객체 생성
		 */
		
		/******************************/
		
		
		
	}// 생성자 끝
	/***************패널 변경 메소드******************/
	
	public void changePanel(int panel_no, Object data) {
		if(true) {
			
		} else if(true) {
			
		}
		
	}
	 /***********패널변경메쏘드********/
	/*
	public void changePanel(int panel_no,Object data) {
		if(panel_no==PRODUCT_LIST_PANEL) {
			shopTabbedPane.setSelectedIndex(0);
			productTabbedPane.setSelectedIndex(0);
		}else if(panel_no==PRODUCT_DETAIL_PANEL) {
			Product product=(Product)data;
			System.out.println("recv product"+product);
			
			shopTabbedPane.setSelectedIndex(0);
			productTabbedPane.setSelectedIndex(1);
			productDetailPanel.displayProductDetail(product);
			
		}else if(panel_no==USER_INFO_PANEL) {
			shopTabbedPane.setSelectedIndex(1);
			productTabbedPane.setSelectedIndex(1);
		}else if(panel_no==USERT_JOIN_PANEL) {
			shopTabbedPane.setSelectedIndex(1);
			productTabbedPane.setSelectedIndex(0);
		}
		
	}
	 */
	

}
