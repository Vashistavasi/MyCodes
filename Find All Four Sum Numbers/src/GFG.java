//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required
class pair{
    int first;
    int second;
    int sum;
    pair(int first,int second,int sum){
        this.first=first;
        this.second=second;
        this.sum=sum;
    }
    pair(){
        
    }
    public String toString(){
        return " "+ this.sum +" "+this.first+" "+this.second;
    }
}
// class cmap{
//     int sum;
//     ArrayList<pair> possible;
//     cmap(ArrayList<pair>possible){
//         this.possible=possible;
//     }
// }
class Solution {
    public static boolean unique(pair p1, pair p2){
        if(p1.first==p2.first||p1.first==p2.second||p1.second==p2.first||p1.second==p2.second)
        return false;
        else
        return true;
    }
    public ArrayList<ArrayList<Integer>> fourSum(int[] A, int X) {
        // code here


	
		int l, r;
        int n=A.length;
		Arrays.sort(A);
  HashSet<ArrayList<Integer>> hs=new HashSet<ArrayList<Integer>>();
   ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n - 3; i++)
		{
			for (int j = i + 1; j < n - 2; j++)
			{
				l = j + 1;
				r = n - 1;

				while (l < r)
				{
					if (A[i] + A[j] + A[l] + A[r] == X)
					{
						     ArrayList<Integer> al= new ArrayList<Integer> ();
                    al.add(A[i]);
                    al.add(A[j]);
                    al.add(A[l]);
                    al.add(A[r]);
                    Collections.sort(al);
                    if(!hs.contains(al)){
                      ans.add(al);
                      hs.add(al);
                    }
						//System.out.println(A[i]+" "+A[j]+" "+A[l]+" "+A[r]);
						l++;
						r--;
					}
					else if (A[i] + A[j] + A[l] + A[r] < X)
						l++;
					else 
						r--;
				} 
			}
		} 

        Collections.sort(ans,new Comparator<ArrayList<Integer>>(){
            public int compare(ArrayList<Integer> a,ArrayList<Integer> b){
                int diff1=a.get(0)-b.get(0);
                if(diff1!=0)
                return diff1;
                int diff2=a.get(1)-b.get(1);
                if(diff2!=0)
                return diff2;
                int diff3=a.get(2)-b.get(2);
                if(diff3!=0)
                return diff3;
                int diff4=a.get(3)-b.get(3);
                return diff4;
            }
        });
        return ans;

     

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    //      ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
    //     int len=arr.length;
    //     int size=len*(len-1)/2;
    //   pair sum[]=new pair[size];
    //   // ArrayList<cmap> possiblePairsList=new ArrayList<cmap>();
    //   int g=0;
    //   for(int i=0;i<len;i++)
    //   {
    //       for(int j=i+1;j<len;j++){
    //           {
    //             //   if(arr[i]+arr[j]<=k)
    //             //   {
    //             //       if(possiblePairsList)
    //             //       possiblePairsList.add(possible.add(new pair(i,j,arr[i]+arr[j])));
    //             //   }
    //               sum[g++]=new pair(i,j,arr[i]+arr[j]);
    //           }
    //       }
    //   }
    //     // Arrays.sort(sum,new Comparator<pair>(){
    //     //     public int compare(pair p1,pair p2){
    //     //         return p1.sum-p2.sum;
    //     //     }
    //     // });
    //     HashSet<ArrayList<Integer>> hs=new HashSet<ArrayList<Integer>>();
    //     for(int i=0;i<size;i++){
    //         for(int l=size-1;l>=0;l--){
    //                       if(l!=i && sum[i].sum+sum[l].sum==k && unique(sum[i],sum[l])){
    //             //ArrayList<pair> bl=possiblePairsList[k-sum[i].sum].possible;
    //           // System.out.println(sum[i].first + " " + sum[i].second +" "+sum[i].sum +" "+bl.toString());
    //             //for(int j=0;j<bl.size();j++){
    //               //  if(unique(sum[i],bl.get(j))){
    //                      ArrayList<Integer> al= new ArrayList<Integer> ();
    //                 al.add(arr[sum[i].first]);
    //                 al.add(arr[sum[i].second]);
    //                 al.add(arr[sum[l].first]);
    //                 al.add(arr[sum[l].second]);
    //                 Collections.sort(al);
    //                 if(!hs.contains(al)){
    //                   ans.add(al);
    //                   hs.add(al);
    //                 }
    //             //}
    //         //}  
    //         }

    //     }
     

    //      }
    //     // while(i<len&& j>0){
    //     // {
                
    //     //         if(sum[i].sum+sum[j].sum==k && unique(sum[i],sum[j])){
        
    //     //             for(int f=0;f<len;f++){
    //     //                 if(sum[f].sum==sum[j].sum && unique(sum[i],sum[f]) ){
    //     //             al.add(sum[i].first);
    //     //             al.add(sum[i].second);
    //     //             al.add(sum[j].first);
    //     //             al.add(sum[j].second);
    //     //             Collections.sort(al);
    //     //             if(!ans.contains(al))
    //     //             ans.add(al);
    //     //                 }
    //     //             }
    //     //             i++;
    //     //         }
    //     //         else if(sum[i].sum+sum[j].sum<k)
    //     //         i++;
    //     //         else
    //     //         j--;
    //     //     }
    //     // }
        
   
    }
}