import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HalfOccurance {
	 public int majorityElement(final List<Integer> A) {
		 HashMap<Integer, Integer> hm= new HashMap<Integer,Integer>();
		 for(int i=0;i<A.size();i++) {
			 if(hm.get(A.get(i))==null)
			 hm.put(A.get(i), 1);
			 else
			 {
				 int a=hm.get(A.get(i));
				 hm.put(A.get(i), a+1);
			 }
		 }
		 Iterator it=hm.entrySet().iterator();
		 int ans=0;
		 while(it.hasNext()) {
			 Map.Entry mp= (Map.Entry) it.next();
			 if((int)mp.getValue()>Math.floor(A.size()/2)) {
				 ans=(int)mp.getKey();
			 }
				 
		 }
		 return ans;
		
	 }
	 }

