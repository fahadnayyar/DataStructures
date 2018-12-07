
public class Sorting {
	public static void main(String[] args) {
		 int arr[]= {5,2,6,4,3,8};
		 mergesort(arr, 0, arr.length-1);
		 for (int i:arr){
			 System.out.print(i+" ");
		 }
		 System.out.println();
	}

	public static void quicksort(int arr[], int low, int high) {// to sort give parameter as low=0, hight = lenght of arr -1
		int pivot = low;
		// int l = arr.length;
		int left = low + 1;
		int right = high;

		while (left < right) {
			while (arr[left] <= arr[pivot] && left != high) {
				left++;
			}
			while (arr[right] > arr[pivot] && right != low) {
				right--;
			}
			if (left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				// //comment maarna hai
				// for (int i:arr) {
				// System.out.print(i+" ");
				// }
				// System.out.println();
				// //yaha tak

			}
		}
		if (arr[pivot]>=arr[right]) {
			int temp = arr[pivot];
			arr[pivot] = arr[right];
			arr[right] = temp;
		}
		
		
		// //comment maarna hai
		// for (int i:arr) {
		// System.out.print(i+" ");
		// }
		// System.out.println();
		// //yaha tak

		if (low < right - 1) {
			quicksort(arr, low, right - 1);
		}
		if (right + 1 < high) {
			quicksort(arr, right + 1, high);
		}
	}

	public static void mergesort(int arr[], int low, int high) {// give low=0, high =len-1 while calling this function.
		if (low < high) {
			int mid = (high + low) / 2;
			mergesort(arr, low, mid);
			mergesort(arr, mid + 1, high);
		}
		int range=high-low+1;
		int j;
		int mid;
		if (range%2==0) {
			j=(range/2);
			mid=(range/2)-1;
		}
		else {
			j=(range/2)+1;
			mid=(range/2);
		}
		int i=0;
		//int mid = (high + low) / 2;
		//int i = low;
		//int j = mid + 1;
		int l = arr.length;
		int k = low;
		int aux[] = new int[range];
		for (int p = 0; p < range; p++) {
			aux[p] = arr[low+p];
		}
		while (i <= mid && j < range) {
			if (aux[i] <= aux[j]) {
				arr[k] = aux[i];
				i++;
			} else {
				arr[k] = aux[j];
				j++;
			}
			k++;
		}
		while (i <= mid) {
			arr[k] = aux[i];
			k++;
			i++;
		}
		while (j < range) {
			arr[k]=aux[j];
			k++;
			j++;
		}
		// comment maarna hai
//		if (high == low) {
//
//		} else {
//			for (int f = low; f <= high; f++) {
//				System.out.print(arr[f] + " ");
//			}
//			System.out.println();
//		}
		// yaha tak

	}
}
