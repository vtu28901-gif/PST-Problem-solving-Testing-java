import java.util.*;

public class Result {
    public static List<Integer> maxSubarray(List<Integer> arr) {
        int currentSum = arr.get(0);
        int maxSum = arr.get(0);

        int currentPositive = Math.max(0, arr.get(0));
        int maxPositive = currentPositive;

        for (int i = 1; i < arr.size(); i++) {
            currentSum = Math.max(arr.get(i), currentSum + arr.get(i));
            maxSum = Math.max(maxSum, currentSum);

            currentPositive += Math.max(0, arr.get(i));
            maxPositive = Math.max(maxPositive, currentPositive);
        }

        return Arrays.asList(maxSum, maxPositive);
    }
}

/*
Input:
2
4
1 2 3 4
4
2 -1 2 3 4 -5

Output:
10 10
10 11
*/