package tst_eda;

import java.util.*;

public class VerificaPrimo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int entrada = sc.nextInt();
		System.out.println(ehPrimo(entrada));
	}
	
	private static boolean ehPrimo(int v) {
		for(int i = 2; i < v ; i++) {
			if( v % i == 0) {
				return false;
			}
		}
		return true;
	}

}
