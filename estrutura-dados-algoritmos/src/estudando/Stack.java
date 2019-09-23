package estudando;

public class Stack<T> {

	private T[] array;
	private int top;

	public Stack(int size) {
		this.array = (T[]) new Object[size];
		this.top = -1;
	}

	public boolean isEmpty() {
		return this.top == -1;
	}

	public boolean isFull() {
		return this.top == this.array.length - 1;
	}

	public void push(T element) {
		if(isFull()) {
			throw new RuntimeException("Stack is full");
		}
		if(element != null) {
			this.top++;
			this.array[this.top] = element;
		}
	}
	
	public T pop() {
		if(isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		T e = this.array[this.top];
		this.top--;
		return e;
	}
	
	public T top() {
		if(isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		return this.array[this.top];
	}
}
