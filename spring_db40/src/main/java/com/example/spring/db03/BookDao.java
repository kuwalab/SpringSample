package com.example.spring.db03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate npJdbcTemplate;

	public List<Book> selectBookList() {
		return jdbcTemplate.query("SELECT * FROM book",
				new BeanPropertyRowMapper<Book>(Book.class));
	}

	public List<Book> searchBookList1(String bookName) {
		return jdbcTemplate.query("SELECT * FROM book WHERE book_name LIKE ?",
				new BeanPropertyRowMapper<Book>(Book.class), bookName + "%");
	}

	public List<Book> searchBookList2(String bookName) {
		return npJdbcTemplate.query(
				"SELECT * FROM book WHERE book_name LIKE :book_name",
				new MapSqlParameterSource().addValue("book_name", bookName
						+ "%"), new BeanPropertyRowMapper<Book>(Book.class));
	}

	public List<Book> searchBookList3(Book book) {
		return npJdbcTemplate.query(
				"SELECT * FROM book WHERE book_name LIKE :bookName",
				new BeanPropertySqlParameterSource(book),
				new BeanPropertyRowMapper<Book>(Book.class));
	}
}
