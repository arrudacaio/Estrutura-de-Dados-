package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		if (isEmpty()) {
			return null;
		}
		return this.array[0];
	}

	@Override
	public boolean isEmpty() {
		return this.tail < 0;
	}

	@Override
	public boolean isFull() {
		return this.tail == this.array.length - 1;
	}

	private void shiftLeft() {
		int i = 1;
		while (this.array[i] != null) {
			this.array[i - 1] = this.array[i];
			i += 1;
		}
		this.tail -= 1;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(isFull()) {
			throw new RuntimeException("Queue is full!");
		}
		if(element != null) {
			this.tail++;
			this.array[this.tail] = element;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(isEmpty()) {
			throw new RuntimeException("Queue is empty!");
		} 
		T saida = this.array[0];
		this.array[0] = null;
		shiftLeft();
		return saida;
	}

}
