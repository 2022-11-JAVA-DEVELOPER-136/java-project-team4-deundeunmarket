package com.itwill.shop.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.print.SimpleDoc;

import com.itwill.shop.member.Member;
import com.itwill.shop.member.MemberDao;

public class MemberDaoTestMain {

	public static void main(String[] args) throws Exception {
		MemberDao memberDao=new MemberDao();
		
		//Member memeber = new Member("myt10", "myt9", "최민영", "010-0000-0000", new Date(1994,01,01), "cmy@naver.com", "서울시 동대문구");
		//int rowCount=memberDao.insert(memeber);
		//System.out.println("1. insert -->"+rowCount);
		
		int rowCount=memberDao.delete("myt10");
		System.out.println("2. delete -->"+rowCount);
		
		
		Member member = new Member("sy2", "pass", "테스트", "phonenumber", new Date(1999,01,01), "text1", "Text2");
		rowCount=memberDao.update(member);
		System.out.println("3. update -->"+rowCount);
		
		System.out.println("4. select -->"+memberDao.findByPrimaryKey("sy2"));
		
		List<Member> memberList = memberDao.findAll();
		System.out.println("5. selectAll -->"+memberList);
		
		
	}

}
