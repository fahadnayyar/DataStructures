
public class LargestPallindromSubString {
	public static void main(String[] args) {
		String s = "geekkeeg";
		LargestPallindromSubString lpss = new LargestPallindromSubString(s, s.length());
		int bhagg[]=lpss.giveLPSSBotup();
		System.out.println(bhagg[0]+" "+bhagg[1]);
		
		
		
	}
	String s;
	int n;
	boolean dparrBotUp[][];
	public LargestPallindromSubString(String s, int n) {
		this.s=s;
		this.n=n;
	}
	public int[] giveLPSSBotup() {
		this.dparrBotUp= new boolean[n][n];
		int maxLen=1;
		int sind=0;
		for (int i=0;i<n;i++) {
			dparrBotUp[i][i]=true;
		}
		for (int i=1;i<n;i++) {
			if (s.charAt(i)==s.charAt(i-1)) {
				dparrBotUp[i-1][i]=true;
				
				
				sind=i-1;
				maxLen=2;
			}
		}
		int j=2;
		int gj=2;
		int i=0;
		while (gj<n) {
			//System.out.println(i+" "+j);
			if (s.charAt(i)==s.charAt(j) && dparrBotUp[i+1][j-1]){
				dparrBotUp[i][j]=true;
				if ((j-i+1)>maxLen) {
					
					
					maxLen=(j-i+1);
					sind=i;
				}
			}
//			else {
//				dparBotUp[i][j]= Math.max( dparBotUp[i][j-1],  dparBotUp[i+1][j])   ;
//			}
			i=i+1;
			j=j+1;
			if (j==n) {
				i=0;
				j=gj+1;
				gj=j;
			}
		}
	int ret[] = {maxLen,sind};
		return ret;
	}
}
