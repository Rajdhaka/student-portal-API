package com.geekster.mappingPractice.controllers;

import com.geekster.mappingPractice.models.Book;
import com.geekster.mappingPractice.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping()
    public void addBook(@RequestBody Book book){
        bookService.createBook(book);
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Book>> getAllBooks(){
        Iterable<Book> books = bookService.getAllBooks();
        HttpStatus status;
        if(books == null){
            status = HttpStatus.NO_CONTENT;
        }
        else{
            status = HttpStatus.OK;
        }
        return new ResponseEntity<Iterable<Book>>(books,status);
    }

    @GetMapping(value = "/{bookId}")
    public ResponseEntity<Book> getBookById(@RequestParam Long bookId) {
        HttpStatus status = null;
        Book book = bookService.getBookById(bookId);
        if (book == null) {
            status = HttpStatus.BAD_REQUEST;
        } else {
            status = HttpStatus.OK;
        }
        return new ResponseEntity<Book>(book, status);

    }

    @PutMapping("bookId/{bookId}/bookPrice/{bookPrice}")
    public ResponseEntity<String>modifyBookPrice(@PathVariable Long bookId,@PathVariable Double bookPrice){
        HttpStatus status;
        String message ;
        try{
            bookService.updateBookPrice(bookId,bookPrice);
            status = HttpStatus.OK;
            message = "Book Price updated successfully !!!";

        }
        catch (Exception ex){

            status = HttpStatus.NOT_MODIFIED;
            message = "Book with bookId "+bookId+" does not exist";
            System.out.println(ex);


        }
        return new ResponseEntity<String>(message,status);
    }

    @DeleteMapping("/bookId/{bookId}")
    public ResponseEntity<String> deleteBookById(@PathVariable Long bookId){
        String message = null;
        HttpStatus status;

        try{
            message = bookService.removeBookById(bookId);
            status = HttpStatus.OK;
        }catch (Exception ex){
            status = HttpStatus.BAD_REQUEST;
            message ="Book does not exist";
            ex.printStackTrace();

        }
        return new ResponseEntity<String>(message,status);
    }
}
