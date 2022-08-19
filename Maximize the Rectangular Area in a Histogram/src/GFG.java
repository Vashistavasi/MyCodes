//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
	public static ArrayList<int[] > consecutives(long hist[]){
		ArrayList<int[]>al=new ArrayList<int[]>();
		int size=hist.length;
		int left[]=new int[size];
		int right[]=new int[size];
		 for (int i = 0; i < size; i++){
	            left[i] = -1;
	            right[i] = size;
	        }
		int i=0;
		ArrayDeque<Integer>stack=new ArrayDeque<Integer>();
		stack.push(-1);
		while(i<size) {
			while(!stack.isEmpty()&& stack.peek()!=-1 && hist[i]<hist[stack.peek()]) {
				right[stack.peek()]=i;
				stack.pop();
			}
			if(i>0&&hist[i]==hist[i-1]) {
				left[i]=left[i-1];
			}
			else {
				left[i]=stack.peek();
			}
			stack.push(i);
			i++;
		}
		al.add(left);
		al.add(right);
		return al;
	}
    public static long consecutives(long hist[],int index){
        long count=1l;
        int temp=index;
        long pivot=hist[index--];
        while(index>=0 && hist[index]>=pivot){
            count++;
            index--;
        }
        temp++;
        while(temp<hist.length && hist[temp]>=pivot){
            temp++;
            count++;
        }
        return count;
    }
    public static long getMaxArea(long hist[], long n) 
    {
        // your code here
        long ans=Long.MIN_VALUE;
        ArrayList<int[]> al=consecutives(hist);
        int[]left=al.get(0);
        int[]right=al.get(1);
        for(int i=0;i<n;i++){
            ans=Math.max(ans,hist[i]*(right[i]-left[i]-1));
            ans=Math.max(ans, hist[i]);
        } 	
        return ans;
    }
        
}



