import java.util.*;

public class Task9 {

    static int add(int a, int b) {
        return a + b;
    }

    static double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return (double) a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        String operator = sc.next();
        int b = sc.nextInt();

        try {
            if (operator.equals("+")) {
                int result = add(a, b);

                if (result == a + b) {
                    System.out.println("Test Passed");
                } else {
                    System.out.println("Test Failed");
                }
            } else if (operator.equals("/")) {
                double result = divide(a, b);

                if (result == (double) a / b) {
                    System.out.println("Test Passed");
                } else {
                    System.out.println("Test Failed");
                }
            }
        } catch (ArithmeticException e) {
            System.out.println("Test Failed");
        }
    }
}