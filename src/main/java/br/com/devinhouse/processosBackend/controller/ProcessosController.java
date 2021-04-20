package br.com.devinhouse.processosBackend.controller;

import java.util.Map;
import java.util.HashMap;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.devinhouse.processosBackend.model.Processo;

@RestController
public class ProcessosController {

    private final Map<Integer, Processo> processos = new HashMap<>();

    @PostMapping(path="/v1/processo", consumes="application/json")
    public Processo postProcesso(@RequestBody Processo processo) {
	processos.put(processo.getId(), processo);
	return processo;
    }

    @GetMapping("v1/processos")
    public Processo[] getProcessos() {
	return processos.values().toArray(Processo[]::new);
    }

    @GetMapping("v1/processo/{id}")
    public Processo getProcessoPorId(@PathVariable Integer id) {
	return processos.get(id);
    }

}
