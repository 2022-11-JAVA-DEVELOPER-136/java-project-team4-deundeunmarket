package com.itwill.shop.member;

import java.util.Date;
/*
 * 이름        널?       유형            
	--------- -------- ------------- 
	M_ID      NOT NULL VARCHAR2(50)  
	M_PASS             VARCHAR2(50)  
	M_NAME             VARCHAR2(50)  
	M_PHONE            VARCHAR2(100) 
	M_BDAY             DATE          
	M_EMAIL            VARCHAR2(100) 
	M_ADDRESS          VARCHAR2(500) 
 */
public class Member {
	private String m_id;
	private String m_pass;
	private String m_name;
	private String m_phone;
	private Date m_bday;
	private String m_email;
	private String m_address;
}
