/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
	//code
		Scanner s=new Scanner(System.in);
		int tests=s.nextInt();
		while(tests-->0) {
			int size=s.nextInt();
			Integer a[]=new Integer[size];
			for(int i=0;i<size;i++) {
				a[i]=s.nextInt();
			}
			HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
			for(int i=0;i<size;i++) {
				if(hm.containsKey(a[i])) {
					int count=hm.get(a[i]);
					hm.put(a[i], count+1	);
				}
				else {
					hm.put(a[i], 1);
				}
			}
			
			List<Integer> al=Arrays.asList(a);
			al.sort(new Comparator<Integer>() {

				@Override
				public int compare(Integer a, Integer b) {
					// TODO Auto-generated method stub
					int freq1=hm.get(a);
					int freq2=hm.get(b);
					if(freq1!=freq2) {
						return freq2-freq1;
					}
					else {
						return a-b;
					}
				}
				
			});
			al.forEach(x->System.out.print(x+" "));
			System.out.println();
		}
		//code
	}
}