package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (validacao(array, leftIndex, rightIndex)) {
			if(leftIndex < rightIndex) { // Condição q para de quebrar quanto tiver um array de 1 elemento
				int meio = (leftIndex + rightIndex)/2 ; // define o meio do array
				sort(array,leftIndex, meio); 	// divide o array da esquerda até o meio
				sort(array, meio +1, rightIndex); // divide o array do meio +1 até o rightIndex
				merge(array,leftIndex, meio, rightIndex); // vai mesclar os arrays 
			}

		}
		throw new IllegalArgumentException("Entrada Inválida");

	}

	private void merge(T[] array, int leftIndex, int meio, int rightIndex) {
		// TODO Auto-generated method stub
		
	}

	private boolean validacao(T[] array, int leftIndex, int rightIndex) {
		boolean result = true;

		if (array == null) {
			result = false;
		}
		if (array.length == 0) {
			result = false;
		}
		if (leftIndex < 0 || rightIndex < 0) {
			result = false;
		}
		if (leftIndex >= array.length || rightIndex >= array.length) {
			result = false;
		}
		if (leftIndex > rightIndex) {
			result = false;
		}
		return result;
	}
}
