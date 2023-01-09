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

public class MemberJoinPanel_최민영 extends JPanel {
	/*********1.MemberService멤버필드선언*****/
	private MemberService memberService;
	
	

	private JTextField idTF;
	private JPasswordField passwordTF;
	private JTextField nameTF;
	private JTextField phoneTF;
	private JTextField bdayTF;
	private JTextField emailTF;
	private JTextField addressTF;
	private JPasswordField passCheckTF;
	private JButton pwCheckbtn;

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
					
					if (id.equals("")) {
						JOptionPane.showMessageDialog(null, "아이디를 입력하세요.");
						idTF.requestFocus();
						return;
					}
					
					Member newMember = new Member(id, password, name, phone, new SimpleDateFormat("yyyy/MM/dd").parse(bday), email, address);
					boolean isAdd = memberService.addMember(newMember);
					
					if (isAdd==true) {
						JOptionPane.showMessageDialog(null,"회원가입에 성공하셨습니다.");
					}
					else {
						JOptionPane.showMessageDialog(null,"회원가입에 실패하셨습니다.");
					}
					
					
					
				}catch (Exception e1) {
					e1.printStackTrace();
					System.out.println("회원가입-->"+e1.getMessage());
				}
				
				
			}
		});
		memberjoinBtn.setBounds(46, 443, 97, 23);
		memberJoinPannel.add(memberjoinBtn);
		
		JButton memberCancelBtn = new JButton("취소");
		memberCancelBtn.setBounds(183, 443, 97, 23);
		memberJoinPannel.add(memberCancelBtn);
		
		passCheckTF = new JPasswordField();
		passCheckTF.setBounds(131, 158, 116, 21);
		memberJoinPannel.add(passCheckTF);
		
		JLabel lblNewLabel_7 = new JLabel("비밀번호확인");
		lblNewLabel_7.setBounds(26, 161, 82, 15);
		memberJoinPannel.add(lblNewLabel_7);
		
		pwCheckbtn = new JButton("비밀번호확인");
		pwCheckbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password=new String(passwordTF.getPassword());
				String passwordc=new String(passCheckTF.getPassword());
				
				if (password.equals(passwordc)) {
					JOptionPane.showMessageDialog(null, "일치하는 비밀번호입니다..");
				} else {
					JOptionPane.showMessageDialog(null, "일치하지않는 비밀번호입니다.");
					return;

				}
				
			}
		});
		pwCheckbtn.setBounds(251, 144, 97, 23);
		memberJoinPannel.add(pwCheckbtn);
		
		
		memberService=new MemberService();

	}
	
	
	
	
}
