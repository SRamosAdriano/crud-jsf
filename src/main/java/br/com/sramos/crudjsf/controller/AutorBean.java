package br.com.sramos.crudjsf.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

import br.com.sramos.crudjsf.bo.AutorBO;
import br.com.sramos.crudjsf.bo.LivroBO;
import br.com.sramos.crudjsf.model.Autor;
import br.com.sramos.crudjsf.model.Livro;

@ManagedBean(name="autorBean")
@ViewScoped
public class AutorBean extends AbstractController implements Serializable{

	private static final long serialVersionUID = -308338667593521278L;
	
	private Autor autor = new Autor();
	
	private List<Autor> autores;
	
	private DualListModel<Livro> livros;
	
	@EJB
	AutorBO autorBO;
	
	@EJB
	LivroBO livroBO;

	
	public void salvar(){
		try {
			List<Livro> livrosAssociados = this.livros.getTarget();
			this.autor.setLivros(livrosAssociados);
			
			this.autorBO.salvar(this.autor);
			mensagemInformacao("Autor", "Autor salvo com sucesso.");
			this.autor = new Autor();
			this.livros = null;
			this.autores = null;
		} catch (Exception e) {
			mensagemErroFatal(e, "Erro inesperado", "Erro ao cadastrar livro");
		}
	}
	
	public void livrosTransferidos(TransferEvent event) {
		StringBuilder nomesAutores = new StringBuilder();
		for (Object item : event.getItems()) {
			Livro livro = (Livro) item;
			nomesAutores.append(livro.getNome());
			nomesAutores.append("<br />");
		}
		mensagemInformacao("Itens transferidos", nomesAutores.toString());
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

	public DualListModel<Livro> getLivros() {
		if(livros == null){
			List<Livro> livrosDisponiveis = this.livroBO.buscarTodos(); 
	        List<Livro> livrosAssociados = new ArrayList<Livro>(); 
	        this.livros = new DualListModel<Livro>(livrosDisponiveis, livrosAssociados);
		}
		return livros;
	}

	public void setLivros(DualListModel<Livro> livros) {
		this.livros = livros;
	}
}
