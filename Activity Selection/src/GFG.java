//{ Driver Code Starts
import java.io.*; 
import java.util.*; 
import java.lang.*;

class Main
{
    public static void main (String[] args) throws IOException  
    {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//testcases
		int t = Integer.parseInt(br.readLine().trim());
		
		while(t-- > 0)
		{
		    String inputLine[] = br.readLine().trim().split(" ");
		    //size of array
		    int n = Integer.parseInt(inputLine[0]);
		    int start[] = new int[n];
		    int end[] = new int[n];
		    
		    //adding elements to arrays start and end
		    inputLine = br.readLine().trim().split(" ");
		    for(int i = 0; i < n; i++)
		     start[i] = Integer.parseInt(inputLine[i]);
		    
		    inputLine = br.readLine().trim().split(" ");
		    for(int i= 0; i < n; i++)
		      end[i] = Integer.parseInt(inputLine[i]);
		    
		    //function call
		    System.out.println(new Solution().activitySelection(start, end, n));
		}
    }
}


// } Driver Code Ends

class WorkDay{
    int start;
    int end;
    WorkDay(int start,int end){
        this.start=start;
        this.end=end;
    }
    WorkDay(){
        
    }
    public String toString(){
        return this.start +" "+ this.end;
    }
}
class Solution
{
    //Function to find the maximum number of activities that can
    //be performed by a single person.
    
    public static int activitySelection(int start[], int end[], int n)
    {
        // add your code here
        WorkDay workDays[]=new WorkDay[n];
        for(int i=0;i<n;i++){
            workDays[i]=new WorkDay(start[i],end[i]);
        }
        Arrays.sort(workDays,new Comparator<WorkDay>(){
            public int compare(WorkDay w1, WorkDay w2){
                return w1.end-w2.end;
            }
        });
        //System.out.println(Arrays.toString(workDays));
        
        //int ans[]=new int[n];
        int res=0;
        int i=0;
        //for(int i=0;i<n;i++){
            ArrayDeque<Integer> stack=new ArrayDeque<Integer>();
            stack.push(workDays[i].end);
            for(int j=i+1;j<n;j++){
                if(workDays[j].start>stack.peek()){
                    stack.push(workDays[j].end);
                }
            }
            res=stack.size();
            //ans[]=stack.size();
       // }
        // int res=Integer.MIN_VALUE;
        // for(int i:ans)
        // res=Math.max(res,i);
        
        //System.out.println(Arrays.toString(workDays)+ "\n"+Arrays.toString(ans));
        return res ;
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}  