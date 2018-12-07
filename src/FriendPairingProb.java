
public class FriendPairingProb {
	public static void main(String[] args) {
		FriendPairingProb fp = new FriendPairingProb(3);
		System.out.println(fp.giveNorecur());
		System.out.println(fp.GiveNoBotUp());
	}
	int n;
	int dparrBotUp[];
	int dparr[];
	public FriendPairingProb(int n) {
		this.n=n;
	}
	public int giveNorecur() {
		dparr = new int[n+1];
		for (int i=0;i<=n;i++) {
			dparr[i]=-1;
		}
		return giveNoRecur(n);
	}
	private int giveNoRecur(int n) {
		if (dparr[n]!=-1) {
			return dparr[n];
		}
		if (n==1) {
			dparr[n]=1;
			return 1;
		}
		if (n==2) {
			dparr[n]=2;
			return 2;
		}
		else {
			int yo,ro;
			if (dparr[n-1]!=-1) {
				yo=dparr[n-1];
			}else {
				yo=giveNoRecur(n-1);
				dparr[n-1]=yo;
			}
			if (dparr[n-2]!=-1) {
				ro=dparr[n-2];
				
			}else {
				ro=giveNoRecur(n-2);
				dparr[n-2]=ro;
			}
			
			
			return yo+(n-1)*ro;
		}
	}
	public int GiveNoBotUp() 
	{
		this.dparrBotUp = new int[n+1];
		dparrBotUp[1]=1;
		dparrBotUp[2]=2;
		for (int i=3;i<=n;i++) {
			dparrBotUp[i]=dparrBotUp[i-1]+(i-1)*dparrBotUp[i-2];
		}
	return dparrBotUp[n];
	}
	
}
