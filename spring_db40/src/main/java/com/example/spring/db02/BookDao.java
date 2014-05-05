package com.example.spring.db02;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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

	public int insert(Book book) {
		return npJdbcTemplate.update(
				"INSERT INTO BOOK(book_id,book_name,price) "
						+ "VALUES(:book_id,:book_name,:price)",
				new MapSqlParameterSource()
						.addValue("book_id", book.getBookId())
						.addValue("book_name", book.getBookName())
						.addValue("price", book.getPrice()));
	}

	public int update(Book book) {
		BeanPropertySqlParameterSource beanProps = new BeanPropertySqlParameterSource(
				book);
		return npJdbcTemplate.update("UPDATE book "
				+ "SET book_name=:bookName,price=:price WHERE book_id=:bookId",
				beanProps);
	}

	public int delete(Book book) {
		BeanPropertySqlParameterSource beanProps = new BeanPropertySqlParameterSource(
				book);
		return npJdbcTemplate.update("DELETE FROM book WHERE book_id=:bookId",
				beanProps);
	}

	public List<Book> selectBookList() {
		return jdbcTemplate.query("SELECT * FROM book", new RowMapper<Book>() {
			public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
				Book book = new Book();
				book.setBookId(rs.getInt("book_id"));
				book.setBookName(rs.getString("book_name"));
				book.setPrice(rs.getInt("price"));
				return book;
			}
		});
	}
}
