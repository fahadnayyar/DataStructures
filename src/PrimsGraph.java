class PrimsGraph {

	linkedListPrims vertexarr[];
	int size;

	public PrimsGraph(int size) {
		this.size = size;
		this.vertexarr = new linkedListPrims[size];
		for (int i = 0; i < size; i++) {
			vertexarr[i] = new linkedListPrims();
			vertexarr[i].d = Integer.MAX_VALUE;
			vertexarr[i].flag = 0;
		}
		vertexarr[0].d = 0;
		vertexarr[0].flag = 1;
	}

	public void addEdge(int i, int j, int w) {
		NodePrims yo = new NodePrims();
		yo.vertexNo = j;
		yo.weight = w;
		vertexarr[i].insert(yo);
	}

	public primedge[] primsAlgo() {
		int iind = 0;
		primedge ans[] = new primedge[(this.size - 1)];
		heapMinPrims pq = new heapMinPrims(this.size);

		while (!pq.isEmpty()) {

			vertex yo = pq.ExtractMin();
			vertexarr[yo.vertexno].flag = 1;
			if (yo.vertexno != 0) {
				primedge edge = new primedge();
				edge.i = vertexarr[yo.vertexno].parent;
				edge.j = yo.vertexno;
				edge.w = yo.d;
				ans[iind] = edge;
				iind++;

			}

			NodePrims bhagg = vertexarr[yo.vertexno].head;

			while (bhagg != null) {
				if (vertexarr[bhagg.vertexNo].flag == 0 && bhagg.weight < vertexarr[bhagg.vertexNo].d) {
					vertexarr[bhagg.vertexNo].d = bhagg.weight;
					vertexarr[bhagg.vertexNo].parent = yo.vertexno;
					pq.decrease(bhagg.vertexNo, bhagg.weight);

				}
				bhagg = bhagg.next;
			}
		}

		return ans;
	}
}

class linkedListPrims {
	NodePrims tail;
	int parent;
	int flag;
	int d;
	NodePrims head;

	public void insert(NodePrims yo) {
		if (this.head == null) {
			head = yo;
			tail = yo;
			return;
		} else {
			// NodePrims bhagg = head;
			// while (bhagg.next != null) {
			// bhagg = bhagg.next;
			// }
			// bhagg.next = yo;
			tail.next = yo;
			tail = yo;
		}
	}
}

class NodePrims {
	int vertexNo;
	NodePrims next;
	int weight;
}

class heapMinPrims {
	vertex heaparr[];
	int size;
	int indexarr[];

	public heapMinPrims(int cap) {
		heaparr = new vertex[cap];
		size = cap;
		indexarr = new int[cap];
		vertex root = new vertex();
		root.d = 0;
		root.flag = 1;
		root.vertexno = 0;
		heaparr[0] = root;
		for (int i = 1; i < cap; i++) {
			vertex yo = new vertex();
			yo.d = Integer.MAX_VALUE;
			yo.flag = 0;
			yo.vertexno = i;
			heaparr[i] = yo;
		}
		for (int i = 0; i < cap; i++) {
			indexarr[i] = i;
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int giveSize() {
		return size;
	}

	public void printMinHeap() {
		for (vertex i : heaparr) {
			System.out.print(i.vertexno + " ");
		}
		System.out.println();
	}

	public vertex giveMin() {
		if (size <= 0) {
			System.out.println("empty heap");
			return null;
		} else {
			return heaparr[0];
		}

	}

	public vertex ExtractMin() {
		return ExtractMin_ins();
	}

	private vertex ExtractMin_ins() {
		if (this.size <= 0) {
			System.out.println("heap underflow : emoty heap exception");
			return null;
		} else {
			vertex min = heaparr[0];
			indexarr[min.vertexno] = size - 1;
			indexarr[heaparr[size - 1].vertexno] = 0;
			heaparr[0] = heaparr[size - 1];

			heaparr[size - 1] = min;
			heapify_ins(this.heaparr, 0, size - 2);
			size--;
			return min;
		}
	}

	public void heapify(int i) {
		heapify_ins(this.heaparr, i, this.size - 1);
	}

	private void heapify_ins(vertex arr[], int i, int size) {
		int l = (2 * i) + 1;
		int r = (2 * i) + 2;
		int smallest;
		if (l <= size && arr[l].d < arr[i].d) {
			smallest = l;

		} else {
			smallest = i;
		}
		if (r <= size && arr[smallest].d > arr[r].d) {
			smallest = r;
		}
		if (smallest != i) {
			indexarr[arr[i].vertexno] = smallest;
			indexarr[arr[smallest].vertexno] = i;
			vertex temp = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = temp;
			heapify_ins(arr, smallest, size);

		}
	}

	public void decrease(int vertexno, int d) {
		int ind = indexarr[vertexno];
		decreaseIns(ind, d);
	}

	public void decreaseIns(int i, int key) {
		if (i < 0 || i > size - 1) {
			System.out.println("index out of bound");
		} else if (heaparr[i].d <= key) {
			System.out.println("arr element is already smaller than given key");
		} else {
			heaparr[i].d = key;
			while (i > 0 && heaparr[(i - 1) / 2].d > heaparr[i].d) {
				indexarr[heaparr[(i - 1) / 2].vertexno] = i;
				indexarr[heaparr[i].vertexno] = (i - 1) / 2;
				vertex temp = heaparr[i];
				heaparr[i] = heaparr[(i - 1) / 2];
				heaparr[(i - 1) / 2] = temp;
				i = (i - 1) / 2;
			}
		}
	}

}

class vertex {
	int vertexno;
	int d;
	int flag;
	int parent;
}

class primedge {
	int i;
	int j;
	int w;
}
