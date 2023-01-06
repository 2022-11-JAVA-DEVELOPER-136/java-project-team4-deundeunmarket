package com.itwill.shop.product;

public class ProductSQL {

public static final String PRODUCT_INSERT = "insert into product values (product_p_no_seq.nextval,?,?,?,?)";

public static final String PRODUCT_UPDATE 
	= "update product set p_name = ?, p_price = ?, p_image = ?, p_desc = ? where p_no = ?";

public static final String PRODUCT_DELETE 
	= "delete from product where p_no=?";

public static final String PRODUCT_SELECT_BY_NO 
	= "select * from product where p_no=? ";

public static final String PRODUCT_SELECT_ALL 
	= "select * from product";

}	