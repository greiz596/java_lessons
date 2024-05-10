import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberGroupProcessor {
    public static Map<String, Integer> process(Map<String, List<String>> data) {
        Map<String, Integer> result = new HashMap<>();

        for (Map.Entry<String, List<String>> entry : data.entrySet()) {
            String key = entry.getKey();
            List<String> numbers = entry.getValue();
            int sum = 0;

            for (String numberStr : numbers) {
                String[] parts = numberStr.split(" ");
                for (String part : parts) {
                    sum += Integer.parseInt(part);
                }
            }

            result.put(key, sum);
        }

        return result;
    }

    public static void main(String[] args) {
        // Пример использования метода
        Map<String, List<String>> data = new HashMap<>();
        List<String> group1 = List.of("1 1", "2 2", "3 3");
        List<String> group2 = List.of("4 4", "5 5", "6 6");
        data.put("Group 1", group1);
        data.put("Group 2", group2);

        Map<String, Integer> result = process(data);

        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}







import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberGroupProcessor {
    public static Map<String, Integer> processSubtraction(Map<String, List<String>> data) {
        Map<String, Integer> result = new HashMap<>();

        for (Map.Entry<String, List<String>> entry : data.entrySet()) {
            String key = entry.getKey();
            List<String> numbers = entry.getValue();
            int difference = 0;

            for (String numberStr : numbers) {
                String[] parts = numberStr.split(" ");
                for (String part : parts) {
                    difference -= Integer.parseInt(part);
                }
            }

            result.put(key, difference);
        }

        return result;
    }

    public static void main(String[] args) {
        // Пример использования метода
        Map<String, List<String>> data = new HashMap<>();
        List<String> group1 = List.of("5 2", "8 4", "10 3");
        List<String> group2 = List.of("20 5", "15 6", "12 2");
        data.put("Group 1", group1);
        data.put("Group 2", group2);

        Map<String, Integer> result = processSubtraction(data);

        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
