package problemSolution.way.jan2019;
import java.util.*;

public class Pattern {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		//Your Code 
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(j==0 || j==n-1){
					System.out.print("*");
				}else if(i==j || i+j == n-1){
					System.out.print("*");
				}else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}

	}

}
