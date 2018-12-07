
public class FibonacciNums {
	public static void main(String[] args) {
		FibonacciNums fn = new FibonacciNums();
		
		System.out.println(fn.recursive(3, 3, 4));
		System.out.println(fn.RecursiveMemorized(3, 3, 4));
		System.out.println(fn.bottomUp(3, 3, 4));
		System.out.println(fn.bottomUpEfficient(3, 3, 4));
	}
	int recursetable[];
	int bottomUpTable[];
	public FibonacciNums() {
	
	}
	public int recursive(int n, int i0, int i1) {
		if (n==1) {
			return i0;
		}
		else if (n==2){
			return i1;
		}
		else {
			return recursive(n-1, i0, i1)+recursive(n-2, i0, i1);
		}
	}
	public int RecursiveMemorized(int n, int i0, int i1) {
		this.recursetable = new int[n+1];
		for (int i=0;i<n+1;i++) {
			recursetable[i]=-1;
		}
		return recurciveMenorized(n, i0, i1);
	}
	private int recurciveMenorized(int n, int i0, int i1) {
		if (recursetable[n]!=-1){
			return recursetable[n];
		}
		else if (n ==1) {
			recursetable[n]=i0;
			return i0;
		}
		else if (n==2) {
			recursetable[n]=i1;
			return i1;
		}
		else{
			recursetable[n]=recurciveMenorized(n-1, i0, i1)+recurciveMenorized(n-2, i0, i1);
			return recursetable[n];
		}
	}
	public int bottomUp(int n, int i0, int i1) {
		this.bottomUpTable = new int[n+1];
		bottomUpTable[1]=i0;
		bottomUpTable[2]=i1;
		for (int i=3;i<=n;i++) {
			bottomUpTable[i]=bottomUpTable[i-1]+bottomUpTable[i-2];
		}
		return bottomUpTable[n];
	}
	public int bottomUpEfficient(int n, int i0, int i1) {
		int i=i0;
		int j=i1;
		for (int yo=0;yo<n-2;yo++) {
			int k = i+j;
			i=j;
			j=k;
		}
		return j;
	}

}
