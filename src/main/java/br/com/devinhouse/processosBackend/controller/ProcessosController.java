package br.com.devinhouse.processosBackend.controller;

import java.time.LocalDate;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.devinhouse.processosBackend.model.Processo;

@RestController
public class ProcessosController {

    private int idDisponivel;
    private final Map<Integer, Processo> processos = new HashMap<>();

    @PostMapping(path="v1/processo", consumes="application/json")
    public Processo postProcesso(@RequestBody Processo processo) {
	processo.setId(idDisponivel++);
	processo.setEntrada(LocalDate.now());
	processo.setCodigo("SOFT " + processo.getEntrada().getYear() + "/" + processo.getId());

	processos.put(processo.getId(), processo);
	return processo;
    }

    @GetMapping("v1/processos")
    public Collection<Processo> getProcessos() {
	return processos.values();
    }

    @GetMapping("v1/processo")
    public Processo getProcesso(@RequestParam String codigo) {

	Processo ret = null;
	try {
	    ret = processos.values().stream()
	          .filter(p -> p.getCodigo().equals(codigo)).findFirst().get();
	}
	catch (NoSuchElementException e) {
	    // no problem, just return nothing
	}

	return ret;
    }

    @GetMapping("v1/processo/{id}")
    public Processo getProcesso(@PathVariable Integer id) {
	return processos.get(id);
    }

    @PutMapping(path="v1/processo/{id}", consumes="application/json")
    public Processo putProcesso(@PathVariable Integer id, @RequestBody Processo processo) {

	Processo original = processos.get(id);
	if (original == null) {
	    return postProcesso(processo);
	}

	processo.setId(original.getId());
	processo.setEntrada(original.getEntrada());
	processo.setCodigo(original.getCodigo());

	processos.put(id, processo);
	return processo;
    }

    @DeleteMapping("v1/processo/{id}")
    public Processo deleteProcesso(@PathVariable Integer id) {
	return processos.remove(id);
    }


}
