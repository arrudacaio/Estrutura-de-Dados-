package estudando;

public class Fila {
	private int[] valores;
	private int ini;
	private int fim;
	private int total;

	public Fila() {
		this.valores = new int[10];
		this.ini = 0;
		this.fim = 0;
		this.total = 0;
	}

	public void inserir(int e) {
		if (isFull()) {
			throw new RuntimeException("Fila cheia!");
		}
		this.valores[this.fim] = e;
		this.fim = (this.fim + 1) % this.valores.length;
		this.total++;
	}

	public int retirar() {
		if (isEmpty()) {
			throw new RuntimeException("Fila Vazia!");
		}
		int elemento = this.valores[ini];
		this.ini = (ini + 1) % this.valores.length;
		this.total--;
		return elemento;
	}

	public boolean isEmpty() {
		return this.total == 0;

	}

	public boolean isFull() {
		return this.total == this.valores.length;

	}
}
