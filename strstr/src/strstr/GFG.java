// { Driver Code Starts
import java.util.*;


class Implement_strstr
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String line = sc.nextLine();
			String a = line.split(" ")[0];
			String b = line.split(" ")[1];
			
			GfG g = new GfG();
			System.out.println(g.strstr(a,b));
			
			t--;
		}
	}
}// } Driver Code Ends


class GfG
{
    //Function to locate the occurrence of the string x in the string s.
    int strstr(String s, String x)
    {
       // Your code here
        boolean flag=false;
       int index=-1;
       if(s.length()==1)
       if(s.equals(x))
       return 0;
       else
       return -1;
       for(int i=0;i<s.length();i++){
           index=i;
           if(s.charAt(i)==x.charAt(0)){
               if(x.length()==1)
               return index;
           for(int j=1;j<x.length();j++){
               if(i+j<s.length()&& s.charAt(i+j)==x.charAt(j))
               {
                   if(j==x.length()-1){
                       flag=true;
                       return index;
                   }
               }
               else{
                   break;
               }
              
           }
           }
       }
       return -1;
    }
}
