package com.itwill.shop.cart;

import java.util.List;

public class CartService {
	private CartDao cartDao;
	
	public CartService() throws Exception {
		cartDao = new CartDao();
	}
/*
 * 카트 추가 or 수정 - addCart
 */
	public int addCart(Cart cart) throws Exception {
		if(cartDao.countByProductNo(cart.getM_id(),cart.getProduct().getP_no())>0) {
			return cartDao.updateByProductNo(cart);
		}else {
		return cartDao.insert(cart);
		}
	}
/*
 * 카트 수량 변경 - updateCart
 */
	public int updateCart(Cart cart) throws Exception {
		return cartDao.updateByCartNo(cart);
	}
		
		
/*
 * 카트 전체보기 - getCartItemByUserId
 */
	public List<Cart> getCartItemByUserId(String m_id) throws Exception {
		return cartDao.findByM_Id(m_id);
	}
/*
 * 카트 아이템 1개 보기 - getCartItemByCartNo
 */
	public Cart getCartItemByCartNo(int cart_no) throws Exception {
		return cartDao.findByCartNo(cart_no);
	}
/*
 * 카트 아이템 1개 삭제 - deleteCartItemByCartNo
 */
	public int deleteCartItemByCartNo(int cart_no) throws Exception {
		return cartDao.deleteByCartNo(cart_no);
	}
/*
 * 카트 전체 삭제 - deleteCartItemByUserId
 */
	
	public int deleteCartItemByUserId(String m_id) throws Exception {
		return cartDao.deleteByUserId(m_id);
	}
	
}
