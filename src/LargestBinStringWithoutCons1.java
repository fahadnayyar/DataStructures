
public class LargestBinStringWithoutCons1 {
	public static void main(String[] args) {
		LargestBinStringWithoutCons1 l = new LargestBinStringWithoutCons1(2);
		System.out.println(l.GiveLarAns());
		System.out.println(l.GiveAnsrecur());
	}
	//String s;
	int dparBotUp[][];
	int n;
	int ar[];
	int br[];
	public LargestBinStringWithoutCons1(int n) {
		//this.s=s;
		this.n=n;
	}
	public int GiveLarAns() {
		this.ar=new int[n+1]; 
		this.br=new int[n+1];
		ar[1]=br[1]=1;
		for (int i=2;i<=n;i++) {
			ar[i]=ar[i-1]+br[i-1];
			br[i]=ar[i-1];
		}
		return ar[n]+br[n];
	}
	public int GiveAnsrecur() {
		this.dparBotUp = new int[n+1][2];
		for (int i=0;i<=n;i++) {
			for (int j=0;j<2;j++) {
				dparBotUp[i][j]=-1;
			}
		}
		return GiveAnsRecur(n,0)+GiveAnsRecur(n, 1);
	}
	private int GiveAnsRecur(int i,int end) {
		if (dparBotUp[i][end]!=-1) {
			return dparBotUp[i][end];
		}
		if (i==1) {
			dparBotUp[1][end]=1;
			//dparBotUp[1][end]=1;
			return 1;
		}else {
			if (end==0) {
				int yo,ro;
				if (dparBotUp[i-1][0]!=-1) {
					
					yo=dparBotUp[i-1][0];
				}else {
					
					yo=GiveAnsRecur(i-1, 0);
					dparBotUp[i-1][0]=yo;
				}
				if (dparBotUp[i-1][1]!=-1) {
					ro=GiveAnsRecur(i-1, 1);
				}else {
					ro=GiveAnsRecur(i-1, 1);
					dparBotUp[i-1][1]=ro;
				}
				return yo+ro;
			}else {
				int yo;
				if (dparBotUp[i-1][0]!=-1) {
					yo=dparBotUp[i-1][0];
				}else {
					yo=GiveAnsRecur(i-1, 0);
					dparBotUp[i-1][0]=yo;
				}
				
				
				return yo;
			}
			
		}
	}
}
