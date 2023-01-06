package com.itwill.shop.cart;

import com.itwill.shop.product.Product;
/*
 * 이름       널?       유형           
	-------- -------- ------------ 
	CART_NO  NOT NULL NUMBER(10)   
	CART_QTY          NUMBER(10)   
	M_ID              VARCHAR2(50) 
	P_NO              NUMBER(10)  
 */
public class Cart {
	private int cart_no;
	private int cart_qty;
	/************FK*************/
	private String userid; 
	/************FK Product 포함*************/
	private Product product;
}
