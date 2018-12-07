import java.io.IOException;

public class QueueArray {

	public static void main(String[] args) throws IOException {
		// QueueArray q = new QueueArray(1);
		// q.enqueue(2);
		// q.enqueue(3);
		// q.enqueue(4);
		// q.enqueue(5);
		// q.enqueue(6);
		// q.enqueue(7);
		// q.enqueue(7);
		// q.enqueue(8);
		// q.enqueue(9);
		// q.enqueue(10);
		// q.enqueue(11);
		// q.enqueue(12);
		// q.printQueue();
		// System.out.println(q.dequeue());
		// System.out.println(q.dequeue());
		// System.out.println(q.dequeue());
		// System.out.println(q.dequeue());
		// System.out.println(q.dequeue());
		// System.out.println(q.dequeue());
		// q.printQueue();
		// q.enqueue(13);
		// q.enqueue(14);
		// q.enqueue(15);
		// q.enqueue(16);
		// q.printQueue();

		Reader.init(System.in);

		int n = Reader.nextInt();
		QueueArray q = new QueueArray(n);
		for (int i = 0; i < 2 * n; i++) {
			String s = Reader.next();
			if (s.equals("enq")) {
				int kya = Reader.nextInt();
				q.enqueue(kya);
				q.printQueue();
			} else if (s.equals("deq")) {
				q.dequeue();
				q.printQueue();
			}

		}

	}

	Object arr[];
	int capacity, size, rear, front;

	public QueueArray(int cap) {
		this.capacity = cap;
		// this.capacity=cap;
		size = 0;
		arr = new Object[this.capacity];
		front = 0;
		rear = this.capacity - 1;
	}

	public void enqueue(Object data) {
		if (isFull()) {
			System.out.println("queue is full");
			return;
		} else {
			rear = (rear + 1) % capacity;
			arr[rear] = data;
			size++;
		}
	}

	public Object dequeue() {
		if (isEmpty()) {
			return null;
		} else {
			 Object temp = arr[front];
			arr[front] = 0;
			front = (front + 1) % capacity;
			size--;
			return temp;
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == capacity;
	}

	public void printQueue() {
		for (Object i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
