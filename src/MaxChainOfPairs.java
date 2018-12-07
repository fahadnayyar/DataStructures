class pair {
	
	
	
	int l;
	int r;
	public pair(int l, int r) {
		this.l=l;
		this.r=r;
	}
	public boolean isGreater(pair yo) {
		if (this.l>yo.l) {
			return true;
		}
		else if (this.l<yo.l) {
			return false;
		}
		else {
			return this.r>yo.r;
		}
	}
//	public boolean equals(pair yo) {
//		return (this.l==yo.l && this.r==yo.r);
//	}
//	public int compareTo(pair yo) {
//		return 
//	}
}
public class MaxChainOfPairs {
	public static void main(String[] args) {
		int ar1[]= {5,15,27,50};
		int ar2[]= {24,25,40,60};
		pair ar[] = new pair[4];
		ar[0]= new pair(ar1[0],ar2[0]);
		ar[1]= new pair(ar1[1],ar2[1]);
		ar[2]= new pair(ar1[2],ar2[2]);
		ar[3]= new pair(ar1[3],ar2[3]);
		MaxChainOfPairs mcp = new MaxChainOfPairs(ar, 4);
		System.out.println(mcp.giveMacChain());

	}
	
	
	
	pair arr[];
	int lis[];
	int n;
	public MaxChainOfPairs(pair arr[],int n) {
		this.arr=arr;
		this.n=n;
	}
	public int giveMacChain() {
		this.lis=new int[n];
		for (int i=0;i<n;i++) {
			lis[i]=1;
		}
		mergesort(arr, 0, n-1);
		for (int i=0;i<n;i++) {
			for (int j=0;j<i;j++) {
				if (arr[i].l>arr[j].r) {
					lis[i]=Math.max(lis[i], lis[j]+1);
				}
			}
		}
	return lis[n-1];
	}
	public static void mergesort(pair arr[], int low, int high) {// give low=0, high =len-1 while calling this function.
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
		pair aux[] = new pair[range];
		for (int p = 0; p < range; p++) {
			aux[p] = arr[low+p];
		}
		while (i <= mid && j < range) {
			if ( aux[j].isGreater(aux[i]) )   {//aux[i] <= aux[j])
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
