class Solution {
    public int longestPalindrome(String s) {
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j))
                    count++;
            }
            if (count >= 2)
                length += count / 2 * 2;
        }
        boolean odd = false;
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j))
                    count++;
            }
            if (count % 2 == 1)
                odd = true;
        }
        return odd ? length + 1 : length;
    }
}
