package com.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.task.entity.Book;
import com.task.service.BookService;

@RestController
@RequestMapping("/book/v1")
public class BookController {
	
	private final BookService bookService;
	
	@Autowired
	public BookController(BookService bookService) {
		this.bookService=bookService;
	}
	
	@PostMapping("/addBook")
	public ResponseEntity addBook(@RequestBody Book book) {
	    Book savedBook = bookService.addBook(book);
	    return ResponseEntity.ok(savedBook);
	}
	
	@GetMapping("/getBook/{bookName}")
	public ResponseEntity<Book> getBookBYName(@PathVariable("bookName")String name){
	    Book bookByName= bookService.getBookByName(name);
	    return ResponseEntity.ok(bookByName);
	}

	@PutMapping("/updateBook")
	public ResponseEntity updateBook(@RequestBody Book book) {
	    Book updateBook = bookService.updateBook(book);
	    return ResponseEntity.ok(updateBook);
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public ResponseEntity<Book> deletebook(@PathVariable("id")Integer id){
	    bookService.deleteBook(id);
	    return ResponseEntity.ok().build();
	}
}
