package sorting.divideAndConquer.threeWayQuicksort;

import sorting.AbstractSorting;
import util.Util;

public class ThreeWayQuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	/**
	 * No algoritmo de quicksort, selecionamos um elemento como pivot, particionamos
	 * o array colocando os menores a esquerda do pivot e os maiores a direita do
	 * pivot, e depois aplicamos a mesma estrategia recursivamente na particao a
	 * esquerda do pivot e na particao a direita do pivot.
	 * 
	 * Considerando um array com muitoe elementos repetidos, a estrategia do
	 * quicksort pode ser otimizada para lidar de forma mais eficiente com isso.
	 * Essa melhoria eh conhecida como quicksort tree way e consiste da seguinte
	 * ideia: - selecione o pivot e particione o array de forma que * arr[l..i]
	 * contem elementos menores que o pivot * arr[i+1..j-1] contem elementos iguais
	 * ao pivot. * arr[j..r] contem elementos maiores do que o pivot.
	 * 
	 * Obviamente, ao final do particionamento, existe necessidade apenas de ordenar
	 * as particoes contendo elementos menores e maiores do que o pivot. Isso eh
	 * feito recursivamente.
	 **/
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (verifica(array, leftIndex, rightIndex)) {
			if (leftIndex < rightIndex) {
				int mid = leftIndex + (rightIndex - leftIndex) / 2;
				medianOfThree(array, leftIndex, mid, rightIndex);
				Util.swap(array, mid, rightIndex - 1);
				int pivot = particion(array, leftIndex + 1, rightIndex - 1);

				sort(array, leftIndex, pivot - 1);
				sort(array, pivot + 1, rightIndex);

			}
		}
	}

	private void medianOfThree(T[] array, int leftIndex, int mid, int rightIndex) {

		if (array[leftIndex].compareTo(array[rightIndex]) > 0) {
			Util.swap(array, leftIndex, rightIndex);
		}

		if (array[mid].compareTo(array[rightIndex]) > 0) {
			Util.swap(array, mid, rightIndex);
		}

		if (array[leftIndex].compareTo(array[mid]) > 0) {
			Util.swap(array, leftIndex, mid);
		}
	}

	private int particion(T[] array, int leftIndex, int rightIndex) {

		T pivot = array[leftIndex - 1];
		int inicial = leftIndex - 1;

		for (int j = leftIndex; j < rightIndex; j++) {
			if (array[j].compareTo(pivot) < 0) {
				inicial++;
				Util.swap(array, inicial, j);
			}
		}

		Util.swap(array, leftIndex - 1, inicial);
		return inicial;

	}

	private boolean verifica(T[] array, int leftIndex, int rightIndex) {
		boolean result = true;

		if (array == null || array.length <= 0) {
			result = false;
		} else if (leftIndex >= rightIndex || leftIndex < 0) {
			result = false;
		} else if (rightIndex > array.length || leftIndex >= array.length || rightIndex <= 0) {
			result = false;
		}

		return result;
	}

}
