package com.rdlsmile.mobike.test;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.rdlsmile.mobike.dao.BookDao;
import com.rdlsmile.mobike.entity.Book;


public class TestBookDao extends TestBase {
	private BookDao bookDao;
	@Before
	//@Test
	public void init(){
		bookDao=super.getContext().getBean(
				"bookDao", BookDao.class);
		
		System.out.println(bookDao);
	}
	@Test
	public void test(){
		List<Book> list
			=bookDao.findByUserId(
			"48595f52-b22c-4485-9244-f4004255b972");
		for(Book book:list){
			System.out.println(
					book);
		}
	}
	@Test
	public void testSave(){
		Book book=new Book();
		book.setId("123456");
		book.setUserId("48595f52-b22c-4485-9244-f4004255b972");
		book.setName("cloudnote");
		book.setTypeId("5");
		book.setDesc("");
		Timestamp time
			=new Timestamp(System.currentTimeMillis());
		book.setCreateTime(time);
		bookDao.save(book);
	}
}







