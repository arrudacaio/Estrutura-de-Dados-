package tst_eda;

import java.util.*;

public class TrocaVizinhos {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String entrada = sc.nextLine();
		int[] lista = transformaEntrada(entrada);
		trocaVizinhos(lista);
		System.out.println(Arrays.toString(lista));

		
	}
	
	private static void trocaVizinhos(int[] v) {
		int tamanho = v.length;
		if(tamanho % 2 != 0) { // se tamanho for ímpar
			tamanho -= 1;
		}

		for(int i = 1; i < tamanho; i+=2) {
			swap(v,i,i-1);
		}
		
	}
	
	private static void swap(int[] v, int i, int j) {
		int aux= v[i];
		v[i] = v[j];
		v[j] = aux;
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
