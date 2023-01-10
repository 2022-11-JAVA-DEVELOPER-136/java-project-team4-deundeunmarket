package com.itwill.shop.ui.최민영;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.shop.member.Member;
import com.itwill.shop.member.MemberService;

import javax.swing.JTabbedPane;

public class ShopMainFrame_최민영 extends JFrame {
	
	/*********1.MemberService멤버필드선언*****/
	private MemberService memberService;
	/*************로그인한회원****************/
	private Member loginMember;
	

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopMainFrame_최민영 frame = new ShopMainFrame_최민영();
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
	public ShopMainFrame_최민영() throws Exception {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 664);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		MemberDetailPanel_최민영 memberDetailPanel_최민영 = new MemberDetailPanel_최민영();
		memberDetailPanel_최민영.setBounds(34, 40, 424, 556);
		contentPane.add(memberDetailPanel_최민영);
		
		
	}
}
