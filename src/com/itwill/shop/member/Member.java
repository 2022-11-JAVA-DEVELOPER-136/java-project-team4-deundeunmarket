package com.itwill.shop.member;

import java.util.Date;

public class Member {
	private String m_id;
	private String m_pass;
	private String m_name;
	private String m_phone;
	private Date m_bday;
	private String m_email;
	private String m_address;
	
	
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pass() {
		return m_pass;
	}
	public void setM_pass(String m_pass) {
		this.m_pass = m_pass;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_phone() {
		return m_phone;
	}
	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}
	public Date getM_bday() {
		return m_bday;
	}
	public void setM_bday(Date m_bday) {
		this.m_bday = m_bday;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public String getM_address() {
		return m_address;
	}
	public void setM_address(String m_address) {
		this.m_address = m_address;
	}

	public Member(String m_id, String m_pass, String m_name, String m_phone, Date m_bday, String m_email,
			String m_address) {
		super();
		this.m_id = m_id;
		this.m_pass = m_pass;
		this.m_name = m_name;
		this.m_phone = m_phone;
		this.m_bday = m_bday;
		this.m_email = m_email;
		this.m_address = m_address;
	}
	@Override
	public String toString() {
		return "Member [m_id=" + m_id + ", m_pass=" + m_pass + ", m_name=" + m_name + ", m_phone=" + m_phone
				+ ", m_bday=" + m_bday + ", m_email=" + m_email + ", m_address=" + m_address + "]";
	}
}
