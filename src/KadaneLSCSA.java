
public class KadaneLSCSA {
	public static void main(String[] args) {
		int arr[] = {-2,-3,4-1,-2,1,5,-3};
		KadaneLSCSA ka = new KadaneLSCSA(arr, arr.length);
		System.out.println(ka.giveLSCSA());
		System.out.println(ka.giveLSCSAAllNeg());
	}
	
	int arr[];
	int n;
	public KadaneLSCSA(int arr[], int n) {
		this.arr=arr;
		this.n=n;
	}
	public int giveLSCSA() {
		int glmax=0;
		int curmax=0;
		for (int i=0;i<n;i++) {
			curmax=curmax+arr[i];
			if (curmax<0) {
				curmax=0;
			}else if (glmax<curmax){
				glmax=curmax;
			}
			
		}
	return glmax;
	}
	public int giveLSCSAAllNeg() {
		int glmax=arr[0];
		int curmax=arr[0];
		for (int i=1;i<n;i++) {
			curmax = Math.max(arr[i], curmax+arr[i]);
			glmax=Math.max(curmax, glmax);
		}
	return glmax;
	}
}
