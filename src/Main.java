

import model.MainMethod;

import java.util.Scanner;

/**
 * @author Bektur Duyshenbek uulu
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    1.Library
                    2.Book
                    3.Reader
                    """);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> MainMethod.getLibrary(scanner);
                case 2 -> MainMethod.getBook(scanner);
                case 3 -> MainMethod.getReader(scanner);

            }
        }
    }
}