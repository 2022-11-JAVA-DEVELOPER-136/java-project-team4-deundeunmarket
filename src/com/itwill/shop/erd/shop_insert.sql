/*
member insert
*/
insert into member(m_id, m_pass, m_name, m_phone, m_bday, m_email, m_address) values('sy0', '0000', '김세영', '010-0000-0000', sysdate, 'sy0@gmail.com', '서울시 송파구');
insert into member(m_id, m_pass, m_name, m_phone, m_bday, m_email, m_address) values('sy1', '1111', '김세일', '010-1111-1111', sysdate, 'sy1@gmail.com', '서울시 강남구');
insert into member(m_id, m_pass, m_name, m_phone, m_bday, m_email, m_address) values('sy2', '2222', '김세이', '010-2222-2222', sysdate, 'sy2@gmail.com', '서울시 서초구');

/*
product insert
*/
insert into product(p_no, p_name, p_price, p_image, p_desc) values(product_p_no_SEQ.nextval, '닭도리탕', 10000, '/images/닭도리탕.jpg', '상품설명1');
insert into product(p_no, p_name, p_price, p_image, p_desc) values(product_p_no_SEQ.nextval, '떡볶이', 10000, '/images/떡볶이.jpg', '상품설명2');
insert into product(p_no, p_name, p_price, p_image, p_desc) values(product_p_no_SEQ.nextval, '막국수', 10000, '/images/막국수.jpg', '상품설명3');
insert into product(p_no, p_name, p_price, p_image, p_desc) values(product_p_no_SEQ.nextval, '삼선짬뽕', 10000, '/images/삼선짬뽕.jpg', '상품설명4');
insert into product(p_no, p_name, p_price, p_image, p_desc) values(product_p_no_SEQ.nextval, '샤브샤브', 10000, '/images/샤브샤브.jpg', '상품설명5');
insert into product(p_no, p_name, p_price, p_image, p_desc) values(product_p_no_SEQ.nextval, '스테이크', 10000, '/images/스테이크.jpg', '상품설명6');
insert into product(p_no, p_name, p_price, p_image, p_desc) values(product_p_no_SEQ.nextval, '우동', 10000, '/images/우동.jpg', '상품설명7');
insert into product(p_no, p_name, p_price, p_image, p_desc) values(product_p_no_SEQ.nextval, '전복버터밥', 10000, '/images/전복버터밥.jpg', '상품설명8');
insert into product(p_no, p_name, p_price, p_image, p_desc) values(product_p_no_SEQ.nextval, '칼국수', 10000, '/images/칼국수.jpg', '상품설명9');
insert into product(p_no, p_name, p_price, p_image, p_desc) values(product_p_no_SEQ.nextval, '크림파스타', 10000, '/images/크림파스타.jpg', '상품설명10');

/*
cart insert
*/
--sy0
insert into cart(cart_no, cart_qty, m_id, p_no) values(cart_cart_no_SEQ.nextval, 1, 'sy0', 1);
insert into cart(cart_no, cart_qty, m_id, p_no) values(cart_cart_no_SEQ.nextval, 2, 'sy0', 2);

--sy1
insert into cart(cart_no, cart_qty, m_id, p_no) values(cart_cart_no_SEQ.nextval, 3, 'sy1', 3);
insert into cart(cart_no, cart_qty, m_id, p_no) values(cart_cart_no_SEQ.nextval, 4, 'sy1', 4);

/*
order insert
*/
--sy0
insert into orders(o_no, o_name, o_desc, o_date, o_price, o_address, o_loc, o_payment, m_id) values(orders_o_no_SEQ.nextval, '김민선','o_desc', sysdate, 80000, '서울시 강남구','문 앞에 놔주세요', 'o_payment', 'sy0');
insert into order_item(oi_no, oi_qty, p_no, o_no) values(order_item_oi_no_SEQ.nextval, 1, 1, orders_o_no_SEQ.currval);
insert into order_item(oi_no, oi_qty, p_no, o_no) values(order_item_oi_no_SEQ.nextval, 2, 2, orders_o_no_SEQ.currval);

--sy1
insert into orders(o_no, o_name, o_desc, o_date, o_price, o_address, o_loc, o_payment, m_id) values(orders_o_no_SEQ.nextval,'김세영', 'o_desc', sysdate, 90000, '서울시 강남구','벨 울리지 말아주세요', 'o_payment', 'sy1');
insert into order_item(oi_no, oi_qty, p_no, o_no) values(order_item_oi_no_SEQ.nextval, 3, 3, orders_o_no_SEQ.currval);
insert into order_item(oi_no, oi_qty, p_no, o_no) values(order_item_oi_no_SEQ.nextval, 4, 4, orders_o_no_SEQ.currval);