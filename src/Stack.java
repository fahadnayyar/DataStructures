public class Stack{
	private int[] a;
	private int top;
	public Stack(int size){
		a = new int[size];
		top = -1;
	}
	public boolean isempty() {
		if (top==-1) {
			return true;
					
		}
		else {
			return false;
		}
	}
	public void push(int nn) {
		if (top != (a.length-1)) {
		//System.out.println(a.length);
		a[top+1]=nn;
		top++;
		}
		else {
			//System.out.println(a.length);
			System.out.println("Stack is full");
		}
	}
	public int pop() {
		if (top!=-1) {
		top--;
		int n = a[top+1];
		return n;
		}
		else
			System.out.println("StackClasss is empty");
			return -1;
	}
	public void print() {
		//System.out.println( this.top); 
		for (int i=0;i<=top;i++) {
			System.out.print(a[i]);
			System.out.print(' ');
			
		}
		System.out.println();
		
	}
	public int size() {
		return top;
	}
	public int givetop() {
		if (top==-1) {
			System.out.println("StackClasss is empty");
			return -1;
		}
		else {
			return a[top];
		}
		
	}
}	
