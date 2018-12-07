
public class BinomialCoefficients { //ncr in O(n*r)
	public static void main(String[] args) {
		BinomialCoefficients bc = new BinomialCoefficients(5, 2);
		System.out.println(bc.giveNcrBotUp());
		System.out.println(bc.goveNcrRecur());
		System.out.println(bc.giveNcrEffBotUp());
	}
	
	int dparBotUpEff[];
	int n;
	int r;
	int dparr[][];
	int dparrBotUp[][];
	public BinomialCoefficients(int n, int r) {
		this.n=n;
		this.r=r;
		
	}
	public int giveNcrBotUp() {
		this.dparrBotUp= new int[n+1][r+1];
		for (int i=0;i<=n;i++) {
			for (int j=0;j<=Math.min(i,r);j++) {
				//System.out.println(i+" "+j);
				if (j==0 || i==j) {
					dparrBotUp[i][j]=1;
				}else {
					dparrBotUp[i][j]=dparrBotUp[i-1][j-1]+ dparrBotUp[i-1][j];
				}
			}
		}
	return dparrBotUp[n][r];
	}
	public int goveNcrRecur() {
		this.dparr = new int[n+1][r+1];
		for (int i=0;i<=n;i++) {
			for (int j=0;j<=r;j++) {
				dparr[i][j]=-1;
			}
		}
		return giveNcrRecurIns(n, r);
		
	}
	private int giveNcrRecurIns(int n, int r) {
		if (r==0 || n==r) {
			dparr[n][r]=1;
			return 1;
		}
		
		
		if (dparr[n][r]==-1) {
			dparr[n][r]=giveNcrRecurIns(n-1, r-1)+giveNcrRecurIns(n-1, r);
			return dparr[n][r];
		}
		else {
			return dparr[n][r];
		}
	}
	public int giveNcrEffBotUp() { // idk how this shit is working?
		this.dparBotUpEff=new int[r+1];
		dparBotUpEff[0]=1;
		for (int i=1;i<=n;i++) {
			for (int j=Math.min(i, r);j>0;j--) {
				dparBotUpEff[j]=dparBotUpEff[j]+dparBotUpEff[j-1];
			}
		}
		return dparBotUpEff[r];
		
	}
}
