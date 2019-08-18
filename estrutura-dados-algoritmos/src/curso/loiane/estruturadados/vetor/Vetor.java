package curso.loiane.estruturadados.vetor;

public class Vetor {
	
	private String[] elementos;
	private int tamanho;
	
	public Vetor(int capacidade) {
		this.elementos = new String[capacidade];
		this.tamanho = 0;
		
	}
	
	
	// Essa forma de fazer não é eficiente quando tivermos um array de centenas posições
	/*public void adiciona(String elemento) {
		for(int i = 0; i < this.elementos.length ; i++) {
			if(this.elementos[i] == null) {
				this.elementos[i] = elemento;
				break;
			}
		}
	}*/
	
	/* Mais eficiente, pois não é necessário percorrer todo 
	o array em busca de uma posição valida*/
	public boolean adiciona(String elemento)  {
		boolean retorno = false ;
		if(this.tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho ++;
			retorno = true;
		} 
		return retorno;
	}

}
