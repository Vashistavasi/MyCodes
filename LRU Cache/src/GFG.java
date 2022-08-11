//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

  public class GFG {

    public static void main(String[] args) throws IOException {
//    	
//    	File file=new File("C:\\Users\\10683788\\Documents\\background\\fileInput (1).txt");
//    	File file2=new File("C:\\Users\\10683788\\Documents\\background\\file.txt");
//        BufferedReader read =
//            new BufferedReader(new FileReader(file2));
       
       
       
//       try {
        {
           // System.out.println("Inside while");
            //int capacity = Integer.parseInt(read.readLine().trim());
        	int capacity=2;
            //System.out.println(capacity);
            //System.out.println(read.readLine());
            //int queries = Integer.parseInt(read.readLine().trim());
            int queries=8;
           // System.out.println(queries);
            LRUCache cache = new LRUCache(capacity);
           //String  str[] = read.readLine().trim().split(" ");
             String str[]={"SET", "1",
                           "2", "SET", "2", "3", "SET", "1","5", "GET", "2", "SET", "3", "4",
                           "SET", "2", "4", "SET", "4", "5", "GET", "2"};
             
           //System.out.println(Arrays.toString(str));
            int len = str.length;
            int itr = 0;

            for (int i = 0; (i < queries) && (itr < len); i++) {
                String queryType = str[itr++];
                if (queryType.equals("SET")) {
                    int key = Integer.parseInt(str[itr++]);
                    int value = Integer.parseInt(str[itr++]);
                    cache.set(key, value);
                }
                if (queryType.equals("GET")) {
                    int key = Integer.parseInt(str[itr++]);
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
        }
 //   }
//       catch(Exception e) {
//       	e.printStackTrace();
//       }
       }
    
}

// } Driver Code Ends


// design the class in the most optimal way
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
