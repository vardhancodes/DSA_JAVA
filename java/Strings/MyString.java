


public class MyString {
    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        // System.out.println("Enter a line: ");
        // String line = in.nextLine();
        // System.out.println(line);

        //Lowercase function:
        String name = "Hello";
        String name1 = name.toLowerCase();
        System.out.println(name1);
        
        //Uppercase function:
        String name2 = name.toUpperCase();
        System.out.println(name2);

        //Iteration: 
        System.out.println(name.charAt(3));

        //Return Index: 
        System.out.println(name.indexOf('H'));

        //Last Index:
        System.out.println(name.lastIndexOf('l'));

        //Length:
        System.out.println(name.length());

        //Convert to character array:

        char[] ch = name.toCharArray();
        for (int i = 0; i < ch.length ; i++) {
            System.out.println(ch[i]+" ");
            
        }

        //Comparing string:

        System.out.println("Shashwat".compareTo("Shash"));
        System.out.println("SHASH".compareTo("WASH"));

        //To remove spaces:

        String str = "      ddfd  ";
        System.out.println(str.trim());

        //prefix checker:
        System.out.println(name.startsWith("He"));

        //suffix checker:
        System.out.println(name.endsWith("lo"));
        
        //substring function:
        System.out.println("shashwat".substring(3));

        //Convert to string array:

        String myLocations = "Hyderabad,Pune,Delhi,Mumbai";
        String[] locations = myLocations.split(",");

        for(int i = 0; i < locations.length ; i++) {

            System.out.print(locations[i] + " "); 
        }

    //StringBuilder and StringBuffer:
    // Are mutable. They allow modifications to the same object in memory, rather than creating new ones. 
    //This makes them significantly faster for operations that involve frequent appending, deleting, or inserting characters. StringBuilder is particularly recommended for competitive coding due to its speed.
    //Key Difference (Synchronization):
    // ▪ StringBuffer: Is synchronized. This means it is thread-safe; in a multi-threaded environment, only one thread can access and modify the StringBuffer object at a time, preventing data corruption. However, this synchronization adds overhead, making it slightly slower.
    // ▪ StringBuilder: Is non-synchronized. It is not thread-safe, meaning multiple threads can access and modify it concurrently, which can lead to unpredictable results in a multi-threaded scenario. However, because it lacks synchronization overhead, it is generally faster than StringBuffer in single-threaded environments.






    }

}
