package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (validacao(array, leftIndex, rightIndex)) {
			// Procurando o K
			int k = procuraK(array, leftIndex, rightIndex);
			int[] c = new int[k + 1];
			int[] b = new int[array.length];

			for (int i = 0; i < c.length; i++) { // Preenche todos os elementos de C com 0
				c[i] = 0;
			}

			for (int i = leftIndex; i <= rightIndex; i++) { // P1) Contagem de ocorrencia
				c[array[i]]+=1;
			}

			for (int i = 1; i < c.length; i++) { // P2) Cumulativa em C
				c[i] += c[i - 1];
			}

			for (int i = rightIndex; i >= leftIndex; i--) {
				b[--c[array[i]]] = array[i]; 
			}

			for (int i = 0; i <= rightIndex - leftIndex; i++) {
				array[i + leftIndex] = b[i];  
			}

		}

	}

	private int procuraK(Integer[] array, int leftIndex, int rightIndex) {
		int maior = array[leftIndex];
		for (int i = 1; i <= rightIndex; i++) {
			if (array[i] > maior) {
				maior = array[i];
			}
		}
		return maior;
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
