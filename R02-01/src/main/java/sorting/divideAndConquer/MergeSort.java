package sorting.divideAndConquer;

import java.util.Arrays;

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
			if (leftIndex < rightIndex) {
				int meio = (leftIndex + rightIndex) / 2;
				sort(array, leftIndex, meio);
				sort(array, meio + 1, rightIndex);
				merge(array, leftIndex, meio, rightIndex);
			}

		}

	}

	private void merge(T[] array, int leftIndex, int meio, int rightIndex) {
		T[] aux = Arrays.copyOf(array, array.length); // Preenchendo o array auxiliar com os mesmos elementos do array
														// original
		int i = leftIndex;
		int k = leftIndex;
		int middle = meio + 1;

		while (i <= meio && middle <= rightIndex) { // Compara os elementos da primeira metade do array com os da
													// segunda e preenche ordenado o array auxiliar.

			if (aux[i].compareTo(aux[middle]) < 0) {
				array[k] = aux[i];
				i++;
			} else {
				array[k] = aux[middle];
				middle++;
			}
			k++;
		}

		while (i <= meio) { // Preenche o array auxiliar caso tenha acabado os elementos da segunda metade
							// do array original.
			array[k] = aux[i];
			i++;
			k++;

		}

		while (middle <= rightIndex) { // Preenche o array auxiliar caso já tenha acabado os elementos da primeira
										// metade do array original.
			array[k] = aux[middle];
			middle++;
			k++;
		}

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
