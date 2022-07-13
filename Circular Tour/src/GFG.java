// { Driver Code Starts
import java.util.*;


class First_Circular_tour
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();
			String arr[] = str.split(" ");
			int p[] = new int[n];
			int d[] = new int[n];
			int j=0;
			int k=0;
			for(int i=0; i<2*n; i++)
			{
				if(i%2 == 0)
				{
					p[j]= Integer.parseInt(arr[i]);
					j++;
				}
				else
				{
					d[k] = Integer.parseInt(arr[i]);
					k++;
				}
			}
			
			System.out.println(new Solution().tour(p,d));
		t--;
		}
	}
}// } Driver Code Ends


// In java function tour() takes two arguments array of petrol
// and array of distance

class Solution
{
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
    int tour(int petrol[], int distance[])
    {
	// Your code here	
	int dumsum=0;
	int dumdis=0;
	for(int i:petrol)
	dumsum+=i;
	for(int i:distance)
	dumdis+=i;
	if(dumsum<dumdis)
	return -1;
	int start=0;
    	int end=distance.length;
    	int []fuel=new int[end];
    	int []dis=new int[end];
    	while(start<end) {
    		boolean flag=false;
    		fuel[0]=petrol[start%end];
    		dis[0]=distance[start%end];
    		for(int i=1;i<end;i++) {
    			fuel[i]=petrol[(i+start)%end]+fuel[i-1];
    			dis[i]=distance[(i+start)%end]+dis[i-1];
    			if(fuel[i]<dis[i])
    			{
    				
    				break;
    			}
    		}
    		
    	//	System.out.println(Arrays.toString(fuel));
    	//	System.out.println(Arrays.toString(dis));
    		for(int i=0;i<end;i++) {
    			if(fuel[i]>=dis[i])
    				continue;
    			else
    			{
    				flag=true;
    				break;
    			}
    			
    		}
    		
    		if(!flag)
    			return start;
    			start++;
    		
    	}
    	return -1;
    }
}