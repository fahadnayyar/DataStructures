
public class MinCoins {
	public static void main(String[] args) {
		int carr[] = { 9,6,5,1 };
		int v = 11;
		MinCoins mc = new MinCoins(v, carr, 4);
		System.out.println(mc.GiveMinCoinrecur());
		System.out.println(mc.giveMinCoinBotUp());
	}

	int coinar[];
	int dparr[];
	int dparBotUp[];
	int v;
	int n;

	public MinCoins(int v, int arr[], int n) {
		this.n = n;
		this.v = v;
		this.coinar = arr;
	}

	public int GiveMinCoinrecur() {
		this.dparr = new int[v + 1];
		for (int i = 0; i <= v; i++) {
			dparr[i] = -1;
		}
		return GiveMinCoinRecur(this.v);
	}

	private int GiveMinCoinRecur(int v) {
		if (dparr[v] != -1) {
			return dparr[v];
		}

		if (v == 0) {
			dparr[v] = 0;
			return 0;
		} else {
			int mini = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				if (v >= coinar[i]) {
					int yo;
					if (dparr[v - coinar[i]] != -1) {
						yo = 1 + dparr[v - coinar[i]];
					} else {

						yo = 1 + GiveMinCoinRecur(v - coinar[i]);
						dparr[v - coinar[i]] = yo - 1;
					}

					// int yo = 1+GiveMinCoinRecur(v-coinar[i]);
					if (yo < mini) { // there may be some bug it may be req to check that yo!=Int_Max.
						mini = yo;
					}
				}

			}
			return mini;
		}
	}public int giveMinCoinBotUp() {
		this.dparBotUp = new int[v+1];
		dparBotUp[0]=0;
		for (int i=1;i<=v;i++) {
			dparBotUp[i]=Integer.MAX_VALUE;
		}
		for (int i=1;i<=v;i++) {
			 for (int j=0;j<n;j++){
				if (coinar[j]<=i) {
					int yo = dparBotUp[i-coinar[j]];
					if (yo!=Integer.MAX_VALUE && yo+1<dparBotUp[i]) {
						dparBotUp[i]=yo+1;
					}
				}else {
					
				}
			}
		
		}
		return dparBotUp[v];
	}

}
