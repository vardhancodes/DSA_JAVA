public class PairwiseSwapNodes {
    

    public ListNode swapPairs(ListNode head) {
       ListNode first = head;
       ListNode prev = null;
       if(head == null || head.next == null )
       {
            return head;
       }
       head = head.next;
       while(first != null && first.next != null)
       {
            ListNode second = first.next;
            if(prev == null)
            {
                first.next = second.next;
                second.next = first;
                prev = first;
                first = first.next;
            }
            else
            {
                first.next = second.next;
                second.next = first;
                prev.next = second;
                prev = first;
                first = first.next;
            }
       }
       return head;
    }


    public ListNode swapPairs2(ListNode head) {
       ListNode first = head;
       ListNode prev = null;
       while(first != null && first.next != null)
       {
            ListNode second = first.next;
            first.next = second.next;
            second.next = first;
            if(prev == null)
            {
                head = second;
            }
            else
            {
                prev.next = second;
            }
            prev = first;
            first = first.next;
       }
       return head;
    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
