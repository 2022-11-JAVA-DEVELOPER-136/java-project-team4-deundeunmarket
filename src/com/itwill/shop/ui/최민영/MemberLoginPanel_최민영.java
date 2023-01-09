package com.itwill.shop.ui.최민영;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.itwill.shop.member.MemberService;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;

public class MemberLoginPanel_최민영 extends JPanel {
	private JTextField loginIdTF;
	/*********1.MemberService멤버필드선언*****/
	private MemberService memberService;
	private JButton loginBtn;
	private JButton joinBtn;
	private JPasswordField loginPassTF;
	
	

	/**
	 * Create the panel.
	 */
	public MemberLoginPanel_최민영() {
		setForeground(Color.WHITE);
		setLayout(null);
		
		JPanel memberLoginPanel = new JPanel();
		memberLoginPanel.setBackground(Color.WHITE);
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
					if(result==0) {
						//로그인성공
						JOptionPane.showMessageDialog(null, "로그인 성공");
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

	}
}
