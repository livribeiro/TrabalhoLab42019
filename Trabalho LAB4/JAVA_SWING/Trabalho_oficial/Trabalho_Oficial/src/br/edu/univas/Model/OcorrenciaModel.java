package br.edu.univas.Model;


import java.sql.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class OcorrenciaModel {
	private String titulo;
	private String observação;
	private int idMensagem;
	private String problemas;
	private String comboSetor;
	private int idDepartamento;
	private String protocolo;
	private String status;
	private String cnpj;
	private int idCnpj;
	private String produto;
	private int idProduto;
	private String nomeCliente;
	private String data;
	
	public int getIdMensagem() {
		return idMensagem;
	}
	public void setIdMensagem(int idMensagem) {
		this.idMensagem = idMensagem;
	}
	public int getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	public int getIdCnpj() {
		return idCnpj;
	}
	public void setIdCnpj(int idCnpj) {
		this.idCnpj = idCnpj;
	}
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public String getData() {
		return data;
	}
	public void setData(String string) {
		this.data = string;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getProduto() {
		return produto;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProtocolo() {
		return protocolo;
	}
	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}
	public String getComboSetor() {
		return comboSetor;
	}
	public void setComboSetor(String comboSetor) {
		this.comboSetor = comboSetor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getObservação() {
		return observação;
	}
	public void setObservação(String observação) {
		this.observação = observação;
	}
	public String getProblemas() {
		return problemas;
	}
	public void setProblemas(String problemas) {
		this.problemas = problemas;
	}
}
