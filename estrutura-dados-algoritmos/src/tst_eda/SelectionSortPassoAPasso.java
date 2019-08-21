package tst_eda;

import java.util.*;

public class SelectionSortPassoAPasso {
	
	// tirar o public da classe principal para não dar erro SSSSs

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String entrada = sc.nextLine();
		int[] lista = transformaEntrada(entrada);
		selectionSort(lista);
		sc.close();

	}

	private static void selectionSort(int[] v) {
		for (int i = 0; i < v.length; i++) {
			int m_inicial = i;
			for (int j = i + 1; j < v.length; j++) {
				if (v[j] < v[m_inicial]) {
					m_inicial = j;
				}
			}
			// swap
			swap(v, m_inicial, i);
			if (m_inicial != i) {
				System.out.println(Arrays.toString(v));
			}
		}
	}

	private static void swap(int[] v, int i, int j) {
		int aux = v[i];
		v[j] = v[i];
		v[i] = aux;
	}
	
	
	private static int[] transformaEntrada(String entrada) {
		String[] modified = entrada.split(" ");
		int[] v = new int[modified.length];
		for (int i = 0; i < modified.length; i++) {
			v[i] = Integer.parseInt(modified[i]);

		}
		return v;
	}

}
