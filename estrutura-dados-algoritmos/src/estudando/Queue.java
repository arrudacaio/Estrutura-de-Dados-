package estudando;

public class Queue<T> {
	private T[] array;
	private int tail;

	public Queue(int size) {
		this.array = (T[]) new Object[size];
		this.tail = -1;
	}

	public boolean isEmpty() {
		return this.tail < 0;
	}

	public boolean isFull() {
		return this.tail == this.array.length - 1;
	}

	public T head() {
		if (isEmpty()) {
			return null;
		}
		return this.array[0];

	}

	public void enqueue(T element) {
		if (isFull()) {
			throw new RuntimeException("Queue is full!");
		}
		if (element != null) {
			this.tail++;
			this.array[this.tail] = element;

		}

	}
	
	public T dequeue() {
		if(isEmpty()) {
			throw new RuntimeException("Queue is empty!");
		}
		T saida = this.array[0];
		this.array[0] = null;
		shiftLeft();
		return saida;

		
	}
	
	public void shiftLeft() {
		int i = 1;
		while(this.array[i] !=  null) {
			this.array[i-1] = this.array[i];
			i++;
		}
		this.tail--;
	}

}
