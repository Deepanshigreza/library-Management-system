package com.example.librarydb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;
    //logic written here
    public void createBook(Book book)  throws Exception{
        if(bookRepository.findById(book.getId()).get()!=null){
            throw new Exception("Already present");
        }

        bookRepository.save(book);
    }
    public Book getBookById(Integer id) throws Exception{
        Book book=bookRepository.findById(id).get();
        return book;

    }
    public void updateBookPages(UpdateBookPages updateBookPage){

        //We need to convert our object (Entry dto) into Entity Object.

        int id = updateBookPage.getId();

        Book bookToBeUpdated = bookRepository.findById(id).get();//get book by id finding

        bookToBeUpdated.setPages(updateBookPage.getPages());

        bookRepository.save(bookToBeUpdated);
    }
}
