public class newtonraphson {

    public static void main(String[] args) {
        
       double ans = mysqrt(4);
       System.out.println(ans);
    }

    public static double mysqrt(int num){
        double tol = 0.001;

        double X = num;
        double root; 
        double ans;

        while(true)
        {
            root = 0.5*(X + (num/X));
            ans = X - root;
            if(ans < tol)
            {
                break;
            }
            X = root;
        }
        return root;
 


    }
    
}
