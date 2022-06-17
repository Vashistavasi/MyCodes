import java.util.HashMap;

public class Solution {
    public int numDecodings(String A) {
    
    	
    	int count=0;
    	int value=Integer.parseInt(A);
    	if (value==0)
            return 0;
    	int m10=value%10;
    	int  m100=value%100;
    	int temp=value;
   
    	 {
    		if(m10!=0&&m100<27) {
    		temp=temp/10;
    		count+=1+numDecodings(new String(String.valueOf(temp))+numDecodings(new String(String.valueOf(temp/10))));
    		return count;
    		}
    		else {
    			temp=temp/100;
    			count+=1+numDecodings(new String(String.valueOf(temp)));
    			return count;
    		}
    	}
    	
    
    }
    
    int variable =10;
    public static void main(String[] args) {
    	System.out.println(variable);
//		String a= new String("133");
//		String b=new String(String.valueOf(a.charAt(0)+""+a.charAt(2)));
//		System.out.println(b);
//		Integer.parseInt(String.valueOf('0'));
	}
}
