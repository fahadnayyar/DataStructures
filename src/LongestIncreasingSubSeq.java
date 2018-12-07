
public class LongestIncreasingSubSeq {
	public static void main(String[] args) {
		int ar[] = {1,2,3,4,5,6,7,8};
		LongestIncreasingSubSeq lis = new LongestIncreasingSubSeq(ar, ar.length);
		System.out.println(lis.giveLISDP());
	}
	
	int lisar[];
	int arr[];
	int n;
	public LongestIncreasingSubSeq(int ar[], int n) {
		this.arr=ar;
		this.n=n;
		
	}
	public int giveLISDP() { //O(n^2 soln.)
		this.lisar=new int[n];
		for (int i=0;i<n;i++) {
			lisar[i]=1;
		}
		for (int i=0;i<n;i++) {
			for (int j=0;j<i;j++) {
				if (arr[j]<=arr[i]) { // for strinctly increasing use < instead of <=
					lisar[i]=Math.max(lisar[i],lisar[j]+1);
				}
			}
		}
		return lisar[n-1];
	}
}
