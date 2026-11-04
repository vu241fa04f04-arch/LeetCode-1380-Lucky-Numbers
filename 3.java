
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int max = 0;
        int[] freq = new int[128];

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            while (freq[ch] > 0) {
                freq[s.charAt(left)]--;
                left++;
            }

            freq[ch]++;
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
