//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    
		    int arr[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    arr[i]=sc.nextInt();
		    
		    int k=sc.nextInt();
		    Solution ob = new Solution();
		    out.println(ob.kthSmallest(arr, 0, n-1, k));
		}
		out.flush();
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	//{ Driver Code Starts
	//Initial Template for Java

	/*package whatever //do not write package name here */

	import java.io.*;
	import java.util.*;
	class GFG {
		public static void main (String[] args) {
			Scanner sc=new Scanner(System.in);
			PrintWriter out = new PrintWriter(System.out);
			int t=sc.nextInt();
			
			while(t-->0)
			{
			    int n=sc.nextInt();
			    
			    int arr[]=new int[n];
			    
			    for(int i=0;i<n;i++)
			    arr[i]=sc.nextInt();
			    
			    int k=sc.nextInt();
			    Solution ob = new Solution();
			    out.println(ob.kthSmallest(arr, 0, n-1, k));
			}
			out.flush();
		}
	}

	// } Driver Code Ends


	//User function Template for Java

	class Solution{
	    int kthSmallest(int arr[], int l, int r, int k)
	    {
	      
	        if (k > 0 && k <= r - l + 1)
	        {
	         
	            int pos = randomPartition(arr, l, r);
	 
	            if (pos-l == k-1)
	                return arr[pos];
	                if (pos-l > k-1)
	                return kthSmallest(arr, l, pos-1, k);
	 
	            
	            return kthSmallest(arr, pos+1, r, k-pos+l-1);
	        }
	 
	 
	        return Integer.MAX_VALUE;
	    }
	 

	    void swap(int arr[], int i, int j)
	    {
	        int temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	    }
	 
	  
	    int partition(int arr[], int l, int r)
	    {
	        int x = arr[r], i = l;
	        for (int j = l; j < r; j++)
	        {
	            if (arr[j] <= x)
	            {
	                swap(arr, i, j);
	                i++;
	            }
	        }
	        swap(arr, i, r);
	        return i;
	    }

	    int randomPartition(int arr[], int l, int r)
	    {
	        int n = r - l + 1;
	        int pivot = (int)(Math.random() * (n - 1));
	        swap(arr, l + pivot, r);
	        return partition(arr, l, r);
	    }
//	     	public static void swap(int a,int b)
//	 	{
//	 		int temp=a;
//	 		a=b;
//	 		b=temp;
//	 	}
//	 	public static int partition(int A[], int l, int r) 
//	 	{ 
//	 	    int x = A[r];
//	 	    int i = l-1;
//	 	    for ( int j = l ;j<r;j++) 
//	 	    { 
//	 	        if (A[j] <= x) 
//	 	        { 
//	 	            i = i + 1;
//	 	            swap(A[i], A[j]);
//	 	        } 
//	 	    } 
//	 	    swap(A[i+1], A[r]);
//	 	    return i+1;
//	 	}
		
//	     public static int kthSmallest(int[] A, int left, int right, int K) 
//	     { 
	    	
//	     	 if (left == right)
//	              return A[left];
//	         int pos = partition(A, left, right);
//	       int count = pos - left + 1;
//	         if ( count == K )
//	              return A[pos];
//	         else if ( count > K )      
//	              return kthSmallest(A, left, pos-1, K);
//	         else                 
//	              return kthSmallest(A, pos+1, right, K)  ;
	    // public static int kthSmallest(int[] a, int l, int r, int k) 
	    // { 
	        
	    //   PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Comparator.reverseOrder());
	    // 	int size=a.length;
	    // 	for(int i=0;i<size;i++) {
	    // 			pq.add(a[i]);
	    // 			if(pq.size()>k)
	    // 			pq.poll();
	    // 	}
	    // 	//Arrays.sort(a);
	    // 	//System.out.println(Arrays.toString(a));
	    // 	return pq.peek();
	    	
	        
	        
	        
	        
	        
	        
	        //Your code here
	//  Set<Integer> s = new TreeSet<Integer>();
	       

//	         for(int i=0;i<a.length;i++)
//	           s.add(a[i]);
	         

//	         Iterator<Integer> itr = s.iterator();
	       
//	         while(k>1)
//	         {
//	           itr.next();
//	           k--;
//	         }
//	         return itr.next();
	    //         int count=0;
	    //         int ans=0;
	    //         int min=Integer.MAX_VALUE;
	    //     int n=a.length;
	    //   int j=0;
	      
	    //     for(int i=0;i<a.length;i++){
	    //     if(a[i]<min){
	    //                     j=0;
	    //         for(j=0;j<a.length;j++){
	    //             if(a[i]>a[j]){
	    //                 count++;
	    //             }
	                
	    //         }
	    //         if(count>k-1){
	    //             min=Math.min(min,a[i]);
	    //         }
	    //         if(j==a.length && count==k-1)
	    //         {
	    //             ans=a[i];
	    //             break;
	    //         }
	    //         count=0; 
	    //     }

	    //     }
	        
	        // return ans;
	   // } 
	}

