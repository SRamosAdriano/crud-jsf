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
	
	
	public void salvar(){
		try {
			this.autorBO.salvar(this.autor);
			mensagemInformacao("Autor", "Autor salvo com sucesso.");
			this.autor = new Autor();
			this.autores = null;
		} catch (Exception e) {
			mensagemErroFatal(e, "Erro inesperado", "Erro ao cadastrar autor");
		}
	}
	
	public void excluir(Autor autor){
		try {
			this.autorBO.excluir(autor);
			mensagemInformacao("Autor", "Autor removido com sucesso.");
			this.autor = new Autor();
			this.autores = null;
		} catch (Exception e) {
			mensagemErroFatal(e, "Erro inesperado", "Erro ao excluir autor");
		}
	}
	
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
