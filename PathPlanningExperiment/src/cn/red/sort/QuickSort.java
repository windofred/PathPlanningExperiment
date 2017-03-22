package cn.red.sort;

/**
 * 
 * 快速排序
 * 
 * @author Administrator
 *
 */
public class QuickSort {
	
	//划分操作
	public static int partition(int[] arr, int left, int right) {
		int pivotKey = arr[left];
		
		while(left < right) {
			while(left<right && pivotKey>=arr[right]) {
				right--;
			}
			arr[left] = arr[right];//把小的移动到左边
			while(left<right && pivotKey<=arr[left]) {
				left++;
			}
			arr[right] = arr[left];//把打的移动到右边
		}
		arr[left] = pivotKey;//最后把pivotKey赋值到中间
		return left;
	}
	
	//快速排序
	public static void quickSort(int[] arr, int left, int right) {
		if(left>=right) {
			return;
		}
		int pivotPos = partition(arr, left, right);
		quickSort(arr, left, pivotPos-1);
		quickSort(arr, pivotPos+1, right);
	}
	
	//排序
	public static void sort(int[] arr) {
		if(arr==null || arr.length==0) {
			return;
		}
		quickSort(arr, 0, arr.length-1);
	}
	
	//交换:交换的是left和right作为下标的数组元素的值，而不是交换的是left和right的值
	public static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	
	
}
