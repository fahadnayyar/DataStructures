
public class MaxIncSubSeqSum {
	public static void main(String[] args) {
		//int arr[]= {1,101,2,3,100,4};
		int arr[] = {10,5,4,3};
		MaxIncSubSeqSum ms = new MaxIncSubSeqSum(arr.length, arr);
		System.out.println(ms.GiveMaxSum());
	}
	int arr[];
	int lis[];
	int n;
	public MaxIncSubSeqSum(int n, int arr[]) {
		this.arr=arr;
		this.n=n;
	}
	public int GiveMaxSum() {
		this.lis= new int[n];
		for (int i=0;i<n;i++) {
			lis[i]=arr[i];
		}
		int glmax=Integer.MIN_VALUE;
		
		for (int i=0;i<n;i++) {
			for (int j=0;j<i;j++) {
				if (arr[i]>=arr[j] && lis[i]<lis[j]+arr[i]) {
					lis[i]=lis[j]+arr[i];
				}
			}
			if (glmax<lis[i]) {
				glmax=lis[i];
			}
		//System.out.print(lis[i]+" ");
		}
		//System.out.println();
		return glmax;
	}
}
