
public class LongestCommonSubsequence {
	public static void main(String[] args) {
		String a= "stone";
		String b="staognze";
		//a=" "+a;
		//b=" "+b;
		//System.out.println(a);
		//System.out.println(b);
		LongestCommonSubsequence lcs = new LongestCommonSubsequence(a, b, a.length(), b.length());
		System.out.println(lcs.giveLength());
		System.out.println(lcs.PrintLcs());
//		for (int i=0;i<=lcs.m;i++) {
//			for(int j=0;j<=lcs.n;j++) {
//				System.out.print(lcs.dparr[i][j]+" ");
//			}
//			System.out.println();
//		}
	}
	
	
	
	String a;
	String b;
	int m;
	int n;
	int dparr[][];
	int flag;
	public LongestCommonSubsequence(String a, String b, int m, int n) {
		this.a=a;
		this.b=b;
		this.m=m;
		this.n=n;
		this.dparr=new int[m+1][n+1];
		this.flag=0;
	}
	public int giveLength() {
		//int i=1;j=1;s
		for (int i=1;i<m+1;i++) {
			for (int j=1;j<n+1;j++) {
				//System.out.println(a.charAt(i)+" "+b.charAt(j));
				if (a.charAt(i-1)==b.charAt(j-1)) {
					//System.out.println(a.charAt(i)+" "+b.charAt(j));
					//System.out.println(dparr[i-1][j-1]);
					dparr[i][j]=dparr[i-1][j-1]+1;
				}else {
					dparr[i][j]=Math.max(dparr[i-1][j], dparr[i][j-1]);
				}
				
			}
		}
	this.flag=1;
		return dparr[m][n];
	}
	public String PrintLcs() {
		if (this.flag==0) {
			giveLength();
		}
		int i=m;
		int j=n;
		String s="";
		while (i>0 && j>0) {
			if (dparr[i][j]==dparr[i-1][j]) {
				i=i-1;
			}
			else if (dparr[i][j]==dparr[i][j-1]) {
				j=j-1;
			}
			else {
				//String yo=(String)a.charAt(i);
				s=a.charAt(i-1)+s;
				//s.concat(str)
				//s.concat(a.charAt(i));
				i=i-1;
				j=j-1;
			}
		}
	return s;
	}
}
