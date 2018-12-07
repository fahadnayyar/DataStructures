
public class LongestBitonicSubSeq {
	
	public static void main(String[] args) {
int arr[]= {2 ,4 ,6 ,3 ,4 ,5 ,87, 56, 43, 9};
//		int arr[]= {4 ,5, 2, 3, 7, 9, 1, 5};
		LongestBitonicSubSeq lbs = new LongestBitonicSubSeq(arr, arr.length);
		System.out.println(lbs.GiveLBSS());
//		for (int i:lbs.lis) {
//			System.out.print(i+" ");
//		}
//		System.out.println();
//		for (int i:lbs.lds) {
//			System.out.print(i+" ");
//		}
//		System.out.println();
	}
	
	int arr[];
	int lis[];
	int lds[];
	int n;
	public LongestBitonicSubSeq(int arr[], int n) {
		this.arr=arr;
		this.n=n;
	}
	public int GiveLBSS() {
		this.lis=new int[n];
		this.lds=new int[n];
		for (int i=0;i<n;i++) {
			lis[i]=1;
			lds[i]=1;
		}
		
		for (int i=0;i<n;i++) {
			for (int j=0;j<i;j++) {
				if (arr[i]>arr[j]) {
					lis[i]=Math.max(lis[i], lis[j]+1);
				}
				
//				else if (arr[i]<arr[j]) {
//					lds[i]=Math.max(lds[i], lds[j]+1);
//				}
			}
			
		}
		for (int i=n-2;i>=0;i--) {
			for (int j=n-1;j>i;j--) {
				if (arr[i]>arr[j]) {
					lds[i]=Math.max(lds[i], lds[j]+1);
				}
			}
		}
		int maxa=lis[0]+lds[0]-1;
		for (int i=1;i<n;i++) {
			int yo=lds[i]+lis[i]-1;
			if (yo>maxa) {
				maxa=yo;
			}
		}
		return maxa;
	}
}
