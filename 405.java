class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        char[] hex = "0123456789abcdef".toCharArray();
        StringBuilder result = new StringBuilder();

        while (num != 0 && result.length() < 8) {
            result.append(hex[num & 15]);
            num >>>= 4;
        }

        return result.reverse().toString();
    }
}
