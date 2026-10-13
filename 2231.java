
class Solution {
    public int largestInteger(int num) {
        char[] arr = String.valueOf(num).toCharArray();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[i] - '0') % 2 == (arr[j] - '0') % 2 && arr[j] > arr[i]) {
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return Integer.parseInt(new String(arr));
    }
}
