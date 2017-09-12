package com.rdlsmile.mobike.dao;

import java.util.List;

import com.rdlsmile.mobike.entity.Book;


public interface BookDao {
	List<Book> findByUserId(String userId);
	Book findByBookId(String bookId);
	void save(Book book);
}









