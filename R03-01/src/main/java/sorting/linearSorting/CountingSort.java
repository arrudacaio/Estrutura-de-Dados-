package sorting.linearSorting;

import java.util.Arrays;

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
			Integer k = procuraK(array, leftIndex, rightIndex);
			Integer[] contador = new Integer[k + 1];
			Integer[] b = new Integer[array.length];

			Arrays.fill(contador, 0); 
 
			for (int i = leftIndex; i <= rightIndex; i++) { // P1) Contagem de ocorrencia
				contador[array[i]] += 1;
			}

			for (int i = 1; i < contador.length; i++) { // P2) Cumulativa em C
				contador[i] += contador[i - 1];
			}

			for (int i = rightIndex; i >= leftIndex; i--) { 
				b[contador[array[i]]-1] = array[i];
				contador[array[i]]--;
			}

			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = b[i];
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
