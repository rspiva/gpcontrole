package br.com.jpiva.controller.system;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.jpiva.model.recursos.Usuario;


@ManagedBean(name = "mb_portal")
public class PortalController {
	
	FacesContext context = FacesContext.getCurrentInstance();
	
	public Usuario getUserSessao(){
		
		return (Usuario) context.getExternalContext().getSessionMap().get(AcessoController.USER_SESSION_KEY);
		
	}

}
