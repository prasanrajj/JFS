package executors;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class TryWithResourcesDemo {

    public static void main(String[] args) {

        try (
            FileInputStream fis = 
            new FileInputStream
            ("C:\\Users\\Prasanna\\eclipse-workspace\\JFS\\src\\executors/sample.txt");
            Scanner scanner = new Scanner(fis);
        ) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

