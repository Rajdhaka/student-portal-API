package com.geekster.mappingPractice.services;

import com.geekster.mappingPractice.models.Book;
import com.geekster.mappingPractice.repositories.IBookRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    IBookRepo bookRepo;

    public void createBook(Book book) {
        bookRepo.save(book);
    }

    public Book getBookById(Long bookId) {
        return bookRepo.findBookByBookId(bookId);
    }

    public Iterable<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @Transactional
    public void updateBookPrice(Long bookId, Double bookPrice) {
        boolean isValidPrize = bookRepo.existsById(bookId);

        if(!isValidPrize){
            throw new IllegalStateException("Book does not exist");
        }
        bookRepo.updateBookPrize(bookId, bookPrice);
    }

    public String removeBookById(Long bookId) {
        Book book = bookRepo.findBookByBookId(bookId);

        if(book == null){
            throw new IllegalStateException("Book with id "+bookId+" doesn't exists !!");
        }else {
            bookRepo.deleteById(bookId);
            return "Book with id "+bookId+" is deleted successfully !!";
        }

    }
}
