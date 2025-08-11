import java.util.Stack;

public class NextsmallerElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] ans = nextSmel(arr);
        for(int i = 0 ; i < ans.length ; i++)
        {
            System.out.print(ans[i] + " ");
        }
    }

//Next Smaller Element

//logic : reverse of NextgreaterElement problem.


public static int[] nextSmel(int arr[])
{
    int[] results = new int[arr.length];
    Stack<Integer> stack = new Stack<>();

    for(int i = arr.length-1 ; i>= 0 ; i --)
    {
        while(!stack.isEmpty() && stack.peek()>= arr[i])
        {
            stack.pop();
        }
        if(stack.isEmpty())
        {
            results[i] = -1; 
        }
        else
        {
            results[i] = stack.peek();
        }
        stack.push(arr[i]);
    }

    return results;

}
}
