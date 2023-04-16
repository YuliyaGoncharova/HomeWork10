package task2FileToFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UsersReader {
    private List<User> users;

    public List<User> parseFile(String fileName) {
        List<User> users = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fileReader);
            String userLine = reader.readLine();
            do {
                userLine = reader.readLine();
                if (userLine != null) {
                    String[] userParams = userLine.split(" ");
                    User newUser = new User(userParams[0], userParams[1]);
                    users.add(newUser);
                }
            } while (userLine != null);

            fileReader.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return users;
    }

    public void saveToJson(List<User> users, String fileName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(users);
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.append(json);

            fileWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }

//        System.out.println(json);
    }
}
