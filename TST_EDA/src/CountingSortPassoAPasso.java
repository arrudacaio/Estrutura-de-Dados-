import java.util.Arrays;

public class CountingSortPassoAPasso {

	public static void main(String[] args) {
		int[] a = { 2, 2, 4, 3, 2, 1, 5 };

		countingSort(a, 5);
	}

	private static void countingSort(int[] a, int k) {
		int[] c = new int[k+1]; // Array de contagem
		int[] b = new int[a.length]; // Versão ordenada de A

		// Passo 1: Registrando frequencia dos elementos de A em C
		for (int i = 0; i < a.length; i++) {
			c[a[i]] += 1;
			System.out.println(Arrays.toString(c));
		}

		// Passo 2: Calcular a soma acumulativa de C
		for (int j = 1; j < c.length; j++) {
			c[j] = c[j] + c[j - 1];
		}
		String result = "Cumulativa do vetor de contagem - " + Arrays.toString(c);
		System.out.println("Cumulativa do vetor de contagem - " + Arrays.toString(c));
		
		// Passo 3: Iterar sobre A do fim ao inicio (para manter a estabilidade)
		// registrando
		// em B o valor de A
		for (int n = a.length - 1; n >= 0; n--) {
			b[c[a[n]] - 1] = a[n];
			c[a[n]] -= 1;
		}

		//Troca os elementos fora de ordem de A pela versão de A ordenada que é B
		for(int p = 0; p < a.length; p++) {
			a[p] = b[p];
		}
		
		System.out.println(Arrays.toString(c));
		System.out.println(Arrays.toString(a));

	}

}
