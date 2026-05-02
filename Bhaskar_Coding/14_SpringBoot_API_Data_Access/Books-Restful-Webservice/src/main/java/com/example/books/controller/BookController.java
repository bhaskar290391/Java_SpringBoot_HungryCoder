package com.example.books.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.books.entity.Book;
import com.example.books.exception.ResourceNotFound;

@RestController
@RequestMapping("/api/books")
public class BookController {

	private List<Book> books = new ArrayList<>();

	public BookController() {
		books.add(new Book(1L, "1978", "Bhaskar"));
		books.add(new Book(2L, "Bayblade", "Kanishk"));
	}

	@GetMapping
	public List<Book> getAllBooks() {
		return books;
	}

	@GetMapping("/{id}")
	public Book getBookById(@PathVariable Long id) {
		
		if(id > 10) {
			throw new ResourceNotFound("Book id does not exist");
		}
		return books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
	}

	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable Long id) {
		books.removeIf(book -> book.getId().equals(id));
	}

	@PostMapping()
	public Book addBook(@RequestBody Book book) {
		book.setId((long) (books.size() + 1));
		books.add(book);
		return book;
	}

	@PutMapping("/{id}")
	public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
		Book existingBook = books.stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null);

		if (existingBook != null) {
			existingBook.setAuthor(book.getAuthor());
			existingBook.setTitle(book.getTitle());

			return existingBook;
		}

		return null;
	}
	
	
	@GetMapping("/search")
	public String getSearchBook(@RequestParam String title) {
		return title;
	}
}
