public class TypesOfRecursion {
    
/*
Types of Recursion
There are primarily two important types of recursion:

1. Head Recursion

In head recursion, the recursive call is made before any other operations in the function.

The recursive call is not the last statement in the function.

After the recursive call returns, the function performs some additional tasks.

This means the function waits for the recursive call to complete before executing the remaining code.

Example behavior: If a function prints numbers from 5 to 0 using head recursion, the output will be in descending order (5, 4, 3, 2, 1, 0).

The function call stack grows until the base case is reached, and then the tasks are performed while unwinding the stack.





2. Tail Recursion

In tail recursion, the recursive call is the last statement in the function.

No additional operations are performed after the recursive call.

This allows some compilers or interpreters to optimize the recursion by reusing the current function's stack frame (tail call optimization).

Example behavior: If a function prints numbers from 5 to 0 using tail recursion, the output will be in ascending order (0, 1, 2, 3, 4, 5).

The function calls itself with a smaller input and immediately returns the result of the recursive call.


 */
}
