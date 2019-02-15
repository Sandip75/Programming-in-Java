package problemSolution.way.jan2019;

import java.util.Scanner;

public class Balanced {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		//String s = scn.next();
		String s = ")(";
		
		int check = 0 ; 
		boolean flag = false ;
		for(int i=0 ;  i< s.length() ; i++){
			if(s.charAt(i) == '('){
				check +=1;
			}else {
				check -=1;
			}						
			if(!flag && check==-1){
				check +=1;
				flag = true;
			}			
			if(check < -1){
				System.out.println("No");
				return ;
			}			
		}		
		if(flag && check==0){
			System.out.println("Yes");
		}else if(!flag && (check==0 || check==-1 || check==1)){
			System.out.println("Yes");
		}
		else{
			System.out.println("No");
		}
	}
}
