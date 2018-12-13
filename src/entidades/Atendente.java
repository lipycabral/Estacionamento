package entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="atendentes")
@NamedQueries({
	@NamedQuery(name="Todos.atendentes", query="SELECT a FROM Atendente a"),
	@NamedQuery(name="Todos.atendentesPorNome", query="SELECT a FROM Atendente a ORDER BY a.nome"),
	@NamedQuery(name="Todos.atendentesPorCpf", query="SELECT a FROM Atendente a ORDER BY a.cpf"),
	@NamedQuery(name="Todos.atendentesPorNomeEspecifico", query="SELECT a FROM Atendente a where a.nome LIKE :nome ORDER BY a.cpf"),
})
public class Atendente {
	@Id
	@Column(length=11)
	private String cpf;
	@Column(length=50, nullable=false)
	private String nome;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="usuario_fk")
	private Usuario usuario;
	@Column(length=50, nullable=false)
	private String rua;
	@Column(nullable=false)
	private int numero;
	@Column(length=50, nullable=false)
	private String bairro;
	@Column(length=30, nullable=false)
	private String cidade;
	@Column(length=2, nullable=false)
	private String uf;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf){
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
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
	
	public String toString() {
		return String.format("CPF=(%s), nome=(%s), Usuario=(%s), Rua=(%s), Numero=(%d), Bairro=(%s), Cidade=(%s), UF=(%s),"
				, getCpf(), getNome(), getUsuario(), getRua(), getNumero(), getBairro(), getCidade(), getUf());
	}
}
