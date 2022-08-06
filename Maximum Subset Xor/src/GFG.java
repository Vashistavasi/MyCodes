//{ Driver Code Starts
import java.util.*;
class XOR
{	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0)
		{
		  int n = sc.nextInt();
		  int[] a = new int[100004];
			for(int i=0;i<n;i++)
				a[i]=sc.nextInt();
		  Solution g = new Solution();
		  System.out.println(g.maxSubarrayXOR(a , n));
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/

class Solution
{
    public static int maxSubarrayXOR(int arr[], int N)
    {
        //add code here.
        int intSize=32;
        int index=0;
        for(int i=31;i>-1;i--){
            int maxInd=index;
            int maxEle=Integer.MIN_VALUE;
            for(int j=index;j<N;j++){
                if((arr[j]&(1<<i))!=0 && arr[j]>maxEle){
                 maxEle=arr[j];
                 maxInd=j;
                    
                }
                
            }
            if(maxEle== Integer.MIN_VALUE)
            continue;
            
            int temp=arr[index];
            arr[index]=arr[maxInd];
            arr[maxInd]=temp;
            maxInd=index;
            for(int j=0;j<N;j++){
                if(j!=maxInd && (arr[j]&(1<<i))!=0){
                    arr[j]=arr[j]^arr[maxInd];
                }
            }
            index++;
        }
        int res=0;
        for(int i=0;i<N;i++){
          res^=arr[i];  
        }
        return res;
    }
}