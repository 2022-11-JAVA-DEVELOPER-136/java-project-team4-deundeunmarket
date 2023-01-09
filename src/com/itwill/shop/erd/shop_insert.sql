/*
member insert
*/
insert into member(m_id, m_pass, m_name, m_phone, m_bday, m_email, m_address) values('sy0', '0000', '�輼��', '010-0000-0000', sysdate, 'sy0@gmail.com', '����� ���ı�');
insert into member(m_id, m_pass, m_name, m_phone, m_bday, m_email, m_address) values('sy1', '1111', '�輼��', '010-1111-1111', sysdate, 'sy1@gmail.com', '����� ������');
insert into member(m_id, m_pass, m_name, m_phone, m_bday, m_email, m_address) values('sy2', '2222', '�輼��', '010-2222-2222', sysdate, 'sy2@gmail.com', '����� ���ʱ�');

/*
product insert
*/
insert into product(p_no, p_name, p_price, p_image, p_desc) values(product_p_no_SEQ.nextval, '�ߵ�����', 10000, '/images/�ߵ�����_����.jpg', '������ ���ڼ����� ���� ǳ���ϰ�');
insert into product(p_no, p_name, p_price, p_image, p_desc) values(product_p_no_SEQ.nextval, '������', 10000, '/images/������_����.jpg', '�ڲ� �������� ���� ������');
insert into product(p_no, p_name, p_price, p_image, p_desc) values(product_p_no_SEQ.nextval, '������', 10000, '/images/������_����.jpg', '������ �ҽ��� ��ġ�� ������ ��ȭ');
insert into product(p_no, p_name, p_price, p_image, p_desc) values(product_p_no_SEQ.nextval, '�Ｑ«��', 10000, '/images/�Ｑ«��_����.jpg', '�ػ깰�� Ǫ���� �鸮���� �Ｑ«��!');
insert into product(p_no, p_name, p_price, p_image, p_desc) values(product_p_no_SEQ.nextval, '�������', 10000, '/images/�������_����.jpg', '������ ���Ͽ�� �ϼ�');
insert into product(p_no, p_name, p_price, p_image, p_desc) values(product_p_no_SEQ.nextval, '������ũ', 10000, '/images/������ũ_����.jpg', '�̱��� �İ�, ǳ���� ����');
insert into product(p_no, p_name, p_price, p_image, p_desc) values(product_p_no_SEQ.nextval, '�쵿', 10000, '/images/�쵿_����.jpg', '������ ������ �α� �޴�');
insert into product(p_no, p_name, p_price, p_image, p_desc) values(product_p_no_SEQ.nextval, '�������͹�', 10000, '/images/�������͹�_����.jpg', '�� ���� ��� ����� ǳ��');
insert into product(p_no, p_name, p_price, p_image, p_desc) values(product_p_no_SEQ.nextval, 'Į����', 10000, '/images/Į����_����.jpg', '�� ������ ���� Ǫ���� Į����');
insert into product(p_no, p_name, p_price, p_image, p_desc) values(product_p_no_SEQ.nextval, 'ũ���Ľ�Ÿ', 10000, '/images/ũ���Ľ�Ÿ_����.jpg', '������ �ŷ��� ũ�� �Ľ�Ÿ');

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