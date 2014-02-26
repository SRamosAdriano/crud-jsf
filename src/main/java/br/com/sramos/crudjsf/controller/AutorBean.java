package br.com.sramos.crudjsf.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sramos.crudjsf.bo.AutorBO;
import br.com.sramos.crudjsf.model.Autor;

@ManagedBean(name="autorBean")
@ViewScoped
public class AutorBean extends AbstractController implements Serializable{

	private static final long serialVersionUID = -308338667593521278L;
	
	private Autor autor = new Autor();
	
	private List<Autor> autores;
	
	@EJB
	AutorBO autorBO;

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public List<Autor> getAutores() {
		if(this.autores == null){
			this.autores = autorBO.buscarTodos();
		}
		return autores;
	}
}
