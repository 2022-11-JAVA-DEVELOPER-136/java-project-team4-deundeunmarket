package com.itwill.shop.ui.김민영;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import com.itwill.shop.member.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;


import javax.swing.JButton;

import javax.swing.JLabel;

public class MemberDetailPanel_김민영 extends JPanel {
	private MemberService memberService;
	private JPanel memberTabbedPane;
	private JTextField infoIdTF;
	private JPasswordField infoPassTF;
	private JTextField infoNameTF;
	private JTextField infoPhoneTF;
	private JTextField infoBdayTF;
	private JTextField infoEmailTF;
	private JTextField infoAddressTF;
	private JButton updateBtn;
	private JButton updateFormBtn;
	/**
	 * Create the panel.
	 */
	public MemberDetailPanel_김민영() {
		JPanel memberInfoPanel = new JPanel();
		memberInfoPanel.setBackground(Color.LIGHT_GRAY);
		memberInfoPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setBounds(90, 96, 57, 15);
		memberInfoPanel.add(lblNewLabel_1);
		
		infoIdTF = new JTextField();
		infoIdTF.setEnabled(false);
		infoIdTF.setColumns(10);
		infoIdTF.setBounds(168, 93, 116, 21);
		memberInfoPanel.add(infoIdTF);
		
		JLabel 패쓰워드_1 = new JLabel("패쓰워드");
		패쓰워드_1.setBounds(90, 145, 57, 15);
		memberInfoPanel.add(패쓰워드_1);
		
		infoPassTF = new JPasswordField();
		infoPassTF.setEditable(false);
		infoPassTF.setBounds(168, 143, 116, 18);
		memberInfoPanel.add(infoPassTF);
		
		JLabel lblNewLabel_2_1 = new JLabel("이름");
		lblNewLabel_2_1.setBounds(90, 190, 57, 15);
		memberInfoPanel.add(lblNewLabel_2_1);
		
		infoNameTF = new JTextField();
		infoNameTF.setEditable(false);
		infoNameTF.setColumns(10);
		infoNameTF.setBounds(168, 187, 116, 21);
		memberInfoPanel.add(infoNameTF);
		
		JLabel lblNewLabel_3_1 = new JLabel("전화번호");
		lblNewLabel_3_1.setBounds(90, 241, 57, 15);
		memberInfoPanel.add(lblNewLabel_3_1);
		
		infoPhoneTF = new JTextField();
		infoPhoneTF.setEditable(false);
		infoPhoneTF.setColumns(10);
		infoPhoneTF.setBounds(168, 238, 116, 21);
		memberInfoPanel.add(infoPhoneTF);
		
		JLabel lblNewLabel_4_1 = new JLabel("생일");
		lblNewLabel_4_1.setBounds(90, 289, 57, 15);
		memberInfoPanel.add(lblNewLabel_4_1);
		
		infoBdayTF = new JTextField();
		infoBdayTF.setEnabled(false);
		infoBdayTF.setColumns(10);
		infoBdayTF.setBounds(168, 285, 116, 23);
		memberInfoPanel.add(infoBdayTF);
		
		infoEmailTF = new JTextField();
		infoEmailTF.setEnabled(false);
		infoEmailTF.setColumns(10);
		infoEmailTF.setBounds(168, 358, 116, 19);
		memberInfoPanel.add(infoEmailTF);
		
		JLabel lblNewLabel_6_1 = new JLabel("주소");
		
		infoAddressTF = new JTextField();
		infoAddressTF.setEnabled(false);
		infoAddressTF.setColumns(10);
		infoAddressTF.setBounds(168, 420, 116, 19);
		memberInfoPanel.add(infoAddressTF);
		
		updateFormBtn = new JButton("수정폼");
		updateFormBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String btnText=updateFormBtn.getText();
				if(btnText.equals("수정폼")) {
					updateFormEnable(true);
				}else if(btnText.equals("수정취소")) {
				
					updateFormEnable(false);
				}
				
				
			}

			private void updateFormEnable(boolean b) {
				// TODO Auto-generated method stub
				
			}

			
		});
		updateFormBtn.setBounds(78, 512, 97, 23);
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
					String bday=infoBdayTF.getText();
					String email=infoEmailTF.getText();
					String address=infoAddressTF.getText();
					
					Member member=new Member(id,password,name,phone,new SimpleDateFormat("yyyy/MM/dd").parse(bday),email,address);
					memberService.memberUpdate(member);
					updateFormEnable(false);
				}catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		updateBtn.setBounds(187, 512, 97, 23);
		memberInfoPanel.add(updateBtn);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("이메일");
		lblNewLabel_4_1_1.setBounds(90, 360, 57, 15);
		memberInfoPanel.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("주소");
		lblNewLabel_4_1_2.setBounds(90, 422, 57, 15);
		memberInfoPanel.add(lblNewLabel_4_1_2);
	}
		/*************회원수정폼활성화 불활성화****************/
		private void updateFormEnable(boolean b) {
			if(b) {
				//활성화
				//infoIdTF.setEnabled(true);
				//infoPassTF.setEnabled(true);
				infoNameTF.setEditable(true);
				infoPhoneTF.setEditable(true);
				infoBdayTF.setEditable(true);
				infoEmailTF.setEditable(true);
				infoAddressTF.setEditable(true);
				
				updateFormBtn.setText("수정취소");
				updateBtn.setEnabled(true);
			}else {
				//불활성화
				infoIdTF.setEnabled(false);
				infoPassTF.setEnabled(false);
				infoNameTF.setEditable(false);
				infoPhoneTF.setEditable(false);
				infoBdayTF.setEditable(false);
				infoEmailTF.setEditable(false);
				infoAddressTF.setEditable(false);
				
				updateFormBtn.setText("수정폼");
				updateBtn.setEnabled(false);
			}
			
		}
	}

