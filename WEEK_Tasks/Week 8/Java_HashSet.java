import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < t; i++) {
            String left = sc.next();
            String right = sc.next();

            String pair = left + " " + right;
            set.add(pair);

            System.out.println(set.size());
        }
    }
}

/*
Input:
5
john tom
john mary
john tom
mary anna
mary anna

Output:
1
2
2
3
3
*/
