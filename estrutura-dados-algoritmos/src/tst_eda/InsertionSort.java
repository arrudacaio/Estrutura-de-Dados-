package tst_eda;

import java.util.*;

public class InsertionSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String entrada = sc.nextLine();
		insertionLast(transformaEntrada(entrada));
		
		

	}
	

	private static void insertionLast(int[] v) {
		int i = v.length - 1;
		while(i > 0 && v[i] < v[i-1]) {
			swap(v , i, i-1);
			i--;
		}
		System.out.println(Arrays.toString(v));
	}
	
	private static void swap(int[] v, int i, int j) {
		int aux = v[i];
		v[i] = v[j];
		v[j] = aux;
	}
	
	private static int[] transformaEntrada(String entrada) {
		String[] modified = entrada.split(" ");
		int[] lista = new int[modified.length];
		
		for(int i = 0; i < lista.length; i++) {
			lista[i] = Integer.parseInt(modified[i]);
		}
		return lista;
	}
}
