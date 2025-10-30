public class MiddleOfLL {

//Brute Force

    public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int length = 1;
        while(temp.next != null)
        {
            length++;
            temp = temp.next;
        }
        int target = length/2 + 1;
        int counter = 1;
        while(counter < target)
        {
            head = head.next;
            counter++;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() 
    {
        
    }
    ListNode(int val) 
    { 
        this.val = val; 
    }

    ListNode(int val, ListNode next) 
    { 
        this.val = val; 
        this.next = next;

    } 
}
