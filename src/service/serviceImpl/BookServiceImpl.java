package serviceImpl;

import model.Book;
import model.Library;
import service.BookService;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {

    List<Book>books=new ArrayList<>();
    List<Library>libraries = new ArrayList<>();

    @Override
    public Book saveBook(Long libraryId, Book book) {
        for (Library library:libraries){
            if (library.getId()==libraryId){
                books.add(book);
            }
        }
        return null;
    }

    @Override
    public List<Book> getAllBooks(Long libraryId) {
        for (Library library:libraries){
            if (library.getId()==libraryId){
                return books;
            }
        }
        return null;
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        for (Library library:libraries){
            if (library.getId()==libraryId){
                for (Book book:books){
                    if (book.getId()==bookId){
                        return book;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        for (Library library:libraries){
            if (library.getId()==libraryId){
                for (Book book:books){
                    if(book.getId()==bookId){
                        libraries.remove(book);
                    }
                }
            }
        }
        return null;
    }

    @Override
    public void clearBooksByLibraryId(Long libraryId) {
        for (Library library:libraries){
            if (library.getId()==libraryId){
                libraries.clear();
            }
        }
    }
}
