package com.itwill.shop.ui.김민영;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.itwill.shop.member.*;

public class MemberJoinPanel_김민영 extends JPanel {
	
	private MemberService memberService;
	private JTabbedPane memberTabbedPane;
	private JTextField idTF;
	private JPasswordField passTF;
	private JTextField nameTF;
	private JTextField phoneTF;
	private JTextField bdayTF;
	private JTextField emailTF;
	private JTextField addressTF;
	private JLabel idMsgLB;
	private JPasswordField passwordField;
	/**
	 * Create the panel.
	 */
	public MemberJoinPanel_김민영() {
		JPanel memberJoinPanel = new JPanel();
		memberJoinPanel.setBackground(new Color(46, 139, 87));
		memberTabbedPane.addTab("회원가입", null, memberJoinPanel, null);
		memberJoinPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setBounds(53, 60, 57, 15);
		memberJoinPanel.add(lblNewLabel);
		
		idTF = new JTextField();
		idTF.setBounds(166, 58, 156, 21);
		memberJoinPanel.add(idTF);
		idTF.setColumns(10);
		
		JLabel 비밀번호 = new JLabel("비밀번호");
		비밀번호.setBounds(53, 109, 57, 15);
		memberJoinPanel.add(비밀번호);
		
		JLabel lblNewLabel_2 = new JLabel("이름");
		lblNewLabel_2.setBounds(53, 208, 57, 15);
		memberJoinPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("전화번호");
		lblNewLabel_3.setBounds(53, 258, 57, 15);
		memberJoinPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("생일");
		lblNewLabel_4.setBounds(53, 308, 57, 15);
		memberJoinPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("이메일");
		lblNewLabel_5.setBounds(53, 358, 57, 15);
		memberJoinPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("배송지");
		lblNewLabel_6.setBounds(53, 408, 57, 15);
		memberJoinPanel.add(lblNewLabel_6);
		
		passTF = new JPasswordField();
		passTF.setBounds(166, 108, 156, 18);
		memberJoinPanel.add(passTF);
		
		nameTF = new JTextField();
		nameTF.setBounds(166, 208, 156, 21);
		memberJoinPanel.add(nameTF);
		nameTF.setColumns(10);
		
		phoneTF = new JTextField();
		phoneTF.setBounds(166, 258, 156, 21);
		memberJoinPanel.add(phoneTF);
		phoneTF.setColumns(10);
		
		bdayTF = new JTextField();
		bdayTF.setBounds(166, 308, 156, 21);
		memberJoinPanel.add(bdayTF);
		bdayTF.setColumns(10);
		
		emailTF = new JTextField();
		emailTF.setBounds(166, 358, 156, 21);
		memberJoinPanel.add(emailTF);
		emailTF.setColumns(10);
		
		addressTF = new JTextField();
		addressTF.setBounds(166, 408, 156, 21);
		memberJoinPanel.add(addressTF);
		addressTF.setColumns(10);
		
	
		JButton memberJoinBtn = new JButton("가입");
		memberJoinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*********** 회원가입 ************/
				try {
					/******TextField로 부터 데이타얻기*****/
					String id = idTF.getText();
					String password=new String(passTF.getPassword());
					String name=nameTF.getText();
					String phone=phoneTF.getText();
					String bday=bdayTF.getText();
					String email=emailTF.getText();
					String address=addressTF.getText();
					/***********유효성체크****************/
					if(id.equals("")) {
						idMsgLB.setText("아이디를 입력하세요.");
						 idTF.requestFocus();
						return;
					}
					
					
					
					Member newMember=new Member(id,password,name,phone,new SimpleDateFormat("yyyy/MM/dd").parse(bday),email,address);
					boolean isAdd = memberService.addMember(newMember);
					if(isAdd) {
						//로그인화면전환
						 memberTabbedPane.setSelectedIndex(1);
					}else {
						JOptionPane.showMessageDialog(null, "이미사용하고있는 아이디입니다.");
						idTF.requestFocus();
						idTF.setSelectionStart(0);
						idTF.setSelectionEnd(id.length());
					}
				}catch (Exception e1) {
					System.out.println("회원가입-->"+e1.getMessage());
				}
			}
		});
		memberJoinBtn.setBounds(80, 495, 97, 23);
		memberJoinPanel.add(memberJoinBtn);
		
		JButton memberCancleBtn = new JButton("취소");
		memberCancleBtn.setBounds(193, 495, 97, 23);
		memberJoinPanel.add(memberCancleBtn);
		
		idMsgLB = new JLabel("");
		idMsgLB.setForeground(Color.RED);
		idMsgLB.setBounds(131, 82, 116, 15);
		memberJoinPanel.add(idMsgLB);
		
		JLabel 패쓰워드_1 = new JLabel("비밀번호 확인");
		패쓰워드_1.setBounds(53, 158, 76, 15);
		memberJoinPanel.add(패쓰워드_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(166, 158, 156, 18);
		memberJoinPanel.add(passwordField);
		
	}

}
