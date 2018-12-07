//class Node{
//	int data;
//	Node next;
//}
public class StackSLL {
	Node top;
	int size;

	public StackSLL() {
		top = null;
		size = 0;
	}

	public void push(int x) {
		Node n = new Node();
		n.data = x;
		// if (top==null) {
		// top=n;
		// size++;
		// }
		// else {
		n.next = top;
		top = n;
		size++;
		// }
	}

	public int pop() {
		if (top == null) {
			System.out.println("empty stack");
			return -1;
			
		} else {
			int ret = top.data;
			top = top.next;
			size--;
			return ret;
		}

	}
	public int peek() {
		if (top == null) {
			System.out.println("empty stack");
			return -1;
			
		} else {
			int ret = top.data;
			//top = top.next;
			//size--;
			return ret;
		}
	}
	public boolean isempty() {
		return top==null;
	}
	public int givesize() {
		return size;
	}
	public void print() {
		if (top==null) {
			System.out.println("empty stack");
		}
		else {
			Node yo = top;
			while (yo.next!=null) {
				System.out.print(yo.data+" ");
				yo=yo.next;
			}
			System.out.print(yo.data);
			System.out.println();
		}
	}

}
