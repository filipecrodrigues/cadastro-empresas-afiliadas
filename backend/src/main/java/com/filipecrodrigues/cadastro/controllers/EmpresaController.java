package com.filipecrodrigues.cadastro.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filipecrodrigues.cadastro.entities.Empresa;
import com.filipecrodrigues.cadastro.services.EmpresaService;

import jakarta.validation.Valid;

// Controller REST
@RestController

// Endpoint base da API
@RequestMapping("/api/empresas")
public class EmpresaController {

    // Service com regras de negócio
    private final EmpresaService empresaService;

    // Injeção via construtor (melhor prática)
    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    // ===============================
    // CREATE
    // ===============================
@PostMapping
public ResponseEntity<Empresa> cadastrar(@RequestBody @Valid Empresa empresa) {
    Empresa empresaSalva = empresaService.cadastrar(empresa);
    URI uri = URI.create("/api/empresas/" + empresaSalva.getId());
    return ResponseEntity.created(uri).body(empresaSalva);
}


    // ===============================
    // READ - Listar todas
    // ===============================
    @GetMapping
    public ResponseEntity<List<Empresa>> listarTodas() {

        return ResponseEntity.ok(empresaService.listarTodas());
    }

    // ===============================
    // READ - Buscar por ID
    // ===============================
    @GetMapping("/{id}")
    public ResponseEntity<Empresa> buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(empresaService.buscarPorId(id));
    }

    // ===============================
    // UPDATE
    // ===============================
    @PutMapping("/{id}")
    public ResponseEntity<Empresa> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid Empresa empresa) {

        return ResponseEntity.ok(empresaService.atualizar(id, empresa));
    }

    // ===============================
    // DELETE
    // ===============================
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        empresaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
