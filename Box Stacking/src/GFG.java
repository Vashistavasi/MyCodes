//{ Driver Code Starts
//Initial Template for Java

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
            String[] s1 = br.readLine().trim().split(" ");
            int[] height = new int[n];
            for(int i = 0; i < n; i++){
                height[i] = Integer.parseInt(s1[i]);
            }
            String[] s2 = br.readLine().trim().split(" ");
            int[] width = new int[n];
            for(int i = 0; i < n; i++){
                width[i] = Integer.parseInt(s2[i]);
            }
            String[] s3 = br.readLine().trim().split(" ");
            int[] length = new int[n];
            for(int i = 0; i < n; i++){
                length[i] = Integer.parseInt(s3[i]);
            }
            Solution obj = new Solution();
            System.out.println(obj.maxHeight(height, width, length, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class box{
    int l;
    int w;
    int h;
    int area;
    box(int l,int w,int h){
        this.l=l;
        this.w=w;
        this.h=h;
        area=l*w;
    }
    public String toString(){
        return this.l+" "+this.w+" "+this.h+" "+this.area;
    }
}

class Solution
{
    public static int maxHeight(int[] h, int[] w, int[] l, int n)
    {
        // Code here
        box boxes[]=new box[3*n];
        for(int i=0,j=0;i<n;i+=1,j+=3){
            if(l[i]<w[i])
            boxes[j]=new box(l[i],w[i],h[i]);
            else
            boxes[j]=new box(w[i],l[i],h[i]);
            if(h[i]<w[i])
            boxes[j+1]=new box(h[i],w[i],l[i]);
            else
            boxes[j+1]=new box(w[i],h[i],l[i]);
            if(l[i]<h[i])
            boxes[j+2]=new box(l[i],h[i],w[i]);
            else
            boxes[j+2]=new box(h[i],l[i],w[i]);

        }
        Arrays.sort(boxes,new Comparator<box>(){
            public int compare(box box1,box box2){
            return box2.area-box1.area;    
            }
            
        });
        int maxHeight[]=new int[3*n];
        int tem=0;
        for(box i:boxes)
        maxHeight[tem++]=i.h;
        
        for(int i=1;i<3*n;i++){
            int val=0;
            box b=boxes[i];
            for(int j=0;j<i;j++){
                box c=boxes[j];
                if(b.l<c.l && b.w<c.w ){
                    val=Math.max(val,maxHeight[j]);
                }
                
            }
            maxHeight[i]=val+b.h;
        }

        //System.out.println(Arrays.toString(boxes));
        int ans=Integer.MIN_VALUE;
        for(int i:maxHeight)
        ans=Math.max(ans,i);
        
        return ans;
        
    }
}