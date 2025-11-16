public class ToBinary {
    public static void main(String[] args) {
        toBinary(89);
    }

// 3 IMPORTANT THINGS ARE NEEDED TO CONSTRUCT A RECURSIVE FUNCTION 
//1. BASE CASE
//2. REPETITIVE FUNCTION
//3. NEXT INPUT

//To binary function:

  public static void toBinary(int n) {
        // code here
        if(n == 0)
        {
            return ;
        }
        toBinary(n/2);
        System.out.print(n%2);
    }
}
