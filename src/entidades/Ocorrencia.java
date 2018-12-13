package entidades;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="ocorrencias")
@NamedQueries({
	@NamedQuery(name="Recuperar.todos", query="SELECT o from Ocorrencia o ORDER BY o.id")
	
})
public class Ocorrencia {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(nullable=false)
	private Date data;
	@Lob @Basic(fetch=FetchType.LAZY)
	@Column(nullable=false)
	private String descricao;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String toString() {
		return String.format("id={%d}, data={%s}, ocorrido={%s}", getId(), getData(), getDescricao());
	}

}
