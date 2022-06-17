import java.util.ArrayList;
import java.util.Arrays;

public class Candies {
	public static void main(String[] args) {
		ArrayList <Integer> al= new ArrayList<>();
		al.add(1);
		al.add(5);
		al.add(2);
		al.add(1);
	  System.out.println(candy(al));
	}
	
	
	
	
	    public static int candy(ArrayList<Integer> A) {
	        int n=A.size();
	        int[] candies=new int[n];
	        Arrays.fill(candies,1);
	        for(int i=0;i<n-1;i++){
	            if(A.get(i+1)>A.get(i))
	                candies[i+1]=candies[i]+1;
	        }
	        for(int i: candies)
	        	System.out.print(" "+i+" ");
	        System.out.println();
	        for(int i=n-1;i>0;i--){
	            if(A.get(i-1)>A.get(i) && candies[i-1]<=candies[i])
	                candies[i-1]=candies[i]+1;
	        }
	        for(int i: candies)
	        	System.out.print(" "+i+" ");
	        System.out.println();
	        int sum=0;
	        for(int i=0;i<n;i++){
	            sum+=candies[i];
	        }
	        return sum;
	    }
	    
	
	
	
	
	
	
	
	
//	
//	public int candy2(ArrayList<Integer>A) {
//		int[]candies = new int[A.size()];
//		Integer a[]= new Integer[A.size()];
//		A.toArray(a);
//		Arrays.sort(a);
//		
//	
//		return 0;
//	}
//
//    public int candy(ArrayList<Integer> A) {
//        int ans=0;
//        for(int i=0;i<A.size();i++){
//            ans+=check(A,i);
//        }
//        return ans;
//    }
//    
//    public static int che(ArrayList<Integer>A, int i) {
//    	int []candies=new int[A.size()];
//    	if(A.size()==1)
//    		return 1;
//    	if(A.get(0)<=A.get(1))
//    		candies[0]=1;
//    	else 
//    		candies[0]=1+candies[1];
//    	return 0;
//    }
//    
//    
//    
//    
//    public static int check(ArrayList<Integer>A, int i){
//        if(A.size()==1)
//        return 1;
//        if(i==0){
//            if(A.get(0)<=A.get(1))
//            return 1;
//            else
//            return 1+check(A,1);
//        }
//        else if(i==A.size()-1){
//            if(A.get(A.size()-1)<=A.get(A.size()-2))
//            return 1;
//            else 
//            return 1+check(A,A.size()-2);
//        }
//        else{
//            int current=A.get(i);
//            int previous=A.get(i-1);
//            int next=A.get(i+1);
//            if(current>previous && current>next)
//                return 1+Math.max(check(A,i-1),check(A,i+1));
//                else if(current>previous && current<next)
//                return 1+check(A,i-1);
//                else if(current<previous && current>next)
//                return 1+check(A,i+1);
//               else if(current==previous && current==next)
//                return check(A,i+1);
//                else
//                return 1;
//            
//        }
//    }
//
//
//
//	    public int candy3(ArrayList<Integer> A) {
//	        int ans=0;
//	        for(int i=0;i<A.size();i++){
//	            ans+=check(A,i);
//	        }
//	        return ans;
//	    }
//	    public static int check1(ArrayList<Integer>A, int i){
//	        if(A.size()==1)
//	        return 1;
//	        if(i==0){
//	            if(A.get(0)<=A.get(1))
//	            return 1;
//	            else
//	            return 1+check(A,1);
//	        }
//	        else if(i==A.size()-1){
//	            if(A.get(A.size()-1)<=A.get(A.size()-2))
//	            return 1;
//	            else 
//	            return 1+check(A,A.size()-2);
//	        }
//	        else{
//	            int current=A.get(i);
//	            int previous=A.get(i-1);
//	            int next=A.get(i+1);
//	            if(current>previous && current>next)
//	                return 1+Math.max(check(A,i-1),check(A,i+1));
//	                 if(current>previous && current<next)
//	                return 1+check(A,i-1);
//	                if(current<previous && current>next)
//	                return 1+check(A,i+1);
//	                if(current<previous && current<next)
//	                return 1;
//	                return 1;
//	            
//	        }
//	    }
//

}
