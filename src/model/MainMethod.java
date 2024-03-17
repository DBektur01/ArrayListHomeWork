package model;

import enums.Gender;

import enums.Genre;
import generateId.GenerateId;

import model.db.Database;
import service.serviceImpl.BookServiceImpl;
import service.serviceImpl.LibraryServiceImpl;
import service.serviceImpl.ReaderServiceImpl;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainMethod {


    public static void getLibrary(Scanner scanner){
        LibraryServiceImpl libraryService = new LibraryServiceImpl();
        try {
            boolean isTrue = true;
            while (isTrue) {
                System.out.println("""
                                    1.Save Library
                                    2.Get All Libraries
                                    3.Get Library By Id
                                    4.Update Library
                                    5.Delete Library By Id
                                    6.Exit
                                    """);
                int choiceLibrary = scanner.nextInt();
                switch (choiceLibrary) {
                    case 1 -> {
                        boolean isTrueSave = true;
                        while (isTrueSave) {
                            Library library = new Library();
                            library.setId(GenerateId.genLibraryId());
                            library.setName();
                            library.setAddress();
                            library.setReaders(Database.readers);
                            library.setBooks(Database.books);
                            List<Library> libraries = new ArrayList<>();
                            libraries.add(library);
                            libraryService.saveLibrary(libraries);

                            System.out.println("Successfully added");
                            isTrueSave=false;

                            //Long id, String name, String address, List<Book> books, List<Reader> readers

                        }
                    }
                    case 2 -> {
                        System.out.println(libraryService.getAllLibraries());
                    }
                    case 3 -> {
                        System.out.println("Write the ID of the library: ");
                        System.out.println(libraryService.getLibraryById(scanner.nextLong()));
                    }
                    case 4 -> {
                        boolean isTrueLib = true;
                        while (isTrueLib) {
                            System.out.println("Write the ID of the library:");
                            long updateScanner = scanner.nextLong();
                            Library library = new Library();
                            library.setId(updateScanner);
                            library.setName();
                            library.setAddress();
                            library.setReaders(Database.readers);
                            library.setBooks(Database.books);
                            System.out.println(libraryService.updateLibrary(updateScanner, library));
                            System.out.println("Successfully updated ");
                            isTrueLib=false;

                        }
                    }
                    case 5 -> {
                        System.out.println("Write the ID of the library: ");
                        System.out.println(libraryService.deleteLibrary(scanner.nextLong()));
                    }
                    case 6 -> {
                        isTrue = false;
                    }
                }
            }

        } catch (InputMismatchException e) {
            System.err.println("Choice 1-2-3-4-5-6");
        }
    }
    public static void getBook(Scanner scanner){
        BookServiceImpl bookService = new BookServiceImpl();
        //TODO BOOK
        try {

            boolean isTrue = true;
            while (isTrue) {
                System.out.println("""
                                    1.Save Book
                                    2.Get All Books
                                    3.Get Book By Id
                                    4.Delete Book By Id
                                    5.Clear Books By Library Id
                                    6.Exit
                                          """);
                int BookChoice = scanner.nextInt();
                switch (BookChoice) {

                    //TODO Save Book
                    case 1 -> {
                        boolean isTrueB = true;
                        while (isTrueB) {
                            Book book = new Book();
                            System.out.println("Write the ID of the library: ");
                            long libraryId = scanner.nextLong();
                            book.setId(GenerateId.genBookId());
                            book.setName();
                            book.setAuthor();
                            book.setGenre();
                            System.out.println(bookService.saveBook(libraryId, book));
                            System.out.println("Successfully");
                            isTrueB=false;
                        }
                    }
                    //TODO Get all books
                    case 2 -> {
                        System.out.println("Write the ID of the library: ");
                        System.out.println(bookService.getAllBooks(scanner.nextLong()));
                    }
                    //TODO Get book by ID
                    case 3 -> {
                        System.out.println("Write Library Id and book Id: ");
                        System.out.println(bookService.getBookById(scanner.nextLong(), scanner.nextLong()));
                    }
                    //TODO Delete book by ID
                    case 4 -> {
                        System.out.println("Write the ID of the library: ");
                        long libID =scanner.nextLong();
                        System.out.println("Write the ID of the book: ");
                        System.out.println(bookService.deleteBook(libID, scanner.nextLong()));
                    }
                    case 5 -> {
                        System.out.println("Write the ID of the library: ");
                        bookService.clearBooksByLibraryId(scanner.nextLong());
                    }
                    case 6 -> {
                        isTrue = false;
                    }
                }
            }
        } catch (InputMismatchException e) {
            System.err.println(e.getMessage());
        }

    }
    public static void getReader(Scanner scanner){
        ReaderServiceImpl readerService = new ReaderServiceImpl();
        //TODO READER
        try {
            boolean isTrue = true;
            while (isTrue) {
                System.out.println("""
                                    1.Save Reader
                                    2.Get All Readers
                                    3.Get Reader By Id
                                    4.Update Reader
                                    5.Assign Reader To Library
                                    6.Exit
                                    """);
                int bookChoice = scanner.nextInt();
                switch (bookChoice) {
                    //TODO Save reader
                    case 1 -> {
                        boolean isTrue2=true;
                        while (isTrue2) {
                            Reader reader = new Reader();
                            reader.setId(GenerateId.genReaderId());
                            reader.setFullName();
                            reader.setEmail();
                            reader.setPhoneNumber();
                            reader.setGender();
                           System.out.println("Successfully added");
                           readerService.saveReader(reader);
                           isTrue2=false;
                        }
                    }
                    //TODO Get all readers
                    case 2 -> {
                        System.out.println(readerService.getAllReaders());
                    }
                    //TODO Get reader by ID
                    case 3 -> {
                        System.out.println("Write the reader's ID");
                        System.out.println(readerService.getReaderById(scanner.nextLong()));
                    }
                    //TODO update reader
                    case 4 -> {
                        Reader reader = new Reader();
                        System.out.println("Write reader ID");
                        long id=scanner.nextLong();
                        reader.setId(id);
                        reader.setFullName();
                        reader.setEmail();
                        reader.setPhoneNumber();
                        reader.setGender();
                        System.out.println(readerService.updateReader(id,reader));

                    }
                    //TODO Assign Reader to library
                    case 5 -> {
                        System.out.println("Write reader Id and library Id");
                        readerService.assignReaderToLibrary(scanner.nextLong(), scanner.nextLong());
                    }
                    //TODO Exist
                    case 6 -> {
                        isTrue = false;
                    }
                }
            }
        }catch (InputMismatchException e){
            System.err.println(e.getMessage());
        }

    }
}
