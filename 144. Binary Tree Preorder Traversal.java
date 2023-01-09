class Solution
{
    public List<Integer> preorderTraversal(TreeNode root)
    {
        List<Integer> list=new ArrayList<Integer>();
        TreeNode cur=root;
        while(cur!=null)
        {
            if(cur.left==null)
            {
                list.add(cur.val);
                cur=cur.right;
            }
            else
            {
                TreeNode prev=cur.left;
                while(prev.right!=null && prev.right!=cur)
                    prev=prev.right;
                if(prev.right==null)
                {
                    prev.right=cur;
                    list.add(cur.val);
                    cur=cur.left;
                }
                else
                {
                    prev.right=null;
                    cur=cur.right;
                }
            }
        }
        return list;
    }
}

//Time Complexity : O(N)
//Space Complexity : O(1)
