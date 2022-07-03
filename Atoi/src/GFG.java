// { Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			System.out.println(obj.atoi(str));
		t--;
		}
	}
}// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String str) {
	// Your code here
	boolean flag=false;
	char[]c=str.toCharArray();
// 	int a='9';
// 	System.out.println(a);
	for(int i=0;i<c.length;i++){
	    if(c[i]=='-'&&i==0)
	    continue;
	    if(c[i]<48 || c[i]>57 )
	    flag=true;
	}
	if(flag)
	return -1;
	else{
	    if(c[0]=='-'){
	      int ans=Integer.parseInt(str);
	      
	    
	      return -1+ans+1;
	    }

else
return Integer.parseInt(str);
	}
   
    }
}
