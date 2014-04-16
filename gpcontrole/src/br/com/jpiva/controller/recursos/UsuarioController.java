package br.com.jpiva.controller.recursos;

import br.com.jpiva.model.recursos.*;
import java.util.*;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.jpiva.controller.system.DAO;
import br.com.jpiva.model.recursos.Usuario;

@ManagedBean(name = "mb_Usuario")
@RequestScoped
public class UsuarioController extends DAO<Usuario>{

	private List<Usuario> findAll;
	Usuario usuario = new Usuario();
	int idFunction;
	int idDepartamento;

	public Usuario getUsuario(){
		return this.usuario;
	}

	public void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}

	public int getIdFunction(){
		return this.idFunction;
	}

	public void setIdFunction( int idFunction){
		this.idFunction = idFunction;
	}

	public int getIdDepartamento(){
		return this.idDepartamento;
	}

	public void setIdDepartamento( int idDepartamento){
		this.idDepartamento = idDepartamento;
	}


	public String insertUsuario(){

		this.usuario.setFunction(new FunctionController().getFunctionId(this.idFunction));
		this.usuario.setDepartamento(new DepartamentoController().getDepartamentoId(this.idDepartamento));
		insertObject(usuario);
		this.usuario.setName("");
		this.usuario.setCpf("");
		this.usuario.setSnAtivo(false);
		this.usuario.setDtCadastro(null);
		this.idFunction = 0;
		this.idDepartamento = 0;
		this.usuario.setEmail("");
		this.usuario.setLogin("");
		this.usuario.setPassword("");
		return null;
	}

	public Usuario getUsuarioId(int idusuario){
		Usuario usuario = new Usuario();
		usuario = (Usuario) getObjectId(usuario,"id", idusuario);
		return null;
	}
	public List getUsuarioList(){
		return getObjectList("from Usuario");
	}

	@PostConstruct
	public void construct(){
		findAll = getUsuarioList();
	}

	public List<Usuario> getFindAll(){
		return findAll;
	}
	
	public Usuario getUsuarioEmail(String email){
		Usuario usuarioEmail = new Usuario();
		Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
		
        try{
	        //Filtro conforme o id do parametro
	        Criteria filter = session.createCriteria(Usuario.class);
			filter.add(Restrictions.eq("email", email));
			usuarioEmail = (Usuario) filter.uniqueResult();
			transaction.commit();
			
		}catch(Throwable e){
			System.out.println("Erro na operação de busca" + e.getMessage());
			transaction.rollback();
		}finally{
			session.close();
		}
     	return usuarioEmail;
		
	}

}
