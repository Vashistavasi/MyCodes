import java.util.Scanner;

public class PossibleSolutionCount {
public static void main(String... args) {

	int []coins= {1,3,4};
	Scanner s= new Scanner(System.in);
	System.out.println("Enter the sum Required ");
	int sum =s.nextInt();
	int value[]= new int [sum+1];
	value[0] = 1;
	for (int x = 1; x <= sum; x++) {
	for (int c : coins) {
	if (x-c >= 0) {
	value[x] += value[x-c];;
	}
	}
	}
	int ans=value[sum];
	

	System.out.println("Possible count "+ ans);
	}
}

