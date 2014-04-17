package br.com.jpiva.controller.system;

import java.util.ArrayList;
import java.util.List;

import br.com.jpiva.controller.recursos.FunctionController;
import br.com.jpiva.controller.recursos.UsuarioController;
import br.com.jpiva.model.recursos.Function;

public class Teste {
	
	public static void main(String args[]){
		/*
		List l = new ArrayList();
		l = new UsuarioController().getObjectList("from Usuario");
		System.out.println(l);		
		
		Function f = new Function();
		f = (Function) new FunctionController().getFunctionId(2);
		System.out.println(f.getDescription());
		*/
		
		GravaLog.setGravaLog("Usuario", "Inclusão", "Incluindo um cliente");
		GravaLog.setGravaLog("Usuario", "Erro", "na tela");
	}

}
