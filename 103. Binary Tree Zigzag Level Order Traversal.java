class Solution
{
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)
            return res;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean flag=true;
        while(!q.isEmpty())
        {
            int size=q.size();
            List<Integer> temp=new ArrayList<>(size);
            for(int i=0;i<size;i++)
            {
                TreeNode node=q.poll();
                if(flag)
                    temp.add(node.val);
                else
                    temp.add(0,node.val);
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            }
            flag=!flag;
            res.add(temp);
        }
        return res;
    }
}

//Time Complexity : O(N)
//Space Complexity : O(N)
