class solution {
    static int evenlyDivides(int n) {
        int count=0;
        while(n>0)
        {
            int digit = n%10;
            count = count+1;
            if(n%digit==0)
            {
                return digit;
            }
            n=n/10;
            
            
            
            
            
            
            
            
        }
        return count;
    }
}