package estudando;

public class OccurrencesCounter {

	public static void main(String[] args) {
		int[] v = { -2, 3, 4, 1, 5, 21, -1 };
		System.out.println(orderStatic(v, 4));
	}

	private int occurencesCounter(int[] array, int x, int leftIndex, int rightIndex) {
		int ocorrencias = 0;
		int primeiraOcorrencia = upperBound(array, x);
		int ultimaOcorrencia = lowerBound(array, x);

		if (ultimaOcorrencia != -1 && primeiraOcorrencia != -1) {
			ocorrencias = (ultimaOcorrencia - primeiraOcorrencia) + 1;
		}
		return ocorrencias;

	}

	private int lowerBound(int[] v, int x) {
		int lower = -1;
		int start = 0;
		int last = v.length;

		while (start < last) {
			int middle = (start + last) / 2;
			if (v[middle] == x) {
				lower = middle;
				last = middle - 1;
			} else if (v[middle] > x) {
				last = middle - 1;
			} else if (v[middle] < x) {
				start = middle + 1;
			}

		}

		return lower;
	}

	private int upperBound(int[] v, int x) {
		int upper = -1;
		int start = 0;
		int last = v.length;

		while (start < last) {
			int middle = (start + last) / 2;
			if (v[middle] == x) {
				upper = middle;
				last = middle - 1;
			} else if (v[middle] > x) {
				last = middle - 1;
			} else if (v[middle] < x) {
				start = middle + 1;

			}
		}

		return upper;
	}

	public static int orderStatic(int[] array, int k) {
		int maior = maior(array);
		int menor = menor(array);
		k--;
		while (k > 0) {
			int aux = maior;
			for (int i = 0; i < array.length; i++) {
				if (array[i] > menor && array[i] < aux) {
					aux = array[i];
				}
			}
			menor = aux;
			k--;
		}
		return menor;
	}

	private static int maior(int[] array) {
		int maior = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > maior) {
				maior = array[i];
			}
		}
		return maior;
	}

	private static int menor(int[] array) {
		int menor = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < menor) {
				menor = array[i];
			}
		}
		return menor;
	}

}
