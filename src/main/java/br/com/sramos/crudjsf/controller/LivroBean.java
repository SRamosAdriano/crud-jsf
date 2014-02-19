package br.com.sramos.crudjsf.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.sramos.crudjsf.bo.LivroBO;
import br.com.sramos.crudjsf.model.Livro;

@ManagedBean(name="livroBean")
@RequestScoped
public class LivroBean extends AbstractController implements Serializable{

	private static final long serialVersionUID = -931442528856567420L;

	@EJB
	LivroBO livroBO;
	
	private Livro livro = new Livro();
	
	public void salvar(){
		try {
			livroBO.salvar(livro);
			mensagemInformacao("Livro", "Livro salvo com sucesso.");
			livro = new Livro();
		} catch (Exception e) {
			mensagemErroFatal(e, "Erro inesperado", "Erro ao cadastrar usuário");
		}
	}

	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
}
