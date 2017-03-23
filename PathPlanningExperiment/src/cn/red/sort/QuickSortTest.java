package cn.red.sort;

public class QuickSortTest {
	
	public static void main(String[] args) {
		int[] arr = new int[]{10,20,30,40,50,60,70,80,90};
		QuickSort.sort(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	
	
}
