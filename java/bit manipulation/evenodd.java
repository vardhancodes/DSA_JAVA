public class evenodd {

    
    public static void main(String[] args) {
        venodd(25);

    }

    public static void venodd (int num){
      if(isbitset(num, 0))
      {
        System.out.println("odd number");
      }
      else{

        System.out.println("even number");
      }
        

        
    }

    public static boolean isbitset(int num, int bit)
    {
        int res = num&(1<<bit);
        return (res==0)?false:true;
        


    }
}

    

