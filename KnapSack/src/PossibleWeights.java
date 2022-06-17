import java.util.Arrays;

public class PossibleWeights {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] weights= {1,3,3,5};
		int w=12;
		
		boolean [] possible= new boolean[w+1];
		possible[0]=true;
		for(int i=0;i<weights.length;i++) {
			for(int j=w;j>=0;j--) {
				if(possible[j]) {
					possible[j+weights[i]]=true;
				}
			}
		}
		System.out.println(Arrays.toString(possible));

	}

}
