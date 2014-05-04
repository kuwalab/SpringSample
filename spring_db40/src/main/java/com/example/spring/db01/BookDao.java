package com.example.spring.db01;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(Book book) {
		return jdbcTemplate.update(
				"INSERT INTO BOOK(book_id,book_name,price) VALUES(?,?,?)",
				book.getBookId(), book.getBookName(), book.getPrice());
	}

	public int update(Book book) {
		return jdbcTemplate.update(
				"UPDATE book SET book_name=?,price=? WHERE book_id=?",
				book.getBookName(), book.getPrice(), book.getBookId());
	}

	public int delete(Book book) {
		return jdbcTemplate.update("DELETE FROM book WHERE book_id=?",
				book.getBookId());
	}

	public List<Book> selectBookList() {
		return jdbcTemplate.query("SELECT * FROM book", new RowMapper<Book>() {
			public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
				Book book = new Book();
				book.setBookId(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setPrice(rs.getInt(3));
				return book;
			}
		});
	}
}
