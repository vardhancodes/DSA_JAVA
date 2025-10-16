public class LinkedList{
    Node<Integer> head;
    int size;

    public static void main(String[] args) {
        LinkedList obj = new LinkedList();
        obj.insertAtTail(10);
        obj.insertAtHead(10);
        obj.insertAtHead(10);
        obj.insertAtPosition(14,3);
        obj.printList();
        obj.deleteAtHead();
        obj.deleteAtHead();
        obj.deleteAtTail();
        obj.printList();
        obj.UpdateNode(2, 1);
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

//Deletion At Beginning
    public void deleteAtHead()
    {
        if(head == null)
        {
            System.out.println("Linked List is Empty");
            return;
        }
        Node<Integer> temp = head;
        head = temp.next;
        temp.next = null;
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
            size--;
            System.out.println("Deletion at tail is successful");
            return;

        }
        Node<Integer> temp = head;
        Node<Integer> prev = null;
        while(temp.next!= null)
        {
            prev= temp;
            temp = temp.next;
        }
        prev.next = null;
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
            Node<Integer> prev = null;
            Node<Integer> temp = head;
            while(counter < position-1 && temp!= null)
            {
                counter++;
                prev= temp;
                temp = temp.next;
            }
            prev.next = temp.next;
            temp.next = null;
            size--;
            System.out.println("Node Deleted at the given position");
        }
    }

//Update Node

public void UpdateNode(int UpdatedData, int position)
{
    if(head == null)
    {
        System.out.println("Linked List is empty");
        return;
    }
    int counter = 1;
    Node<Integer> temp = head;
    while(counter < position && temp!=null)
    {
        counter++;
        temp= temp.next;
    }
    if(temp != null && counter == position)
    {
        temp.data = UpdatedData;
    }
    else
    {
        System.out.println("Size of Linked List is smaller");
        return;
    }
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
        System.out.println();
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

