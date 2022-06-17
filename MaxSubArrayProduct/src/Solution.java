import java.util.List;

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY

    public int maxProduct(final List<Integer> A){
        int n=A.size();
int maxProduct[]=new int[n];
int minProduct[]=new int[n];
maxProduct[0]=A.get(0);
minProduct[0]=A.get(0);
for(int i=1;i<n;i++){
maxProduct[i]=Math.max(Math.max(maxProduct[i-1]*A.get(i),minProduct[i-1]*A.get(i)),A.get(i));
minProduct[i]=Math.min(Math.min(maxProduct[i-1]*A.get(i),minProduct[i-1]*A.get(i)),A.get(i));


    // int product=maxProduct[i-1]*A.get(i);
    // if(product>=maxProduct[i-1]){
    //  maxProduct[i]=product;
    //  minProduct[i]=A.get(i);
    // }
   
    // else
    // {
    //     maxProduct[i]=A.get(i);
    //     minProduct[i]=product;
    // }

    // product=minProduct[i-1]*A.get(i);

    // if(product<minProduct[i-1])
    // minProduct[i]=product;
}

    
    // public int maxProduct(final List<Integer> A) {
    //     int n=A.size();
    //     int product=1;
    //     int ans=Integer.MIN_VALUE;
    //     //ArrayList<Integer> ans=new ArrayList<Integer>();
    //     for(int i=0;i<n;i++){
    //         for(int j=i;j<n;j++){
    //             product*=A.get(j);
    //             ans=Math.max(ans,product);
    //         }
    //         product=1;
    //     }
        int value=Integer.MIN_VALUE;
        for(int i: maxProduct){
            value=Math.max(value, i);
        }
        return value;
    }
    // }
}
