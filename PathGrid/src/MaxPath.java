import java.util.ArrayList;

public class MaxPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] a= {
				     {3,7,9,2,7}
		,            {9,8,3,5,5},
		             {1,7,9,8,5}, 
		             {3,8,6,4,10}, 
		             {6,3,9,7,8}
		             };
		System.out.println(value1(a,4,4));


	}
	public static int value(int [][]a,int x, int y) {
		int value=0;
		if(x<0||y<0 )
			return 0;

			value+=Math.max(value(a,x-1,y), value(a,x,y-1))+a[x][y];
System.out.println("Value1 "+ value+ " X "+ x +" Y "+ y );

		return value;
		
	}
	public static int value1(int [][]a,int x, int y) {
		int value=0;
		 
		if(x<0||y<0 )
			return 0;
		
		if(x==0&&y>=0) {
			value+= value1(a,x,y-1)+a[x][y];
		}
		if(x>=0&&y==0) {
			value+=value1(a,x-1,y)+a[x][y];
		}
if(x>0&&y>0)
			value+=Math.min(value1(a,x-1,y), value1(a,x,y-1))+a[x][y];

		return value;
		
	}

public static int value(ArrayList<ArrayList<Integer>> a){
    int n=a.size();
    int m=a.get(0).size();
    int values[][]= new int[n+1][m+1];
    values[0][0]=a.get(0).get(0);
    for(int i=1;i<m;i++){
        values[0][i]=values[0][i-1]+a.get(0).get(i);
    }
    for(int i=1;i<n;i++){
        values[i][0]=values[i-1][0]+a.get(i).get(0);
    }
    for(int i=1;i<n;i++){
        for(int j=1;j<m;j++){
            values[i][j]=Math.min(values[i-1][j],values[i][j-1])+a.get(i).get(j);
        }
    }
    return values[n-1][m-1];
}
}
