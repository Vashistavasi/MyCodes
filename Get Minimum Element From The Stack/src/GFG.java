//{ Driver Code Starts
import java.util.*;



class Get_Min_From_Stack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			GfG g = new GfG();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
					//System.out.println(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		}
		
	}
}



// } Driver Code Ends


class GfG
{
    int minEle=Integer.MAX_VALUE;
    Stack<Integer> s=new Stack<Integer> ();
    HashMap<Integer,Integer>hm=new HashMap<Integer,Integer> ();

    /*returns min element from stack*/
    int getMin()
    {
	// Your code here
	if( minEle!=Integer.MAX_VALUE && hm.get(minEle)>0 ){
	return minEle;    
	}
	else if(hm.containsKey(minEle) && hm.get(minEle)==0){
	     Stack<Integer> q=new Stack<Integer> ();
	    while(!s.isEmpty())
	    {
	        int num=s.pop();
	      //  System.out.println(num+ " wa");
	        minEle=Math.min(minEle,num);
	        q.push(num);
	    }
	    s=q;
	   return minEle;
	}
	
	else
	return -1;
    }
    
    /*returns poped element from stack*/
    int pop()
    {
	// Your code here	
	if(s.size()==0)
	return -1;
	int ans=s.pop();
	hm.put(ans,hm.get(ans)-1);
	if(ans==minEle){
	    minEle=Integer.MAX_VALUE;
	    Stack<Integer> q=new Stack<Integer> ();
	    while(!s.isEmpty())
	    {
	        int num=s.pop();
	      //  System.out.println(num+ " wa");
	        minEle=Math.min(minEle,num);
	        q.push(num);
	    }
	    while(!q.isEmpty()){
	        s.push(q.pop());
	    }
	   // System.out.println(minEle);
	    
	}
	     return ans;
	
    }

    /*push element x into the stack*/
    void push(int x)
    {
	// Your code here
	if(!hm.containsKey(x))
	hm.put(x,1);
	else
	hm.put(x,hm.get(x)+1);
	if(x<minEle)
	minEle=x;
	//System.out.println(minEle);
	s.push(x);
    }	
}

