import java.util.*;
public class AddTwoNum {
    public static void main(String[] args) {
        ListNode head1 = null;
        ListNode temp1 = head1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of l1: ");
        int size1 = sc.nextInt();
        System.out.println("Enter size of l2: ");
        int size2 = sc.nextInt();

        for(int i = 0 ; i < size1 ; i++)
        {
            System.out.println("Enter node value of L1: ");
            ListNode newNode = new ListNode(sc.nextInt());
            if(head1 == null)
            {
                head1 = newNode;
                temp1 = newNode;
            }
            else
            {
                temp1.next = newNode;
                temp1 = temp1.next;
            }
            
        }
        ListNode head2 = null;
        ListNode temp2 = head2;
        for(int i = 0 ; i < size2 ; i++)
        {
            System.out.println("Enter node value of L2: ");
            ListNode newNode = new ListNode(sc.nextInt());
            if(head2 == null)
            {
                head2 = newNode;
                temp2 = newNode;
            }
            else
            {
                temp2.next = newNode;
                temp2 = temp2.next;
            }
            
        }
        ListNode ans = addTwoNumbers(head1, head2);
        ListNode temp = ans;
        while(temp!=null)
        {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode temp = null;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0)
        {
            int val1 = (l1 == null)?0:l1.val;
            int val2 = (l2 == null)?0:l2.val;
            int value = val1 + val2 + carry;
            ListNode newNode = new ListNode(value%10);
            carry = value/10;
            if(head == null)
            {
                head = newNode;
                temp = newNode;
            }
            else
            {
                temp.next = newNode;
                temp = newNode;
            }
            if(l1!=null)
            {
                l1=l1.next;
            }
            if(l2!=null)
            {
                l2 = l2.next;
            }
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


