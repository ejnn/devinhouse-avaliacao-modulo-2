package br.com.devinhouse.processosBackend.model;

import java.time.LocalDate;

public class Processo {

    private static int idDisponivel;

    private final int id;
    private final LocalDate entrada;
    private final String codigo;

    private String assunto;
    private String descricao;
    private String[] interessados;

    public Processo() {
	id = idDisponivel++;
	entrada = LocalDate.now();
	codigo = "SOFT " + entrada.getYear() + "/" + id;
    }

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
