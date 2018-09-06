package coreJava.arrays;

public class ReverseArray {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50, 60 };
		reverseArray(arr);
		for (int val : arr) {
			System.out.print(val + "  ");
		}
	}

	public static void reverseArray(int[] arr) {
		int left =0 ;
		int right = arr.length -1 ;
		
		while(left <= right){
			swap(arr, left , right);
			left++;
			right--;
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp ;
	}

}
