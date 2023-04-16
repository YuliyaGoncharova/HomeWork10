import task1FileToConsole.PhonesReader;

import java.util.List;

import task1FileToConsole.PhonesReader;
import task2FileToFile.User;
import task2FileToFile.UsersReader;
import task3UniqWords.UniqWords;

public class Main {

    static void Task1() {
        PhonesReader reader = new PhonesReader("file_phone_numbers.txt");
        List<String> phoneNumbers = reader.readPhoneNumbersFromFile();
        for (String phNumber:
                phoneNumbers) {
            System.out.println(phNumber);
        }
//        System.out.println(phoneNumbers);
    }

    static void Task2() {
        UsersReader reader = new UsersReader();
        List<User> users = reader.parseFile("file_task2.txt");
        reader.saveToJson(users, "test.json");
    }

    static void Task3() {
        UniqWords uniqWords = new UniqWords();
        uniqWords.parseFile("words.txt");
    }

    public static void main(String[] args) {
        Task1();
//        Task2();
//        Task3();
    }
}