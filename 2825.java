class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0, j = 0;

        while (i < str1.length() && j < str2.length()) {
            char c = str1.charAt(i);

            if (c == str2.charAt(j) || (c - 'a' + 1) % 26 == str2.charAt(j) - 'a') {
                j++;
            }

            i++;
        }

        return j == str2.length();
    }
}