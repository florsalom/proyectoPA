import java.time.LocalDate;

public class Habitaciones {

	private int id;
	private int costoXdia;
	private String tipo;
	public Habitaciones(int id, int costoXdia, String tipo) {
		super();
		this.id = id;
		this.costoXdia = costoXdia;
		this.tipo = tipo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCostoXdia() {
		return costoXdia;
	}
	public void setCostoXdia(int costoXdia) {
		this.costoXdia = costoXdia;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "Habitaciones [id=" + id + ", costoXdia=" + costoXdia + ", tipo=" + tipo + "]";
	}

}