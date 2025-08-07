public class printbits
 {
    public static void main(String[] args) {
        
        printb(32);
        
    }


    static void printb(int num)
    {
        for(int i = 7 ; i>= 0 ; i--)
        {
            System.out.print((num>>i) & 1)  ;
            

        }

        
    }

    
    



}


