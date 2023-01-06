/************* 회원 ***************/
--회원정보보기(select pk)
select * from member where m_id='sy0';
select * from member where m_id='sy1';
select * from member where m_id='sy2';

--회원정보수정(update pk)
update member set m_pass='1111',m_name='nxxx' where m_id='sy0';
update member set m_pass='2222',m_name='nyyy' where m_id='sy1';
update member set m_pass='3333',m_name='nzzz' where m_id='sy2';

--회원정보(delete pk)
delete member where  m_id='sy0';
delete member where  m_id='sy1';
delete member where  m_id='sy2';


/************* 제품 ***************/
-- 제품 전체 리스트
select * from product;
-- 제품 상세보기
select * from product where p_no=1;



/************* 카트 ***************/
-- 로그인 한 회원의 카트 리스트
-- 로그인 한 회원의 카트리스트 삭제(cart_no) 
-- 로그인 한 회원의 카트리스트 전체 삭제(m_id)
-- 로그인 한 회원의 카트 1개 아이템 수량 변경(cart_no)
-- 로그인 한 회원의 카트에 존재하는 제품의 수(제품 존재여부 판단)
-- 로그인 한 회원의 카트에 담기(카트에 이미 존재하는 제품의 수량만 수정)


/************* 주문 ***************/
-- 주문 전체 목록 보기 (회원아이디)
select * from orders where m_id = 'sy0';
-- 주문(주문아이템+제품) 전체 목록 보기 (회원아이디)
select * from orders o 
join order_item oi 
on o.o_no=oi.o_no
join product p
on oi.p_no = p.p_no
where m_id = 'sy0';
-- 주문 목록 (주문아이템+제품) 한 개보기 (회원아이디 + 주문번호)
select * 
from orders o
join order_item oi
on o.o_no = oi.o_no
join product p
on oi.p_no = p.p_no
where m_id = 'sy0' and o.o_no=1;
-- 주문 1건 삭제 (주문번호)
delete orders where o_no = 1;
-- 주문 전체 삭제 (회원아이디)
delete orders where m_id = 'sy1';


