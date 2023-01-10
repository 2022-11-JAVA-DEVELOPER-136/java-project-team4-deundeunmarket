package com.itwill.shop.ui.김민영;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.itwill.shop.member.*;
import java.awt.Font;

public class MemberLoginPanel_김민영 extends JPanel {
	private MemberService memberService;
	private JTabbedPane memberTabbedPane;
	private JTextField loginIdTF;
	private JPasswordField loginPassTF;
	private JMenuItem loginMenuItem;
	private JMenuItem joinMenuItem;
	private JMenuItem logoutMenuItem;
	private JLabel idMsgLB;
	
	
	
	private Member loginMember=null;
	/**
	 * Create the panel.
	 */
	public MemberLoginPanel_김민영() {
		JPanel memberLoginPanel = new JPanel();
		memberLoginPanel.setBackground(new Color(46, 139, 87));
		memberTabbedPane.addTab("회원로그인", null, memberLoginPanel, null);
		memberLoginPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("로그인");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("D2Coding", Font.PLAIN, 22));
		lblNewLabel.setBounds(147, 90, 66, 38);
		memberLoginPanel.add(lblNewLabel);
		
		JPanel memberLoginPanel_1 = new JPanel();
		memberLoginPanel_1.setLayout(null);
		memberLoginPanel_1.setBackground(new Color(46, 139, 87));
		memberLoginPanel_1.setBounds(0, 0, 312, 431);
		memberLoginPanel.add(memberLoginPanel_1);
		
		JButton joinBtn = new JButton("회원가입");
		joinBtn.setBounds(198, 284, 89, 23);
		memberLoginPanel_1.add(joinBtn);
		joinBtn.setFont(new Font("D2Coding", Font.PLAIN, 14));
		

		
		JLabel passwordLB = new JLabel("아이디");
		passwordLB.setBounds(102, 204, 57, 15);
		memberLoginPanel_1.add(passwordLB);
		passwordLB.setFont(new Font("D2Coding", Font.PLAIN, 12));
		passwordLB.setForeground(Color.WHITE);
		
		loginIdTF = new JTextField();
		loginIdTF.setBounds(184, 196, 116, 21);
		memberLoginPanel_1.add(loginIdTF);
		loginIdTF.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("패쓰워드");
		lblNewLabel_6.setBounds(102, 247, 57, 15);
		memberLoginPanel_1.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("D2Coding", Font.PLAIN, 12));
		lblNewLabel_6.setForeground(Color.WHITE);
		
		loginPassTF = new JPasswordField();
		loginPassTF.setBounds(184, 241, 116, 21);
		memberLoginPanel_1.add(loginPassTF);
		
		JButton loginBtn = new JButton("");
		loginBtn.setBounds(73, 284, 75, 23);
		memberLoginPanel_1.add(loginBtn);
		loginBtn.setIcon(new ImageIcon(MemberLoginPanel_김민영.class.getResource("/com/itwill/shop/ui/login_my.png")));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(32, 50, 105, 108);
		memberLoginPanel_1.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(MemberLoginPanel_김민영.class.getResource("/image/user_my.png")));
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/***********회원로그인************/
				try {
					String id = loginIdTF.getText();
					String pass=new String(loginPassTF.getPassword());
					
					int result = memberService.logIn(id, pass);
					if(result==0) {
						//로그인성공
						loginProcess(id);
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
		joinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberTabbedPane.setSelectedIndex(1);
			}
		});
	}
	private void loginProcess(String id) throws Exception{
		/***********로그인성공시 해야할일***********
		 1.로그인성공한 멤버객체 멤버필드에저장
		 2.MemberMainFrame타이틀변경
		 3.로그인,회원가입탭 불활성화
		   로그인,회원가입 메뉴아이템 불활성화
		   로그아웃 메뉴아이템 활성화
		 4.회원정보보기 화면전환
		********************************************/
		//2.MemberMainFrame타이틀변경
		// 3.로그인,회원가입탭 불활성화
		memberTabbedPane.setEnabledAt(1, false);
		memberTabbedPane.setEnabledAt(2, false);
		memberTabbedPane.setEnabledAt(3, true);
		loginMenuItem.setEnabled(false);
		joinMenuItem.setEnabled(false);
		logoutMenuItem.setEnabled(true);
		
		
	}
}
