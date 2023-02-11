package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;

    // One example controller, make the rest by yourself
    @PostMapping("/create-book")
    public ResponseEntity createBook(@RequestBody Book book){
        Book newbook = bookService.createBook(book);
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }

    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity getBook(@PathVariable String id)
    {
        Book book=bookService.findBookById(id);
        return new ResponseEntity<>(book,HttpStatus.FOUND);

    }

    @GetMapping("/get-all-books")
    public ResponseEntity getAllBooks()
    {
        List<Book> ans=bookService.findAllBooks();
        return new ResponseEntity<>(ans,HttpStatus.CREATED);
    }


    //Get books by author: /books/get-books-by-author?author=author+name
    @GetMapping("/get-books-by-author")
    public ResponseEntity getBooksByAuthor( @RequestParam String author)
    {
        return new ResponseEntity<>(bookService.findBooksByAuthor(author),HttpStatus.FOUND);
    }


    //Get books by genre: /books/get-books-by-genre?genre=genre+name

    @GetMapping("/get-books-by-genre")
    public ResponseEntity getBooksByGenre(@RequestParam String genre)
    {
        return new ResponseEntity<>(bookService.findBooksByGenre(genre),HttpStatus.FOUND);
    }

    //Delete book by id: /books/delete-book-by-id/{id}

    @DeleteMapping("/delete-book-by-id/{id}")
    public ResponseEntity deleteBookById(@PathVariable String id)
    {
        bookService.deleteBookById(id);
        return new ResponseEntity<>("Deleted Book by id"+id,HttpStatus.NO_CONTENT);
    }

    //Delete all books: /books/delete-all-books\

    @DeleteMapping("/delete-all-books")
    public ResponseEntity deleteAllBooks()
    {
        bookService.deleteAllBooks();
        return new ResponseEntity<>("All books deleted",HttpStatus.NO_CONTENT);
    }

}
