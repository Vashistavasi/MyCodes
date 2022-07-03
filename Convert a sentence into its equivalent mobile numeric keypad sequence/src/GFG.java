// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String S = read.readLine();
            Solution obj = new Solution();
            System.out.println(obj.printSequence(S));
            
        }
    } 
} // } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    String printSequence(String S) 
    { 
        // code here
          HashMap<Character,String>hm=new HashMap<Character,String>();
          hm.put(' ',"0");
        hm.put('a',"2");
        hm.put('b',"22");
        hm.put('c',"222");
        hm.put('d',"3");
        hm.put('e',"33");
        hm.put('f',"333");hm.put('g',"4");hm.put('h',"44");hm.put('i',"444");hm.put('j',"5");
        hm.put('k',"55");hm.put('l',"555");hm.put('m',"6");hm.put('n',"66");hm.put('o',"666");
        hm.put('t',"8");hm.put('s',"7777");hm.put('r',"777");hm.put('q',"77");hm.put('p',"7");
        hm.put('u',"88");hm.put('v',"888");hm.put('w',"9");hm.put('x',"99");hm.put('y',"999");
        hm.put('z',"9999");
        char[]c=S.toLowerCase().toCharArray();
        StringBuffer sb=new StringBuffer();
        for(char ch:c){
            sb.append(hm.get(ch));
        }
        return new String(sb);
    }
}