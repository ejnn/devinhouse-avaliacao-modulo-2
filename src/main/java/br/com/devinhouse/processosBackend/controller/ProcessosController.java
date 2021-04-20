package br.com.devinhouse.processosBackend.controller;

import java.util.Map;
import java.util.HashMap;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.devinhouse.processosBackend.model.Processo;

@RestController
public class ProcessosController {

    private int numeroDisponivel;
    private final Map<Integer, Processo> processos = new HashMap<>();

    @PostMapping(path="v1/processo", consumes="application/json")
    public Processo postProcesso(@RequestBody Processo processo) {
	processo.setId(processo.hashCode());
	processo.setEntrada(LocalDate.now());
	processo.setNumero(numeroDisponivel++);
	processo.setCodigo("SOFT " + processo.getEntrada().getYear() + "/" + processo.getNumero());

	processos.put(processo.getId(), processo);
	return processo;
    }

    @GetMapping("v1/processos")
    public Processo[] getProcessos() {
	return processos.values().toArray(Processo[]::new);
    }

    @GetMapping("v1/processo/{identifier}")
    public Processo getProcesso(@PathVariable Integer identifier) {
	Processo ret = processos.get(identifier);

	// identifier may be either id or numero
	if (ret == null) {
	    try {
		ret = processos.values().stream()
		    .filter(p -> identifier.equals(p.getNumero())).findFirst().get();
	    }
	    catch (NoSuchElementException e) {
	    }
	}

	return ret;
    }

    @PutMapping(path="v1/processo/{id}", consumes="application/json")
    public Processo putProcesso(@PathVariable Integer id, @RequestBody Processo processo) {

	Processo original = processos.get(id);
	if (original == null) {
	    postProcesso(processo);
	    return processo;
	}

	processo.setId(original.getId());
	processo.setEntrada(original.getEntrada());
	processo.setNumero(original.getNumero());
	processo.setCodigo(original.getCodigo());

	processos.put(id, processo);
	return processo;
    }

    @DeleteMapping("v1/processo/{id}")
    public Processo deleteProcesso(@PathVariable Integer id) {
	return processos.remove(id);
    }


}
