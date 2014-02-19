package br.com.sramos.crudjsf.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "livro", uniqueConstraints = {
		@UniqueConstraint(name = "UC_LIVRO_ISBN", columnNames = "isbn"),
		@UniqueConstraint(name = "UC_LIVRO_NOME", columnNames = "nome") })
public class Livro implements Serializable {

	private static final long serialVersionUID = 5850995947244204020L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_livro")
	private Long id;

	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "nome")
	private String nome;

	@NotNull
	@Size(min = 1, max = 50)
	@Pattern(regexp = "[0-9]+", message = "ISBN não deve conter letras")
	@Column(name = "isbn")
	private String isbn;
	
	@NotNull
	@Column(name = "ativo")
	private Boolean ativo;
	
	@Null
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="livro_autor"
			, joinColumns=@JoinColumn(name="id_livro")
			, inverseJoinColumns=@JoinColumn(name="id_autor"))
	Collection<Autor> autores;

	public Livro() {
		this.ativo = true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
