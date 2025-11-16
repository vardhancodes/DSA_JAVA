import java.util.ArrayList;
import java.util.List;

public class NQueensII {
    public static void main(String[] args) {
        int n = 4;
        List<List<String>> list = new ArrayList<List<String>>();
        List<List<String>> board = new ArrayList<List<String>>();
        for(int i = 0 ; i < n ; i++)
        {
            List<String> sublist = new ArrayList<String>();
            for(int j = 0 ; j < n ; j++)
            {
                sublist.add(".");
            }
            board.add(sublist);
        }
        recur(n,list,0,board);
        System.out.println(list.size());
    }

    public static boolean isPossible(List<List<String>> board,int n , int i , int j)
    {
        //horizontal check
        for(int col = 0 ; col < j ; col++)
        {
            if(board.get(i).get(col).equals("Q"))
            {
                return false;
            }
        }
        //upper diagnol
        for(int row = i-1 , col = j-1 ; row>=0 && col>=0 ; row-- , col--)
        {
            if(board.get(row).get(col).equals("Q"))
            {
                return false;
            }
        }
        //Lower Diagnol
        for(int row = i+1 , col = j-1 ; row<n && col>=0 ; row++ , col--)
        {
            if(board.get(row).get(col).equals("Q"))
            {
                return false;
            }
        }
        return true;

    }
    public static void recur(int n , List<List<String>> list ,int j, List<List<String>> board)
    {
        if(j >= n)
        {
            List<String> sublist = new ArrayList<String>();
            for(int i = 0 ; i < n ; i++)
            {
                String s = "";
                for(int col = 0 ; col < n ; col++)
                {
                    s = s + board.get(i).get(col);
                }
                sublist.add(s);
            }
            list.add(sublist);
            return;
        }

        for(int row = 0 ; row < n ; row++)
        {
            if(isPossible(board,n,row,j))
            {
                board.get(row).set(j,"Q");
                recur(n,list,j+1,board);
                board.get(row).set(j,".");

            }

        }
    }
}
