package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() { // Retorna o elemento que está no topo
		if (isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		}
		return this.array[this.top];
	}

	@Override
	public boolean isEmpty() { // Verifica se está vazia
		return (this.top == -1);
	}

	@Override
	public boolean isFull() { // Verifica se está cheia
		return this.top == this.array.length - 1;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (isFull()) {
			throw new RuntimeException("Stack is full");
		}
		if (element != null) {
			this.top++;
			this.array[this.top] = element;
		}

	}

	@Override
	public T pop() throws StackUnderflowException {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		return this.array[this.top--];

	}

}
