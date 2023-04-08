class Solution
{
    public Node cloneGraph(Node node) 
    {
        HashMap<Integer,Node> map=new HashMap<>();
        return clone(node,map);
    }
    public Node clone(Node node,HashMap<Integer,Node> map)
    {
        if(node==null)
            return null;
        if(map.containsKey(node.val))
            return map.get(node.val);
        Node newNode=new Node(node.val);
        map.put(newNode.val,newNode);
        for(Node neighbor:node.neighbors)
            newNode.neighbors.add(clone(neighbor,map));
        return newNode;
    }
}

//Time Complexity : O(V+E)
//Space Complexity : O(V)
