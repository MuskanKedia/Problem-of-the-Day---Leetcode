class Solution
{
    public TreeNode buildTree(int[] inorder, int[] postorder) 
    {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        TreeNode node=build(inorder,0,inorder.length-1,postorder,0,postorder.length-1,map);
        return node;
    }
    public TreeNode build(int[] inorder,int istart,int iend,int[] postorder,int pstart,int pend,Map<Integer,Integer> map)
    {
        if(istart>iend || pstart>pend)
            return null;
        TreeNode node=new TreeNode(postorder[pend]);
        int inRoot=map.get(node.val);
        int numsleft=inRoot-istart;
        node.left=build(inorder,istart,inRoot-1,postorder,pstart,pstart+numsleft-1,map);
        node.right=build(inorder,inRoot+1,iend,postorder,pstart+numsleft,pend-1,map);
        return node;
    }
}

//Time Complexity : O(N)
//Space Complexity : O(N)
