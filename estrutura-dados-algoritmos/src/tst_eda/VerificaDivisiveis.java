package tst_eda;

public class VerificaDivisiveis {

	public static void main(String[] args) {
		int[] v= {5,13,3,4,8};
		

	}
	
	private static boolean verifica_divisiveis(int[] v) {
		for(int i = 1; i < v.length; i++) {
			if(v[i] % v[i-1] == 0) {
				return true;
			}
		} 
		return false;
	
	}
}
