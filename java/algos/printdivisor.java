public class printdivisor {

    public static void main(String[] args) {

        printdiv(24);
        
        
    }

    static void printdiv(int num)
    {
        int counter  = 1;
        int sqroot = (int)Math.sqrt(num);
        while(counter<=sqroot)
        {
            if(num%counter ==0)
            {
                System.out.println(counter + " is a divisor of " + num);
                int otherfactor = num/counter;
                if(counter!=otherfactor)
                {
                    System.out.println(otherfactor + " is a divisor of " + num);
                }
            }
            counter++;
        }
        
}
}