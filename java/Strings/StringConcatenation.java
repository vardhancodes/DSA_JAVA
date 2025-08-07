public class StringConcatenation {
    public static void main(String[] args) {
        System.out.println( 87+98.99+ "Try" );
    
    //string formatting 


    double num = 68.7878787;
    //.8 for 8 decimal places and ',' will be used instead of '+'
    System.out.printf("Number is %.8f",num);
    //.1 for 1 decimal place
    System.out.printf("Number is %.1f",num);    
    String name = "Number";
    System.out.printf("my %s",name);

    }

}
