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
			
			List<Autor> autoresAssociados = this.autores.getTarget();
			this.livro.setAutores(autoresAssociados);
			
			this.livroBO.salvar(this.livro);
			mensagemInformacao("Livro", "Livro salvo com sucesso.");
			this.livro = new Livro();
			this.livros = null;
			this.autores = null;
		} catch (Exception e) {
			mensagemErroFatal(e, "Erro inesperado", "Erro ao cadastrar livro");
		}
	}
	
	public void editar(Livro livro){
		try {
			this.livro = livro;
			
			List<Autor> autoresDisponiveis = this.autorBO.buscarTodos();  
	        List<Autor> autoresAssociados = this.autorBO.buscarPorIdLivro(this.livro.getId()); 
			
	        for (int i = 0 ; i < autoresDisponiveis.size() ; i++) {
				for (int y = 0 ; y < autoresAssociados.size() ; y++) {
					if(autoresAssociados.get(y).getId() == autoresDisponiveis.get(i).getId()){
						autoresDisponiveis.remove(i);
						i=-1;
						break;
					}
				}
			}
	        
	        this.autores = new DualListModel<Autor>(autoresDisponiveis, autoresAssociados); 
		} catch (Exception e) {
			mensagemErroFatal(e, "Erro inesperado", "Erro ao editar livro");
		}
	}
	
	public void excluir(Livro livro){
		try {
			this.livroBO.deletar(livro);
			
			this.livro = new Livro();
			this.livros = null;
			this.autores = null;
			mensagemInformacao("Livro", "Livro excluido com sucesso.");
		} catch (Exception e) {
			mensagemErroFatal(e, "Erro inesperado", "Erro ao excluir livros");
		}
	}

	public void autoresTransferidos(TransferEvent event) {
		StringBuilder nomesAutores = new StringBuilder();
		for (Object item : event.getItems()) {
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
	
	public List<Livro> getLivros() {
		if(this.livros == null){
			this.livros = this.livroBO.buscarTodos();
		}
		return livros;
	}

	public DualListModel<Autor> getAutores() {
		if(autores == null){
			List<Autor> autoresDisponiveis = this.autorBO.buscarTodos(); 
	        List<Autor> autoresAssociados = new ArrayList<Autor>(); 
	        this.autores = new DualListModel<Autor>(autoresDisponiveis, autoresAssociados);
		}
		return autores;
	}

	public void setAutores(DualListModel<Autor> autores) {
		this.autores = autores;
	}
}
