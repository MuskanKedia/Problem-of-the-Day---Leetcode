public class Solution {
    public ListNode detectCycle(ListNode head) 
    {
        if(head==null)
            return null;
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null && fast.next.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast)
            {
                fast=head;
                while(slow!=fast)
                {
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}

//Time Complexity : O(N)
//Space Complexity : O(1)
