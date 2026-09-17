class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] lps = new int[n];

        for (int i = 1, len = 0; i < n;) {
            if (s.charAt(i) == s.charAt(len)) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                i++;
            }
        }

        int length = lps[n - 1];

        return length > 0 && n % (n - length) == 0;
    }
}

/*
Input:
s = "abab"

Output:
true
*/