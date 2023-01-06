package com.itwill.shop.order;

import java.util.Date;
import java.util.List;

/*
 * 이름        널?       유형             
	--------- -------- -------------- 
	O_NO      NOT NULL NUMBER(10)     
	O_DESC             VARCHAR2(1000) 
	O_DATE             DATE           
	O_PRICE            NUMBER(10)     
	O_ADDRESS          VARCHAR2(500)  
	O_LOC              VARCHAR2(500)  
	O_PAYMENT          VARCHAR2(50)   
	M_ID               VARCHAR2(50)  
 */
public class Order {
	private int o_no;
	private String o_desc;
	private Date o_date;
	private int o_price;
	private String o_address;
	private String o_loc;
	/*********FK**********/
	private String userid;
	/******List<OrderItem> 포함 (order 1개에 order_item 여러개 있으니 컬렉션으로)******/
	private List<OrderItem> orderItemList;
}
