package br.com.jpiva.model.recursos;

import java.util.Date;
import javax.persistence.*;


@Entity
@Table( name="tb_usuario")
public class Usuario{

	@Id@GeneratedValue
	@Column (name="id")
	private int id;

	@Column (name="name")
	private String name;

	@Column (name="cpf")
	private String cpf;

	@Column (name="sn_ativo", columnDefinition = "TINYINT(3)")
	private boolean snAtivo;

	@Column (name="dt_cadastro")
	private Date dtCadastro;

	@ManyToOne
	@JoinColumn(name = "id_function")
	private Function function;

	@ManyToOne
	@JoinColumn(name = "id_departamento")
	private Departamento departamento;

	@Column (name="email")
	private String email;

	@Column (name="login")
	private String login;

	@Column (name="password")
	private String password;

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getCpf(){
		return cpf;
	}

	public void setCpf(String cpf){
		this.cpf = cpf;
	}

	public boolean isSnAtivo(){
		return snAtivo;
	}

	public void setSnAtivo(boolean snAtivo){
		this.snAtivo = snAtivo;
	}

	public Date getDtCadastro(){
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro){
		this.dtCadastro = dtCadastro;
	}

	public Function getFunction(){
		return function;
	}

	public void setFunction(Function function){
		this.function = function;
	}

	public Departamento getDepartamento(){
		return departamento;
	}

	public void setDepartamento(Departamento departamento){
		this.departamento = departamento;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getLogin(){
		return login;
	}

	public void setLogin(String login){
		this.login = login;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}

}