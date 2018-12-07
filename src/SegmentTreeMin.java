
public class SegmentTreeMin {
//	public static void main(String[] args) {
//	int arr[]= {24,436,-1352,263,-26,3,-46,26,745,3,753};
//	SegmentTreeMin st = new SegmentTreeMin(arr.length, arr);
//	System.out.println(st.Query(1,4 ));
//	System.out.println(st.Query(3, 8));
//	System.out.println(st.Query(7,10 ));
//	System.out.println(st.Query(1,9 ));
//	System.out.println(st.Query(6, 8));
//	System.out.println(st.Query(3,6 ));
//	System.out.println(st.Query(9,9 ));
//	System.out.println(st.Query(3, 7));
//	
//}
	
	public int arr[];
	public int 	segarr[];
	public int n; // size of array whose seg tree is constructed.
	public SegmentTreeMin(int n,int ar[]) {
		this.segarr=new int[(4*n)+1];
		this.n=n;
		this.arr=ar;
		Build();
	}
	
	private void Build() {
		build(arr, 0, n-1, 1);
	}
	private void build(int ar[], int l, int r, int ind) { // ar is the array on which rmq is to be done, l=0,r=n-1.ind=1
		if (l>r) {
			return; 
		}
		if (l==r) {
			segarr[ind]=ar[l];
			return;
		}
		int mid =(l+r)/2;
		build(ar, l, mid, 2*ind );
		build(ar, mid+1, r, 2*ind+1 );
		int left = segarr[2*ind];
		int right = segarr[2*ind+1];
		segarr[ind]=Math.min(left, right);
	}
//	public int givemin(int ql, int qr) {
//		return queryMin(l, r, ind, ql, qr)
//	}
	
	public int Query(int l, int r) {
		return query(0, n-1, 1, l, r);
	}
	private int query(int l, int r, int ind, int ql,int qr) { // ind=1,l=0,r=n-1,ql,qr is related to queries.
		if (ql>r || qr<l) {
			return Integer.MAX_VALUE;
		}
		else {
			if (ql<=l && qr>=r) {
				return segarr[ind];
			}
			else {
				int mid=(l+r)/2;
				int left=query( l, mid, 2*ind, ql, qr);
				int right=query( mid+1, r, 2*ind+1, ql, qr);
				return Math.min(left, right);
			}
		}
	}
	public void Update(int i, int val) {
		update(0, n-1, 1, i, val);
	}
	private void update(int l, int r , int ind, int i , int value) { // i is the index at which this value v is to be updated.
		if (i<l || i > r) {
			return;
		}
		if (l==r) {
			segarr[ind]=value;
			return;
			
		}
		else {
			int mid = (l+r)/2;
			update(l, mid, 2*ind, i, value);
			update(mid+1, r, 2*ind+1, i, value);
			segarr[ind]=Math.min(segarr[2*ind], segarr[2*ind+1]);
			return;
		}
	}
	public void RangeUpdate(int rl, int rr, int inc) {
		rangeUpdate(0, n-1, 1, rl, rr, inc);
	}
	private void rangeUpdate (int l, int r, int ind,int rl, int rr,int inc ) {
		if (rl>r || rr <l) {
			return;
		}
		if (l==r) {
			segarr[ind]=segarr[ind]+inc;
			return;
		}
		else {
			int mid = (l+r)/2; 
			rangeUpdate(l, mid, 2*ind, rl, rr, inc);
			rangeUpdate(mid+1, r, 2*ind+1, rl, rr, inc);
			segarr[ind]=Math.min(segarr[2*ind], segarr[2*ind+1 ]);
		}
	}
}
