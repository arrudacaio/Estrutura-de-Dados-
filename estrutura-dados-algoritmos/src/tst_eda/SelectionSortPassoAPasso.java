package tst_eda;

import java.util.*;

public class SelectionSortPassoAPasso {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String entrada = sc.nextLine();
		int[] lista = transformaEntrada(entrada);
		selectionSort(lista);
		sc.close();

	}

	public static void selectionSort(int[] v) {
		for (int i = 0; i < v.length; i++) {
			int m_inicial = i;
			for (int j = i + 1; j < v.length; j++) {
				if (v[j] < v[m_inicial]) {
					m_inicial = j;
				}
			}
			// swap, estudar isso
			int aux = v[i];
			v[i] = v[m_inicial];
			v[m_inicial] = aux;
			if (m_inicial != i) {
				System.out.println(Arrays.toString(v));
			}
		}
	}

	public static int[] transformaEntrada(String entrada) {
		String[] modified = entrada.split(" ");
		int[] v = new int[modified.length];
		for (int i = 0; i < modified.length; i++) {
			v[i] = Integer.parseInt(modified[i]);

		}
		return v;
	}

}
