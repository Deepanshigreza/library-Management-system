package com.example.librarydb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

@Autowired
BookService bookService;

//try catch to handle the validation
        @PostMapping("/add_book")
        public void addBook(@RequestBody()Book  book){
                try {
                        bookService.createBook(book);
                } catch (Exception e) {
                        throw new RuntimeException(e);
                }

        }
        @GetMapping("/get_book")
        public Book getBookById(@RequestParam("id") Integer id){
                Book book= null;
                try {
                        book = bookService.getBookById(id);
                } catch (Exception e) {
                        throw new RuntimeException(e);
                }
                return book;
        }
        //update pages
        @PutMapping("/update_pages")
        public void updatePages(@RequestBody()UpdateBookPages updateBookPage){ //Book book

                bookService.updateBookPages(updateBookPage);
        }


}

