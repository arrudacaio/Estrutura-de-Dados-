import java.util.*;

public class CountingSortPassoAPasso {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] array = getArray(sc);
		int k = Integer.parseInt(sc.nextLine());

		countingSort(array , k);
		sc.close();
	}

	private static void countingSort(int[] a, int k) {
		int[] c = new int[k + 1]; // Array de contagem
		int[] b = new int[a.length]; // Versão ordenada de A

		// Passo 1: Registrando frequencia dos elementos de A em C
		for (int i = 0; i < a.length; i++) {
			c[a[i]]++;
			System.out.println(strArray(c));
		}

		// Passo 2: Calcular a soma acumulativa de C
		for (int i = 1; i < c.length; i++) {
			c[i] += c[i - 1];
		}
		String result = "Cumulativa do vetor de contagem - " + strArray(c);
		System.out.println(result);

		// Passo 3: Iterar sobre A do fim ao inicio (para manter a estabilidade)
		// registrando
		// em B o valor de A
		int v;
		int posicao;
		for (int i = a.length - 1; i >= 0; i--) {
			v = a[i];
			posicao = --c[v];
			b[posicao] = v;
		}

		// Troca os elementos fora de ordem de A pela versão de A ordenada que é B
		for (int i = 0; i < b.length; i++) {
			a[i] = b[i];
		}

		System.out.println(strArray(c));
		System.out.println(strArray(a));

	}

	private static String strArray(int[] array) {
		String result = "";
		for (int i = 0; i < array.length - 1; i++) {
			result += array[i] + " ";
		}
		result += array[array.length - 1] + "";
		return result;
	}
	
	private static int[] getArray(Scanner scan) {
		String[] entrada = scan.nextLine().split(" ");
		int[] array = new int[entrada.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(entrada[i]);
		}
		return array;
	}

}
