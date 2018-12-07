
public class DIsplay {

	
	public static void main(String[] args) {
		CircularLinkedList cll = new CircularLinkedList();
		cll.addAtStart(new NodeCir(1));
		cll.addAtStart(new NodeCir(2));
		cll.addAtStart(new NodeCir(3));
		cll.addAtStart(new NodeCir(4));
		cll.print();
		cll.append(new NodeCir(5));
		cll.append(new NodeCir(6));
		cll.append(new NodeCir(7));
		cll.append(new NodeCir(8));
		cll.print();
		System.out.println(cll.giveElementAt(0));
		System.out.println(cll.giveElementAt(4));
		System.out.println(cll.giveElementAt(100));
		System.out.println(cll.giveElementAt(3));
	}
	

}
