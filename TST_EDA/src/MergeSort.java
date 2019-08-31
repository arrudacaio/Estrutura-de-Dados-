
import java.util.*;
// Tirar public do class para não dar erro no TST
class MergeSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] entrada = sc.nextLine().split(" ");
		int[] array = new int[entrada.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(entrada[i]);
		}

		mergeSort(array);
		System.out.println(Arrays.toString(array));
		sc.close();

	}

	private static void mergeSort(int[] array) {
		mergeSort(array, 0, array.length - 1);
	}

	private static void mergeSort(int[] array, int leftIndex, int rightIndex) {
		imprimeArray(array, leftIndex, rightIndex);
		if (leftIndex < rightIndex) {
			int middle = (leftIndex + rightIndex) / 2;
			mergeSort(array, leftIndex, middle);
			mergeSort(array, middle + 1, rightIndex);
			merge(array, leftIndex, middle, rightIndex);

			if (rightIndex - leftIndex < array.length - 1) {
				imprimeArray(array, leftIndex, rightIndex);
			}

		}
	}

	private static void merge(int[] array, int leftIndex, int middle, int rightIndex) {
		int[] aux = Arrays.copyOf(array, array.length);
		int i = leftIndex;
		int k = leftIndex;
		int m = middle + 1;

		while (i <= middle && m <= rightIndex) {
			if (aux[i] < aux[m]) {
				array[k] = aux[i];
				i++;
				k++;
			}
			if (aux[i] > aux[m]) {
				array[k] = aux[m];
				m++;
				k++;
			}
		}

		while (i <= middle) {
			array[k] = aux[i];
			i++;
			k++;

		}
		while (m <= rightIndex) {
			array[k] = aux[m];
			m++;
			k++;
		}

	}

	private static void imprimeArray(int[] array, int leftIndex, int rightIndex) {
		System.out.println(Arrays.toString(Arrays.copyOfRange(array, leftIndex, rightIndex + 1)));
	}

}
