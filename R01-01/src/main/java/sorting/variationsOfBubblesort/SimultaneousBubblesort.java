package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This algorithm applies two bubblesorts simultaneously. In a same iteration, a
 * bubblesort pushes the greatest elements to the right and another bubblesort
 * pushes the smallest elements to the left. At the end of the first iteration,
 * the smallest element is in the first position (index 0) and the greatest
 * element is the last position (index N-1). The next iteration does the same
 * from index 1 to index N-2. And so on. The execution continues until the array
 * is completely ordered.
 */
public class SimultaneousBubblesort<T extends Comparable<T>> extends AbstractSorting<T> {
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (validationInput(array, leftIndex, rightIndex)) {
			int inicio = leftIndex;
			int fim = rightIndex;

			if (inicio < rightIndex) {
				if (array[inicio].compareTo(array[inicio + 1]) > 0) {
					Util.swap(array, inicio, inicio + 1);
				}

				inicio++;
				sort(array, inicio, rightIndex);
			}

			if (fim > leftIndex) {
				if (array[fim].compareTo(array[fim - 1]) < 0) {
					Util.swap(array, fim, fim - 1);
				}

				fim--;
				sort(array, leftIndex, fim);
			}
		}
	}

	private boolean validationInput(T[] array, int leftIndex, int rightIndex) {
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
