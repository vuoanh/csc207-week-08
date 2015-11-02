import java.util.Arrays;

class A implements Comparable<Integer> {
	int x;

	@Override
	public int compareTo(Integer o) {
		// if this less than 0, return negative
		if(this.x < o.intValue()) {return -1;}
		if(this.x == o.intValue()){
			return 0;
		} else { return 1;}
	}
}
public class Sort<T> {
	/* helper method help merge two sub arrays and put the merged array into outArr */
	public static <T extends Comparable<? super T>> void merge(T[] arr, int leftPos, int rightPos, T outArr[], int rightEnd){
		int ElementNum = rightEnd - leftPos +1;
		int leftEnd = rightPos - 1;
		int tmpPos = leftPos;
		// Compare first element of each of left and right sub arrays.
		// Copy the smaller element to outArr
		while(leftPos <= leftEnd && rightPos <= rightEnd){
			if (arr[leftPos].compareTo(arr[rightPos]) < 0){
				outArr[tmpPos++] = arr[leftPos++];
			}
			else {
				outArr[tmpPos++] = arr[rightPos++];
			}
		}
		// if right sub array is out of element
		while(leftPos <= leftEnd){
			outArr[tmpPos++] = arr[leftPos++];
		}
		while(rightPos <= rightEnd){
			outArr[tmpPos++] = arr[rightPos++];
		}
		// Copy outArr back to arr
		for(int i = 0; i < ElementNum ; i++){
			arr[i] = outArr[i];
		}
	}
	/* Helper mergeSort for mergeSort method. 
	 * Recursively divide the array into left and right sub arrays
	 * Then, recursively merge left and right sub arrays by using merge method
	 *  */
	public static <T extends Comparable<? super T>> void mergeSortHelper( T[] arr, int lower, int upper, T[] tmpArr){
		if (upper > lower) {
			int mid = lower + (upper - lower) /2;
			mergeSortHelper(arr, lower, mid,tmpArr);
			mergeSortHelper(arr, mid+1, upper, tmpArr);
			merge(arr, lower, mid + 1, tmpArr, upper);
		}
	}
	
	public static <T extends Comparable<? super T>> void mergeSort( T[] arr){
		T[] tmpArr = (T[]) new Object[arr.length];
		mergeSortHelper( arr, 0, arr.length, tmpArr);
	}
	
}