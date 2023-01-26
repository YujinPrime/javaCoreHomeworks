package module10.task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserToJson {
    private String sourceFile = "src/module10/task2/file.txt";
    private String jsonFile = "src/module10/task2/user.json";
    private List<User> users = new ArrayList<>();

    public void usersFromTextToJson() {
        allUsersToList();
        allUsersToJson();
    }

    private void allUsersToList() {
        File file = new File(sourceFile);

        if (file.exists()) {
            try (InputStream fis = new FileInputStream(file);
                 Scanner scanner = new Scanner(fis)) {
                scanner.nextLine();
                while (scanner.hasNext()) {
                    String[] userStringData = scanner.nextLine().split(" ");
                    users.add(new User(userStringData[0], Integer.parseInt(userStringData[1])));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File not exists or incorrect path");
        }
    }

    private void allUsersToJson() {
        try (Writer fileWriter = new FileWriter(jsonFile)){
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            gson.toJson(users, fileWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
