package sprint7.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static sprint7.utils.constants.Constants.*;

public class GenerateData {

    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

    public static String generateRandomPhoneNumber() {
        return String.format("+7-%03d-%03d-%02d-%02d",
                RANDOM.nextInt(1000),
                RANDOM.nextInt(1000),
                RANDOM.nextInt(100),
                RANDOM.nextInt(100));
    }

    public static String generateRandomDate() {
        int day = RANDOM.nextInt(28) + 1;
        int month = RANDOM.nextInt(12) + 1;
        int year = RANDOM.nextInt(2024 - 1900) + 1900;

        LocalDate date = LocalDate.of(year, month, day);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }
}