
public class LinkedList {
	Node head;
	// Node tail;

	public void append(int x) {
		Node n = new Node();
		n.data = x;
		n.next = null;
		if (head == null) {
			head = n;
			// tail = n;
		} else {
			Node yo = head;
			while (yo.next != null) {
				yo = yo.next;
			}
			yo.next = n;
			// tail.next = n;
			// tail = n;
		}
	}

	public void addAtStart(int x) {
		Node n = new Node();
		n.data = x;
		n.next = head;
		head = n;
	}

	public void addAt(int x, int index) {
		int l = giveLength();
		if (index > l) {
			System.out.println("index out of bond");
		} else {

			Node n = new Node();
			n.data = x;
			n.next = null;
			// int l= this.giveLength();
			if (index == 0) {
				addAtStart(x);
			} else if (index == l - 1) {
				append(x);
			} else {
				Node yo = head;
				for (int i = 0; i < index - 1; i++) {
					yo = yo.next;
				}
				n.next = yo.next;
				yo.next = n;
			}
		}
	}

	public void delete(int index) {
		int l = giveLength();
		if (index >= l) {
			System.out.println("index out of bond");
		} else {
			if (index == 0) {
				head = head.next;
			}

			else {
				Node n = head;
				for (int i = 0; i < index - 1; i++) {
					n = n.next;
				}
				Node nn = n.next;
				n.next = nn.next;
			}
		}
	}

	public void show() {
		if (head == null) {
			System.out.println("empty list");
		} else {
			Node ro = head;
			// do {
			// System.out.print(yo.data);
			// yo=yo.next;
			// }while(yo.next!=null);
			while (ro.next != null) {
				System.out.print(ro.data);
				System.out.print(' ');
				ro = ro.next;
			}
			System.out.println(ro.data);
		}
	}

	public int giveLength() {
		Node ro = head;
		if (head == null) {
			return 0;
		} else {
			int count = 1;
			while (ro.next != null) {
				count++;
				ro = ro.next;
			}
			return count;
		}

	}

	public void deleteval(int x) {
		if (!this.ispresent(x)) {
			System.out.println("this element not present");
			return;
		} else {
			Node yo = head;
			Node prev = null;
			while (yo != null) {
				if (yo == head && yo.data == x) {
					this.delete(0);
					return;
				} else if (yo.data == x) {
					prev.next = yo.next;
					// break;
					return;

				}
				prev = yo;
				yo = yo.next;
			}
		}
	}

	public void deleteallval(int x) {
		if (!this.ispresent(x)) {
			System.out.println("this element not present");
			return;
		} else {
			Node yo = head;
			Node prev = null;
			while (yo != null) {
				if (yo == head && yo.data == x) {
					this.delete(0);
				} else if (yo.data == x) {
					prev.next = yo.next;
					// return;
				}
				prev = yo;
				yo = yo.next;
			}
		}

	}

	public boolean ispresent(int x) {
		Node yo = head;
		while (yo != null) {
			if (yo.data == x) {
				return true;

			}
			yo = yo.next;
		}
		return false;
	}

	public int index(int x) {
		// int l = this.giveLength();
		// if (x >= l) {
		// System.out.println("index out of bond");
		// return -1;
		// }
		// else {

		Node yo = head;
		int count = 0;
		while (yo != null) {
			if (yo.data == x) {
				return count;

			}
			yo = yo.next;
			count++;
		}
		System.out.println("element is not present");
		return -1;
	}
	// }

	public int index(int x, int y) {
		int l = this.giveLength();
		if (y >= l) {

			System.out.println("index out of bond");
			return -1;
		} else {
			Node yo = head;
			int count = 0;
			while (count != y) {
				yo = yo.next;
				count++;
			}
			// yo = yo.next;
			// count++;
			while (yo != null) {
				if (yo.data == x) {
					return count;
				}

				yo = yo.next;
				count++;

			}
			System.out.println("element is not present");
			return -1;
		}
	}

	public int giveCountOf(int x) {
		int count = 0;
		Node yo = head;
		while (yo != null) {
			if (yo.data == x) {
				count++;
			}
			yo = yo.next;
		}
		return count;

	}

	public int dataAt(int index) {
		int l = this.giveLength();
		if (index >= l) {
			System.out.println("index out of bound");
			return -1;
		} else {
			Node yo = head;
			int count = 0;
			while (count != index) {
				yo = yo.next;
				count++;
			}
			int ans = yo.data;
			return ans;
		}
	}

	public boolean issortedrecurr(Node ref) {
		if (ref.next == null) {
			return true;
		} else {
			return ref.data < ref.next.data && issortedrecurr(ref.next);
		}
	}

	public void reverse() {
		Node prev = null;
		Node curr = head;
		Node next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}

	public void reverseInStepsOf(int k) {
		head = reversestep(this.head, k);
	}

	public Node reversestep(Node ref, int k) {
		Node prev = null;
		Node curr = ref;
		Node next = null;

		int count = 0;
		while (count < k && curr != null) {

			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;

		}

		if (next != null) {
			ref.next = reversestep(next, k);
		}
		return prev;

	}

	public void reverserecurr(Node ref) {
		if (ref.next == null) {
			head = ref;
			return;

		}
		reverserecurr(ref.next);
		Node q = ref.next;
		q.next = ref;
		ref.next = null;

	}

}

class Node {
	int data;
	Node next;
}
