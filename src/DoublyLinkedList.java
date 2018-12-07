
public class DoublyLinkedList {
	NodeD head;
	NodeD tail;
	int length;

	public DoublyLinkedList() {
		length = 0;
	}

	public void insertAtStart(NodeD p) {
		if (head == null) {
			head = p;
			tail = p;
			length++;
		} else {
			head.setprev(p);
			p.setnext(head);
			head = p;
			length++;
		}
	}

	public void append(NodeD p) {
		if (head == null) {
			head = p;
			tail = p;
			length++;
		} else {
			tail.setnext(p);
			p.setprev(tail);
			p.setnext(null);
			tail = p;
			length++;
		}

	}

	public void insertAt(NodeD p, int ind) {
		// int count=1;

		if (ind > length || ind < 0) {
			System.out.println("INDEX OUT OF BOUND");
			return;
		} else if (ind == 0) {
			insertAtStart(p);
			return;
		} else if (ind == length ) {
			append(p);
		} else {

			NodeD yo = head;
			for (int i = 1; i < ind; i++) {
				yo = yo.givenext();
			}
			p.setnext(yo.givenext());
			p.setprev(yo);
			yo.setnext(p);
			p.givenext().setprev(p);
			length++;
		}
	}

	public int giveLength() {
		return length;
	}

	public void deleteFront() {
		if (head == null) {
			System.out.println("EMPTY LIST");
			return;
		} else {
			NodeD temp = head;
			head = head.givenext();
			head.setprev(null);
			temp = null;
			length--;
		}
	}

	public void deleteEnd() {
		if (head == null) {
			System.out.println("EMPTY LIST");
			return;
		} else {
			NodeD temp = tail;
			tail = tail.giveprev();
			tail.setnext(null);
			temp = null;
			length--;
		}
	}
	public void deleteAt(int ind) {
		if (ind<0 || ind>=length) {
			System.out.println("INDEX OUT OF BOUND");
		}
		else if (ind==0) {
			deleteFront();
		}
		else if(ind ==length-1) {
			deleteEnd();
		}
		else {
			NodeD yo =head;
			for (int i=1;i<ind;i++) {
				yo=yo.givenext();
			}
			NodeD temp=yo.givenext();
			yo.setnext(yo.givenext().givenext());
			temp.givenext().setprev(yo);
			temp=null;
			length--;
		}
	}
	public void print() {
		NodeD yo = head;
		while(yo!=null) {
			System.out.print(yo.givedata()+" ");
			yo=yo.givenext();
		}
		System.out.println();
	}

}

class NodeD {
	private Object data;
	private NodeD next;
	private NodeD prev;

	public NodeD() {
		data = null;
		next = null;
		prev = null;
	}

	public NodeD(Object o) {
		data = o;
		next = null;
		prev = null;
	}

	public NodeD(Object o, NodeD prev, NodeD next) {
		data = o;
		this.next = next;
		this.prev = prev;
	}

	public void setnext(NodeD n) {
		this.next = n;
	}

	public void setprev(NodeD n) {
		this.prev = n;
	}

	public void setdata(Object o) {
		this.data = o;
	}

	public Object givedata() {
		return this.data;
	}

	public NodeD givenext() {
		return this.next;
	}

	public NodeD giveprev() {
		return this.prev;
	}
}