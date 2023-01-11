package com.itwill.shop.ui.최민영;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.itwill.shop.member.Member;
import com.itwill.shop.member.MemberService;
import com.itwill.shop.ui.ProductListPanel;
import com.itwill.shop.ui.ShopMainFrame;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class MemberDetailPanel_최민영 extends JPanel {
	/*
	 * 프레임 참조
	 */
	ShopMainFrame frame;
	/*********1.MemberService 멤버필드 선언*****/
	private MemberService memberService;
	/************* 로그인 한 회원 ****************/
	//private Member loginMember= new Member("sy3", "3333", "홍길동", "010-1234-5677", null, "test@gmail.com", "화성시");
	//테스트용 --> 합치고 Member loginMember = null;로 주면된다.
	private Member loginMember = null;
	
	
	public JTextField infoIdTF;
	public JPasswordField infoPassTF;
	public JTextField infoNameTF;
	public JTextField infoPhoneTF;
	public JTextField infoBdayTF;
	public JTextField infoMailTF;
	public JTextField infoAddressTF;
	public JButton updateFormBtn;
	public JButton updateBtn;
	public JLabel infoMsgLB;
	private JLabel memberBdayLB;

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public MemberDetailPanel_최민영() throws Exception {
		
		setLayout(null);
		
		JPanel memberInfoPanel = new JPanel();
		memberInfoPanel.setBackground(Color.WHITE);
		memberInfoPanel.setBounds(0, 0, 360, 540);
		add(memberInfoPanel);
		memberInfoPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setFont(new Font("D2Coding", Font.PLAIN, 12));
		lblNewLabel.setBounds(74, 58, 70, 15);
		memberInfoPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setFont(new Font("D2Coding", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(74, 83, 70, 15);
		memberInfoPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("이름");
		lblNewLabel_2.setFont(new Font("D2Coding", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(74, 109, 70, 15);
		memberInfoPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("전화번호");
		lblNewLabel_3.setFont(new Font("D2Coding", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(74, 134, 70, 15);
		memberInfoPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("생일");
		lblNewLabel_4.setFont(new Font("D2Coding", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(74, 170, 70, 15);
		memberInfoPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("이메일");
		lblNewLabel_5.setFont(new Font("D2Coding", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(74, 195, 70, 15);
		memberInfoPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("주소");
		lblNewLabel_6.setFont(new Font("D2Coding", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(74, 221, 70, 15);
		memberInfoPanel.add(lblNewLabel_6);
		
		infoIdTF = new JTextField();
		infoIdTF.setEnabled(false);
		infoIdTF.setEditable(false);
		infoIdTF.setBounds(156, 55, 96, 21);
		memberInfoPanel.add(infoIdTF);
		infoIdTF.setColumns(10);
		
		infoPassTF = new JPasswordField();
		infoPassTF.setEditable(false);
		infoPassTF.setBounds(156, 80, 96, 21);
		memberInfoPanel.add(infoPassTF);
		
		infoNameTF = new JTextField();
		infoNameTF.setEditable(false);
		infoNameTF.setBounds(156, 105, 96, 21);
		memberInfoPanel.add(infoNameTF);
		infoNameTF.setColumns(10);
		
		infoPhoneTF = new JTextField();
		infoPhoneTF.setEditable(false);
		infoPhoneTF.setBounds(156, 130, 96, 21);
		memberInfoPanel.add(infoPhoneTF);
		infoPhoneTF.setColumns(10);
		
		infoBdayTF = new JTextField();
		infoBdayTF.setEditable(false);
		infoBdayTF.setBounds(156, 168, 96, 21);
		memberInfoPanel.add(infoBdayTF);
		infoBdayTF.setColumns(10);
		
		infoMailTF = new JTextField();
		infoMailTF.setEditable(false);
		infoMailTF.setBounds(156, 192, 96, 21);
		memberInfoPanel.add(infoMailTF);
		infoMailTF.setColumns(10);
		
		infoAddressTF = new JTextField();
		infoAddressTF.setEditable(false);
		infoAddressTF.setBounds(156, 217, 96, 21);
		memberInfoPanel.add(infoAddressTF);
		infoAddressTF.setColumns(10);
		
		updateFormBtn = new JButton("수정하기");
		updateFormBtn.setFont(new Font("D2Coding", Font.PLAIN, 12));
		updateFormBtn.setBackground(new Color(240, 255, 240));
		updateFormBtn.setForeground(Color.BLACK);
		updateFormBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateForm();
			}
		});
		updateFormBtn.setBounds(36, 278, 90, 23);
		memberInfoPanel.add(updateFormBtn);
		
		updateBtn = new JButton("수정완료");
		updateBtn.setFont(new Font("D2Coding", Font.PLAIN, 12));
		updateBtn.setBackground(new Color(240, 255, 240));
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		updateBtn.setBounds(128, 278, 90, 23);
		memberInfoPanel.add(updateBtn);
		
		JButton deleteBtn = new JButton("회원탈퇴");
		deleteBtn.setFont(new Font("D2Coding", Font.PLAIN, 12));
		deleteBtn.setBackground(new Color(240, 255, 240));
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
				frame.changePanel(ShopMainFrame.PANEL_PRODUCT_LIST, null);
			}
		});
		deleteBtn.setBounds(221, 278, 90, 23);
		memberInfoPanel.add(deleteBtn);
		
		infoMsgLB = new JLabel("");
		infoMsgLB.setForeground(Color.RED);
		infoMsgLB.setBounds(57, 21, 213, 15);
		memberInfoPanel.add(infoMsgLB);
		
		memberBdayLB = new JLabel("(예)1999/01/01)");
		memberBdayLB.setFont(new Font("D2Coding", Font.PLAIN, 12));
		memberBdayLB.setBounds(156, 153, 117, 15);
		memberInfoPanel.add(memberBdayLB);
		
		memberService = new MemberService();
		

	}// 생성자 끝
	
	public void setFrame(ShopMainFrame frame) {
		this.frame = frame;
	}

	/************* 수정폼(수정하기) method - 회원정보 수정 가능하도록***************/
	public void updateForm() {
		try {
			String btnText = updateFormBtn.getText();
			if (btnText.equals("수정하기")) {
				updateFormEnable(true);
			} else if (btnText.equals("수정취소")) {
				displayMemberInfo(loginMember);
				updateFormEnable(false);
			}
		} catch (Exception e1) {
			// TODO: handle exception
		}
	}
	
	/*************** 수정완료 method - 회원정보 수정 완료되도록***************/
	
	public void update() {
		/**************** 회원수정 ***************/
		try {
			/****** TextField로 부터 데이타 얻기 *****/
			String id = infoIdTF.getText();
			String password = new String(infoPassTF.getPassword());
			String name = infoNameTF.getText();
			String phone = infoPhoneTF.getText();
			String bday = infoBdayTF.getText();
			String email = infoMailTF.getText();
			String address = infoAddressTF.getText();

			if (id.equals("") || password.equals("") || name.equals("") || phone.equals("") || bday.equals("")
					|| email.equals("") || address.equals("")) {
				infoMsgLB.setText("내용을 입력하십시오.");
				infoIdTF.requestFocus();
				return;
			}

			Member member = new Member(id, password, name, phone, new SimpleDateFormat("yyyy/MM/dd").parse(bday), email,
					address);

			memberService.memberUpdate(member);
			loginMember = memberService.memberDetail(id);
			updateFormEnable(false);
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
	}
	
	/************** 회원탈퇴 method ***************************/
	public void delete() {
		try {		
			String selectedId = infoIdTF.getText();
			String pw1 = loginMember.getM_pass();
			String pw2 = new String(infoPassTF.getPassword()); 
			if (pw1.equals(pw2)) {
				memberService.memberDelete(selectedId);
				JOptionPane.showMessageDialog(null,"탈퇴가 완료되었습니다.");
			}else {
				JOptionPane.showMessageDialog(null, "확인바랍니다.");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	/************* 회원 정보 수정폼 활성화 불활성화 method****************/
	public void updateFormEnable(boolean b) {
		if(b) {
			//활성화
			//infoIdTF.setEnabled(true);
			infoPassTF.setEditable(true);
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
			infoPhoneTF.setEditable(false);
			infoBdayTF.setEditable(false);
			infoMailTF.setEditable(false);
			infoAddressTF.setEditable(false);
			
			updateFormBtn.setText("수정하기");
			updateBtn.setEnabled(false);
		}
		
	}
	public void displayMemberInfo(Member member) throws Exception {
		/**** 회원 상세 데이타 보여주기 method*****/
		infoIdTF.setText(member.getM_id());
		infoPassTF.setText(member.getM_pass());
		infoNameTF.setText(member.getM_name());
		infoPhoneTF.setText(member.getM_phone());
		infoBdayTF.setText(new SimpleDateFormat("yyyy/MM/dd").format(member.getM_bday()));
		infoMailTF.setText(member.getM_email());
		infoAddressTF.setText(member.getM_address());	
	}
}
