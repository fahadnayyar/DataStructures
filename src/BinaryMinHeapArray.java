
public class BinaryMinHeapArray {
	public static void main(String[] args) {
		BinaryMinHeapArray hp = new BinaryMinHeapArray(100);
		hp.insert(9);
		hp.insert(8);
		hp.insert(7);
		hp.insert(6);
		hp.insert(5);
		hp.insert(4);
		hp.insert(3);
		hp.insert(2);
		hp.insert(1);
		hp.printMinHeap();
		System.out.println(hp.ExtractMin());
		System.out.println(hp.giveMin());
		System.out.println(hp.giveSize());
		hp.delete(3);
		System.out.println(hp.giveSize());
		//hp.delete(0);
		hp.printMinHeap();
		hp.decrease(3, -100);
		hp.printMinHeap();
		int arr[] = {124,546,7,4,-436,-64575};
		hp.heapSort(arr);
		for (int p:arr) {
			System.out.print(p+" ");
		}
		System.out.println();
	}
	
	private int heaparr[];
	private int size;

	public BinaryMinHeapArray(int cap) {
		heaparr = new int[cap];
		size = 0;
	}

	public int giveSize() {
		return size;
	}

	public void printMinHeap() {
		for (int i : heaparr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public int giveMin() {
		if (size <= 0) {
			System.out.println("empty heap");
			return Integer.MAX_VALUE;
		} else {
			return heaparr[0];
		}

	}

	public int ExtractMin() {
		return ExtractMin_ins();
	}

	private int ExtractMin_ins() {
		if (this.size <= 0) {
			System.out.println("heap underflow : emoty heap exception");
			return Integer.MAX_VALUE;
		} else {
			int min = heaparr[0];
			heaparr[0] = heaparr[size - 1];
			heaparr[size - 1] = 0;
			heapify_ins(this.heaparr, 0, size - 2);
			size--;
			return min;
		}
	}

	public void heapify(int i) {
		heapify_ins(this.heaparr, i, this.size-1);
	}

	private void heapify_ins(int arr[], int i, int size) {
		int l = (2 * i) + 1;
		int r = (2 * i) + 2;
		int smallest;
		if (l <= size && arr[l] < arr[i]) {
			smallest = l;

		} else {
			smallest = i;
		}
		if (r <= size && arr[smallest] > arr[r]) {
			smallest = r;
		}
		if (smallest != i) {
			int temp = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = temp;
			heapify_ins(arr, smallest, size);
		}
	}

	public void buildMinHeap(int arr[]) {
		int l = arr.length;
		for (int i = (l / 2); i >= 0; i--) {
			heapify_ins(arr, i, l - 1);
		}
	}
	public void heapSort(int arr[]) {
		buildMinHeap(arr);
		int l= arr.length;
		for (int i=l-1;i>=1;i--) {
			int temp=arr[0];
			arr[0]=arr[i];
			arr[i]=temp;
			heapify_ins(arr, 0, i-1);
		}
	}
	public void decrease(int i, int key) {
		if (i<0 || i>size-1) {
			System.out.println("index out of bound");
		}
		else if (heaparr[i]<=key) {
			System.out.println("arr element is already smaller than given key");
		}
		else {
			heaparr[i]=key;
			while (i>0 && heaparr[(i-1)/2]>heaparr[i]) {
				int temp=heaparr[i];
				heaparr[i]=heaparr[(i-1)/2];
				heaparr[(i-1)/2]=temp;
				i=(i-1)/2;
			}
		}
	}
	public void insert(int key) {
		if (size>heaparr.length-1) {
			System.out.println("heap overflow");
		}
		else {
			size++;
			heaparr[size-1]=Integer.MAX_VALUE;
			decrease(size-1, key);
		}
	}
	public void delete(int i) {
		int temp=heaparr[size-1];
		heaparr[size-1]=0;
		heaparr[i]=temp;
		size--;
		if (temp>heaparr[(i-1)/2]) {
			heapify(i);
		}
		else{
			while (i>0 && heaparr[(i-1)/2]>heaparr[i]) {
				int temp1=heaparr[i];
				heaparr[i]=heaparr[(i-1)/2];
				heaparr[(i-1)/2]=temp1;
				i=(i-1)/2;
			}
		}
	}
	

}




