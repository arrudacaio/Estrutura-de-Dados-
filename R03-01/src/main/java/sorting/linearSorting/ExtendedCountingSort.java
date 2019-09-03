package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		boolean isValid = validacao(array, leftIndex, rightIndex);
		if (isValid) {
			int maior = maior(array, leftIndex, rightIndex);
			int menor = menor(array, leftIndex, rightIndex);
			int[] aux = new int[(maior - menor) + 1];
			int[] saida = new int[array.length];

			for (int i = leftIndex; i <= rightIndex; i++) { // Conta as ocorrencias
				aux[array[i] - menor]++;
			}

			for (int i = 1; i < aux.length; i++) { // Cumulativa
				aux[i] += aux[i - 1];
			}

			for (int i = leftIndex; i <= rightIndex; i++) {
				saida[aux[array[i] - menor] - 1] = array[i];
				aux[array[i] - menor]--;
			}

			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = saida[i];
			}
		}

	}

	private int maior(Integer[] array, int leftIndex, int rightIndex) {
		int maior = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > maior) {
				maior = array[i];
			}
		}
		return maior;
	}

	private int menor(Integer[] array, int leftIndex, int rightIndex) {
		int menor = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < menor) {
				menor = array[i];
			}
		}
		return menor;
	}

	private boolean validacao(Integer[] array, int leftIndex, int rightIndex) {
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
