
public class LongestSubsequence {
public static void main(String[] args) {
	int [] a= { 14, 24, 18, 46, 55, 53, 82, 18, 101, 20, 78, 35, 68, 9, 16, 93, 101, 85, 81, 28, 78 };
	int []length= new int[a.length];
//	System.out.println(findLength(a, 0));
//	System.out.println(findLength(a, 1));
//	System.out.println(findLength(a, 2));
//	System.out.println(findLength(a, 3));
//	System.out.println(findLength(a, 4));
//	System.out.println(findLength(a, 5));
//	System.out.println(findLength(a, 6));
	System.out.println(findLength(a, a.length-1));
	
	
}
public static int findLength(int[]a,int n) {
	int []length= new int[n+1];
	length[n]=1;
	//we need to find an position j<n where a[j]<a[n] 
	// for all such position length[n] will be max(length[n],length[j]+1)
	for( int j=0;j<=n;j++) {
		 {
			if(a[j]<a[n])
			length[n]=Math.max(findLength(a,j)+1,length[n] );
			//	length[n]=Math.max(findLength(a,j)[j]+1,length[n] );
			
		}
	}
//	for(int i:length) {
//		System.out.print(" "+ i+" ");
//		
//	}
//	System.out.println();
	return length[n];
	
}

public static int[] findLength1(int[]a,int n) {
	int []length= new int[n+1];
	length[n]=1;
	//we need to find an position j<n where a[j]<a[n] 
	// for all such position length[n] will be max(length[n],length[j]+1)
	for( int j=0;j<=n;j++) {
		 {
			if(a[j]<a[n]) {
			int temp[]=findLength1(a,j);
				length[n]=Math.max(temp[j]+1,length[n] );
			}
		}
	}
	return length;
	
}
}
