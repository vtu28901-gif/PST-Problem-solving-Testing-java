import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Function<Integer, Integer> increaseSalary =
                salary -> salary + salary / 10;

        IntStream.range(0, n)
                .map(i -> increaseSalary.apply(sc.nextInt()))
                .forEach(salary -> System.out.print(salary + " "));
    }
}