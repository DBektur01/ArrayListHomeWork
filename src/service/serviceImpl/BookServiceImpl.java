package service.serviceImpl;

import model.Book;

import model.Library;
import model.db.Database;
import service.BookService;
import java.util.List;

public class BookServiceImpl implements BookService {

    @Override
    public Book saveBook(Long libraryId, Book book) {
        for (Library library: Database.libraries){
            if (library.getId().equals(libraryId)){
                Database.books.add(book);
            }
        }
        return book;
    }

    @Override
    public List<Book> getAllBooks(Long libraryId) {
        for (Library library:Database.libraries){
            if (library.getId().equals(libraryId)){
                return Database.books;
            }
        }
        return null;
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        for (Library library:Database.libraries){
            if (library.getId().equals(libraryId)){
                for (Book book:Database.books){
                    if (book.getId().equals(bookId)){
                        return book;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId){
        for (Library library:Database.libraries){
            if (library.getId().equals(libraryId)){
                for (Book book : Database.books) {
            if (book.getId().equals(bookId)) {
                Database.books.remove(book);
                return "Book with ID " + bookId + " deleted successfully.";

                  }
                }
            }
        }
        return "Book with ID " + bookId + " not found.";
    }

    @Override
    public void clearBooksByLibraryId(Long libraryId) {
        for (Library library:Database.libraries){
            if (library.getId().equals(libraryId)){
                Database.books.clear();
            }
        }
    }
}
