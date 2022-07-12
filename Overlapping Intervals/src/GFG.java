// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[][] Intervals = new int[n][2];
            int j = 0;
            for(int i = 0; i < n; i++){
                Intervals[i][0] = Integer.parseInt(s[j]);
                j++;
                Intervals[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            int[][] ans = obj.overlappedInterval(Intervals);
            for(int i = 0; i < ans.length; i++){
                for(j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Schedule{
	int start;
	int end;
	public Schedule(int start,int end) {
		// TODO Auto-generated constructor stub
		this.start=start;
		this.end=end;
	}
}

class Solution
{
    public int[][] overlappedInterval(int[][] Intervals)
    {
        // Code here // Code here
    	Schedule inter[]=new Schedule[Intervals.length];
    for(int i=0;i<Intervals.length;i++) {
    	inter[i]=new Schedule(Intervals[i][0],Intervals[i][1]);
    }
    Arrays.sort(inter,new Comparator<Schedule>() {

		@Override
		public int compare(Schedule o1, Schedule o2) {
			// TODO Auto-generated method stub
			return o1.start-o2.start;
		}
	});
    ArrayDeque<Schedule> stack=new ArrayDeque<Schedule>();
     stack.push(inter[0]);
    for(int i=1;i<inter.length;i++) {
    	
    	if(stack.peek().end<inter[i].start) {
    		stack.push(inter[i]);
    	}
    	else if(stack.peek().end<inter[i].end) {
    		Schedule s=stack.pop();
    		s.end=inter[i].end;
    		stack.push(s);
    	}
    }
    int ans[][]=new int [stack.size()][2];
    
    Schedule sch[]=new Schedule[stack.size()];
    int siz=stack.size();
 for(int i=0;i<siz;i++){
     
     sch[i]=stack.pop();
 }    
       Arrays.sort(sch,new Comparator<Schedule>() {

		@Override
		public int compare(Schedule o1, Schedule o2) {
			// TODO Auto-generated method stub
			return o1.start-o2.start;
		}
	});
    for(int i=0;i<siz;i++) {
	   Schedule top=sch[i];
    	ans[i][0]=top.start;
    	ans[i][1]=top.end;
    	
    }
    return ans;
	
    }
}