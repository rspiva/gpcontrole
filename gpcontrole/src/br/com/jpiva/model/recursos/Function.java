package br.com.jpiva.model.recursos;

import java.util.Date;
import javax.persistence.*;


@Entity
@Table( name="tb_function")
public class Function{

	@Id@GeneratedValue
	@Column (name="id")
	private int id;

	@Column (name="description")
	private String description;

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public String getDescription(){
		return description;
	}

	public void setDescription(String description){
		this.description = description;
	}

}