package com.example.spring.db04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate npJdbcTemplate;

	public Book selectByKey(int bookId) {
		return npJdbcTemplate.queryForObject(
				"SELECT * FROM book WHERE book_id=:book_id",
				new MapSqlParameterSource().addValue("book_id", bookId),
				new BeanPropertyRowMapper<Book>(Book.class));
	}

	public Integer count(String bookName) {
		return npJdbcTemplate.queryForObject(
				"SELECT count(*) FROM book WHERE book_name LIKE :book_name",
				new MapSqlParameterSource().addValue("book_name", bookName
						+ "%"), Integer.class);
	}

}
