package com.itwill.shop.cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itwill.shop.common.DataSource;
import com.itwill.shop.product.Product;

public class CartDao {

	private DataSource dataSource;
	public CartDao() throws Exception {
		dataSource = new DataSource();
	}
	//카트추가
	public int insert(Cart cart) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int insertRowCount = 0;
		con=dataSource.getConnection();
		pstmt=con.prepareStatement(CartSQL.CART_INSERT);
		pstmt.setInt(1, cart.getCart_qty());
		pstmt.setInt(2, cart.getProduct().getP_no());
		pstmt.setString(3, cart.getM_id());
		insertRowCount = pstmt.executeUpdate();
		
		con.close();
		return insertRowCount;
	}
	//cart제품 존재 여부
	public int countByProductNo(String m_id,int p_no) throws Exception{
		int count = 0;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_COUNT_BY_M_ID_PRODUCT_NO);
		pstmt.setString(1, m_id);
		pstmt.setInt(2, p_no);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			count=rs.getInt(1);
		}
		con.close();
		return count;
	}
	//  상품에서 카트 추가시 update
	public int updateByProductNo(Cart cart) throws Exception {
		int rowCount = 0;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_UPDATE_BY_PRODUCT_NO_M_ID);
		pstmt.setInt(1, cart.getCart_qty());
		pstmt.setString(2, cart.getM_id());
		pstmt.setInt(3, cart.getProduct().getP_no());
		rowCount =pstmt.executeUpdate();
		
		con.close();
		return rowCount;
	}
	
	// cart update(카트리스트에서 수정)
	public int updateByCartNo(Cart cart) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_UPDATE_BY_CART_NO);
		int rowCount = 0;
		pstmt.setInt(1,cart.getCart_qty());
		pstmt.setInt(2,cart.getCart_no());
		
		rowCount =pstmt.executeUpdate();
		con.close();
		return rowCount;
	}
	//cart list 카트 전체보기
	public List<Cart> findByM_Id(String m_id) throws Exception{
		List<Cart> cartList = new ArrayList<Cart>();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_SELECT_BY_M_ID);
		pstmt.setString(1, m_id);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			cartList.add(new Cart
						(rs.getInt("cart_no"),
						 rs.getInt("cart_qty"),
						 rs.getString("m_id"),
						 new Product(rs.getInt("p_no"),
								 	 rs.getString("p_name"),
									 rs.getInt("p_price"),
									 rs.getString("p_image"),
									 rs.getString("p_desc"))
						 )
				);
		}
		return cartList;
	}
	
	//cart pk delete
	public int deleteByCartNo(int cart_no) throws Exception {
		int deleteRowCount = 0;
		List<Cart> cartList = new ArrayList<Cart>();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_DELETE_BY_CART_NO);
		pstmt.setInt(1, cart_no);
		deleteRowCount = pstmt.executeUpdate();
		con.close();
		return deleteRowCount;
	}
	
	
	
	
	
	
	//cart delete
	public int deleteByUserId(String m_id) throws Exception {
		int deleteRowCount = 0;
		List<Cart> cartList = new ArrayList<Cart>();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_DELETE_BY_M_ID);
		pstmt.setString(1, m_id);
		deleteRowCount = pstmt.executeUpdate();
		con.close();
		return deleteRowCount;
	}
	
	
	//카트번호로 찾기
	public Cart findByCartNo(int cart_no) throws Exception {
		Cart cart =null;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_SELECT_BY_CART_NO);
		pstmt.setInt(1, cart_no);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			cart = new Cart(rs.getInt("cart_no"),
							rs.getInt("cart_qty"),
							rs.getString("m_id"),
							new Product(rs.getInt("p_no"),
										rs.getString("p_name"),
										rs.getInt("p_price"),
										rs.getString("p_image"),
										rs.getString("p_desc"))
							);
		}
		return cart;
	}
	
	
	
	
	
}
