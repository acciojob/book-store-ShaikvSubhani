package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    private List<Book> bookList;
    private int id;
    public BookRepository(){
        bookList=new ArrayList<>();
        id=1;
    }

    public Book save(Book book){
        book.setId(id++);
        bookList.add(book);
        return book;
    }

    public Book findBookById(int id){
        for(Book book : bookList)
        {
            if(id== book.getId())
                return book;
        }
        return null;
    }

    public List<Book> findAll(){
        return bookList;
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book> listOfBooks=new ArrayList<>();
        for(Book book : bookList)
        {
            if(author.equals(book.getAuthor()))
                listOfBooks.add(book);
        }
        return listOfBooks;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> listOfBooksByGenre=new ArrayList<>();
        for(Book book: bookList)
        {
            if(genre.equals(book.getGenre()))
                listOfBooksByGenre.add(book);
        }
        return listOfBooksByGenre;
    }

    public void deleteBookById(int id){
        bookList.remove(id);
    }

    public void deleteAll(){
        bookList.clear();
    }




}
