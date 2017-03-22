package cn.red.sort;

public class QuickSortTest {
	
	public static void main(String[] args) {
		int[] arr = new int[]{50,10,90,30,70,40,80,60,20};
		QuickSort.sort(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
}
