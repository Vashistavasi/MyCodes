//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;


class GFG
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        int n;
        while(t-- > 0){
            n = sc.nextInt();
    
            Solution obj = new Solution();
            for(int i = 1; i <= n; i++)
            {
                int x =sc.nextInt();
                obj.insertHeap(x);
                System.out.println((int)Math.floor(obj.getMedian()));
            }
        }
        
        
    }
}


// } Driver Code Ends


class Solution
{
    //Function to insert heap.
  	PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>();
	PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(Comparator.reverseOrder());
    public  void insertHeap(int x)
    {
        // add your code here
    	if(!minHeap.isEmpty()&& x<minHeap.peek()) {
    		maxHeap.add(x);
    		balanceHeaps();
    	}
    
    	else {
    		minHeap.add(x);
    	    balanceHeaps();
    	}
    }
    
    //Function to balance heaps.
    public  void balanceHeaps()
    {
       // add your code here
       	if(minHeap.size()>maxHeap.size()+1) {
    			maxHeap.add(minHeap.poll());
    			return;
    		}
        if(maxHeap.size()>minHeap.size()+1) {
    		minHeap.add(maxHeap.poll());
    		return;
    	}
    }
    
    //Function to return Median.
    public  double getMedian()
    {
        // add your code here
    	double median;
    	if(minHeap.size()>maxHeap.size())
    		median=(double)minHeap.peek();
    	else if(maxHeap.size()>minHeap.size())
    		median=(double)maxHeap.peek();
    	else
    		median=((double)minHeap.peek()+(double)maxHeap.peek())/2;
    	
    	return median;
    	
    }
    
}