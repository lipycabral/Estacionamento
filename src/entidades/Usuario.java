package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	@Id
	@Column(length=11)
	private String usuario;
	@Column(length=50, nullable=false)
	private String senha;
	
	public String getUsuario() {
		return usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setUsuario(String cpf) {
		this.usuario = cpf;
	}
	public String toString() {
		return String.format("Usuario=(%s), Senha=(%s)", usuario, senha);
	}
	
}
