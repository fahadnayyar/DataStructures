
//4 4
//1 4 4
//1 2 2
//2 4 1
//1 3 3

import java.beans.Visibility;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.text.html.MinimalHTMLWriter;

public class GraphList {

	boolean cycle;
	int dijkstraDIstarr[];
	int dijkstraParentarr[];
	int dijkstraVisitarr[];
	private int vertexNo;
	private LindekListAdj  arrVertex[];
	int dfstime;
	int bfsvisitArr[];
	int bfsDistArr[];
	int bipartitearr[];
	boolean bipartite;

	public GraphList(int size) {
		this.cycle = false;
		this.bipartite = true;
		this.vertexNo = size;
		this.arrVertex = new LindekListAdj[size];
		for (int i = 0; i < size; i++) {
			arrVertex[i] = new LindekListAdj();
		}
		this.bfsvisitArr = new int[this.vertexNo];
		this.bfsDistArr = new int[this.vertexNo];
		for (int i = 0; i < this.vertexNo; i++) {
			this.bfsDistArr[i] = Integer.MAX_VALUE;
		}
		this.bipartitearr = new int[this.vertexNo];
	}

	public void addEdge(int i, int j, int w) {
		NodeAdj yo = new NodeAdj();
		yo.vertexNo = j;
		yo.weight = w;
		arrVertex[i].insert(yo);
	}

	public int[][] bfs(int i) {
		int vis[] = this.bfsvisitArr;
		vis[i] = 1;

		int distarr[] = this.bfsDistArr;
		ArrayList<Integer> queue = new ArrayList();
		int trial = 0;
		distarr[i] = trial;

		// for (int p = 0; p < this.vertexNo; p++) {
		// distarr[p] = Integer.MAX_VALUE;
		// }
		queue.add(i);
		while (!queue.isEmpty()) {
			int yo = queue.remove(0);
			trial = distarr[yo] + 1;
			NodeAdj ro = this.arrVertex[yo].head;
			while (ro != null) {
				if (vis[ro.vertexNo] == 0) {
					queue.add(ro.vertexNo);
					vis[ro.vertexNo] = 1;
					distarr[ro.vertexNo] = trial;
				}
				ro = ro.next;
			}
		}
		int bhagg[][] = new int[2][this.vertexNo];
		bhagg[0] = vis;
		bhagg[1] = distarr;
		return bhagg;

	}

	public dijvertex[] topologicalSort() {
		int bhagg[][] = dfs();
		int finarr[] = bhagg[2];
		dijvertex re[] = new dijvertex[this.vertexNo];
		for (int i = 0; i < this.vertexNo; i++) {
			dijvertex yo = new dijvertex();
			yo.dist = finarr[i];
			yo.vertexNo = i;
			re[i] = yo;

		}
		mergesort(re, 0, this.vertexNo - 1);
		return re;
	}

