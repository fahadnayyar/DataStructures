//public class RangeMinQuery { // this class only supports range min queries and no updations in array.
//	
//	public static void main(String[] args) {
//		int arr[] = {25,235,97,-325,64,152,346,-328,399};
//		RangeMinQuery rmq = new RangeMinQuery(arr, arr.length);
//		rmq.constructSparseTable();
//		System.out.println(arr[rmq.sparseTableMin(0, 8)]);
//		System.out.println(arr[rmq.sparseTableMin(1, 4)]);
//		System.out.println(arr[rmq.sparseTableMin(2, 2)]);
//		System.out.println(arr[rmq.sparseTableMin(2, 7)]);
//		System.out.println(arr[rmq.sparseTableMin(8, 8)]);
//		
//	}
//	
//	
//	
//	
//	
//	int arr[];
//	int len; // length of array
//	// int l;
//	// int r;
//	int dpArr[][];
//	int sparseTable[][];
//	int segarr[];
//	public RangeMinQuery(int arr[], int len) { // create this class giving array refrence and length of array as parameter.
//		this.arr = arr;
//		this.len = len;
//		// this.l=l;
//		// this.r=r;
//		
//	}
//
//	public int bruteForceMin(int l, int r) { // call this method with range l,r to find min in that range. O(n)
//		int min=arr[l];
//		int minind=l;
//		for (int i=l;i<=r;i++) {
//			if (arr[i]<min) {
//				min=arr[i];
//				minind=i;
//			}
//		}
//		return minind;
//	}
////	public int dpMin(int l, int r) { 
////		this.dpArr=new int[len][len];
////	}
//	public int sparseTableMin(int l,int r) { // first construct spase table from construction method then call this method to get min query in O(1) time.
//		int yo = r-l+1;
//		int k =(int) Math.log(yo);
//		return Math.min(this.sparseTable[l][k],this.sparseTable[l+yo-(int)Math.pow(2, k)][k] );
//	}
//	public void constructSparseTable(){ // forms a sparsh table in O(nlog(n)) time and space.
//		int preprocessor[][]=new int[len][((int)Math.log(len))+1];
//		for (int i=0;i<len;i++) {
//			preprocessor[i][0]=i;
//			
//		}
//		for (int j=1;(int)Math.pow(2, j) <=len;j++) { // doubt 2^j<=len why?
//			for (int i=0;i+(int)Math.pow(2, j)-1<len;i++) { // doubt i+2^j-1<len why?
//				if (arr[preprocessor[i][j-1]]<arr[preprocessor[i+((int)Math.pow(2, j-1))][j-1]]) { // doubt why i+2^(j-1)
//					preprocessor[i][j]=preprocessor[i][j-1];
//				}
//				else {
//					preprocessor[i][j]=preprocessor[i+((int)Math.pow(2, j-1))][j-1];
//				}
//			}
//			
//		}
//		this.sparseTable=preprocessor;
//	}
//	private void initializeSegmentTree() {
//		if (Math.pow(2, (int)Math.log(len))==len) {
//			segarr=new int[2*len-1];
//		}
//		else {
//			segarr=new int[2*(int)Math.pow(2, (int)Math.log(len)+1)-1];
//		}
//		
//	}
//	public void constructSegmentTree(int l,int r,int pos) { // call it with l=0 and r=len-1 pos=0  // this function constructs segment tree arr in O(n) its size is also O(n)
//		initializeSegmentTree();
//		if (l==r) {
//			segarr[pos]=arr[l];
//			return;
//		}
//		else {
//			int mid=(r+l)/2;
//			constructSegmentTree(l, mid, 2*pos+1);
//			constructSegmentTree(mid+1, r, 2*pos+2);
//			segarr[pos]=Math.min(segarr[2*pos+1], segarr[2*pos+2]);
//		}
//	}
//	public int segmentTreeMin(int l, int r, int low, int high, int pos) { // call this function with pos=0, low=0, high=len
//		if () {
//			
//		}
//		else if (){
//			
//		}
//	}
//	
//	
//
//}
