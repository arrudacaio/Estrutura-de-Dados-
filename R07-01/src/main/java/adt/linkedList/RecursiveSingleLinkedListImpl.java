package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	public RecursiveSingleLinkedListImpl(T data, RecursiveSingleLinkedListImpl<T> next) {
		this.data = data;
		this.next = next;
	}

	@Override
	public boolean isEmpty() {
		return (this.data == null);
	}

	@Override
	public int size() {
		int size = 0;
		if (isEmpty()) {
			return size;
		} else {
			size++;
			return size + next.size();
		}
	}

	@Override
	public T search(T element) {
		if (isEmpty()) {
			return null;
		} else if (this.data.equals(element)) {
			return element;
		} else {
			return next.search(element);

		}
	}

	@Override
	public void insert(T element) {
		if(element != null) {
			if(isEmpty()) { // Se a lista for vazia, criamos um novo nó
				this.data = element;
				this.next =  new RecursiveSingleLinkedListImpl<T>();
			} else {
				next.insert(element);
			}
		}
	}

	@Override
	public void remove(T element) { 
		if(!isEmpty()) {
			if(this.data.equals(element)) {
				this.data = this.next.data;
				this.next = this.next.next;
			} else {
				next.remove(element);
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() { 
		T[] array = (T[])  new Object[size()];
		toArray(array,this,0);
		return array;
	}

	private Object toArray(T[] array, RecursiveSingleLinkedListImpl<T> node, int index) {
		if (node.isEmpty()) {
			return array;
		} else {
			array[index] = node.getData();
			return toArray(array, node.next, index + 1);
		}
	}
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
