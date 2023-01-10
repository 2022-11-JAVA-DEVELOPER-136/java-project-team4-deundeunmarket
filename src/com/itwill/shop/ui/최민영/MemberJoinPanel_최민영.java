package com.itwill.shop.ui.최민영;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.itwill.shop.member.Member;
import com.itwill.shop.member.MemberService;

import java.text.SimpleDateFormat;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class MemberJoinPanel_최민영 extends JPanel {
	/*********1.MemberService멤버필드선언*****/
	private MemberService memberService;
	
	/*************로그인한회원****************/
	private Member loginMember=null;
	

	private JTextField idTF;
	private JPasswordField passwordTF;
	private JTextField nameTF;
	private JTextField phoneTF;
	private JTextField bdayTF;
	private JTextField emailTF;
	private JTextField addressTF;
	private JPasswordField passCheckTF;
	private JLabel idMsgLB;
	private JLabel pwMsgLb;

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public MemberJoinPanel_최민영() throws Exception {
		setLayout(null);
		
		JPanel memberJoinPannel = new JPanel();
		memberJoinPannel.setBounds(0, 0, 360, 540);
		add(memberJoinPannel);
		memberJoinPannel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setBounds(51, 95, 57, 15);
		memberJoinPannel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setBounds(51, 130, 57, 15);
		memberJoinPannel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("이름");
		lblNewLabel_2.setBounds(51, 199, 57, 15);
		memberJoinPannel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("전화번호");
		lblNewLabel_3.setBounds(51, 241, 57, 15);
		memberJoinPannel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("생일");
		lblNewLabel_4.setBounds(51, 285, 57, 15);
		memberJoinPannel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("이메일");
		lblNewLabel_5.setBounds(51, 333, 57, 15);
		memberJoinPannel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("주소");
		lblNewLabel_6.setBounds(51, 377, 57, 15);
		memberJoinPannel.add(lblNewLabel_6);
		
		idTF = new JTextField();
		idTF.setBounds(131, 92, 116, 21);
		memberJoinPannel.add(idTF);
		idTF.setColumns(10);
		
		passwordTF = new JPasswordField();
		passwordTF.setBounds(131, 127, 116, 21);
		memberJoinPannel.add(passwordTF);
		
		nameTF = new JTextField();
		nameTF.setBounds(131, 199, 116, 21);
		memberJoinPannel.add(nameTF);
		nameTF.setColumns(10);
		
		phoneTF = new JTextField();
		phoneTF.setBounds(131, 238, 116, 21);
		memberJoinPannel.add(phoneTF);
		phoneTF.setColumns(10);
		
		bdayTF = new JTextField();
		bdayTF.setBounds(131, 285, 116, 21);
		memberJoinPannel.add(bdayTF);
		bdayTF.setColumns(10);
		
		emailTF = new JTextField();
		emailTF.setBounds(131, 330, 116, 21);
		memberJoinPannel.add(emailTF);
		emailTF.setColumns(10);
		
		addressTF = new JTextField();
		addressTF.setBounds(131, 374, 116, 21);
		memberJoinPannel.add(addressTF);
		addressTF.setColumns(10);
		
		JButton memberjoinBtn = new JButton("가입");
		memberjoinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					join();
			}
		});
		memberjoinBtn.setBounds(46, 443, 97, 23);
		memberJoinPannel.add(memberjoinBtn);
		
		//취소 누르면 화면전환 필요!
		JButton memberCancelBtn = new JButton("취소");
		memberCancelBtn.setBounds(183, 443, 97, 23);
		memberJoinPannel.add(memberCancelBtn);
		
		passCheckTF = new JPasswordField();
		
		
		passCheckTF.setBounds(131, 158, 116, 21);
		memberJoinPannel.add(passCheckTF);
		
		JLabel lblNewLabel_7 = new JLabel("비밀번호확인");
		lblNewLabel_7.setBounds(26, 161, 82, 15);
		memberJoinPannel.add(lblNewLabel_7);
		
		idMsgLB = new JLabel("");
		idMsgLB.setForeground(Color.RED);
		idMsgLB.setBounds(131, 54, 101, 29);
		memberJoinPannel.add(idMsgLB);
		
		pwMsgLb = new JLabel("");
		pwMsgLb.setForeground(Color.RED);
		pwMsgLb.setBounds(247, 130, 101, 15);
		memberJoinPannel.add(pwMsgLb);
		
		JButton duplicateIdBtn = new JButton("중복확인");
		duplicateIdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idTF.getText();
				
				boolean isAdd;
				try {
					isAdd = memberService.isDuplicateId(id);
					if(isAdd==false) {
						JOptionPane.showMessageDialog(null, "사용가능한 아이디입니다.");
						idTF.requestFocus();
						idTF.setSelectionStart(0);
						idTF.setSelectionEnd(id.length());
				}else {
					JOptionPane.showMessageDialog(null, "이미 사용하고있는 아이디입니다.");
					idTF.requestFocus();
					idTF.setSelectionStart(0);
					idTF.setSelectionEnd(id.length());
				}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		duplicateIdBtn.setBounds(259, 91, 97, 23);
		memberJoinPannel.add(duplicateIdBtn);
		
		JButton passCheckBtn = new JButton("비밀번호확인");
		passCheckBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passCheck();
			}
		});
		passCheckBtn.setFont(new Font("굴림", Font.PLAIN, 10));
		passCheckBtn.setBounds(257, 157, 97, 23);
		memberJoinPannel.add(passCheckBtn);
		
		JLabel lblNewLabel_8 = new JLabel("(예)1999/01/01)");
		lblNewLabel_8.setBounds(141, 264, 87, 21);
		memberJoinPannel.add(lblNewLabel_8);
		
		
		memberService=new MemberService();

	}
	/*************회원가입 method***********/
	public void join() {
		/*********** 회원가입 ************/
		try {
			/******TextField로 부터 데이타얻기*****/
			String id = idTF.getText();
			String password=new String(passwordTF.getPassword());
			String passwordc=new String(passCheckTF.getPassword());
			String name=nameTF.getText();
			String phone=phoneTF.getText();
			String bday = bdayTF.getText();
			String email = emailTF.getText();
			String address = addressTF.getText();
			/********** 유효성 체크 **************/
			if (id.equals("")) {
				idMsgLB.setText("아이디를 입력하세요.");
				idTF.requestFocus();
				return;
			}
			
			if (password.equals("")) {
				pwMsgLb.setText("비밀번호를 입력하세요.");
				passwordTF.requestFocus();
				return;
			}
			
			
			
			Member newMember = new Member(id, password, name, phone, new SimpleDateFormat("yyyy/MM/dd").parse(bday), email, address);
			boolean isAdd = memberService.addMember(newMember);
			
			if (isAdd==true) {
				JOptionPane.showMessageDialog(null,"회원가입에 성공하셨습니다.");
				/* 로그인화면전환
				 memberTabbedPane.setSelectedIndex(1); */
			}
			else {
				JOptionPane.showMessageDialog(null,"다시 확인바랍니다.");
				idTF.requestFocus();
				idTF.setSelectionStart(0);
				idTF.setSelectionEnd(id.length());
			}
			
			
			
		}catch (Exception e1) {
			e1.printStackTrace();
			System.out.println("회원가입-->"+e1.getMessage());
		}
	}
	/*******************비밀번호 확인 메쏘드***************/
	public void passCheck() {
		String password=new String(passwordTF.getPassword());
		String passwordc=new String(passCheckTF.getPassword());
		
		if (password.equals(passwordc)) {
			JOptionPane.showMessageDialog(null, "일치하는 비밀번호입니다.");
			passwordTF.requestFocus();
			passwordTF.setSelectionStart(0);
			passwordTF.setSelectionEnd(password.length());
		} else {
			JOptionPane.showMessageDialog(null, "일치하지않는 비밀번호입니다.");
			passwordTF.requestFocus();
			passwordTF.setSelectionStart(0);
			passwordTF.setSelectionEnd(password.length());
			return;
		}
		
	}
	
	
	
	
	
	
}
