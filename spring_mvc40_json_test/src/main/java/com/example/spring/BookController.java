package com.example.spring;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonMappingException.Reference;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@RestController
public class BookController {
	private static List<Book> bookList;

	static {
		bookList = new ArrayList<>();
		bookList.add(new Book("1", "よくわかるSpring", 3000));
		bookList.add(new Book("2", "よくわかるJava", 3200));
		bookList.add(new Book("3", "よくわかるJUnit", 2800));
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("book/index");
		return mav;
	}

	@RequestMapping(value = "/books", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
			+ ";charset=utf-8")
	public List<Book> books() {
		return bookList;
	}

	@RequestMapping(value = "/books", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE
			+ ";charset=utf-8")
	public Book insert(@RequestBody @Valid Book book, Errors errors) {
		for (ObjectError oe : errors.getAllErrors()) {
			System.out.println(oe.getDefaultMessage());
		}

		bookList.add(book);
		return book;
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public Book handleException(HttpMessageNotReadableException ex,
			WebRequest request) {
		Throwable t = ex.getCause();
		if (t != null && t instanceof InvalidFormatException) {
			InvalidFormatException ife = (InvalidFormatException) t;
			// エラーのフィールド。
			for (Reference r : ife.getPath()) {
				System.out.println(r.getFieldName());
			}
			// エラーになったフィールドの型
			System.out.println("type= " + ife.getTargetType().getName());
			// エラーになったフィールドの値
			System.out.println("value=" + ife.getValue());
		}

		return new Book();
	}

	@RequestMapping(value = "/books/{bookId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE
			+ ";charset=utf-8")
	public Book update(@PathVariable("bookId") String initBookId,
			@RequestBody Book book) {
		for (int i = 0; i < bookList.size(); i++) {
			Book currentBook = bookList.get(i);
			if (currentBook.getBookId().equals(initBookId)) {
				currentBook.setBookId(book.getBookId());
				currentBook.setBookName(book.getBookName());
				currentBook.setPrice(book.getPrice());
				return currentBook;
			}
		}

		return new Book();
	}

	@RequestMapping(value = "/books/{bookId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE
			+ ";charset=utf-8")
	public Book delete(@PathVariable String bookId) {
		for (int i = 0; i < bookList.size(); i++) {
			Book book = bookList.get(i);
			if (book.getBookId().equals(bookId)) {
				bookList.remove(i);
				return book;
			}
		}

		return new Book();
	}

}
