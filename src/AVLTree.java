
public class AVLTree {
	
	public static void main(String[] args) {
		
		
		
		
		
		
		AVLTree tr = new AVLTree();
		tr.setRoot(tr.insert(tr.giveRoot(), 14));
		tr.setRoot(tr.insert(tr.giveRoot(), -235));
		tr.setRoot(tr.insert(tr.giveRoot(), 74));
		tr.setRoot(tr.insert(tr.giveRoot(), 23686));
		tr.setRoot(tr.insert(tr.giveRoot(), -26));
		tr.setRoot(tr.insert(tr.giveRoot(), -47886));
		tr.setRoot(tr.insert(tr.giveRoot(), 156));
		tr.setRoot(tr.insert(tr.giveRoot(), 86));
		tr.setRoot(tr.insert(tr.giveRoot(), 2));
		tr.setRoot(tr.insert(tr.giveRoot(), 86));
		tr.setRoot(tr.insert(tr.giveRoot(), 37));
		tr.setRoot(tr.insert(tr.giveRoot(), 8));
		tr.setRoot(tr.insert(tr.giveRoot(), 14));
		
		tr.InOrderPrint(tr.giveRoot());
		System.out.println();
		tr.setRoot(tr.insert(tr.giveRoot(), 86));
		tr.setRoot(tr.delete(tr.giveRoot(), 14));
		tr.setRoot(tr.delete(tr.giveRoot(), 2));
		tr.setRoot(tr.delete(tr.giveRoot(), -235));
		tr.setRoot(tr.delete(tr.giveRoot(), 74));
		tr.setRoot(tr.delete(tr.giveRoot(), 23686));
		
		tr.InOrderPrint(tr.giveRoot());
		System.out.println();
	}
	
	
	
	private AVLNode root;
	public AVLNode giveRoot() {
		return this.root;
	}
	public void setRoot(AVLNode yo) {
		this.root=yo;
	}
	
	public AVLNode searchRecurr(AVLNode ref,int data) {
		if (ref==null) {
			return null;
		}
		else if (data>ref.getData()) {
			return searchRecurr(ref.getRight(),data);
		}
		else if (data<ref.getData()) {
			return searchRecurr(ref.getLeft(),data);
		}
		else return ref;
	}
	public AVLNode searchIterative(int data) {
		AVLNode ref=this.root;
		if (ref==null) {
			return null;
		}
		else {
			while (ref!=null) {
				if (ref.getData()>data) {
					ref=ref.getRight();
				}
				else if (ref.getData()<data) {
					ref=ref.getLeft();
				}
				else {
					return ref;
				}
			}
			return ref;
		}
	}
	
	
	public static int getHeight(AVLNode yo) {
		if (yo == null) {
			return -1;
		} else {
			return yo.getHeight();
		}
	}

	public AVLNode insert(AVLNode ref, int data) {
		if (ref == null) {
			ref = new AVLNode();
			ref.setData(data);
			ref.setHeight(0);
		} else if (data < ref.getData()) {
			//System.out.println("yaha");
			ref.setLeft(insert(ref.getLeft(), data));
			int balance = ref.getBalance();
			if (balance >= 2)  {
				if (data < ref.getLeft().getData()) {
					ref = RightRotateSingle(ref);
				} else if (data > ref.getLeft().getData()) {
					ref = RightRotateDouble(ref);
				}
			}

		} else if (data > ref.getData()) {
			
			ref.serRight(insert(ref.getRight(), data));
			int balance = ref.getBalance();
			if (balance <= -2) {
				if (data > ref.getRight().getData()) {
					ref = LeftRotateSingle(ref);
				} else if (data < ref.getRight().getData()) {
					ref = LeftRotateDouble(ref);
				}
			}
		}
		ref.setHeight(Math.max(getHeight(ref.getLeft()), getHeight(ref.getRight())) + 1);
		//System.out.println(ref.getData());
		return ref;
	}

	public AVLNode delete(AVLNode ref, int data) {
		if (ref == null) {
			return ref;
		} else {
			if (data < ref.getData()) {
				ref.setLeft(delete(ref.getLeft(), data));
			} else if (data > ref.getData()) {
				ref.serRight(delete(ref.getRight(), data));
			} else {
				if (ref.getLeft() == null && ref.getRight() == null) {
					return null;
				} else if (ref.getLeft() != null && ref.getRight() == null) {
					return ref.getLeft();
				} else if (ref.getRight() != null && ref.getLeft() == null) {
					return ref.getRight();
				} else {
					AVLNode temp = maxrecur(ref.getLeft());
					int tempdata = temp.getData();
					ref.setLeft(delete(ref.getLeft(), tempdata));
					ref.setData(tempdata);
				}
			}

		}

		if (ref == null) {
			return null;
		}
		ref.setHeight(Math.max(getHeight(ref.getLeft()), getHeight(ref.getRight())) + 1);
		int balance = getHeight(ref.getLeft()) - getHeight(ref.getRight());

		if (balance >= 2) {
			AVLNode yo = ref.getLeft();
			int balance1 = getHeight(yo.getLeft()) - getHeight(yo.getRight());
			if (balance1 >= 1) {
				ref = RightRotateSingle(ref);
			} else if (balance1 <= -1) {
				ref = RightRotateDouble(ref);
			}
		} else if (balance <= -2) {
			AVLNode yo = ref.getRight();
			int balance1 = getHeight(yo.getLeft()) - getHeight(yo.getRight());
			if (balance1 <= -1) {
				ref = LeftRotateSingle(ref);
			} else if (balance1 >= 1) {
				ref = LeftRotateDouble(ref);
			}
		}
		return ref;
	}

