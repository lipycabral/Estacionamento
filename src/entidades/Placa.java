package entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="placas")
public class Placa {
	@Id
	@Column(length=7, nullable=false)
	private String placa;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="mensalista_fk")
	private Mensalista mensalista;
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public Mensalista getMensalista() {
		return mensalista;
	}
	public void setMensalista(Mensalista mensalista) {
		this.mensalista = mensalista;
	}
	public String toString() {
		return String.format("Placa={%s}, Mensalista={%s}", getPlaca(), getMensalista());
	}
}
