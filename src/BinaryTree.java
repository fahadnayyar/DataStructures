import java.io.IOException;

import javax.xml.crypto.Data;

class BTNode {
	private int data;
	private BTNode left;
	private BTNode right;

	public void setData(int data) {
		this.data = data;
	}

	public void setLeft(BTNode left) {
		this.left = left;
	}

	public void setRight(BTNode right) {
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public BTNode getLeft() {
		return left;
	}

	public BTNode getRight() {
		return right;
	}
}

public class BinaryTree {

	public static BTNode PreInSeTree(int arrIn[], int iin, int jin, int arrPre[], int ipre, int jpre) {
		if (iin > jin || ipre > jpre) {
			return null;
		}
		BTNode root = new BTNode();
		root.setData(arrPre[ipre]);
		int data = root.getData();
		//int l = arrIn.length;
		int k = -1;
		for (int i = iin; i <= jin; i++) {
			if (data == arrIn[i]) {
				k = i;

				break;
			}

		}
		int iinl = iin;
		int jinl = k - 1;
		int iprel = ipre + 1;
		int jprel = ipre + k - iin;

		int iinr = k + 1;
		int jinr = jin;
		int iprer = ipre + k - iin + 1;
		int jprer = jpre;

		root.setLeft(PreInSeTree(arrIn, iinl, jinl, arrPre, iprel, jprel));
		root.setRight(PreInSeTree(arrIn, iinr, jinr, arrPre, iprer, jprer));
		return root;
	}
	public static BTNode PostInSeTree(int arrIn[], int iin, int jin, int arrPost[],int ipost, int jpost) {
		if (iin>jin || ipost>jpost) {
			return null;
		}
		BTNode root = new BTNode();
		root.setData(arrPost[jpost]);
		int data=root.getData();
		int k=-1;
		for (int i=iin;i<=jin ;i++) {
			if (data==arrIn[i]) {
				k=i;
				break;
			}
		}
		int iinl = iin;
		int jinl = k - 1;
		int ipostl = ipost ;
		int jpostl = ipost + k - iin-1;

		int iinr = k + 1;
		int jinr = jin;
		int ipostr = ipost + k - iin ;
		int jpostr = jpost-1;
		
		
		root.setLeft(PostInSeTree(arrIn, iinl, jinl, arrPost, ipostl, jpostl));
		root.setRight(PostInSeTree(arrIn, iinr, jinr, arrPost, ipostr, jpostr));
		return root;
	}

	public static void main(String[] args) throws IOException {
//		Reader.init(System.in);
//		int n = Reader.nextInt();
//		BinaryTree bt = new BinaryTree();
//		for (int i = 0; i < 10 * n; i++) {
//			String s = Reader.next();
//			if (s.equals("insert")) {
//				int kya = Reader.nextInt();
//				bt.insert(kya);
//				bt.LOTraversalQueuePrint();
//			} else if (s.equals("delete")) {
//				int kya = Reader.nextInt();
//				bt.delete(kya);
//				bt.LOTraversalQueuePrint();
//			} else if (s.equals("search")) {
//				int kya = Reader.nextInt();
//				System.out.println(bt.SearchLevelOrder(kya));
//				bt.LOTraversalQueuePrint();
//			}
//		}
		
		BinaryTree bt =new BinaryTree();
		int inarr[]= new int[] {6, 9, 2, 5, 11, 7};
		int prearr[]=new int[] {5, 9, 6, 2, 11, 7};
		bt.root=PreInSeTree(inarr, 0, 5, prearr, 0, 5);
		bt.InOrderRecurPrint(bt.root);
		System.out.println();
		bt.PreOrderRecurPrint(bt.root);
		System.out.println();
		bt.PostOrderRecurPrint(bt.root);
		System.out.println();
		
		inarr= new int[] {3, 8, 15, 16, 17, 18, 20};
		int postarr[]=new int[] {3, 8 ,17, 16, 15, 20, 18};
		bt.root=PostInSeTree(inarr, 0, 6, postarr, 0, 6);
		bt.InOrderRecurPrint(bt.root);
		System.out.println();
		bt.PreOrderRecurPrint(bt.root);
		System.out.println();
		bt.PostOrderRecurPrint(bt.root);
		System.out.println();
	}

	private BTNode root;
	private int noOfNodes;

	public void setRoot(BTNode ref) {
		root = ref;
	}

	public BTNode getRoot() {
		return root;
	}

	public void insert(int data) {
		BTNode yo = new BTNode();
		yo.setData(data);

		if (root == null) {
			root = yo;
			noOfNodes++;
			return;
		}

		QueueArray q = new QueueArray(noOfNodes);
		q.enqueue(root);
		while (!q.isEmpty()) {
			BTNode ref = (BTNode) q.dequeue();
			// System.out.println(ref.getData());
			if (ref.getLeft() != null) {
				q.enqueue(ref.getLeft());
			} else {
				ref.setLeft(yo);
				noOfNodes++;
				break;
			}
			if (ref.getRight() != null) {
				q.enqueue(ref.getRight());
			} else {
				ref.setRight(yo);
				noOfNodes++;
				break;
			}

		}
	}

	public void delete(int data) {
		BTNode temp = null, yo = null;
		if (root == null) {
			return;
		}
		QueueArray q = new QueueArray(noOfNodes);
		q.enqueue(root);
		while (!q.isEmpty()) {
			yo = (BTNode) q.dequeue();
			if (yo.getData() == data) {
				temp = yo;
			}

			if (yo.getLeft() != null) {
				q.enqueue(yo.getLeft());
			}
			if (yo.getRight() != null) {
				q.enqueue(yo.getRight());
			}
		}
		if (temp == null) {
			return;
		}
		temp.setData(yo.getData());
		deletedepth(yo);

	}

