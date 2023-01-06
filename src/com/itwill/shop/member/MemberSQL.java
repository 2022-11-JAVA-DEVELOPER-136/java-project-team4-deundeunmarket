package com.itwill.shop.member;


public class MemberSQL {
	public static final String MEMBER_INSERT=
			"insert into member(m_id,m_pass,m_name,m_phone,m_bday,m_email,m_address) values(?,?,?,sysdate,?,?)";
	public static final String MEMBER_UPDATE=
			"update member set m_pass=?,m_name=?,m_phone=?,m_bday=?,m_email=?,m_address=?, where m_id=?";
	public static final String MEMBER_DELETE=
			"delete from member where m_id=?";
	public static final String MEMBER_SELECT_BY_ID=
			"select m_id,m_pass,m_name,m_phone,m_bday,m_email,m_address from member where m_id=?";
	public static final String MEMBER_SELECT_ALL=
			"select m_id,m_pass,m_name,m_phone,m_bday,m_email,m_address from member";
}


