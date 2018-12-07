import java.io.IOException;

public class BinarySearchTree {
	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		BinarySearchTree bst = new BinarySearchTree();
		int n = Reader.nextInt();
		for (int i = 0; i < n; i++) {
			String s = Reader.next();
			if (s.equals("INSERT")  ) {
				int kya = Reader.nextInt();
				bst.root = bst.inserrtRecurr(bst.root, kya);
			} else if (s.equals("DELETE")  ) {
				int kya = Reader.nextInt();
				bst.root = bst.delete(bst.root, kya);
			} else if (s.equals("PRINTPRE")  ) {
				if (bst.root == null) {
					System.out.println(-1);
				}

				else {
					bst.printPreOrder(bst.root);
					System.out.println();
				}

			} else if (s.equals("PRINTPOST")  ) {
				if (bst.root == null) {
					System.out.println(-1);
				}

				else {
					bst.printPostOrder(bst.root);
					System.out.println();
				}

			} else if (s.equals("PRINTIN")  ) {
				if (bst.root == null) {
					System.out.println(-1);
				}

				else {
					bst.printInOrder(bst.root);
					System.out.println();
				}

			}

		}
	}

	BSTNode root;

	public static BSTNode searchRecur(BSTNode ref, int data) { // null will be returned if bst is empty or if simple
																// that
		// element doesn't exist in bst.
		// BSTNode ref = root;
		if (ref == null) {
			return null;
		}
		if (data < ref.getData()) {
			return searchRecur(ref.getLeft(), data);
		} else if (data > ref.getData()) {
			return searchRecur(ref.getright(), data);
		}
		return ref;
	}

	public BSTNode searchIterate(int data) { //// null will be returned if bst is empty or if simple that element
												//// doesn't exist in bst.
		BSTNode ref = root;
		if (ref == null) {
			return null;
		}
		while (ref != null) {
			if (data == ref.getData()) {
				return ref;
			} else if (data > ref.getData()) {
				ref = ref.getright();
			} else {
				ref = ref.getLeft();
			}
		}
		return null;
	}

	public static BSTNode FindMinRecurr(BSTNode ref) { // null will be returned if bst is empty.
		if (ref == null) {
			return null;
		} else {
			if (ref.getLeft() == null) {
				return ref;
			} else {
				return FindMinRecurr(ref.getLeft());
			}
		}
	}

	public BSTNode FindMinIterative() { // null will be returned only if bst is empty.
		BSTNode ref = root;
		if (ref == null) {
			return null;
		}
		while (ref.getLeft() != null) {
			ref = ref.getLeft();
		}
		return ref;
	}

	public BSTNode FindMaxIterate() {
		BSTNode ref = root;
		if (ref == null) {
			return null;
		}
		while (ref.getright() != null) {
			ref = ref.getright();
		}
		return ref;

	}

	public static BSTNode FindMaxRecurr(BSTNode ref) {
		if (ref == null) {
			return null;
		} else {
			if (ref.getright() == null) {
				return ref;
			} else {
				return FindMaxRecurr(ref.getright());
			}
		}
	}

	public void insertIterate(int data) {
		BSTNode ref = root;
		BSTNode yo = new BSTNode();
		yo.setData(data);
		if (root == null) {
			root = yo;
			return;
		}
		BSTNode parent = null, current = ref;
		while (current != null) {
			parent = current;
			if (current.getData() < data) {
				current = current.getright();
			} else {
				current = current.getLeft();
			}
		}
		if (parent.getData() < data) {
			parent.setRight(yo);
		} else {
			parent.setLeft(yo);
		}
	}

	public BSTNode inserrtRecurr(BSTNode ref, int data) {
		if (ref == null) {
			ref = new BSTNode();
			ref.setData(data);
			return ref;
		} else {
			if (data <= ref.getData()) {
				ref.setLeft(inserrtRecurr(ref.getLeft(), data));
			} else if (data > ref.getData()) {
				ref.setRight(inserrtRecurr(ref.getright(), data));
			}

			// else {
			//
			// }
			return ref;
		}

	}

	public void printInOrder(BSTNode ref) { // whenever u use this funcrion use one sysout extra.
		if (ref == null) {
			return;
			// System.out.println("empty bst");
		} else {
			printInOrder(ref.getLeft());
			System.out.print(ref.getData() + " ");
			printInOrder(ref.getright());
		}
	}

	public void printPreOrder(BSTNode ref) {

		if (ref == null) {
			return;
		} else {
			System.out.print(ref.getData()+" ");
			printPreOrder(ref.getLeft());
			printPreOrder(ref.getright());
		}
	}

	public void printPostOrder(BSTNode ref) {

		if (ref == null) {
			return;
		} else {

			printPostOrder(ref.getLeft());
			printPostOrder(ref.getright());
			System.out.print(ref.getData()+" ");
		}
	}

	public BSTNode delete(BSTNode ref, int data) {
		BSTNode temp;
		if (ref == null) {
			//System.out.println("this element is not present");
			return null;
		} else if (data < ref.getData()) {
			ref.setLeft(delete(ref.getLeft(), data));
		} else if (data > ref.getData()) {
			ref.setRight(delete(ref.getright(), data));
		} else {
			if (ref.getLeft() != null && ref.getright() != null) {
				temp = FindMinRecurr(ref.getright());
				ref.setData(temp.getData());
				ref.setRight(delete(ref.getright(), ref.getData()));

				// temp=FindMaxRecurr(ref.getLeft());
				// ref.setData(temp.getData());
				// ref.setLeft(delete(ref.getLeft(), ref.getData()));
			} else {
				temp = ref;
				if (ref.getLeft() == null) {
					ref = ref.getright();
				} else if (ref.getright() == null) {
					ref = ref.getLeft();
				}
			}
		}
		return ref;
	}

	public BSTNode successor(BSTNode ref, int data) {
		BSTNode yo = searchRecur(ref, data);
		return FindMaxRecurr(yo.getright());

	}

	public BSTNode predecessor(BSTNode ref, int data) {
		BSTNode yo = searchRecur(ref, data);
		return FindMinRecurr(yo.getLeft());
	}
}

class BSTNode {
	private BSTNode left;
	private BSTNode right;
	private int data;

	public void setData(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setLeft(BSTNode left) {
		this.left = left;
	}

	public void setRight(BSTNode right) {
		this.right = right;
	}

	public BSTNode getLeft() {
		return left;
	}

	public BSTNode getright() {
		return right;
	}
}
