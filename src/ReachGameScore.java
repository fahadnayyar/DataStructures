
public class ReachGameScore {
	public static void main(String[] args) {
		int scorear[]= {3,5,10};
		int n=13;
		ReachGameScore rgc = new ReachGameScore(n, scorear.length, scorear);
		System.out.println(rgc.giveWays());
	}
	int dparr[];
	int n; // this is score to reach.
	int scorearr[]; // this array contains types of scores avail.
	int m; // size of score array.
	public ReachGameScore(int n, int m, int arr[]) {
		this.n=n;
		this.m=m;
		this.scorearr=arr;
	}
	public int giveWays() {
		this.dparr= new int[n+1];
		dparr[0]=1;
		for (int i=0;i<m;i++) {
			int score = scorearr[i];
			if(score<=n) {
				for (int j=score;j<=n;j++) {
					dparr[j]+=dparr[j-score];
				}
			}
		}
	return dparr[n];
	}
}
