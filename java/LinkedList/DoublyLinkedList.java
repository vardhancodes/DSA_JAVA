
public class DoublyLinkedList {

    DoublyNode<Integer> head;
    int size;
    DoublyNode<Integer> tail;

    DoublyLinkedList(){
        this.head = null;
        this.size = 0;
        this.tail = null;

    }

    public static void main(String[] args) {
        DoublyLinkedList obj = new DoublyLinkedList();
        obj.insertAtTail(10);
        obj.insertAtHead(10);
        obj.insertAtHead(10);
        obj.insertAtPosition(14,3);
        obj.printList();
        obj.printListrev();
        

    }

//Insertion At Beginning.
    public void insertAtHead(int data)
    {
        DoublyNode<Integer> newnode = new DoublyNode<>(data);
        if(head == null)
        {
            head = newnode;
            tail = newnode;
            System.out.println("Node Inserted at head");
            size++;
            return;
        }
        newnode.next = head;
        head.prev = newnode;
        head = newnode;

        size++;
        System.out.println("Node Inserted at head");
    }

//Insertion At End.
    public void insertAtTail(int data)
    {
        DoublyNode<Integer> newnode = new DoublyNode<>(data);
        if(head == null)
        {
            head = newnode;
            tail = newnode;
            System.out.println("Node Inserted at tail");
            size++;
            return;
        }
        DoublyNode<Integer> temp = head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next = newnode;
        newnode.prev = temp;
        tail = newnode;
        System.out.println("Node Inserted at tail");
        size++;
    }

//Insertion At any postion
    public void insertAtPosition(int data , int position)
    {
        if(position > size+1 || position <= 0)
        {
            System.out.println("Wrong input");
        }
        if(position == 1)
        {
            insertAtHead(data);
            return;
        }
        else if(position == size+1)
        {
            insertAtTail(data);
            return;
        }
        else 
        {
            int counter = 1;
            DoublyNode<Integer> newnode = new DoublyNode<>(data);
            DoublyNode<Integer> temp = head;
            while(counter < position-1 && temp!= null)
            {
                counter++;
                temp = temp.next;
            }
            DoublyNode<Integer> currentnode = temp.next;
            newnode.next = currentnode;
            currentnode.prev = newnode;
            temp.next = newnode;
            newnode.prev = temp;
            size++;
        }
        System.out.println("Node Inserted at the given position");
    }

//Print List in reverse

    public void printListrev()
    {
        DoublyNode<Integer> temp = tail;
        while(temp!=null)
        {
            System.out.print(temp.data+" -> ");
            temp=temp.prev;
        }
        System.out.println();
    }


//Print List

    public void printList()
    {
        DoublyNode<Integer> temp = head;
        while(temp!=null)
        {
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.println();
    }

//Deletion At Beginning
    public void deleteAtHead()
    {
        if(head == null)
        {
            System.out.println("Linked List is Empty");
            return;
        }
        DoublyNode<Integer> temp = head;
        head = head.next;
        temp.next = null;
        if(head == null)
        {
            tail = null;
        } 
        else
        {
            head.prev = null;
        }
        System.out.println("Deletion at head is successful");
        size--;
    }

//Deletion At Tail

    public void deleteAtTail()
    {
        if(head == null)
        {
            System.out.println("Linked List is empty");
            return;
            
        }
        if(head.next == null)
        {
            head = null;
            tail = null;
            size--;
            System.out.println("Deletion at tail is successful");
            return;

        }
        DoublyNode<Integer> temp = head;
        DoublyNode<Integer> prevnode = null;
        while(temp.next!= null)
        {
            prevnode= temp;
            temp = temp.next;
        }
        prevnode.next = null;
        temp.prev = null;
        tail = prevnode;
        System.out.println("Deletion at tail is successful");
        size--;
    }

//Deletion at Postion

public void DeleteAtPosition(int position)
    {
        if(position > size+1 || position <= 0)
        {
            System.out.println("Wrong input");
            return;
        }
        if(position == 1)
        {
            deleteAtHead();
            return;
        }
        else if(position == size)
        {
            deleteAtTail();
            return;
        }
        else 
        {
            int counter = 1;
            DoublyNode<Integer> prevNode = null;
            DoublyNode<Integer> temp = head;
            while(counter < position-1 && temp!= null)
            {
                counter++;
                prevNode= temp;
                temp = temp.next;
            }
            DoublyNode<Integer> nextNode = temp.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            temp.next = null;
            temp.prev = null;
            size--;
            System.out.println("Node Deleted at the given position");
        }
    }



    

    
}
class DoublyNode<T>
{
    T data;
    DoublyNode<T> next;
    DoublyNode<T> prev;

    DoublyNode()
    {
        this.next = null;
        this.prev = null;
    }
    
    DoublyNode(T data)
    {
        this.next = null;
        this.data = data;
        this.prev = null;
    }

}
