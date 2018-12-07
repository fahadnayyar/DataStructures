
public class CircularLinkedList {
	NodeCir rear;
	int length;
	public CircularLinkedList() {
		length=0;
	}
	public void append(NodeCir p) {
		if (rear==null) {
			rear=p;
			rear.setnext(rear);
			length++;
		}
		else {
			p.setnext(rear.getnext());
			rear.setnext(p);
			rear=p;
			length++;
		}
	}
	public void addAtStart(NodeCir p) {
		if (rear==null) {
			rear=p;
			rear.setnext(rear);
			length++;
		}
		else {
			p.setnext(rear.getnext());
			rear.setnext(p);
			length++;
		}
	}
	public void print() {
		if (length==0 || rear==null) {
			System.out.println("EMPTY CLL");
			return;
		}
		
		NodeCir yo=rear;
		yo=rear.getnext();
		while (yo!=rear) {
			System.out.print(yo.getdata()+" ");
			yo=yo.getnext();
		}
		System.out.println(yo.getdata());
	}
	public int givelength() {
		return length;
	}
	public void deleteEnd() {
		if (rear==null || length==0) {
			System.out.println("EMPTY NOTHING TO DELETE");
			return;
		}
		else {
			NodeCir yo =rear;
			while (yo.getnext()!=rear) {
				yo=yo.getnext();
			}
			NodeCir temp=rear;
			rear=yo;
			yo.setnext(yo.getnext().getnext());
			temp=null;
			length--;
		}
	}
	public void deleteFront() {
		if (rear==null || length==0) {
			System.out.println("EMPTY NOTHING TO DELETE");
			return;
		}
		else {
			if (length==1) {
				rear=null;
				length--;
				return;
			}
			else {
				NodeCir temp=rear.getnext();
				rear.setnext(temp.getnext());
				temp=null;
				length--;
			}
		}
	}
	public Object giveElementAt(int ind) {
		if (ind<0 || ind>=length) {
			System.out.println("INDEX OUT OF BOUND");
			return null;
		}
		else {
			NodeCir yo=rear;
			for (int i=0;i<=ind;i++) {
				yo=yo.getnext();
			}
			return yo.getdata();
		}
	}
}
class NodeCir{
	private NodeCir next;
	private Object data;
	public NodeCir() {
		next=null;
		data=null;
	}
	public NodeCir(Object o) {
		data=o;
	}
	public NodeCir(NodeCir n) {
		next=n;
	}
	public NodeCir(NodeCir p, Object o) {
		data= o;
		next=p;
	}
	public Object getdata() {
		return data;
	}
	public NodeCir getnext() {
		return next;
	}
	public void setdata(Object o) {
		data=o;
	}
	public void setnext(NodeCir p) {
		next=p;
	}
	
}