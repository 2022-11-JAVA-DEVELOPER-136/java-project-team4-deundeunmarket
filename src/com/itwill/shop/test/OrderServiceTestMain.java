package com.itwill.shop.test;

import com.itwill.shop.order.Order;
import com.itwill.shop.order.OrderService;

public class OrderServiceTestMain {

	public static void main(String[] args) throws Exception {
		
		OrderService orderService = new OrderService();
		int rowCount = 0;
		Order order = null;
		
		/*
		 * 주문 1개 삭제 - deleteByOrderNo
		 */
		rowCount = orderService.deleteByOrderNo(1);
		System.out.println(rowCount+"개의 주문 삭제");
		
		/*
		 * 주문 전체 삭제 - delete
		 */
		rowCount = orderService.delete("sy1");
		System.out.println(rowCount+"개의 주문 삭제");
		
		/*
		 * 주문 목록 보기 - orderList
		 */
		System.out.println("orderList");
		System.out.println(orderService.orderList("sy0"));
		
		/*
		 * 주문상세보기 - orderDetail
		 */
		System.out.println("orderDetail");
		System.out.println(orderService.orderDetail("sy0", 1));
		
		/*
		 * 상품에서 직접 주문 - orderCreate
		 */
		order = new Order(0, null, null, 0, null, "집 앞에 놔주세요", "카드", "sy2");
		rowCount = orderService.orderCreate(order, 1, 1);
		System.out.println(rowCount+"개의 주문 생성");
		
		/*
		 * 카트에서 주문 - orderCreate 오버로딩
		 */
		order = new Order(0, null, null, 0, null, "계단에 놔주세요", "현금", "sy0");
		rowCount = orderService.orderCreate(order);
		System.out.println(rowCount+"개의 주문 생성");
		
		/*
		 * 카트에서 선택 주문 - orderCreate 오버로딩 (선택)
		 */
		//Exception in thread "main" java.lang.NullPointerException
		order = new Order(0, null, null, 0, null, "벨 울려주세요", "카드", "sy1");
		String[] cart_no_StrArray = {"3", "4", "7", "8"};
		rowCount = orderService.orderCreate(order, cart_no_StrArray);
		System.out.println(rowCount+"개의 주문 생성");
	}
}