
public class MaxSubMatrixWith1 {
	public static void main(String[] args) {
		int arr[][] = {{0,1,1,0,1},{1,1,0,1,0},{0,1,1,1,0},{1,1,1,1,0},{1,1,1,1,1},{0,0,0,0,0}};
		int m=6;
		int n=5;
		MaxSubMatrixWith1 ms1 = new MaxSubMatrixWith1(arr, m, n);
		int ans[] = ms1.GiveMaxMat1();
		System.out.println(ans[0]+" "+ans[1]+" "+ans[2]);
	}
	int matrix[][];
	int n;
	int m;
	int dpmat[][];
	public MaxSubMatrixWith1(int mat[][], int m,int n) {
		this.n=n;
		this.m=m;
		this.matrix=mat;
	}
	public int[] GiveMaxMat1() {
		dpmat = new int[m][n];
		int maxSize=Integer.MIN_VALUE;
		int endi=-1;
		int endj=-1;
		for (int i=0;i<m;i++) {
			dpmat[i][0]=matrix[i][0];
			if (dpmat[i][0]==1) {
				maxSize=1;
				endi=i;
				endj=0;		
			}
		}
		for (int i=0;i<n;i++) {
			//System.out.println(i);
			dpmat[0][i]=matrix[0][i];
			if (dpmat[0][i]==1) {
				maxSize=1;
				endi=0;
				endj=i;		
			}
		}

		for (int i=1;i<m;i++) {
			for (int j=1;j<n;j++) {
				if (matrix[i][j]==1) {
					dpmat[i][j]= Math.min(dpmat[i][j-1], Math.min(dpmat[i-1][j], dpmat[i-1][j-1]))+1;
					if (maxSize<dpmat[i][j]) {
						maxSize=dpmat[i][j];
						endi=i;
						endj=j;
						//System.out.println(endi+" "+endj);
					}
				}else {
					dpmat[i][j]=0;
				}
			//System.out.print(dpmat[i][j]+" ");
			}
		//System.out.println();
		}
	int ret[]= new int[3];
	ret[0] = maxSize;
	ret[1]=endi;
	ret[2]=endj;		
		return ret;
	}
}
