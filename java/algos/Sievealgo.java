import java.util.Arrays;

public class Sievealgo {
    public static void main(String[] args) {
        
        sievealgo(100);
    }

    static void sievealgo(int num)
    {
        boolean arr[] = new boolean[num+1];
        Arrays.fill(arr, true);
        int counter = 2;
        int count = 0;
        while(counter <= num)
        {
            if(arr[counter] == true)
            for(int factor = counter + counter ; factor <= num; factor+=counter)
            {
                arr[factor] = false;
            }
            counter++;
        }
        for(int i = 2; i <=num; i++)
        {
            System.out.println(i + " : " + arr[i]);
            if(arr[i]==true)
            {
                count++;
            }
        }

        System.out.println("total no. of prime numbers between 1 and " +num+ " are: "+ count);

            
        

}
}
