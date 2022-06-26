// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            long N = Long.parseLong(stt.nextToken());
            long M = Long.parseLong(stt.nextToken());
            long X = Long.parseLong(stt.nextToken());
            long A[] = new long[(int)(N)];
            long B[] = new long[(int)(M)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < N; i++) {
                A[i] = Long.parseLong(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < M; i++) {
                B[i] = Long.parseLong(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            pair [] answer = obj.allPairs(A, B, N, M, X);
            int sz = answer.length;
            
            if(sz==0)
            System.out.println(-1);
            else{
                StringBuilder output = new StringBuilder();
                for(int i=0;i<sz;i++){
                    if(i<sz-1)
                    output.append(answer[i].first +" "+ answer[i].second + ", ");
                    else
                    output.append(answer[i].first +" "+ answer[i].second);
                    
                }
                System.out.println(output);
            }
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java

/*
class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}
*/

class Solution {
    public pair[] allPairs( long A[], long B[], long N, long M, long X) {
        // Your code goes here
        
         ArrayList<pair> al=new ArrayList<>();
    	if(N>M) {
    		HashSet<Long> hs=new HashSet<>();
    		for(int i=0;i<N;i++) {
    			hs.add(A[i]);
    		}
    		for(int i=0;i<M;i++) {
    			long required=X-B[i];
    			if(hs.contains(required)) {
    				pair p=new pair(required, B[i]);
    				al.add(p);
    			}
    		}
    	}
    	else {
    		HashSet<Long> hs=new HashSet<>();
    		for(int i=0;i<M;i++) {
    			hs.add(B[i]);
    		}
    		for(int i=0;i<N;i++) {
    			long required=X-A[i];
    			if(hs.contains(required)) {
    				pair p=new pair( A[i],required);
    				al.add(p);
    			}
    		}
    	}
    	
    	    
    	    	Collections.sort(al,new Comparator<pair>() {

			@Override
			public int compare(pair o1, pair o2) {
				// TODO Auto-generated method stub
				
				return (int) (o1.first-o2.first);
			}
		});
    	    
    return	al.toArray(new pair[0]);
    	
    	
    	
    	
        
        
        
        
        
        
        
        
        
        
        
    }
}