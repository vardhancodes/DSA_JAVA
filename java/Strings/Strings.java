//The equality of objects in Java depends not just on their values but also on their references in memory. 
//Two different objects with the same value will not be considered equal if they point to different memory locations.

//The String Constant Pool is a special memory area in Java where string literals (like "Hello", "Java") are stored.
//If the same literal is used again, Java doesn't create a new object.
//Instead, it gives a reference to the existing string in the pool.
//This saves memory and improves performance.

//The new keyword always creates a new object in the heap memory, even if string is already in the pool.



