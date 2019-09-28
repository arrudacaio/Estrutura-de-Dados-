package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL(); // HEAD est� apontando para um n� sentinela ? 
	}

	@Override
	public int size() {

		int contador = 0;
		if(!isEmpty()) {
			SingleLinkedListNode<T> aux = getHead();
			while(!aux.isNIL()) { // Enquanto n�o estiver apontando para um n� vazio
				contador++;
				aux = aux.getNext();
			}
		}
		return contador;
	}

	@Override
	public T search(T element) {
		T exit = null;
		if(!isEmpty()) {
			SingleLinkedListNode<T> aux = this.head;
			while(!aux.isNIL()) {
				if(aux.getData().equals(element)) {
					exit = aux.getData();
				}
				aux = aux.getNext();
			}
		}
		return exit;
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> auxHead = this.head;
		if(this.head.isNIL()) {
			SingleLinkedListNode<T> newHead = new SingleLinkedListNode<>(element, new SingleLinkedListNode<>());
			newHead.next = head;
			head = newHead;
		} else {
			while(!auxHead.next.isNIL()) {
				SingleLinkedListNode<T> newNode = new SingleLinkedListNode<>(element, new SingleLinkedListNode<>());
				newNode.next = auxHead.next;
				auxHead = newNode;
			}
		}
	}

	@Override
	public void remove(T element) { // entender!!!
		if (element != null && !isEmpty()) {
			if (this.head.getData().equals(element)) {
				head = head.getNext();
			} else {
				SingleLinkedListNode<T> previous = new SingleLinkedListNode<T>();
				SingleLinkedListNode<T> aux = getHead();
				while (!aux.isNIL() && !aux.getData().equals(element)) {
					previous = aux;
					aux = aux.getNext();
				}
				if (!aux.isNIL()) {
					previous.setNext(aux.getNext());
				}
			}
		}
	}

	@Override
	public T[] toArray() { // fazer
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented!");
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
