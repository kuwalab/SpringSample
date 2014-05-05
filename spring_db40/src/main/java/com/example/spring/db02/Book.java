package com.example.spring.db02;

public class Book {
	private Integer bookId;
	private String bookName;
	private Integer price;

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", price="
				+ price + "]";
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}
