class Solution 
{
    public int minDiffInBST(TreeNode node) 
    {
        int diff = Integer.MAX_VALUE;
        if(node == null)
            return diff;
        Stack<TreeNode> stk = new Stack();
        TreeNode prev = null;
        while(!stk.isEmpty() || node != null)
        {
            while(node != null)
            {
                stk.push(node);
                node = node.left;
            }
            TreeNode popped = stk.pop();
            if(prev != null)
               diff = Math.min(diff, popped.val-prev.val); 
            prev = popped;
            node = popped.right;
        }
        return diff;
    }
}

//Time Complexity : O(n) where n is the number of nodes
//Space Complexity : O(h) where h is the height of the tree
