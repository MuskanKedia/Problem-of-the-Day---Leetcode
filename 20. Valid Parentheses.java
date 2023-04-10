class Solution 
{
    public boolean isValid(String s) 
    {
        Stack<Character> stack=new Stack<Character>();
        for(char c:s.toCharArray())
        {
            if(c=='{'||c=='['||c=='(')
                stack.push(c);
            else
            {
                if(stack.isEmpty())
                    return false;
                char x=stack.pop();
                if((x=='{' && c=='}')||(x=='[' && c==']')||(x=='(' && c==')'))
                    continue;
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }
}

//Time Complexity : O(N)
//Space Complexity : O(N)
