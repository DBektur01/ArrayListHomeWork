package model;

import enums.Gender;

import enums.Genre;
import generateId.GenerateId;

import model.db.Database;
import service.serviceImpl.BookServiceImpl;
import service.serviceImpl.LibraryServiceImpl;
import service.serviceImpl.ReaderServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMethod {
    public void mainMethod(Scanner scanner){

        List<Library>libraries = new ArrayList<>();


        libraries.add(new Library(GenerateId.genLibraryId(),"Bilimkana",
                "Bishkek 19", Database.books,Database.readers));


        BookServiceImpl bookService = new BookServiceImpl();
        LibraryServiceImpl libraryService = new LibraryServiceImpl();
        ReaderServiceImpl readerService = new ReaderServiceImpl();

        while (true) {
            System.out.println("""
                    1.Library
                    2.Book
                    3.Reader
                    """);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    boolean isTrue =true;
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
                                libraryService.saveLibrary(libraries);
                                System.out.println("Successfully");
                                //Long id, String name, String address, List<Book> books, List<Reader> readers

                            }
                            case 2 -> {
                                System.out.println(libraryService.getAllLibraries());
                            }case 3 -> {
                                System.out.println("Write Library Id: ");
                                System.out.println(libraryService.getLibraryById(scanner.nextLong()));
                            }case 4 -> {
                                System.out.println("Write Library Id");
                                long updateScanner =scanner.nextLong();

                                Library library = new Library();
                                library.setId(GenerateId.genLibraryId());
                                System.out.println("Write library name: ");
                                scanner.nextLine();
                                library.setName(scanner.nextLine());
                                System.out.println("Write library address");
                                library.setAddress(scanner.nextLine());
                                library.setReaders(Database.readers);
                                library.setBooks(Database.books);
                                System.out.println(libraryService.updateLibrary(updateScanner, library));

                            }case 5 -> {
                                System.out.println("Write Library Id: ");
                                libraryService.deleteLibrary(scanner.nextLong());
                            }
                            case 6->{
                                isTrue=false;
                            }
                        }
                    }

                }
                case 2 -> {
                    boolean isTrue =true;
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
                        switch (BookChoice){
                            case 1->{
                                Book book = new Book();
                                book.setId(GenerateId.genBookId());
                                System.out.println("Write Name: ");
                                scanner.nextLine();
                                book.setName(scanner.nextLine());
                                System.out.println("Write author:");
                                book.setAuthor(scanner.nextLine());
                                book.setGenre(Genre.FANTASTIC);
                                System.out.println("Write library Id: ");
                                System.out.println(bookService.saveBook(scanner.nextLong(), book));

                            }
                            case 2 ->{
                                System.out.println("Write Library Id: ");
                                System.out.println(bookService.getAllBooks(scanner.nextLong()));
                            }
                            case 3 ->{
                                System.out.println("Write Library Id and book Id: ");
                                System.out.println(bookService.getBookById(scanner.nextLong(), scanner.nextLong()));
                            }
                            case 4->{System.out.println("Write Library Id and book Id: ");
                                System.out.println(bookService.deleteBook(scanner.nextLong(), scanner.nextLong()));
                            }
                            case 5->{
                                System.out.println("Write Library id: ");
                                bookService.clearBooksByLibraryId(scanner.nextLong());
                            }
                            case 6->{
                                isTrue=false;

                            }
                        }
                    }
                }
                case 3 -> {

                    boolean isTrue =true;
                    while (isTrue){
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
                            case 1 -> {
                                Reader reader = new Reader();
                                reader.setId(GenerateId.genReaderId());
                                System.out.println("Write FullName: ");
                                scanner.nextLine();
                                reader.setFullName(scanner.nextLine());
                                System.out.println("Write Email: ");
                                reader.setEmail(scanner.nextLine());
                                System.out.println("Write phoneNumber: ");
                                reader.setPhoneNumber(scanner.nextLine());
                                System.out.println("Write Gender");
                                String gender = scanner.nextLine();
                                if (gender.equals("Male")){
                                    reader.setGender(Gender.MALE);
                                    readerService.saveReader(reader);
                                }else if (gender.equals("Female")){
                                    reader.setGender(Gender.FEMALE);
                                    readerService.saveReader(reader);
                                }
                                System.out.println("Successfully");
                            }
                            case 2 -> {

                                System.out.println(readerService.getAllReaders());
                            }
                            case 3 -> {
                                System.out.println("Write Reader ID");
                                System.out.println(readerService.getReaderById(scanner.nextLong()));
                            }
                            case 4 -> {
                                Reader reader = new Reader();
                                reader.setId(GenerateId.genReaderId());
                                System.out.println("Write FullName: ");
                                scanner.nextLine();
                                reader.setFullName(scanner.nextLine());
                                System.out.println("Write Email: ");
                                reader.setEmail(scanner.nextLine());
                                System.out.println("Write phoneNumber: ");
                                reader.setPhoneNumber(scanner.nextLine());
                                System.out.println("Write Gender");
                                String gender = scanner.nextLine();
                                if (gender.equals("Male")){
                                    reader.setGender(Gender.MALE);
                                    System.out.println(readerService.updateReader(scanner.nextLong(),reader));
                                }else if (gender.equals("Female")){
                                    reader.setGender(Gender.FEMALE);
                                    System.out.println(readerService.updateReader(scanner.nextLong(),reader));
                                }
                                System.out.println("Successfully");
                            }
                            case 5 -> {
                                System.out.println("Write reader Id and library Id");
                                readerService.assignReaderToLibrary(scanner.nextLong(), scanner.nextLong());
                            }
                            case 6 ->{
                                isTrue=false;
                            }
                        }
                    }
                }
            }
        }
    }
}
