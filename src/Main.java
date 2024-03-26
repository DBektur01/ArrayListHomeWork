import model.MainMethod;
import java.util.Scanner;
/**
 * @author Bektur Duyshenbek uulu
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isTrue=true;
        while (isTrue) {
            System.out.println("""
                    First, you need to add a library.
                    
                    1.Library
                    2.Book
                    3.Reader
                    4.Exit
                    """);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> MainMethod.getLibrary(scanner);
                case 2 -> MainMethod.getBook(scanner);
                case 3 -> MainMethod.getReader(scanner);
                case 4 -> isTrue=false;
            }
        }
    }
}