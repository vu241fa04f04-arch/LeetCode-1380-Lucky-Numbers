
class Solution {
    public int sumNumbers(TreeNode root) {
        return calculate(root, 0);
    }

    private int calculate(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return calculate(root.left, sum) + calculate(root.right, sum);
    }
}
