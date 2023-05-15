class Solution {
    public ListNode swapNodes(ListNode head, int k) {		
        ListNode fast = head;
        ListNode slow = head;
        ListNode first = head, second = head;
        
		// Put fast (k-1) nodes after slow
        for(int i = 0; i < k - 1; ++i)
            fast = fast.next;
            
		// Save the node for swapping
        first = fast;

		// Move until the end of the list
        while(fast.next != null) {
			slow = slow.next;
            fast = fast.next;
        }
        second = slow;
		
		// Swap values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
        return head;
    }
}

//Time Complexity : O(N)
//Space Complexity : O(1)
