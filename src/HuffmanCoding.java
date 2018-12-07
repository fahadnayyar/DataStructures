
public class HuffmanCoding {
	public huffmanNode buildHuffmanTree(char letters[], int freq[], int n) {
		huffmanMinHeap pq = new huffmanMinHeap(n);
		huffmanNode arrr[] = new huffmanNode[n];
		for (int i=0;i<n;i++) {
			huffmanNode yo = new huffmanNode();
			yo.freq=freq[i];
			yo.data=letters[i];
			arrr[i]=yo;
		}
		pq.buildMinHeap(arrr);
		pq.heaparr=arrr;
		while (pq.size!=1) {
			huffmanNode child1 = pq.ExtractMin();
			huffmanNode child2 = pq.ExtractMin();
			huffmanNode inter = new huffmanNode();
			inter.left=child1;
			inter.right=child2;
			inter.freq=child1.freq+child2.freq;
			inter.data='#';
			pq.insert(inter);
		
		}
		return pq.ExtractMin();
	}
	public codeNode[] givecode(huffmanNode root,int n) {
		codeNode[] re = new codeNode[n];
		giveCodesins(root,'',re);
	}
	public void giveCodesins(huffmanNode root,String s,codeNode re[]) {
		
		if (root.left==null && root.right==null) {
			codeNode yo = new codeNode();
			yo.code=s;
			yo.data=root.data;
			re[]
			
		}
	}
	
}

class huffmanNode {
	char data;
	int freq;
	huffmanNode left;
	huffmanNode right;
}
class codeNode{
	char data;
	String code;
}

class huffmanMinHeap {
	huffmanNode heaparr[];
	int size;
	public boolean isEmpty() {
		return size==0;
	}
	public huffmanMinHeap(int cap) {
		//heaparr = new huffmanNode[cap];
		size = 0;
	}

	



	public  huffmanNode ExtractMin() {
		return ExtractMin_ins();
	}

	private huffmanNode ExtractMin_ins() {
		if (this.size <= 0) {
			System.out.println("heap underflow : emoty heap exception");
			return null;
		} else {
			huffmanNode min = heaparr[0];
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

	private void heapify_ins(huffmanNode arr[], int i, int size) {
		int l = (2 * i) + 1;
		int r = (2 * i) + 2;
		int smallest;
		if (l <= size && arr[l].freq < arr[i].freq) {
			smallest = l;

		} else {
			smallest = i;
		}
		if (r <= size && arr[smallest].freq > arr[r].freq) {
			smallest = r;
		}
		if (smallest != i) {
			huffmanNode temp = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = temp;
			heapify_ins(arr, smallest, size);
		}
	}

	public void buildMinHeap(huffmanNode arr[]) {
		int l = arr.length;
		for (int i = (l / 2); i >= 0; i--) {
			heapify_ins(arr, i, l - 1);
		}
	}

	public void decrease(int i, int key) {
		if (i < 0 || i > size - 1) {
			System.out.println("index out of bound");
		} else if (heaparr[i].freq <= key) {
			System.out.println("arr element is already smaller than given key");
		} else {
			heaparr[i].freq = key;
			while (i > 0 && heaparr[(i - 1) / 2].freq > heaparr[i].freq) {
				huffmanNode temp = heaparr[i];
				heaparr[i] = heaparr[(i - 1) / 2];
				heaparr[(i - 1) / 2] = temp;
				i = (i - 1) / 2;
			}
		}
	}

	public void insert(huffmanNode key) {
		if (size > heaparr.length - 1) {
			System.out.println("heap overflow");
		} else {
			size++;
			//huffmanNode yo = new huffmanNode();
			//yo.data='#';
			//yo.freq=Integer.MAX_VALUE;
			heaparr[size - 1] = key; // doubt
			heaparr[size-1].freq=Integer.MAX_VALUE;
			decrease(size - 1, key.freq);
		}
	}

	

}
