
public class KnapSack01 {
	public static void main(String[] args) {
		int par[]= {0,1,2,5,6}; // make array 0 element as 0
		int war[] = {0,2,3,4,5};// make array 0 element as 0
		int n=4+1;
		int w=8+1;
		KnapSack01 ks = new KnapSack01(par, war, n, w);
		System.out.println(ks.giveMaxProfitrecur());
		System.out.println(ks.giveMaxProfit());
		int ar[]= ks.whichItems();
		for (int i:ar) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	int selectar[];
	int weightar[];
	int profitar[];
	int w; // max weight.
	int n; // no of objects.
	int dparr[][];
	int dparrrecur[][];
	int flag=0;
	public KnapSack01(int par[], int war[], int n, int w) { // give n as no of elements +1 // give weight as max weight +1
		this.profitar=par;
		this.weightar=war;
		this.n=n;
		this.w=w;
		this.dparr= new int [n][w];
		
	}
	public int giveMaxProfit() {
		this.dparr= new int [n][w];
		for (int i=1;i<n;i++) {
			for (int j=1;j<w;j++) {
				if (weightar[i]>j) {
					dparr[i][j]=dparr[i-1][j];
				}else {
					dparr[i][j]=Math.max(dparr[i-1][j], profitar[i]+dparr[i-1][j-weightar[i]]);
				}
			}
		}
		flag=1;
		return dparr[n-1][w-1];
	}
	public int[] whichItems() {
		this.selectar = new int[n];
		if (flag==0) {
			giveMaxProfit();
		}
		int i=n-1;
		int j=w-1;
		while (i>0 && j>0) {
			if (dparr[i][j]==dparr[i-1][j]) {
				i=i-1;
			}else {
				selectar[i]=1;
				
				j=j-weightar[i];
				i=i-1;
			}
		}
		
		return selectar; // ignore 0th index. items selected or not is seen from index 1. 
	}
	public int giveMaxProfitrecur() {
		this.dparrrecur=new int [n][w];
		for (int i=0;i<n;i++) {
			for (int j=0;j<w;j++) {
				dparrrecur[i][j]=-1;
			}
		}
		return giveMaxProfitRecur(this.w-1,this.n-1);
	}
	private int giveMaxProfitRecur(int w,int n) {
		//System.out.println(n);
		if (dparrrecur[n][w]!=-1) {
			return dparrrecur[n][w];
		}
		if (n==0 || w==0) {
			dparrrecur[n][w]=0;
			return 0;
		}
		else {
			if (weightar[n]>w) {
				dparrrecur[n][w]=giveMaxProfitRecur(w, n-1);
				//return giveMaxProfitRecur(w, n-1);
				return dparrrecur[n][w];
			}
			else {
				dparrrecur[n][w]=Math.max(giveMaxProfitRecur(w, n-1),profitar[n]+giveMaxProfitRecur(w-weightar[n], n-1) );
				//return Math.max(giveMaxProfitRecur(w, n-1),profitar[n]+giveMaxProfitRecur(w-weightar[n], n-1) );
				return dparrrecur[n][w];
			}
		}
	}
	
}












