package br.com.sramos.crudjsf.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


public abstract class AbstractController {
	
	protected void mensagemInformacao(String titulo, String descricao){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, descricao));
	}
	
	protected void mensagemAlerta(String titulo, String descricao){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, titulo, descricao));
	}
	
	protected void mensagemErro(String titulo, String descricao){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo, descricao));
	}
	
	protected void mensagemErroFatal(Exception e,  String titulo, String descricao){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, titulo, descricao));
	}
}
