package adt.bst;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	// BSTNode<T> node

	@Override
	public int height() {
		return height(this.root);
	}

	private int height(BSTNode<T> node) {
		int height = -1;

		if (!node.isEmpty()) {
			height = 1 + Math.max(this.height((BSTNode<T>) node.getLeft()), this.height((BSTNode<T>) node.getRight()));
		}
		return height;

	}

	@Override
	public BSTNode<T> search(T element) {
		return recursiveSearch(element, this.root);
	}

	public BSTNode<T> recursiveSearch(T element, BSTNode<T> node) {
		if (element != null && !node.isEmpty()) {
			if (element.compareTo(node.getData()) > 0) {
				return recursiveSearch(element, (BSTNode<T>) node.getRight());
			} else if (element.compareTo(node.getData()) < 0) {
				return recursiveSearch(element, (BSTNode<T>) node.getLeft());
			} else {
				return node;
			}
		}
		return new BSTNode();
	}

	@Override
	public void insert(T element) {
		recursiveInsert(element, this.root);
	}

	public void recursiveInsert(T element, BSTNode<T> node) {
		if (element != null) {
			if (node.isEmpty()) {
				node.setData(element);
				node.setLeft(new BSTNode<T>());
				node.setRight(new BSTNode<T>());
				node.getLeft().setParent(node);
				node.getRight().setParent(node);
			} else {
				if (element.compareTo(node.getData()) > 0) {
					recursiveInsert(element, (BSTNode<T>) node.getRight());
				} else {
					recursiveInsert(element, (BSTNode<T>) node.getLeft());
				}
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {
		return recursiveMaximum(this.root);
	}
	
	public BSTNode<T> recursiveMaximum(BSTNode<T> node) {
		if(node.isEmpty()) {
			return null;
		} else if(node.getRight().isEmpty()) {
			return node;
		} else {
			return recursiveMaximum((BSTNode<T>)node.getRight());
		}
	}
	

	@Override
	public BSTNode<T> minimum() {
		return recursiveMinimum(this.root);
	}

	public BSTNode<T> recursiveMinimum(BSTNode<T> node) {
		if(node.isEmpty()) {
			return null;
		} else if(node.getLeft().isEmpty()) {
			return node;
		} else {
			return recursiveMinimum((BSTNode<T>) node.getLeft());
		}
	}
	
	@Override
	public BSTNode<T> sucessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] preOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] order() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] postOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	/**
	 * This method is already implemented using recursion. You must understand how
	 * it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft()) + size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
