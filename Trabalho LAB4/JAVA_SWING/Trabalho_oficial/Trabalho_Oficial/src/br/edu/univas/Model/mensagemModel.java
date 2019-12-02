package br.edu.univas.Model;


public class mensagemModel {
	String idMensagem;
	String mensagem;
	String titulo;
	String data;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

	public String getIdMensagem() {
		return idMensagem;
	}
	public void setIdMensagem(String idMensagem) {
		this.idMensagem = idMensagem;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensage) {
		this.mensagem = mensage;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
