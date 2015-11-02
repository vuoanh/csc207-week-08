import java.util.Arrays;

public class InsertionSort {
	public static int[] InsertionSort(int arr[]){
		for(int i = 0; i < arr.length-1; i++){
			for(int j = i+1; j > 0; j--){
				if(arr[j] < arr[j-1]){
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				} else break;
			}
		}
		return arr;
	}
	
	public static void main(String args[]){
		int[] arrayOne = new int[] {7,7,7};
		InsertionSort(arrayOne);
		for(int i = 0; i<arrayOne.length; i++){
			System.out.println(arrayOne[i]);
		}
	}
}