	public static void mergesort(dijvertex arr[], int low, int high) {// give low=0, high =len-1 while calling this
																		// function.
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
		// int mid = (high + low) / 2;
		// int i = low;
		// int j = mid + 1;
		int l = arr.length;
		int k = low;
		dijvertex aux[] = new dijvertex[range];
		for (int p = 0; p < range; p++) {
			aux[p] = arr[low + p];
		}
		while (i <= mid && j < range) {
			if (aux[i].dist <= aux[j].dist) {
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
		// comment maarna hai
		// if (high == low) {
		//
		// } else {
		// for (int f = low; f <= high; f++) {
		// System.out.print(arr[f] + " ");
		// }
		// System.out.println();
		// }
		// yaha tak

	}

	public int[][] dfs() {
		this.dfstime = 0;
		int colorarr[] = new int[this.vertexNo];
		int discoveryarr[] = new int[this.vertexNo];
		int finalarr[] = new int[this.vertexNo];
		for (int i = 0; i < this.vertexNo; i++) {
			if (colorarr[i] == 0) {
				bipartitearr[i] = 1;
				dfsvisit(i, colorarr, discoveryarr, finalarr);
			}
		}
		int re[][] = new int[3][this.vertexNo];
		re[0] = colorarr;
		re[1] = discoveryarr;
		re[2] = finalarr;

		return re;

	}

	public void dfsvisit(int i, int colorarr[], int discoveryarr[], int finalarr[]) {
		colorarr[i] = 1; // marking grey
		dfstime++;
		discoveryarr[i] = dfstime;
		NodeAdj yo = this.arrVertex[i].head;

		while (yo != null) {
			if (bipartitearr[yo.vertexNo] == bipartitearr[i]) {
				bipartite = false;
			}
			if (colorarr[yo.vertexNo] == 1) {
				// System.out.println(colorarr[yo.vertexNo]);
				this.cycle = true;
			}
			if (colorarr[yo.vertexNo] == 0) {

				if (bipartitearr[i] == 1) {
					bipartitearr[yo.vertexNo] = 2;
				} else {
					bipartitearr[yo.vertexNo] = 1;
				}
				dfsvisit(yo.vertexNo, colorarr, discoveryarr, finalarr);
			}
			yo = yo.next;
		}
		colorarr[i] = 2; // marking black
		dfstime++;
		finalarr[i] = dfstime;
	}

	public int[][] dijkstraDense(int i) {
		this.dijkstraDIstarr = new int[this.vertexNo];
		this.dijkstraParentarr = new int[this.vertexNo];
		this.dijkstraVisitarr = new int[this.vertexNo];
		for (int j = 0; j < this.vertexNo; j++) {
			dijkstraDIstarr[j] = Integer.MAX_VALUE;
		}
		for (int j = 0; j < this.vertexNo; j++) {
			dijkstraParentarr[j] = -1;
		}
		dijkstraDIstarr[i] = 0;
		// dijkstraVisitarr[i] = 1;

		for (int p = 0; p < this.vertexNo; p++) {
			int min = Integer.MAX_VALUE;
			int minver = 0; // crucial -1 pe katega!
			for (int j = 0; j < this.vertexNo; j++) {
				if (dijkstraDIstarr[j] < min && dijkstraVisitarr[j] == 0) {
					min = dijkstraDIstarr[j];
					minver = j;
				}

			}
			// System.out.println(minver);
			dijkstraVisitarr[minver] = 1;
			NodeAdj yo = this.arrVertex[minver].head;
			while (yo != null) {
				if (dijkstraVisitarr[yo.vertexNo] == 0) {
					if (dijkstraDIstarr[yo.vertexNo] > yo.weight + dijkstraDIstarr[minver]) {
						dijkstraDIstarr[yo.vertexNo] = yo.weight + dijkstraDIstarr[minver];
						dijkstraParentarr[yo.vertexNo] = minver;
					}
				}
				yo = yo.next;
			}
		}

		int re[][] = new int[2][this.vertexNo];
		re[0] = dijkstraDIstarr;
		re[1] = dijkstraParentarr;
		return re;
	}

	public int[][] dijkstraSparse(int i) {
		this.dijkstraDIstarr = new int[this.vertexNo];
		this.dijkstraParentarr = new int[this.vertexNo];
		this.dijkstraVisitarr = new int[this.vertexNo];
		for (int j = 0; j < this.vertexNo; j++) {
			dijkstraDIstarr[j] = Integer.MAX_VALUE;
		}
		for (int j = 0; j < this.vertexNo; j++) {
			dijkstraParentarr[j] = -1;
		}
		BinaryMinHeapArrayDij pq = new BinaryMinHeapArrayDij(this.vertexNo);
		pq.decreasekar(i, 0);

		dijkstraDIstarr[i] = 0;
		dijkstraVisitarr[i] = 1;

		while (pq.giveSize() != 0) {
			dijvertex min = pq.ExtractMin();
			int minver = min.vertexNo;

			// System.out.println("hi");
			dijkstraVisitarr[minver] = 1;
			NodeAdj yo = this.arrVertex[minver].head;
			while (yo != null) {
				if (dijkstraVisitarr[yo.vertexNo] == 0) {
					if (dijkstraDIstarr[yo.vertexNo] > yo.weight + dijkstraDIstarr[minver]) {
						dijkstraDIstarr[yo.vertexNo] = yo.weight + dijkstraDIstarr[minver];
						dijkstraParentarr[yo.vertexNo] = minver;
						pq.decreasekar(yo.vertexNo, yo.weight + dijkstraDIstarr[minver]);
					}
				}
				yo = yo.next;
			}

		}

		int re[][] = new int[2][this.vertexNo];
		re[0] = dijkstraDIstarr;
		re[1] = dijkstraParentarr;
		return re;
	}

}

class NodeAdj {
	int vertexNo;
	int weight;
	NodeAdj next;
}

class LindekListAdj {
	int size;
	NodeAdj head;
	NodeAdj tail;

	public void insert(NodeAdj bhagg) {
		// NodeAdj yo = head;
		if (this.head == null) {
			head = bhagg;
			tail = bhagg;
			size++;
			return;
		}
		tail.next = bhagg;
		tail = bhagg;
		size++;
	}

	public boolean isPresent(int ver) {
		if (this.head == null) {
			return false;
		}
		NodeAdj yo = head;
		while (yo != null) {
			if (yo.vertexNo == ver) {
				return true;
			}
			yo = yo.next;
		}
		return false;
	}
}

class BinaryMinHeapArrayDij {
	int indarr[];
	dijvertex heaparr[];
	int size;

	public BinaryMinHeapArrayDij(int cap) {
		heaparr = new dijvertex[cap];
		for (int j = 0; j < cap; j++) {
			dijvertex yo = new dijvertex();
			yo.vertexNo = j;
			yo.dist = Integer.MAX_VALUE;
			heaparr[j] = yo;
		}
		size = cap;
		indarr = new int[cap];
		for (int j = 0; j < cap; j++) {
			indarr[j] = j;
		}

	}

	public int giveSize() {
		return size;
	}

	public void printMinHeap() {
		for (dijvertex i : heaparr) {
			System.out.print(i.vertexNo + " ");
		}
		System.out.println();
	}

	public dijvertex giveMin() {
		if (size <= 0) {
			System.out.println("empty heap");
			return null;
		} else {
			return heaparr[0];
		}

	}

	public dijvertex ExtractMin() {
		return ExtractMin_ins();
	}

	private dijvertex ExtractMin_ins() {
		if (this.size <= 0) {
			System.out.println("heap underflow : emoty heap exception");
			return null;
		} else {

			dijvertex min = heaparr[0];
			indarr[min.vertexNo] = size - 1;
			indarr[heaparr[size - 1].vertexNo] = 0;
			heaparr[0] = heaparr[size - 1];
			heaparr[size - 1] = null;
			heapify_ins(this.heaparr, 0, size - 2);
			size--;
			return min;
		}
	}

	public void heapify(int i) {
		heapify_ins(this.heaparr, i, this.size - 1);
	}

	private void heapify_ins(dijvertex arr[], int i, int size) {
		int l = (2 * i) + 1;
		int r = (2 * i) + 2;
		int smallest;
		if (l <= size && arr[l].dist < arr[i].dist) {
			smallest = l;

		} else {
			smallest = i;
		}
		if (r <= size && arr[smallest].dist > arr[r].dist) {
			smallest = r;
		}
		if (smallest != i) {
			indarr[arr[i].vertexNo] = smallest;
			indarr[arr[smallest].vertexNo] = i;
			dijvertex temp = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = temp;
			heapify_ins(arr, smallest, size);
		}
	}

	public void decreasekar(int i, int key) {
		decrease(indarr[i], key);
	}

	public void decrease(int i, int key) {
		if (i < 0 || i > size - 1) {
			System.out.println("index out of bound");
		} else if (heaparr[i].dist <= key) {
			System.out.println("arr element is already smaller than given key");
		} else {
			heaparr[i].dist = key;
			while (i > 0 && heaparr[(i - 1) / 2].dist > heaparr[i].dist) {
				indarr[heaparr[(i - 1) / 2].vertexNo] = i;
				indarr[heaparr[i].vertexNo] = (i - 1) / 2;
				dijvertex temp = heaparr[i];
				heaparr[i] = heaparr[(i - 1) / 2];
				heaparr[(i - 1) / 2] = temp;
				i = (i - 1) / 2;
			}
		}
	}

}

class dijvertex {
	int vertexNo;
	int dist;
}
