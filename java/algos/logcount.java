class logcount{

    public static void main(String[] args) {
        
        logcounte(5454);
    }

    static void logcounte(int num){

        if(num ==0)
        {
            System.out.println("Digit is 1");
            return;
        }

        int count = (int)((int)Math.log(num)/Math.log(10))+1;
        System.out.println("Digits are: "+count);




    }
}