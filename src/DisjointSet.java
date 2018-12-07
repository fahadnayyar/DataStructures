import java.util.Scanner;

public class DisjointSet {
	public static void main(String[] args) {
		DisjointSet dj = new DisjointSet();
		dj.makesetBySize(6);
		Scanner sc = new Scanner(System.in);
		for (int i=0;i<6;i++){
		int a= sc.nextInt();
		int b = sc.nextInt();
		if (dj.findBySizePathCompression(a)!=dj.findBySizePathCompression(b)) {
			dj.unionBySize(a, b);
		}
		for (int yo: dj.arr) {
			System.out.print(yo+" ");
		}
		System.out.println();
//		if (dj.findBySizePathCompression(a)!=dj.findBySizePathCompression(b)) {
//			System.out.println("hi");
//		}
		}
		for (int yo: dj.arr) {
			System.out.print(yo+" ");
		}
		System.out.println(); 
	}
	public int[] arr;
	public int size;

	public void makesetFastUnion(int size) {
		this.size = size;
		arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = i;
		}
	}
	public int findFastUnion(int x) { // retun root of x if x is a valid element (ie, if -1<x<size)
		if (x >= size || x < 0) {
			return Integer.MIN_VALUE;
		}
		if (arr[x] == x) {
			return x;
		} else {
			return findFastUnion(arr[x]);
		}
	}
	public void Fastunion(int a, int b) { // gives find in O(n)
		int fa = findFastUnion(a);
		int fb = findFastUnion(b);
		if (a>=size||b<=size||a<0||b<0) {
			return;
		}
		if (fa == fb) {
			return;
		} else {
			arr[a]=b;
		}
	}
	public void makesetBySize(int size) {
		this.size=size;
		this.arr=new int[size];
		for (int i=0;i<size;i++) {
			arr[i]=-1;
		}
	}
	public int findBysize(int x) {
		if(x>=size || x<0) {
			return Integer.MIN_VALUE;
		}
		else {
			if (arr[x]<=0) {
				return x;
			}
			else {
				return findBysize(arr[x]);
			}
		}
	}
	public int findBySizePathCompression(int x) {
		if (x<0 || x>=size) {
			return Integer.MIN_VALUE;
		}
		else {
			if (arr[x]<0){
				return x;
			}
			else {
				return arr[x]=findBySizePathCompression(arr[x]);
			}
		}
	}
	public void unionBySize(int a, int b) {
		int fa = findBySizePathCompression(a);
		int fb = findBySizePathCompression(b);
		if (a>=size||b>=size||a<0||b<0) {
			return;
		}
		if (fa == fb) {
			return;
		} else {
			if (arr[fb]<arr[fa]) { // doubt wtf is this??
				arr[fb]+=arr[fa];
				arr[fa]=fb;
				//arr[fa]=fb;		// doubt wtf is this??	
				//arr[fb]+=arr[fa];	// doubt wtf is this??
			}
			else {
				
				arr[fa]+=arr[fb];
				arr[fb]=fa;
			}
		}
	}
	public void makesetByHeight(int size) {
		this.size=size;
		this.arr=new int[size];
		for (int i=0;i<size;i++) {
			arr[i]=-1;
		}
	}
	public int findByHeight(int x) {
		if(x>=size || x<=0) {
			return Integer.MIN_VALUE;
		}
		else {
			if (arr[x]<0) {
				return x;
			}
			else {
				return findByHeight(arr[x]);
			}
		}
	}

	

	

	public void unionByHeight(int  a, int b) {
		int fa = findByHeight(a);
		int fb = findByHeight(b);
		if (a>=size||b<=size||a<0||b<0) {
			return;
		}
		if (a>=size||b<=size||a<0||b<0) {
			return;
		}
		if (fa == fb && fa!=-1) {  //doubt
			return;
		} else {
			if (arr[fa]<arr[fb]) { // wtf is this?
				arr[fb]=fa;		 // wtf is this?	
			}
			else {
				if (arr[fb]==arr[fa]) // wtf is this?
					arr[fa]--;   		// wtf is this?
				arr[fb]=fa;			// wtf is this?
			}
		}
	}
}
