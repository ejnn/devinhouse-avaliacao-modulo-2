package br.com.devinhouse.processosBackend.model;

import java.time.LocalDate;

public class Processo {

    private int id;
    private LocalDate entrada;
    private String codigo;
    private String assunto = "";
    private String descricao = "";
    private String[] interessados = {};

    public int getId() {
	return id;
    }

    public LocalDate getEntrada() {
	return entrada;
    }

    public String getCodigo() {
	return codigo;
    }

    public String getAssunto() {
	return assunto;
    }

    public String getDescricao() {
	return descricao;
    }

    public String[] getInteressados() {
	return interessados;
    }

    public void setId(int id) {
	this.id = id;
    }

    public void setEntrada(LocalDate entrada) {
	this.entrada = entrada;
    }

    public void setCodigo(String codigo) {
	this.codigo = codigo;
    }

    public void setAssunto(String assunto) {
	this.assunto = assunto;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    public void setInteressados(String... interessados) {
	this.interessados = interessados;
    }

}
