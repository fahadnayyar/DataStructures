
public class EggDropProb {
	public static void main(String[] args) {
		EggDropProb edp = new EggDropProb(2, 4);
		System.out.println(edp.giveMinTrialsrecur());
		System.out.println(edp.giveMinTrialBottomUp());
	}
	int dparrBotup[][];
	int dparr[][];
	int eggs;
	int floors;
	public EggDropProb(int n, int k) {
		this.eggs=n;
		this.floors=k;
	}
	public int giveMinTrialsrecur() {
		this.dparr= new int[eggs+1][floors+1];
		for (int i=0;i<=eggs;i++) {
			for (int j=0;j<=floors;j++) {
				dparr[i][j]=-1;
			}
		}
		return giveMinTrialsRecur(this.eggs,this.floors);
	}
	private int giveMinTrialsRecur(int n,int k) {
		if (dparr[n][k]!=-1) {
			return dparr[n][k];
		}
		if (k==0 || k==1) {
			dparr[n][k]=k;
			return k;
		}
		if (n==1) {
			dparr[n][k]=k;
			return k;
		}
		int min = Integer.MAX_VALUE;
		for (int x=1;x<=k;x++) {
			int yo,ro;
			if (dparr[n-1][x-1]!=-1) {
				yo=dparr[n-1][x-1];
			}else {
				yo = giveMinTrialsRecur(n-1, x-1);
			}
			if (dparr[n][k-1]!=-1) {
				ro=dparr[n][k-x];
			}else {
				ro = giveMinTrialsRecur(n, k-x);
			}
;
			int bo = Math.max(yo,ro );
			if (bo<min) {
				min=bo;
			}
		}
		return min+1;
	}
	public int giveMinTrialBottomUp() {
		this.dparrBotup= new int[eggs+1][floors+1];
		for (int j=1;j<=floors;j++) {
			dparrBotup[1][j]=j;
		}
		for (int i=1;i<=eggs;i++) {
			dparrBotup[i][0]=0;
			dparrBotup[i][1]=1;
		}
		
		
		
		for (int i=2;i<=eggs;i++) {
			for (int j=2;j<=floors;j++) {
				
				int mini= Integer.MAX_VALUE;
				for (int x=1;x<=j;x++) {
					int yo = 1 + Math.max(dparrBotup[i-1][x-1], dparrBotup[i][j-x]);
					if (yo < mini) {
						mini=yo;
					}
				dparrBotup[i][j]=mini;
				}
				
//				if (i==1) {
//					dparrBotup[i][j]=j;
//				}
//				else if (j==0 | j==1) {
//					dparrBotup[i][j]=j;
//				}
//				else  {
//					int mini= Integer.MAX_VALUE;
//					for (int x=1;x<=j;x++) {
//						int yo = 1 + Math.max(dparrBotup[i-1][x-1], dparrBotup[i][j-x]);
//						if (yo < mini) {
//							mini=yo;
//						}
//					dparrBotup[i][j]=mini;
//					}
//				}
			}
		}
	return dparrBotup[eggs][floors];
	}
}
