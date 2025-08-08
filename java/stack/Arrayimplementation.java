
import java.util.Scanner;

public class Arrayimplementation
{
    int stack[];
    int top;
    int size;

    public Arrayimplementation(int stacksize){
        stack = new int[stacksize];
        size = stacksize;
        top = -1;
    }
    //PUSH function
    public void push(int element)
    {
        if(top >= size-1)
        {
            System.out.println("Stack is full - overflow");
            return;

        }
        top++;
        stack[top] = element;
    }

    //isempty function

    public boolean isempty()
    {
        return (top<=-1);

    }

    //size function

    public int size(){

        return top+1;
    }

    //peek function 

    public int peek()
    {
        if(isempty())
        {
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        }
        return stack[top];
    }

    //POP function

    public int pop()
    {
        int val = peek();
        if(val != Integer.MIN_VALUE)
        {
            top--;
        }
        return val;
    }

    //print stack function 

    public void print(){

        for(int i = 0 ; i <= top ; i++)
        {
            System.out.print(stack[i]);
            System.out.println();
            if(i != top)
            {
                System.out.println(',');
            }
        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Arrayimplementation stack = new Arrayimplementation(n);
        System.out.println("isempty: "+ stack.isempty());
        stack.push(4);
        stack.push(9);
        stack.pop();
        stack.print();
        stack.push(9);
        stack.print();
        stack.push(1);
        stack.print();
        stack.push(8);
        stack.print();
        stack.push(5);
        stack.print();
        stack.push(8);
        stack.print();
        stack.push(2);
        stack.print();
        stack.push(6);
        stack.print();
        stack.pop();
        stack.print();
        System.out.println("size:"+  stack.size());
        System.out.println("isEmpty:"+  stack.isempty());
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
        System.out.println("peek:"+  stack.peek());

        sc.close();
    }
    
}