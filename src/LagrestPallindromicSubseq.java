
public class LagrestPallindromicSubseq {
	public static void main(String[] args) {
		String s  = "babcbab";
		LagrestPallindromicSubseq lp = new LagrestPallindromicSubseq(s, s.length());
		System.out.println(lp.GiveLPSSrecur());
		System.out.println(lp.giveLPSSBotUp());
	}
	int dparBotUp[][];
	int dparr[][];
	String s;
	int n;
	public LagrestPallindromicSubseq(String s,int len) {
		this.s=s;
		this.n=len;
	}
	public int GiveLPSSrecur() {
		this.dparr=new int[n][n];
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				dparr[i][j]=-1;			}
		}
		return GiveLPSSRecur(0, n-1);
	}
	
	private int GiveLPSSRecur(int l, int r) {
		if (dparr[l][r]!=-1) {
			return dparr[l][r];
		}
		if (l==r) {
			dparr[l][r]=1;
			return 1;
		}
		if (l>r) {
			dparr[l][r]=0;
			return 0;
		}
		if (s.charAt(l)==s.charAt(r)){
			int yo;
			if (dparr[l+1][r-1]!=-1) {
				yo=dparr[l+1][r-1];
			}else {
				yo = GiveLPSSRecur(l+1, r-1);
			}
			return 2+yo;
			//return 2+GiveLPSSRecur(l+1, r-1);
		}
		else {
			int yo,ro;
			if (dparr[l+1][r]!=-1) {
				yo=dparr[l+1][r];
			}
			else {
				yo=GiveLPSSRecur(l+1, r);
			}
			if (dparr[l][r-1]!=-1) {
				ro = dparr[l][r-1];
			}
			else {
				ro=GiveLPSSRecur(l, r-1);
			}
			return Math.max(yo, ro);
			
			//return Math.max(GiveLPSSRecur(l+1, r),GiveLPSSRecur(l, r-1) );
		}
	}
	public int giveLPSSBotUp() {
		this.dparBotUp= new int[n][n];
		for (int i=0;i<n;i++) {
			dparBotUp[i][i]=1;
			
		}
		int j=1;
		int gj=1;
		int i=0;
		while (gj<n) {
			//System.out.println(i+" "+j);
			if (s.charAt(i)==s.charAt(j)){
				dparBotUp[i][j]=dparBotUp[i+1][j-1]+2;
			}else {
				dparBotUp[i][j]= Math.max( dparBotUp[i][j-1],  dparBotUp[i+1][j])   ;
			}
			i=i+1;
			j=j+1;
			if (j==n) {
				i=0;
				j=gj+1;
				gj=j;
			}
		}
	return dparBotUp[0][n-1];
	}
}
