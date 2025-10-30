import java.util.*;
public class hashmap{
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"Shashwat");
        map.put(2,"Ayush");
        map.put(3,"Gaurav");
        System.out.println(map);
        map.put(3,"Shashwat");
        System.out.println(map);
        System.out.println(map.get(3));
        System.out.println(map.containsKey(4));
        System.out.println(map.getOrDefault(5,"Not present"));
        for(Map.Entry<Integer,String> entry : map.entrySet())
        {
            System.out.println("Key->"+entry.getKey());
            System.out.println("Value->"+entry.getValue());
        }
        for(Integer key : map.keySet())
        {
            System.out.println("Key->"+key);
            System.out.println("Value->"+map.get(key));

        }
    }
}
