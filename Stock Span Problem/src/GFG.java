//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int a[] = new int[n];
            
            int i = 0;
            for(i = 0; i < n; i++)
              a[i] = sc.nextInt();
              
            int[] s = new Solution().calculateSpan(a, n);
            
            for(i = 0; i < n; i++)
            {
                System.out.print(s[i] + " ");
            }
            
            System.out.println();
        }
    }
    
    
    
}
// } Driver Code Ends



class Solution
{
    //Function to calculate the span of stock’s price for all n days.
    public static int[] calculateSpan(int a[], int n)
    {
        // Your code here
        // int S[]=new int[n];
        //  S[0] = 1;
  
        // // Calculate span value of remaining days by linearly checking
        // // previous days
        // for (int i = 1; i < n; i++) {
        //     S[i] = 1; // Initialize span value
  
        //     // Traverse left while the next element on left is smaller
        //     // than price[i]
        //     for (int j = i - 1; (j >= 0) && (a[i] >= a[j]); j--)
        //         S[i]++;
        // }
        
        
        // return S;
        
        
        ArrayDeque<Integer> stack=new ArrayDeque<Integer>();
        
        stack.push(0);
        int ans[]=new int[n];
        
        ans[0]=1;
        
        for(int i=0;i<n;i++){
            
            while(!stack.isEmpty() && (a[i]>=a[stack.peek()]))
            stack.pop();
            
            if(stack.isEmpty())
            ans[i]=i+1;
            else
            ans[i]=i-stack.peek();
            
            stack.push(i);
            
            
            
        }
        
        
        
        return ans;
        
        
        
        
        
        
        
        
        
        
        // int ans[]=new int[n];
        
        // for(int i=0;i<n;i++){
        //     int value=Integer.MIN_VALUE;
        //     int count=0;
        //     for(int j=i;j>=0;j--){
                
        //         if(a[j]<=a[i]){
        //             //if(i==4) System.out.println(a[j]+" "+a[i]+" "+ count);
        //             count++;
        //         }
        //         else{
        //             break;
        //         }
        //         value=Math.max(count,value);
        //     }

        //     ans[i]=value;
        // }
        //     ans[0]=1;
        // return ans;
    }
    
}