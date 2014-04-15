package br.com.jpiva.controller.recursos;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.jpiva.controller.system.DAO;
import br.com.jpiva.model.recursos.Departamento;

@ManagedBean(name = "mb_Departamento")
@SessionScoped
public class DepartamentoController extends DAO<Departamento>{

	private List<Departamento> findAll;
	Departamento departamento = new Departamento();

	public Departamento getDepartamento(){
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento){
		this.departamento = departamento;
	}

	public String insertDepartamento(){
		insertObject(this.departamento);
		this.departamento.setDescription("");
		return null;		
	}

	public Departamento getDepartamentoId(int iddepartamento){		
		Departamento departamento = new Departamento();
		departamento = (Departamento) getObjectId(departamento, "id", iddepartamento);
		return departamento;		
	}
	
	public List getDepartamentoList(){		
		return getObjectList("from Departamento");
	}

	@PostConstruct
	public void construct(){
		findAll = getDepartamentoList();
	}

	public List<Departamento> getFindAll(){
		return findAll;
	}

}
