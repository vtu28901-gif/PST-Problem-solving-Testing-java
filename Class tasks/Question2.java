import java.util.*;
import java.util.stream.Collectors;

public class Question2 {

    public static void main(String[] args) {

        List<Integer> marks =
                Arrays.asList(45, 78, 32, 90, 65, 88, 40, 95);

        // Filter marks >= 60 and add 5 bonus marks
        List<Integer> updatedMarks = marks.stream()
                .filter(mark -> mark >= 60)
                .map(mark -> mark + 5)
                .collect(Collectors.toList());

        // Display updated marks
        System.out.println("Updated marks: " + updatedMarks);

        // Find average
        double average = updatedMarks.stream()
                .mapToInt(mark -> mark)
                .average()
                .orElse(0);

        System.out.println("Average: " + average);

        // Display in descending order
        System.out.println("Descending order:");

        updatedMarks.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(mark -> System.out.println(mark));
    }
}