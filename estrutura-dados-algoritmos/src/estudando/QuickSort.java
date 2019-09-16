package estudando;

public class QuickSort {

	private void mergeSort(int[] v, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int pivot = particiona(v, leftIndex, rightIndex);
			mergeSort(v, leftIndex, pivot - 1);
			mergeSort(v, pivot + 1, rightIndex);
		}
	}

	private int particiona(int[] v, int leftIndex, int rightIndex) {

		int pivot = v[leftIndex];
		int inicial = leftIndex;
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (v[i] < pivot) {
				inicial++;
				swap(v, i, inicial);
			}
		}
		swap(v, leftIndex, inicial);
		return inicial;
	}

	private void swap(int[] v, int i, int j) {
		int aux = v[i];
		v[i] = v[j];
		v[j] = aux;
	}

	// Relembrando busca binária
	private int binarySearch(int[] v, int x, int leftIndex, int rightIndex) {
		int middle = (leftIndex + rightIndex) / 2;

		if (v[middle] == x) {
			return middle;
		}
		if (v[middle] < x) {
			binarySearch(v, x, middle + 1, rightIndex);
		}
		if (v[middle] > x) {
			binarySearch(v, x, leftIndex, middle - 1);
		}

		return -1;
	}


}
