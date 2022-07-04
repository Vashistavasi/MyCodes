// { Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();//total testcases
        while (T-- > 0) {
            Hanoi obj = new Hanoi();
            int N;
            
            //taking input N
            N = sc.nextInt();

            //calling toh() method 
            System.out.println(obj.toh(N, 1, 3, 2));
        }
    }
}





// } Driver Code Ends


// User function Template for Java


// avoid space at the starting of the string in "move disk....."
class Hanoi {
   public  static long towerOfHanoi(int n, int from_rod,
                    int to_rod, int aux_rod,ArrayList<String> al)
{
    if (n == 0)
    {
        return 0l;
    }
    towerOfHanoi(n - 1, from_rod, aux_rod, to_rod,al);
    al.add("move disk "+ n + " from rod " +
                       from_rod +" to rod " + to_rod );
                       
        System.out.println("move disk "+ n + " from rod " +
                       from_rod +" to rod " + to_rod );
                       
    towerOfHanoi(n - 1, aux_rod, to_rod, from_rod,al);
    return 1l;
}

    public long toh(int N, int from, int to, int aux) {
        // Your code here
        ArrayList<String> al=new ArrayList<String>();
      long l=0l;
        l+=towerOfHanoi(N,from,to,aux,al);
        return al.size();
    }
}
