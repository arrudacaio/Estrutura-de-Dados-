package tst_eda;

public class VetorCircular {

	public static void main(String[] args) {
		
	}

	private static String vetorCircular(int[] v, int quantidade) {
		String result = "";
		int index = 0;
		for (int i = 0; i < quantidade - 1; i++) {
			result += v[index % v.length] + " ";
			index++;
		}
		result += v[index % v.length];
		return result;
	}
}
