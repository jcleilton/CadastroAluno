package dados;

public class Estrutura<T> {
	
	protected T[] elementos;
	protected int tamanho = 0;
	
	@SuppressWarnings("unchecked")
	public Estrutura(){
		this.elementos = (T[]) new Object[10];
	}
	
	@SuppressWarnings("unchecked")
	public Estrutura(int capacidade){
		this.elementos = (T[]) new Object[capacidade];
		
	}
	
	public T adiciona(T objeto){
		this.aumentaCapacidade();
		this.elementos[this.tamanho++] = objeto;
		return this.espiaUltimo();
	}
	
	public boolean estaVazia(){
		if (this.tamanho > 0){
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		String retorno;
		retorno = "[";
		for (int i = 0; i < this.tamanho; i++){
			retorno += "\"";
			retorno += this.elementos[i];
			retorno += "\"";
			if (i < (this.tamanho - 1)){
				retorno += ",\n";
			} 
			
		}
		
		retorno += "]";
		return retorno;
	}
	
	@SuppressWarnings("unchecked")
	private void aumentaCapacidade(){
		if (this.elementos.length == this.tamanho + 1){
			T[] aux = this.elementos;
			this.elementos = (T[]) new Object[this.elementos.length / 3 + this.elementos.length];
			for (int i = 1; i <= this.tamanho; i++){
				this.elementos[i-1]=aux[i-1];
			}
		}
		
	}
	
	public T apagaUltimoFila(){
		@SuppressWarnings("unchecked")
		T objeto = (T) new Object();
		objeto = this.elementos[0];
		for (int i = 1; i <= this.tamanho; i++){
			this.elementos[i - 1] = this.elementos[i];
		}
		tamanho--;
		return objeto;
	}
	
	public T apagaPrimeiroFila(){
		@SuppressWarnings("unchecked")
		T objeto = (T) new Object();
		objeto = this.elementos[tamanho - 1];
		
		tamanho--;
		return objeto;
	}
	
	public T apaga(T objeto){
		for (int i = 0; i < tamanho; i++){
			if (objeto == this.elementos[i]){
				return this.apaga(i);
			}
		}
		return null;
	}
	
	public T apaga(int index) {
		if (tamanho <= 0 || index >= tamanho){
			return null;
		}
		@SuppressWarnings("unchecked")
		T obj = (T) new Object();
		obj = this.elementos[index];
		if (index == tamanho -1){
			tamanho--;
			return obj;
		}
		for (int i=index;i < tamanho; i++){
			this.elementos[i] = this.elementos[i+1];
		}
		return obj;
	}
	
	public int tamanho(){
		return this.tamanho();
	}
	
	public T espiaUltimo(){
		if (this.estaVazia()){
			return null;
		}
		return this.elementos[0];
	}
	
	public T espiaPrimeiro(){
		if (this.estaVazia()){
			return null;
		}
		return this.elementos[tamanho-1];
	}
	
}
