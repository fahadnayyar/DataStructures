
public class HeapsBinaryMax {

	public static void main(String[] args) {
		HeapsBinaryMax hp = new HeapsBinaryMax(100);
//		hp.Heap_max_insert(1);
//		System.out.println(hp.size);
//		hp.Heap_max_insert(2);
//		System.out.println(hp.size);
//		hp.Heap_max_insert(3);
//		System.out.println(hp.size);
//		hp.Heap_max_insert(4);
//		System.out.println(hp.size);
//		hp.Heap_max_insert(5);
//		System.out.println(hp.size);
//		hp.Heap_max_insert(6);
//		System.out.println(hp.size);
//		hp.Heap_max_insert(7);
//		System.out.println(hp.size);
//		hp.Heap_max_insert(8);
//		System.out.println(hp.size);
//		hp.Heap_max_insert(9);
//		System.out.println(hp.size);
//		hp.Heap_max_insert(10);
//		System.out.println(hp.size);
//		hp.printHeapMax();
//		System.out.println(hp.extractMaxHeap());
//		System.out.println(hp.size);
//		hp.printHeapMax();
//		System.out.println(hp.findMax());
//		System.out.println(hp.size);
//		hp.printHeapMax();
//		hp.delete(1);
//		hp.printHeapMax();
//		
//hp.Heap_max_insert(1);
//hp.Heap_max_insert(2);
//hp.Heap_max_insert(3);
//hp.Heap_max_insert(4);
//hp.Heap_max_insert(5);
//hp.Heap_max_insert(6);
//hp.Heap_max_insert(7);
//hp.Heap_max_insert(8);
//hp.Heap_max_insert(9);
//hp.printHeapMax();
//hp.delete(3);
//hp.printHeapMax();
//int arr[] = {124,546,7,4,-436,-64575};
//hp.heapSortMax(arr);
//for (int p:arr) {
//	System.out.print(p+" ");
//}
//System.out.println();
		int arr[] = {-15,347,-364,135,57,-135,-7432,6432};
		hp.builxMaxHeap(arr);
		for (int p:arr) {
		System.out.print(p+" ");
	}
	System.out.println();
	}

	private int heaparr[];
	private int size;
	public int giveSize() {
		return size;
	}
	public void printHeapMax() {
		for (int i:heaparr) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	public HeapsBinaryMax(int cap) {
		heaparr = new int[cap];
		size = 0;
	}

	public int extractMaxHeap() {
		return extractMaxHeapIns();
	}

	private int extractMaxHeapIns() {
		if (this.size < 0) {
			System.out.println("heap underflow");
			return Integer.MIN_VALUE;
		} else {

			int max = heaparr[0];
			heaparr[0] = heaparr[size - 1];
			heaparr[this.size-1]=0;
			maxHeapifyIns(this.heaparr, 0, size - 2);
			size--;
			return max;
		}
	}

	public void Heap_max_Increase(int i,int key){
		if (i>size-1 || i<0) {
			System.out.println("arrya out of bond");
		}
		else if (heaparr[i]>=key) {
			System.out.println("arr elem is greater than new key");
		}
		else {
			heaparr[i]=key;
			while (i>0 && heaparr[(i-1)/2]<heaparr[i]) {
				//printHeapMax();
				int temp=heaparr[i];
				heaparr[i]=heaparr[(i-1)/2];
				heaparr[(i-1)/2]=temp;
				i=(i-1)/2;
			}
		}
	}
	public void Heap_max_insert(int key) {
		if (size>this.heaparr.length-1) {
			System.out.println("heap overflow");
		}
		else {
			this.size++;
			heaparr[this.size-1]=Integer.MIN_VALUE;
			Heap_max_Increase(this.size-1, key);
		}
		
	}
//	private void Heap_max_Insert_ins(int data, int size ) {
//		
//	}

	public int findMax() {
		return heaparr[0];

	}

	public void maxHeapify(int i) {
		maxHeapifyIns(this.heaparr, i, this.size-1);
	}

	private  void maxHeapifyIns(int arr[], int i, int n) {
		int l = (2 * i) + 1;
		int r = (2 * i) + 2;
		int largest;
		if (l <= n && arr[l] > arr[i]) {
			largest = l;
		} else {
			largest = i;
		}
		if (r <= n && arr[largest] < arr[r]) {
			largest = r;
		}
		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			maxHeapifyIns(arr, largest, n);
		}

	}

	public  void builxMaxHeap(int arr[]) { // approx n(logn)
		int l = arr.length;
		for (int i = (l / 2) ; i >= 0; i--) {
			maxHeapifyIns(arr, i, l - 1);
		}
	}

	public void heapSortMax(int arr[]) {
		builxMaxHeap(arr);
		int l = arr.length;
		for (int i = l - 1; i >= 1; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			maxHeapifyIns(arr, 0, i - 1);
		}
	}
	public void delete(int i) {
		int temp=heaparr[size-1];
		heaparr[size-1]=0;
		heaparr[i]=temp;
		size--;
		if (temp<heaparr[(i-1)/2]) {
			maxHeapify(i);
		}else {
			while (i>0 && heaparr[(i-1)/2]<heaparr[i]) {
				//printHeapMax();
				int temp1=heaparr[i];
				heaparr[i]=heaparr[(i-1)/2];
				heaparr[(i-1)/2]=temp1;
				i=(i-1)/2;
			}
		}
	}

}
