import java.util.*;

public class Result {
    public static int alternatingCharacters(String s) {
        int count = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            }
        }

        return count;
    }
}

/*
Input:
5
AAAA
BBBBB
ABABABAB
BABABA
AAABBB

Output:
3
4
0
0
4
*/