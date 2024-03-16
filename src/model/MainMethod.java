package mainMethod;

import enums.Gender;
import model.Book;
import model.Reader;
import model.genrate.GenerateId;
import service.serviceImpl.BookServiceImpl;
import service.serviceImpl.LibraryServiceImpl;
import service.serviceImpl.ReaderServiceImpl;

import java.util.Scanner;

public class MainMethod {
    public void mainMethod(Scanner scanner){
        BookServiceImpl bookService = new BookServiceImpl();
        LibraryServiceImpl libraryService = new LibraryServiceImpl();
        ReaderServiceImpl readerService = new ReaderServiceImpl();
        while (true) {
            System.out.println("""
                    1.Reader
                    2.Library
                    3.Book
                    """);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    //InnerWhile;
                    while (true){
                        System.out.println("""
                                1.Save Reader
                                2.Get All Readers
                                3.Get Reader By Id
                                4.Update Reader
                                5.Assign Reader To Library
                                """);
                        int bookChoice = scanner.nextInt();
                        switch (bookChoice) {
                            case 1 -> {
//                                System.out.println("Write id: ");
//                                long id =scanner.nextLong();
                                System.out.println("Write FullName: ");
                                scanner.nextLine();
                                String fullName = scanner.nextLine();
                                System.out.println("Write Email: ");
                                String email = scanner.nextLine();
                                System.out.println("Write phoneNumber: ");
                                String phoneNumber = scanner.nextLine();
                                System.out.println("Write Gender");
                                String gender = scanner.nextLine();
                                if (gender.equals("Male")){
                                    Reader reader1 = new Reader(GenerateId.genReaderId(), fullName, email, phoneNumber, Gender.MALE);
                                    readerService.saveReader(reader1);
                                }else if (gender.equals("Female")){
                                    Reader reader1 = new Reader(GenerateId.genReaderId(), fullName, email, phoneNumber, Gender.FEMALE);
                                    readerService.saveReader(reader1);
                                }
                            }
                            case 2 -> {
                                System.out.println(readerService.getAllReaders());
                            }
                            case 3 -> {
                                System.out.println("Write Reader ID");
                                System.out.println(readerService.getReaderById(scanner.nextLong()));
                            }
                            case 4 -> {
                                System.out.println("Write Reader Id");
                                long id =scanner.nextLong();
                                System.out.println("Write FullName: ");
                                scanner.nextLine();
                                String fullName = scanner.nextLine();
                                System.out.println("Write Email: ");
                                String email = scanner.nextLine();
                                System.out.println("Write phoneNumber: ");
                                String phoneNumber = scanner.nextLine();
                                System.out.println("Write Gender");
                                String gender = scanner.nextLine();
                                if (gender.equals("Male")){
                                    Reader reader1 = new Reader(GenerateId.genReaderId(), fullName, email, phoneNumber, Gender.MALE);
                                    System.out.println(readerService.updateReader(scanner.nextLong(),reader1));
                                }else if (gender.equals("Female")){
                                    Reader reader1 = new Reader(GenerateId.genReaderId(), fullName, email, phoneNumber, Gender.FEMALE);
                                    System.out.println(readerService.updateReader(scanner.nextLong(),reader1));
                                }
                            }
                            case 5 -> {
                                System.out.println("Write reader Id and library Id");
                                readerService.assignReaderToLibrary(scanner.nextLong(), scanner.nextLong());
                            }
                        }
                    }
                }
                case 2 -> {
                    while (true) {
                        System.out.println("""
                                1.Save Library
                                2.Get All Libraries
                                3.Get Library By Id
                                4.Update Library
                                5.Delete Library By Id
                                """);
                        int choiceLibrary = scanner.nextInt();
                        switch (choiceLibrary) {
                            case 1 -> {

                            }
                            case 2 -> {
                                System.out.println(libraryService.getAllLibraries());
                            }
                            case 3 -> {
                                System.out.println("Write Library Id: ");
                                libraryService.getLibraryById(scanner.nextLong());
                            }
                            case 4 -> {
                                System.out.println();

                            }
                            case 5 -> {
                                System.out.println("Write Library Id: ");
                                libraryService.deleteLibrary(scanner.nextLong());
                            }
                        }
                    }
                }
                case 3 -> {
                    while (true) {
                        System.out.println("""
                                1.Save Book
                                2.Get All Books
                                3.Get Book By Id
                                4.Delete Book
                                5.Delete Book By Id
                                6.Clear Books By Library Id
                                      """);
                        int BookChoice = scanner.nextInt();
                        switch (BookChoice){
                            case 1->{

                                bookService.saveBook(GenerateId.genBookId(),new Book());
                            }

                        }
                    }
                }
            }
        }
    }
}
