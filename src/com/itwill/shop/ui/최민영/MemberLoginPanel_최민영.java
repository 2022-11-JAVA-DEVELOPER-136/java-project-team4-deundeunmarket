package com.itwill.shop.ui.최민영;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.itwill.shop.member.Member;
import com.itwill.shop.member.MemberService;
import com.itwill.shop.ui.ShopMainFrame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;

public class MemberLoginPanel_최민영 extends JPanel {
	/*
	 * 프레임 참조
	 */
	ShopMainFrame frame;
	/*********1. MemberService 멤버필드 선언 *****/
	private MemberService memberService;
	
	/*************로그인 한 회원****************/
	private Member loginMember=null;
	
	
	private JTextField loginIdTF;
	private JButton loginBtn;
	private JButton joinBtn;
	private JPasswordField loginPassTF;
	private JPanel memberLoginPanel;


	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public MemberLoginPanel_최민영() throws Exception {
		setForeground(Color.WHITE);
		setLayout(null);
		
		memberLoginPanel = new JPanel();
		memberLoginPanel.setBackground(Color.LIGHT_GRAY);
		memberLoginPanel.setBounds(0, 0, 360, 540);
		add(memberLoginPanel);
		memberLoginPanel.setLayout(null);
		
		JLabel idLB = new JLabel("아이디");
		idLB.setBounds(57, 206, 57, 15);
		memberLoginPanel.add(idLB);
		
		JLabel passLB = new JLabel("비밀번호");
		passLB.setBounds(57, 268, 57, 15);
		memberLoginPanel.add(passLB);
		
		loginIdTF = new JTextField();
		loginIdTF.setBounds(145, 203, 116, 21);
		memberLoginPanel.add(loginIdTF);
		loginIdTF.setColumns(10);
		
		joinBtn = new JButton("회원가입");
		joinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * 회원가입 버튼 클릭 시 회원가입 패널로 이동
				 */
				frame.changePanel(ShopMainFrame.PANEL_MEMBER_JOIN, null);
			}
		});
		joinBtn.setBounds(47, 358, 97, 23);
		memberLoginPanel.add(joinBtn);
		
		loginBtn = new JButton("로그인");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
				frame.changePanel(ShopMainFrame.PANEL_PRODUCT_LIST, null);
			}
		});
		loginBtn.setBounds(193, 358, 97, 23);
		memberLoginPanel.add(loginBtn);
		
		loginPassTF = new JPasswordField();
		loginPassTF.setBounds(145, 265, 116, 21);
		memberLoginPanel.add(loginPassTF);
		
		
		memberService=new MemberService();
		
		

	}// 생성자 끝
	
	public void setFrame(ShopMainFrame frame) {
		this.frame = frame;
	}

	/**************로그인 성공 시 호출할 메쏘드***************/

	public void loginProcess(String id) throws Exception{
		
		//1.로그인 성공한 멤버 객체 멤버필드에저장
		this.loginMember = memberService.memberDetail(id);
		//2.MemberMainFrame 타이틀 변경
		frame.setTitle(id + " 님 로그인");
		// 3.로그인, 회원가입 탭 불 활성화
		frame.memberTabbedPane.setEnabledAt(0, false);
		frame.memberTabbedPane.setEnabledAt(1, false);
		// 4.상품 전체보기로 화면전환
		frame.productTabbedPane.setSelectedIndex(0);
	}
	
	public void login() {
		/*********** 회원 로그인 method ************/
		try {
			String id = loginIdTF.getText();
			String pass=new String(loginPassTF.getPassword());
			
			int result = memberService.logIn(id, pass);
			if(result == 1) {
				//로그인 성공
				JOptionPane.showMessageDialog(null, "로그인 성공");
				loginProcess(id); //로그인 멤버로 넣어줌
				loginIdTF.setText(""); 
				loginPassTF.setText("");
			}else {
				JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 확인하세요");
				loginIdTF.setSelectionStart(0);
				loginIdTF.setSelectionEnd(id.length());
				loginIdTF.requestFocus();
			}
			
		}catch (Exception e1) {
			// TODO: handle exception
		}
	}
}
