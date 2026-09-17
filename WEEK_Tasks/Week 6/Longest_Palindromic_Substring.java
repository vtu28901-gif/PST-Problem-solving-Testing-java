class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        StringBuilder transformed = new StringBuilder("^");

        for (char c : s.toCharArray()) {
            transformed.append("#");
            transformed.append(c);
        }

        transformed.append("#$");

        int n = transformed.length();
        int[] radius = new int[n];

        int center = 0;
        int right = 0;
        int maxLength = 0;
        int maxCenter = 0;

        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * center - i;

            if (i < right) {
                radius[i] = Math.min(right - i, radius[mirror]);
            }

            while (transformed.charAt(i + 1 + radius[i]) ==
                   transformed.charAt(i - 1 - radius[i])) {
                radius[i]++;
            }

            if (i + radius[i] > right) {
                center = i;
                right = i + radius[i];
            }

            if (radius[i] > maxLength) {
                maxLength = radius[i];
                maxCenter = i;
            }
        }

        int start = (maxCenter - maxLength) / 2;

        return s.substring(start, start + maxLength);
    }
}

/*
Input:
s = "babad"

Output:
"bab"
*/