import java.time.LocalDateTime;

public class ReservaRecreacion {

	private int id;
	private int id_cliente_fk;
	private int id_recreacion_fk;
	private LocalDateTime inicio;
	private LocalDateTime fin;
	public ReservaRecreacion(int id, int id_cliente_fk, int id_recreacion_fk, LocalDateTime inicio, LocalDateTime fin) {
		super();
		this.id = id;
		this.id_cliente_fk = id_cliente_fk;
		this.id_recreacion_fk = id_recreacion_fk;
		this.inicio = inicio;
		this.fin = fin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_cliente_fk() {
		return id_cliente_fk;
	}
	public void setId_cliente_fk(int id_cliente_fk) {
		this.id_cliente_fk = id_cliente_fk;
	}
	public int getId_recreacion_fk() {
		return id_recreacion_fk;
	}
	public void setId_recreacion_fk(int id_recreacion_fk) {
		this.id_recreacion_fk = id_recreacion_fk;
	}
	public LocalDateTime getInicio() {
		return inicio;
	}
	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}
	public LocalDateTime getFin() {
		return fin;
	}
	public void setFin(LocalDateTime fin) {
		this.fin = fin;
	}
	@Override
	public String toString() {
		return "ReservaRecreacion [id=" + id + ", id_cliente_fk=" + id_cliente_fk + ", id_recreacion_fk="
				+ id_recreacion_fk + ", inicio=" + inicio + ", fin=" + fin + "]";
	}
	
	
}
