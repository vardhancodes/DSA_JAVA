import java.util.HashSet;
import java.util.Iterator;
public class Hashset {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(4);
        set.add(6);
        System.out.println(set);
        System.out.println(set.contains(4));
        set.remove(6);
        System.out.println(set);
        //Looping through for each
        for(Integer i : set)
        {
            System.out.println(i);
        }
        //Looping through iterator
        Iterator<Integer> itr = set.iterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next());
            itr.remove();

        }
    }

}