//	static int findMedian(int arr[], int i,int n)
//	{
//	        Arrays.sort(arr, i, n);
//	        return arr[i+(n-i)/2];                   
//	}
//	 
//
//	static int kthSmallest(int arr[], int l, int r, int k)
//	{
//	  
//	    if (k > 0 && k <= r - l + 1)
//	    {
//	        int n = r - l + 1 ; 
//	        int i;
//	         
//
//	        int []median = new int[(n + 4) / 5];
//	        for (i = 0; i < n/5; i++)
//	            median[i] = findMedian(arr, l+i*5, l+i*5+5);
//	             
//	     
//	        if (i*5 < n)
//	        {
//	            median[i] = findMedian(arr, l+i*5, l+i*5+n%5);
//	            i++;
//	        }
//	 
//	      
//	        int medOfMed = (i == 1)? median[i - 1]:
//	                                kthSmallest(median, 0, i - 1, i / 2);
//	 
//	     
//	        int pos = partition(arr, l, r, medOfMed);
//	 
//	      
//	        if (pos-l == k - 1)
//	            return arr[pos];
//	        if (pos-l > k - 1) 
//	            return kthSmallest(arr, l, pos - 1, k);
//	 
//
//	        return kthSmallest(arr, pos + 1, r, k - pos + l - 1);
//	    }
//	 
//	    
//	    return Integer.MAX_VALUE;
//	}
//	 
//	static int[] swap(int []arr, int i, int j)
//	{
//	    int temp = arr[i];
//	    arr[i] = arr[j];
//	    arr[j] = temp;
//	    return arr;
//	}
//	 
//
//	static int partition(int arr[], int l,
//	                        int r, int x)
//	{
//	   
//	    int i;
//	    for (i = l; i < r; i++)
//	        if (arr[i] == x)
//	        break;
//	    swap(arr, i, r);
//	 
//	    
//	    i = l;
//	    for (int j = l; j <= r - 1; j++)
//	    {
//	        if (arr[j] <= x)
//	        {
//	            swap(arr, i, j);
//	            i++;
//	        }
//	    }
//	    swap(arr, i, r);
//	    return i;
//	}
//	public static void swap(int a,int b)
//	{
//		int temp=a;
//		a=b;
//		b=temp;
//	}
//	public static int partition(int A[], int l, int r) 
//	{ 
//	    int x = A[r];
//	    int i = l-1;
//	    for ( int j = l ;j<r;j++) 
//	    { 
//	        if (A[j] <= x) 
//	        { 
//	            i = i + 1;
//	            swap(A[i], A[j]);
//	        } 
//	    } 
//	    swap(A[i+1], A[r]);
//	    return i+1;
//	}
//	
//    public static int kthSmallest(int[] A, int left, int right, int K) 
//    { 
//    	
//    	 if (left == right)
//             return A[left];
//        int pos = partition(A, left, right);
//       int count = pos - left + 1;
//        if ( count == K )
//             return A[pos];
//        else if ( count > K )      
//             return kthSmallest(A, left, pos-1, K);
//        else                 
//             return kthSmallest(A, pos+1, right, K)  ;
//    	
//    	
//    	
//    	
//    	
//    	
//    	
//    	
//    	
//    	
//    	
//    	
//    	
//    	
////    	PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Comparator.reverseOrder());
////    	int size=a.length;
////    	for(int i=0;i<k;i++)
////    		pq.add(a[i]);
////    	for(int i=k;i<size;i++) {
////    		if(a[i]<pq.peek())
////    			pq.add(a[i]);
////    	}
////    	return pq.peek();
//    	
//    	
//        //Your code here
//        // int i=k-1;
//            //int j=0;
////            int count=0;
////            int ans=0;
////            int min=Integer.MAX_VALUE;
//            // do{
//            //     count=0;
//            //   for(j=0;j<a.length;j++){
//            //     if(a[i]>a[j]){
//            //         count++;
//            //     }
//                
//            // }
//            //  if(count==k-1){
//            //      ans=a[i];
//            //      break;
//            //  }
//            //  if(count>k-1)
//            //  max=Math.max(max,a[i]);
//            // int temp=a[i];
//            // a[i]=a[count];
//            // a[count]=temp;
//            // }while(count!=k-1);
//    
////        int n=a.length;
////       int j=0;
////      
////        for(int i=0;i<a.length;i++){
////        if(a[i]<min){
////                        j=0;
////            for(j=0;j<a.length;j++){
////                
////                if(a[i]>a[j]){
////                    count++;
////                    // if(count>k-1 )
////                    // break;
////                }
////                
////            }
////            if(count>k-1){
////                min=Math.min(min,a[i]);
////            }
////            if(j==a.length && count==k-1)
////            {
////                ans=a[i];
////                break;
////            }
////            count=0; 
////        }
//
////        }
//        
//        
//        // else{
//        //     max=a[0];
//        //     for(int i=0;i<a.length;i++){
//        //       if(a[i]<=max){
//        //           int j=0;
//        //     for(j=0;j<a.length;j++){
//                
//        //         if(a[i]<a[j]){
//        //             count++;
//        //             // if(count>n-k )
//        //             // break;
//        //         }
//                
//        //     }
//        //                  if(count>k-1)
//        //      max=Math.max(max,a[i]);
//        //     if(j==a.length && count==n-k)
//        //     {
//        //         ans=a[i];
//        //         break;
//        //     }
//        //     count=0;  
//        //       }
//           
//        // }
//        
//        // }
//        // Arrays.sort(a);
//        // System.out.println(Arrays.toString(a));
////        return ans;
//    } 
}
