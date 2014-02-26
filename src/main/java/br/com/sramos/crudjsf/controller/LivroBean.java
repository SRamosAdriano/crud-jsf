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

@ManagedBean(name="livroBean")
@ViewScoped
public class LivroBean extends AbstractController implements Serializable{

	private static final long serialVersionUID = -931442528856567420L;

	@EJB
	LivroBO livroBO;
	
	@EJB
	AutorBO autorBO;
	
	private Livro livro = new Livro();
	
	private List<Livro> livros;
	
	private DualListModel<Autor> autores;
	
	
	public void salvar(){
		try {
			
			List<Autor> autoresAssociados = autores.getTarget();
			if(autoresAssociados.size() > 0){
				livro.setAutores(autoresAssociados);
			}
			
			livroBO.salvar(livro);
			mensagemInformacao("Livro", "Livro salvo com sucesso.");
			livro = new Livro();
			this.livros = null;
			this.autores = null;
		} catch (Exception e) {
			mensagemErroFatal(e, "Erro inesperado", "Erro ao cadastrar livro");
		}
	}
	
	public void editar(Livro livro){
		try {
			this.livro = livro;
			
			List<Autor> autoresDisponiveis = new ArrayList<Autor>();  
	        List<Autor> autoresAssociados = new ArrayList<Autor>(); 
			
			autores = new DualListModel<Autor>(autoresDisponiveis, autoresAssociados); 
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
	
	
	 public void autoresTransferidos(TransferEvent event) {  
	        StringBuilder nomesAutores = new StringBuilder();  
	        for(Object item : event.getItems()) {
	        	Autor autor = (Autor) item;
	            nomesAutores.append(autor.getNome());
	            nomesAutores.append("<br />");  
	        }  
	        mensagemInformacao("Itens transferidos", nomesAutores.toString());
	    }
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public DualListModel<Autor> getAutores() {
		if(autores == null){
			List<Autor> autoresDisponiveis = autorBO.buscarTodos(); 
	        List<Autor> autoresAssociados = new ArrayList<Autor>(); 
			autores = new DualListModel<Autor>(autoresDisponiveis, autoresAssociados);
		}
		return autores;
	}

	public void setAutores(DualListModel<Autor> autores) {
		this.autores = autores;
	}
}
