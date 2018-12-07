
public class BoxStacking {
	public static void main(String[] args) {
		box arr[] = new box[3];
		arr[0]= new box(12,32,10);
		arr[1]= new box(5,6,4);
		arr[2]= new box(1,2,3);
		BoxStacking bs = new BoxStacking(arr, 3);
		System.out.println(bs.giveMaxHeight());
	}
	
	box arr[];
	int lis[];
	int n;
	public BoxStacking(box arrr[], int n) {
		this.n=n;
		this.arr= new box[3*n];
		int yo=0;
		for (int i=0;i<n;i++) {
			box b = arrr[i];
			int x=b.l;
			int y=b.b;
			int z=b.h;
			
			box n1= new box(Math.min(y, z),Math.max(y,z),x);
			box n2= new box(Math.min(x, z),Math.max(x,z),y);
			box n3= new box(Math.min(x, y),Math.max(x,y),z);
			this.arr[yo]=n1;
			yo+=1;
			this.arr[yo]=n2;
			yo+=1;
			this.arr[yo]=n3;
			yo+=1;
			
		}
		mergesort(this.arr, 0, (3*n)-1);
		this.lis= new int[3*n];
		for (int i=0;i<3*n;i++) {
			lis[i]=this.arr[i].h;
		}
	}
	public int giveMaxHeight() {
		for (int i=0;i<3*n;i++) {
			for (int j=0;j<i;j++) {
				if (arr[i].l < arr[j].l && arr[i].b <arr[j].b) {
					lis[i]=Math.max(lis[i], lis[j]+arr[i].h);
				}
			}
		}
		return lis[3*n-1];
	}
	
	
	public static void mergesort(box arr[], int low, int high) {// give low=0, high =len-1 while calling this function.
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
		box aux[] = new box[range];
		for (int p = 0; p < range; p++) {
			aux[p] = arr[low+p];
		}
		while (i <= mid && j < range) {
			if ( aux[i].IsGreater(aux[j])   ) { //aux[i] <= aux[j]
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
class box{
	
	public box(int l , int b, int h) {
		this.l=l;
		this.b=b;
		this.h=h;
	}
	public boolean IsGreater(box yo) {
		if (this.l*this.b > yo.l*yo.b) {
			return true;
		}
		else if (this.l*this.b < yo.l*yo.b) {
			return false;
		}else {
			return this.h>=yo.h;
		}
	}
	int l;
	int b;
	int h;
}