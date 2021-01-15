package TPOfinal;

public class Cliente implements Comparable{
	private Dni dni;
	private String nombre;
	private String apellido;
	private String fechaNacimiento;
	private String domicilio;
	private String telefono;
	
	public Cliente(Dni dniParam) {
		this.dni = dniParam;
	}
	
	public Cliente(Dni dniParam, String nombreParam, String apellidoParam, String fechaParam, String domiciolioParam, String telefonoParam) {
		this.dni = dniParam;
		this.nombre = nombreParam;
		this.apellido = apellidoParam;
		this.fechaNacimiento = fechaParam;
		this.domicilio = domiciolioParam;
		this.telefono = telefonoParam;
	}
	
	public void setNombre(String nombreParam) {
		this.nombre = nombreParam;
	}
	
	public void setApellido(String apellidoParam) {
		this.apellido = apellidoParam;
	}
	
	public void setFechaNacimiento(String fechaParam) {
		this.fechaNacimiento = fechaParam;
	}
	
	public void setTelefono(String telefonoParam) {
		this.telefono = telefonoParam;
	}
	
	public void serDomicilio(String domicilioParam) {
		this.domicilio = domicilioParam;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getApellido() {
		return this.apellido;
	}
	
	public String getFechaNaciento() {
		return this.fechaNacimiento;
	}
	
	public String getTelefono() {
		return this.telefono;
	}

	@Override
	public int compareTo(Object elemento) {
		// TODO Auto-generated method stub
		Cliente dniAux = (Cliente) elemento;
		return this.dni.compareTo((Dni) dniAux.dni);
	}
}