	public void deletedepth(BTNode ref) {

		if (root == null) {
			return;
		}
		if (root == ref) {
			root = null;
			noOfNodes--;
			return;
		}
		QueueArray q = new QueueArray(noOfNodes);
		q.enqueue(root);
		while (!q.isEmpty()) {
			BTNode yo = (BTNode) q.dequeue();
			if (yo.getLeft() == ref) {
				yo.setLeft(null);
				noOfNodes--;
				return;
			}
			if (yo.getRight() == ref) {
				yo.setRight(null);
				noOfNodes--;
				return;
			}

			if (yo.getLeft() != null) {
				q.enqueue(yo.getLeft());
			}
			if (yo.getRight() != null) {
				q.enqueue(yo.getRight());
			}
		}
	}

	public void LOTraversalQueuePrint() {
		if (root == null) {
			System.out.println("empty tree");
			return;
		}

		QueueArray q = new QueueArray(this.noOfNodes);
		BTNode yo = root;
		q.enqueue(yo);
		while (!q.isEmpty()) {
			yo = (BTNode) q.dequeue();
			System.out.print(yo.getData() + " ");
			if (yo.getLeft() != null) {
				q.enqueue(yo.getLeft());
			}
			if (yo.getRight() != null) {
				q.enqueue(yo.getRight());
			}

			// yo=(BTNode)q.dequeue();
		}
		System.out.println();

	}

	public BTNode SearchLevelOrder(int data) {
		if (root == null) {
			return null;
		}

		QueueArray q = new QueueArray(this.noOfNodes);
		q.enqueue(root);
		while (!q.isEmpty()) {
			BTNode yo = (BTNode) q.dequeue();
			if (yo.getData() == data) {
				return yo;

			}
			if (yo.getLeft() != null) {
				q.enqueue(yo.getLeft());
			}
			if (yo.getRight() != null) {
				q.enqueue(yo.getRight());
			}
		}
		return null;
	}

	public void PreOrderRecurPrint(BTNode ref) {
		if (ref == null) {
			return;
		} else {
			System.out.print(ref.getData() + " ");
			PreOrderRecurPrint(ref.getLeft());
			PreOrderRecurPrint(ref.getRight());
		}
	}

	public BTNode PreOrderRecurSearch(BTNode ref, int data) {
		if (ref == null) {
			return null;
		} else {
			// System.out.print(ref.getData()+" ");
			if (ref.getData() == data) {
				return ref;
			}
			PreOrderRecurSearch(ref.getLeft(), data);
			PreOrderRecurSearch(ref.getRight(), data);
		}
		return null;
	}

	public void PostOrderRecurPrint(BTNode ref) {
		if (ref == null) {
			return;
		} else {

			PostOrderRecurPrint(ref.getLeft());
			PostOrderRecurPrint(ref.getRight());
			System.out.print(ref.getData() + " ");
		}
	}

	public BTNode PostOrderRecurSearch(BTNode ref, int data) {
		if (ref == null) {
			return null;
		} else {

			PostOrderRecurSearch(ref.getLeft(), data);
			PostOrderRecurSearch(ref.getRight(), data);
			// System.out.println(ref.getData()+" ");
			if (ref.getData() == data) {
				return ref;
			}
		}
		return null;
	}

	public void InOrderRecurPrint(BTNode ref) {
		if (ref == null) {
			return;
		} else {

			InOrderRecurPrint(ref.getLeft());
			System.out.print(ref.getData() + " ");
			InOrderRecurPrint(ref.getRight());
		}
	}

	public BTNode InOrderRecursearch(BTNode ref, int data) {
		if (ref == null) {
			return null;
		} else {

			InOrderRecursearch(ref.getLeft(), data);
			if (ref.getData() == data) {
				return ref;
			}
			InOrderRecursearch(ref.getRight(), data);
		}
		return null;
	}

	public int GiveSize() {
		return noOfNodes;
	}

	// public BTNode searchInorder(BTNode ref, int data) {
	// if (ref == null) {
	// return null;
	// } else {
	// BTNode leftse = searchInorder(ref.getLeft(), data);
	// if (ref.getData() == data) {
	// return ref;
	// }
	//
	// BTNode rightse = searchInorder(ref.getRight(), data);
	// if (leftse == null && rightse == null) {
	// return null;
	// } else if (leftse != null) {
	// return leftse;
	// } else if (rightse != null) {
	// return rightse;
	// } else {
	// return leftse;
	// }
	//
	// }
	// }

	// public BTNode searchPreorder(BTNode ref, int data) {
	// if (ref == null) {
	// return null;
	// } else {
	// if (ref.getData() == data) {
	// return ref;
	// }
	//
	// BTNode leftse = searchPreorder(ref.getLeft(), data);
	//
	// BTNode rightse = searchPreorder(ref.getRight(), data);
	// if (leftse == null && rightse == null) {
	// return null;
	// } else if (leftse != null) {
	// return leftse;
	// } else if (rightse != null) {
	// return rightse;
	// } else {
	// return leftse;
	// }
	//
	// }
	// }

	// public BTNode searchPostorder(BTNode ref, int data) {
	// if (ref == null) {
	// return null;
	// } else {
	//
	// BTNode leftse = searchPostorder(ref.getLeft(), data);
	//
	// BTNode rightse = searchPostorder(ref.getRight(), data);
	// if (leftse == null && rightse == null) {
	// return null;
	// } else if (leftse != null) {
	// return leftse;
	// } else if (rightse != null) {
	// return rightse;
	// } else {
	// if (ref.getData() == data) {
	// return ref;
	// } else {
	//
	// return leftse;
	// }
	// }
	//
	// }
	//
	// }

}
