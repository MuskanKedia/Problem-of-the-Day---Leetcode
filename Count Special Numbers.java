class Solution 
{
    public int countSpecialNumbers(int N, int arr[]) 
    {
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<N;i++)
            if(map.containsKey(arr[i]))
                map.put(arr[i],map.get(arr[i])+1);
            else
                map.put(arr[i],1);
        for(int i=0;i<N;i++)
        {
            boolean flag=false;
            int j=1;
            while(j!=arr[i])
            {
                if(arr[i]%j==0 && map.containsKey(j))
                {
                    count++;
                    flag=true;
                    break;
                }
                j++;
            }
            if(!flag && map.get(j)>1)
                count++;
        }
        return count;
    }
}

//Time Complexity : O(N*max(arr))
//Space Complexity : O(N)
