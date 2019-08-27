package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		boolean valid = validationInput(array, leftIndex, rightIndex);

		if (valid) {
			for (int i = leftIndex; i <= rightIndex; i++) {
				int menorInicial = i;
				for (int j = i + 1; j <= rightIndex; j++) {
					if (array[j].compareTo(array[menorInicial]) < 0) {
						menorInicial = j;
					}
				}
				Util.swap(array, menorInicial, i);
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
