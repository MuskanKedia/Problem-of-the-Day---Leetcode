class LFUCache 
{
    final int capacity;
    int minFrequency;
    int curSize;
    Map<Integer,DLLnode> cache;
    Map<Integer,DoubleLinkedList> frequencyMap;
    
    class DLLnode
    {
        int key;
        int val;
        int frequency;
        DLLnode prev;
        DLLnode next;
        public DLLnode(int key,int val)
        {
            this.key=key;
            this.val=val;
            this.frequency=1;
        }
    }
    
    class DoubleLinkedList
    {
        int listSize;
        DLLnode head;
        DLLnode tail;
        public DoubleLinkedList()
        {
            this.listSize=0;
            this.head=new DLLnode(0,0);
            this.tail=new DLLnode(0,0);
            head.next=tail;
            tail.prev=head;
        }
        public void addNode(DLLnode curNode)
        {
            DLLnode nextNode=head.next;
            curNode.next=nextNode;
            curNode.prev=head;
            head.next=curNode;
            nextNode.prev=curNode;
            listSize++;
        }
        public void removeNode(DLLnode curNode)
        {
            DLLnode prevNode=curNode.prev;
            DLLnode nextNode=curNode.next;
            prevNode.next=nextNode;
            nextNode.prev=prevNode;
            listSize--;
        }
    }
    public LFUCache(int capacity)
    {
        this.capacity=capacity;
        this.curSize=0;
        this.minFrequency=0;
        this.cache=new HashMap<>();
        this.frequencyMap=new HashMap<>();
    }
    
    public int get(int key) 
    {
        DLLnode curNode=cache.get(key);
        if(curNode==null)
            return -1;
        updateNode(curNode);
        return curNode.val;
    }
    
    public void put(int key, int value) 
    {
        if(capacity==0)
            return;
        if(cache.containsKey(key))
        {
            DLLnode curNode=cache.get(key);
            curNode.val=value;
            updateNode(curNode);
        }
        else
        {
            curSize++;
            if(curSize>capacity)
            {
                DoubleLinkedList minFreqList=frequencyMap.get(minFrequency);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                curSize--;
            }
            minFrequency=1;
            DLLnode newNode=new DLLnode(key,value);
            DoubleLinkedList curList=frequencyMap.getOrDefault(1,new DoubleLinkedList());
            curList.addNode(newNode);
            frequencyMap.put(1,curList);
            cache.put(key,newNode);
        }
    }
    
    public void updateNode(DLLnode curNode)
    {
        int curFreq=curNode.frequency;
        DoubleLinkedList curList=frequencyMap.get(curFreq);
        curList.removeNode(curNode);
        if(curFreq==minFrequency && curList.listSize==0)
            minFrequency++;
        curNode.frequency++;
        DoubleLinkedList newList=frequencyMap.getOrDefault(curNode.frequency,new DoubleLinkedList());
        newList.addNode(curNode);
        frequencyMap.put(curNode.frequency,newList);
    }
}

//Time Complexity : O(1)
//Space Complexity : O(N)
