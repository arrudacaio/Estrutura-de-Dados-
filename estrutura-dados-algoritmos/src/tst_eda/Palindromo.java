package tst_eda;

public class Palindromo {

	public static void main(String[] args) {
		char[] palavra = {'a','n','o'};
		System.out.println(eh_palindromo(palavra));
		
	}

	private static boolean eh_palindromo(char[] palavra) {
		String junto = "";
		String inverso = "";
		int j = 0;
		while(j < palavra.length) {
			junto += palavra[j];
			j++;
		}
		
		int i = palavra.length-1;
		while(i > -1) {
			inverso += palavra[i];
			i--;
		}
 
		if(junto.equals(inverso)) {
			return true;
		}
		return false;
	}
}
