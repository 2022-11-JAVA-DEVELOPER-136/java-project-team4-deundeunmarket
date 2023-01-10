package com.itwill.shop.ui.최민영;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.itwill.shop.member.Member;
import com.itwill.shop.member.MemberService;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;

public class MemberLoginPanel_최민영 extends JPanel {
	/*********1.MemberService멤버필드선언*****/
	private MemberService memberService;
	/*************로그인한회원****************/
	private Member loginMember=null;
	
	
	
	private JTextField loginIdTF;
	private JButton loginBtn;
	private JButton joinBtn;
	private JPasswordField loginPassTF;
	
	

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public MemberLoginPanel_최민영() throws Exception {
		setForeground(Color.WHITE);
		setLayout(null);
		
		JPanel memberLoginPanel = new JPanel();
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
				//회원가입 버튼 클릭시, 회원가입으로 연결되야 한다.!
			}
		});
		joinBtn.setBounds(47, 358, 97, 23);
		memberLoginPanel.add(joinBtn);
		
		loginBtn = new JButton("로그인");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/***********회원로그인************/
				try {
					String id = loginIdTF.getText();
					String pass=new String(loginPassTF.getPassword());
					
					int result = memberService.logIn(id, pass);
					if(result==1) {
						//로그인성공
						JOptionPane.showMessageDialog(null, "로그인 성공");
						loginProcess(id); //로그인 멤버로 넣어줌
						loginIdTF.setText("");
						loginPassTF.setText("");
					}else {
						JOptionPane.showMessageDialog(null, "아이디또는 비밀번호를 확인하세요");
						loginIdTF.setSelectionStart(0);
						loginIdTF.setSelectionEnd(id.length());
						loginIdTF.requestFocus();
					}
					
					
					
				}catch (Exception e1) {
					// TODO: handle exception
				}
				
				
			}
		});
		loginBtn.setBounds(193, 358, 97, 23);
		memberLoginPanel.add(loginBtn);
		
		loginPassTF = new JPasswordField();
		loginPassTF.setBounds(145, 265, 116, 21);
		memberLoginPanel.add(loginPassTF);
		
		
		memberService=new MemberService();
		
		

	}
	/**************로그인성공시 호출할메쏘드***************/
	private void loginProcess(String id) throws Exception{
		/***********로그인성공시 해야할일***********
			 1.로그인성공한 멤버객체 멤버필드에저장
			 2.MemberMainFrame타이틀변경
			 3.로그인,회원가입탭 불활성화
			   로그인,회원가입 메뉴아이템 불활성화
			   로그아웃 메뉴아이템 활성화
			 4.회원정보보기 화면전환
		 ********************************************/
		//1.로그인성공한 멤버객체 멤버필드에저장
		this.loginMember = memberService.memberDetail(id);
	/*	
		//2.MemberMainFrame타이틀변경
		setTitle(id+" 님 로그인");
		// 3.로그인,회원가입탭 불활성화
		memberTabbedPane.setEnabledAt(1, false);
		memberTabbedPane.setEnabledAt(2, false);
		memberTabbedPane.setEnabledAt(3, true);
		loginMenuItem.setEnabled(false);
		joinMenuItem.setEnabled(false);
		logoutMenuItem.setEnabled(true); */
		
	/*	
		// 4.회원정보보기 화면전환
		memberTabbedPane.setSelectedIndex(3);
		displayMemberInfo(this.loginMember);
		updateFormEnable(false); */ 
	}
}