	public AVLNode maxIterate() {
		AVLNode ref = root;
		if (ref == null) {
			return null;
		} else {
			while (ref.getRight() != null) {
				ref = ref.getRight();
			}
			return ref;
		}
	}

	public AVLNode minIterate() {
		AVLNode ref = root;
		if (ref == null) {
			return null;
		} else {
			while (ref.getLeft() != null) {
				ref = ref.getLeft();
			}
			return ref;
		}
	}

	public AVLNode minRecur(AVLNode ref) {
		if (ref == null) {
			return null;
		} else if (ref.getLeft() == null) {
			return ref;
		} else {
			return minRecur(ref.getLeft());
		}
	}

	public AVLNode maxrecur(AVLNode ref) {
		if (ref == null) {
			return null;
		} else if (ref.getRight() == null) {
			return ref;
		} else {
			return maxrecur(ref.getRight());
		}
	}

	public AVLNode RightRotateSingle(AVLNode ref) {
		AVLNode x = ref.getLeft();
		AVLNode y = x.getRight();
		x.serRight(ref);
		ref.setLeft(y);
		ref.setHeight(Math.max(getHeight(ref.getLeft()), getHeight(ref.getRight())) + 1);
		x.setHeight(Math.max(getHeight(x.getLeft()), getHeight(x.getRight())) + 1);
		//x.setHeight(Math.max(x.getLeft().getHeight(), x.getRight().getHeight()) + 1);
		return x;
	}

	public AVLNode LeftRotateSingle(AVLNode ref) {
		AVLNode x = ref.getRight();
		AVLNode y = x.getLeft();
		x.setLeft(ref);
		ref.serRight(y);
		ref.setHeight(Math.max(getHeight(ref.getLeft()), getHeight(ref.getRight())) + 1);
		x.setHeight(Math.max(getHeight(x.getLeft()), getHeight(x.getRight())) + 1);
		
	//	ref.setHeight(Math.max(ref.getLeft().getHeight(), ref.getRight().getHeight()) + 1);
	//	x.setHeight(Math.max(x.getLeft().getHeight(), x.getRight().getHeight()) + 1);
		return x;
	}

	public AVLNode LeftRotateDouble(AVLNode ref) {
		AVLNode x = ref.getRight();
		x = RightRotateSingle(x);
		ref.serRight(x);

		return LeftRotateSingle(ref);

	}

	public AVLNode RightRotateDouble(AVLNode ref) {
		AVLNode x = ref.getLeft();
		x = LeftRotateSingle(x);
		ref.setLeft(x);
		return RightRotateSingle(ref);
	}
	public void InOrderPrint(AVLNode ref) {
		if (ref==null) {
			return;
		}
		else {
			InOrderPrint(ref.getLeft());
			System.out.print(ref.getData()+" ");
			InOrderPrint(ref.getRight());
		}
	}
	public AVLNode successor(AVLNode ref,int data) {
		AVLNode yo = searchRecurr(ref, data);
		return maxrecur(yo.getRight());
	}
	public AVLNode predecessor(AVLNode ref,int data) {
		AVLNode yo= searchRecurr(ref, data);
		return minRecur(yo.getLeft());
	}
}

class AVLNode {
	private AVLNode left;
	private AVLNode right;
	private int data;
	private int height;

	public AVLNode getLeft() {
		return left;
	}

	public AVLNode getRight() {
		return right;
	}

	public void setLeft(AVLNode left) {
		this.left = left;
	}

	public void serRight(AVLNode right) {
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getHeight() {

		return height;
	}

	public void setHeight(int heigh) {
		this.height = heigh;
	}

	public int getBalance() {
		if (this.left == null && this.right == null) {
			return 0;
		} else if (this.left == null && this.right != null) {
			return -1 - (this.right.getHeight());
		} else if (this.left != null && this.right == null) {
			return this.left.getHeight() - (-1);
		} else {
			return this.left.getHeight() - this.right.getHeight();
		}
	}

}
