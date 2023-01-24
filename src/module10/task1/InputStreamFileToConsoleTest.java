package module10.task1;

import java.io.*;
import java.util.Scanner;

public class InputStreamFileToConsoleTest {
    public static void main(String[] args) {

        printValidNumbers();

    }

    public static void printValidNumbers() {
        File file = new File("src/module10/task1/file.txt");
        if (file.exists()) {
            try (InputStream fis = new FileInputStream(file);
                 Scanner scanner = new Scanner(fis)) {
                while (scanner.hasNext()) {
                    String number = scanner.nextLine();
                    if (number.matches("\\(\\d{3}\\)\\s\\d{3}-\\d{4}") ||
                        number.matches("\\d{3}-\\d{3}-\\d{4}")) {
                        System.out.println(number);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("File not exists or incorrect path");
        }
    }
}
