package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="mensalistas")
@NamedQueries({
	@NamedQuery(name="Todos.mensalistas", query="SELECT m from Mensalista m ORDER BY m.cpf")
})
public class Mensalista {
	
	@Column(length=11)
	@Id
	private String cpf;
	@Column(length=50, nullable=false)
	private String nome;
	@Column(length=50, nullable=false)
	private String rua;
	@Column(nullable=false)
	private int num;
	@Column(length=30, nullable=false)
	private String bairro;
	@Column(length=40, nullable=false)
	private String cidade;
	@Column(length=2, nullable=false)
	private String uf;
	
	@OneToMany(mappedBy="mensalista", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Placa> placas = new ArrayList<Placa>();


	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<Placa> getPlacas() {
		return placas;
	}

	public void setPlacas(List<Placa> placas) {
		this.placas = placas;
	}
	public void adicionarPlaca(Placa placa) {
		placa.setMensalista(this);
		placas.add(placa);
	}
	public void removerPlaca(Placa placa) {
		placa.setMensalista(null);
		placas.remove(placa);
	}
	public Placa getPlacaEspecifica(String placaI) {
		for (Placa placa : placas) {
			if(placa.getPlaca().equals(placaI)) {
				return placa;
			}
		}
		return null;
	}

	
	public String toString() {
		return String.format("cpf=(%s), nome=(%s), placas=(%d)", getCpf(),getNome(), placas.size());
	}
	

}
