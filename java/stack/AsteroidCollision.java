import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = {5,10,-5};
        int ans[] = asteroidCollision(asteroids);
        for(int i = 0 ; i < ans.length ; i++)
        {
            System.out.print(ans[i] + " ");

        }

        
    }


//Asteroid Collision:

//Approach : 
//1. Create an empty stack to store asteroids that survive after possible collisions.
//
// 2. Iterate through each asteroid in the given array.
//
// 3. If the stack is empty OR the current asteroid is moving right (> 0):
//    → Push the asteroid into the stack (no collision possible in this case).
//
// 4. If the current asteroid is moving left (< 0):
//    → Check for collisions with the asteroid on top of the stack.
//
// 5. Inside the collision check loop:
//    a) If the top asteroid is also moving left (< 0):
//       → No collision occurs, so push the current asteroid and stop checking.
//
//    b) If the top asteroid is larger in size than the current asteroid:
//       → Current asteroid is destroyed; stop checking further.
//
//    c) If both asteroids have the same size:
//       → Both get destroyed (pop top asteroid from the stack) and stop checking.
//
//    d) If the current asteroid is larger:
//       → Pop the top asteroid (destroy it) and keep checking for more collisions.
//
// 6. If the current asteroid is still not destroyed after all checks:
//    → Push it into the stack.
//
// 7. After processing all asteroids:
//    → The stack contains the surviving asteroids from left to right.
//
// 8. Convert the stack into an array in correct order and return it as the result.


public static int[] asteroidCollision(int[] asteroids){

    Stack<Integer> stack = new Stack<>();

    for(int i = 0 ; i < asteroids.length ; i++)
    {
        if(stack.isEmpty() || asteroids[i] > 0)
        {
            stack.push(asteroids[i]);

        }
        else{

            while(!stack.isEmpty())
            {
                int top = stack.peek();
                if(top < 0)
                {
                    stack.push(asteroids[i]);
                    break;
                }
                int modVal = Math.abs(asteroids[i]);
                if(top > modVal)
                {
                    break;
                }
                else if (top == modVal)
                {
                    stack.pop();
                    break;
                }
                else 
                {
                    stack.pop();
                    if(stack.isEmpty())
                    {
                        stack.push(asteroids[i]);
                        break;
                    }
                }

                    
                


            }
        }
    }

    int ans[] = new int[stack.size()];
    int len = stack.size();

    for(int i = len-1 ; i>= 0 ; i-- )
    {
        ans[i] = stack.pop();
    }

    return ans;


}
}
