public class Effecienteuclideanalgo {

    public static void main(String[] args) {
        
        int answer =  ealgo(12122, 112);
        System.out.println(answer);
     }
 
     public static int ealgo(int num1, int num2)
     {
         while(num1!=0 && num2 !=0)
         {
             if(num1 > num2)
             {
                 num1 %= num2;
             }
             else 
             {
                 num2 %= num1;
             }
 
         }
         int res = num1;
         if(num1 == 0)
         {
             res = num2;
         }
         return res;
     }
     
 }
 
    

