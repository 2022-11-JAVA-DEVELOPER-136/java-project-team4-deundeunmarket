package com.itwill.shop.ui.최민영;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.itwill.shop.member.Member;
import com.itwill.shop.member.MemberService;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class MemberDetailPanel_최민영 extends JPanel {
	/*********1.MemberService멤버필드선언*****/
	private MemberService memberService;
	/*************로그인한회원****************/
	private Member loginMember=null;
	
	
	private JTextField infoIdTF;
	private JPasswordField infoPassTF;
	private JTextField infoNameTF;
	private JTextField infoPhoneTF;
	private JTextField infoBdayTF;
	private JTextField infoMailTF;
	private JTextField infoAddressTF;
	private JButton updateFormBtn;
	private JButton updateBtn;

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public MemberDetailPanel_최민영() throws Exception {
		setLayout(null);
		
		JPanel memberInfoPanel = new JPanel();
		memberInfoPanel.setBounds(0, 0, 360, 540);
		add(memberInfoPanel);
		memberInfoPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setBounds(50, 111, 50, 15);
		memberInfoPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setBounds(50, 156, 50, 15);
		memberInfoPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("이름");
		lblNewLabel_2.setBounds(50, 208, 50, 15);
		memberInfoPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("전화번호");
		lblNewLabel_3.setBounds(50, 255, 50, 15);
		memberInfoPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("생일");
		lblNewLabel_4.setBounds(50, 307, 50, 15);
		memberInfoPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("이메일");
		lblNewLabel_5.setBounds(50, 356, 50, 15);
		memberInfoPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("주소");
		lblNewLabel_6.setBounds(50, 407, 50, 15);
		memberInfoPanel.add(lblNewLabel_6);
		
		infoIdTF = new JTextField();
		infoIdTF.setBounds(132, 108, 96, 21);
		memberInfoPanel.add(infoIdTF);
		infoIdTF.setColumns(10);
		
		infoPassTF = new JPasswordField();
		infoPassTF.setBounds(132, 153, 96, 21);
		memberInfoPanel.add(infoPassTF);
		
		infoNameTF = new JTextField();
		infoNameTF.setBounds(132, 205, 96, 21);
		memberInfoPanel.add(infoNameTF);
		infoNameTF.setColumns(10);
		
		infoPhoneTF = new JTextField();
		infoPhoneTF.setBounds(132, 255, 96, 21);
		memberInfoPanel.add(infoPhoneTF);
		infoPhoneTF.setColumns(10);
		
		infoBdayTF = new JTextField();
		infoBdayTF.setBounds(132, 304, 96, 21);
		memberInfoPanel.add(infoBdayTF);
		infoBdayTF.setColumns(10);
		
		infoMailTF = new JTextField();
		infoMailTF.setBounds(132, 353, 96, 21);
		memberInfoPanel.add(infoMailTF);
		infoMailTF.setColumns(10);
		
		infoAddressTF = new JTextField();
		infoAddressTF.setBounds(132, 404, 96, 21);
		memberInfoPanel.add(infoAddressTF);
		infoAddressTF.setColumns(10);
		
		updateFormBtn = new JButton("수정폼");
		updateFormBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String btnText=updateFormBtn.getText();
				if(btnText.equals("수정폼")) {
					updateFormEnable(true);
				}else if(btnText.equals("수정취소")) {
					displayMemberInfo(loginMember);
					updateFormEnable(false);
				}	
				}catch (Exception e1) {
					// TODO: handle exception
				}
			}
		});
		updateFormBtn.setBounds(38, 458, 91, 23);
		memberInfoPanel.add(updateFormBtn);
		
		updateBtn = new JButton("수정");
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**************** 회원수정 ***************/
				try {
					/******TextField로 부터 데이타얻기*****/
					String id = infoIdTF.getText();
					String password=new String(infoPassTF.getPassword());
					String name=infoNameTF.getText();
					String phone=infoPhoneTF.getText();
					String bday = infoBdayTF.getText();
					String email = infoMailTF.getText();
					String address = infoAddressTF.getText();
					
					Member member=new Member(id, password, name, phone, new SimpleDateFormat("yyyy/MM/dd").parse(bday), email, address);
					
					
					memberService.memberUpdate(member);
					loginMember = memberService.memberDetail(id);
					updateFormEnable(false);
				}catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				
			}
		});
		updateBtn.setBounds(182, 458, 91, 23);
		memberInfoPanel.add(updateBtn);
		
		memberService = new MemberService();
		
		
		
		

	}
	/*************회원수정폼활성화 불활성화****************/
	private void updateFormEnable(boolean b) {
		if(b) {
			//활성화
			//infoIdTF.setEnabled(true);
			infoPassTF.setEnabled(true);
			infoNameTF.setEditable(true);
			infoPhoneTF.setEditable(true);
			infoBdayTF.setEditable(true);
			infoMailTF.setEditable(true);
			infoAddressTF.setEditable(true);
			
			
			updateFormBtn.setText("수정취소");
			updateBtn.setEnabled(true);
		}else {
			//불활성화
			infoIdTF.setEnabled(false);
			infoPassTF.setEnabled(false);
			infoNameTF.setEditable(false);
			infoPhoneTF.setEditable(true);
			infoBdayTF.setEditable(true);
			infoMailTF.setEditable(true);
			infoAddressTF.setEditable(false);
			
			
			updateFormBtn.setText("수정폼");
			updateBtn.setEnabled(false);
		}
		
	}
	private void displayMemberInfo(Member member) throws Exception {
		/****회원상세데이타보여주기*****/
		infoIdTF.setText(member.getM_id());
		infoPassTF.setText(member.getM_pass());
		infoNameTF.setText(member.getM_name());
		infoPhoneTF.setText(member.getM_phone());
		member.setM_bday(new SimpleDateFormat("yyyy/MM/dd").parse(infoBdayTF.getText()));
		infoMailTF.setText(member.getM_email());
		infoAddressTF.setText(member.getM_address());
		
		
		
	}
	
	
	
}
