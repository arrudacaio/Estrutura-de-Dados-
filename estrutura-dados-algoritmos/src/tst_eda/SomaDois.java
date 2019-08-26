package tst_eda;

import java.util.*;

public class SomaDois {

	public static void main(String[] args) {
		//fazer entrada?
	}

	private static int[] somaDois(int[] v, int target) {
		int[] soma = new int[2];

		for (int i = 0; i < v.length; i++) {
			for (int j = i + 1; j < v.length; j++) {
				if (v[i] + v[j] == target) {
					int tamanho = 0;
					if (tamanho < soma.length) {
						soma[tamanho] = v[i];
						tamanho++;
						soma[tamanho] = v[j];
					}
				}

			}
		}
		return soma;

	}

}
