import java.util.*;

public class OrdenacaoLinear {

	public static void main(String[] args) {
		int[] a = {19, 1, 3, 4, 6, 7};
		System.out.println(Arrays.toString(sort(a, 19)));

	}

	/*
	 * Todos os elementos do array que vamos ordenar são inteiros positivos (1, 2, 3…k);
	 * Não há repetição de elementos no array que vamos ordenar;
	 * Sabemos o maior valor desse array, o qual chamamos de k.
	 * 
	 */
	private static int[] sort(int[] a, int maiorE) {
		boolean[] c = new boolean[maiorE];

		// Registrando a presença de A[i] na sequência
		// Elemento - 1
		for (int i = 0; i < a.length; i++) {
			c[a[i] - 1] = true;
		}

		int j = 0;
		int[] b = new int[a.length];
		

		// Indice - 1
		for (int k = 0; k < c.length; k++) {
			if (c[k] == true) {
				b[j] = k + 1;
				j += 1;
			}
		}

		return b;

	}

}
