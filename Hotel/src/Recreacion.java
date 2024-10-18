
public class Recreacion {

	private int id;
	private int costoXhora;
	private String tipo;
	private int capacidad;
	public Recreacion(int id, int costoXhora, String tipo ,int capacidad) {
		super();
		this.id = id;
		
		this.costoXhora = costoXhora;
		this.tipo=tipo;
		this.capacidad = capacidad;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public int getCostoXhora() {
		return costoXhora;
	}
	public void setCostoXhora(int costoXhora) {
		this.costoXhora = costoXhora;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "Recreacion [id=" + id + ", capacidad=" + capacidad + ", costoXhora=" + costoXhora + "]";
	}  
	
	
	
	
	
	
	
	
	
	
	
}
