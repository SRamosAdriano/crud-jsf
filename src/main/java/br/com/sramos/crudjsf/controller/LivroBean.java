package br.com.sramos.crudjsf.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sramos.crudjsf.bo.LivroBO;
import br.com.sramos.crudjsf.model.Livro;

@ManagedBean(name="livroBean")
@ViewScoped
public class LivroBean extends AbstractController implements Serializable{

	private static final long serialVersionUID = -931442528856567420L;

	@EJB
	LivroBO livroBO;
	
	private Livro livro = new Livro();
	
	private List<Livro> livros;
	
	public void salvar(){
		try {
			livroBO.salvar(livro);
			mensagemInformacao("Livro", "Livro salvo com sucesso.");
			livro = new Livro();
			this.livros = null;
		} catch (Exception e) {
			mensagemErroFatal(e, "Erro inesperado", "Erro ao cadastrar livro");
		}
	}
	
	public void editar(Livro livro){
		try {
			this.livro = livro;
		} catch (Exception e) {
			mensagemErroFatal(e, "Erro inesperado", "Erro ao editar livro");
		}
	}
	
	public void excluir(Livro livro){
		try {
			livroBO.deletar(livro);
			mensagemInformacao("Livro", "Livro excluido com sucesso.");
			this.livros = null;
		} catch (Exception e) {
			mensagemErroFatal(e, "Erro inesperado", "Erro ao excluir livros");
		}
	}

	public List<Livro> getLivros() {
		if(this.livros == null){
			try {
				this.livros = livroBO.buscarTodos();
			} catch (Exception e) {
				mensagemErroFatal(e, "Erro inesperado", "Erro ao recuperar todos os livros");
			}
		}
		return livros;
	}
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
}
