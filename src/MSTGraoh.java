public class MSTGraoh {

	public edge edgeArr[];
	edge MSTArr[];
	int v;
	int e;
	int curr;
	int ind;

	public MSTGraoh(int v, int e) {
		this.v = v;
		this.e = e;
		edgeArr = new edge[e];
		MSTArr = new edge[v - 1];
		curr = 0;
		ind = 0;
	}

	public void addEdge(int i, int j, int w) {
		edge yo = new edge(i, j, w);
		edgeArr[curr] = yo;
		curr++;
	}

	public edge[] kruskal() {
		mergesort(this.edgeArr, 0, this.e - 1);
		DisjointSetMST ds = new DisjointSetMST();
		ds.makesetBySize(this.v);
		for (int i = 0; i < this.e; i++) {
			int curi = edgeArr[i].i;
			int curj = edgeArr[i].j;

			if (ds.findBySizePathCompression(curi) != ds.findBySizePathCompression(curj)) {
				ds.unionBySize(curi, curj);
				MSTArr[ind] = edgeArr[i];
				if (ind == this.v - 1)
					break;
				ind++;

			}
		}
		return MSTArr;
	}

	public void mergesort(edge arr[], int low, int high) {// give low=0, high =len-1 while calling this function.
		if (low < high) {
			int mid = (high + low) / 2;
			mergesort(arr, low, mid);
			mergesort(arr, mid + 1, high);
		}
		int range = high - low + 1;
		int j;
		int mid;
		if (range % 2 == 0) {
			j = (range / 2);
			mid = (range / 2) - 1;
		} else {
			j = (range / 2) + 1;
			mid = (range / 2);
		}
		int i = 0;
		int k = low;
		edge aux[] = new edge[range];
		for (int p = 0; p < range; p++) {
			aux[p] = arr[low + p];
		}
		while (i <= mid && j < range) {
			if (aux[i].w <= aux[j].w) {
				arr[k] = aux[i];
				i++;
			} else {
				arr[k] = aux[j];
				j++;
			}
			k++;
		}
		while (i <= mid) {
			arr[k] = aux[i];
			k++;
			i++;
		}
		while (j < range) {
			arr[k] = aux[j];
			k++;
			j++;
		}

	}

}

class DisjointSetMST {
	public int[] arr;
	public int size;

	public void makesetBySize(int size) {
		this.size = size;
		this.arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = -1;
		}
	}

	public int findBySizePathCompression(int x) {
		if (x < 0 || x >= size) {
			return Integer.MIN_VALUE;
		} else {
			if (arr[x] < 0) {
				return x;
			} else {
				return arr[x] = findBySizePathCompression(arr[x]);
			}
		}
	}

	public void unionBySize(int a, int b) {
		int fa = findBySizePathCompression(a);
		int fb = findBySizePathCompression(b);
		if (a >= size || b >= size || a < 0 || b < 0) {
			return;
		}
		if (fa == fb) {
			return;
		} else {
			if (arr[fb] < arr[fa]) { // doubt wtf is this??
				arr[fb] += arr[fa];
				arr[fa] = fb;
			} else {

				arr[fa] += arr[fb];
				arr[fb] = fa;
			}
		}
	}

}

class edge {
	int i;
	int j;
	int w;

	public edge() {

	}

	public edge(int i, int j, int w) {
		this.i = i;
		this.j = j;
		this.w = w;
	}
}
