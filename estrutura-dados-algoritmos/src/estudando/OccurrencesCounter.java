package estudando;

public class OccurrencesCounter {
	
	private int occurencesCounter(int[] array, int x, int leftIndex, int rightIndex) {
		int ocorrencias = 0;
		int primeiraOcorrencia = upperBound(array,x);
		int ultimaOcorrencia = lowerBound(array,x);
		
		if( ultimaOcorrencia != -1 && primeiraOcorrencia != -1) {
			ocorrencias = (ultimaOcorrencia - primeiraOcorrencia)+1;
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

}
