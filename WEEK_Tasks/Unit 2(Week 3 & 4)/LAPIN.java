import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            int[] count = new int[26];

            int mid = s.length() / 2;

            for (int i = 0; i < mid; i++) {
                count[s.charAt(i) - 'a']++;
            }

            for (int i = (s.length() + 1) / 2; i < s.length(); i++) {
                count[s.charAt(i) - 'a']--;
            }

            boolean lapindrome = true;

            for (int value : count) {
                if (value != 0) {
                    lapindrome = false;
                    break;
                }
            }

            System.out.println(lapindrome ? "YES" : "NO");
        }
    }
}

/*
Input:
5
gaga
abcde
rotor
xyzxy
abba

Output:
YES
NO
YES
NO
YES
*/