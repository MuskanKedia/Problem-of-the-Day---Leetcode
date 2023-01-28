class SummaryRanges 
{
    TreeMap<Integer,Integer> tree;
    public SummaryRanges() 
    {
        tree=new TreeMap<>();
    }
    public void addNum(int value) 
    {
        if(tree.containsKey(value))
            return;
        Integer l=tree.lowerKey(value);
        Integer h=tree.higherKey(value);
        if(l!=null && h!=null && value==tree.get(l)+1 && value==h-1)
        {
            tree.put(l,tree.get(h));
            tree.remove(h);
        }
        else if(l!=null && value<=tree.get(l)+1)
            tree.put(l,Math.max(value,tree.get(l)));
        else if(h!=null && value==h-1)
        {
            tree.put(value,tree.get(h));
            tree.remove(h);
        }
        else
            tree.put(value,value);
    }
    public int[][] getIntervals() 
    {
        int[][] res=new int[tree.size()][2];
        int i=0;
        for(int a:tree.keySet())
        {
            res[i][0]=a;
            res[i][1]=tree.get(a);
            i++;
        }
        return res;
    }
}

//Time Complexity : O(logN)
//Space Complexity : O(N)
