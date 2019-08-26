package tst_eda;

public class TemRepetido {

	public static void main(String[] args) {
		// falta o main
	}

	private static boolean temRepetido(int[] v) {
		boolean result = false;
		for (int i = 0; i < v.length; i++) {
			for (int j = i + 1; j < v.length; j++) {
				if (v[i] == v[j]) {
					result = true;
				}
			}
		}
		return result;

	}

}
