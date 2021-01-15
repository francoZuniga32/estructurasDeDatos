package TPOfinal;

public class Dni implements Comparable{
	private String tipo;
	private int numero;
	
	public Dni(String tipoArg, int numeroArg) {
		this.tipo = tipoArg;
		this.numero = numeroArg;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String tipo() {
		return this.tipo;
	}
	
	public int numero() {
		return this.numero;
	}

	public int compareTo(Object elem) {
		Dni dni = (Dni) elem;
		int retorno = 0;
		int compareTipo = this.tipo.compareTo(dni.tipo);
		int compareNumero = this.numero - dni.numero;
		if(compareTipo != 0) {
			retorno = compareTipo;
		}else {
			retorno = compareNumero;
		}
		return retorno;
	}
}
