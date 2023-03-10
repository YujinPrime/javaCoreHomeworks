package module10.task1;

import java.io.*;
import java.util.Scanner;

public class FileToConsoleTest {
    private static final String FILE_PATH = "src/main/java/module10/task1/file.txt";
    private static final String VALID_PHONE_NUMBER_PATTERN = "(\\(\\d{3}\\) |\\d{3}-)\\d{3}-\\d{4}";

    public static void main(String[] args) {
        printValidNumbers();
    }

    public static void printValidNumbers() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try (InputStream fis = new FileInputStream(file);
                 Scanner scanner = new Scanner(fis)) {
                while (scanner.hasNext()) {
                    String number = scanner.nextLine();
                    if (number.matches(VALID_PHONE_NUMBER_PATTERN)) {
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
