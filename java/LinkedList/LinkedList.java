public class LinkedList{
    Node<Integer> head;
    int size;

    public static void main(String[] args) {
        LinkedList obj = new LinkedList();
        obj.insertAtTail(10);
        obj.insertAtHead(10);
        obj.printList();
    }

    LinkedList()
    {
        this.head = null;
        this.size = 0;
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
            Node<Integer> newnode = new Node<>(data);
            Node<Integer> temp = head;
            while(counter < position-1 && temp!= null)
            {
                counter++;
                temp = temp.next;
            }
            newnode.next = temp.next;
            temp.next = newnode;
            size++;
        }
        System.out.println("Node Inserted at the given position");
    }


//Insertion At Beginning.
    public void insertAtHead(int data)
    {
        Node<Integer> newnode = new Node<>(data);
        if(head == null)
        {
            head = newnode;
            System.out.println("Node Inserted at head");
            size++;
            return;
        }
        newnode.next = head;
        head = newnode;
        System.out.println("Node Inserted at head");
        size++;

    }


//Insertion At End.
    public void insertAtTail(int data)
    {
        Node<Integer> newnode = new Node<>(data);
        if(head == null)
        {
            head = newnode;
            System.out.println("Node Inserted at tail");
            size++;
            return;
        }
        Node<Integer> temp = head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next = newnode;
        System.out.println("Node Inserted at tail");
        size++;
    }


//Print List

    public void printList()
    {
        Node<Integer> temp = head;
        while(temp!=null)
        {
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
    }
}
class Node<T> {
    T data;
    Node<T> next;

    Node(){
        this.next = null;
    }

    Node(T data)
    {
        this.data = data;
        this.next = null;

    }
}

