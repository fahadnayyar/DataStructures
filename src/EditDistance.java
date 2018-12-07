
public class EditDistance {
	public static void main(String[] args) {
		String a = "abcde";
		String b = "abcd";
		EditDistance ed = new EditDistance(a, b, a.length(), b.length());
		System.out.println(ed.giveMinEdits());
	
	
	}
	
	int m;
	int n;
	String a;
	String b;
	int dparr[][];
	public EditDistance(String a, String b, int m, int n) {
		this.a=a;
		this.b=b;
		this.m=m;
		this.n=n;
				
	}
	public int giveMinEdits() {
		this.dparr = new int[m+1][n+1];
		for (int i=0;i<=m;i++) {
			for (int j=0;j<=n;j++) {
				if (i==0) {
					dparr[i][j]=j;
				}
				else if (j==0) {
					dparr[i][j]=i;
				}
				else if (a.charAt(i-1)==b.charAt(j-1)) {
					dparr[i][j]=dparr[i-1][j-1];
				}
				else {
					dparr[i][j]=1+Math.min(dparr[i-1][j],Math.min(dparr[i][j-1],dparr[i-1][j-1]));
				}
			}
		}
	return dparr[m][n];
	}
}
