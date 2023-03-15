class Solution {
    public boolean isCompleteTree(TreeNode root) {
        int total = countNodes(root);
        return helper(root, 1, total);
    }
    
    private int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    private boolean helper(TreeNode root, int idx, int total) {
        if (root == null) {
            return true;
        }
        if (idx > total) {
            return false;
        }
        return helper(root.left, idx * 2, total)
            && helper(root.right, idx * 2 + 1, total);
    }
}

//Time Complexity : O(N)
//Space Complexity : O(H)
