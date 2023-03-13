class Solution 
{
    public boolean isSymmetric(TreeNode root) 
    {
        return root==null || check(root.left,root.right);
    }
    public boolean check(TreeNode left,TreeNode right)
    {
        if(left==null || right==null)
            return left==right;
        else if(left.val!=right.val)
            return false;
        return check(left.left,right.right) && check(left.right,right.left);
    }
}

//Time Complexity : O(N)
//Space Complexity : O(H)
