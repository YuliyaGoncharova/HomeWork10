package task1FileToConsole;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import java.


public class PhonesReader {
    private String fileName;

    public PhonesReader(String fileName) {
        this.fileName = fileName;
    }

    public List<String> readPhoneNumbersFromFile() {
        List<String> phoneNumbers = new ArrayList<>();

        //987-123-4567
        String format1 = "^\\d{3}-\\d{3}-\\d{4}";
        Pattern pattern1 = Pattern.compile(format1);

        //(123) 456-7890
        String format2 = "^\\(\\d{3}\\) \\d{3}-\\d{4}";
        Pattern pattern2 = Pattern.compile(format2);

        try {
            FileReader fileReader = new FileReader(this.fileName);
            BufferedReader reader = new BufferedReader(fileReader);

            String line;
            do {
                line = reader.readLine();
                if (line != null) {
                    Matcher matcher1 = pattern1.matcher(line);
                    Matcher matcher2 = pattern2.matcher(line);
                    if (matcher1.matches() || matcher2.matches()) {
                        phoneNumbers.add(line);
                    }
                }
            } while (line != null);

        } catch (Exception e) {
            System.out.println(e);
        }

        return phoneNumbers;
    }
}
