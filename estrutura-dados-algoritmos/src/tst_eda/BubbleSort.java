package tst_eda;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] v = { 5, 13, 3, 4, 2 };
		bubbleSort(v);
		// System.out.println(Arrays.toString(v));

	}

	private static void bubbleSort(int[] v) {
		for (int i = 0; i < v.length - 1; i++) {
			for (int j = 0; j < v.length - i - 1; j++) {
				if (v[j] > v[j + 1]) {
					swap(v, j, j + 1);

				}
			}
		}

	}

	private static void swap(int[] v, int i, int j) {
		int aux = v[i];
		v[i] = v[j];
		v[j] = aux;
	}
}
