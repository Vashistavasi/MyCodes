// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])
    {


      
        {
           
            String[] dictionary = {"CAT","TIE"};
            int N = dictionary.length;
            
            
          
            char board[][] = {{'C','A','P'},{'A','N','D'},{'T','I','E'}};
      
            int m=board.length;
            int n=board[0].length;
            
            
            Solution obj = new Solution();
            String[] ans = obj.wordBoggle(board, dictionary);
            
            if(ans.length == 0) System.out.println("-1");
            else
            {
                Arrays.sort(ans);
                for(int i=0;i<ans.length;i++)
                {
                    System.out.print(ans[i] + " ");
                }
                System.out.println();
            }
            
         
        }
    }
}
// } Driver Code Ends
//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
 public static void main(String args[])
 {
     Scanner sc = new Scanner(System.in);
     int t = sc.nextInt();
     while(t>0)
     {
         int N = sc.nextInt();
         String[] dictionary = new String[N];
         for(int i=0;i<N;i++)
         {
             dictionary[i] = sc.next();
         }
         
         int R = Integer.parseInt(sc.next());
         int C = Integer.parseInt(sc.next());
         
         char board[][] = new char[R][C];
         for(int i=0;i<R;i++)
         {
             for(int j=0;j<C;j++)
             {
                 board[i][j] = sc.next().charAt(0);
             }
         }
         
         Solution obj = new Solution();
         String[] ans = obj.wordBoggle(board, dictionary);
         
         if(ans.length == 0) System.out.println("-1");
         else
         {
             Arrays.sort(ans);
             for(int i=0;i<ans.length;i++)
             {
                 System.out.print(ans[i] + " ");
             }
             System.out.println();
         }
         
         t--;
     }
 }
}
//} Driver Code Ends

class TrieNode{
	boolean flag;
	int size;
	TrieNode[] child;
	TrieNode(int size) {
		flag=false;
		this.size=size;
		child=new TrieNode[size];
		for(int i=0;i<size;i++) {
			child[i]=null;
		}
		
	}
	public String toString() {
		return " " + Arrays.toString(child)+" ";
	}
	public static void insert(TrieNode root,String s) {
	     boolean chcase=false;
     if(s.charAt(0)-'a'<0)
     chcase=true;
		int n=s.length();
		TrieNode curr=root;
		for(int i=0;i<n;i++) {
			int index=s.charAt(i)-'a';
			if(chcase)
			index=s.charAt(i)-'A';
			if(curr.child[index]==null)
				curr.child[index]=new TrieNode(26);
			curr=curr.child[index];
		}
		curr.flag=true;
	}
}

//User function Template for Java

class Solution
{
	
	public static boolean isSafe(TrieNode root,char board[][],int i,int j, boolean visited[][]) {
		return (i>=0&& j>=0 && i<board.length && j<board[0].length&& !visited[i][j]);
	}
	
	public static void searchWord(TrieNode root,char board[][], int i,int j,boolean visited[][], String s
	,ArrayList<String> al) {
	    boolean chcase=false;
     if(board[0][0]-'a'<0)
     chcase=true;
		if(root.flag==true && !al.contains(s)) {
			al.add(s);
		}
			
		
		if(isSafe(root,board,i,j,visited)) {
			visited[i][j]=true;
		  for(int k=0;k<26;k++) {
			  if(root.child[k]!=null) {
			      char c='1';
			      if(chcase)
				  c=(char)(k+'A');
				  else
				  c=(char)(k+'a');
				  int xdir[] ={-1,-1,-1,0,0,1,1,1};
				  int ydir[]= {-1,0,1,-1,1,-1,0,1};
				  for(int row=0;row<8;row++) {
					  {
						  
						  if(isSafe(root,board,i+xdir[row],j+ydir[row],visited) && board[i+xdir[row]][j+ydir[row]]==c ) {
							 s=s+c;
							 searchWord(root.child[k],board,i+xdir[row],j+ydir[row],visited,s,al);
						   s=s.substring(0,s.length()-1);
						  }
					  }
				  }
				  
			  }
			  
		  }
		  visited[i][j]=false; 
		}
		
	}
	
	
	
	
	
	
//	public static boolean found(String[]dictionary,String word) {
//		for(int i=0;i<dictionary.length;i++) {
//			if(word.equals(dictionary[i])) {
//				return true;
//			}
//		}
//		return false;
//	}
//	public static void dfs(char board[][], boolean visited[][],ArrayList<String> ans,int row,int column,int m,int n, String word,String []dictionary) {
//		
//		visited[row][column]=true;
//		word=word+board[row][column];
//		if(found(dictionary, word)) {
//			if(!ans.contains(word))
//			ans.add(word);
//			//System.out.println(word);
//		}
//		for(int i=row-1;i<=i+1&&i<m;i++) {
//			for(int j=column-1;j<=j+1&&j<n;j++) {
//				if(i>=0&&j>=0&&!visited[i][j]) {
//					dfs(board, visited, ans, i, j, m, n, word, dictionary);
//				}
//			}
//		}
//		word=word.substring(0,word.length()-1);
//		visited[row][column]=false;
//	
//	}
 public String[] wordBoggle(char board[][], String[] dictionary)
 {
     // Write your code here
     boolean chcase=false;
     if(board[0][0]-'a'<0)
     chcase=true;
     
    ArrayList<String> al=new ArrayList<String>();
 	String[] ans;
 	int m=board.length;
 	int n=board[0].length;
 	String word =new String();
 	TrieNode root=new TrieNode(26);
 	for(int i=0;i<dictionary.length;i++) {
 	 root.insert(root, dictionary[i]);
 	}
    boolean visited[][]=new boolean[m][n];
    for(int i=0;i<m;i++) {
 	   for(int j=0;j<n;j++) {
 	       int index=0;
 	       if(chcase)
 	        index=board[i][j]-'A';
 	        else 
 	        index=board[i][j]-'a';
 		   if(root.child[index]!=null) {
 			   word=word+board[i][j];
 		   searchWord(root.child[index],board,i,j,visited,word,al);
 		   }
 		   word="";
 	   }
    }
//    ArrayList<String> al=new ArrayList<String>();
//    dfs(board, visited, al, 0, 0, m, n, word, dictionary);
// 	
     if(al.size()==0)
     al.add("-1");
 	ans=al.toArray(new String[0]);
 	return ans;
 	
 }
}