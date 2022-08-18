//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int pages[]= new int[N];
            for(int i = 0; i < N; i++)
                pages[i] = Integer.parseInt(input_line[i]);
            int C = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.pageFaults(N, C, pages));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class pair{
    int key;
    int value;
    pair(int key,int value){
        this.key=key;
        this.value=value;
    }
    pair(){
        
    }
    public String toString() {
    	return " " +this.key+" "+this.value;
    }
}
class LRUCache
{
    int cap;
    ArrayDeque<pair> que=new ArrayDeque<pair>();
    HashMap<Integer,pair> hm=new HashMap<Integer,pair>();
    //Constructor for initializing the cache capacity with the given value.
    LRUCache(int cap)
    {
        //code here
        this.cap=cap;
    }

    //Function to return value corresponding to the key.
    public  int get(int key)
    {
        // your code here
        if(!hm.containsKey(key))
        return -1;
        else{
        	pair temp=hm.get(key);
        	que.remove(temp);
        	que.add(temp);
    //    	Iterator<pair> it=que.iterator();
//           while(it.hasNext()) {
//        	   pair temp=it.next();
//        	   if(temp.key==key) {
//        		   que.remove(temp);
//        		   break;
//        	   }
//        		
//        	}
            
//            que.add(new pair(key,hm.get(key)));
            return temp.value;
        }
        
    }

    //Function for storing key-value pair.
    public  void set(int key, int value)
    {
        // your code here
    	if(que.size()<=cap) {
    		
    		if(que.size()==cap && !hm.containsKey(key)){
                pair removed=que.removeFirst();
                hm.remove(removed.key);
                 pair temp=new pair(key,value);
                 
                hm.put(key,temp);
                que.add(temp);
            
            }
          else if(hm.containsKey(key)){
//        	  Iterator<pair> it=que.iterator();
//              while(it.hasNext()) {
//           	   pair temp=it.next();
//           	   if(temp.key==key) {
//           		   que.remove(temp);
//           		   break;
//           	   }
//           		
//           	}
          	pair temp=hm.get(key);
          	que.remove(temp);
          	temp.value=value;
          	que.add(temp);
//                 pair temp=new pair(key,value);
//                hm.put(key,value);
//                que.add(temp);
            }
            else{
                pair temp=new pair(key,value);
                hm.put(key,temp);
                que.add(temp);
            }
	
    	}
    	else {
    		System.out.println("Here");
    	}
                   
    }
}
class Solution{
    static int pageFaults(int N, int C, int pages[]){
        // code here
    	LRUCache lru=new LRUCache(C);
    	int count=0;
    	for(int i=0;i<N;i++) {
    		if(lru.get(pages[i])==-1) {
    			count++;
    			lru.set(pages[i], pages[i]);
    		}
    		else {
    			lru.get(pages[i]);
    		}
    	}
    	return count;
    }
}