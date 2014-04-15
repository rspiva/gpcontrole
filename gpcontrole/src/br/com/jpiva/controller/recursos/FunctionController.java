package br.com.jpiva.controller.recursos;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.jpiva.controller.system.DAO;
import br.com.jpiva.model.recursos.Function;

@ManagedBean(name = "mb_Function")
@SessionScoped
public class FunctionController extends DAO<Function>{

	private List<Function> findAll;
	Function function = new Function();

	public Function getFunction(){
		return this.function;
	}

	public void setFunction(Function function){
		this.function = function;
	}

	public String insertFunction(){

		insertObject(this.function);
		this.function.setDescription("");
		return null;
	}

	public Function getFunctionId(int idFunction){
		
		Function function = new Function();
		function = (Function) getObjectId(function, "id", idFunction);
		return function;
	}
	
	public List getFunctionList(){
		
		return getObjectList("from Function");
	}

	@PostConstruct
	public void construct(){
		findAll = getFunctionList();
	}

	public List<Function> getFindAll(){
		return findAll;
	}

}
